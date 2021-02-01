package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class befor_serch_jucies extends AppCompatActivity {
    ListView listView;
    DatabaseOperaion db;
    ArrayList<Food_Rull> a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_befor_serch_jucies);
        listView=findViewById(R.id.listSerchjuce);
        db = DatabaseOperaion.getInstanss(this);

        try {
            Food_Rull fr=(Food_Rull) getIntent().getSerializableExtra("fr");
            a=db.locateJuice(fr);
            Food_Serch_Adapter FoodAdapter1 = new Food_Serch_Adapter(getApplicationContext(), R.layout.fooditem, a);
            listView.setAdapter(FoodAdapter1);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food_Rull selected_food = (Food_Rull) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), JuciesShow.class);
                intent.putExtra("id", selected_food.getId());
                startActivity(intent);

            }
        });


    }
}