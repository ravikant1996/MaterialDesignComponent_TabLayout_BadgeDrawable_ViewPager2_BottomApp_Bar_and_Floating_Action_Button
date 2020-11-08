package com.example.materialdesigncomponent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.materialdesigncomponent.BottomView.BottomAppBar;
import com.example.materialdesigncomponent.TabLayout.OrderPagerAdapter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        FloatingActionButton fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BottomAppBar.class));
            }
        });
        viewPager2.setAdapter(new OrderPagerAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tab_layut);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:{
                        tab.setText("Pending");
                        tab.setIcon(R.drawable.assignment);
                        BadgeDrawable badgeDrawable= tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error)
                        );
                        badgeDrawable.setVisible(true);
//                        badgeDrawable.setNumber(100);
//                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    }
                    case 1:{
                        tab.setText("Confirmed");
                        tab.setIcon(R.drawable.bike);
                        BadgeDrawable badgeDrawable= tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error)
                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(5);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    }
                    case 2:{
                        tab.setText("Delivered");
                        tab.setIcon(R.drawable.check_circle);
                        BadgeDrawable badgeDrawable= tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error)
                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(100);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    }

                }
            }
        }
        );
        tabLayoutMediator.attach();
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable= tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });
    }
}