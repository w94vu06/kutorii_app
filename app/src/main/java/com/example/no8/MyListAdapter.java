package com.example.no8;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    public TextView tv_msg;
    public Button btn_create;
    public EditText editText_else;
    RecyclerView recyclerView;
    MyListAdapter myListAdapter;

    private static final String DB_NAME = "MyList.db";
    private String TABLE_NAME = "MyTable";
    private static final int DB_VERSION = 1;
    public SQLiteDatabase db;
    public SQLiteDataBaseHelper sqlDataBaseHelper;

    private Context context;
    ArrayList<String> msgArray = new ArrayList<>();
    public MyListAdapter(ArrayList<String> msgArrayList) {
        this.msgArray = msgArrayList;
    }



    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {

        holder.tv_msg.setText(msgArray.get(position));
    }
    @Override
    public int getItemCount() {
        return msgArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_msg,tv_count;
        private ImageView img_like;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_msg = itemView.findViewById(R.id.tv_msg);
            tv_count = itemView.findViewById(R.id.tv_count);
            img_like = itemView.findViewById(R.id.img_like);

        }
    }
}
