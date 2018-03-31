package com.example.dorit.english;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
public class TheGame extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    String[] english;
    String[] hebrew;
    String[] temp1 = new String[20];

    ListView eng;
    int finalGrade;
    String finalGradestr;
    TextView word;
    TextView p;
    TextView tv;
    ArrayAdapter<String> adp;

    String check;
    int tries=0;
    int mistakes=0;
    int place=1;
    View v;
    Boolean tbtf;

    AlertDialog.Builder adb;

    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_game);

        Intent gi = getIntent();
        english = gi.getStringArrayExtra("eng");
        hebrew = gi.getStringArrayExtra("heb");
        tbtf = gi.getBooleanExtra("tbtf", true);


        eng = (ListView) findViewById(R.id.eng);
        word = (TextView) findViewById(R.id.word);
        p = (TextView) findViewById(R.id.p);
        tv = (TextView) findViewById(R.id.tv);

        SharedPreferences sharedPref = getSharedPreferences("SomeName", Context.MODE_PRIVATE);
        String retrievedString = sharedPref.getString("String1", "default");


        //values of hebrew or english go to temp
        if (tbtf == true) {
            for (int j = 0; j < 20; j++) {
                temp1[j] = hebrew[j];
            }
            word.setText(english[0]);
        } else {
            for (int j = 0; j < 20; j++) {
                temp1[j] = english[j];
            }
            word.setText(hebrew[0]);
        }


        for (int i = 0; i < 20; i++) {
            int num = rnd.nextInt(19);
            int num2 = rnd.nextInt(19);
            while (num == num2)
                num2 = rnd.nextInt(19);
            String temp = temp1[num];
            temp1[num] = temp1[num2];
            temp1[num2] = temp;
        }

        adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp1);
        eng.setAdapter(adp);
        eng.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        eng.setOnItemClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent tt = new Intent(this, credits.class);
        startActivity(tt);
        return true;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        check=temp1[position];

        Log.d("english:", "english1: " + (String) adapterView.getItemAtPosition(position));
    }

    public void cont2(View view) {
        if (place<20) {
            if (tbtf == true) {
                word.setText(english[place]);
                if (!(hebrew[place - 1].equals(check))) {
                    mistakes++;
                }
                tries++;
                p.setText("תשובות שגויות: " + mistakes + "\n" + "מספר נסיונות: " + tries);
            } else {
                word.setText(hebrew[place]);
                if (!(english[place - 1].equals(check))) {
                    mistakes++;
                }
                tries++;
                p.setText("תשובות שגויות: " + mistakes + "\n" + "מספר נסיונות: " + tries);
                tv.setText("התאם את המילה בעברית לפירושה באנגלית ולחץ 'המשך'");
            }
            place++;
        }
        else{
            adb=new AlertDialog.Builder(this);
            adb.setTitle("כל התשובות הושלמו");
            adb.setMessage("בבקשה לחץ על הכפתור 'סיימתי' על מנת להשלים");
            AlertDialog ad=adb.create();
            ad.show();
        }

    }

    public void conttoend(View view) {

        Intent t=new Intent(this,EndOfApp.class);
        t.putExtra("mistakes", mistakes);
        t.putExtra("tries", tries);
        startActivity(t);
    }


}
