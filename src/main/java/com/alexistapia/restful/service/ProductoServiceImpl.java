
package com.alexistapia.restful.service;

import com.alexistapia.restful.exception.ProductoNoEncontradoException;
import com.alexistapia.restful.model.Producto;
import com.alexistapia.restful.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * Aplicando el principio de Responsabilidad Unica (SRP),
 * la clase ProductoService solo maneja la logica de negocio relacionada con Producto.
 */

@Service
public class ProductoServiceImpl implements ProductoReadService, ProductoWriteService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(int id, Producto detallesProducto) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        productoExistente.setNombre(detallesProducto.getNombre());
        productoExistente.setPrecio(detallesProducto.getPrecio());
        return productoRepository.save(productoExistente);
    }

    @Override
    public void eliminarProducto(int id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        productoRepository.delete(producto);
    }
}
