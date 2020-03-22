package com.dataentropia.room_viewmodel.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dataentropia.room_viewmodel.data.local.entity.TipoDocumento;

import java.util.List;

@Dao
public interface TipoDocumentoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertTipoDocumento(TipoDocumento tipoDocumento);

    @Update
    public void updateTipoDocumento(TipoDocumento tipoDocumento);

    @Delete
    public void deleteTipoDocumento(TipoDocumento tipoDocumento);

    @Query("SELECT * FROM tipo_documento")
    public LiveData<List<TipoDocumento>> getAllTipoDocumentos();

    @Query("SELECT * FROM tipo_documento where id = :id")
    public LiveData<TipoDocumento> getTipoDocumentoById(String id);

    @Query("SELECT * FROM tipo_documento where id In (:id)")
    public List<TipoDocumento> getTipoDocumentoByIds(List<String> id);
}
