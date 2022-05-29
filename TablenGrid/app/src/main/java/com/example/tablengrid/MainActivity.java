package com.example.tablengrid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Edt_url;
    Button Btn_Cancel;
    Button Btn_Ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_table);
//        mapping();
//        Btn_Cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.exit(1);
//            }
//        });
//
//        Btn_Ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String url = String.valueOf(Edt_url.getText());
//                if (!url.startsWith("http://") && !url.startsWith("https://"))
//                    url = "https://" + url;
//
//                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
//                startActivity(intent);
//            }
//        });
    }

//    public void mapping() {
//        Edt_url = (EditText) findViewById(R.id.edt_url);
//        Btn_Cancel = (Button) findViewById(R.id.btn_cancel);
//        Btn_Ok = (Button) findViewById(R.id.btn_ok);
//    }
}