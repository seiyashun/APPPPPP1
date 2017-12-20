package com.tangtuongco.apppppp.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.ListView;
import android.widget.Toast;

import com.tangtuongco.apppppp.R;
import com.tangtuongco.apppppp.model.phongban;
import com.tangtuongco.apppppp.model.sinhvien;
import com.tangtuongco.apppppp.ulty.pbAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener  {
    pbAdapter pbAdapter;
    ListView listViewPB;
    ArrayList<sinhvien> arrayListSV = new ArrayList<>();
    ArrayList<sinhvien> arrayListSV2 = new ArrayList<>();
    ArrayList<phongban> arrayListPB = new ArrayList<>();
    static int vitri;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 Intent ThemPB = new Intent(MainActivity.this,AddPBActivity.class);
                   startActivityForResult(ThemPB,123);


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        anhxa();
        /*(sinhvien sv1 = new sinhvien("DH51400083","Tăng Tường Cơ",R.drawable.avaaa,"256 LBT","0933622770","Công Nghệ Thông Tin");
        arrayListSV.add(sv1);
        sinhvien sv2 = new sinhvien("DH514","Tăng Cơ",R.drawable.avaaa,"256 LBT","0933622770","Công Nghệ Thông Tin");
        arrayListSV2.add(sv2);
        phongban a = new phongban("Công Nghệ Thông Tin","CNTT",arrayListSV);
        phongban b = new phongban("Quản Trị Kinh Doanh","QTKD",arrayListSV2);
        arrayListPB.add(a);
        arrayListPB.add(b);*/
        CatchOnItem();

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(getApplicationContext(), login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if ( id==R.id.about)
        {
            Intent about = new Intent(MainActivity.this,About.class);

            startActivity(about);
        }
        else if(id==R.id.exittttttt)
        {
            //Exit from Second Activity
            Intent intent = new Intent(getApplicationContext(), login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.exit) {
            finish();
            System.exit(0);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public  void anhxa() {

        listViewPB = findViewById(R.id.lstPB);
        pbAdapter = new pbAdapter(arrayListPB,getApplicationContext());
        listViewPB.setAdapter(pbAdapter);


    }
    private void CatchOnItem() {
            listViewPB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   //Intent intentListSV = new Intent(MainActivity.this,sinhvienActivity2.class);
                   //intentListSV.putExtra("test",arrayListPB.get(i).getListsv());
                  // startActivityForResult(intentListSV,955);
                    phongban b = arrayListPB.get(i);
                    int index = i;
                    int flag =99;
                    Intent intentEdtPB = new Intent(MainActivity.this,sinhvienActivity2.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("datasv",b);
                    bundle.putInt("edtsvindex",index);
                    bundle.putInt("edtsvflag",flag);
                    intentEdtPB.putExtra("bundle",bundle);
                    startActivityForResult(intentEdtPB,955);


                }
            });
            listViewPB.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                    phongban b = arrayListPB.get(i);
                    int index = i;
                    int flag =99;
                    Intent intentEdtPB = new Intent(MainActivity.this,EditPBActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("edtpb",b);
                    bundle.putInt("edtpbindex",index);
                    bundle.putInt("edtpbflag",flag);
                    intentEdtPB.putExtra("bundle",bundle);
                    startActivityForResult(intentEdtPB,234);
                    return  true;
                }
            });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==123 && data !=null)
        {
            phongban a = (phongban) data.getSerializableExtra("lpb");
            int flagc=0;
            if(arrayListPB.size()==0)
            {
                arrayListPB.add(0,a);
            }
            else {
                for (int i = 0; i < arrayListPB.size(); i++) {
                    if (a.getMapb().equals(arrayListPB.get(i).getMapb())) {
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
                    arrayListPB.add(a);
                }
            }
        }
        if(requestCode==234 && data !=null)
        {
            Bundle bundle = data.getBundleExtra("bundletrave");
            int t = bundle.getInt("edtpbindextrave");
            int flag=bundle.getInt("edtpbflag");
            phongban a = (phongban) bundle.getSerializable("edtpbtrave");
            if(flag==0)
            {
                arrayListPB.remove(t);
            }
            else if(flag==1)
            {
                    arrayListPB.get(t).setTenpb(a.getTenpb().toString());
                    arrayListPB.get(t).setMapb(a.getMapb().toString());
            }
        }
        if(requestCode==955 && data !=null)
        {
           Bundle bundle = data.getBundleExtra("bundletrave");
           int t = bundle.getInt("edtsvindextrave");
           ArrayList<sinhvien> bbb = (ArrayList<sinhvien>) bundle.getSerializable("edtsvtrave");
           arrayListPB.get(t).setListsv(bbb);
        }
        pbAdapter.notifyDataSetChanged();
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        Log.d("aa","des");
        super.onDestroy();
    }
}
