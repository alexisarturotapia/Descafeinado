package com.alexistapia.restful.domain.port.in;

import com.alexistapia.restful.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoReadUseCase {
    List<Producto> obtenerTodosLosProductos();
    Optional<Producto> obtenerProductoPorId(int id);
}

