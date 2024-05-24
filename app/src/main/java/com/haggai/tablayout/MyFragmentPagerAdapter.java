package com.haggai.tablayout;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private final BeritaFragment _beritaFragment = new BeritaFragment();
    private final Context _context;
    private final ECommerceFragment _eCommerceFragment = new ECommerceFragment();
    private final int _tabCount;
    private final KampusFragment _kampusFragment = new KampusFragment();

    public MyFragmentPagerAdapter(Context context, FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        _context = context;
        _tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return _eCommerceFragment;
            case 1:
                return _beritaFragment;
            case 2:
                return _kampusFragment;
            default:
                return new Fragment(); // Return a default Fragment to avoid returning null
        }
    }

    @Override
    public int getCount() {
        return _tabCount;
    }
}
