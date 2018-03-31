package com.example.dorit.english;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EndOfApp extends AppCompatActivity {

    int finalGrade;
    int mistakes;
    int tries;

    TextView tm;
    TextView fm;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_app);

        Intent gi = getIntent();
        mistakes = gi.getIntExtra("mistakes",0);
        tries = gi.getIntExtra("tries",0);

        tm = (TextView) findViewById(R.id.tm);
        fm = (TextView) findViewById(R.id.fg);

        tries++;


        finalGrade = ((tries-mistakes)*100)/tries;

        fm.setText("ציונך הסופי הוא: "+finalGrade);
        tm.setText("מספר הנסיונות: "+tries+"\n"+"מספר הטעויות: "+mistakes);

        SharedPreferences sharedPref = getSharedPreferences("SomeName", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("String1", "grade"+finalGrade);  // value is the string you want to save
        editor.commit();


    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent tt = new Intent(this, credits.class);
        startActivity(tt);
        return true;
    }

    public void backtoopening(View view) {
        Intent t=new Intent(this,Opening.class);
        startActivity(t);
    }
}
