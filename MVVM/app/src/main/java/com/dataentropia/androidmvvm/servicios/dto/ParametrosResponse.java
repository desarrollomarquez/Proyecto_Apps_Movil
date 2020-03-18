package com.dataentropia.androidmvvm.servicios.dto;


import com.dataentropia.androidmvvm.servicios.entity.EParametro;

import java.util.List;

public class ParametrosResponse {


    private List<EParametro> parametros;

    public List<EParametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<EParametro> parametros) {
        this.parametros = parametros;
    }


}