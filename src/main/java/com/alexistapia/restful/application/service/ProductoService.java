package com.alexistapia.restful.application.service;

import com.alexistapia.restful.domain.model.Producto;
import com.alexistapia.restful.domain.port.in.ProductoReadUseCase;
import com.alexistapia.restful.domain.port.in.ProductoWriteUseCase;
import com.alexistapia.restful.domain.port.out.ProductoRepositoryPort;
import com.alexistapia.restful.exception.ProductoNoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements ProductoReadUseCase, ProductoWriteUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public ProductoService(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepositoryPort.findAll();
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(int id) {
        return productoRepositoryPort.findById(id);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepositoryPort.save(producto);
    }

    @Override
    public Producto actualizarProducto(int id, Producto detallesProducto) {
        Producto productoExistente = productoRepositoryPort.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        productoExistente.setNombre(detallesProducto.getNombre());
        productoExistente.setPrecio(detallesProducto.getPrecio());
        return productoRepositoryPort.save(productoExistente);
    }

    @Override
    public void eliminarProducto(int id) {
        Producto producto = productoRepositoryPort.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        productoRepositoryPort.deleteById(id);
    }
}
