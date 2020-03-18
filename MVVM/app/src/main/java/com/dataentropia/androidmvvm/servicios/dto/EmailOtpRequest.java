package com.dataentropia.androidmvvm.servicios.dto;



public class EmailOtpRequest<EEmailOtp> {
    private EEmailOtp eEmailOtp;

    public EmailOtpRequest(EEmailOtp eEmailOtp) {
        this.eEmailOtp = eEmailOtp;
    }

    public EEmailOtp geteEmailOtp() {
        return eEmailOtp;
    }

    public void seteEmailOtp(EEmailOtp eEmailOtp) {
        this.eEmailOtp = eEmailOtp;
    }

}
