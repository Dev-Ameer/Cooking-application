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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Candy extends AppCompatActivity {
    ListView listCandy;
    DatabaseOperaion db;
    Food_Adapter contactAdapter;
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candy);
        textView=findViewById(R.id.t);
        editText=findViewById(R.id.t);
        button=findViewById(R.id.b);

        try {
            listCandy = (ListView) findViewById(R.id.listcandy);
            db = DatabaseOperaion.getInstanss(this);
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
        }

        ArrayList<Food_Food> contacts = db.getAllContentCandy();

         contactAdapter = new Food_Adapter(this, R.layout.fooditem, contacts);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Food_Food> contacts1 = db.getItemByNameCandy(textView.getText().toString());
                Food_Adapter contactAdapter1 = new Food_Adapter(getApplicationContext(), R.layout.fooditem, contacts1);

                if(!contacts1.isEmpty()) {

                    listCandy.setAdapter(contactAdapter1);
                    Toast.makeText(getApplicationContext(),"تم ايجاد الوصفة",Toast.LENGTH_LONG).show();
                }else {
                    listCandy.setAdapter(contactAdapter);
                    Toast.makeText(getApplicationContext(),"لم يتم ايجاد الوصفة",Toast.LENGTH_LONG).show();
                }

            }
        });

        listCandy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Food_Food selected_food = (Food_Food) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), CandyShow.class);
                intent.putExtra("id", selected_food.getId());
                startActivity(intent);

            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
        try {
            listCandy.setAdapter(contactAdapter);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
        }


    }
}
