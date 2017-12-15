package com.tangtuongco.apppppp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Administrator on 22/11/2017.
 */

public class sinhvien implements Serializable {
    private String masv;
    private String tensv;
    private byte[] avatar;
    private String diachi;
    private String sdt;

    public sinhvien(String masv, String tensv, byte[] avatar, String diachi, String sdt) {
        this.masv = masv;
        this.tensv = tensv;
        this.avatar = avatar;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public String getMasv() {

        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public sinhvien() {




    }





}
