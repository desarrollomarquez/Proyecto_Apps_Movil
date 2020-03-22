package com.dataentropia.room_viewmodel.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RoomWarnings;
import androidx.room.Update;

import com.dataentropia.room_viewmodel.data.local.entity.TerminoCondicionxUsuario;

import java.util.List;

@Dao
public interface TerminoCondicionxUsuarioDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertTerminoCondicionxUsuario(TerminoCondicionxUsuario terminoCondicionxUsuario);

    @Update
    public void updateTerminoCondicionxUsuario(TerminoCondicionxUsuario terminoCondicionxUsuario);

    @Delete
    public void deleteTerminoCondicionxUsuario(TerminoCondicionxUsuario terminoCondicionxUsuario);

    @Query("SELECT * FROM termino_condicion_x_usuario")
    public LiveData<List<TerminoCondicionxUsuario>> getAllTerminoCondicionxUsuario();


    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query( " SELECT * FROM termino_condicion " +
            " INNER JOIN termino_condicion_x_usuario" +
            " ON termino_condicion.tc_id=termino_condicion_x_usuario.tcu_tc_id" +
            " WHERE termino_condicion_x_usuario.tcu_pes_doc=:username")
    public LiveData<TerminoCondicionxUsuario> getTerminoCondicionxUsuarioByUsername(String username);

}
