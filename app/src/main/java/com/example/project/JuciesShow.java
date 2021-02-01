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
import java.util.ArrayList;

public class JuciesShow extends AppCompatActivity {
    TextView juciestime,juciessur,juciescal,juciesallintg,juciesmm,index;
    androidx.appcompat.widget.Toolbar tolbarjucies;
    ImageView pickImag;
    DatabaseOperaion db;
    byte[] image = null;
    int id;
    Food_Food food_food;
    FloatingActionButton favbuttn;
    ArrayList arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jucies_show);

        juciestime=findViewById(R.id.juciestime);
        juciessur=findViewById(R.id.juciessur);
        juciescal=findViewById(R.id.juciesycal);
        juciesallintg=findViewById(R.id.juciesallintg);
        juciesmm=findViewById(R.id.juciesmm);
        tolbarjucies= findViewById(R.id.tolbarjucies);
        pickImag=findViewById(R.id.imgjucies);
        favbuttn=findViewById(R.id.favJuce);
        index=findViewById(R.id.index);


        id = getIntent().getIntExtra("id", 0);
        db = DatabaseOperaion.getInstanss(this);
        try {
            food_food=db.getJuiceByID(id);



            /*التفاصيل*/
            tolbarjucies.setTitle(food_food.getName()+"");
            juciestime.setText(food_food.getTime());
            juciescal.setText(food_food.getCalories());
            juciessur.setText(food_food.getSource());
            juciesallintg.setText(food_food.getIngredients());
            juciesmm.setText(food_food.getPrepare());
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
                    db.UpdatIndexJuiceById(id);
                    Snackbar.make(findViewById(android.R.id.content),"تم الاضافة في المفضلة",Snackbar.LENGTH_SHORT).show();

                }

                if(food_food.getIndex().equals("1")){
                    db.UpdatDelIndexJuiceById(id);
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