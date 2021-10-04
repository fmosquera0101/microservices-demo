package com.store.productservice.controller;

import com.store.productservice.entities.ProductEntity;
import com.store.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Environment environment;

    @GetMapping
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping
    public String saveProduct(@RequestBody ProductEntity productEntity){
        if(productEntity.getName() != null && !"".equals(productEntity.getName())){

            productEntity.setProductId(UUID.randomUUID().toString());
            productRepository.save(productEntity);

            return "Product save successfully "+productEntity.getProductId() +", by: "+environment.getProperty("local.server.port");
        }else {
            return "Product name required, by: "+environment.getProperty("local.server.port");
        }

    }
}
