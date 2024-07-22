package com.alexistapia.restful.repository;

import com.alexistapia.restful.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* Aplicando el principio de Inversion de Dependencias (DIP),
* dependemos de abstracciones (JpaRepository), no de implementaciones.
*/

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}

