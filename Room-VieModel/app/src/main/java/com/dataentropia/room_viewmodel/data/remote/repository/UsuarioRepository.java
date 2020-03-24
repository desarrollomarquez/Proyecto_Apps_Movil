package com.dataentropia.room_viewmodel.data.remote.repository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;

import com.dataentropia.room_viewmodel.data.local.AppDatabase;
import com.dataentropia.room_viewmodel.data.local.dao.UsuarioDAO;
import com.dataentropia.room_viewmodel.data.local.entity.Usuario;


import java.util.List;

public class UsuarioRepository {

    private UsuarioDAO usuarioDAO;

    public UsuarioRepository(Context context) {
        usuarioDAO = AppDatabase.getAppDatabase(context).UsuarioDatabase();
    }

    public void addUsuario(Usuario u) {
           long rec =  usuarioDAO.insertUsuario(u);
        Log.d("db insert ","added "+rec);
    }

    public void updateUsuario(Usuario u) {
        usuarioDAO.updateUsuario(u);
    }

    public void deleteUsuario(Usuario u) {
        usuarioDAO.deleteUsuario(u);
    }

    public LiveData<List<Usuario>> getAllUsuarios() {
        return usuarioDAO.getAllUsuarios();
    }

    public LiveData<Usuario> getUsuarioByUsername(String username) {
        return usuarioDAO.getUsuarioByUsername(username);
    }


}
