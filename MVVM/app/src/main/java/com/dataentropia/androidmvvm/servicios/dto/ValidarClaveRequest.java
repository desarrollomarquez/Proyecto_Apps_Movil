package com.dataentropia.androidmvvm.servicios.dto;


public class ValidarClaveRequest {

    public String numeroDocumento;
    public String clave;

    public ValidarClaveRequest(String numeroDocumento, String clave) {
        this.numeroDocumento = numeroDocumento;
        this.clave = clave;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
