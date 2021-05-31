package com.example.myapp.bean;

import com.example.chapter13.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class GoodsOrder {
    public long rowid; // 行号
    public int xuhao; // 序号
    public String goods_name; // 商品名称
    public double price; // 商品价格
    public int evaluate_status; // 评价状态。0 未评价；1 已评价
    public String create_time; // 订单创建时间

    public GoodsOrder() {
        rowid = 0L;
        xuhao = 0;
        goods_name = "";
        price = 0;
        evaluate_status = 0;
        create_time = "";
    }

    // 声明一个手机商品的名称数组
    private static String[] mNameArray = {
            "夏季T恤女", "李宁跑步鞋", "小米10", "华为笔记本电脑"
    };
    // 声明一个手机商品的价格数组
    private static float[] mPriceArray = {100, 298, 3999, 5000};

    // 获取默认的手机信息列表
    public static List<GoodsOrder> getDefaultList() {
        List<GoodsOrder> goodsList = new ArrayList<GoodsOrder>();
        for (int i = 0; i < mNameArray.length; i++) {
            com.example.chapter13.bean.GoodsOrder order = new com.example.chapter13.bean.GoodsOrder();
            order.goods_name = mNameArray[i];
            order.price = mPriceArray[i];
            order.evaluate_status = 0;
            order.create_time = DateUtil.getNowDateTime();
            goodsList.add(order);
        }
        return goodsList;
    }

}
