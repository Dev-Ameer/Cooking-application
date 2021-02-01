package com.example.project;

public class Food_Food {
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    int id;
    String name;
    String recipe;
    byte[] img;
    String claes;
     String ingredients,prepare,source,time,calories;
    String index;
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrepare() {
        return prepare;
    }

    public void setPrepare(String prepare) {
        this.prepare = prepare;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public Food_Food(int id, String name, String recipe, byte[] img, String claes) {
        this.id = id;
        this.name = name;
        this.recipe = recipe;
        this.img = img;
        this.claes = claes;
    }
    public Food_Food(int id,String name,String time,String calories ,byte[] img){
        this.id=id;
        this.name=name;
        this.img=img;
        this.time=time;
        this.calories=calories;
    }
    public Food_Food(int id,String name ,byte[] img){
        this.id=id;
        this.name=name;
        this.img=img;

    }

    public Food_Food(String name, String ingredients, String prepare, String source, String time, String calories,String index, byte[] image) {
        this.name=name;
        this.ingredients=ingredients;
        this.prepare=prepare;
        this.source=source;
        this.time=time;
        this.calories=calories;
        this.img=image;
        this.index=index;
    }
    public Food_Food(String name, String ingredients, String prepare, String source, String time, String calories, byte[] image) {
        this.name=name;
        this.ingredients=ingredients;
        this.prepare=prepare;
        this.source=source;
        this.time=time;
        this.calories=calories;
        this.img=image;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getClaes() {
        return claes;
    }

    public void setClaes(String claes) {
        this.claes = claes;
    }


}
