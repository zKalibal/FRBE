package it.finalround.security;

import it.finalround.entity.Article;
import it.finalround.repository.ArticleRepository;
import it.finalround.service.TwitchApiService;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interceptor che blocca l’accesso a /api/v1/posts/{id}
 * se l’utente NON è abbonato a tutti i canali richiesti.
 */
@Component
@RequiredArgsConstructor
public class SubscriptionGuard implements HandlerInterceptor {

    private final ArticleRepository postRepo;
    private final TwitchApiService  twitch;

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,
                             Object handler) throws Exception {

        /* Interessa solo GET /posts/{id} */
        String uri = req.getRequestURI();
        if (!uri.matches(".*/posts/\\d+$")) return true;

        Long postId = Long.parseLong(uri.replaceAll(".*?/posts/(\\d+)$", "$1"));
        Article post = postRepo.findById(postId).orElse(null);
        if (post == null || post.getSubscriptions() == null) return true;

        /* Estrai id utente (mock) */
        String userHeader = req.getHeader("X-User-Id");
        if (userHeader == null) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Login richiesto");
            return false;
        }
        Long userId = Long.valueOf(userHeader);

        /* Verifica tutti i canali */
        List<Long> channels = Arrays.stream(post.getSubscriptions().split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());

        boolean ok = channels.stream()
                .allMatch(ch -> twitch.isSubscribed(userId, ch));

        if (!ok) {
            res.sendError(HttpServletResponse.SC_PAYMENT_REQUIRED,
                    "Abbonamento Twitch richiesto");
            return false;
        }
        return true;
    }
}
