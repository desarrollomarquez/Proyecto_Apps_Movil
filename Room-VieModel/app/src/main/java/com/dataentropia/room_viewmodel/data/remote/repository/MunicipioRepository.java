package com.dataentropia.room_viewmodel.data.remote.repository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;
import com.dataentropia.room_viewmodel.data.local.dao.MunicipioDAO;
import com.dataentropia.room_viewmodel.data.local.entity.Municipio;
import com.dataentropia.room_viewmodel.helpers.DatabaseCreator;
import java.util.List;

public class MunicipioRepository {

    private MunicipioDAO municipioDAO;

    public MunicipioRepository(Context context) {
        municipioDAO = DatabaseCreator.getAppDatabase(context).MunicipioDatabase();
    }

    public void addMunicipio(Municipio m) {
           long rec =  municipioDAO.insertMunicipio(m);
        Log.d("db insert ","added "+rec);
    }

    public void updateMunicipio(Municipio m) {
        municipioDAO.updateMunicipio(m);
    }

    public void deleteMunicipio(Municipio m) {
        municipioDAO.deleteMunicipio(m);
    }

    public LiveData<List<Municipio>> getAllMunicipios() {
        return municipioDAO.getAllMunicipios();
    }

    public LiveData<Municipio> getMunicipioByCodigo(String codigo) {
        return municipioDAO.getMunicipioByCodigo(codigo);
    }


}
