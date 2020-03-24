package com.dataentropia.room_viewmodel.data.remote.repository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;

import com.dataentropia.room_viewmodel.data.local.AppDatabase;
import com.dataentropia.room_viewmodel.data.local.dao.TipoDocumentoDAO;
import com.dataentropia.room_viewmodel.data.local.entity.TipoDocumento;


import java.util.List;

public class TipoDocumentoRepository {

    private TipoDocumentoDAO tipoDocumentoDAO;

    public TipoDocumentoRepository(Context context) {
        tipoDocumentoDAO = AppDatabase.getAppDatabase(context).TipoDocumentoDatabase();
    }

    public void addTipoDocumento(TipoDocumento td) {
           long rec =  tipoDocumentoDAO.insertTipoDocumento(td);
        Log.d("db insert ","added "+rec);
    }

   /* public List<TipoDocumento> insertAllTipoDocumentos(List<TipoDocumento> td){
        return tipoDocumentoDAO.insertAllTipoDocumentos(td);
    }*/

    public void updateTipoDocumento(TipoDocumento td) {
        tipoDocumentoDAO.updateTipoDocumento(td);
    }

    public void deleteTipoDocumento(TipoDocumento td) {
        tipoDocumentoDAO.deleteTipoDocumento(td);
    }

   public LiveData<List<TipoDocumento>> getAllTipoDocumentos() {
        return tipoDocumentoDAO.getAllTipoDocumentos();
    }

    public LiveData<TipoDocumento> getTipoDocumentoByCodigo(String id) {
        return tipoDocumentoDAO.getTipoDocumentoById(id);
    }


}
