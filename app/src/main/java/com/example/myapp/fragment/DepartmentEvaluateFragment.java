package com.example.myapp.fragment;

//评价页面

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapp.R;
import com.example.myapp.adapter.OrderListAdapter;
import com.example.myapp.bean.GoodsOrder;
import com.example.myapp.database.GoodsOrderHelper;
import com.example.myapp.util.SharedUtil;

import java.util.ArrayList;
import java.util.List;

public class DepartmentEvaluateFragment extends Fragment implements View.OnClickListener {
    private final static String TAG = "GoodsOrderActivity";
    private ListView lv_order;
//    protected AppCompatActivity mActivity; // 声明一个活动对象
    protected View mView; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
//        setContentView(R.layout.activity_goods_order);
        mView = inflater.inflate(R.layout.activity_goods_order, container, false);
        TextView tv_title = mView.findViewById(R.id.tv_title);
        tv_title.setText("订单列表");
        mView.findViewById(R.id.iv_back).setOnClickListener(this);
        lv_order = mView.findViewById(R.id.lv_order);
        importOrder(); // 导入商品订单
        return mView;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
//            getActivity().onBackPressed();// 退出页面
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory(Intent.CATEGORY_HOME);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(homeIntent);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initOrderList(); // 初始化订单列表
    }

    // 导入商品订单
    private void importOrder() {
        if (SharedUtil.getIntance(mContext).readInt("import_flag", 0) == 0) {
            List<GoodsOrder> order_list = GoodsOrder.getDefaultList();
            GoodsOrderHelper helper = new GoodsOrderHelper(mContext);
            helper.insert(order_list); // 往数据库写入商品订单
            SharedUtil.getIntance(mContext).writeInt("import_flag", 1);
        }
        Log.d(TAG, "import_flag="+SharedUtil.getIntance(mContext).readInt("import_flag", 0));
    }

    // 初始化订单列表
    private void initOrderList() {
        GoodsOrderHelper helper = new GoodsOrderHelper(mContext);
        // 从数据库中查询商品记录
        List<GoodsOrder> order_list = (ArrayList<GoodsOrder>) helper.queryAll();
        OrderListAdapter adapter = new OrderListAdapter(mContext, order_list);
        lv_order.setAdapter(adapter); // 设置列表视图的适配器
        lv_order.setOnItemClickListener(adapter); // 设置列表视图的点击监听器
    }

}
