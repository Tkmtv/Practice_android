package com.example.tablengrid;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView Lbl_fml;
    private EditText Edt_res;
    private Button Btn_add;
    private Button Btn_sub;
    private Button Btn_mul;
    private Button Btn_div;
    private Button Btn_eq;
    private Button Btn_bruh;
    private Button Btn_ac;
    private Button Btn_del;
    private Button Btn_zero;
    private Button Btn_one;
    private Button Btn_two;
    private Button Btn_three;
    private Button Btn_four;
    private Button Btn_five;
    private Button Btn_six;
    private Button Btn_seven;
    private Button Btn_eight;
    private Button Btn_nine;
    private Button Btn_dot;
    private double temp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_table);
        mapping();
    }

    public void mapping() {

        Lbl_fml = (TextView) findViewById(R.id.lbl_fml);

        Edt_res = (EditText) findViewById(R.id.edt_res);
        this.Edt_res.setSelection(Edt_res.getText().length());

        Btn_add = (Button) findViewById(R.id.btn_add);
        Btn_sub = (Button) findViewById(R.id.btn_sub);
        Btn_mul = (Button) findViewById(R.id.btn_mul);
        Btn_div = (Button) findViewById(R.id.btn_div);
        Btn_eq = (Button) findViewById(R.id.btn_eq);
        Btn_bruh = (Button) findViewById(R.id.btn_bruh);
        Btn_ac = (Button) findViewById(R.id.btn_ac);
        Btn_del = (Button) findViewById(R.id.btn_del);
        Btn_zero = (Button) findViewById(R.id.btn_zero);
        Btn_one = (Button) findViewById(R.id.btn_one);
        Btn_two = (Button) findViewById(R.id.btn_two);
        Btn_three = (Button) findViewById(R.id.btn_three);
        Btn_four = (Button) findViewById(R.id.btn_four);
        Btn_five = (Button) findViewById(R.id.btn_five);
        Btn_six = (Button) findViewById(R.id.btn_six);
        Btn_seven = (Button) findViewById(R.id.btn_seven);
        Btn_eight = (Button) findViewById(R.id.btn_eight);
        Btn_nine = (Button) findViewById(R.id.btn_nine);
        Btn_dot = (Button) findViewById(R.id.btn_dot);
        for (Button button : Arrays.asList(Btn_add, Btn_sub, Btn_mul, Btn_div, Btn_eq, Btn_bruh, Btn_ac, Btn_del, Btn_zero, Btn_one, Btn_two, Btn_three, Btn_four, Btn_five, Btn_six, Btn_seven, Btn_eight, Btn_nine, Btn_dot)) {
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                setDisplayNumber("+");
                break;
            case R.id.btn_sub:
                setDisplayNumber("-");
                break;
            case R.id.btn_mul:
                setDisplayNumber("*");
                break;
            case R.id.btn_div:
                setDisplayNumber("/");
                break;
            case R.id.btn_eq:
                calculate();
                break;
            case R.id.btn_bruh:
                setDisplayNumber("+/-");
                break;
            case R.id.btn_ac:
                this.Edt_res.setText("");
                this.Lbl_fml.setText("");
                break;
            case R.id.btn_del:
                deleteNum();
                break;
            case R.id.btn_zero:
                setDisplayNumber("0");
                break;
            case R.id.btn_one:
                setDisplayNumber("1");
                break;
            case R.id.btn_two:
                setDisplayNumber("2");
                break;
            case R.id.btn_three:
                setDisplayNumber("3");
                break;
            case R.id.btn_four:
                setDisplayNumber("4");
                break;
            case R.id.btn_five:
                setDisplayNumber("5");
                break;
            case R.id.btn_six:
                setDisplayNumber("6");
                break;
            case R.id.btn_seven:
                setDisplayNumber("7");
                break;
            case R.id.btn_eight:
                setDisplayNumber("8");
                break;
            case R.id.btn_nine:
                setDisplayNumber("9");
                break;
            case R.id.btn_dot:
                setDisplayNumber(".");
                break;
            default:
                break;
        }
    }

    private void add() {
        try {
            temp += Double.parseDouble(String.valueOf(Edt_res.getText()));
            Lbl_fml.setText(String.valueOf(temp));

        } catch (Exception e) {
            Edt_res.setText(e.getMessage());
        }

    }

    private void sub() {

    }

    private void multiply() {

    }

    private void divide() {

    }

    private void calculate() {
        String res = String.valueOf(Edt_res.getText());
        char sign = res.charAt(res.length()-1);
        switch (sign) {
            case '+':


        }
        this.Lbl_fml.setText(Edt_res.getText());
        this.Edt_res.setText("the result is I dunno");
        this.Edt_res.setSelection(Edt_res.getText().length());
    }

    private void deleteNum() {
        String exists = String.valueOf(this.Edt_res.getText());

        int pos = Edt_res.getSelectionStart();

        System.out.println(pos);

        String left = exists.substring(0, pos - 1);
        if (pos != exists.length()) {
            String right = exists.substring(pos + 1, exists.length()-1);
            String fin = left + right;
        }
        String fin = left;
        Edt_res.setText(fin);
        this.Edt_res.setSelection(Edt_res.getText().length());
    }

    public void setDisplayNumber(String n) {
//        System.out.println(this.Edt_res.getText());
        String exists = String.valueOf(this.Edt_res.getText());
        exists += n;
        this.Edt_res.setText(exists);
        this.Edt_res.setSelection(Edt_res.getText().length());
    }
}
