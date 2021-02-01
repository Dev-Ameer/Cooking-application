package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayOutputStream;

import static com.example.project.R.color.colorAccent;

public class ShowFood extends AppCompatActivity {
    TextView foodtime,foodsur,foodcal,foodallintg,foodmm,index;
    androidx.appcompat.widget.Toolbar tolbarfood;
    ImageView pickImag;
    DatabaseOperaion db;
    byte[] image = null;
    int id;
    int i=0;
    FloatingActionButton favbuttn;
    Food_Food food_food;
    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_food);

        foodtime=findViewById(R.id.foodtime);
        foodsur=findViewById(R.id.foodsur);
        foodcal=findViewById(R.id.foodcal);
        foodallintg=findViewById(R.id.foodallintg);
        foodmm=findViewById(R.id.foodallmm);
        tolbarfood= findViewById(R.id.toolbarfood);
        pickImag=findViewById(R.id.imgfood);
        favbuttn=findViewById(R.id.favfood);
        index=findViewById(R.id.index);



        id = getIntent().getIntExtra("id", 0);
        db = DatabaseOperaion.getInstanss(this);
        try {
          food_food=db.getFoodByID(id);

        /*التفاصيل*/
        tolbarfood.setTitle(food_food.getName()+"");
        foodtime.setText(food_food.getTime());
        foodcal.setText(food_food.getCalories());
        foodsur.setText(food_food.getSource());
        foodallintg.setText(food_food.getIngredients());
        foodmm.setText(food_food.getPrepare());
        index.setText(food_food.getIndex());
        /*الصورة*/
        Bitmap bitmap = BitmapFactory.decodeByteArray(food_food.getImg(), 0, food_food.getImg().length);
        pickImag.setImageBitmap(bitmap);
        image = getBytes(bitmap);


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
        }


        favbuttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (food_food.getIndex().equals("0")){
                        db.UpdatIndexFoodById(id);
                        Snackbar.make(findViewById(android.R.id.content),"تم الاضافة في المفضلة",Snackbar.LENGTH_SHORT).show();
                    }

                    if(food_food.getIndex().equals("1")){
                        db.UpdatDelIndexFoodById(id);
                        Snackbar.make(findViewById(android.R.id.content),"تم الازالة من المفضلة",Snackbar.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
                }




            }
        });
    }
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

}