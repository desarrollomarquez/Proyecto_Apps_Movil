package com.dataentropia.androidmvvm.servicios.dto;


import com.dataentropia.androidmvvm.servicios.entity.EDocumentoIdentificacion;
import com.dataentropia.androidmvvm.servicios.entity.EUsuario;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidarUsuarioCreadoResponse {

    @SerializedName("estadoConsultaUsuario")
    @Expose
    private String estadoConsultaUsuario;
    @SerializedName("mensajeValidacion")
    @Expose
    private String mensajeValidacion;
    @SerializedName("usuario")
    @Expose
    private EUsuario usuario;
    @SerializedName("documentoIdentificacion")
    @Expose
    private EDocumentoIdentificacion documentoIdentificacion;


    public String getEstadoConsultaUsuario() {
        return estadoConsultaUsuario;
    }

    public void setEstadoConsultaUsuario(String estadoConsultaUsuario) {
        this.estadoConsultaUsuario = estadoConsultaUsuario;
    }

    public String getMensajeValidacion() {
        return mensajeValidacion;
    }

    public void setMensajeValidacion(String mensajeValidacion) {
        this.mensajeValidacion = mensajeValidacion;
    }

    public EUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(EUsuario usuario) {
        this.usuario = usuario;
    }

    public EDocumentoIdentificacion getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(EDocumentoIdentificacion documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }
}
