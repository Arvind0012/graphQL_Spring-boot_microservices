package com.inventory.services;

import com.inventory.models.Product;
import com.inventory.models.ProductInput;
import com.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product){
//        return repository.save(new Product(productInput.name(), productInput.category(), productInput.price(), productInput.stock()));
        return repository.save(product);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public List<Product> getProductByCategory(String category){
        return repository.findByCategory(category);
    }

    public Product updateStock(int id, int stock){
        Product existingProduct = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id "+id));
        existingProduct.setStock(stock);
        return repository.save(existingProduct);
    }

    public Product recieveNewShipment(int id, int quantity){
        Product existingProduct = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
        existingProduct.setStock(existingProduct.getStock()+quantity);
        return repository.save(existingProduct);
    }
}
