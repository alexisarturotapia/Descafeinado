package com.alexistapia.restful.infrastructure.adapter.in.web;

import com.alexistapia.restful.domain.model.Producto;
import com.alexistapia.restful.domain.port.in.ProductoReadUseCase;
import com.alexistapia.restful.domain.port.in.ProductoWriteUseCase;
import com.alexistapia.restful.exception.ProductoNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoReadUseCase productoReadUseCase;
    private final ProductoWriteUseCase productoWriteUseCase;

    public ProductoController(ProductoReadUseCase productoReadUseCase, ProductoWriteUseCase productoWriteUseCase) {
        this.productoReadUseCase = productoReadUseCase;
        this.productoWriteUseCase = productoWriteUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = productoReadUseCase.obtenerTodosLosProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = productoReadUseCase.obtenerProductoPorId(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoWriteUseCase.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto detallesProducto) {
        Producto productoActualizado = productoWriteUseCase.actualizarProducto(id, detallesProducto);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        productoWriteUseCase.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
