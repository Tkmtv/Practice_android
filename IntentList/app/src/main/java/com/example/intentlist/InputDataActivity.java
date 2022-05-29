package com.example.intentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputDataActivity extends AppCompatActivity {
    Button btnSave1, btnSave2;
    EditText edtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        mapping();
        setEvent();
    }

    public void setEvent() {
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToMain(MainActivity.REQUEST_CODE_SAVE1);
            }
        });

        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToMain(MainActivity.REQUEST_CODE_SAVE2);
            }
        });
    }

    public void sendToMain(int resultCode) {
        try {
            Intent intent = getIntent();
            double value = Double.parseDouble(edtNumber.getText().toString());
            intent.putExtra("data", value);
            setResult(resultCode, intent);
            finish();
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        } catch (Exception e) {
            Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
        }
    }

    public void mapping() {
        btnSave1 = findViewById(R.id.btn_save1);
        btnSave2 = findViewById(R.id.btn_save2);
        edtNumber = findViewById(R.id.edtNum);
    }
}