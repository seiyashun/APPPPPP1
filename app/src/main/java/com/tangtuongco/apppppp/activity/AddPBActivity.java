package com.tangtuongco.apppppp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tangtuongco.apppppp.R;
import com.tangtuongco.apppppp.model.phongban;
import com.tangtuongco.apppppp.model.sinhvien;

import java.util.ArrayList;

public class AddPBActivity extends AppCompatActivity {
    EditText edtName,edtCode;
    Button btnAdd;
    ArrayList<sinhvien> arrsv = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_pb);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarpb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        anhxa();
        control();

    }


    private void control() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phongban a = new phongban();
                a.setMapb(edtCode.getText().toString());
                a.setTenpb(edtName.getText().toString());
                a.setListsv(arrsv);

                Intent intent  = new Intent();
                intent.putExtra("lpb",a);
                setResult(123,intent);
                finish();
            }
        });
    }

    private void anhxa() {
        edtName = findViewById(R.id.edtADDIDPB);
        edtCode = findViewById(R.id.edtADDCODEPB);
        btnAdd = findViewById(R.id.btnADDPB);
    }
}
