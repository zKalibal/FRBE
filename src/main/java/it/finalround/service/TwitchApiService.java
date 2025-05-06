package it.finalround.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  – In profilo DEV restituisce sempre true (mock) –
 *  – In profilo PROD chiama le API Twitch Helix                        –
 */
@Service
@RequiredArgsConstructor
public class TwitchApiService {

    @Value("${twitch.client-id:mock}")
    private String clientId;
    @Value("${twitch.client-secret:mock}")
    private String clientSecret;

    /** cache semplice accessToken + expiry */
    private String accessToken;
    private long   tokenExpiresAt = 0;

    /** cache sottoscrizioni (5 minuti) */
    private final Map<String, Boolean> subCache = new ConcurrentHashMap<>();

    private final RestTemplate rest = new RestTemplate();

    public boolean isSubscribed(Long userId, Long broadcasterId) {

        /* ---- PROFILO DEV: mock ---- */
        if ("dev".equals(System.getProperty("spring.profiles.active", "dev")))
            return true;

        /* ---- cache 5 min ---- */
        String key = userId + ":" + broadcasterId;
        if (subCache.containsKey(key)) return subCache.get(key);

        /* ---- refresh token se necessario ---- */
        if (accessToken == null || System.currentTimeMillis() >= tokenExpiresAt) {
            refreshToken();
        }

        /* ---- chiama Helix ---- */
        String url = "https://api.twitch.tv/helix/subscriptions/user"
                + "?broadcaster_id=" + broadcasterId
                + "&user_id=" + userId;

        HttpHeaders h = new HttpHeaders();
        h.setBearerAuth(accessToken);
        h.set("Client-Id", clientId);

        ResponseEntity<String> rsp = rest.exchange(
                url, HttpMethod.GET, new HttpEntity<>(h), String.class);

        boolean ok = rsp.getStatusCode().is2xxSuccessful()
                && rsp.getBody() != null && rsp.getBody().contains("\"tier\"");

        subCache.put(key, ok);
        /* scadenza: 5 min */
        new java.util.Timer().schedule(
                new java.util.TimerTask() { public void run(){ subCache.remove(key); } },
                5 * 60 * 1000);

        return ok;
    }

    /* === token app access === */
    private void refreshToken() {
        String url = "https://id.twitch.tv/oauth2/token"
                + "?grant_type=client_credentials"
                + "&client_id="     + clientId
                + "&client_secret=" + clientSecret;

        @SuppressWarnings("unchecked")
        Map<String,Object> map = rest.postForObject(url, null, Map.class);
        accessToken     = (String) map.get("access_token");
        Integer expires = (Integer) map.get("expires_in");
        tokenExpiresAt  = System.currentTimeMillis() + expires * 1000L;
    }
}
