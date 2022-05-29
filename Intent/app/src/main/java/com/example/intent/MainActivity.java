package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnResult;
    EditText edtA;
    EditText edtB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(edtA.getText().toString());
                    double b = Double.parseDouble(edtB.getText().toString());
                    sendIntent(a, b);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Empty input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void sendIntent(double a, double b) {
        Intent myIntent = new Intent(this, ResultActivity.class);
        Bundle myBundle = new Bundle();

        myBundle.putDouble("varA", a);
        myBundle.putDouble("varB", b);
        myIntent.putExtra("myPacket", myBundle);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right);
    }

    public void mapping() {
        btnResult = findViewById(R.id.btn_result);
        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);
    }
}