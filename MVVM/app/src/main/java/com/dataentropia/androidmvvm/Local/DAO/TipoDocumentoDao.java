package com.dataentropia.androidmvvm.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.dataentropia.androidmvvm.local.entity.TipoDocumento;
import java.util.List;

@Dao
public interface TipoDocumentoDao {

    @SuppressWarnings("unchecked")
    @Insert
     void addTidItems(TipoDocumento tipoDocumento);

    @SuppressWarnings("unchecked")
    @Query("DELETE FROM TipoDocumento")
     void deleteAllTidItems();

    @SuppressWarnings("unchecked")
    @Query("select * from TipoDocumento")
    List<TipoDocumento> getAllTidItems();


    @SuppressWarnings("unchecked")
    @Delete
     void deleteItems(TipoDocumento tipoDocumento);
}
