package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Food extends AppCompatActivity {
    ListView listView;
    DatabaseOperaion db;
    Food_Adapter contactAdapter,contactAdapter2,contactAdapter3,contactAdapter4;
    TextView textView;
    EditText editText;
    Button button;
    RadioButton all,brecfast,lunch,dener;
    ArrayList<Food_Food> contacts,contacts2,contacts3,contacts4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        textView=findViewById(R.id.t);
        editText=findViewById(R.id.t);
        button=findViewById(R.id.b);
        all=findViewById(R.id.all);
        brecfast=findViewById(R.id.brecfast);
        lunch=findViewById(R.id.lunch);
        dener=findViewById(R.id.denar);

        try {
            listView =  findViewById(R.id.listfood);
            db = DatabaseOperaion.getInstanss(this);
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
        }

        /*ٌRadioButton Checked*/
        contacts = db.getAllContentFood();
        contactAdapter = new Food_Adapter(this, R.layout.fooditem, contacts);


        all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    contacts = db.getAllContentFood();
                    contactAdapter = new Food_Adapter(getApplicationContext(), R.layout.fooditem, contacts);
                    listView.setAdapter(contactAdapter);
                }
            }
        });

        brecfast.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    contacts2 = db.getAllContentFoodByCalssbrecf();
                    contactAdapter2 = new Food_Adapter(getApplicationContext(), R.layout.fooditem, contacts2);
                    listView.setAdapter(contactAdapter2);
                }
            }
        });
        lunch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    contacts3 = db.getAllContentFoodByCalsslunch();
                    contactAdapter3 = new Food_Adapter(getApplicationContext(), R.layout.fooditem, contacts3);
                    listView.setAdapter(contactAdapter3);
                }
            }
        });
        dener.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    contacts4 = db.getAllContentFoodByCalssdener();
                    contactAdapter4 = new Food_Adapter(getApplicationContext(), R.layout.fooditem, contacts4);
                    listView.setAdapter(contactAdapter4);
                }
            }
        });
        /*****************/


      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
                  ArrayList<Food_Food> contacts1 = db.getItemByNameFood(textView.getText().toString());
                 Food_Adapter contactAdapter1 = new Food_Adapter(getApplicationContext(), R.layout.fooditem, contacts1);

              if(!contacts1.isEmpty()) {

                  listView.setAdapter(contactAdapter1);
                  Toast.makeText(getApplicationContext(),"تم ايجاد الوصفة",Toast.LENGTH_LONG).show();

              }else {
                  listView.setAdapter(contactAdapter);
                  Toast.makeText(getApplicationContext(),"لم يتم ايجاد الوصفة",Toast.LENGTH_LONG).show();
              }

          }
      });
/*ارسال idلعرض التفاصيل*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Food_Food selected_food = (Food_Food) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), ShowFood.class);
                intent.putExtra("id", selected_food.getId());
                startActivity(intent);

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        contactAdapter = new Food_Adapter(this, R.layout.fooditem, contacts);
        listView.setAdapter(contactAdapter);



    }

}



