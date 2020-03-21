package com.dataentropia.room_viewmodel;


import android.content.Context;
import androidx.room.Room;

public class DatabaseCreator {

    private static PersonDatabase personDatabase;
    private static AddressDatabase addressDatabase;
    private static final Object LOCK = new Object();

    public synchronized static PersonDatabase getPersonDatabase(Context context){
        if(personDatabase == null) {
            synchronized (LOCK) {
                if (personDatabase == null) {
                    personDatabase = Room.databaseBuilder(context,
                            PersonDatabase.class, "person db").build();
                }
            }
        }
        return personDatabase;
    }




}
