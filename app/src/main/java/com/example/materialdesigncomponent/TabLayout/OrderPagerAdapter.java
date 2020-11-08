package com.example.materialdesigncomponent.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class OrderPagerAdapter extends FragmentStateAdapter {

    public OrderPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PendingOrderFragment();
            case 1:
                return new ConfirmOrderFragment();
            default:
                return new DeliveredOrderedFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
