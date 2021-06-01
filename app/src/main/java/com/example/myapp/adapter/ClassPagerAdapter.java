package com.example.myapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapp.fragment.AppliancesFragment;
import com.example.myapp.fragment.ClothesFragment;
import com.example.myapp.fragment.DigitalFragment;
import com.example.myapp.fragment.FoodFragment;
import com.example.myapp.fragment.ImportFragment;
import com.example.myapp.fragment.LuggageFragment;
import com.example.myapp.fragment.MakeFragment;
import com.example.myapp.fragment.MenFragment;
import com.example.myapp.fragment.MotherFragment;
import com.example.myapp.fragment.MotionFragment;
import com.example.myapp.fragment.OrnamentsFragment;
import com.example.myapp.fragment.PhoneFragment;
import com.example.myapp.fragment.ShoesFragment;
import com.example.myapp.fragment.StoreFragment;
import com.example.myapp.fragment.WashFragment;

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
        } else if (position == 1){
            return new AppliancesFragment();
        } else if (position == 2){
            return new FoodFragment();
        } else if (position == 3){
            return new WashFragment();
        } else if (position == 4){
            return new MotherFragment();
        } else if (position == 5){
            return new MakeFragment();
        } else if (position == 6){
            return new StoreFragment();
        } else if (position == 7){
            return new OrnamentsFragment();
        } else if (position == 8){
            return new ImportFragment();
        }else if (position == 9){
            return new DigitalFragment();
        } else if (position == 10){
            return new ShoesFragment();
        } else if (position == 11){
            return new PhoneFragment();
        } else if (position == 12){
            return new LuggageFragment();
        } else if (position == 13){
            return new MenFragment();
        } else {
            return new MotionFragment();
        }
    }

    // 获取碎片Fragment的个数
    @Override
    public int getItemCount() {
        return mTitleList.size();
    }

}
