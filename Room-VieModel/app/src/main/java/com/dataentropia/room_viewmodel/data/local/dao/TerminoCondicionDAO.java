package com.dataentropia.room_viewmodel.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dataentropia.room_viewmodel.data.local.entity.TerminoCondicion;

import java.util.List;

@Dao
public interface TerminoCondicionDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertTerminoCondicion(TerminoCondicion terminoCondicion);

    @Update
    public void updateTerminoCondicion(TerminoCondicion terminoCondicion);

    @Delete
    public void deleteTerminoCondicion(TerminoCondicion terminoCondicion);

    @Query("SELECT * FROM termino_condicion")
    public LiveData<List<TerminoCondicion>> getAllTerminoCondiciones();

    @Query("SELECT * FROM termino_condicion where tc_id = :tc_id")
    public LiveData<TerminoCondicion> getTerminoCondicionByCodigo(String tc_id);

    @Query("SELECT * FROM termino_condicion where tc_id In (:tc_id)")
    public List<TerminoCondicion> getTerminoCondicionByCodigo(List<String> tc_id);
}
