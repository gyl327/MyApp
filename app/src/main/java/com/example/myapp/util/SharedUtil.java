package com.example.myapp.util;

import android.content.Context;
import android.content.SharedPreferences;

// 这是共享参数的工具类，统一对共享参数的读写操作
public class SharedUtil {
    private static com.example.myapp.util.SharedUtil mUtil; // 声明一个共享参数工具类的实例
    private static SharedPreferences mShared; // 声明一个共享参数的实例

    // 通过单例模式获取共享参数工具类的唯一实例
    public static com.example.myapp.util.SharedUtil getIntance(Context ctx) {
        if (mUtil == null) {
            mUtil = new com.example.myapp.util.SharedUtil();
        }
        // 从share.xml中获取共享参数对象
        mShared = ctx.getSharedPreferences("share", Context.MODE_PRIVATE);
        return mUtil;
    }

    // 把配对信息写入共享参数（字符串）
    public void writeString(String key, String value) {
        SharedPreferences.Editor editor = mShared.edit(); // 获得编辑器的对象
        editor.putString(key, value); // 添加一个指定键名的字符串参数
        editor.commit(); // 提交编辑器中的修改
    }

    // 根据键名到共享参数中查找对应的值对象（字符串）
    public String readString(String key, String defaultValue) {
        return mShared.getString(key, defaultValue);
    }

    // 把配对信息写入共享参数（整型数）
    public void writeInt(String key, int value) {
        SharedPreferences.Editor editor = mShared.edit(); // 获得编辑器的对象
        editor.putInt(key, value); // 添加一个指定键名的字符串参数
        editor.commit(); // 提交编辑器中的修改
    }

    // 根据键名到共享参数中查找对应的值对象（整型数）
    public int readInt(String key, int defaultValue) {
        return mShared.getInt(key, defaultValue);
    }

}
