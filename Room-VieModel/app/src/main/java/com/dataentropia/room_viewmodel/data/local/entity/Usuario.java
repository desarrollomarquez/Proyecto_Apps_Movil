package com.dataentropia.room_viewmodel.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "usuario",
        foreignKeys = @ForeignKey(entity = TipoDocumento.class, parentColumns = "id", childColumns = "id_tid"),
        indices = {@Index("id_tid")})
public class Usuario {

   /* @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;*/
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    private int username;
    @ColumnInfo(name = "nombres")
    private String nombres;
    @ColumnInfo(name = "apellidos")
    private String apellidos;
    @ColumnInfo(name = "fnac")
    private String fnac;
    @ColumnInfo(name = "fexp")
    private String fexp;
    @ColumnInfo(name = "lexp")
    private String lexp;
    @ColumnInfo(name = "numcelular")
    private String numcelular;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "clave")
    private String clave;
    @ColumnInfo(name = "claveencriptada")
    private String claveencriptada;
    @ColumnInfo(name = "sesion")
    private String sesion;
    @ColumnInfo(name = "estado")
    private String estado;
    @NonNull
    @ColumnInfo(name = "id_tid")
    private int id_tid;


    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public String getFexp() {
        return fexp;
    }

    public void setFexp(String fexp) {
        this.fexp = fexp;
    }

    public String getLexp() {
        return lexp;
    }

    public void setLexp(String lexp) {
        this.lexp = lexp;
    }

    public String getNumcelular() {
        return numcelular;
    }

    public void setNumcelular(String numcelular) {
        this.numcelular = numcelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClaveencriptada() {
        return claveencriptada;
    }

    public void setClaveencriptada(String claveencriptada) {
        this.claveencriptada = claveencriptada;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_tid() {
        return id_tid;
    }

    public void setId_tid(int id_tid) {
        this.id_tid = id_tid;
    }
}
