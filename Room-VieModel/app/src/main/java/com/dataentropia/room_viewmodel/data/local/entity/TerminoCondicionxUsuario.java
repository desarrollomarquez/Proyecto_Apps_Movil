package com.dataentropia.room_viewmodel.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.RoomWarnings;

import org.w3c.dom.Text;


@Entity(tableName = "termino_condicion_x_usuario",
        primaryKeys = { "tcu_tc_id", "tcu_pes_doc" },
        foreignKeys = {
                @ForeignKey(entity = TerminoCondicion.class,
                        parentColumns = "tc_id",
                        childColumns = "tcu_tc_id"),
                @ForeignKey(entity = Usuario.class,
                        parentColumns = "username",
                        childColumns = "tcu_pes_doc")
        },
        indices = {@Index("tcu_pes_doc"),@Index("tcu_tc_id")})
public class TerminoCondicionxUsuario {

    @NonNull
    @ColumnInfo(name = "tcu_pes_doc")
    private int tcu_pes_doc;
    @NonNull
    @ColumnInfo(name = "tcu_tc_id")
    private int tcu_tc_id;
    @NonNull
    @ColumnInfo(name = "tcu_acepto")
    private int tcu_acepto;

    public int getTcu_pes_doc() {
        return tcu_pes_doc;
    }

    public void setTcu_pes_doc(int tcu_pes_doc) {
        this.tcu_pes_doc = tcu_pes_doc;
    }

    public int getTcu_tc_id() {
        return tcu_tc_id;
    }

    public void setTcu_tc_id(int tcu_tc_id) {
        this.tcu_tc_id = tcu_tc_id;
    }

    public int getTcu_acepto() {
        return tcu_acepto;
    }

    public void setTcu_acepto(int tcu_acepto) {
        this.tcu_acepto = tcu_acepto;
    }

}
