package com.dataentropia.androidmvvm.helpers;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import tcs.civica.mobile.R;

public class CustomValidator {


    public static boolean ValidacionCampo(EditText campoValidar, TextInputLayout til, String expRegular, String msjError, boolean esObligatorio, boolean dibujarEstado  )
    {

        if (campoValidar.getText().toString().matches(expRegular) )
        {
            if(dibujarEstado)
            campoValidar.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tick, 0);

            //til.setErrorEnabled(false);
            til.setError(null);
            return true;
        }
        else
        {
            til.setErrorEnabled(true);
            if(campoValidar.getText().toString().trim().length() == 0)
            {
                if(esObligatorio)
                {
                    til.setError("El campo es obligatorio");
                }
                else
                {
                    //til.setErrorEnabled(false);
                    til.setError(null);
                }
            }
            else
            {
                til.setError(msjError);
            }

            if(dibujarEstado)
            campoValidar.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.error, 0);

            return false;
        }
    }


}