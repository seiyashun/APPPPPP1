package com.tangtuongco.apppppp.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tangtuongco.apppppp.R;
import com.tangtuongco.apppppp.model.phongban;
import com.tangtuongco.apppppp.model.sinhvien;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class EditSinhVien extends AppCompatActivity {
    Button btnEdit,btnRemove,btnChon,btnChup;
    EditText edtName,edtCode,edtSdt,edtDC;
    ImageView imgAva;
    int flag=0;
    final int REQUEST_TAKE_PIC = 123;
    final int REQUEST_CHOOSE_PIC =321;
    sinhvien sv= new sinhvien();
    byte[] hinhanh;
    int INDEX=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sinh_vien);
        anhxa();
        getdata();
        control();
    }

    private void getdata() {
        Intent intent = getIntent();
        if(intent!=null)
        {
            Bundle bundle = intent.getBundleExtra("bundle");
            sinhvien a = (sinhvien) bundle.getSerializable("edtsvvv");
            INDEX = bundle.getInt("edtsvvvvvindex");
            flag = bundle.getInt("edtsvvvvvflag");
            edtName.setText(a.getTensv().toString());
            edtCode.setText(a.getMasv().toString());
            edtDC.setText(a.getDiachi().toString());
            edtSdt.setText(a.getSdt().toString());
            Bitmap bitmap = BitmapFactory.decodeByteArray(a.getAvatar(),0,a.getAvatar().length);
            imgAva.setImageBitmap(bitmap);

        }
    }

    private void control() {
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonpic();
            }
        });
        btnChup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takepic();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgAva.getDrawable()==null)
                {
                    Toast.makeText(EditSinhVien.this, getString(R.string.nullll), Toast.LENGTH_SHORT).show();
                }
                else
                {

                    sinhvien sv = new sinhvien();
                    sv.setTensv(edtName.getText().toString());
                    sv.setSdt(edtSdt.getText().toString());
                    sv.setDiachi(edtDC.getText().toString());
                    sv.setMasv(edtCode.getText().toString());
                    hinhanh = getByteArrayFromImageView(imgAva);
                    sv.setAvatar(hinhanh);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("edtsvvvvvvtrave",sv);
                    bundle.putInt("edtindexsvvvvvvtraveeeee",INDEX);
                    flag=1;
                    bundle.putInt("edtsvflagggg",flag);
                    intent.putExtra("bundletrave",bundle);;
                    setResult(222,intent);
                    finish();
                }
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhvien sv = new sinhvien();
                sv.setTensv(edtName.getText().toString());
                sv.setSdt(edtSdt.getText().toString());
                sv.setDiachi(edtDC.getText().toString());
                sv.setMasv(edtCode.getText().toString());
                hinhanh = getByteArrayFromImageView(imgAva);
                sv.setAvatar(hinhanh);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("edtsvvvvvvtrave",sv);
                bundle.putInt("edtindexsvvvvvvtraveeeee",INDEX);
                flag=0;
                bundle.putInt("edtsvflagggg",flag);
                intent.putExtra("bundletrave",bundle);;
                setResult(222,intent);
                finish();
            }
        });

    }

    private void anhxa() {
        btnEdit = findViewById(R.id.btnEdittttttt);
        btnChup=findViewById(R.id.btnChup1);
        btnChon=findViewById(R.id.btnChon1);
        edtName=findViewById(R.id.NameAdd1);
        edtCode=findViewById(R.id.CodeAdd1);
        edtDC=findViewById(R.id.DCAdd1);
        edtSdt=findViewById(R.id.SdtADD1);
        imgAva=findViewById(R.id.imageAvatar1);
        btnRemove=findViewById(R.id.btnRemoveeeeeeee);
    }
    private void takepic()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_TAKE_PIC);
    }
    private void chonpic()
    {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,REQUEST_CHOOSE_PIC);
    }
    private byte[] getByteArrayFromImageView(ImageView imgv){

        BitmapDrawable drawable = (BitmapDrawable) imgv.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK)
        {
            if(requestCode==REQUEST_CHOOSE_PIC)
            {
                Uri imageUri = data.getData();
                //InputStream is =getContentResolver().openInputStream(imageUri);
                //Bitmap bitmap = BitmapFactory.decodeStream(is);
                Picasso.with(getApplicationContext()).load(imageUri).into(imgAva);
            }
            else if (requestCode==REQUEST_TAKE_PIC)
            {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imgAva.setImageBitmap(bitmap);

            }
        }
    }
}
