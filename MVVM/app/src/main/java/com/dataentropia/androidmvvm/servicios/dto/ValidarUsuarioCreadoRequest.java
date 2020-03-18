package com.dataentropia.androidmvvm.servicios.dto;


import com.dataentropia.androidmvvm.servicios.entity.EDocumentoIdentificacion;

public class ValidarUsuarioCreadoRequest {


    private EDocumentoIdentificacion documentoIdentificacion;

    public EDocumentoIdentificacion getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(EDocumentoIdentificacion documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public ValidarUsuarioCreadoRequest(EDocumentoIdentificacion documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }
}
