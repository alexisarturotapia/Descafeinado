package com.alexistapia.restful.service;

import com.alexistapia.restful.model.Producto;

public interface ProductoWriteService {
    Producto crearProducto(Producto producto);
    Producto actualizarProducto(int id, Producto detallesProducto);
    void eliminarProducto(int id);
}

