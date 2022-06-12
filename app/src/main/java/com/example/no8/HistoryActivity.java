package com.example.no8;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private Banner banner;
    private GlideImageLoader glideImageLoader;
    private List<Integer> imagePath;
    private TextView tv_history_content;
    private ImageButton btn_back;


    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_page);
        initDate();
        initView();

    }

    private void initDate() {
        imagePath = new ArrayList<>();
        imagePath.add(R.drawable.history1);
        imagePath.add(R.drawable.history2);
        imagePath.add(R.drawable.history3);
        tv_history_content = findViewById(R.id.tv_history_content);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_back = new Intent();
                it_back.setClass(HistoryActivity.this, MainActivity.class);
                startActivity(it_back);
            }
        });
    }

    private void initView() {
        tv_history_content.setText("　　早年堀頭里內有很多坑，堀邊有一堆一堆的土堆，遠處遙望，土堆像似人頭，因而把此地稱叫〝堀頭〞。" +
                "\n　　據〝雲林縣採訪冊〞所載清代大坵田東堡，堡內45莊，已有堀頭莊，當時29戶，60丁人口為鄰莊埒內三分之一，早年一部份人口，由大陸福建而來，大部份人口從埒內莊移墾過來，目前里內以黃姓及王姓二大姓為主。" +
                "\n　　本里農特產以土豆(花生)、稻米、蒜頭、玉米及毛巾為主。");
        glideImageLoader = new GlideImageLoader();
        banner = findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CENTER);
        banner.setImageLoader(glideImageLoader);
        banner.setDelayTime(2000);
        banner.setImages(imagePath);
        banner.start();
    }
}
