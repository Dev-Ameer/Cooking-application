package com.example.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class Food_Adapter extends ArrayAdapter<Food_Food> {

    Context context;
    int resource;

    public Food_Adapter(@NonNull Context context, int resource, @NonNull List<Food_Food> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource, parent, false  );

        TextView tvname = (TextView)convertView.findViewById(R.id.tvName);
        //TextView tvtime = (TextView)convertView.findViewById(R.id.tvtime);
        TextView tvcal = (TextView)convertView.findViewById(R.id.tvcaly);

        ImageView imgFood = (ImageView) convertView.findViewById(R.id.imgUser);



        Food_Food currentFood = getItem(position);

        tvname.setText(currentFood.getName());
        //tvtime.setText(String.valueOf(currentFood.getTime()));
        tvcal.setText(String.valueOf(currentFood.getCalories())+" CAL");

        Bitmap bitmap = BitmapFactory.decodeByteArray(currentFood.getImg(), 0, currentFood.getImg().length);
        imgFood.setImageBitmap(bitmap);



        return convertView;
    }




}
