package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Model.Employee;
import Model.EmployeeFullTime;
import Model.EmployeePartTime;

public class MainActivity extends AppCompatActivity {

    private ListView lvEms;
    private EditText EdtID;
    private EditText EdtName;
    private RadioGroup RdGrp;
    private RadioButton RdFull;
    private RadioButton RdPart;
    private Button BtnSubmit;
    private ArrayList<Employee> employees = null;
    ArrayAdapter<Employee> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        employees = new ArrayList<>();
        employees.add(new EmployeeFullTime(1, "ABC"));
        employees.add(new EmployeeFullTime(2, "ABD"));
        employees.add(new EmployeePartTime(3, "ABE"));

        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_multiple_choice,
                employees
        );

//        add adapter cho list view
        lvEms.setAdapter(adapter);
//        add event
        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = EdtID.getText().toString();
                String s = EdtName.getText().toString().trim();

                if (id.length() == 0) {
                    Toast.makeText(MainActivity.this, "ID không được trống", Toast.LENGTH_SHORT).show();
                    EdtID.requestFocus();
                    return;
                }
                if (s.length() == 0) {
                    Toast.makeText(MainActivity.this, "Tên không được trống", Toast.LENGTH_SHORT).show();
                    EdtName.requestFocus();
                    return;
                }
                if (RdFull.isChecked()) {
                    employees.add(new EmployeeFullTime(Integer.valueOf(id), s));
                } else if (RdPart.isChecked()) {
                    employees.add(new EmployeePartTime(Integer.valueOf(id), s));
                } else {
                    Toast.makeText(MainActivity.this, "Chọn loại nv", Toast.LENGTH_SHORT).show();
                    RdGrp.requestFocus();
                    return;
                }
                adapter.notifyDataSetChanged();
            }
        });

//        add click event
        lvEms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String val = String.valueOf(employees.get(position));
                String message = "Postion: " + position + " Value: " + val;
                Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT).show();

//                toggle checked
                CheckedTextView checkedTextView = ((CheckedTextView) view);
                checkedTextView.setChecked(!checkedTextView.isChecked());
            }
        });

        lvEms.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                employees.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public void mapping() {
        lvEms = findViewById(R.id.lv_ems);
        EdtID = findViewById(R.id.edt_id);
        EdtName = findViewById(R.id.edt_name);
        RdGrp = findViewById(R.id.rd_grp);
        RdFull = findViewById(R.id.rad_full);
        RdPart = findViewById(R.id.rad_part);
        BtnSubmit = findViewById(R.id.btn_submit);
    }
}