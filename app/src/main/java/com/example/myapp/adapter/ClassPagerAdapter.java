package com.example.myapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapp.fragment.AppliancesFragment;
import com.example.myapp.fragment.ClothesFragment;
import com.example.myapp.fragment.FoodFragment;

import java.util.List;

public class ClassPagerAdapter extends FragmentStateAdapter {
    private List<String> mTitleList; // 声明一个标题文字列表

    // 碎片页适配器的构造方法，传入碎片管理器与标题列表
    public ClassPagerAdapter(FragmentActivity fa, List<String> titleList) {
        super(fa);
        mTitleList = titleList;
    }

    // 创建指定位置的碎片Fragmen
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) { // 第一页展示服装
            return new ClothesFragment();
        } else if (position == 1){ // 第二页展示电器
            return new AppliancesFragment();
        }else { // 第三页展示食品
            return new FoodFragment();
        }
    }

    // 获取碎片Fragment的个数
    @Override
    public int getItemCount() {
        return mTitleList.size();
    }

}
