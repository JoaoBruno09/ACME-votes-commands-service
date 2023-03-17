package com.isep.acme.repositories;

import org.springframework.data.repository.CrudRepository;

import com.isep.acme.model.ProdImage;

public interface ImageRepository extends CrudRepository<ProdImage, Long> {
}
