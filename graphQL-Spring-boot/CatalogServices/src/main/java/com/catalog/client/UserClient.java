package com.catalog.client;

import com.catalog.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserClient {

    @Autowired
    private HttpGraphQlClient userGraphQlClient;

    public List<User> viewUsers(){
        String graphQLQuery = """
                query GetAllUser {
                    GetAllUser {
                        name
                        email
                        password
                    }
                }""";

        return userGraphQlClient.document(graphQLQuery)
                .retrieve("GetAllUser")
                .toEntityList(User.class).block();
    }

    public User addUser(User user) {
        String graphQLQuery = String.format("""
                mutation Create {
                    Create(
                        user: { name: "%s", email: "%s", password: "%s" }
                    ) {
                        name
                        email
                        password
                    }
                }""", user.getName(), user.getEmail(), user.getPassword());

        return userGraphQlClient.document(graphQLQuery).retrieve("Create").toEntity(User.class).block();
    }
}
