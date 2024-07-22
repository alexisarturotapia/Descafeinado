package com.alexistapia.restful.infrastructure.adapter.out.persistence;

import com.alexistapia.restful.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductoRepository extends JpaRepository<Producto, Integer> {
}
