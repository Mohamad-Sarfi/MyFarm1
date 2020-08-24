package com.example.myfarm.ui;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapterGardens extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragTitlesList = new ArrayList<>();
    private  final List<Integer> fragIconsList = new ArrayList<>();



    public ViewPagerAdapterGardens(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragTitlesList.get(position);
    }



    public void addFragments(Fragment fragment, String Title){
        fragmentList.add(fragment);
        fragTitlesList.add(Title);
    }

}
