package com.example.wechatpage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MyfragmentPagerAdapter extends FragmentStateAdapter {

    List<Fragment> fragmentList;


    public MyfragmentPagerAdapter(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Lifecycle lifecycle, List<Fragment> fragment) {
        super(fragmentManager, lifecycle);
        fragmentList = fragment;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new FragmentContent();
            default:
                return fragmentList.get(position);

        }

    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
