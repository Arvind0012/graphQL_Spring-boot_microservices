package com.catalog.controller;

import com.catalog.dto.Product;
import com.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private CatalogService service;

    @GetMapping("/products")
    public List<Product> viewProducts(){
        return service.viewProducts();
    }

    @GetMapping("/products/category")
    public List<Product> viewProductByCategory(@RequestParam String category){
        return service.viewProductByCategory(category);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestParam String name, @RequestParam String category, @RequestParam Double price, @RequestParam int stock){

        Product p = new Product();
        p.setName(name);
        p.setCategory(category);
        p.setPrice(price);
        p.setStock(stock);

        return service.addProduct(p);
    }

}
