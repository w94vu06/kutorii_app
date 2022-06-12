package com.example.no8;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import org.osmdroid.views.MapView;
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

public class PreventActivity extends AppCompatActivity {
    private Button btn_back2;
    MapView map2, mMap2;
    Dialog dialog2;
    public TextView tv_dialog_title2, tv_dialog_content2;
    ImageView img_dialog_main2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prevent_page);
        initDate();
        mapView2();
        setDialog();
    }

    private void initDate() {
        btn_back2 = findViewById(R.id.btn_back2);
        btn_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_back = new Intent();
                it_back.setClass(PreventActivity.this, MainActivity.class);
                startActivity(it_back);
            }
        });
    }

    public void mapView2(){
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        map2 = (MapView) findViewById(R.id.map2);
        map2.setTileSource(TileSourceFactory.MAPNIK);
        map2.setBuiltInZoomControls(true);
        map2.setMultiTouchControls(true);
        IMapController mapController = map2.getController();
        mapController.setZoom(16);
        GeoPoint startPoint = new GeoPoint(23.717540, 120.450067);
        mapController.setCenter(startPoint);
        //this.myLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(ctx),map);
        //this.myLocationOverlay.enableMyLocation();
        //map.getOverlays().add(this.myLocationOverlay);
        putItems();
    }

    private int[] picture = {R.drawable.img_prevent2,R.drawable.img_prevent3,R.drawable.img_prevent4,R.drawable.img_prevent5,};
    private String[] title = {"A.堀頭里辦公處","B.埒內里親水公園","C.埓内里親水公園旁","D.埓内里親水公園旁","E.三姓公廟旁",
            "F.三姓公廟公廁牆上","G.三姓公前方路燈下","H.三姓公往堀頭里內","I.三姓公廟往堀頭里内",
            "J.桂花園旁","K.大閘蟹生態養殖場旁","L.大閘蟹生態養殖場","M.元維紡織廠旁"};
    private String[] content = {"設備：淹水感測器","設備：水尺","設備：雨量筒","設備：智慧水尺"};

    @SuppressLint("ResourceType")
    public void setDialog() {
        Context context = PreventActivity.this;
        dialog2 = new Dialog(context, R.layout.dialog_mode2);
        dialog2.setContentView(R.layout.dialog_mode2);
        dialog2.getWindow().setBackgroundDrawableResource(R.drawable.dialog_no);

        tv_dialog_title2 = (TextView) dialog2.findViewById(R.id.tv_dialog_title2);
        tv_dialog_content2 = (TextView) dialog2.findViewById(R.id.tv_dialog_content2);
        img_dialog_main2 = (ImageView) dialog2.findViewById(R.id.img_dialog_main2);

        ImageView close =(ImageView) dialog2.findViewById(R.id.close2);
        dialog2.setCanceledOnTouchOutside(true);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });
    }

    public void putItems() {
        Context ctx = getApplicationContext();
        ArrayList<OverlayItem> items = new ArrayList<>();
        items.add(new OverlayItem("A.堀頭里辦公處_雨量筒","",new GeoPoint(23.71888, 120.45025)));
        items.add(new OverlayItem("B.埒內里親水公園_淹水感測器","",new GeoPoint(23.72112, 120.44886)));
        items.add(new OverlayItem("C.埓内里親水公園旁_水尺","",new GeoPoint(23.72151, 120.44809)));
        items.add(new OverlayItem("D.埓内里親水公園旁_智慧水尺","",new GeoPoint(23.72096, 120.44765)));
        items.add(new OverlayItem("E.三姓公廟旁_智慧水尺","",new GeoPoint(23.71818, 120.44628)));
        items.add(new OverlayItem("F.三姓公廟公廁牆上_水尺","",new GeoPoint(23.71817, 120.44641)));
        items.add(new OverlayItem("G.三姓公前方路燈下_淹水感測器","",new GeoPoint(23.718, 120.44714)));
        items.add(new OverlayItem("H.三姓公往堀頭里內_水尺","",new GeoPoint(23.7181, 120.44754)));
        items.add(new OverlayItem("I.三姓公廟往堀頭里内_水尺","",new GeoPoint(23.7181, 120.44777)));
        items.add(new OverlayItem("J.桂花園旁_水尺","",new GeoPoint(23.71654, 120.44721)));
        items.add(new OverlayItem("K.大閘蟹生態養殖場旁_水尺","",new GeoPoint(23.7139, 120.45347)));
        items.add(new OverlayItem("L.大閘蟹生態養殖場_淹水感測器","",new GeoPoint(23.71391, 120.45373)));
        items.add(new OverlayItem("M.元維紡織廠旁_水尺","",new GeoPoint(23.71532, 120.45209)));
        mMap2 = (MapView) findViewById(R.id.map2);
        //{"設備：淹水感測器","設備：水尺","設備：雨量筒","設備：智慧水尺"}
        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(items, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                if (index == 0) {
                    img_dialog_main2.setImageResource(picture[2]);
                    tv_dialog_title2.setText(title[0]);
                    tv_dialog_content2.setText(content[2]);
                    dialog2.show();
                }
                if (index == 1) {
                    img_dialog_main2.setImageResource(picture[0]);
                    tv_dialog_title2.setText(title[1]);
                    tv_dialog_content2.setText(content[0]);
                    dialog2.show();
                }
                if (index == 2) {
                    img_dialog_main2.setImageResource(picture[1]);
                    tv_dialog_title2.setText(title[2]);
                    tv_dialog_content2.setText(content[1]);
                    dialog2.show();
                }
                if (index == 3) {
                    img_dialog_main2.setImageResource(picture[3]);
                    tv_dialog_title2.setText(title[3]);
                    tv_dialog_content2.setText(content[3]);
                    dialog2.show();
                }
                if (index == 4) {
                    img_dialog_main2.setImageResource(picture[3]);
                    tv_dialog_title2.setText(title[4]);
                    tv_dialog_content2.setText(content[3]);
                    dialog2.show();
                }
                if (index == 5) {
                    img_dialog_main2.setImageResource(picture[1]);
                    tv_dialog_title2.setText(title[5]);
                    tv_dialog_content2.setText(content[1]);
                    dialog2.show();
                }

                if (index == 6) {
                    img_dialog_main2.setImageResource(picture[0]);
                    tv_dialog_title2.setText(title[6]);
                    tv_dialog_content2.setText(content[0]);
                    dialog2.show();
                }
                if (index == 7) {
                    img_dialog_main2.setImageResource(picture[1]);
                    tv_dialog_title2.setText(title[7]);
                    tv_dialog_content2.setText(content[1]);
                    dialog2.show();
                }
                if (index == 8) {
                    img_dialog_main2.setImageResource(picture[1]);
                    tv_dialog_title2.setText(title[8]);
                    tv_dialog_content2.setText(content[1]);
                    dialog2.show();
                }
                if (index == 9) {
                    img_dialog_main2.setImageResource(picture[1]);
                    tv_dialog_title2.setText(title[9]);
                    tv_dialog_content2.setText(content[1]);
                    dialog2.show();
                }
                if (index == 10) {
                    img_dialog_main2.setImageResource(picture[1]);
                    tv_dialog_title2.setText(title[10]);
                    tv_dialog_content2.setText(content[1]);
                    dialog2.show();
                }
                if (index == 11) {
                    img_dialog_main2.setImageResource(picture[0]);
                    tv_dialog_title2.setText(title[11]);
                    tv_dialog_content2.setText(content[0]);
                    dialog2.show();
                }
                if (index == 12) {
                    img_dialog_main2.setImageResource(picture[1]);
                    tv_dialog_title2.setText(title[12]);
                    tv_dialog_content2.setText(content[1]);
                    dialog2.show();
                }

                return false;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        }, ctx);

        mOverlay.setFocusItemsOnTap(true);
        mMap2.getOverlays().add(mOverlay);
    }
}
