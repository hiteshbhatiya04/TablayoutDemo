package com.example.hitesh.tablayout;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.hitesh.tablayout.Fragments.FirstFragment;
import com.example.hitesh.tablayout.Fragments.SecondFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstFragment(), "Name");
        adapter.addFragment(new SecondFragment(), "Message");
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> FragmentList = new ArrayList<>();
        private final List<String> FragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentList.get(position);
        }

        @Override
        public int getCount() {
            return FragmentTitleList.size();
        }
        public void addFragment(Fragment fragment,String title)
        {
            FragmentList.add(fragment);
            FragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return FragmentTitleList.get(position);
        }


    }
}
