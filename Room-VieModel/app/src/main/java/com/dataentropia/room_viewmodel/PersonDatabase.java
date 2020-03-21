package com.dataentropia.room_viewmodel;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 2, exportSchema = false)
public abstract class PersonDatabase extends RoomDatabase {
    public abstract PersonDAO PersonDatabase();
}
