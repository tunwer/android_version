package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_product_main;
    EditText edit_count;
    TextView txt_total, txt_delivery, txt_pay;
    CheckBox chk_agree;

    int value_total = 0;
    int value_delivery = 2500;
    int value_pay = 0;

    int selected_price = 1500;
    int selected_count = 0;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_product_main = findViewById(R.id.img_product_main);
        edit_count = findViewById(R.id.edit_count);
        txt_total = findViewById(R.id.txt_total);
        txt_delivery = findViewById(R.id.txt_delivery);
        txt_pay = findViewById(R.id.txt_pay);
        chk_agree = findViewById(R.id.chk_agree);

        findViewById(R.id.radio1).setOnClickListener(this);
        findViewById(R.id.radio2).setOnClickListener(this);
        findViewById(R.id.radio3).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_pay).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.radio1:
                img_product_main.setImageResource(R.drawable.product1);
                selected_price = 1500;
                total();
                break;

            case R.id.radio2:
                img_product_main.setImageResource(R.drawable.product2);
                selected_price = 2000;
                total();
                break;

            case R.id.radio3:
                img_product_main.setImageResource(R.drawable.product3);
                selected_price = 3000;
                total();
                break;

            case R.id.btn_minus:
                count = Integer.parseInt(edit_count.getText().toString());
                if (count == 1){
                    Toast.makeText(this, "최소 수량은 1입니다!", Toast.LENGTH_SHORT).show();
                }else{
                    edit_count.setText(Integer.toString(count - 1));
                }
                total();
                break;

            case R.id.btn_plus:
                count = Integer.parseInt(edit_count.getText().toString());
                edit_count.setText(Integer.toString(count + 1));
                total();
                break;

            case R.id.btn_pay:
                if (chk_agree.isChecked()){
                    Intent i = new Intent(MainActivity.this,SubActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(this, "약관을 확인해주세요", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public void total(){
        selected_count = Integer.parseInt(edit_count.getText().toString());
        value_total = selected_count * selected_price;
        if(value_total >= 10000)
            value_delivery = 0;
        else
            value_delivery = 2500;
        value_pay = value_delivery + value_total;

        txt_pay.setText(value_pay+"원");
        txt_delivery.setText(value_delivery+"원");
        txt_total.setText(value_total+"원");
    }
}