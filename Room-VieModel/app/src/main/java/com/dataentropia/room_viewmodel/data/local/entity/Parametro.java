package com.dataentropia.room_viewmodel.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.w3c.dom.Text;

@Entity(tableName = "parametro")
public class Parametro {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "codigo")
    private Text codigo;
    @ColumnInfo(name = "descripcion")
    private Text descripcion;
    @ColumnInfo(name = "valor")
    private Text valor;
    @ColumnInfo(name = "estado")
    private Text estado;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Text getCodigo() {
        return codigo;
    }

    public void setCodigo(Text codigo) {
        this.codigo = codigo;
    }

    public Text getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Text descripcion) {
        this.descripcion = descripcion;
    }

    public Text getValor() {
        return valor;
    }

    public void setValor(Text valor) {
        this.valor = valor;
    }

    public Text getEstado() {
        return estado;
    }

    public void setEstado(Text estado) {
        this.estado = estado;
    }
}
