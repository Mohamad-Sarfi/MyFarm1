package com.example.myfarm;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {
    String tag;
    TextView appBarTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        AppBarLayout appBar = findViewById(R.id.mainAppbar);


        Fragment fragment = new HomeFrag();
        getSupportFragmentManager().
                beginTransaction().replace(R.id.fragment_container,fragment).commit();


    }

    private boolean loadFragment(Fragment fragment){

        if (fragment != null){
            getSupportFragmentManager().
            beginTransaction().replace(R.id.fragment_container,fragment).commit();
        }

        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                menuItem.setChecked(true);
                fragment = new HomeFrag();
                break;
            case R.id.navigation_gardens:
                menuItem.setChecked(true);
                fragment = new GardensFrag();
                break;
            case R.id.navigation_products:
                menuItem.setChecked(true);
                fragment = new ProductsFragment();
                break;
            case R.id.navigation_insights:
                menuItem.setChecked(true);
                fragment = new InsightsFrag();
                break;
        }

        return loadFragment(fragment);
    }

    public String tap(View view){
        tag = view.getTag().toString();
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        intent.putExtra(tag, "tag");
        startActivity(intent);

        return tag;
    }

}
