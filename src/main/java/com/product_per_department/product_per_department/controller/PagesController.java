package com.product_per_department.product_per_department.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    @GetMapping({"/login"})
    public String login(){
        return "login";
    }

    @GetMapping({"/registro"})
    public String registro(){
        return "registro";
    }

    @GetMapping({"/categorias"})
    public String categorias(){
        return "categorias";
    }

    @GetMapping({"/","/productos"})
    public String productos(){
        return "productos";
    }
}
