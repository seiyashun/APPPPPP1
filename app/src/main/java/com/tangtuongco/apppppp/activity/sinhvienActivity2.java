package com.tangtuongco.apppppp.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.tangtuongco.apppppp.R;
import com.tangtuongco.apppppp.model.phongban;
import com.tangtuongco.apppppp.model.sinhvien;
import com.tangtuongco.apppppp.ulty.pbAdapter;
import com.tangtuongco.apppppp.ulty.svAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class sinhvienActivity2 extends AppCompatActivity

{
    int INDEX=0;
    svAdapter svAdapter;
    ListView listViewSV;
    Button btnADD;
    ArrayList<sinhvien> sinhvienArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinhvien);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarpb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();


            }
        });

        getdata();

        anhxa();
        getdata();
        control();
      //  sinhvienArrayList = (ArrayList<sinhvien>) getIntent().getSerializableExtra("test");
        svAdapter =new svAdapter(sinhvienArrayList, getApplicationContext());
        listViewSV.setAdapter(svAdapter);

    }

    public void onBackPressed() {
        Intent intent1 = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("edtsvtrave",sinhvienArrayList);
        bundle.putInt("edtsvindextrave",INDEX);
        intent1.putExtra("bundletrave",bundle);;
        setResult(955,intent1);


        finish();
        super.onBackPressed();
    }
    private void getdata() {
        Intent intent = getIntent();
        if(intent!=null)
        {
            Bundle bundle = intent.getBundleExtra("bundle");
            phongban a = (phongban) bundle.getSerializable("datasv");
            INDEX = bundle.getInt("edtsvindex");
            sinhvienArrayList=a.getListsv();


        }
    }

    private void control() {
        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ThemSV = new Intent(sinhvienActivity2.this,AddSVActivity.class);
                startActivityForResult(ThemSV,111);

            }
        });
        listViewSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sinhvien b = sinhvienArrayList.get(i);
                int index = i;
                int flag =99;
                Intent intentEdtSV = new Intent(sinhvienActivity2.this,EditSinhVien.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("edtsvvv",b);
                bundle.putInt("edtsvvvvvindex",index);
                bundle.putInt("edtsvvvvvflag",flag);
                intentEdtSV.putExtra("bundle",bundle);
                startActivityForResult(intentEdtSV,222);

            }
        });

    }

    private void anhxa() {
        listViewSV = findViewById(R.id.listviewSV);
        btnADD = findViewById(R.id.btnADDSV);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==111 && data !=null)
        {
            sinhvien a = (sinhvien) data.getSerializableExtra("1sv");

            int flagc=0;
            if(sinhvienArrayList.size()==0)
            {
                sinhvienArrayList.add(a);
            }
            else {
                for (int i = 0; i < sinhvienArrayList.size(); i++) {
                    if (a.getMasv().equals(sinhvienArrayList.get(i).getMasv())) {
                        new AlertDialog.Builder(this)
                                .setTitle(getString(R.string.warning))
                                .setMessage(getString(R.string.idx2))
                                .setNegativeButton("OK", null)
                                .create().show();
                        flagc=0;
                        break;
                    } else {
                        flagc = 1;
                    }
                }
                if (flagc == 1) {
                    sinhvienArrayList.add(a);
                }
            }
        }
        if(requestCode==222 && data!=null)
        {
            Bundle bundle = data.getBundleExtra("bundletrave");
            int t = bundle.getInt("edtindexsvvvvvvtraveeeee");
            int flag=bundle.getInt("edtsvflagggg");
            sinhvien a = (sinhvien) bundle.getSerializable("edtsvvvvvvtrave");
            if(flag==0)
            {
                sinhvienArrayList.remove(t);
            }
            else if(flag==1)
            {
                /*sinhvienArrayList.get(t).setMasv(a.getMasv());
                sinhvienArrayList.get(t).setDiachi(a.getDiachi());
                sinhvienArrayList.get(t).setSdt(a.getSdt());*/
                sinhvienArrayList.set(t,a);
            }
        }
        svAdapter.notifyDataSetChanged();
        super.onActivityResult(requestCode, resultCode, data);
    }
}
