package com.dataentropia.room_viewmodel.data.remote.repository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;

import com.dataentropia.room_viewmodel.data.local.AppDatabase;
import com.dataentropia.room_viewmodel.data.local.dao.DispositivoDAO;
import com.dataentropia.room_viewmodel.data.local.entity.Dispositivo;


import java.util.List;

public class DispositivoRepository {

    private DispositivoDAO dispositivoDAO;

    public DispositivoRepository(Context context) {
        dispositivoDAO = AppDatabase.getAppDatabase(context).DispositivoDatabase();
    }

    public void addDispositivo(Dispositivo d) {
           long rec =  dispositivoDAO.insertDispositivo(d);
        Log.d("db insert ","added "+rec);
    }

    public void updateDispositivo(Dispositivo d) {
        dispositivoDAO.updateDispositivo(d);
    }

    public void deleteDispositivo(Dispositivo d) {
        dispositivoDAO.deleteDispositivo(d);
    }

    public LiveData<List<Dispositivo>> getAllDispositivos() {
        return dispositivoDAO.getAllDispositivos();
    }

    public LiveData<Dispositivo> getDispositivoById(String id) {
        return dispositivoDAO.getDispositivoById(id);
    }


}
