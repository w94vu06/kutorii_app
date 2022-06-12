package com.example.no8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.facebook.stetho.Stetho;

import java.time.Instant;

public class MainActivity extends Activity {

    private ImageButton imageBtn_history,imageBtn_record,imageBtn_command,imageBtn_sight,imageBtn_prevent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        initView();

        Stetho.initializeWithDefaults(this);
    }


    private void initDate(){
        imageBtn_history = findViewById(R.id.img_history);
        imageBtn_record = findViewById(R.id.img_record);
        imageBtn_command = findViewById(R.id.img_command);
        imageBtn_sight = findViewById(R.id.img_sight);
        imageBtn_prevent = findViewById(R.id.img_prevent);

    }
    private void initView(){
        imageBtn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_history = new Intent();
                it_history.setClass(MainActivity.this, HistoryActivity.class);
                startActivity(it_history);
            }
        });
        imageBtn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_record = new Intent();
                it_record.setClass(MainActivity.this, RecordActivity.class);
                startActivity(it_record);
            }
        });
        imageBtn_command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_command = new Intent();
                it_command.setClass(MainActivity.this, CommandActivity.class);
                startActivity(it_command);
            }
        });
        imageBtn_sight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_sight = new Intent();
                it_sight.setClass(MainActivity.this, SightActivity.class);
                startActivity(it_sight);
            }
        });
        imageBtn_prevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_prevent = new Intent();
                it_prevent.setClass(MainActivity.this, PreventActivity.class);
                startActivity(it_prevent);
            }
        });

    }
}