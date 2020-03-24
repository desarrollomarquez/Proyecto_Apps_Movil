package com.dataentropia.room_viewmodel.data.remote.repository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;

import com.dataentropia.room_viewmodel.data.local.AppDatabase;
import com.dataentropia.room_viewmodel.data.local.dao.ParametroDAO;
import com.dataentropia.room_viewmodel.data.local.entity.Parametro;


import java.util.List;

public class ParametroRepository {

    private ParametroDAO parametroDAO;

    public ParametroRepository(Context context) {
        parametroDAO = AppDatabase.getAppDatabase(context).ParametroDatabase();
    }

    public void addParametro(Parametro p) {
           long rec =  parametroDAO.insertParametro(p);
        Log.d("db insert ","added "+rec);
    }

    public void updateParametro(Parametro p) {
        parametroDAO.updateParametro(p);
    }

    public void deleteParametro(Parametro p) {
        parametroDAO.deleteParametro(p);
    }

    public LiveData<List<Parametro>> getAllParametros() {
        return parametroDAO.getAllParametros();
    }

    public LiveData<Parametro> getParametroByCodigo(String codigo) {
        return parametroDAO.getParametroByCodigo(codigo);
    }


}
