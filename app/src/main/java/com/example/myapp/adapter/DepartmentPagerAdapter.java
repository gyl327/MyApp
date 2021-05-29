package com.example.myapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapp.fragment.DepartmentCartFragment;
import com.example.myapp.fragment.DepartmentClassFragment;
import com.example.myapp.fragment.DepartmentEvaluateFragment;
import com.example.myapp.fragment.DepartmentHomeFragment;
import com.example.myapp.fragment.DepartmentMineFragment;

public class DepartmentPagerAdapter extends FragmentPagerAdapter {

    // 碎片页适配器的构造方法，传入碎片管理器
    public DepartmentPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    // 获取指定位置的碎片Fragment
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DepartmentHomeFragment();
        } else if (position == 1) {
            return new DepartmentClassFragment();
        } else if (position == 2) {
            return new DepartmentEvaluateFragment();
        }else if (position == 3) {
            return new DepartmentCartFragment();
        }else if (position == 4) {
            return new DepartmentMineFragment();
        } else {
            return null;
        }
    }

    // 获取碎片Fragment的个数
    public int getCount() {
        return 5;
    }
}
