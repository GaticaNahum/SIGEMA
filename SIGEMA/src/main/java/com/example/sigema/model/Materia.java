package com.example.sigema.model;

public class Materia {

    private int id;

    private String nombre;

    private String descripcion;

    private boolean estado;

    private String fecha_inicio;

    private String fecha_fin;

    private int bloques;

    public Materia() {
    }

    public Materia(int id, String nombre, String descripcion, boolean estado, String fecha_inicio, String fecha_fin, int bloques) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.bloques = bloques;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getBloques() {
        return bloques;
    }

    public void setBloques(int bloques) {
        this.bloques = bloques;
    }


}
