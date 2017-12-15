package com.tangtuongco.apppppp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tangtuongco.apppppp.R;
import com.tangtuongco.apppppp.model.phongban;
import com.tangtuongco.apppppp.model.sinhvien;

import java.util.ArrayList;

public class EditPBActivity extends AppCompatActivity {
    EditText edtID,edtCODE;
    Button btnEdit,btnDel;
    int INDEX=0;
    int flag=0;//0 là xóa 1 là sửa
    ArrayList<sinhvien> arrsv = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pb);
        anhxa();
        getdata();
        control();



    }

    private void getdata() {
        Intent intent = getIntent();
        if(intent!=null)
        {
            Bundle bundle = intent.getBundleExtra("bundle");
            phongban a = (phongban) bundle.getSerializable("edtpb");
            INDEX = bundle.getInt("edtpbindex");
            flag = bundle.getInt("edtpbflag");
            edtID.setText(a.getTenpb());
            edtCODE.setText(a.getMapb());
        }
    }

    private void control() {
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phongban a = new phongban();
                a.setMapb(edtCODE.getText().toString());
                a.setTenpb(edtID.getText().toString());
                a.setListsv(arrsv);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("edtpbtrave",a);
                bundle.putInt("edtpbindextrave",INDEX);
                flag=1;
                bundle.putInt("edtpbflag",flag);
                intent.putExtra("bundletrave",bundle);;
                setResult(234,intent);
                finish();


            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phongban a = new phongban();
                a.setMapb(edtCODE.getText().toString());
                a.setTenpb(edtID.getText().toString());
                a.setListsv(arrsv);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("edtpbtrave",a);
                flag=0;
                bundle.putInt("edtpbflag",flag);
                bundle.putInt("edtpbindextrave",INDEX);
                intent.putExtra("bundletrave",bundle);;
                setResult(234,intent);
                finish();
            }
        });
    }

    private void anhxa() {
        edtID = findViewById(R.id.edtEDTIDPB);
        edtCODE = findViewById(R.id.edtEDTCODEPB);
        btnEdit = findViewById(R.id.btnEDTPB);
        btnDel = findViewById(R.id.btnDELPB);
    }
}
