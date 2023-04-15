package com.isep.acme.rabbit.listeners.impl;

import com.isep.acme.constants.Constants;
import com.isep.acme.model.Product;
import com.isep.acme.rabbit.listeners.ProductListener;
import com.isep.acme.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class ProductListenerImpl implements ProductListener {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public void listenedProduct(Product product, String action) {
        if(product != null){
            final Optional<Product> productToAction = productRepository.findBySku(product.getSku());
            switch(action) {
                case Constants.CREATED_PRODUCT_HEADER:
                    if(productToAction.isEmpty()){
                        productRepository.save(product);
                        System.out.println("Product Added " + product);
                    }
                    break;
                case Constants.UPDATED_PRODUCT_HEADER:
                    if(!productToAction.isEmpty()){
                        productToAction.get().updateProduct(product);
                        productRepository.save(productToAction.get());
                        System.out.println("Product Updated " + productToAction.get());
                    }
                    break;
                case Constants.DELETED_PRODUCT_HEADER:
                    if(!productToAction.isEmpty()){
                        productRepository.deleteBySku(product.getSku());
                        System.out.println("Product Deleted " + productToAction.get());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}