package com.product_per_department.product_per_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product_per_department.product_per_department.model.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {
    public Usuario findById(long id_categoria);
}
