package com.isep.acme.controllers;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(final String string) {
        super(string);
    }

    public ResourceNotFoundException(final Class<?> clazz, final long id) {
        super(String.format("Entity %s with id %d not found", clazz.getSimpleName(), id));
    }
}
