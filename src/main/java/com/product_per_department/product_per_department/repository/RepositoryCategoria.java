package com.product_per_department.product_per_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product_per_department.product_per_department.model.Categoria;

public interface RepositoryCategoria extends JpaRepository<Categoria, Long>{
    
    public Categoria findById(long id_categoria);
}
