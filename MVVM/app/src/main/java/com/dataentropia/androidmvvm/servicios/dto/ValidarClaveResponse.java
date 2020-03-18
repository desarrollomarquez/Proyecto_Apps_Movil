package com.dataentropia.androidmvvm.servicios.dto;


import com.dataentropia.androidmvvm.servicios.entity.EValidarClaveUsuario;

public class ValidarClaveResponse {

    public boolean valido;
    public String mensaje;
    public String descripcion;
    public EValidarClaveUsuario eValidaUsuario;

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EValidarClaveUsuario geteValidaUsuario() {
        return eValidaUsuario;
    }

    public void seteValidaUsuario(EValidarClaveUsuario eValidaUsuario) {
        this.eValidaUsuario = eValidaUsuario;
    }


}
