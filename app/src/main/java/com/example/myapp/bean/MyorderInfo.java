//package com.example.myapp.bean;
//
//import com.example.myapp.R;
//
//import java.util.ArrayList;
//
//public class MyorderInfo {
//    public long rowid; // 行号
//    public int xuhao; // 序号
//    public String name; // 名称
//    public String desc; // 描述
//    public float price; // 价格
////    public double num;
//    public String pic_path; // 大图的保存路径
//    public int pic; // 大图的资源编号
//
//    public MyorderInfo() {
//        rowid = 0L;
//        xuhao = 0;
//        name = "";
//        desc = "";
//        price = 0;
////        num = 0;
//        pic_path = "";
//        pic = 0;
//    }
//
//    // 声明一个手机商品的名称数组
//    private static String[] mNameArray = {
//            "连衣裙", "西装外套", "小米10", "美味锅巴", "奶粉", "面膜"
//    };
//    // 声明一个手机商品的描述数组
//    private static String[] mDescArray = {
//            "2021春夏新款碎花连衣裙女",
//            "粉色西装外套女薄款",
//            "小米 MI10 8GB+128GB 钛银黑 5G手机 游戏拍照手机",
//            "大钜惠美味锅巴",
//            "婴儿配方奶粉 飞鹤奶粉",
//            "双十一爆款面膜"
//    };
//    // 声明一个手机商品的价格数组
//    private static float[] mPriceArray = {299, 188, 3999, 20, 198, 99};
//    //数量
////    private static float[] mNumArray = {1, 2, 1, 2, 2, 1};
//    // 声明一个手机商品的大图数组
//    private static int[] mPicArray = {
//            R.drawable.women01, R.drawable.women05, R.drawable.xiaomi,
//            R.drawable.food02, R.drawable.mu02, R.drawable.mei01
//    };
//
//    // 获取默认的手机信息列表
//    public static ArrayList<MyorderInfo> getDefaultList() {
//        ArrayList<MyorderInfo> goodsList = new ArrayList<MyorderInfo>();
//        for (int i = 0; i < mNameArray.length; i++) {
//            com.example.myapp.bean.MyorderInfo info = new com.example.myapp.bean.MyorderInfo();
//            info.name = mNameArray[i];
//            info.desc = mDescArray[i];
//            info.price = mPriceArray[i];
////            info.num = mNumArray[i];
//            info.pic = mPicArray[i];
//            goodsList.add(info);
//        }
//        return goodsList;
//    }
//}
