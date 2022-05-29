package com.example.flowerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

//    EditText Edit_name;
//    Button Btn_sayHello;

    EditText Edit_numA;
    EditText Edit_numB;
    TextView Lbl_res;
    Button Btn_sum;
    Button Btn_sub;
    Button Btn_mul;
    Button Btn_div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_test);
        //mapping();
    }

//        Btn_sayHello.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s = "Hello ";
//                s += Edit_name.getText();
//                //Toast.makeText(MainActivity.this, s.toString(), Toast.LENGTH_LONG).show();
//                View contextView = findViewById(R.id.view);
//                Snackbar.make(contextView, s.toString(), Snackbar.LENGTH_INDEFINITE)
//                        .show();
//            }
//        });

//        Btn_sum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    double a = Double.parseDouble(String.valueOf(Edit_numA.getText()));
//                    double b = Double.parseDouble(String.valueOf(Edit_numB.getText()));
//                    Lbl_res.setText(String.valueOf(a + b));
//                } catch (Exception e) {
//                    Lbl_res.setText(e.getMessage());
//                }
//            }
//        });
//
//        Btn_sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    double a = Double.parseDouble(String.valueOf(Edit_numA.getText()));
//                    double b = Double.parseDouble(String.valueOf(Edit_numB.getText()));
//                    Lbl_res.setText(String.valueOf(a - b));
//                } catch (Exception e) {
//                    Lbl_res.setText(e.getMessage());
//                }
//            }
//        });
//
//        Btn_mul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    double a = Double.parseDouble(String.valueOf(Edit_numA.getText()));
//                    double b = Double.parseDouble(String.valueOf(Edit_numB.getText()));
//                    Lbl_res.setText(String.valueOf(a * b));
//                } catch (Exception e) {
//                    Lbl_res.setText(e.getMessage());
//                }
//            }
//        });
//
//        Btn_div.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    double a = Double.parseDouble(String.valueOf(Edit_numA.getText()));
//                    double b = Double.parseDouble(String.valueOf(Edit_numB.getText()));
//                    if (b == 0) {
//                        Lbl_res.setText("Error: divide by 0");
//                    } else {
//                        Lbl_res.setText(String.valueOf(a / b));
//                    }
//                } catch (Exception e) {
//                    Lbl_res.setText(e.getMessage());
//                }
//
//            }
//        });
//
//
//    }
//
//    public void mapping() {
////        Edit_name = (EditText) findViewById(R.id.edt_name);
////        Btn_sayHello = (Button) findViewById(R.id.btn_sayhello);
//
//        Edit_numA = (EditText) findViewById(R.id.edt_a);
//        Edit_numB = (EditText) findViewById(R.id.edt_b);
//        Btn_sum = (Button) findViewById(R.id.btn_sum);
//        Btn_sub = (Button) findViewById(R.id.btn_sub);
//        Btn_mul = (Button) findViewById(R.id.btn_mul);
//        Btn_div = (Button) findViewById(R.id.btn_div);
//
//        Lbl_res = (TextView) findViewById(R.id.lbl_res);
//    }

}