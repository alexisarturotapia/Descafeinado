package com.alexistapia.restful.domain.port.in;

import com.alexistapia.restful.domain.model.Producto;

public interface ProductoWriteUseCase {
    Producto crearProducto(Producto producto);
    Producto actualizarProducto(int id, Producto detallesProducto);
    void eliminarProducto(int id);
}

