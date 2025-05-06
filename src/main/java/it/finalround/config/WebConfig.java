package it.finalround.config;

import it.finalround.security.SubscriptionGuard;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final SubscriptionGuard guard;

    @Override
    public void addInterceptors(InterceptorRegistry reg) {
        reg.addInterceptor(guard);
    }
}
