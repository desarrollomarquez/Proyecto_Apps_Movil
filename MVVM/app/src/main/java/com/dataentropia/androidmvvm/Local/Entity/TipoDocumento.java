package com.dataentropia.androidmvvm.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.dataentropia.androidmvvm.servicios.entity.Movie;


@Entity(tableName = "TipoDocumento")
public class TipoDocumento {

    private static TipoDocumento instance;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "tid")
    private String tid;

    @ColumnInfo(name = "name")
    private String name;

    public TipoDocumento() {
        this.id = id;
        this.tid = tid;
        this.name = name;
    }

    public static TipoDocumento getInstance() {
        if (instance == null) {
            synchronized (TipoDocumento.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new TipoDocumento();
                }
            }
        }
        return instance;
    }



    public static void setInstance(TipoDocumento instance) {
        TipoDocumento.instance = instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
