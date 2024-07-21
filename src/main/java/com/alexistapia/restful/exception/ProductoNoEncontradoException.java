package com.alexistapia.restful.exception;

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(int id) {
        super("Producto no encontrado con ID: " + id);
    }
}

