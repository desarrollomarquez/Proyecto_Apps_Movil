package com.dataentropia.room_viewmodel.data.local;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.dataentropia.room_viewmodel.data.local.dao.AddressDAO;
import com.dataentropia.room_viewmodel.data.local.dao.DispositivoDAO;
import com.dataentropia.room_viewmodel.data.local.dao.MunicipioDAO;
import com.dataentropia.room_viewmodel.data.local.dao.ParametroDAO;
import com.dataentropia.room_viewmodel.data.local.dao.PersonDAO;
import com.dataentropia.room_viewmodel.data.local.dao.TerminoCondicionDAO;
import com.dataentropia.room_viewmodel.data.local.dao.TerminoCondicionxUsuarioDAO;
import com.dataentropia.room_viewmodel.data.local.dao.TipoDocumentoDAO;
import com.dataentropia.room_viewmodel.data.local.dao.UsuarioDAO;
import com.dataentropia.room_viewmodel.data.local.entity.Address;
import com.dataentropia.room_viewmodel.data.local.entity.Dispositivo;
import com.dataentropia.room_viewmodel.data.local.entity.Municipio;
import com.dataentropia.room_viewmodel.data.local.entity.Parametro;
import com.dataentropia.room_viewmodel.data.local.entity.Person;
import com.dataentropia.room_viewmodel.data.local.entity.TerminoCondicion;
import com.dataentropia.room_viewmodel.data.local.entity.TerminoCondicionxUsuario;
import com.dataentropia.room_viewmodel.data.local.entity.TipoDocumento;
import com.dataentropia.room_viewmodel.data.local.entity.Usuario;


@Database(entities = {Person.class, Address.class, Dispositivo.class, Municipio.class,
        Parametro.class, TerminoCondicion.class, TerminoCondicionxUsuario.class, TipoDocumento.class,
        Usuario.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "CivicaApp";
    private static final String INSERT_TABLA_TIPODOCUMENTO_1 = "INSERT INTO tipo_documento (nombre, abrev) VALUES ( 'Cedula de Ciudadania' , 'CC');";
    private static final String INSERT_TABLA_TIPODOCUMENTO_2 = "INSERT INTO tipo_documento (nombre, abrev) VALUES ( 'Tarjeta Identidad', 'TI' );";
    private static final String INSERT_TABLA_TIPODOCUMENTO_3 = "INSERT INTO tipo_documento (nombre, abrev) VALUES ( 'Cedula de Extranjera', 'CE');";
    private static final String INSERT_TABLA_MUNICIPIO_1 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (22,'MEDELLÍN');";
    private static final String INSERT_TABLA_MUNICIPIO_2 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (15,'ENVIGADO');";
    private static final String INSERT_TABLA_MUNICIPIO_3 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (18,'ITAGUÍ');";
    private static final String INSERT_TABLA_MUNICIPIO_4 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (26,'SABANETA')";
    private static final String INSERT_TABLA_MUNICIPIO_5 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (10,'CALDAS');";
    private static final String INSERT_TABLA_MUNICIPIO_6 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (20,'LA ESTRELLA');";
    private static final String INSERT_TABLA_MUNICIPIO_7 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (7,'BELLO');";
    private static final String INSERT_TABLA_MUNICIPIO_8 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (6,'BARBOSA');";
    private static final String INSERT_TABLA_MUNICIPIO_9 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (16,'GIRARDOTA');";
    private static final String INSERT_TABLA_MUNICIPIO_10 = "INSERT INTO municipio  (mun_codigo, mun_nome) values (14,'COPACABANA');";
    private static final String INSERT_TABLA_PARAMETRO_1 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_001', 'Valor texto Lands pantalla 1', 0,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_2 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_002', 'Valor texto Lands pantalla 2', 0,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_3 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_003', 'Valor texto Lands pantalla 3', 0,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_4 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_004', 'Tipos de documentos permitidos', 'Cedula de Ciudadania,Tarjeta de Identidad,Cedula de Extranjera','A' );";
    private static final String INSERT_TABLA_PARAMETRO_5 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_005', 'Numero de intentos ingreso de Clave', 3,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_6 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_006', 'Longitud Maxima de Numero Celular', 10,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_7 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_007', 'Longitud Maxima de Codigo Activacion/Recuperacion', 6,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_8 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_008', 'Tiempo de espera ingreso clave (milis)', 70000,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_9 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_009', 'Numero de intentos escaneo PDF147 de Documento de Identidad', 3,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_10 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_010', 'Tiempo de expiracion para codigo activacion/recuperacion(min)', 70000,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_11 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_011', 'Registrarlogs Informativos', 'S','A' );";
    private static final String INSERT_TABLA_PARAMETRO_12 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_012', 'Mostrar Lands', 'S','A' );";
    private static final String INSERT_TABLA_PARAMETRO_13 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_013', 'Edad minima para registro', 18,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_14 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_014', 'Numero de intentos recuperacion de clave', 3,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_15 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_015', 'Valor texto Lands pantalla 1', 0,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_16 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_016', 'Texto a mostrar terminos y condiciones', 1,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_17 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_017', 'Longitud Maxima de clave', 3,'A' );";
    private static final String INSERT_TABLA_PARAMETRO_18 = "INSERT INTO parametro ( codigo, descripcion, valor, estado) VALUES ( 'PAR_018', 'Temporizador de intervalo clave', 1000,'A' );";

    public static synchronized AppDatabase getAppDatabase(Context context){

        if(appDatabase == null) {
            synchronized (LOCK) {
                if (appDatabase == null) {
                    appDatabase = Room.databaseBuilder(context,
                            AppDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    db.execSQL(INSERT_TABLA_TIPODOCUMENTO_1);
                                    db.execSQL(INSERT_TABLA_TIPODOCUMENTO_2);
                                    db.execSQL(INSERT_TABLA_TIPODOCUMENTO_3);

                                    db.execSQL(INSERT_TABLA_MUNICIPIO_1);
                                    db.execSQL(INSERT_TABLA_MUNICIPIO_2);
                                    db.execSQL(INSERT_TABLA_MUNICIPIO_3);
                                    db.execSQL(INSERT_TABLA_MUNICIPIO_4);
                                    db.execSQL(INSERT_TABLA_MUNICIPIO_5);
                                    db.execSQL(INSERT_TABLA_MUNICIPIO_6);
                                    db.execSQL(INSERT_TABLA_MUNICIPIO_7);
                                    db.execSQL(INSERT_TABLA_MUNICIPIO_8);
                                    db.execSQL(INSERT_TABLA_MUNICIPIO_9);
                                    db.execSQL(INSERT_TABLA_MUNICIPIO_10);

                                    db.execSQL(INSERT_TABLA_PARAMETRO_1);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_2);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_3);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_4);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_5);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_6);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_7);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_8);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_9);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_10);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_11);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_12);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_13);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_14);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_15);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_16);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_17);
                                    db.execSQL(INSERT_TABLA_PARAMETRO_18);

                                }
                            })
                            .build();

                }
            }
        }
        return appDatabase;
    }


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
