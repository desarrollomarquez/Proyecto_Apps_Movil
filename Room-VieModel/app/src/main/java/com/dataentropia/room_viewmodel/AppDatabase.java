package com.dataentropia.room_viewmodel;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class, Address.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDAO  PersonDatabase();
    public abstract AddressDAO AddressDatabase();
}
