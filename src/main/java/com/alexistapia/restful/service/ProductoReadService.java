package com.alexistapia.restful.service;

import com.alexistapia.restful.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoReadService {
    List<Producto> obtenerTodosLosProductos();
    Optional<Producto> obtenerProductoPorId(int id);
}

