package com.dataentropia.room_viewmodel.data.local;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.dataentropia.room_viewmodel.data.local.dao.DispositivoDAO;
import com.dataentropia.room_viewmodel.data.local.dao.MunicipioDAO;
import com.dataentropia.room_viewmodel.data.local.dao.ParametroDAO;
import com.dataentropia.room_viewmodel.data.local.dao.TerminoCondicionDAO;
import com.dataentropia.room_viewmodel.data.local.dao.TerminoCondicionxUsuarioDAO;
import com.dataentropia.room_viewmodel.data.local.dao.TipoDocumentoDAO;
import com.dataentropia.room_viewmodel.data.local.dao.UsuarioDAO;
import com.dataentropia.room_viewmodel.data.local.entity.Address;
import com.dataentropia.room_viewmodel.data.local.dao.AddressDAO;
import com.dataentropia.room_viewmodel.data.local.entity.Dispositivo;
import com.dataentropia.room_viewmodel.data.local.entity.Municipio;
import com.dataentropia.room_viewmodel.data.local.entity.Parametro;
import com.dataentropia.room_viewmodel.data.local.entity.Person;
import com.dataentropia.room_viewmodel.data.local.dao.PersonDAO;
import com.dataentropia.room_viewmodel.data.local.entity.TerminoCondicion;
import com.dataentropia.room_viewmodel.data.local.entity.TerminoCondicionxUsuario;
import com.dataentropia.room_viewmodel.data.local.entity.TipoDocumento;
import com.dataentropia.room_viewmodel.data.local.entity.Usuario;

@Database(entities = {Person.class, Address.class, Dispositivo.class, Municipio.class,
        Parametro.class, TerminoCondicion.class, TerminoCondicionxUsuario.class, TipoDocumento.class,
        Usuario.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDAO PersonDatabase();
    public abstract AddressDAO AddressDatabase();
    public abstract DispositivoDAO DispositivoDatabase();
    public abstract MunicipioDAO MunicipioDatabase();
    public abstract ParametroDAO ParametroDatabase();
    public abstract TerminoCondicionDAO TerminoCondicionDatabase();
    public abstract TerminoCondicionxUsuarioDAO TerminoCondicionxUsuarioDatabase();
    public abstract TipoDocumentoDAO TipoDocumentoDatabase();
    public abstract UsuarioDAO UsuarioDatabase();
}
