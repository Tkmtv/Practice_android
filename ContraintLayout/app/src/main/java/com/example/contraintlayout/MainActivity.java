package com.example.contraintlayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Edt_A;
    EditText Edt_B;
    Button Btn_sum;
    Button Btn_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_contraint);
        mapping();
        Btn_sum.setOnClickListener(view -> {
            String res;
            try {
                double a = Double.parseDouble(String.valueOf(Edt_A.getText()));
                double b = Double.parseDouble(String.valueOf(Edt_B.getText()));
                res = "KQ: " + (a + b);
            } catch (Exception e) {
                res = e.getMessage();
            }
            Toast toast = Toast.makeText(MainActivity.this, res, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        });

        Btn_exit.setOnClickListener(view -> {
            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
            ad.setTitle("Thông báo");
            ad.setMessage("Exit?");
            ad.setPositiveButton("Ok", (dialogInterface, i) -> finish());

            ad.setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.cancel());
            ad.create().show();
        });


    }

    public void mapping() {
        Edt_A = (EditText) findViewById(R.id.edt_A);
        Edt_B = (EditText) findViewById(R.id.edt_B);
        Btn_sum = (Button) findViewById(R.id.btn_sum);
        Btn_exit = (Button) findViewById(R.id.btn_exit);
    }
}