package com.product_per_department.product_per_department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_per_department.product_per_department.model.Usuario;
import com.product_per_department.product_per_department.repository.RepositoryUsuario;

@Service
public class ServiceUsuario {
    @Autowired
    RepositoryUsuario repositoryUsuario;

    public List<Usuario> getAllUsuarios(){
        return this.repositoryUsuario.findAll();
    }

    public Usuario getUsuario(long id){
        return this.repositoryUsuario.findById(id);
    }

    public void addUsuario(Usuario usuario){
        this.repositoryUsuario.save(usuario);
    }

    public void putUsuario(Usuario usuario){
        this.repositoryUsuario.save(usuario);
    }

    public void deleteUsuario(long id){
        this.repositoryUsuario.deleteById(id);
    }
}
