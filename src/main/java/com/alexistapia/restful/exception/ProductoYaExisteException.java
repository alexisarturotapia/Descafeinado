package com.alexistapia.restful.exception;

/*
 * Aplicando el principio de Responsabilidad Unica (SRP),
 * esta clase solo tiene una responsabilidad: representar una excepción específica.
 */

public class ProductoYaExisteException extends RuntimeException {
    public ProductoYaExisteException(int id) {
        super("El producto con ID: " + id + " ya existe.");
    }
}
