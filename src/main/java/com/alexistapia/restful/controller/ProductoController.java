package com.alexistapia.restful.controller;

import com.alexistapia.restful.exception.ProductoNoEncontradoException;
import com.alexistapia.restful.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping("/productos")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        productos.add(producto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }
}
