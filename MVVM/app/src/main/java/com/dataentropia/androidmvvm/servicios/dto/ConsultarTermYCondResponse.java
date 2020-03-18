package com.dataentropia.androidmvvm.servicios.dto;

import com.dataentropia.androidmvvm.servicios.entity.ETerminoYCondicion;

import java.util.List;


public class ConsultarTermYCondResponse {
    public List<ETerminoYCondicion> terminosYCondiciones;

    public List<ETerminoYCondicion> getTerminosYCondiciones() {
        return terminosYCondiciones;
    }

    public void setTerminosYCondiciones(List<ETerminoYCondicion> terminosYCondiciones) {
        this.terminosYCondiciones = terminosYCondiciones;
    }

}
