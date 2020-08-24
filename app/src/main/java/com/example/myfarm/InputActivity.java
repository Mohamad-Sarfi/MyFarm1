package com.example.myfarm;

import android.os.Bundle;

import com.example.myfarm.fragments.InputFertilizerFrag;
import com.example.myfarm.fragments.InputIrrigationFrag;
import com.example.myfarm.fragments.InputOthersFrag;
import com.example.myfarm.fragments.InputPesticidesFrag;
import com.example.myfarm.ui.ViewPagerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity
        implements InputFertilizerFrag.fragmentListener,
        InputIrrigationFrag.irrigationFragListener
{

    TabLayout tabLayout;
    AppBarLayout appBarLayout;
    ViewPager viewPager;
    ImageView imageView;
    TextView titleTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        appBarLayout = findViewById(R.id.appbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.veiwPager);
        imageView = findViewById(R.id.appbar_image);
        titleTV = findViewById(R.id.titleTxt2);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


        viewPagerAdapter.addFragments(new InputIrrigationFrag(), "آبیاری");
        viewPagerAdapter.addFragments(new InputFertilizerFrag(), "تغذیه");
        viewPagerAdapter.addFragments(new InputPesticidesFrag(), "سمپاشی");
        viewPagerAdapter.addFragments(new InputOthersFrag(), "متفرقه");

        viewPager.setAdapter(viewPagerAdapter);


        tabLayout.setupWithViewPager(viewPager);





        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int pos = tabLayout.getSelectedTabPosition();
                switch (pos){
                    case 0:
                        //imageView.setImageResource(R.drawable.watering);
                        titleTV.setText("آبیاری");
                        break;
                    case 1:
                        //imageView.setImageResource(R.drawable.fertilizer);
                        titleTV.setText("تغذیه");
                        break;
                    case 2:
                        //imageView.setImageResource(R.drawable.pesticide1);
                        titleTV.setText("سمپاشی");
                        break;
                    case 3:
                        //imageView.setImageResource(R.drawable.tractor);
                        titleTV.setText("متفرقه");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentFinish(String GARDEN_NAME, String[] MATERIALS, String DATE) {
        Toast.makeText(this,  MATERIALS[0] + MATERIALS[1], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onIrrigationFragFinish(String NAME, int DURATION, String DATE, String INTENSITY) {
        Toast.makeText(this,  DURATION, Toast.LENGTH_SHORT).show();
    }

}
