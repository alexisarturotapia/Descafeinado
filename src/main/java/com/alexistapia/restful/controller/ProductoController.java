package com.alexistapia.restful.controller;

import com.alexistapia.restful.exception.ProductoNoEncontradoException;
import com.alexistapia.restful.model.Producto;
import com.alexistapia.restful.service.ProductoReadService;
import com.alexistapia.restful.service.ProductoWriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Aplicando el principio de Inversion de Dependencias (DIP) y la separación de responsabilidades (SRP),
 * el controlador depende de la abstraccion del servicio, no de los detalles de implementacion.
 */

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoReadService productoReadService;
    private final ProductoWriteService productoWriteService;

    public ProductoController(ProductoReadService productoReadService, ProductoWriteService productoWriteService) {
        this.productoReadService = productoReadService;
        this.productoWriteService = productoWriteService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = productoReadService.obtenerTodosLosProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = productoReadService.obtenerProductoPorId(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoWriteService.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto detallesProducto) {
        Producto productoActualizado = productoWriteService.actualizarProducto(id, detallesProducto);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        productoWriteService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
