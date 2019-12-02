package com.example.lomba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {
    CarouselView carousel;
    CardView sejarah,about;
    int[] img = {R.drawable.a,R.drawable.g,R.drawable.so,R.drawable.spk,R.drawable.ma,R.drawable.dakwah,R.drawable.dakwah1,R.drawable.dakwah2,
            R.drawable.dakwah3,R.drawable.dakwah4,R.drawable.dakwah5,R.drawable.dakwah6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carousel = findViewById(R.id.carousel);
        carousel.setPageCount(img.length);
        carousel.setImageListener(imglistener);

        sejarah = findViewById(R.id.sejarah);


        sejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sej = new Intent(MainActivity.this, Sejarah.class);
                startActivity(sej);
            }
        });
    }



    ImageListener imglistener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(img[position]);

        }
    };

    public void dakwah(View view) {
        Intent dak = new Intent(MainActivity.this,Dakwah.class);
        startActivity(dak);

    }


    public void onAbout(View view) {
        Intent ab = new Intent(MainActivity.this,
                About.class);
        startActivity(ab);
    }
}
