package com.example.stackview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StackView stackView;
    private Button btn_prev;
    private Button btn_next;

    private final int[] flag = {R.drawable.us, R.drawable.australia, R.drawable.china,
            R.drawable.india, R.drawable.nz, R.drawable.portugal};
    private final String[] countries = {"USA", "Australia", "China",
            "India", "NZ", "Portugal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        List<StackItem> items = new ArrayList<>();
        for (int i = 0; i < countries.length; i++) {
            items.add(new StackItem(countries[i], flag[i]));
        }

        StackAdapter adapter = new StackAdapter(this, R.layout.stack_item, items);
        stackView.setAdapter(adapter);
        stackView.setHorizontalScrollBarEnabled(true);

        setEvent();
    }

    private void setEvent() {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackView.showNext();
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackView.showPrevious();
            }
        });
    }

    private void mapping() {
        stackView = findViewById(R.id.stackView);
        btn_next = findViewById(R.id.btn_next);
        btn_prev = findViewById(R.id.btn_prev);
    }
}