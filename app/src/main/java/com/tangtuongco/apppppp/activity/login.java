package com.tangtuongco.apppppp.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tangtuongco.apppppp.R;

public class login extends AppCompatActivity {

    EditText edtID,edtPASS;
    Button btnLogin;
    TextView txtID,txtPASS;
    String id="admin";
    String pass="admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        anhxa();
        //Exit from Second Activity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

    }

    private void login() {
        String user=edtID.getText().toString().trim();
        String password=edtPASS.getText().toString().trim();
        if(user.equals(id)&&password.equals(pass))
        {
            Toast.makeText(this, getString(R.string.logsuc), Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.warning))
                    .setMessage(getString(R.string.mess))
                    .setNegativeButton("OK",null)
                    .create().show();
        }

    }

    private void anhxa() {
        edtID = findViewById(R.id.edtID);
        edtPASS = findViewById(R.id.edtPASS);
        txtID=findViewById(R.id.txtID);
        txtPASS=findViewById(R.id.txtPASS);
        btnLogin=findViewById(R.id.btnLOGIN);

    }
}
