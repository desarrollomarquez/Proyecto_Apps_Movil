package com.dataentropia.room_viewmodel.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dataentropia.room_viewmodel.data.local.entity.Municipio;

import java.util.List;

@Dao
public interface MunicipioDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertMunicipio(Municipio municipio);

    @Update
    public void updateMunicipio(Municipio municipio);

    @Delete
    public void deleteMunicipio(Municipio municipio);

    @Query("SELECT * FROM municipio")
    public LiveData<List<Municipio>> getAllMunicipios();

    @Query("SELECT * FROM municipio where mun_codigo = :mun_codigo")
    public LiveData<Municipio> getMunicipioByCodigo(String mun_codigo);

    @Query("SELECT * FROM municipio where mun_codigo In (:mun_codigo)")
    public List<Municipio> getMunicipioByCodigos(List<String> mun_codigo);
}
