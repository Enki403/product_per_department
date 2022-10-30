package com.product_per_department.product_per_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product_per_department.product_per_department.model.Producto;

public interface RepositoryProducto extends JpaRepository<Producto, Long> {
    public Producto findById(long id_categoria);
}
