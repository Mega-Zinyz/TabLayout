package com.haggai.tablayout;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TabLayout tabLayout1 = findViewById(R.id.tablayout1);
        tabLayout1.addTab(tabLayout1.newTab().setText("E-Commerce").setContentDescription("E-Commerce Tab"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Berita").setContentDescription("Berita Tab"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Kampus").setContentDescription("Kampus Tab"));
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager1 = findViewById(R.id.viewPager1);

        MyFragmentPagerAdapter _myFragmentPagerAdapter = new MyFragmentPagerAdapter(this, getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(_myFragmentPagerAdapter);
        viewPager1.setOffscreenPageLimit(3);

        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
