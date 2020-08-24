package com.example.myfarm;

import android.os.Bundle;

import com.example.myfarm.fragments.ActiviteisReportFragment;
import com.example.myfarm.fragments.GardenProfileFragment;
import com.example.myfarm.ui.ViewPagerAdapter;
import com.example.myfarm.ui.ViewPagerAdapterGardens;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

public class GardenProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tablayout_gardens);
        ViewPager viewPager = findViewById(R.id.viewPagerGardens);
        int[] tabIcons = {
            R.drawable.green_tea,
                R.drawable.ecology
        };

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragments(new GardenProfileFragment(), "مشخصات باغ");
        viewPagerAdapter.addFragments(new ActiviteisReportFragment(), "گزارش فعالیت های باغ");

        viewPager.setAdapter(viewPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
