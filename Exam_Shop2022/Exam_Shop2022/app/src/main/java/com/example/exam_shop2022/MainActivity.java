package com.example.exam_shop2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int pay = 0;
    int amount = 0;
    int price = 1500;

    EditText edit_count;

    TextView txt_price;
    TextView txt_delivery;
    TextView txt_pay;

    CheckBox chk_agree;

    ImageView img_product_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_count = findViewById(R.id.edit_count);
        txt_price = findViewById(R.id.txt_price);
        txt_delivery = findViewById(R.id.txt_delivery);
        txt_pay = findViewById(R.id.txt_pay);
        chk_agree = findViewById(R.id.chk_agree);
        img_product_main = findViewById(R.id.img_product_main);

        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.radio1).setOnClickListener(this);
        findViewById(R.id.radio2).setOnClickListener(this);
        findViewById(R.id.radio3).setOnClickListener(this);
        findViewById(R.id.btn_pay).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        amount = Integer.parseInt(String.valueOf(edit_count.getText()));
        switch (v.getId()){
            case R.id.radio1:
                price = 1500;
                img_product_main.setImageResource(R.drawable.product1);
                total();
                break;

            case R.id.radio2:
                price = 2000;
                img_product_main.setImageResource(R.drawable.product2);
                total();
                break;

            case R.id.radio3:
                price = 3000;
                img_product_main.setImageResource(R.drawable.product3);
                total();
                break;

            case R.id.btn_minus:
                if (amount == 1) {
                    Toast.makeText(this, "최소 수량은 1개입니다!", Toast.LENGTH_SHORT).show();
                }else{
                    edit_count.setText(String.valueOf(--amount));
                    total();
                }
                break;

            case R.id.btn_plus:
                edit_count.setText(String.valueOf(++amount));
                total();
                break;

            case R.id.btn_pay:
                if (chk_agree.isChecked()){
                    Toast.makeText(this, pay+"원을 결제하셨습니다", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,SubActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(this, "결제 동의 버튼을 체크해주세요", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void total() {
        pay = price * amount;
        txt_price.setText(pay + "원");

        if (pay >= 10000){
            txt_delivery.setText("0원");
            txt_pay.setText(pay + "원");
        }else{
            txt_delivery.setText("2500원");
            pay += 2500;
            txt_pay.setText(pay + "원");
        }
    }
}