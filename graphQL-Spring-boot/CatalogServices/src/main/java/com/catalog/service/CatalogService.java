package com.catalog.service;

import com.catalog.client.InventoryClient;
import com.catalog.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private InventoryClient inventoryClient;

    public List<Product> viewProducts(){
        return inventoryClient.viewProducts();
    }

    public List<Product> viewProductByCategory(String category){
        return inventoryClient.viewProductByCategory(category);
    }

    public Product addProduct(Product product) {
        return inventoryClient.addProduct(product);
    }
}
