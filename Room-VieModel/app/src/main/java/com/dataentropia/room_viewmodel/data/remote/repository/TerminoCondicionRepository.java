package com.dataentropia.room_viewmodel.data.remote.repository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;

import com.dataentropia.room_viewmodel.data.local.AppDatabase;
import com.dataentropia.room_viewmodel.data.local.dao.TerminoCondicionDAO;
import com.dataentropia.room_viewmodel.data.local.entity.TerminoCondicion;

import java.util.List;

public class TerminoCondicionRepository {

    private TerminoCondicionDAO terminoCondicionDAO;

    public TerminoCondicionRepository(Context context) {
        terminoCondicionDAO = AppDatabase.getAppDatabase(context).TerminoCondicionDatabase();
    }

    public void addTerminoCondicion(TerminoCondicion tc) {
           long rec =  terminoCondicionDAO.insertTerminoCondicion(tc);
        Log.d("db insert ","added "+rec);
    }

    public void updateTerminoCondicion(TerminoCondicion tc) {
        terminoCondicionDAO.updateTerminoCondicion(tc);
    }

    public void deleteTerminoCondicion(TerminoCondicion tc) {
        terminoCondicionDAO.deleteTerminoCondicion(tc);
    }

    public LiveData<List<TerminoCondicion>> getAllTerminoCondiciones() {
        return terminoCondicionDAO.getAllTerminoCondiciones();
    }

    public LiveData<TerminoCondicion> getTerminoCondicionByCodigo(String codigo) {
        return terminoCondicionDAO.getTerminoCondicionByCodigo(codigo);
    }


}
