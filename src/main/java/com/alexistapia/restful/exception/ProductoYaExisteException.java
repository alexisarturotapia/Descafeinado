package com.alexistapia.restful.exception;

public class ProductoYaExisteException extends RuntimeException {
    public ProductoYaExisteException(int id) {
        super("El producto con ID: " + id + " ya existe.");
    }
}
