package com.dataentropia.room_viewmodel.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dataentropia.room_viewmodel.data.local.entity.Parametro;

import java.util.List;

@Dao
public interface ParametroDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertParametro(Parametro parametro);

    @Update
    public void updateParametro(Parametro parametro);

    @Delete
    public void deleteParametro(Parametro parametro);

    @Query("SELECT * FROM parametro")
    public LiveData<List<Parametro>> getAllParametros();

    @Query("SELECT * FROM parametro where codigo = :codigo")
    public LiveData<Parametro> getParametroByCodigo(String codigo);

    @Query("SELECT * FROM parametro where descripcion In (:descripcion)")
    public List<Parametro> getParametroByDescripcion(List<String> descripcion);
}
