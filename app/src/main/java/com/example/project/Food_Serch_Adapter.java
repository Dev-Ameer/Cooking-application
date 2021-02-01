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

public class Food_Serch_Adapter extends ArrayAdapter<Food_Rull> {
    Context context;
    int resource;
    public Food_Serch_Adapter(@NonNull Context context, int resource, @NonNull List<Food_Rull> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, parent, false  );

        TextView tvname = (TextView)convertView.findViewById(R.id.tvName);
        ImageView imgFood = (ImageView) convertView.findViewById(R.id.imgUser);

        Food_Rull currentFood = getItem(position);
        tvname.setText(currentFood.getName());
        if(currentFood.getImg()!=null){
        Bitmap bitmap = BitmapFactory.decodeByteArray(currentFood.getImg(), 0, currentFood.getImg().length);
        imgFood.setImageBitmap(bitmap);}

        return convertView;
    }
}
