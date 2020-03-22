package com.dataentropia.room_viewmodel.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dataentropia.room_viewmodel.data.local.entity.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertUsuario(Usuario usuario);

    @Update
    public void updateUsuario(Usuario usuario);

    @Delete
    public void deleteUsuario(Usuario usuario);

    @Query("SELECT * FROM usuario")
    public LiveData<List<Usuario>> getAllTipoDocumentos();

    @Query("SELECT * FROM usuario where username = :username")
    public LiveData<Usuario> getUsuarioByUsername(String username);

    @Query("SELECT * FROM usuario where id In (:username)")
    public List<Usuario> getUsuarioByUsernames(List<String> username);
}
