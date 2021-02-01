package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fav_Food extends AppCompatActivity {
    ListView listView;
    DatabaseOperaion db;
   Food_Adapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav__food);
        listView=findViewById(R.id.fav_food);
        db = DatabaseOperaion.getInstanss(this);

        ArrayList<Food_Food> contacts = db.getAllContentFavFood();
        contactAdapter = new Food_Adapter(this, R.layout.fooditem, contacts);






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
    protected void onResume() {
        super.onResume();
        contactAdapter.notifyDataSetChanged();
        listView.setAdapter(contactAdapter);
    }
}