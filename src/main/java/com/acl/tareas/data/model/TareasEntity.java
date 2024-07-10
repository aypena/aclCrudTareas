package com.acl.tareas.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


import java.util.Date;


@Entity
@Table
public class TareasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;

    @Size(min=2, message = "La descripcion deberia tener Min 2 Caracteres")
    @Column(nullable = false)
    private String descripcion;

    @Past(message = "La fecha deberia estar en pasado")
    @Column(nullable = true)
    private Date fechaCreacion;

    @Column(nullable = false)
    private boolean vigente;

    public TareasEntity(Integer identificador, String descripcion, Date fechaCreacion, boolean vigente) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.vigente = vigente;
    }

    public TareasEntity(String descripcion, Date fechaCreacion, boolean vigente) {
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.vigente = vigente;
    }

    public TareasEntity() {
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    @Override
    public String toString() {
        return "TareasEntity{" +
                "identificador=" + identificador +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", vigente=" + vigente +
                '}';
    }
}
