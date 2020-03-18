package com.dataentropia.androidmvvm.servicios.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EUsuario implements Parcelable {

    @SerializedName("nombre")
    @Expose
    public String nombre;
    @SerializedName("apellido")
    @Expose
    public String apellido;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("fechaNacimiento")
    @Expose
    public String fechaNacimiento;

    public EUsuario(String nombre, String apellido, String email, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    protected EUsuario(Parcel in) {
        nombre = in.readString();
        apellido = in.readString();
        email = in.readString();
        fechaNacimiento = in.readString();
    }

    public static final Creator<EUsuario> CREATOR = new Creator<EUsuario>() {
        @Override
        public EUsuario createFromParcel(Parcel in) {
            return new EUsuario(in);
        }

        @Override
        public EUsuario[] newArray(int size) {
            return new EUsuario[size];
        }
    };

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(email);
        dest.writeString(fechaNacimiento);
    }
}
