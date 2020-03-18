package com.dataentropia.androidmvvm.local;

import android.content.Context;



import com.dataentropia.androidmvvm.local.dao.TipoDocumentoDao;
import com.dataentropia.androidmvvm.local.entity.TipoDocumento;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TipoDocumento.class}, version = 1, exportSchema = false)
public abstract class TipoDocumentoDataBase extends RoomDatabase {

    private static TipoDocumentoDataBase instance;
    public abstract TipoDocumentoDao oper();

    public TipoDocumentoDataBase() {
    }

    public static TipoDocumentoDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (TipoDocumentoDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            TipoDocumentoDataBase.class,
                            "product_database")
                            .build();

                }
            }
        }
        return instance;
    }

}
