package com.dataentropia.room_viewmodel.helpers;


import android.content.Context;
import androidx.room.Room;

import com.dataentropia.room_viewmodel.data.local.AppDatabase;

public class DatabaseCreator {

    private static AppDatabase appDatabase;
    private static final Object LOCK = new Object();

    public synchronized static AppDatabase getAppDatabase(Context context){
        if(appDatabase == null) {
            synchronized (LOCK) {
                if (appDatabase == null) {
                    appDatabase = Room.databaseBuilder(context,
                            AppDatabase.class, "room_viewmodel db").build();
                }
            }
        }
        return appDatabase;
    }






}
