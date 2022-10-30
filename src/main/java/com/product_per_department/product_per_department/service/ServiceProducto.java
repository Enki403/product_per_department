package com.product_per_department.product_per_department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_per_department.product_per_department.model.Producto;
import com.product_per_department.product_per_department.repository.RepositoryProducto;

@Service
public class ServiceProducto {
    @Autowired
    RepositoryProducto repositoryProducto;

    public List<Producto> getAllProductos(){
        return this.repositoryProducto.findAll();
    }

    public Producto getProducto(long id){
        return this.repositoryProducto.findById(id);
    }

    public void addProducto(Producto producto){
        this.repositoryProducto.save(producto);
    }

    public void putProducto(Producto producto){
        this.repositoryProducto.save(producto);
    }

    public void deleteProducto(long id){
        this.repositoryProducto.deleteById(id);
    }
}
