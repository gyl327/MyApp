//package com.example.myapp;
//
//import android.annotation.SuppressLint;
//import android.app.AlertDialog;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.myapp.bean.GoodsInfo;
//import com.example.myapp.database.CartDBHelper;
//import com.example.myapp.database.GoodsDBHelper;
//import com.example.myapp.fragment.DepartmentCartFragment;
//import com.example.myapp.util.ToastUtil;
//
//@SuppressLint("SetTextI18n")
//public class PayMyorderActivity extends AppCompatActivity implements OnClickListener {
//    private TextView tv_title;
//    private TextView tv_count;
//    private TextView tv_goods_price;
//    private TextView tv_goods_desc;
//    private ImageView iv_goods_pic;
//    private long mGoodsId; // 当前商品的商品编号
//    private GoodsDBHelper mGoodsHelper; // 声明一个商品数据库的帮助器对象
//    private CartDBHelper mCartHelper; // 声明一个购物车数据库的帮助器对象
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_paymyorder_detail);
//        tv_title = findViewById(R.id.tv_title);
//        tv_count = findViewById(R.id.tv_count);
//        tv_goods_price = findViewById(R.id.tv_goods_price);
//        tv_goods_desc = findViewById(R.id.tv_goods_desc);
//        iv_goods_pic = findViewById(R.id.iv_goods_pic);
//        findViewById(R.id.iv_back).setOnClickListener(this);
//        findViewById(R.id.iv_cart).setOnClickListener(this);
//        findViewById(R.id.btn_add_cart).setOnClickListener(this);
//        tv_count.setText("" + MainApplication.goodsCount);
//    }
//
////    @Override
////    public void onClick(View v) {
////        if (v.getId() == R.id.iv_back) { // 点击了返回图标
////            finish(); // 关闭当前页面
////        } else if (v.getId() == R.id.iv_cart) { // 点击了购物车图标
////            Intent intent = new Intent(this, DepartmentCartFragment.class);
////            startActivity(intent); // 跳转到购物车页面
////        } else if (v.getId() == R.id.btn_add_cart) { // 点击了“添加”按钮
////            addToCart(mGoodsId); // 把该商品添加到购物车
////        }
////    }
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.iv_back) { // 点击了返回图标
//            finish(); // 关闭当前页面
//        }
////        else if (v.getId() == R.id.iv_cart) { // 点击了购物车图标
////            Intent intent = new Intent(this, DepartmentCartFragment.class);
////            startActivity(intent); // 跳转到购物车页面
////        }
//        else if (v.getId() == R.id.btn_pay_myorder) { // 点击了“马上支付”按钮
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//            builder.setTitle("结算商品");
//            builder.setMessage("客官抱歉，支付功能尚未开通，请下次再来");
//            builder.setPositiveButton("我知道了", null);
//            builder.create().show(); // 显示提醒对话框
//        }
//    }
//
//    // 把指定编号的商品添加到购物车
////    private void addToCart(long goods_id) {
////        MainApplication.goodsCount++;
////        tv_count.setText("" + MainApplication.goodsCount);
////        mCartHelper.save(goods_id); // 把该商品填入购物车数据库
////        ToastUtil.show(this, "成功添加至购物车");
////    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        // 获取商品数据库的帮助器对象
//        mGoodsHelper = GoodsDBHelper.getInstance(this, 1);
//        mGoodsHelper.openReadLink(); // 打开商品数据库的读连接
//        // 获取购物车数据库的帮助器对象
//        mCartHelper = CartDBHelper.getInstance(this, 1);
//        mCartHelper.openWriteLink(); // 打开购物车数据库的写连接
//        showDetail(); // 展示商品详情
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mGoodsHelper.closeLink(); // 关闭商品数据库的数据库连接
//        mCartHelper.closeLink(); // 关闭购物车数据库的数据库连接
//    }
//
//    private void showDetail() {
//        // 获取上一个页面传来的商品编号
//        mGoodsId = getIntent().getLongExtra("goods_id", 0L);
//        if (mGoodsId > 0) {
//            // 根据商品编号查询商品数据库中的商品记录
//            GoodsInfo info = mGoodsHelper.queryById(mGoodsId);
//            tv_title.setText(info.name); // 设置商品名称
//            tv_goods_desc.setText(info.desc); // 设置商品描述
//            tv_goods_price.setText("" + (int)info.price); // 设置商品价格
//            iv_goods_pic.setImageURI(Uri.parse(info.pic_path)); // 设置商品图片
//        }
//    }
//
//}
