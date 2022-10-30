package com.product_per_department.product_per_department.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_categoria;
    private String nombre_categoria;
    private String descripcion_categoria;

    public Categoria(){}

    public Categoria(String nombreCategoria, String descripcionCategoria) {
        this.nombre_categoria = nombreCategoria;
        this.descripcion_categoria = descripcionCategoria;
    }
    
    public long getIdCategoria() {
        return id_categoria;
    }
    public void setIdCategoria(long idCategoria) {
        this.id_categoria = idCategoria;
    }
    public String getNombreCategoria() {
        return nombre_categoria;
    }
    public void setNombreCategoria(String nombreCategoria) {
        this.nombre_categoria = nombreCategoria;
    }
    public String getDescripcionCategoria() {
        return descripcion_categoria;
    }
    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcion_categoria = descripcionCategoria;
    }
}
