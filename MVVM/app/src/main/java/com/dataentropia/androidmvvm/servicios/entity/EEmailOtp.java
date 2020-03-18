package com.dataentropia.androidmvvm.servicios.entity;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EEmailOtp implements Parcelable {

    @SerializedName("codigoOTP")
    @Expose
    private String codigoOTP;
    @SerializedName("correoAEnviar")
    @Expose
    private String correoAEnviar;
    @SerializedName("usuarioQueEnvia")
    @Expose
    private String usuarioQueEnvia;
    @SerializedName("nroDocumento")
    @Expose
    private String nroDocumento;

    public EEmailOtp(String codigoOTP, String correoAEnviar, String usuarioQueEnvia, String nroDocumento) {
        this.codigoOTP = codigoOTP;
        this.correoAEnviar = correoAEnviar;
        this.usuarioQueEnvia = usuarioQueEnvia;
        this.nroDocumento = nroDocumento;
    }

    protected EEmailOtp(Parcel in) {
        codigoOTP = in.readString();
        correoAEnviar = in.readString();
        usuarioQueEnvia = in.readString();
        nroDocumento = in.readString();
    }

    public static final Creator<EEmailOtp> CREATOR = new Creator<EEmailOtp>() {
        @Override
        public EEmailOtp createFromParcel(Parcel in) {
            return new EEmailOtp(in);
        }

        @Override
        public EEmailOtp[] newArray(int size) {
            return new EEmailOtp[size];
        }
    };

    public String getNroDocumento() {
        return nroDocumento;
    }
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
    public String getCodigoOTP() {
        return codigoOTP;
    }
    public void setCodigoOTP(String codigoOTP) {
        this.codigoOTP = codigoOTP;
    }
    public String getCorreoAEnviar() {
        return correoAEnviar;
    }
    public void setCorreoAEnviar(String correoAEnviar) {
        this.correoAEnviar = correoAEnviar;
    }
    public String getUsuarioQueEnvia() {
        return usuarioQueEnvia;
    }
    public void setUsuarioQueEnvia(String usuarioQueEnvia) {
        this.usuarioQueEnvia = usuarioQueEnvia;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codigoOTP);
        dest.writeString(correoAEnviar);
        dest.writeString(usuarioQueEnvia);
        dest.writeString(nroDocumento);
    }
}
