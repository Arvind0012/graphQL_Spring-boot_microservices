package com.catalog.client;

import com.catalog.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryClient {

    @Autowired
    private HttpGraphQlClient inventoryGaphQlClient;

    public List<Product> viewProducts(){
        String graphQLQuery = """
                query GetProducts {
                    getProducts {
                        name
                        category
                        price
                        stock
                    }
                }
                """;
        return inventoryGaphQlClient.document(graphQLQuery)
                .retrieve("getProducts")
                .toEntityList(Product.class).block();
    }

    public List<Product> viewProductByCategory(String category){
        String graphQLQuery = String.format("""
                query GetProductByCategory {
                    getProductByCategory(category: "%s") {
                        name
                        category
                        price
                        stock
                    }
                }
                """, category);
        return inventoryGaphQlClient.document(graphQLQuery)
                .retrieve("getProductByCategory")
                .toEntityList(Product.class).block();
    }


    public Product addProduct(Product product) {
        String graphQLQuery = String.format("""
                mutation PostProduct3 {
                    postProduct(
                        name: "%s"
                        category: "%s"
                        price: %f
                        stock: %d
                    ){
                        id
                        name
                        category
                        price
                        stock
                     }
                }""", product.getName(), product.getCategory(), product.getPrice(), product.getStock());

        return inventoryGaphQlClient.document(graphQLQuery).retrieve("postProduct").toEntity(Product.class).block();
    }
}
