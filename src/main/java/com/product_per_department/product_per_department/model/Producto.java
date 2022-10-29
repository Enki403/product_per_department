package com.product_per_department.product_per_department.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "tbl_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private int cantidad;
    private int precio;
    
    private String nombreProducto;
    private String descripcionProducto;
    private String imgDir;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    @JsonBackReference
    private Categoria categoria;

    public Producto(){}

    public Producto(int cantidad, int precio, String nombreProducto, String descripcionProducto, String imgDir) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.imgDir = imgDir;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getDescripcionProducto() {
        return descripcionProducto;
    }
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    public String getImgDir() {
        return imgDir;
    }
    public void setImgDir(String imgDir) {
        this.imgDir = imgDir;
    }
}
