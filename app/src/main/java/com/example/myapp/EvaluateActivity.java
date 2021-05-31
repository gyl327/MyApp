package com.example.myapp;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapp.adapter.DepartmentPagerAdapter;
import com.example.myapp.util.PermissionUtil;

public class EvaluateActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_department_evaluate);

        findViewById(R.id.btn_evaluate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_evaluate) {
            if (PermissionUtil.checkPermission(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, R.id.btn_evaluate % 65536)) {
                startActivity(new Intent(this, GoodsOrderActivity.class));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        if (requestCode == R.id.btn_evaluate % 65536) {
            if (PermissionUtil.checkGrant(grantResults)) {
                startActivity(new Intent(this, GoodsOrderActivity.class));
            } else {
                Toast.makeText(this, "需要允许摄像头和存储卡权限才能评价晒单噢", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
