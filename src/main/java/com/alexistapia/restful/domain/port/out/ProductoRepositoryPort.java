package com.alexistapia.restful.domain.port.out;

import com.alexistapia.restful.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    List<Producto> findAll();
    Optional<Producto> findById(int id);
    Producto save(Producto producto);
    void deleteById(int id);
}

