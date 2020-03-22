package com.dataentropia.room_viewmodel.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.w3c.dom.Text;

@Entity(tableName = "dispositivo")
public class Dispositivo {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "imei")
    private Text imei;
    @ColumnInfo(name = "version")
    private Text version;
    @ColumnInfo(name = "numcelular")
    private Text numcelular;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Text getImei() {
        return imei;
    }

    public void setImei(Text imei) {
        this.imei = imei;
    }

    public Text getVersion() {
        return version;
    }

    public void setVersion(Text version) {
        this.version = version;
    }

    public Text getNumcelular() {
        return numcelular;
    }

    public void setNumcelular(Text numcelular) {
        this.numcelular = numcelular;
    }
}
