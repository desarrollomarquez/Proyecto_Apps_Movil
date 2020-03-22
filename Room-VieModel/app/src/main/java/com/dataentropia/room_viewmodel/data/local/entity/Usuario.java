package com.dataentropia.room_viewmodel.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.w3c.dom.Text;

@Entity(tableName = "usuario",
        foreignKeys = @ForeignKey(entity = TipoDocumento.class, parentColumns = "id", childColumns = "id_tid"),
        indices = {@Index("id_tid")})
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @NonNull
    @ColumnInfo(name = "username")
    private Text username;
    @ColumnInfo(name = "nombres")
    private Text nombres;
    @ColumnInfo(name = "apellidos")
    private Text apellidos;
    @ColumnInfo(name = "fnac")
    private Text fnac;
    @ColumnInfo(name = "fexp")
    private Text fexp;
    @ColumnInfo(name = "lexp")
    private Text lexp;
    @ColumnInfo(name = "numcelular")
    private Text numcelular;
    @ColumnInfo(name = "email")
    private Text email;
    @ColumnInfo(name = "clave")
    private Text clave;
    @ColumnInfo(name = "claveencriptada")
    private Text claveencriptada;
    @ColumnInfo(name = "sesion")
    private Text sesion;
    @ColumnInfo(name = "estado")
    private Text estado;
    @NonNull
    @ColumnInfo(name = "id_tid")
    private int id_tid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public Text getUsername() {
        return username;
    }

    public void setUsername(@NonNull Text username) {
        this.username = username;
    }

    public Text getNombres() {
        return nombres;
    }

    public void setNombres(Text nombres) {
        this.nombres = nombres;
    }

    public Text getApellidos() {
        return apellidos;
    }

    public void setApellidos(Text apellidos) {
        this.apellidos = apellidos;
    }

    public Text getFnac() {
        return fnac;
    }

    public void setFnac(Text fnac) {
        this.fnac = fnac;
    }

    public Text getFexp() {
        return fexp;
    }

    public void setFexp(Text fexp) {
        this.fexp = fexp;
    }

    public Text getLexp() {
        return lexp;
    }

    public void setLexp(Text lexp) {
        this.lexp = lexp;
    }

    public Text getNumcelular() {
        return numcelular;
    }

    public void setNumcelular(Text numcelular) {
        this.numcelular = numcelular;
    }

    public Text getEmail() {
        return email;
    }

    public void setEmail(Text email) {
        this.email = email;
    }

    public Text getClave() {
        return clave;
    }

    public void setClave(Text clave) {
        this.clave = clave;
    }

    public Text getClaveencriptada() {
        return claveencriptada;
    }

    public void setClaveencriptada(Text claveencriptada) {
        this.claveencriptada = claveencriptada;
    }

    public Text getSesion() {
        return sesion;
    }

    public void setSesion(Text sesion) {
        this.sesion = sesion;
    }

    public Text getEstado() {
        return estado;
    }

    public void setEstado(Text estado) {
        this.estado = estado;
    }

    public int getId_tid() {
        return id_tid;
    }

    public void setId_tid(int id_tid) {
        this.id_tid = id_tid;
    }
}
