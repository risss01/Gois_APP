package com.example.lomba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class Dakwah extends AppCompatActivity {

    ListView lvMain;

    private int[] mImages = new int[]{
            R.drawable.dakwah, R.drawable.dakwah1, R.drawable.dakwah2, R.drawable.dakwah3,
            R.drawable.dakwah4,R.drawable.dakwah5,R.drawable.dakwah6,
    };

    private String[] mImageTitle = new String[]{
            "", "", "", "", ""
    };

    String[] menuItem = {"gua tsur", "Perjalanan menyusuri koto thaif", "Perang Badar", "Khalid bin Walid", "Abdullah bin Aamir", "bilal bin rabah", "Hamzah bin Abdul Muthalib", };
    Integer[] menuImage = {
            R.drawable.dakwah,
            R.drawable.dakwah1,
            R.drawable.dakwah2,
            R.drawable.dakwah3,
            R.drawable.dakwah4,
            R.drawable.dakwah5,
            R.drawable.dakwah6,

    };
    String[] menuLagi = {"Hijrah Nabi Muhammad SAW dari Mekah ke Madinah menjadi peristiwa besar bagi umat Islam. Kisah itu punya makna mendalam bagi muslimin dunia.", "Kota yang dapat ditempuh 1 jam 45 menit dari Kota Mekah ", "Perang ini terjadi pada 17 Ramadan 2 H", "Khalid bin Walid seorang panglima perang",
            "Abdullah bin Amr lebih dulu masuk Islam ketimbang bapaknya, Amr bin Ash. ", "Muazin Rasulullah Shalallahu ‘alaihi wasallam, memiliki kisah menarik tentang sebuah perjuangan mempertahankan aqidah.",
            "Sejak muda, paman Rasulullah ini memang hobi dan gemar berburu binatang.", };

    String[] url = {"https://m.dream.co.id/jejak/kisah-hijrah-nabi-muhammad-151013g.html", "https://www.dream.co.id/jejak/menyusuri-kota-thaif-tempat-ujian-berat-sang-rasul-150902z.html", "https://www.dream.co.id/news/6-fakta-pertempuran-badar-kemenangan-besar-umat-muslim-170614a.html",
            "https://www.dream.co.id/orbit/khalid-bin-walid-panglima-muslim-berjuluk-pedang-allah-170622c.html", "https://www.republika.co.id/berita/dunia-islam/khazanah/11/05/12/ll2rnt-kisah-sahabat-nabi-abdullah-bin-amr-ahli-ibadah-yang-rajin-tobat","https://kisahmuslim.com/700-kisah-perjuangan-bilal-bin-rabah-radhiallahu-anhu.html",
            "https://www.republika.co.id/berita/dunia-islam/khazanah/11/07/25/lovp5n-kisah-sahabat-nabi-hamzah-bin-abdul-muthalib-pemimpin-para-syuhada", };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dakwah);

        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);

            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(Dakwah.this, mImageTitle[position], Toast.LENGTH_SHORT).show();
            }
        });

        CostumListAdapter adapter = new CostumListAdapter(this, menuItem, menuImage, menuLagi);
        lvMain = findViewById(R.id.lvMain);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Yang diklik adalah posisi ke : " + position, Toast.LENGTH_LONG).show();
                startActivity(new Intent(Dakwah.this, DetailAct.class)
                        .putExtra("url", url[position]));
            }
        });
    }
    }

