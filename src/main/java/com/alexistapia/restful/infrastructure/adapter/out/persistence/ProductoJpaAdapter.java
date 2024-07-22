package com.alexistapia.restful.infrastructure.adapter.out.persistence;

import com.alexistapia.restful.domain.model.Producto;
import com.alexistapia.restful.domain.port.out.ProductoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoJpaAdapter implements ProductoRepositoryPort {

    private final JpaProductoRepository jpaProductoRepository;

    public ProductoJpaAdapter(JpaProductoRepository jpaProductoRepository) {
        this.jpaProductoRepository = jpaProductoRepository;
    }

    @Override
    public List<Producto> findAll() {
        return jpaProductoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(int id) {
        return jpaProductoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return jpaProductoRepository.save(producto);
    }

    @Override
    public void deleteById(int id) {
        jpaProductoRepository.deleteById(id);
    }
}

