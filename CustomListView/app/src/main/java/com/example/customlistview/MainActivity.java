package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Adapter.MyAdapter;
import Model.Employee;

public class MainActivity extends AppCompatActivity {

    EditText edt_id, edt_name;
    RadioGroup rd_grp;
    RadioButton rd_male, rd_female;
    Button btn_add, btn_del;
    ListView lv_employee;

    MyAdapter adapter;
    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        employees.add(new Employee("001", "ABC", false));
        employees.add(new Employee("002", "BEC", true));
        employees.add(new Employee("003", "DVC", false));

//        create adapter
        adapter = new MyAdapter(MainActivity.this, employees);
//        add adapter to listview
        lv_employee.setAdapter(adapter);

        addEvent();
    }

    private void addEvent() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
                sortAsc();
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDelete();
            }
        });
    }

    private void validateInput() {
        String id = edt_id.getText().toString().trim();
        if (id.length() == 0) {
            Toast.makeText(MainActivity.this, "ID empty", Toast.LENGTH_SHORT).show();
            edt_id.requestFocus();
            return;
        }
        if (findEmpID(id)) {
            Toast.makeText(MainActivity.this, "ID exit", Toast.LENGTH_SHORT).show();
            edt_id.requestFocus();
            return;
        }
        String name = edt_name.getText().toString().trim();
        if (name.length() == 0) {
            Toast.makeText(MainActivity.this, "Name empty", Toast.LENGTH_SHORT).show();
            edt_name.requestFocus();
            return;
        }

        if (!rd_female.isChecked() && !rd_male.isChecked()) {
            Toast.makeText(MainActivity.this, "Unknown gender", Toast.LENGTH_SHORT).show();
            rd_grp.requestFocus();
            return;
        }

        boolean gender = !rd_female.isChecked();
        Employee employee = new Employee(id, name, gender);
        employees.add(employee);
        adapter.notifyDataSetChanged();
        resetInput();
    }

    private void validateDelete() {
        for (int i = lv_employee.getChildCount() - 1; i >= 0; i--) {
            View v = lv_employee.getChildAt(i);
            CheckBox ck_del = v.findViewById(R.id.ck_sel);
            if (ck_del.isChecked()) {
                employees.remove(i);
                ck_del.setChecked(false);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void resetInput() {
        edt_id.setText("");
        edt_name.setText("");
        rd_male.setChecked(true);
        rd_female.setChecked(false);
        edt_id.requestFocus();
    }

    private boolean findEmpID(String id) {
        for (Employee e : employees) {
            if (e.getId().toString().trim().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private void sortAsc() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
//                int cmp = o1.getId().compareTo(o2.getId());
                int cmp = 0;
                if (cmp ==0) {
                    if (o1.isGender()) {
                        cmp = -1;
                    } else {
                        cmp = 1;
                    }
                }
                return cmp;
            }
        });
        adapter.notifyDataSetChanged();
    }


    private void mapping() {
        edt_id = findViewById(R.id.edt_id);
        edt_name = findViewById(R.id.edt_name);
        btn_add = findViewById(R.id.btn_submit);
        btn_del = findViewById(R.id.btn_del);
        rd_grp = findViewById(R.id.rd_grp);
        rd_male = findViewById(R.id.rad_male);
        rd_female = findViewById(R.id.rad_female);
        lv_employee = findViewById(R.id.lv_ems);
    }
}