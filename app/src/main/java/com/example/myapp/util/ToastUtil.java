package com.example.myapp.util;

import android.content.Context;
import android.widget.Toast;

import com.example.myapp.ShoppingChannelActivity;

public class ToastUtil {

    public static void show(Context ctx, String desc) {
        Toast.makeText(ctx, desc, Toast.LENGTH_SHORT).show();
    }
}
