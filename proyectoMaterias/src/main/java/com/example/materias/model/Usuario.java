package com.example.materias.model;

public class Usuario {
    private int id;
    private String nombre;
    private String estatus;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String estatus) {
        this.id = id;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
