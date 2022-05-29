package com.example.contextmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddSubjectActivity extends Activity {
    private EditText edtName;
    private Button btnSave;
    private int cmd;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject);
        mapping();

        Intent callerIntent = getIntent();
        Bundle packet = callerIntent.getBundleExtra("MyPacket");
        cmd = packet.getInt("cmd");
        if (cmd == MainActivity.REQUEST_CODE_EDIT) {
            edtName.setText(packet.getString("name"));
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = edtName.getText().toString().trim();
                if (cmd == MainActivity.REQUEST_CODE_ADD) {
                    if (name.equals("")) {
                        sendToMain(MainActivity.RESULT_CODE_ADD_FAIL);
                    } else {
                        sendToMain(MainActivity.RESULT_CODE_ADD_SUCCESS);
                    }
                }
                if (cmd == MainActivity.REQUEST_CODE_EDIT) {
                    if (name.equals("")) {
                        sendToMain(MainActivity.RESULT_CODE_EDIT_FAIL);
                    } else {
                        sendToMain(MainActivity.RESULT_CODE_EDIT_SUCCESS);
                    }
                }
            }
        });
    }

    private void mapping() {
        edtName = findViewById(R.id.edt_sbName);
        btnSave = findViewById(R.id.btn_submit);
    }


    public void sendToMain(int resultCode) {
        Intent intent = getIntent();
        intent.putExtra("data", name);
        setResult(resultCode, intent);
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
