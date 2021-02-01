package com.example.project;


import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MDatabase extends SQLiteAssetHelper {

    public static final String DB_NAME="food.db";
    public static final int DB_VERSION=1;
/*ماكولات*/
    public static final String DB_FOOD_tabel="food";
    public static final String FOOD_ID ="id";
    public static final String FOOD_NAME="name";
    public static final String FOOD_Ingre="ingredients";
    public static final String FOOD_IMGE="img";
    public static final String FOOD_PREP="prepare";
    public static final String FOOD_TIME="time";
    public static final String FOOD_SOURCE="source";
    public static final String FOOD_CALORIES="calories";
    public static final String FOOD_CLASS="class";
    public static final String FOOD_INDEX="index";
/*حلويات*/
    public static final String DB_CANDY_tabel="Candy";
    public static final String CANDY_ID ="id";
    public static final String CANDY_NAME="name";
    public static final String CANDY_Ingre="indredients";
    public static final String CANDY_IMGE="img";
    public static final String CANDY_PREP="prepare";
    public static final String CANDY_TIME="time";
    public static final String CANDY_SOURCE="source";
    public static final String CANDY_CALORIES="calories";
    public static final String CANDY_INDEX="index";
/*عصائر*/
    public static final String DB_JUICE_tabel="juice";
    public static final String JUICE_ID ="id";
    public static final String JUICE_NAME="name";
    public static final String JUICE_Ingre="ingredients";
    public static final String JUICE_IMGE="img";
    public static final String JUICE_PREP="prepare";
    public static final String JUICE_TIME="time";
    public static final String JUICE_SOURCE="source";
    public static final String JUICE_CALORIES="calories";
    public static final String JUICE_INDEX="index";
    /*Food_rule*/
    public static final String DB_RULE_FOOD="ruleFood";
    public static final String RULE_FOOD_ID ="id";
    public static final String RULE_FOOD_NAME="name";
    public static final String RULE_FOOD_IMG="img";
    public static final String I1="e1";
    public static final String I2="e2";
    public static final String I3="e3";
    public static final String I4="e4";
    public static final String I5="e5";
    public static final String I6="e6";
    public static final String I7="e7";
    public static final String I8="e8";
    public static final String I9="e9";
    public static final String I10="e10";
    public static final String I11="e11";
    public static final String I12="e12";
    public static final String I13="e13";
    public static final String I14="e14";
    public static final String I15="e15";
    /*Candy_rule*/
    public static final String DB_RULE_CANDY="ruleCandy";
    public static final String RULE_CANDY_ID ="id";
    public static final String RULE_CANDY_NAME="name";
    public static final String RULE_CANDY_IMG="img";
    public static final String I1_CANDY="e1";
    public static final String I2_CANDY="e2";
    public static final String I3_CANDY="e3";
    public static final String I4_CANDY="e4";
    public static final String I5_CANDY="e5";
    public static final String I6_CANDY="e6";
    public static final String I7_CANDY="e7";
    public static final String I8_CANDY="e8";
    public static final String I9_CANDY="e9";
    public static final String I10_CANDY="e10";
    public static final String I11_CANDY="e11";
    public static final String I12_CANDY="e12";
    public static final String I13_CANDY="e13";
    public static final String I14_CANDY="e14";
    public static final String I15_CANDY="e15";
    /*Juice_reule*/
    public static final String DB_RULE_JUICE="ruleJuice";
    public static final String RULE_JUICE_ID ="id";
    public static final String RULE_JUICE_NAME="name";
    public static final String RULE_JUICE_IMG="img";
    public static final String I1_JUICE="e1";
    public static final String I2_JUICE="e2";
    public static final String I3_JUICE="e3";
    public static final String I4_JUICE="e4";
    public static final String I5_JUICE="e5";
    public static final String I6_JUICE="e6";
    public static final String I7_JUICE="e7";
    public static final String I8_JUICE="e8";
    public static final String I9_JUICE="e9";
    public static final String I10_JUICE="e10";
    public static final String I11_JUICE="e11";
    public static final String I12_JUICE="e12";
    public static final String I13_JUICE="e13";
    public static final String I14_JUICE="e14";
    public static final String I15_JUICE="e15";
    public MDatabase(Context contextn) {

        super(contextn,DB_NAME,null,DB_VERSION);
    }
}
