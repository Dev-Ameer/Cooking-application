package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainAct extends AppCompatActivity {
private DrawerLayout drawerLayout;
private ActionBarDrawerToggle mToggle;
private  NavigationView a;
Context context=this;
CarouselView carouselView;
ImageView fav1,fav2,fav3;
int [] sampleImages=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.f };
//int[] sampleImages = {R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_launcher_foreground, R.drawable.ic_settings_black_24dp, R.drawable.ic_work_black_24dp}
    ImageView img1,img2,img3,s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.actmin);

        img1=findViewById(R.id.image1);
        img2=findViewById(R.id.image2);
        img3=findViewById(R.id.image3);
        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        s3=findViewById(R.id.s3);
        fav1=findViewById(R.id.fav1);
        fav2=findViewById(R.id.fav2);
        fav3=findViewById(R.id.fav3);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),Search_Food_integ.class);
                startActivity(s1);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s2=new Intent(getApplicationContext(),Search_Candy_integ.class);
                startActivity(s2);
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s3=new Intent(getApplicationContext(),Search_Jucies_integ.class);
                startActivity(s3);
            }
        });
        fav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food=new Intent(getApplicationContext(),Fav_Food.class);
                startActivity(food);
            }
        });
        fav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food=new Intent(getApplicationContext(),Candy_Fav.class);
                startActivity(food);
            }
        });
        fav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food=new Intent(getApplicationContext(),Juse_Fav.class);
                startActivity(food);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food=new Intent(getApplicationContext(),Food.class);
                startActivity(food);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                Intent candy=new Intent(getApplicationContext(),Candy.class);
                startActivity(candy);
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();

                }
            }
        });

       img3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent juices=new Intent(getApplicationContext(),Juices.class);
               startActivity(juices);
           }
       });
         /*ايقونة القائمة الجانبية عند الفتح وعند الاغلاق*/
        drawerLayout =(DrawerLayout)findViewById(R.id.draw);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*******************عند الضغط والتنقل بين الصفحات****************/
         a=findViewById(R.id.a);
     a.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             int id=item.getItemId();

             if (id==R.id.home){
                 Toast.makeText(getApplicationContext(),"انت بالفعل في الرئيسية",Toast.LENGTH_LONG).show();
                 return true;
             }
             if (id==R.id.who){
                 try {
                     AlertDialog.Builder a=new AlertDialog.Builder(context);
                     a.setTitle("من نحن").setMessage("المطور :امير اياد الهوبي" +
                             "\n"
                     ).setPositiveButton("ok", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             dialog.dismiss();
                         }
                     });
                     AlertDialog dialog=a.create();
                     dialog.show();
                     return true;
                 } catch (Exception e) {
                     Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
                 }

             }


             if (id==R.id.share){
                 Intent shareIntent = new Intent(Intent.ACTION_SEND);
                 shareIntent.setType("text/plain");
                 String shareBody = "Party Help \n" + "https://play.google.com/store/apps/details?id=com.clic2code.partySupport&h1=en";
                 String sherSup = "شارك التطبيق.. ";
                 shareIntent.putExtra(Intent.EXTRA_SUBJECT, sherSup);
                 shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                 startActivity(Intent.createChooser(shareIntent, "مشاركة بإستخدام"));
                 return true;
             }
             if (id==R.id.setting){
                 Toast.makeText(getApplicationContext(),"اعدادات",Toast.LENGTH_LONG).show();
                 return true;
             }
             if (id==R.id.send){

               try {
                 Intent s=new Intent(getApplicationContext(),send.class);
                 startActivity(s);
               } catch (Exception e) {
                   Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
               }
                 return true;
             }


             return false;
         }
     });
/*******************سلايدر *******************************/
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
       // inflater.inflate(R.menu.toolbar_search_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId())
        {
            case R.id.n:
                try {
                    AlertDialog.Builder a=new AlertDialog.Builder(context);
                    a.setTitle("نصائح!").setMessage("1-تاكد دائما من تنظسف يدك قبل الطبخ." +
                            "\n"+"2-غسل المكونات الخضراوات او الفواكه قبل الطبخ."+"\n"+"3-استمتع في الطبخ :)."
                    ).setPositiveButton("تمام", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog=a.create();
                    dialog.show();
                    return true;
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
                }
                break;




        }
        return super.onOptionsItemSelected(item);
    }



}
