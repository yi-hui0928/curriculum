package com.example.curriculum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btn1_8,btn2_8,btn3_8,btn4_8,btn5_8,
            btn1_9,btn2_9,btn3_9,btn4_9,btn5_9,
            btn1_10,btn2_10,btn3_10,btn4_10,btn5_10,
            btn1_11,btn2_11,btn3_11,btn4_11,btn5_11,
            btn1_13,btn2_13,btn3_13,btn4_13,btn5_13,
            btn1_14,btn2_14,btn3_14,btn4_14,btn5_14,
            btn1_15,btn2_15,btn3_15,btn4_15,btn5_15,
            btn1_16,btn2_16,btn3_16,btn4_16,btn5_16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn1_8=(Button)findViewById(R.id.btn1_8);
        btn2_8=(Button)findViewById(R.id.btn2_8);
        btn3_8=(Button)findViewById(R.id.btn3_8);
        btn4_8=(Button)findViewById(R.id.btn4_8);
        btn5_8=(Button)findViewById(R.id.btn5_8);
        btn1_9=(Button)findViewById(R.id.btn1_9);
        btn2_9=(Button)findViewById(R.id.btn2_9);
        btn3_9=(Button)findViewById(R.id.btn3_9);
        btn4_9=(Button)findViewById(R.id.btn4_9);
        btn5_9=(Button)findViewById(R.id.btn5_9);
        btn1_10=(Button)findViewById(R.id.btn1_10);
        btn2_10=(Button)findViewById(R.id.btn2_10);
        btn3_10=(Button)findViewById(R.id.btn3_10);
        btn4_10=(Button)findViewById(R.id.btn4_10);
        btn5_10=(Button)findViewById(R.id.btn5_10);
        btn1_11=(Button)findViewById(R.id.btn1_11);
        btn2_11=(Button)findViewById(R.id.btn2_11);
        btn3_11=(Button)findViewById(R.id.btn3_11);
        btn4_11=(Button)findViewById(R.id.btn4_11);
        btn5_11=(Button)findViewById(R.id.btn5_11);
        btn1_13=(Button)findViewById(R.id.btn1_13);
        btn2_13=(Button)findViewById(R.id.btn2_13);
        btn3_13=(Button)findViewById(R.id.btn3_13);
        btn4_13=(Button)findViewById(R.id.btn4_13);
        btn5_13=(Button)findViewById(R.id.btn5_13);
        btn1_14=(Button)findViewById(R.id.btn1_14);
        btn2_14=(Button)findViewById(R.id.btn2_14);
        btn3_14=(Button)findViewById(R.id.btn3_14);
        btn4_14=(Button)findViewById(R.id.btn4_14);
        btn5_14=(Button)findViewById(R.id.btn5_14);
        btn1_15=(Button)findViewById(R.id.btn1_15);
        btn2_15=(Button)findViewById(R.id.btn2_15);
        btn3_15=(Button)findViewById(R.id.btn3_15);
        btn4_15=(Button)findViewById(R.id.btn4_15);
        btn5_15=(Button)findViewById(R.id.btn5_15);
        btn1_16=(Button)findViewById(R.id.btn1_16);
        btn2_16=(Button)findViewById(R.id.btn2_16);
        btn3_16=(Button)findViewById(R.id.btn3_16);
        btn4_16=(Button)findViewById(R.id.btn4_16);
        btn5_16=(Button)findViewById(R.id.btn5_16);

        btn1_8.setOnClickListener(listener);
        btn2_8.setOnClickListener(listener);
        btn3_8.setOnClickListener(listener);
        btn4_8.setOnClickListener(listener);
        btn5_8.setOnClickListener(listener);
        btn1_9.setOnClickListener(listener);
        btn2_9.setOnClickListener(listener);
        btn3_9.setOnClickListener(listener);
        btn4_9.setOnClickListener(listener);
        btn5_9.setOnClickListener(listener);
        btn1_10.setOnClickListener(listener);
        btn2_10.setOnClickListener(listener);
        btn3_10.setOnClickListener(listener);
        btn4_10.setOnClickListener(listener);
        btn5_10.setOnClickListener(listener);
        btn1_11.setOnClickListener(listener);
        btn2_11.setOnClickListener(listener);
        btn3_11.setOnClickListener(listener);
        btn4_11.setOnClickListener(listener);
        btn5_11.setOnClickListener(listener);
        btn1_13.setOnClickListener(listener);
        btn2_13.setOnClickListener(listener);
        btn3_13.setOnClickListener(listener);
        btn4_13.setOnClickListener(listener);
        btn5_13.setOnClickListener(listener);
        btn1_14.setOnClickListener(listener);
        btn2_14.setOnClickListener(listener);
        btn3_14.setOnClickListener(listener);
        btn4_14.setOnClickListener(listener);
        btn5_14.setOnClickListener(listener);
        btn1_15.setOnClickListener(listener);
        btn2_15.setOnClickListener(listener);
        btn3_15.setOnClickListener(listener);
        btn4_15.setOnClickListener(listener);
        btn5_15.setOnClickListener(listener);
        btn1_16.setOnClickListener(listener);
        btn2_16.setOnClickListener(listener);
        btn3_16.setOnClickListener(listener);
        btn4_16.setOnClickListener(listener);
        btn5_16.setOnClickListener(listener);


    }
    private Button.OnClickListener listener=new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

            Intent intent=new Intent();
            intent.setClass(MainActivity.this,SetChoice.class);
            startActivity(intent);

        }
    };
}