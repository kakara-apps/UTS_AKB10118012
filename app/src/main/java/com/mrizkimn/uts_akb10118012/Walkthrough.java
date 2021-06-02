package com.mrizkimn.uts_akb10118012;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mrizkimn.uts_akb10118012.fragments.Walkthrough1;
import com.mrizkimn.uts_akb10118012.fragments.Walkthrough2;
import com.mrizkimn.uts_akb10118012.fragments.Walkthrough3;

import java.util.ArrayList;
import java.util.List;

//Moch Rizki Maulana N
//10118012
//IF-1
//26-05-2021

public class Walkthrough extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    TextView pageCounter;
    Button btnLewati;
    int total = 3 , count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        List<Fragment> list = new ArrayList<>();
        list.add(new Walkthrough1());
        list.add(new Walkthrough2());
        list.add(new Walkthrough3());

        pageCounter = findViewById(R.id.page_counter);
        pageCounter.setText(count +"/"+ total);
        btnLewati = findViewById(R.id.tv_lewati);

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);


        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                count = 0;
                count = position + 1;
                pageCounter.setText(count +"/"+ total);

                if(count == total){
                    btnLewati.setText("Mulai");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void mulai(View view){
        Intent i = new Intent(Walkthrough.this, HomeActivity.class);
        startActivity(i);
        finish();
    }

}