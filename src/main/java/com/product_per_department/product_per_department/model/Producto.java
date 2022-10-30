package com.product_per_department.product_per_department.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "tbl_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_producto;
    private int cantidad;
    private double precio;
    
    private String nombre_producto;
    private String descripcion_producto;
    private String img_dir;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonBackReference
    private Categoria categoria;

    public Producto(){}

    public Producto(int cantidad, double precio, String nombreProducto, String descripcionProducto, String imgDir, Categoria categoria) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre_producto = nombreProducto;
        this.descripcion_producto = descripcionProducto;
        this.img_dir = imgDir;
        this.categoria = categoria;
    }
    public long getIdProducto() {
        return id_producto;
    }
    public void setIdProducto(long idProducto) {
        this.id_producto = idProducto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getNombreProducto() {
        return nombre_producto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombre_producto = nombreProducto;
    }
    public String getDescripcionProducto() {
        return descripcion_producto;
    }
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcion_producto = descripcionProducto;
    }
    public String getImgDir() {
        return img_dir;
    }
    public void setImgDir(String imgDir) {
        this.img_dir = imgDir;
    }
}
