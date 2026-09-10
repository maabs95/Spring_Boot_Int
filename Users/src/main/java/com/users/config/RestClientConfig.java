package com.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.boot.restclient.autoconfigure.RestClientSsl;

@Configuration
public class RestClientConfig {
    @Bean
    public RestClient mtlsRestClient(RestClient.Builder builder, RestClientSsl ssl) {
        return builder
                .baseUrl("https://localhost:8081")
                .apply(ssl.fromBundle("client-mtls-bundle"))
                .build();
    }
}
