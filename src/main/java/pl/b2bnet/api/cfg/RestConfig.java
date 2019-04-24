package pl.b2bnet.api.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    @Bean
    RestTemplate create() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
