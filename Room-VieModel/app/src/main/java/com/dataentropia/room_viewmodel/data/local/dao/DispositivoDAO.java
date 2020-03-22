package com.dataentropia.room_viewmodel.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dataentropia.room_viewmodel.data.local.entity.Dispositivo;

import java.util.List;

@Dao
public interface DispositivoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertDispositivo(Dispositivo dispositivo);

    @Update
    public void updateDispositivo(Dispositivo dispositivo);

    @Delete
    public void deleteDispositivo(Dispositivo dispositivo);

    @Query("SELECT * FROM dispositivo")
    public LiveData<List<Dispositivo>> getAllDispositivos();

    @Query("SELECT * FROM dispositivo where id = :id")
    public LiveData<Dispositivo> getDispositivoById(String id);

    @Query("SELECT * FROM dispositivo where numcelular In (:numerocel)")
    public List<Dispositivo> getDispositivoByNumeros(List<String> numerocel);
}
