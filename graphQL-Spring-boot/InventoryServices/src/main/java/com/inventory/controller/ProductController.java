package com.inventory.controller;

import com.inventory.models.Product;
import com.inventory.models.ProductInput;
import com.inventory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//@RestController
//@RequestMapping("/api/product")
@Controller
public class ProductController {

    @Autowired
    private ProductService service;

//    @GetMapping
    @QueryMapping
    public List<Product> getProducts(){
        return service.getProducts();
    }
//    @GetMapping("/{category}")
    @QueryMapping
    public List<Product> getProductByCategory(@Argument String category){
        return service.getProductByCategory(category);
    }

    @MutationMapping
    public Product updateProduct(@Argument int id, @Argument int stock){
        return service.updateStock(id, stock);
    }
    @MutationMapping
    public Product recieveNewShipment(@Argument int id, @Argument int quantity){
        return service.recieveNewShipment(id, quantity);
    }

    @MutationMapping("postProduct")
//    public Product postProduct(@Argument ProductInput productInput){
    public Product postProduct(@Argument String name, @Argument String category, @Argument Double price, @Argument Integer stock){
        Product p = new Product();
//        System.out.println("product:-"+productInput.toString());
        p.setName(name);
        p.setCategory(category);
        p.setPrice(price);
        p.setStock(stock);
        return service.addProduct(p);
    }
}
