package com.product_per_department.product_per_department.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private Categoria categoria;

    public Producto(){}

    public Producto(long id_producto, int cantidad, double precio, String nombre_producto, String descripcion_producto,
            String img_dir, Categoria categoria) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.img_dir = img_dir;
        this.categoria = categoria;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
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

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getImg_dir() {
        return img_dir;
    }

    public void setImg_dir(String img_dir) {
        this.img_dir = img_dir;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}
