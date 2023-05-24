package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ViewPager2 pager;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        pager.setOffscreenPageLimit(3);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), getLifecycle());
        pager.setAdapter(adapter);

        /*
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
         */

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    public  void onFragmentChanged(int index){
        if(index == 0){
            //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
            pager.setCurrentItem(1);
        }
        else if(index == 1){
            //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
            pager.setCurrentItem(2);
        }
        else if(index == 2){
            //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
            pager.setCurrentItem(0);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.tab1:
                Toast.makeText(getApplicationContext(), "첫번째탭", Toast.LENGTH_SHORT).show();
                pager.setCurrentItem(0);
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                return true;
            case R.id.tab2:
                Toast.makeText(getApplicationContext(), "두번째탭", Toast.LENGTH_SHORT).show();
                pager.setCurrentItem(1);
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                return true;
            case R.id.tab3:
                Toast.makeText(getApplicationContext(), "세번째탭", Toast.LENGTH_SHORT).show();
                pager.setCurrentItem(2);
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
                return true;
        }
        return false;
    }

    //MyPagerAdapter 라는 어댑터 클래스를 정의해줘야함.
    class MyPagerAdapter extends FragmentStateAdapter{

        int itemCount = 3;

        public MyPagerAdapter(FragmentManager fm, Lifecycle cycle){
            super(fm, cycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0 :
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
            }
            return new Fragment1();
        }

        @Override
        public int getItemCount() {
            return itemCount;
        }
    }




}

