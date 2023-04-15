package com.isep.acme.rabbit.listeners;

import com.isep.acme.model.Product;

public interface ProductListener {

    void listenedProduct(Product product, String action);
}
