package com.example.myapp.fragment;

//我的-订单页面

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapp.MainApplication;
import com.example.myapp.R;
import com.example.myapp.ShoppingChannelActivity;
import com.example.myapp.adapter.MyorderlistAdapter;
import com.example.myapp.adapter.OrderListAdapter;
import com.example.myapp.bean.GoodsOrder;
import com.example.myapp.bean.MyorderGoodOrder;
import com.example.myapp.database.CartDBHelper;
import com.example.myapp.database.GoodsDBHelper;
import com.example.myapp.database.GoodsOrderHelper;
import com.example.myapp.database.MyorderGoodsOrderHelper;
import com.example.myapp.util.SharedUtil;
import com.example.myapp.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class DepartmentMineFragment extends Fragment implements View.OnClickListener {
    private final static String TAG = "MyOrderActivity";
    private ListView lv_order;
    //    protected AppCompatActivity mActivity; // 声明一个活动对象
    protected View mView; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象


    private TextView tv_count;
    private TextView tv_total_price;
    private LinearLayout ll_content;
    private LinearLayout ll_cart; // 声明一个购物车列表的线性布局对象
    private LinearLayout ll_empty;
    private GoodsDBHelper mGoodsHelper; // 声明一个商品数据库的帮助器对象
    private CartDBHelper mCartHelper; // 声明一个购物车数据库的帮助器对象


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        mContext = getActivity();
//
//        mView = inflater.inflate(R.layout.activity_my_order, container, false);
//        TextView tv_title = mView.findViewById(R.id.tv_title);
//        tv_title.setText("全部订单");
//        mView.findViewById(R.id.iv_back).setOnClickListener(this);
//        lv_order = mView.findViewById(R.id.lv_order);
//        importOrder(); // 导入商品订单
//        return mView;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mView = inflater.inflate(R.layout.activity_my_order, container, false);
        TextView tv_title = mView.findViewById(R.id.tv_title);
        tv_title.setText("全部订单");

        tv_count = mView.findViewById(R.id.tv_count);
        tv_total_price = mView.findViewById(R.id.tv_total_price);
        ll_content = mView.findViewById(R.id.ll_content);
        ll_cart = mView.findViewById(R.id.ll_cart);
        ll_empty = mView.findViewById(R.id.ll_empty);

        mView.findViewById(R.id.iv_back).setOnClickListener(this);
        mView.findViewById(R.id.iv_back).setOnClickListener(this);
        mView.findViewById(R.id.btn_shopping_channel).setOnClickListener(this);
        mView.findViewById(R.id.btn_clear).setOnClickListener(this);
        mView.findViewById(R.id.btn_settle).setOnClickListener(this);
        return mView;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) { // 点击了返回图标
//            finish(); // 关闭当前页面

            //关闭页面
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory(Intent.CATEGORY_HOME);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(homeIntent);

        } else if (v.getId() == R.id.btn_shopping_channel) { // 点击了“商场”按钮
            // 从购物车页面跳到商场页面
//            Intent intent = new Intent(this, ShoppingChannelActivity.class);
            Intent intent = new Intent(mContext, ShoppingChannelActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 设置启动标志
            startActivity(intent); // 跳转到手机商场页面
        } else if (v.getId() == R.id.btn_clear) { // 点击了“清空”按钮
            mCartHelper.deleteAll(); // 清空订单数据库
            MainApplication.goodsCount = 0;
//            showCount(); // 显示最新的商品数量
//            ToastUtil.show(this, "购物车已清空");
            ToastUtil.show(mContext, "订单已清空");

        }
//        else if (v.getId() == R.id.btn_settle) { // 点击了“结算”按钮
////            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//
//            builder.setTitle("结算商品");
//            builder.setMessage("客官抱歉，支付功能尚未开通，请下次再来");
//            builder.setPositiveButton("我知道了", null);
//            builder.create().show(); // 显示提醒对话框
//        }
    }


    @Override
    public void onResume() {
        super.onResume();
        initOrderList(); // 初始化订单列表
    }

    // 导入商品订单
    private void importOrder() {
        if (SharedUtil.getIntance(mContext).readInt("import_flag", 0) == 0) {
            List<MyorderGoodOrder> order_list = MyorderGoodOrder.getDefaultList();
            MyorderGoodsOrderHelper helper = new MyorderGoodsOrderHelper(mContext);
            helper.insert(order_list); // 往数据库写入商品订单
            SharedUtil.getIntance(mContext).writeInt("import_flag", 1);
        }
        Log.d(TAG, "import_flag="+SharedUtil.getIntance(mContext).readInt("import_flag", 0));
    }

    // 初始化订单列表
    private void initOrderList() {
        GoodsOrderHelper helper = new GoodsOrderHelper(mContext);
        // 从数据库中查询商品记录
        List<MyorderGoodOrder> order_list = (ArrayList<MyorderGoodOrder>) helper.queryAll();
        MyorderlistAdapter adapter = new MyorderlistAdapter(mContext, order_list);
        lv_order.setAdapter(adapter); // 设置列表视图的适配器
        lv_order.setOnItemClickListener(adapter); // 设置列表视图的点击监听器
    }
}








//package com.example.myapp.fragment;
//
////评价页面
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import com.example.myapp.R;
//import com.example.myapp.adapter.OrderListAdapter;
//import com.example.myapp.bean.GoodsOrder;
//import com.example.myapp.database.GoodsOrderHelper;
//import com.example.myapp.util.SharedUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DepartmentMineFragment extends Fragment implements View.OnClickListener {
//    private final static String TAG = "MyOrderActivity";
//    private ListView lv_order;
//    //    protected AppCompatActivity mActivity; // 声明一个活动对象
//    protected View mView; // 声明一个视图对象
//    protected Context mContext; // 声明一个上下文对象
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        mContext = getActivity();
////        setContentView(R.layout.activity_goods_order);
//        mView = inflater.inflate(R.layout.activity_my_order, container, false);
//        TextView tv_title = mView.findViewById(R.id.tv_title);
//        tv_title.setText("我的订单");
//        mView.findViewById(R.id.iv_back).setOnClickListener(this);
//        lv_order = mView.findViewById(R.id.lv_order);
//        importOrder(); // 导入商品订单
//        return mView;
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.iv_back) {
////            Toast.makeText(mContext, "您点击了back", Toast.LENGTH_LONG).show();// 关闭当前页面
//            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
//            homeIntent.addCategory(Intent.CATEGORY_HOME);
//            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(homeIntent);
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        initOrderList(); // 初始化订单列表
//    }
//
//    // 导入商品订单
//    private void importOrder() {
//        if (SharedUtil.getIntance(mContext).readInt("import_flag", 0) == 0) {
//            List<GoodsOrder> order_list = GoodsOrder.getDefaultList();
//            GoodsOrderHelper helper = new GoodsOrderHelper(mContext);
//            helper.insert(order_list); // 往数据库写入商品订单
//            SharedUtil.getIntance(mContext).writeInt("import_flag", 1);
//        }
//        Log.d(TAG, "import_flag="+SharedUtil.getIntance(mContext).readInt("import_flag", 0));
//    }
//
//    // 初始化订单列表
//    private void initOrderList() {
//        GoodsOrderHelper helper = new GoodsOrderHelper(mContext);
//        // 从数据库中查询商品记录
//        List<GoodsOrder> order_list = (ArrayList<GoodsOrder>) helper.queryAll();
//        OrderListAdapter adapter = new OrderListAdapter(mContext, order_list);
//        lv_order.setAdapter(adapter); // 设置列表视图的适配器
//        lv_order.setOnItemClickListener(adapter); // 设置列表视图的点击监听器
//    }
//
//}

