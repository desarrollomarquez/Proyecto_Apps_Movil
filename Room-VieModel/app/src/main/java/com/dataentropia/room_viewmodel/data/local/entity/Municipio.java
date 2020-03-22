package com.dataentropia.room_viewmodel.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.w3c.dom.Text;

@Entity(tableName = "municipio")
public class Municipio {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "mun_codigo")
    private String mun_codigo;
    @ColumnInfo(name = "mun_nome")
    private String mun_nome;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMun_codigo() {
        return mun_codigo;
    }

    public void setMun_codigo(String mun_codigo) {
        this.mun_codigo = mun_codigo;
    }

    public String getMun_nome() {
        return mun_nome;
    }

    public void setMun_nome(String mun_nome) {
        this.mun_nome = mun_nome;
    }
}
