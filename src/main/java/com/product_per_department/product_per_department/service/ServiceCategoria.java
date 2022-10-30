package com.product_per_department.product_per_department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_per_department.product_per_department.model.Categoria;
import com.product_per_department.product_per_department.repository.RepositoryCategoria;

@Service
public class ServiceCategoria {
    @Autowired
    RepositoryCategoria repositoryCategoria;

    public List<Categoria> getAllCategorias(){
        return this.repositoryCategoria.findAll();
    }

    public Categoria getCategoria(long id){
        return this.repositoryCategoria.findById(id);
    }

    public void addCategoria(Categoria categoria){
        this.repositoryCategoria.save(categoria);
    }

    public void putCategoria(Categoria categoria){
        this.repositoryCategoria.save(categoria);
    }

    public void deleteCategoria(long id){
        this.repositoryCategoria.deleteById(id);
    }

}
