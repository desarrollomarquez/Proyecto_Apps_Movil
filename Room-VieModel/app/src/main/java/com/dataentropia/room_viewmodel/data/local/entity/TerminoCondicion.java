package com.dataentropia.room_viewmodel.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.w3c.dom.Text;

@Entity(tableName = "termino_condicion")
public class TerminoCondicion {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "tc_id")
    private int tc_id;
    @ColumnInfo(name = "titulo")
    private Text titulo;
    @ColumnInfo(name = "contenido")
    private Text contenido;
    @ColumnInfo(name = "requerido")
    private Text requerido;
    @ColumnInfo(name = "orden")
    private Text orden;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTc_id() {
        return tc_id;
    }

    public void setTc_id(int tc_id) {
        this.tc_id = tc_id;
    }

    public Text getTitulo() {
        return titulo;
    }

    public void setTitulo(Text titulo) {
        this.titulo = titulo;
    }

    public Text getContenido() {
        return contenido;
    }

    public void setContenido(Text contenido) {
        this.contenido = contenido;
    }

    public Text getRequerido() {
        return requerido;
    }

    public void setRequerido(Text requerido) {
        this.requerido = requerido;
    }

    public Text getOrden() {
        return orden;
    }

    public void setOrden(Text orden) {
        this.orden = orden;
    }
}
