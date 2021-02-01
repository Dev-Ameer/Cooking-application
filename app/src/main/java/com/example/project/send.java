package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class send extends AppCompatActivity {
EditText e1,e2;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
try {


    e1=findViewById(R.id.edsubject);
    e2=findViewById(R.id.emessge);
    b=findViewById(R.id.bsend);

    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "damer.ucst@gmail.com"));
            String a=e1.getText().toString();
            String a1=e2.getText().toString();
            intent.putExtra(Intent.EXTRA_SUBJECT,a);
            intent.putExtra(Intent.EXTRA_TEXT,a1);
            startActivity(intent);
        }
    });

} catch (Exception e) {
    Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.backe,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.backe:
                Intent i=new Intent(getApplicationContext(), MainAct.class);
                startActivity(i);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
