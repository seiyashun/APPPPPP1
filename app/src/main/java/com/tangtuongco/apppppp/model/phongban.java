package com.tangtuongco.apppppp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 22/11/2017.
 */

public class phongban implements Serializable {
    private String tenpb;
    private String mapb;
    private ArrayList<sinhvien> listsv;

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public ArrayList<sinhvien> getListsv() {
        return listsv;
    }

    public void setListsv(ArrayList<sinhvien> listsv) {
        this.listsv = listsv;
    }

    public phongban(String tenpb, String mapb, ArrayList<sinhvien> listsv) {

        this.tenpb = tenpb;
        this.mapb = mapb;
        this.listsv = listsv;
    }
    public  phongban()
    {
        this.tenpb="";
        this.mapb="";
        listsv = new ArrayList<sinhvien>();
    }



    public sinhvien tim(String masv)
    {
        for (sinhvien a: listsv) {
            if(a.getMasv().toString()==masv) {
                return a;
            }
        }
        return null;
    }
    public  void them(sinhvien a)
    {
        listsv.add(a);
    }
    public  void xoa(String masv)
    {
        sinhvien a = tim(masv);
        if(a!=null) listsv.remove(a);
    }

    public  void sua(sinhvien a)
    {
        sinhvien b = tim(a.getMasv());
        if(b!=null)
        {
            b.setDiachi(a.getDiachi().toString());
            b.setSdt(a.getSdt().toString());
            b.setTensv(a.getTensv().toString());

        }
    }
}
