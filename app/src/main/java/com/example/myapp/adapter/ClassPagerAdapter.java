package com.example.myapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapp.fragment.AppliancesFragment;
import com.example.myapp.fragment.ClothesFragment;
import com.example.myapp.fragment.FoodFragment;
import com.example.myapp.fragment.ImportFragment;
import com.example.myapp.fragment.MakeFragment;
import com.example.myapp.fragment.MenFragment;
import com.example.myapp.fragment.MotherFragment;
import com.example.myapp.fragment.OrnamentsFragment;
import com.example.myapp.fragment.PhoneFragment;

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
        if (position == 0) { // 第一页展示女装
            return new ClothesFragment();
        } else if (position == 1){  //电器
            return new AppliancesFragment();
        } else if (position == 2){  //食品
            return new FoodFragment();
        }  else if (position == 3){  //母婴
            return new MotherFragment();
        } else if (position == 4){  //美妆
            return new MakeFragment();
        } else if (position == 5){  //饰品
            return new OrnamentsFragment();
        } else if (position == 6){  //进口
            return new ImportFragment();
        } else if (position == 7){ //手机
            return new PhoneFragment();
        }  else {    //男装
            return new MenFragment();
        }
    }

    // 获取碎片Fragment的个数
    @Override
    public int getItemCount() {
        return mTitleList.size();
    }

}
