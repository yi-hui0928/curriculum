package com.example.curriculum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SetChoice extends AppCompatActivity {
    private Button btnRequest;
    private Spinner spnClass;
    String sel;
    String[] classes=new String[]{"資管系必修","資管系選修","人文領域","生命領域","社會領域","自然領域","微型課程"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chose);

        spnClass=(Spinner)findViewById(R.id.spnClass);
        btnRequest=(Button)findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(btnRequestListener);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,classes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnClass.setAdapter(adapter);
        spnClass.setOnItemSelectedListener(spnClassListener);
    }
    private Spinner.OnItemSelectedListener spnClassListener=new Spinner.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sel=parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //TODO Auto-generated method stub
        }
    };
    private Button.OnClickListener btnRequestListener=new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(SetChoice.this,SelectClass.class);

            Bundle bundle=new Bundle();
            bundle.putString("SEL",sel);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    };
}
