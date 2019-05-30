package com.example.a6868.june_day1_work;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.a6868.june_day1_work.adapter.VpAdpater;
import com.example.a6868.june_day1_work.fragment.ChildFragment;
import com.example.a6868.june_day1_work.fragment.HomeFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;


//彭波 H1810B
public class MainActivity extends AppCompatActivity {

    private ViewPager mVP;
    private TabLayout mTab;
    private ArrayList<Fragment> fs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        mVP = (ViewPager) findViewById(R.id.mVP);
        mTab = (TabLayout) findViewById(R.id.mTab);

        initData();

        VpAdpater vpAdpater = new VpAdpater(getSupportFragmentManager(), fs);
        mVP.setAdapter(vpAdpater);

    }

    private void initData() {

        fs = new ArrayList<>();

        fs.add(new HomeFragment());
        fs.add(new ChildFragment());

       mTab.addTab(mTab.newTab().setText("故事").setIcon(R.drawable.selector));
       mTab.addTab(mTab.newTab().setText("亲子").setIcon(R.drawable.selector_c));

       mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               mVP.setCurrentItem(tab.getPosition());
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
       mVP.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));

    }
}
