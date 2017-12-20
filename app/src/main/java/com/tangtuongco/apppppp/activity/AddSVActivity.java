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
import com.tangtuongco.apppppp.model.sinhvien;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddSVActivity extends AppCompatActivity {
    Button btnAdd,btnChon,btnChup;
    EditText edtName,edtCode,edtSdt,edtDC;
    ImageView imgAva;
    final int REQUEST_TAKE_PIC = 123;
    final int REQUEST_CHOOSE_PIC =321;
    sinhvien sv= new sinhvien();
    byte[] hinhanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sv);
        anhxa();
        control();
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
        btnAdd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              if (imgAva.getDrawable() == null) {
                  Toast.makeText(AddSVActivity.this, getString(R.string.nullll), Toast.LENGTH_SHORT).show();
              }
              if (edtCode.getText().toString().trim().length() <= 7) {
                  Toast.makeText(AddSVActivity.this, getString(R.string.idwarning), Toast.LENGTH_SHORT).show();
              } else {
                  sv.setTensv(edtName.getText().toString());
                  sv.setSdt(edtSdt.getText().toString());
                  sv.setDiachi(edtDC.getText().toString());
                  sv.setMasv(edtCode.getText().toString());


                  hinhanh = getByteArrayFromImageView(imgAva);
                  sv.setAvatar(hinhanh);
                  Toast.makeText(AddSVActivity.this, getString(R.string.addsc), Toast.LENGTH_SHORT).show();

                  Intent intent = new Intent();
                  intent.putExtra("1sv", sv);
                  setResult(111, intent);
                  finish();
              }
          }
      });
    }
    public String createID() {
        Date now = new Date();
        String id = (new SimpleDateFormat("ddMMyyHHmmss", Locale.US).format(now));
        return id;
    }

    private void anhxa() {
        btnAdd = findViewById(R.id.btnADDDDDDSV);
        btnChup=findViewById(R.id.btnChup);
        btnChon=findViewById(R.id.btnChon);
        edtName=findViewById(R.id.NameAdd);
        edtCode=findViewById(R.id.CodeAdd);
        edtDC=findViewById(R.id.DCAdd);
        edtSdt=findViewById(R.id.SdtADD);
        imgAva=findViewById(R.id.imageAvatar);
        String id= "SV"+createID();
        edtCode.setText(id);

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
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }

        return Bitmap.createScaledBitmap(image, width, height, true);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK)
        {
            if(requestCode==REQUEST_CHOOSE_PIC)
            {



                try {
                    Uri imageUri = data.getData();
                    InputStream is = null;
                    is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    imgAva.setImageBitmap(getResizedBitmap(bitmap,300));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
            else if (requestCode==REQUEST_TAKE_PIC)
            {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imgAva.setImageBitmap(bitmap);


            }
        }
    }
}
