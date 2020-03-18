package com.dataentropia.androidmvvm.servicios.entity;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EIdentificacionCivica implements Parcelable {

    @SerializedName("pessoaId")
    @Expose
    public long pessoaId;
    @SerializedName("usuarioCivTransId")
    @Expose
    public long usuarioCivTransId;

    protected EIdentificacionCivica(Parcel in) {
        pessoaId = in.readLong();
        usuarioCivTransId = in.readLong();
    }

    public static final Creator<EIdentificacionCivica> CREATOR = new Creator<EIdentificacionCivica>() {
        @Override
        public EIdentificacionCivica createFromParcel(Parcel in) {
            return new EIdentificacionCivica(in);
        }

        @Override
        public EIdentificacionCivica[] newArray(int size) {
            return new EIdentificacionCivica[size];
        }
    };

    public long getPessoaId() {
        return pessoaId;
    }
    public void setPessoaId(long pessoaId) {
        this.pessoaId = pessoaId;
    }
    public long getUsuarioCivTransId() {
        return usuarioCivTransId;
    }
    public void setUsuarioCivTransId(long usuarioCivTransId) {
        this.usuarioCivTransId = usuarioCivTransId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(pessoaId);
        dest.writeLong(usuarioCivTransId);
    }
}
