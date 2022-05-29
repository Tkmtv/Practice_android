package com.example.basiccontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Edt_uname;
    private EditText Edt_pwd;
    private RadioGroup Rd_grp;
    private RadioButton radioButton;
    private CheckBox Ck_agree;
    private Button Btn_submit;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        Ck_agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!Ck_agree.isChecked()) {
                    Btn_submit.setVisibility(View.INVISIBLE);
                } else {
                    Btn_submit.setVisibility(View.VISIBLE);
                }
            }
        });

        Rd_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = findViewById(Rd_grp.getCheckedRadioButtonId());
                showNoti((String) radioButton.getText());
            }
        });

        Btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String s = "Your account \n";
                    s += "Account name: " + Edt_uname.getText().toString() + "\n";
                    s += "Account password: " + Edt_pwd.getText().toString() + "\n";
                    s += "Account type: " + radioButton.getText().toString();
                    showNoti(s);
                }
            }
        });
    }

    public void mapping() {
        Edt_uname = findViewById(R.id.edt_name);
        Edt_pwd = findViewById(R.id.edt_pwd);
        Ck_agree = findViewById(R.id.ck_agree);
        Rd_grp = findViewById(R.id.rdg);
        Btn_submit = findViewById(R.id.btn_submit);
    }

    public boolean validate() {
        if (Edt_uname.getText().toString().length() == 0) {
            showNoti("You haven't input your name");
            return false;
        }
        if (Edt_pwd.getText().toString().length() == 0) {
            showNoti("You haven't input your password");
            return false;
        }
        if (Rd_grp.getCheckedRadioButtonId() == -1) {
            showNoti("You haven't select account type");
            return false;
        }
        if (!Ck_agree.isChecked()) {
            showNoti("You haven't agree");
            return false;
        }
        return true;
    }

    public void showNoti(String s) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG);
        toast.show();
    }
}