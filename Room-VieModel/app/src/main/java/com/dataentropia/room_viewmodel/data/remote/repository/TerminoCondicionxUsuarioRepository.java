package com.dataentropia.room_viewmodel.data.remote.repository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;

import com.dataentropia.room_viewmodel.data.local.AppDatabase;
import com.dataentropia.room_viewmodel.data.local.dao.TerminoCondicionxUsuarioDAO;
import com.dataentropia.room_viewmodel.data.local.entity.TerminoCondicionxUsuario;


import java.util.List;

public class TerminoCondicionxUsuarioRepository {

    private TerminoCondicionxUsuarioDAO terminoCondicionxUsuarioDAO;

    public TerminoCondicionxUsuarioRepository(Context context) {
        terminoCondicionxUsuarioDAO = AppDatabase.getAppDatabase(context).TerminoCondicionxUsuarioDatabase();
    }

    public void addTerminoCondicionxUsuario(TerminoCondicionxUsuario tcu) {
           long rec =  terminoCondicionxUsuarioDAO.insertTerminoCondicionxUsuario(tcu);
        Log.d("db insert ","added "+rec);
    }

    public void updateTerminoCondicionxUsuario(TerminoCondicionxUsuario tcu) {
        terminoCondicionxUsuarioDAO.updateTerminoCondicionxUsuario(tcu);
    }

    public void deleteTerminoCondicionxUsuario(TerminoCondicionxUsuario tcu) {
        terminoCondicionxUsuarioDAO.deleteTerminoCondicionxUsuario(tcu);
    }

    public LiveData<List<TerminoCondicionxUsuario>> getAllTerminoCondicionxUsuarios() {
        return terminoCondicionxUsuarioDAO.getAllTerminoCondicionxUsuario();
    }

    public LiveData<TerminoCondicionxUsuario> getParametroByCodigo(String username) {
        return terminoCondicionxUsuarioDAO.getTerminoCondicionxUsuarioByUsername(username);
    }


}
