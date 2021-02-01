package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.example.project.MDatabase.CANDY_CALORIES;
import static com.example.project.MDatabase.CANDY_ID;
import static com.example.project.MDatabase.CANDY_IMGE;
import static com.example.project.MDatabase.CANDY_INDEX;
import static com.example.project.MDatabase.CANDY_Ingre;
import static com.example.project.MDatabase.CANDY_NAME;
import static com.example.project.MDatabase.CANDY_PREP;
import static com.example.project.MDatabase.CANDY_SOURCE;
import static com.example.project.MDatabase.CANDY_TIME;
import static com.example.project.MDatabase.DB_CANDY_tabel;
import static com.example.project.MDatabase.DB_FOOD_tabel;
import static com.example.project.MDatabase.DB_JUICE_tabel;
import static com.example.project.MDatabase.DB_RULE_FOOD;
import static com.example.project.MDatabase.DB_RULE_CANDY;
import static com.example.project.MDatabase.DB_RULE_JUICE;
import static com.example.project.MDatabase.FOOD_CALORIES;
import static com.example.project.MDatabase.FOOD_ID;
import static com.example.project.MDatabase.FOOD_INDEX;
import static com.example.project.MDatabase.FOOD_Ingre;
import static com.example.project.MDatabase.FOOD_NAME;
import static com.example.project.MDatabase.FOOD_IMGE;
import static com.example.project.MDatabase.FOOD_PREP;
import static com.example.project.MDatabase.FOOD_SOURCE;
import static com.example.project.MDatabase.FOOD_TIME;
import static com.example.project.MDatabase.I1;
import static com.example.project.MDatabase.I10;
import static com.example.project.MDatabase.I10_CANDY;
import static com.example.project.MDatabase.I10_JUICE;
import static com.example.project.MDatabase.I11;
import static com.example.project.MDatabase.I11_CANDY;
import static com.example.project.MDatabase.I11_JUICE;
import static com.example.project.MDatabase.I12;
import static com.example.project.MDatabase.I12_CANDY;
import static com.example.project.MDatabase.I12_JUICE;
import static com.example.project.MDatabase.I13;
import static com.example.project.MDatabase.I13_CANDY;
import static com.example.project.MDatabase.I13_JUICE;
import static com.example.project.MDatabase.I14;
import static com.example.project.MDatabase.I14_CANDY;
import static com.example.project.MDatabase.I14_JUICE;
import static com.example.project.MDatabase.I15;
import static com.example.project.MDatabase.I15_CANDY;
import static com.example.project.MDatabase.I15_JUICE;
import static com.example.project.MDatabase.I1_CANDY;
import static com.example.project.MDatabase.I1_JUICE;
import static com.example.project.MDatabase.I2;
import static com.example.project.MDatabase.I2_CANDY;
import static com.example.project.MDatabase.I2_JUICE;
import static com.example.project.MDatabase.I3;
import static com.example.project.MDatabase.I3_CANDY;
import static com.example.project.MDatabase.I3_JUICE;
import static com.example.project.MDatabase.I4;
import static com.example.project.MDatabase.I4_CANDY;
import static com.example.project.MDatabase.I4_JUICE;
import static com.example.project.MDatabase.I5;
import static com.example.project.MDatabase.I5_CANDY;
import static com.example.project.MDatabase.I5_JUICE;
import static com.example.project.MDatabase.I6;
import static com.example.project.MDatabase.I6_CANDY;
import static com.example.project.MDatabase.I6_JUICE;
import static com.example.project.MDatabase.I7;
import static com.example.project.MDatabase.I7_CANDY;
import static com.example.project.MDatabase.I7_JUICE;
import static com.example.project.MDatabase.I8;
import static com.example.project.MDatabase.I8_CANDY;
import static com.example.project.MDatabase.I8_JUICE;
import static com.example.project.MDatabase.I9;
import static com.example.project.MDatabase.I9_CANDY;
import static com.example.project.MDatabase.I9_JUICE;
import static com.example.project.MDatabase.JUICE_CALORIES;
import static com.example.project.MDatabase.JUICE_ID;
import static com.example.project.MDatabase.JUICE_IMGE;
import static com.example.project.MDatabase.JUICE_INDEX;
import static com.example.project.MDatabase.JUICE_Ingre;
import static com.example.project.MDatabase.JUICE_NAME;
import static com.example.project.MDatabase.JUICE_PREP;
import static com.example.project.MDatabase.JUICE_SOURCE;
import static com.example.project.MDatabase.JUICE_TIME;
import static com.example.project.MDatabase.RULE_CANDY_ID;
import static com.example.project.MDatabase.RULE_CANDY_IMG;
import static com.example.project.MDatabase.RULE_CANDY_NAME;
import static com.example.project.MDatabase.RULE_FOOD_ID;
import static com.example.project.MDatabase.RULE_FOOD_IMG;
import static com.example.project.MDatabase.RULE_FOOD_NAME;
import static com.example.project.MDatabase.RULE_JUICE_ID;
import static com.example.project.MDatabase.RULE_JUICE_IMG;
import static com.example.project.MDatabase.RULE_JUICE_NAME;

public class DatabaseOperaion {
    SQLiteOpenHelper openHelper;
    private static DatabaseOperaion instanss;
    private DatabaseOperaion(Context context) {

        this.openHelper = new MDatabase(context);
    }
    public static DatabaseOperaion getInstanss(Context context) {
        if (instanss == null) {
            instanss = new DatabaseOperaion(context);
        }
        return instanss;
    }
/*Get All Eliment In Food,Candy,Jucies*/
    public ArrayList<Food_Food> getAllContentFood() {
        ArrayList<Food_Food> contentFood = new ArrayList<Food_Food>();
        String select_query = "select * from " + DB_FOOD_tabel;
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(FOOD_ID));
                String Name = cursor.getString(cursor.getColumnIndex(FOOD_NAME));
                String time = cursor.getString(cursor.getColumnIndex(FOOD_TIME));
                String calures = cursor.getString(cursor.getColumnIndex(FOOD_CALORIES));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(FOOD_IMGE));
                Food_Food food = new Food_Food(id,Name,time,calures,img);
                contentFood.add(food);
            } while (cursor.moveToNext());
        }
        return contentFood;
    }
    public ArrayList<Food_Food> getAllContentFoodByCalsslunch() {
        ArrayList<Food_Food> contentFood = new ArrayList<Food_Food>();
        String select_query = "select * from food where class=\"غذاء\"";
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(FOOD_ID));
                String Name = cursor.getString(cursor.getColumnIndex(FOOD_NAME));
                String time = cursor.getString(cursor.getColumnIndex(FOOD_TIME));
                String calures = cursor.getString(cursor.getColumnIndex(FOOD_CALORIES));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(FOOD_IMGE));
                Food_Food food = new Food_Food(id,Name,time,calures,img);
                contentFood.add(food);
            } while (cursor.moveToNext());
        }
        return contentFood;
    }
    public ArrayList<Food_Food> getAllContentFoodByCalssbrecf() {
        ArrayList<Food_Food> contentFood = new ArrayList<Food_Food>();
        String select_query = "select * from food where class=\"فطور\"";
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(FOOD_ID));
                String Name = cursor.getString(cursor.getColumnIndex(FOOD_NAME));
                String time = cursor.getString(cursor.getColumnIndex(FOOD_TIME));
                String calures = cursor.getString(cursor.getColumnIndex(FOOD_CALORIES));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(FOOD_IMGE));
                Food_Food food = new Food_Food(id,Name,time,calures,img);
                contentFood.add(food);
            } while (cursor.moveToNext());
        }
        return contentFood;
    }
    public ArrayList<Food_Food> getAllContentFoodByCalssdener() {
        ArrayList<Food_Food> contentFood = new ArrayList<Food_Food>();
        String select_query = "select * from food where class=\"عشاء\"";
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(FOOD_ID));
                String Name = cursor.getString(cursor.getColumnIndex(FOOD_NAME));
                String time = cursor.getString(cursor.getColumnIndex(FOOD_TIME));
                String calures = cursor.getString(cursor.getColumnIndex(FOOD_CALORIES));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(FOOD_IMGE));
                Food_Food food = new Food_Food(id,Name,time,calures,img);
                contentFood.add(food);
            } while (cursor.moveToNext());
        }
        return contentFood;
    }
    public ArrayList<Food_Food> getAllContentCandy() {
        ArrayList<Food_Food> contentCandy = new ArrayList<Food_Food>();

        String select_query = "select * from " + DB_CANDY_tabel;

        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(cursor.getColumnIndex(CANDY_ID));
                String Name = cursor.getString(cursor.getColumnIndex(CANDY_NAME));
                String time = cursor.getString(cursor.getColumnIndex(CANDY_TIME));
                String calures = cursor.getString(cursor.getColumnIndex(CANDY_CALORIES));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(CANDY_IMGE));
                Food_Food food = new Food_Food(id,Name,time,calures,img);
                contentCandy.add(food);

            } while (cursor.moveToNext());

        }

        return contentCandy;
    }
    public ArrayList<Food_Food> getAllContentJucies() {
        ArrayList<Food_Food> contentCandy = new ArrayList<Food_Food>();

        String select_query = "select * from " + DB_JUICE_tabel;

        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(cursor.getColumnIndex(JUICE_ID));
                String Name = cursor.getString(cursor.getColumnIndex(JUICE_NAME));
                String time = cursor.getString(cursor.getColumnIndex(JUICE_TIME));
                String calures = cursor.getString(cursor.getColumnIndex(JUICE_CALORIES));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(JUICE_IMGE));
                Food_Food food = new Food_Food(id,Name,time,calures,img);
                contentCandy.add(food);

            } while (cursor.moveToNext());

        }

        return contentCandy;
    }
 /***************/
 /*Get All Favoret Food,Candy,Juce */
 public ArrayList<Food_Food> getAllContentFavFood() {
     ArrayList<Food_Food> contentFood = new ArrayList<Food_Food>();
     String select_query = "SELECT * from food where \"index\"=1";
     SQLiteDatabase db = this.openHelper.getReadableDatabase();
     Cursor cursor = db.rawQuery(select_query,null);
     if (cursor.moveToFirst()) {
         do {
             int id = cursor.getInt(cursor.getColumnIndex(FOOD_ID));
             String Name = cursor.getString(cursor.getColumnIndex(FOOD_NAME));
             String time = cursor.getString(cursor.getColumnIndex(FOOD_TIME));
             String calures = cursor.getString(cursor.getColumnIndex(FOOD_CALORIES));
             byte[] img = cursor.getBlob(cursor.getColumnIndex(FOOD_IMGE));
             Food_Food food = new Food_Food(id,Name,time,calures,img);
             contentFood.add(food);
         } while (cursor.moveToNext());
     }
     return contentFood;
 }
 public ArrayList<Food_Food> getAllContentFavCandy() {
        ArrayList<Food_Food> contentFood = new ArrayList<Food_Food>();
        String select_query = "SELECT * from Candy where \"index\"=1";
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(CANDY_ID));
                String Name = cursor.getString(cursor.getColumnIndex(CANDY_NAME));
                String time = cursor.getString(cursor.getColumnIndex(CANDY_TIME));
                String calures = cursor.getString(cursor.getColumnIndex(CANDY_CALORIES));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(CANDY_IMGE));
                Food_Food food = new Food_Food(id,Name,time,calures,img);
                contentFood.add(food);
            } while (cursor.moveToNext());
        }
        return contentFood;
    }
 public ArrayList<Food_Food> getAllContentFavJuices() {
        ArrayList<Food_Food> contentFood = new ArrayList<Food_Food>();
        String select_query = "SELECT * from juice where \"index\"=1";
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(JUICE_ID));
                String Name = cursor.getString(cursor.getColumnIndex(JUICE_NAME));
                String time = cursor.getString(cursor.getColumnIndex(JUICE_TIME));
                String calures = cursor.getString(cursor.getColumnIndex(JUICE_CALORIES));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(JUICE_IMGE));
                Food_Food food = new Food_Food(id,Name,time,calures,img);
                contentFood.add(food);
            } while (cursor.moveToNext());
        }
        return contentFood;
    }
 /***********************/
/*Get Item By Name To Food,Candy,Juices Tabel*/
    public ArrayList<Food_Food> getItemByNameFood(String name) {
        ArrayList<Food_Food> contentCandy = new ArrayList<Food_Food>();

        String select_query = "select * from food where name like'" + name + "'";
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(cursor.getColumnIndex(CANDY_ID));
                String Name = cursor.getString(cursor.getColumnIndex(CANDY_NAME));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(CANDY_IMGE));


                Food_Food food = new Food_Food(id, Name, img);

                contentCandy.add(food);

            } while (cursor.moveToNext());

        }

        return contentCandy;
    }
    public ArrayList<Food_Food> getItemByNameCandy(String name) {
        ArrayList<Food_Food> contentCandy = new ArrayList<Food_Food>();

        String select_query = "select * from Candy where name like'" + name + "'";
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(cursor.getColumnIndex(CANDY_ID));
                String Name = cursor.getString(cursor.getColumnIndex(CANDY_NAME));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(CANDY_IMGE));


                Food_Food food = new Food_Food(id, Name, img);

                contentCandy.add(food);

            } while (cursor.moveToNext());

        }

        return contentCandy;
    }
    public ArrayList<Food_Food> getItemByNameJuices(String name) {
        ArrayList<Food_Food> contentCandy = new ArrayList<Food_Food>();

        String select_query = "select * from juice where name like'" + name + "'";
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(cursor.getColumnIndex(CANDY_ID));
                String Name = cursor.getString(cursor.getColumnIndex(CANDY_NAME));
                byte[] img = cursor.getBlob(cursor.getColumnIndex(CANDY_IMGE));


                Food_Food food = new Food_Food(id, Name, img);

                contentCandy.add(food);

            } while (cursor.moveToNext());

        }

        return contentCandy;
    }
/****************/
/*get Item By Id To Food,Candy,Juices Tabel*/
    public Food_Food getFoodByID(int id) {

        Food_Food food_food = null;

        SQLiteDatabase db = this.openHelper.getReadableDatabase();
       // Cursor cursor = db.query(DB_FOOD_tabel, new String[]{"name", "ingredients", "prepare", "source", "time", "calories","index","img"}, "id=?",
       //         new String[]{String.valueOf(id)}, null, null, null, null);
        String select_query = "select * from food where id="+id;
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {

            String name = cursor.getString(cursor.getColumnIndex(FOOD_NAME));
            String ingredients = cursor.getString(cursor.getColumnIndex(FOOD_Ingre));
            String prepare = cursor.getString(cursor.getColumnIndex(FOOD_PREP));
            String source = cursor.getString(cursor.getColumnIndex(FOOD_SOURCE));
            String time = cursor.getString(cursor.getColumnIndex(FOOD_TIME));
            String calories = cursor.getString(cursor.getColumnIndex(FOOD_CALORIES));
            String index=cursor.getString(cursor.getColumnIndex(FOOD_INDEX));
            byte[] image = cursor.getBlob(cursor.getColumnIndex(FOOD_IMGE));

            food_food = new Food_Food(name, ingredients, prepare, source, time, calories,index ,image);

        }

        return food_food;

    }
    public Food_Food getCandyByID(int id) {

        Food_Food food_food = null;

        SQLiteDatabase db = this.openHelper.getReadableDatabase();
      //  Cursor cursor = db.query("Candy", new String[]{"name", "indredients", "prepare", "source", "time", "calories","img"}, "id=?",
        //        new String[]{String.valueOf(id)}, null, null, null, null);
        String select_query = "select * from Candy where id="+id;
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {

            String namec = cursor.getString(cursor.getColumnIndex(CANDY_NAME));
            String ingredientsc = cursor.getString(cursor.getColumnIndex(CANDY_Ingre));
            String preparec = cursor.getString(cursor.getColumnIndex(CANDY_PREP));
            String sourcec = cursor.getString(cursor.getColumnIndex(CANDY_SOURCE));
            String timec = cursor.getString(cursor.getColumnIndex(CANDY_TIME));
            String index=cursor.getString(cursor.getColumnIndex(FOOD_INDEX));
            String caloriesc = cursor.getString(cursor.getColumnIndex(CANDY_CALORIES));

            byte[] imagec = cursor.getBlob(cursor.getColumnIndex(CANDY_IMGE));

            food_food = new Food_Food(namec, ingredientsc, preparec, sourcec, timec, caloriesc,index,imagec);

        }

        return food_food;

    }
    public Food_Food getJuiceByID(int id) {

        Food_Food food_food = null;

        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        //Cursor cursor = db.query(DB_JUICE_tabel, new String[]{"name", "ingredients", "prepare", "source", "time", "calories","img"}, "id=?",
          //      new String[]{String.valueOf(id)}, null, null, null, null);
        String select_query = "select * from juice where id="+id;
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {

            String namec = cursor.getString(cursor.getColumnIndex(JUICE_NAME));
            String ingredientsc = cursor.getString(cursor.getColumnIndex(JUICE_Ingre));
            String preparec = cursor.getString(cursor.getColumnIndex(JUICE_PREP));
            String sourcec = cursor.getString(cursor.getColumnIndex(JUICE_SOURCE));
            String timec = cursor.getString(cursor.getColumnIndex(JUICE_TIME));
            String caloriesc = cursor.getString(cursor.getColumnIndex(JUICE_CALORIES));
            String index=cursor.getString(cursor.getColumnIndex(FOOD_INDEX));
            byte[] imagec = cursor.getBlob(cursor.getColumnIndex(JUICE_IMGE));

            food_food = new Food_Food(namec, ingredientsc, preparec, sourcec, timec, caloriesc,index,imagec);

        }

        return food_food;

    }
 /***************/
/*Favoret Food ,Candy,Juices Tabel*/
 public void UpdatIndexFoodById(int id) {
     SQLiteDatabase db = this.openHelper.getWritableDatabase();
     String select_query = "UPDATE  food SET \"index\"=1 where id="+id;
      db.execSQL(select_query);

 }
 public void UpdatDelIndexFoodById(int id) {
        SQLiteDatabase db = this.openHelper.getWritableDatabase();
        String select_query = "UPDATE  food SET \"index\"=0 where id="+id;
        db.execSQL(select_query);
    }
 public void UpdatIndexCandyById(int id) {
        SQLiteDatabase db = this.openHelper.getWritableDatabase();
        String select_query = "UPDATE  Candy SET \"index\"=1 where id="+id;
        db.execSQL(select_query);
    }
 public void UpdatDelIndexCandyById(int id) {
        SQLiteDatabase db = this.openHelper.getWritableDatabase();
        String select_query = "UPDATE  Candy SET \"index\"=0 where id="+id;
        db.execSQL(select_query);
    }
 public void UpdatIndexJuiceById(int id) {
        SQLiteDatabase db = this.openHelper.getWritableDatabase();
        String select_query = "UPDATE  juice SET \"index\"=1 where id="+id;
        db.execSQL(select_query);
    }
 public void UpdatDelIndexJuiceById(int id) {
        SQLiteDatabase db = this.openHelper.getWritableDatabase();
        String select_query = "UPDATE  juice SET \"index\"=0 where id="+id;
        db.execSQL(select_query);
    }
 /**********************/
 /*Serch Food By Using Ingredints To Food,Candy,Juices Tabel*/
    public ArrayList<Food_Rull> locateFood(Food_Rull fr) {
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        String select_query = "select * from " + DB_RULE_FOOD;
        Cursor cursor = db.rawQuery(select_query, null);
        ArrayList<Food_Rull> list = new ArrayList<Food_Rull>();
        int i = 0;
        if (cursor.moveToFirst()) {
            do {
                Food_Rull frd = new Food_Rull();
                frd.setId(cursor.getInt(cursor.getColumnIndex(RULE_FOOD_ID)));
                frd.setName(cursor.getString(cursor.getColumnIndex(RULE_FOOD_NAME)));
                frd.setImg(cursor.getBlob(cursor.getColumnIndex(RULE_FOOD_IMG)));
                frd.setE1(cursor.getString(cursor.getColumnIndex(I1)));
                frd.setE2(cursor.getString(cursor.getColumnIndex(I2)));
                frd.setE3(cursor.getString(cursor.getColumnIndex(I3)));
                frd.setE4(cursor.getString(cursor.getColumnIndex(I4)));
                frd.setE5(cursor.getString(cursor.getColumnIndex(I5)));
                frd.setE6(cursor.getString(cursor.getColumnIndex(I6)));
                frd.setE7(cursor.getString(cursor.getColumnIndex(I7)));
                frd.setE8(cursor.getString(cursor.getColumnIndex(I8)));
                frd.setE9(cursor.getString(cursor.getColumnIndex(I9)));
                frd.setE10(cursor.getString(cursor.getColumnIndex(I10)));
                frd.setE11(cursor.getString(cursor.getColumnIndex(I11)));
                frd.setE12(cursor.getString(cursor.getColumnIndex(I12)));
                frd.setE13(cursor.getString(cursor.getColumnIndex(I13)));
                frd.setE14(cursor.getString(cursor.getColumnIndex(I14)));
                frd.setE15(cursor.getString(cursor.getColumnIndex(I15)));
                 if(frd.getE1()!=null && fr.getE1()!=null){
                if (frd.getE1().equalsIgnoreCase(fr.getE1()) ) {
                    i++;
                }}
                if(frd.getE2()!=null && fr.getE2()!=null){
                if (frd.getE2().equalsIgnoreCase(fr.getE2())) {
                    i++;
                }}
                if(frd.getE3()!=null && fr.getE3()!=null){
                if (frd.getE3().equalsIgnoreCase(fr.getE3()) ) {
                    i++;
                }}
                if(frd.getE4()!=null && fr.getE4()!=null){
                if (frd.getE4().equalsIgnoreCase(fr.getE4()) ) {
                    i++;
                }}
                if(frd.getE5()!=null &&fr.getE5()!=null){
                if (frd.getE5().equalsIgnoreCase(fr.getE5())) {
                    i++;
                }}
                if(frd.getE6()!=null && fr.getE6()!=null){
                if (frd.getE6().equalsIgnoreCase(fr.getE6())) {
                    i++;
                }}
                if(frd.getE7()!=null && fr.getE7()!=null){
                if (frd.getE7().equalsIgnoreCase(fr.getE7())) {
                    i++;
                }}
                if(frd.getE8()!=null && fr.getE8()!=null){
                if (frd.getE8().equalsIgnoreCase(fr.getE8())) {
                    i++;
                }}
                if(frd.getE9()!=null && fr.getE9()!=null){
                if (frd.getE9().equalsIgnoreCase(fr.getE9())) {
                    i++;
                }}
                if(frd.getE10()!=null && fr.getE10()!=null){
                if (frd.getE10().equalsIgnoreCase(fr.getE10())) {
                    i++;
                }}
                if(frd.getE11()!=null && fr.getE11()!=null){
                if (frd.getE11().equalsIgnoreCase(fr.getE12()) ) {
                    i++;
                }}
                if(frd.getE12()!=null && fr.getE12()!=null){
                if (frd.getE12().equalsIgnoreCase(fr.getE12())) {
                    i++;
                }}
                if(frd.getE13()!=null && fr.getE13()!=null){
                if (frd.getE13().equalsIgnoreCase(fr.getE13())) {
                    i++;
                }}
                if(frd.getE14()!=null && fr.getE14()!=null){
                if (frd.getE14().equalsIgnoreCase(fr.getE14())) {
                    i++;
                }}
                if(frd.getE15()!=null && fr.getE15()!=null){
                if (frd.getE15().equalsIgnoreCase(fr.getE15()) ) {
                    i++;
                }}
                if (i >= 3) {
                    list.add(frd);
                    System.out.println(frd.getE1()+"===================");

                    i = 0;
                }

            } while (cursor.moveToNext());
        }

            return list;
        }
    public ArrayList<Food_Rull> locateCandy(Food_Rull fr) {
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        String select_query = "select * from " + DB_RULE_CANDY;
        Cursor cursor = db.rawQuery(select_query, null);
        ArrayList<Food_Rull> list = new ArrayList<Food_Rull>();
        int i = 0;
        if (cursor.moveToFirst()) {
            do {
                Food_Rull frd = new Food_Rull();
                frd.setId(cursor.getInt(cursor.getColumnIndex(RULE_CANDY_ID)));
                frd.setName(cursor.getString(cursor.getColumnIndex(RULE_CANDY_NAME)));
                frd.setImg(cursor.getBlob(cursor.getColumnIndex(RULE_CANDY_IMG)));
                frd.setE1(cursor.getString(cursor.getColumnIndex(I1_CANDY)));
                frd.setE2(cursor.getString(cursor.getColumnIndex(I2_CANDY)));
                frd.setE3(cursor.getString(cursor.getColumnIndex(I3_CANDY)));
                frd.setE4(cursor.getString(cursor.getColumnIndex(I4_CANDY)));
                frd.setE5(cursor.getString(cursor.getColumnIndex(I5_CANDY)));
                frd.setE6(cursor.getString(cursor.getColumnIndex(I6_CANDY)));
                frd.setE7(cursor.getString(cursor.getColumnIndex(I7_CANDY)));
                frd.setE8(cursor.getString(cursor.getColumnIndex(I8_CANDY)));
                frd.setE9(cursor.getString(cursor.getColumnIndex(I9_CANDY)));
                frd.setE10(cursor.getString(cursor.getColumnIndex(I10_CANDY)));
                frd.setE11(cursor.getString(cursor.getColumnIndex(I11_CANDY)));
                frd.setE12(cursor.getString(cursor.getColumnIndex(I12_CANDY)));
                frd.setE13(cursor.getString(cursor.getColumnIndex(I13_CANDY)));
                frd.setE14(cursor.getString(cursor.getColumnIndex(I14_CANDY)));
                frd.setE15(cursor.getString(cursor.getColumnIndex(I15_CANDY)));
                if(frd.getE1()!=null && fr.getE1()!=null){
                    if (frd.getE1().equalsIgnoreCase(fr.getE1()) ) {
                        i++;
                    }}
                if(frd.getE2()!=null && fr.getE2()!=null){
                    if (frd.getE2().equalsIgnoreCase(fr.getE2())) {
                        i++;
                    }}
                if(frd.getE3()!=null && fr.getE3()!=null){
                    if (frd.getE3().equalsIgnoreCase(fr.getE3()) ) {
                        i++;
                    }}
                if(frd.getE4()!=null && fr.getE4()!=null){
                    if (frd.getE4().equalsIgnoreCase(fr.getE4()) ) {
                        i++;
                    }}
                if(frd.getE5()!=null &&fr.getE5()!=null){
                    if (frd.getE5().equalsIgnoreCase(fr.getE5())) {
                        i++;
                    }}
                if(frd.getE6()!=null && fr.getE6()!=null){
                    if (frd.getE6().equalsIgnoreCase(fr.getE6())) {
                        i++;
                    }}
                if(frd.getE7()!=null && fr.getE7()!=null){
                    if (frd.getE7().equalsIgnoreCase(fr.getE7())) {
                        i++;
                    }}
                if(frd.getE8()!=null && fr.getE8()!=null){
                    if (frd.getE8().equalsIgnoreCase(fr.getE8())) {
                        i++;
                    }}
                if(frd.getE9()!=null && fr.getE9()!=null){
                    if (frd.getE9().equalsIgnoreCase(fr.getE9())) {
                        i++;
                    }}
                if(frd.getE10()!=null && fr.getE10()!=null){
                    if (frd.getE10().equalsIgnoreCase(fr.getE10())) {
                        i++;
                    }}
                if(frd.getE11()!=null && fr.getE11()!=null){
                    if (frd.getE11().equalsIgnoreCase(fr.getE12()) ) {
                        i++;
                    }}
                if(frd.getE12()!=null && fr.getE12()!=null){
                    if (frd.getE12().equalsIgnoreCase(fr.getE12())) {
                        i++;
                    }}
                if(frd.getE13()!=null && fr.getE13()!=null){
                    if (frd.getE13().equalsIgnoreCase(fr.getE13())) {
                        i++;
                    }}
                if(frd.getE14()!=null && fr.getE14()!=null){
                    if (frd.getE14().equalsIgnoreCase(fr.getE14())) {
                        i++;
                    }}
                if(frd.getE15()!=null && fr.getE15()!=null){
                    if (frd.getE15().equalsIgnoreCase(fr.getE15()) ) {
                        i++;
                    }}
                if (i >= 3) {
                    list.add(frd);
                    System.out.println(frd.getE1()+"===================");
                    i = 0;
                }

            } while (cursor.moveToNext());
        }

        return list;
    }
    public ArrayList<Food_Rull> locateJuice(Food_Rull fr) {
        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        String select_query = "select * from " + DB_RULE_JUICE;
        Cursor cursor = db.rawQuery(select_query, null);
        ArrayList<Food_Rull> list = new ArrayList<Food_Rull>();
        int i = 0;
        if (cursor.moveToFirst()) {
            do {
                Food_Rull frd = new Food_Rull();
                frd.setId(cursor.getInt(cursor.getColumnIndex(RULE_JUICE_ID)));
                frd.setName(cursor.getString(cursor.getColumnIndex(RULE_JUICE_NAME)));
                frd.setImg(cursor.getBlob(cursor.getColumnIndex(RULE_JUICE_IMG)));
                frd.setE1(cursor.getString(cursor.getColumnIndex(I1_JUICE)));
                frd.setE2(cursor.getString(cursor.getColumnIndex(I2_JUICE)));
                frd.setE3(cursor.getString(cursor.getColumnIndex(I3_JUICE)));
                frd.setE4(cursor.getString(cursor.getColumnIndex(I4_JUICE)));
                frd.setE5(cursor.getString(cursor.getColumnIndex(I5_JUICE)));
                frd.setE6(cursor.getString(cursor.getColumnIndex(I6_JUICE)));
                frd.setE7(cursor.getString(cursor.getColumnIndex(I7_JUICE)));
                frd.setE8(cursor.getString(cursor.getColumnIndex(I8_JUICE)));
                frd.setE9(cursor.getString(cursor.getColumnIndex(I9_JUICE)));
                frd.setE10(cursor.getString(cursor.getColumnIndex(I10_JUICE)));
                frd.setE11(cursor.getString(cursor.getColumnIndex(I11_JUICE)));
                frd.setE12(cursor.getString(cursor.getColumnIndex(I12_JUICE)));
                frd.setE13(cursor.getString(cursor.getColumnIndex(I13_JUICE)));
                frd.setE14(cursor.getString(cursor.getColumnIndex(I14_JUICE)));
                frd.setE15(cursor.getString(cursor.getColumnIndex(I15_JUICE)));
                if(frd.getE1()!=null && fr.getE1()!=null){
                    if (frd.getE1().equalsIgnoreCase(fr.getE1()) ) {
                        i++;
                    }}
                if(frd.getE2()!=null && fr.getE2()!=null){
                    if (frd.getE2().equalsIgnoreCase(fr.getE2())) {
                        i++;
                    }}
                if(frd.getE3()!=null && fr.getE3()!=null){
                    if (frd.getE3().equalsIgnoreCase(fr.getE3()) ) {
                        i++;
                    }}
                if(frd.getE4()!=null && fr.getE4()!=null){
                    if (frd.getE4().equalsIgnoreCase(fr.getE4()) ) {
                        i++;
                    }}
                if(frd.getE5()!=null &&fr.getE5()!=null){
                    if (frd.getE5().equalsIgnoreCase(fr.getE5())) {
                        i++;
                    }}
                if(frd.getE6()!=null && fr.getE6()!=null){
                    if (frd.getE6().equalsIgnoreCase(fr.getE6())) {
                        i++;
                    }}
                if(frd.getE7()!=null && fr.getE7()!=null){
                    if (frd.getE7().equalsIgnoreCase(fr.getE7())) {
                        i++;
                    }}
                if(frd.getE8()!=null && fr.getE8()!=null){
                    if (frd.getE8().equalsIgnoreCase(fr.getE8())) {
                        i++;
                    }}
                if(frd.getE9()!=null && fr.getE9()!=null){
                    if (frd.getE9().equalsIgnoreCase(fr.getE9())) {
                        i++;
                    }}
                if(frd.getE10()!=null && fr.getE10()!=null){
                    if (frd.getE10().equalsIgnoreCase(fr.getE10())) {
                        i++;
                    }}
                if(frd.getE11()!=null && fr.getE11()!=null){
                    if (frd.getE11().equalsIgnoreCase(fr.getE12()) ) {
                        i++;
                    }}
                if(frd.getE12()!=null && fr.getE12()!=null){
                    if (frd.getE12().equalsIgnoreCase(fr.getE12())) {
                        i++;
                    }}
                if(frd.getE13()!=null && fr.getE13()!=null){
                    if (frd.getE13().equalsIgnoreCase(fr.getE13())) {
                        i++;
                    }}
                if(frd.getE14()!=null && fr.getE14()!=null){
                    if (frd.getE14().equalsIgnoreCase(fr.getE14())) {
                        i++;
                    }}
                if(frd.getE15()!=null && fr.getE15()!=null){
                    if (frd.getE15().equalsIgnoreCase(fr.getE15()) ) {
                        i++;
                    }}
                if (i >= 3) {
                    list.add(frd);
                    System.out.println(frd.getE1()+"===================");

                    i = 0;
                }

            } while (cursor.moveToNext());
        }

        return list;
    }
/***************************/
    }
