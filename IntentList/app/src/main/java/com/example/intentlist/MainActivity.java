package com.example.intentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_INPUT = 113;
    public static final int REQUEST_CODE_SAVE1 = 115;
    public static final int REQUEST_CODE_SAVE2 = 116;

    Button btnOpen;
    ListView lvData;
    ArrayList<Double> numbers = new ArrayList<>();
    ArrayAdapter<Double> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        setEvent();
        adapter = new ArrayAdapter<Double>(
                this, android.R.layout.simple_list_item_1, numbers
        );
        lvData.setAdapter(adapter);
    }

    public void setEvent() {
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputDataActivity.class);
                startActivityForResult(intent, REQUEST_CODE_INPUT);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case REQUEST_CODE_SAVE1:
                doubl e v1 = data.getDoubleExtra("data", 0);
                numbers.add(v1 * v1);
                adapter.notifyDataSetChanged();
                break;
            case REQUEST_CODE_SAVE2:
                double v2 = data.getDoubleExtra("data", 0);
                numbers.add(v2);
                adapter.notifyDataSetChanged();
                break;

        }
    }

    public void mapping() {
        btnOpen = findViewById(R.id.btn_open);
        lvData = findViewById(R.id.lv_data);
    }
}