package com.example.simplebillcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import Model.Sale;

public class MainActivity extends AppCompatActivity {

    private EditText EdtName;
    private EditText EdtAmount;
    private CheckBox CkVip;
    private TextView LblBill;
    private Button BtnCal;
    private Button BtnNext;
    private Button BtnStat;
    private TextView LblCustomers;
    private TextView LblNoVip;
    private TextView LblSale;
    private ImageButton BtnExit;
    private boolean calFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        Sale sale = new Sale();

        BtnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    double res = sale.calBill(Integer.parseInt(String.valueOf(EdtAmount.getText())),
                            CkVip.isChecked());
                    LblBill.setText(String.valueOf(res));
                    calFlag = true;
                } else {
                    Toast.makeText(MainActivity.this, "Thông tin không đầy đủ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calFlag) {
                    String name = String.valueOf(EdtName.getText());
                    int amount = Integer.valueOf(String.valueOf(EdtAmount.getText()));
                    boolean isVip = CkVip.isChecked();
                    double bill = Double.valueOf(String.valueOf(LblBill.getText()));
                    sale.saveInfo(name, amount, isVip, bill);
                    Toast.makeText(MainActivity.this, "Thông tin khách hàng đã được lưu", Toast.LENGTH_SHORT).show();
                    EdtName.setText("");
                    EdtAmount.setText("");
                    CkVip.setChecked(false);
                    LblBill.setText("");
                    calFlag = false;
                } else {
                    Toast.makeText(MainActivity.this, "Bill chưa được tính", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BtnStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LblCustomers.setText(String.valueOf(sale.getTotalCustomers()));
                LblNoVip.setText(String.valueOf(sale.getNumberVIP()));
                LblSale.setText(String.valueOf(String.valueOf(sale.getTotalSale())));
            }
        });

        BtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo!");
                builder.setMessage("Bạn có muốn thoát không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
    }

    public void mapping() {
        EdtName = findViewById(R.id.edt_name);
        EdtAmount = findViewById(R.id.edt_amount);
        CkVip = findViewById(R.id.ck_vip);
        LblBill = findViewById(R.id.lbl_billNumber);
        BtnCal = findViewById(R.id.btn_cal);
        BtnNext = findViewById(R.id.btn_next);
        BtnStat = findViewById(R.id.btn_stat);
        LblCustomers = findViewById(R.id.lbl_sl_customers);
        LblNoVip = findViewById(R.id.lbl_sl_vip);
        LblSale = findViewById(R.id.lbl_sl_sale);
        BtnExit = findViewById(R.id.btn_exit);
    }

    public boolean validate() {
        if (String.valueOf(EdtName.getText()).equals("")) {
            return false;
        }
        if (String.valueOf(EdtAmount.getText()).equals("")) {
            return false;
        }
        return true;
    }
}