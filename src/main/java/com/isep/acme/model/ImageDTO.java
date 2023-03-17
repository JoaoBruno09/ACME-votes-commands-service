package com.isep.acme.model;

import com.isep.acme.services.ImageService;

public class ImageDTO {


    private ImageService service;
    private Long id;

    private Long productID;

    public ImageDTO(Long id, Long productID){

        this.id = id;
        this.productID = productID;

    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Iterable<ImageDTO> getImageProduct(){return service.getImageProduct();}
}
