package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button btnBack;
    TextView lblRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mapping();
//        get intent
        Intent callerIntent = getIntent();
//        get packet
        Bundle packetFromCaller = callerIntent.getBundleExtra("myPacket");

        calculate(packetFromCaller.getDouble("varA"),
                packetFromCaller.getDouble("varB"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right);
            }
        });
    }

    public void calculate(double a, double b) {
        if (a == 0 && b == 0) {
            lblRes.setText("Vô số nghiệm");
        } else if (a == 0 && b != 0) {
            lblRes.setText("Vô số nghiệm");
        } else {
            double result = -b / a;
            lblRes.setText(String.valueOf(result));
        }
    }

    public void mapping() {
        btnBack = findViewById(R.id.btn_back);
        lblRes = findViewById(R.id.lbl_res);
    }
}