package com.dataentropia.androidmvvm.servicios.dto;


import com.dataentropia.androidmvvm.servicios.entity.EIdentificacionCivica;

public class RegistroUsuarioResponse {

    private boolean registroExitoso;
    private EIdentificacionCivica eIdentificacionCivica;

    public EIdentificacionCivica geteIdentificacionCivica() {
        return eIdentificacionCivica;
    }
    public void seteIdentificacionCivica(EIdentificacionCivica eIdentificacionCivica) {
        this.eIdentificacionCivica = eIdentificacionCivica;
    }
    public boolean isRegistroExitoso() {
        return registroExitoso;
    }
    public void setRegistroExitoso(boolean registroExitoso) {
        this.registroExitoso = registroExitoso;
    }
}
