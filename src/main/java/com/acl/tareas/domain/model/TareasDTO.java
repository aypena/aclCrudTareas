package com.acl.tareas.domain.model;

import java.io.Serializable;
import java.util.Date;



public class TareasDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer identificador;
    private String descripcion;
    private Date fechaCreacion;
    private boolean vigente;




    public TareasDTO() {
    }

    public Integer getIdentificador() {
        return this.identificador;
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

    public TareasDTO(Integer identificador, String descripcion, Date fechaCreacion, boolean vigente) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.vigente = vigente;
    }

    @Override
    public String toString() {
        return "TareasDTO{" +
                "identificador=" + identificador +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", vigente=" + vigente +
                '}';
    }
}
