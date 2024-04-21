package com.sociedade.order.services;

import com.sociedade.order.domain.Product;
import com.sociedade.order.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(@Valid Product product) {


    }

}
