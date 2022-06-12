package com.example.no8;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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

public class SightActivity extends AppCompatActivity {
    private ImageButton btn_back,img_btn_close;
    private TextView tv_dialog_title, tv_dialog_content;

    ImageView img_dialog_main;
    MapView map,mMap;
    MyLocationNewOverlay myLocationOverlay;
    Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sight_page);
        initDate();
        mapView();
        setDialog();
    }

    private void initDate() {
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_back = new Intent();
                it_back.setClass(SightActivity.this, MainActivity.class);
                startActivity(it_back);
            }
        });
    }

    public void mapView(){
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        IMapController mapController = map.getController();
        mapController.setZoom(18);
        GeoPoint startPoint = new GeoPoint(23.717540, 120.450067);
        mapController.setCenter(startPoint);
        //this.myLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(ctx),map);
        //this.myLocationOverlay.enableMyLocation();
        //map.getOverlays().add(this.myLocationOverlay);
        putItems();
    }

    private int[] picture = {R.drawable.img_sight1, R.drawable.img_sight2, R.drawable.img_sight3,
            R.drawable.img_sight4, R.drawable.img_sight5, R.drawable.img_sight6, R.drawable.img_sight7,
            R.drawable.img_sight8, R.drawable.img_sight9, R.drawable.img_sight10, R.drawable.img_sight11,
            R.drawable.img_sight12, R.drawable.img_sight13, R.drawable.img_sight14, R.drawable.img_sight15,
            R.drawable.img_sight16, R.drawable.img_sight17, R.drawable.img_sight18, R.drawable.img_sight19,
            R.drawable.img_sight20, R.drawable.img_sight21,};

    private String[] title = {"堀頭里社區活動中心",
            "堀頭里長青食堂", "長泰老學堂日照中心", "埒內里親水公園", "三姓公廟", "桂花園", "堀頭里大閘蟹生態養殖場",
            "元維棉織廠", "紫雲寺", "雷雲宮", "雷雲園", "金鵬巾緻親子館", "堀頭里社區公園", "虎尾菜刀店", "彩繪古亭畚",
            "堀頭28落羽松秘境", "3D立體彩繪牆", "馬賽克文化藝術牆", "彩色小石子藝術牆", "社區小角落","詮益棉織公司"};

    private String[] intro = {"本活動中心採用綠色建築的建造理念 、建築風格體現地方特色,內部設施 以安全、方便舒適為原則,作為里民 集會、聯誼、室內運動及學生課輔場 所,有助於起聚社區向心力的一個場所。",
            "自105年6月設立至今,共嘉惠70名老 人用餐,社區落實落實社會福利社區化原則,結合社會資源共同推動老人 服務,符合在地老化及多元連續服務之目標。",
    "以自立支援照顧的模式,改變長輩的認知與觀念,幫助長輩們重新找回支配自己的意願與生活能力,長輩來到這裡上學,透過學習讓長輩的日常能力提升,達到降低照顧負擔,進而對整體家庭與社會形成良性的循環",
    "位於堀頭、埒內交界,公園周邊鳥類、植物種類約有120種,社區發展協會動員居民自行鋪設環湖步道,大家參與增加認同感,目前運動人口急速增加,除了建設社區景觀與環境維護,更藉此營造居民戶外活動空間," +
            "每到夜晚便可看到居民攜家帶眷到公園散步。",
            "位於臺灣雲林縣虎尾級埒內里萬應公廟,該廟主要奉祀二二八事件死者顧尚泰、李持芳、王濟寧，配祀金、廖姓女子,於1975年-虎尾鎮民陳竹芳等人先在公墓內建小祠祭祀他們。 1970年代末於改建於現址。",
    "105年本里所推動之「閒置空地埋美化」行動項目,以公有土地及社區居民自願提供之土地將其綠美化成社區公到,面積80坪,傍晚或吃完飯後,居民會散步聊聊天增進感情,也曾自動自發撿拾垃圾·" +
            "提升社區居民參與 並增加社區居民的生活品質,亦達到節能減碳兼具實用之目的。",
    "虎尾鎮大閘蟹生態養殖場負責人黃宥霖 ,以生態養殖與中國大陸的大閘蟹做區 隔,訴求禁藥零檢出、蟹苗直接在台灣 養殖7至8個月才出貨。雖然不投藥養殖 的育成率僅3成,與一般傳統養殖的5成以上相比低了許多," +
            "但他就是堅持「美味與安全兼具,才是最好的大閘蟹」",
            "從事毛巾代工生產,今日已有12台紡織機的生產規模。歷經產業環境轉變,也渡過低價品的競爭,開始重視研發與生產技術的提升與改善。目前品質漸受國內外客戶肯定",
            "紫雲寺主要供奉黑面送子觀音佛祖,而本里自供奉觀世音菩薩後,居民安居樂業,人丁興旺,此乃佛祖庇境護民之功 ,里民有感於此,乃共議建廟,於民國五十二年冬,動土興建,至五十三年三月落成,定名為「紫雲寺」",
            "相傳早年有一次淹大水,漂來神主牌並托夢於本里里民黃來成老先生,神主牌上有29位神公,内有醫生等各行業,最長者姓雷,因無法考據而以雷府29神公廟稱之,原先只是間小廟,村民有失竊患農具、抽水馬達及牛隻,求神公都能找回 ·浙浙香火鼎盛而蓋廟,並取名為雷雲宮",
            "雷雲圖為102年度林務局植樹綠美化計畫施作的口袋公園,原為髒亂不勘的磁 陋空間,經綠美化后,轉變成美麗的小公園,不但能提供民眾休息,由於位於長泰老學堂旁,也能提供學堂内長者散步的空間,其效益大大提升了。",
            "結合毛巾產業與文創,創造出特色親子館,全館共有6個以毛巾打造的主題空間、毛巾製作的世界名畫,親子空間,充滿溫馨與藝術風格,讓大人小孩都沉浸在歡樂氣氛中,也為毛巾產業開創新風貌。",
            "原為家庭式毛巾工廠,位於里中心,其製作毛巾的機器聲音及四處飄揚的棉絮讓鄰 近居民不堪其擾·李萬壽里長多次和業 協調,最後者關廠並將土地無償交給協會運用,協會將其建蓋成一座休憩運動公園,提供社區居民運動空間,並建置兒童 遊樂場,讓社區老老少少都能使用,大大提升了公園的利用性。",
            "陳永和先生從事菜刀製作近30年，虎尾菜刀原廠位於頂溪里，10年前遷至堀頭，製作的菜刀種類多樣，有傳統菜刀、西瓜刀、檳榔刀等，其菜刀製作方式為鍛燒，因此，菜刀品質優良且兼顧耐用，許多大廠都請他代工。目前二代也傳承這傳統的技藝，將卓越的菜刀製作技術延續下去。",
            "結合學校文創資源建構社區成為富有文化氣息之典範農農業社區。不僅將古亭畚彩繪變裝，同時將其保存",
            "夏季的落羽松林，宛如綠色隧道般寧靜又夢幻，而落羽松最矚目的時節更便是秋冬由綠轉黃、轉紅的時候，隨著季節更迭金色、橙色、深紅樹叢層層堆疊，專屬冬季的美景一年僅有一次，堀頭落羽松步道帶給居民更美好的生活環境與放鬆休閒的好去處。",
            " 將堀頭在地產業、農特產品結合到牆面上，利用3D彩繪技術，使得照片看起來栩栩如生，不僅創造出具有特色的農村聚落風光，同時也提供社區居民及遊客休憩活動之場所，並期能吸引更多遊客駐足。",
            "結合學校文創資源建構社區成為富有文化氣息之典範農業社區。利用馬賽克磚美化牆面，將堀頭在地產業、能特產品結合到牆面上，形成堀頭特有文化藝術牆。",
            "利用交彩色小石子、大理石碎片美化牆面，將堀頭在地產業、農特產品結合到牆面上形成堀頭里特有文化藝術牆，創造出具有特色的農村具落風光。",
            "社區居民將雜貨店店面的空地提供出來，希望營造出兒時學校及大家在井邊談天說笑的回憶，讓居民擁有一個能聊天、買零嘴的休憩空間。",
            "始於1991年，由國外引進24台最新電腦高速提花機，2台噴氣高速織造機，製造一體成形的毛巾、浴巾等產品，以與其他棉織工廠做市場區隔，其工作團隊陣容強大，產量高，交貨快，專業提供品質優良的毛巾產品。",};


    @SuppressLint("ResourceType")
    public void setDialog() {
        Context context = SightActivity.this;
        dialog = new Dialog(context, R.layout.dialog_mode);
        dialog.setContentView(R.layout.dialog_mode);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_no);

        tv_dialog_title = (TextView) dialog.findViewById(R.id.tv_dialog_title);
        tv_dialog_content = (TextView) dialog.findViewById(R.id.tv_dialog_content);
        img_dialog_main = (ImageView) dialog.findViewById(R.id.img_dialog_main);

        ImageView close =(ImageView) dialog.findViewById(R.id.close);
        dialog.setCanceledOnTouchOutside(true);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public void putItems() {
        Context ctx = getApplicationContext();
        ArrayList<OverlayItem> items = new ArrayList<>();
        items.add(new OverlayItem("1.堀頭里社區活動中心","",new GeoPoint(23.718707935523685,120.45237181663238)));
        items.add(new OverlayItem("2.堀頭里長青食堂","",new GeoPoint(23.71819,120.45041)));
        items.add(new OverlayItem("3.長泰老學堂日照中心","",new GeoPoint(23.718707935523685,120.45237181663238)));
        items.add(new OverlayItem("4.埒內里親水公園","",new GeoPoint(23.72022, 120.44722)));
        items.add(new OverlayItem("5.三姓公廟","",new GeoPoint(23.71844, 120.44652)));
        items.add(new OverlayItem("6.桂花園","",new GeoPoint(23.71653, 120.44847)));
        items.add(new OverlayItem("7.堀頭里大閘蟹生態養殖場","",new GeoPoint(23.7139, 120.45384)));
        items.add(new OverlayItem("8.元維棉織廠","",new GeoPoint(23.71475, 120.45226)));
        items.add(new OverlayItem("9.紫雲寺","",new GeoPoint(23.71852, 120.45029)));
        items.add(new OverlayItem("10.雷雲宮","",new GeoPoint(23.71901, 120.4522)));
        items.add(new OverlayItem("11.雷雲園","",new GeoPoint(23.71875, 120.45235)));
        items.add(new OverlayItem("12.金鵬巾緻親子館","",new GeoPoint(23.7193, 120.4483)));
        items.add(new OverlayItem("13.堀頭里社區公園","",new GeoPoint(23.718, 120.45058)));
        items.add(new OverlayItem("14.虎尾菜刀店","",new GeoPoint(23.71681, 120.45133)));
        items.add(new OverlayItem("15.彩繪古亭畚","",new GeoPoint(23.71672, 120.45111)));
        items.add(new OverlayItem("16.堀頭28落羽松秘境","",new GeoPoint(23.71536, 120.45123)));
        items.add(new OverlayItem("17.3D立體彩繪牆","",new GeoPoint(23.7182, 120.45006)));
        items.add(new OverlayItem("18.馬賽克文化藝術牆","",new GeoPoint(23.71698, 120.45103)));
        items.add(new OverlayItem("19.彩色小石子藝術牆","",new GeoPoint(23.71713, 120.45011)));
        items.add(new OverlayItem("20.社區小角落","",new GeoPoint(23.7182, 120.45054)));
        items.add(new OverlayItem("21.詮益棉織公司","",new GeoPoint(23.71574, 120.45093)));
        mMap = (MapView) findViewById(R.id.map);

        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(items, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                if (index == 0) {
                    img_dialog_main.setImageResource(picture[0]);
                    tv_dialog_content.setText(intro[0]);
                    tv_dialog_title.setText(title[0]);
                    dialog.show();
                }
                if (index == 1) {
                    img_dialog_main.setImageResource(picture[1]);
                    tv_dialog_content.setText(intro[1]);
                    tv_dialog_title.setText(title[1]);
                    dialog.show();
                }
                if (index == 2) {
                    img_dialog_main.setImageResource(picture[2]);
                    tv_dialog_content.setText(intro[2]);
                    tv_dialog_title.setText(title[2]);
                    dialog.show();
                }
                if (index == 3) {
                    img_dialog_main.setImageResource(picture[3]);
                    tv_dialog_content.setText(intro[3]);
                    tv_dialog_title.setText(title[3]);
                    dialog.show();
                }
                //三姓公廟
                if (index == 4) {
                    img_dialog_main.setImageResource(picture[4]);
                    tv_dialog_content.setText(intro[4]);
                    tv_dialog_title.setText(title[4]);
                    dialog.show();
                }
                if (index == 5) {
                    img_dialog_main.setImageResource(picture[5]);
                    tv_dialog_content.setText(intro[5]);
                    tv_dialog_title.setText(title[5]);
                    dialog.show();
                }
                if (index == 6) {
                    img_dialog_main.setImageResource(picture[6]);
                    tv_dialog_content.setText(intro[6]);
                    tv_dialog_title.setText(title[6]);
                    dialog.show();
                }
                if (index == 7) {
                    img_dialog_main.setImageResource(picture[7]);
                    tv_dialog_content.setText(intro[7]);
                    tv_dialog_title.setText(title[7]);
                    dialog.show();
                }
                if (index == 8) {
                    img_dialog_main.setImageResource(picture[8]);
                    tv_dialog_content.setText(intro[8]);
                    tv_dialog_title.setText(title[8]);
                    dialog.show();
                }
                if (index == 9) {
                    img_dialog_main.setImageResource(picture[9]);
                    tv_dialog_content.setText(intro[9]);
                    tv_dialog_title.setText(title[9]);
                    dialog.show();
                }
                if (index == 10) {
                    img_dialog_main.setImageResource(picture[10]);
                    tv_dialog_content.setText(intro[10]);
                    tv_dialog_title.setText(title[10]);
                    dialog.show();
                }
                if (index == 11) {
                    img_dialog_main.setImageResource(picture[11]);
                    tv_dialog_content.setText(intro[11]);
                    tv_dialog_title.setText(title[11]);
                    dialog.show();
                }
                if (index == 12) {
                    img_dialog_main.setImageResource(picture[12]);
                    tv_dialog_content.setText(intro[12]);
                    tv_dialog_title.setText(title[12]);
                    dialog.show();
                }
                if (index == 13) {
                    img_dialog_main.setImageResource(picture[13]);
                    tv_dialog_content.setText(intro[13]);
                    tv_dialog_title.setText(title[13]);
                    dialog.show();
                }
                if (index == 14) {
                    img_dialog_main.setImageResource(picture[14]);
                    tv_dialog_content.setText(intro[14]);
                    tv_dialog_title.setText(title[14]);
                    dialog.show();
                }
                if (index == 15) {
                    img_dialog_main.setImageResource(picture[15]);
                    tv_dialog_content.setText(intro[15]);
                    tv_dialog_title.setText(title[15]);
                    dialog.show();
                }
                if (index == 16) {
                    img_dialog_main.setImageResource(picture[16]);
                    tv_dialog_content.setText(intro[16]);
                    tv_dialog_title.setText(title[16]);
                    dialog.show();
                }
                if (index == 17) {
                    img_dialog_main.setImageResource(picture[17]);
                    tv_dialog_content.setText(intro[17]);
                    tv_dialog_title.setText(title[17]);
                    dialog.show();
                }
                if (index == 18) {
                    img_dialog_main.setImageResource(picture[18]);
                    tv_dialog_content.setText(intro[18]);
                    tv_dialog_title.setText(title[18]);
                    dialog.show();
                }
                if (index == 19) {
                    img_dialog_main.setImageResource(picture[19]);
                    tv_dialog_content.setText(intro[19]);
                    tv_dialog_title.setText(title[19]);
                    dialog.show();
                }
                if (index == 20) {
                    img_dialog_main.setImageResource(picture[20]);
                    tv_dialog_content.setText(intro[20]);
                    tv_dialog_title.setText(title[20]);
                    dialog.show();
                }
                if (index == 21) {
                    img_dialog_main.setImageResource(picture[21]);
                    tv_dialog_content.setText(intro[21]);
                    tv_dialog_title.setText(title[21]);
                    dialog.show();
                }
                return false;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        }, ctx);

        mOverlay.setFocusItemsOnTap(true);
        mMap.getOverlays().add(mOverlay);
    }


}
