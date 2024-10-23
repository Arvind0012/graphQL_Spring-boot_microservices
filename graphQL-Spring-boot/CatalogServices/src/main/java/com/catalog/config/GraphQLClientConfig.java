package com.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class GraphQLClientConfig {

    @Bean
    public HttpGraphQlClient inventoryGaphQlClient(){
        WebClient inventoryClient = WebClient.builder()
                .baseUrl("http://localhost:8082/graphql")
                .build();
        return HttpGraphQlClient.builder(inventoryClient).build();
    }

    // use in UserClient with same name as userGraphQlClient
    @Bean
    public HttpGraphQlClient userGraphQlClient(){
        WebClient userClient = WebClient.builder()
                .baseUrl("http://localhost:8083/graphql")
                .build();
        return HttpGraphQlClient.builder(userClient).build();
    }

}
