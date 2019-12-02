package com.example.lomba;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.Arrays;
import java.util.List;

public class Sejarah extends AppCompatActivity {
    CarouselView crs;
    ListView listView;

    int[] mg = {R.drawable.utomo, R.drawable.batavia, R.drawable.aru, R.drawable.ban, R.drawable.spk};

    String [] nama ={
            "Peristiwa G30SPKI",
            "Perang Gerilya Yg Di Pimpin Jendral Soedirman",
            "Perang Padri",
            "Bandung Lautan Api",
            "PERTEMPURAN LAUT ARU (Maluku)",
            "Penyerbuan Batavia (1628-1629)",
            "Serangan 10 November 1945"
    };

    Integer[] gambar ={
            R.drawable.g,R.drawable.soedir,R.drawable.padri,R.drawable.laut,R.drawable.aru1,R.drawable.batavia1,R.drawable.utomo1 };

    private String[] mImageTitle = new String[]{
            "", "", "", "", ""};

    String[] menuLagi = {" ", " ", " ", " ", " ", " ", " "};

    String[] url = {"https://sejarahlengkap.com/indonesia/kemerdekaan/pasca-kemerdekaan/peristiwa-g30spki ","" +
                    "https://www.merdeka.com/peristiwa/kisah-jenderal-soedirman-memimpin-perang-gerilya-di-atas-tandu.html"
                    ,"https://sejarahlengkap.com/indonesia/sejarah-perang-padri"
                    ,"https://seruni.id/peristiwa-bandung-lautan-api/"
                    ,"https://id.wikipedia.org/wiki/Pertempuran_Laut_Aru"
                    ,"https://sains.kompas.com/read/2017/06/28/160800223/kisah.batavia.yang.dijuluki.kota.tahi.oleh.prajurit.mataram?page=all"
                    ,"https://www.merdeka.com/peristiwa/ini-akhir-dramatis-pertempuran-10-november-1945-di-surabaya.html"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sejarah);



        crs  = findViewById(R.id.crs);
        crs.setPageCount(mg.length);
        crs.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mg[position]);

            }
        });
        crs.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(Sejarah.this, mImageTitle[position], Toast.LENGTH_SHORT).show();
            }
        });

        CostumListAdapter adapter = new CostumListAdapter(this, nama, gambar, menuLagi );
        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Yang diklik adalah posisi ke : " + position, Toast.LENGTH_LONG).show();
                startActivity(new Intent(Sejarah.this, DetailSejarah.class)
                        .putExtra("url", url[position]));
            }
        });
    }
    }
