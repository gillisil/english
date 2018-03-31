package com.example.dorit.english;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class BeforeTheGame extends AppCompatActivity {

    String[] english;
    String[] hebrew;
    Button ready;
    Boolean tbtf=true;
    TextView words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_the_game);

        ready = (Button) findViewById(R.id.ready);
        words = (TextView) findViewById(R.id.words);


        Intent gi=getIntent();
        english=gi.getStringArrayExtra("eng");
        hebrew=gi.getStringArrayExtra("heb");
        tbtf=gi.getBooleanExtra("tbtf",true);

        if (tbtf==true);
            for (int i=0;i<20;i++){
                words.setText(words.getText()+english[i]+" = "+hebrew[i]+"\n");
            }


        Log.d("english beforegame:","english1: "+ Arrays.toString(english));
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

    public void cont(View view) {
        Intent t=new Intent(this,TheGame.class);
        t.putExtra("eng", english);
        t.putExtra("heb", hebrew);
        t.putExtra("tbtf",tbtf);
        startActivity(t);
    }
}
