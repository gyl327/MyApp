package com.example.myapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

@SuppressLint("DefaultLocale")
public class RegisterSQLiteActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_phone; // 声明一个编辑框对象
    private EditText et_password; // 声明一个编辑框对象
    private EditText et_verifycode; // 声明一个编辑框对象
    private String mVerifyCode; // 验证码
//    private String mPhone; // 手机号码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_sqlite);
        // 从布局文件中获取名叫et_phone的编辑框
        et_phone = findViewById(R.id.et_phone);
        // 从布局文件中获取名叫et_password的编辑框
        et_password = findViewById(R.id.et_password);
        // 从布局文件中获取名叫et_verifycode的编辑框
        et_verifycode = findViewById(R.id.et_verifycode);
        findViewById(R.id.btn_verifycode).setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);
//        // 从上一个页面获取要修改密码的手机号码
//        mPhone = getIntent().getStringExtra("phone");
    }

    @Override
    public void onClick(View v) {
        // 点击了“获取验证码”按钮
        if (v.getId() == R.id.btn_verifycode) {
            String phone = et_phone.getText().toString();
            if (phone == null || phone.length() != 11) {
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            // 生成六位随机数字的验证码
            mVerifyCode = String.format("%06d", new Random().nextInt(999999));
            // 以下弹出提醒对话框，提示用户记住六位验证码数字
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("请记住验证码");
            builder.setMessage("手机号" + phone + "，本次验证码是" + mVerifyCode + "，请输入验证码");
            builder.setPositiveButton("好的", null);
            AlertDialog alert = builder.create();
            alert.show(); // 显示提醒对话框
        }
        // 点击了“注册”按钮
        else if (v.getId() == R.id.btn_register) {
            String phone = et_phone.getText().toString();
            String password = et_password.getText().toString();
            if (phone.length() != 11) {
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!et_verifycode.getText().toString().equals(mVerifyCode)) {
                Toast.makeText(this, "请输入正确的验证码", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                // 以下把修改好的新密码返回给上一个页面
                Intent intent = new Intent(); // 创建一个新意图
                intent.putExtra("new_password", password); // 存入新密码
                setResult(Activity.RESULT_OK, intent); // 携带意图返回上一个页面
                finish(); // 结束当前的活动页面
            }
        }
    }

}
