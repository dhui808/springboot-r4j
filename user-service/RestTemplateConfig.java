package com.example.us;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Value("${user-service.connect-timeout}")
    private int CONNECT_TIMEOUT;
	
	@Value("${user-service.read-timeout}")
    private int READ_TIMEOUT;
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(getRequestFactory());
    }

    private ClientHttpRequestFactory getRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory();

        factory.setReadTimeout(READ_TIMEOUT);
        factory.setConnectTimeout(CONNECT_TIMEOUT);

        return factory;
    }
}
