package com.example.no8;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CommandActivity extends AppCompatActivity {
    //database
    private static final String DB_NAME = "MyList.db";
    private static String TABLE_NAME = "MyTable";
    private static final int DB_VERSION = 1;
    public static SQLiteDatabase db;
    public SQLiteDataBaseHelper sqlDataBaseHelper;


    public TextView tv_msg;
    public Button btn_create;
    public EditText editText_else;

    RecyclerView recyclerView;
    MyListAdapter myListAdapter;


    private ImageButton btn_back2;
    private ImageButton btn_plus;
    Dialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.command_page);
        initRCV();
        initCOM();
        setDialog();
        initDB();
    }



    private void initDB() {
        sqlDataBaseHelper = new SQLiteDataBaseHelper(CommandActivity.this,DB_NAME,null, DB_VERSION, TABLE_NAME);
        db = sqlDataBaseHelper.getWritableDatabase();
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("Comment", editText_else.getText().toString());
                //insert資料
                db.insert(TABLE_NAME, null, contentValues);
                Cursor c = db.rawQuery("SELECT * FROM "+"MyTable", null);
                c.moveToFirst();
                c.moveToNext();

//                db.execSQL("INSERT INTO MyTable(Comment,LikeNum)VALUES(? , 0)");

            }
        });
    }

    //設定dialog
    @SuppressLint("ResourceType")
    public void setDialog() {
        Context context = CommandActivity.this;
        dialog = new Dialog(context, R.layout.create_page);
        dialog.setContentView(R.layout.create_page);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_no);
        dialog.setCanceledOnTouchOutside(true);
        editText_else = dialog.findViewById(R.id.editText_else);
        btn_create = dialog.findViewById(R.id.btn_create);
    }

    public ArrayList<String> msgInArray() {
        sqlDataBaseHelper = new SQLiteDataBaseHelper(CommandActivity.this,DB_NAME,null, DB_VERSION, TABLE_NAME);
        db = sqlDataBaseHelper.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM MyTable", null);
        c.moveToFirst();
        //msgInArray().clear();
        for (int i = 0 ; i < c.getCount(); i++) {
            msgInArray().add(c.getString(1));
            c.moveToNext();
        }
        return msgInArray();
    }

    //RCV
    private void initRCV() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        ArrayList<String> MsgArrayList = msgInArray();
        myListAdapter = new MyListAdapter(MsgArrayList);
        recyclerView.setAdapter(myListAdapter);



        btn_back2 = findViewById(R.id.btn_back2);
        btn_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommandActivity.this,MainActivity.class));
            }
        });
        recyclerView.setVisibility(View.VISIBLE);
    }
    //show dialog
    private void initCOM() {
        btn_plus = findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }
}
