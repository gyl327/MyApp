package com.example.myapp.bean;

import com.example.myapp.util.DateUtil2;

import java.util.ArrayList;
import java.util.List;

public class MyorderGoodOrder {
    public long rowid; // 行号
    public int xuhao; // 序号
    public String goods_name; // 商品名称
    public double price; // 商品价格
    public String create_time; // 订单创建时间
    public int num;  //商品数量
    public double sum;  //总价
    public int pay_status; // 支付状态。0 未支付；1 已支付

    public MyorderGoodOrder() {
        rowid = 0L;
        xuhao = 0;
        goods_name = "";
        price = 0;
        create_time = "";
        num = 0;
        sum = 0;
        pay_status = 0;

    }

    // 声明一个手机商品的名称数组
    private static String[] mNameArray = {
            "iPhone11", "Mate30", "小米10", "OPPO Reno3", "vivo X30", "荣耀30S"
    };
    // 声明一个手机商品的价格数组
    private static float[] mPriceArray = {6299, 4999, 3999, 2999, 2998, 2399};

    // 获取默认的手机信息列表
    public static List<MyorderGoodOrder> getDefaultList() {
        List<MyorderGoodOrder> goodsList = new ArrayList<MyorderGoodOrder>();
        for (int i = 0; i < mNameArray.length; i++) {
            com.example.myapp.bean.MyorderGoodOrder order = new com.example.myapp.bean.MyorderGoodOrder();
            order.goods_name = mNameArray[i];
            order.price = mPriceArray[i];
            order.pay_status = 0;
            order.create_time = DateUtil2.getNowDateTime();



            goodsList.add(order);
        }
        return goodsList;
    }
}
