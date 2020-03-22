package com.dataentropia.room_viewmodel.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.w3c.dom.Text;

@Entity(tableName = "tipo_documento")
public class TipoDocumento {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "nombre")
    private Text nombre;
    @ColumnInfo(name = "abrev")
    private Text abrev;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Text getNombre() {
        return nombre;
    }

    public void setNombre(Text nombre) {
        this.nombre = nombre;
    }

    public Text getAbrev() {
        return abrev;
    }

    public void setAbrev(Text abrev) {
        this.abrev = abrev;
    }
}
