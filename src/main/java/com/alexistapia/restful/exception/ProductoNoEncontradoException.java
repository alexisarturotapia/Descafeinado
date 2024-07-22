package com.alexistapia.restful.exception;

/*
* Aplicando el principio de Responsabilidad Unica (SRP),
* esta clase solo tiene una responsabilidad: representar una excepción específica.
*/

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(int id) {
        super("Producto no encontrado con ID: " + id);
    }
}

