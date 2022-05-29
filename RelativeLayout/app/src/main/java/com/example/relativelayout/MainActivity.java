package com.example.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Edt_user, Edt_pwd;
    Button Btn_ok, Btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logtin_relative);
        mapping();
        Btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Edt_user.getText().toString().trim();
                String pwd = Edt_pwd.getText().toString().trim();
                if (user.compareTo("Teo")==0 && pwd.compareTo("123")==0 ) {
                    Toast.makeText(MainActivity.this, "Login successfull!!!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login failed!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edt_user.setText("");
                Edt_pwd.setText("");
            }
        });

    }

    public void mapping() {
        Edt_user = (EditText) findViewById(R.id.edt_uname);
        Edt_pwd = (EditText) findViewById(R.id.edt_pwd);
        Btn_ok = (Button) findViewById(R.id.btn_ok);
        Btn_cancel = (Button) findViewById(R.id.btn_cancel);
    }
}