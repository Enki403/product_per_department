package com.product_per_department.product_per_department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product_per_department.product_per_department.model.Categoria;
import com.product_per_department.product_per_department.model.Producto;
import com.product_per_department.product_per_department.model.Usuario;
import com.product_per_department.product_per_department.service.ServiceCategoria;
import com.product_per_department.product_per_department.service.ServiceProducto;
import com.product_per_department.product_per_department.service.ServiceUsuario;

@RestController
public class Controller {
    @Autowired
    ServiceCategoria serviceCategoria;
    @Autowired
    ServiceProducto serviceProducto;
    @Autowired
    ServiceUsuario serviceUsuario; 

    /* Categoria */
    
    @GetMapping("/categorias/getAllCategorias")
    public List<Categoria> getAllCategorias() {
        return this.serviceCategoria.getAllCategorias();
    }

    @GetMapping("/categorias/getCategoria/{id}")
    public Categoria getCategoria(@PathVariable("id") int idCategoria){
        return this.serviceCategoria.getCategoria(idCategoria);
    }

    @PostMapping("/categorias/addCategoria")
    public void addCategoria(@RequestBody Categoria categoria){
        this.serviceCategoria.addCategoria(categoria);
    } 

    @PutMapping("/categorias/update/{id}")
    public void updateCategoria(@PathVariable("id") int idCategoria, @RequestBody Categoria newCategoria){
        
        Categoria storedCategoria = serviceCategoria.getCategoria(idCategoria);
        storedCategoria.setNombreCategoria(newCategoria.getNombreCategoria());
        storedCategoria.setDescripcionCategoria(newCategoria.getDescripcionCategoria());
        this.serviceCategoria.putCategoria(storedCategoria);
    }
    
    @DeleteMapping("/categorias/delete/{id}")
    public void deleteCategoria(@PathVariable("id") int idCategoria){
        this.serviceCategoria.deleteCategoria(idCategoria);
    }

    /* Productos */
    
    @GetMapping("/productos/getAllProductos")
    public List<Producto> getAllProductos() {
        return this.serviceProducto.getAllProductos();
    }

    @GetMapping("/productos/getProducto/{id}")
    public Producto getProducto(@PathVariable("id") int idProducto){
        return this.serviceProducto.getProducto(idProducto);
    }

    @GetMapping("/productos/getProductoDescripcion")
    public List<Producto> getProductoDescripcion(@RequestParam("search") String descripcion){
        return this.serviceProducto.getProductoDescripcion(descripcion);
    }
    
    @PostMapping("/productos/addProducto")
    public void addProducto(@RequestBody Producto producto){
        this.serviceProducto.addProducto(producto);
    }
    
    @PutMapping("/productos/update/{id}")
    public void updateProducto(@PathVariable("id") int idProducto, @RequestBody Producto newProducto){
        
        Producto storedProducto = serviceProducto.getProducto(idProducto);
        storedProducto.setNombreProducto(newProducto.getNombreProducto());
        storedProducto.setDescripcionProducto(newProducto.getDescripcionProducto());
        this.serviceProducto.putProducto(storedProducto);
    }
    
    @DeleteMapping("productos/delete/{id}")
    public void deleteProducto(@PathVariable("id") int idProducto){
        this.serviceProducto.deleteProducto(idProducto);
    }

    /* Usuario */
    
    @GetMapping("/usuarios/getAllUsuarios")
    public List<Usuario> getAllCUsuarios() {
        return this.serviceUsuario.getAllUsuarios();
    }

}
