package com.dataentropia.androidmvvm.servicios.dto;

import com.dataentropia.androidmvvm.servicios.entity.ECredencial;
import com.dataentropia.androidmvvm.servicios.entity.EDispositivoMovil;
import com.dataentropia.androidmvvm.servicios.entity.EDocumentoIdentificacion;
import com.dataentropia.androidmvvm.servicios.entity.ETerminoYCondicion;
import com.dataentropia.androidmvvm.servicios.entity.EUsuario;


import java.util.List;


public class RegistroUsuarioRequest {

    public EUsuario usuario;
    public EDocumentoIdentificacion documentoIdentificacion;
    public List<ETerminoYCondicion> terminosYCondiciones;
    public ECredencial credencial;
    public EDispositivoMovil dispositivoMovil;

    public void setTerminosYCondiciones(List<ETerminoYCondicion> terminosYCondiciones) {
        this.terminosYCondiciones = terminosYCondiciones;
    }
}
