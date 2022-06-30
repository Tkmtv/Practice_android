package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUser, edtPwd;
    CheckBox ckRemmber;
    Button btnLogin;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USER_NAME = "user";
    String PASSWORD_KEY = "pass";

    private void mapping() {
        edtUser = findViewById(R.id.edt_uname);
        edtPwd = findViewById(R.id.edt_pwd);
        ckRemmber = findViewById(R.id.ck_remeber);
        btnLogin = findViewById(R.id.btn_submit);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        sharedPreferences = (SharedPreferences) getSharedPreferences("LoginShPr", MODE_PRIVATE);
        edtUser.setText(sharedPreferences.getString(USER_NAME, ""));
        edtPwd.setText(sharedPreferences.getString(PASSWORD_KEY, ""));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString().trim();
                String pwd = edtPwd.getText().toString();

                if (user.equals("teo") && pwd.equals("detail")) {
                    Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                    startReadAndWrite();
                    if (ckRemmber.isChecked()) {
                        editor = sharedPreferences.edit();
                        editor.putString(USER_NAME, user);
                        editor.putString(PASSWORD_KEY, pwd);
                        editor.commit();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startReadAndWrite() {
        Intent myIntent = new Intent(this, ReadAndWriteActivity.class);
        startActivity(myIntent);
    }
}