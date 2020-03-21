package com.dataentropia.room_viewmodel;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Address.class}, version = 2, exportSchema = false)
public abstract class AddressDatabase extends RoomDatabase {
    public abstract AddressDAO AddressDatabase();
}
