package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Search_Candy_integ extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15;
    Button shrch;
    DatabaseOperaion db;
    Food_Rull fr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__candy_integ);
   Toast.makeText(getApplicationContext(),"ادخل 3 مكونات على الاقل...",Toast.LENGTH_LONG).show();
        db = DatabaseOperaion.getInstanss(this);
        e1=findViewById(R.id.c1);
        e2=findViewById(R.id.c2);
        e3=findViewById(R.id.c3);
        e4=findViewById(R.id.c4);
        e5=findViewById(R.id.c5);
        e6=findViewById(R.id.c6);
        e7=findViewById(R.id.c7);
        e8=findViewById(R.id.c8);
        e9=findViewById(R.id.c9);
        e10=findViewById(R.id.c10);
        e11=findViewById(R.id.c11);
        e12=findViewById(R.id.c12);
        e13=findViewById(R.id.c13);
        e14=findViewById(R.id.c14);
        e15=findViewById(R.id.c15);
        shrch=findViewById(R.id.cserch);

        shrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),fr.getE1()+"",Toast.LENGTH_LONG).show();
                try {
                    fr = new Food_Rull();
                    fr.setE1(e1.getText().toString());
                    fr.setE2(e2.getText().toString());
                    fr.setE3(e3.getText().toString());
                    fr.setE4(e4.getText().toString());
                    fr.setE5(e5.getText().toString());
                    fr.setE6(e6.getText().toString());
                    fr.setE7(e7.getText().toString());
                    fr.setE8(e8.getText().toString());
                    fr.setE9(e9.getText().toString());
                    fr.setE10(e10.getText().toString());
                    fr.setE11(e11.getText().toString());
                    fr.setE12(e12.getText().toString());
                    fr.setE13(e13.getText().toString());
                    fr.setE14(e14.getText().toString());
                    fr.setE15(e15.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), Berfor_Serch_Candy.class);
                    intent.putExtra("fr",fr);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
                }


            }
        });



    }
}