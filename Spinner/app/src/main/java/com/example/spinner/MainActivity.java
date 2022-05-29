package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    String[] countryNames = {"Desc", "Asc"};
    int[] flags = {R.drawable.ic_baseline_keyboard_arrow_down_24, R.drawable.ic_baseline_keyboard_arrow_up_24};

    Spinner spin;
    ListView lv_employee;
    MyAdapter adapter;
    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_custom);
        mapping();

        employees.add(new Employee("001", "ArwerwBC", false));
        employees.add(new Employee("002", "BrwEwerwerwC", true));
        employees.add(new Employee("003", "DwrwrVC", false));
        employees.add(new Employee("004", "rwer", false));
        employees.add(new Employee("005", "BwrwerwAG", true));
        employees.add(new Employee("006", "Drwrr65", false));
        employees.add(new Employee("007", "arwedada", false));
        employees.add(new Employee("008", "daewtt", true));
        employees.add(new Employee("009", "DwrVC", false));
        employees.add(new Employee("010", "ABrwerwC", false));
        employees.add(new Employee("011", "BrwerwEC", true));
        employees.add(new Employee("012", "DVwrweC", false));
//        create adapter
        adapter = new MyAdapter(MainActivity.this, employees);
//        add adapter to listview
        lv_employee.setAdapter(adapter);

        CustomerAdapter customerAdapter = new CustomerAdapter(getApplicationContext(), flags, countryNames);
        spin.setAdapter(customerAdapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (countryNames[position].equals("Asc")) {
                    Toast.makeText(MainActivity.this, countryNames[position], Toast.LENGTH_SHORT).show();
                    sortAsc();
                } else {
                    sortDecs();
                    Toast.makeText(MainActivity.this, countryNames[position], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void sortAsc() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int cmp = o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
                return cmp;
            }
        });
        adapter.notifyDataSetChanged();
    }

    private void sortDecs() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int cmp = o2.getName().toLowerCase().compareTo(o1.getName().toLowerCase());
                return cmp;
            }
        });
        adapter.notifyDataSetChanged();
    }


    private void mapping() {
        lv_employee = findViewById(R.id.lv_ems);
        spin = findViewById(R.id.spinner);
    }
}