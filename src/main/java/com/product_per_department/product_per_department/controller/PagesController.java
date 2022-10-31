package com.product_per_department.product_per_department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product_per_department.product_per_department.model.Categoria;
import com.product_per_department.product_per_department.model.Producto;
import com.product_per_department.product_per_department.service.ServiceCategoria;
import com.product_per_department.product_per_department.service.ServiceProducto;

@Controller
public class PagesController {
    @Autowired
    ServiceCategoria serviceCategoria;
    @Autowired
    ServiceProducto serviceProducto;

    @GetMapping({"/login"})
    public String login(){
        return "login";
    }

    @GetMapping({"/registro"})
    public String registro(){
        return "registro";
    }

    @GetMapping({"/categorias"})
    public String categorias(Model model){
        List<Categoria> categorias = this.serviceCategoria.getAllCategorias();
        model.addAttribute("categorias", categorias);
        return "categorias";
    }

    @GetMapping({"/","/productos"})
    public String productos(@RequestParam(name = "search", defaultValue="") String descripcion,Model model){
        List<Producto> productos = this.serviceProducto.getAllProductos();
        if(descripcion!=""){
            productos = this.serviceProducto.getProductoDescripcion(descripcion);
        }
        model.addAttribute("productos", productos);
        return "productos";
    }
}
