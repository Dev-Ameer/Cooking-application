package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayOutputStream;

public class CandyShow extends AppCompatActivity {
    TextView candytime,candysur,candycal,candyallintg,candymm,index;
    androidx.appcompat.widget.Toolbar tolbarcandy;
    ImageView pickImag;
    DatabaseOperaion db;
    byte[] image = null;
    int id;
    Food_Food food_food;
    FloatingActionButton favbuttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candy_show);
        candytime=findViewById(R.id.candytime);
        candysur=findViewById(R.id.candysur);
        candycal=findViewById(R.id.candycal);
        candyallintg=findViewById(R.id.candyallintg);
        candymm=findViewById(R.id.candyallmm);
        tolbarcandy= findViewById(R.id.toolbarcandy);
        pickImag=findViewById(R.id.imgcandy);
        favbuttn=findViewById(R.id.favCandy);
        index=findViewById(R.id.index);


        id = getIntent().getIntExtra("id", 0);
        db = DatabaseOperaion.getInstanss(this);
        try {
           food_food=db.getCandyByID(id);



            /*التفاصيل*/
            tolbarcandy.setTitle(food_food.getName()+"");
            candytime.setText(food_food.getTime());
            candycal.setText(food_food.getCalories());
            candysur.setText(food_food.getSource());
            candyallintg.setText(food_food.getIngredients());
            candymm.setText(food_food.getPrepare());
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

                if (food_food.getIndex().equals("0")){
                    db.UpdatIndexCandyById(id);
                    Snackbar.make(findViewById(android.R.id.content),"تم الاضافة في المفضلة",Snackbar.LENGTH_SHORT).show();
                }

                if(food_food.getIndex().equals("1")){
                    db.UpdatDelIndexCandyById(id);
                    Snackbar.make(findViewById(android.R.id.content),"تم الازالة من المفضلة",Snackbar.LENGTH_SHORT).show();
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