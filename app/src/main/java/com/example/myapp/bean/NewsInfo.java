package com.example.myapp.bean;

import com.example.myapp.R;

import java.util.ArrayList;
import java.util.List;

public class NewsInfo {
    public int pic_id; // 图片的资源编号
    public String title; // 标题
    public String desc; // 描述
    public boolean bPressed; // 是否按下
    public int id; // 商品信息编号
    private static int seq = 0; // 序号

    public NewsInfo(int pic_id, String title, String desc) {
        this.pic_id = pic_id;
        this.title = title;
        this.desc = desc;
        this.bPressed = false;
        this.id = this.seq;
        this.seq++;
    }

    private static int[] gridImageArray = {R.drawable.pic_01, R.drawable.pic_02, R.drawable.pic_03
            , R.drawable.pic_04, R.drawable.pic_05, R.drawable.pic_06, R.drawable.pic_07
            , R.drawable.pic_08, R.drawable.pic_09, R.drawable.pic_10};
    private static String[] gridTitleArray = {"新品上线", "今日爆款", "百货超市", "便利小店",
            "地摊吃货", "食杂店", "口碑生活", "土货鲜食", "菜市场", "会员中心"};

    public static List<NewsInfo> getDefaultGrid() {
        List<NewsInfo> gridList = new ArrayList<NewsInfo>();
        for (int i = 0; i < gridImageArray.length; i++) {
            gridList.add(new com.example.myapp.bean.NewsInfo(gridImageArray[i], gridTitleArray[i], null));
        }
        return gridList;
    }


    private static int[] combineImageArray = {R.drawable.cainixihuan, R.drawable.dapaijiadao
            , R.drawable.trip_01, R.drawable.trip_02, R.drawable.trip_03, R.drawable.trip_04};
    private static String[] combineTitleArray = {
            "猜你喜欢", "大牌驾到", "买哪个", "别想了", "先下单", "包你满意"};

    public static List<NewsInfo> getDefaultCombine() {
        List<NewsInfo> combineList = new ArrayList<NewsInfo>();
        for (int i = 0; i < combineImageArray.length; i++) {
            combineList.add(new com.example.myapp.bean.NewsInfo(combineImageArray[i], combineTitleArray[i], null));
        }
        return combineList;
    }

    //女装
    private static int[] stagImageArray = {R.drawable.women01, R.drawable.women02, R.drawable.women03
            , R.drawable.women04, R.drawable.women05, R.drawable.women06, R.drawable.women07
            , R.drawable.women08, R.drawable.women09, R.drawable.women10, R.drawable.women11
            , R.drawable.women12, R.drawable.women13, R.drawable.women14, R.drawable.women15
            , R.drawable.women16, R.drawable.women17, R.drawable.women18, R.drawable.women19
            , R.drawable.women20, R.drawable.women21};
    private static String[] stagTitleArray = {"促销价", "惊爆价", "跳楼价", "白菜价", "清仓价", "割肉价",
            "实惠价", "一口价", "满意价", "打折价", "腰斩价", "无人问津", "算了吧", "大声点",
            "嘘嘘", "嗯嗯", "呼呼", "呵呵", "哈哈", "嘿嘿", "嘻嘻"};

    public static List<NewsInfo> getDefaultStag() {
        List<NewsInfo> stagList = new ArrayList<NewsInfo>();
        for (int i = 0; i < stagImageArray.length; i++) {
            stagList.add(new com.example.myapp.bean.NewsInfo(stagImageArray[i], stagTitleArray[i], null));
        }
        return stagList;
    }

    //电器
    private static int[] appiImageArray = {R.drawable.dian01, R.drawable.dian02, R.drawable.dian03
            , R.drawable.dian04, R.drawable.dian05, R.drawable.dian06, R.drawable.dian07
            , R.drawable.dian08, R.drawable.dian09, R.drawable.dian10, R.drawable.dian11
            , R.drawable.dian12, R.drawable.dian13, R.drawable.dian14, R.drawable.dian15
            ,R.drawable.dian16, R.drawable.dian17, R.drawable.dian18, R.drawable.dian20};
    private static String[] appiTitleArray = {"双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权", "包安装", "再返券",
            "白送你", "想得美", "干活去", "好好学", "才有钱","想得美", "干活去", "好好学", "才有钱"};

    public static List<NewsInfo> getDefaultAppi() {
        List<NewsInfo> appiList = new ArrayList<NewsInfo>();
        for (int i = 0; i < appiImageArray.length; i++) {
            appiList.add(new com.example.myapp.bean.NewsInfo(appiImageArray[i], appiTitleArray[i], null));
        }
        return appiList;
    }

    //进口产品
    private static int[] importImageArray = {R.drawable.jin01, R.drawable.jin02, R.drawable.jin03
            , R.drawable.jin04, R.drawable.jin05, R.drawable.jin06, R.drawable.jin07
            , R.drawable.jin08};
    private static String[] importTitleArray = {"双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权"};

    public static List<NewsInfo> getDefaultimport() {
        List<NewsInfo> appiList = new ArrayList<NewsInfo>();
        for (int i = 0; i < importImageArray.length; i++) {
            appiList.add(new com.example.myapp.bean.NewsInfo(importImageArray[i], importTitleArray[i], null));
        }
        return appiList;
    }

    //美妆 orna
    private static int[] ornaImageArray = {R.drawable.mei01, R.drawable.mei02, R.drawable.mei03
            , R.drawable.mei04, R.drawable.mei05, R.drawable.mei06, R.drawable.mei07
            , R.drawable.mei08,R.drawable.mei09, R.drawable.mei10, R.drawable.mei25
            , R.drawable.mei11, R.drawable.mei12, R.drawable.mei13, R.drawable.mei14
            , R.drawable.mei15,R.drawable.mei16, R.drawable.mei17, R.drawable.mei18
            , R.drawable.mei19, R.drawable.mei20, R.drawable.mei21, R.drawable.mei22
            , R.drawable.mei23, R.drawable.mei24};
    private static String[] ornaTitleArray = {"双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权","双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权","双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权", "享特权"};

    public static List<NewsInfo> getDefaultorna() {
        List<NewsInfo> appiList = new ArrayList<NewsInfo>();
        for (int i = 0; i < ornaImageArray.length; i++) {
            appiList.add(new com.example.myapp.bean.NewsInfo(ornaImageArray[i], ornaTitleArray[i], null));
        }
        return appiList;
    }

    //饰品
    private static int[] makeImageArray = {R.drawable.shi01, R.drawable.shi02, R.drawable.shi03
            , R.drawable.shi04, R.drawable.shi05, R.drawable.shi06, R.drawable.shi07
            , R.drawable.shi08,R.drawable.shi09, R.drawable.shi10, R.drawable.shi11
            , R.drawable.shi12, R.drawable.shi13, R.drawable.shi14, R.drawable.shi15
            , R.drawable.shi16, R.drawable.shi17,R.drawable.shi18
            , R.drawable.shi19, R.drawable.shi20};
    private static String[] makeTitleArray = {"双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权","双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权", "享特权","付定金", "享特权", "享特权"};

    public static List<NewsInfo> getDefaultmake() {
        List<NewsInfo> appiList = new ArrayList<NewsInfo>();
        for (int i = 0; i < makeImageArray.length; i++) {
            appiList.add(new com.example.myapp.bean.NewsInfo(makeImageArray[i], makeTitleArray[i], null));
        }
        return appiList;
    }

    //母婴
    private static int[] moImageArray = {R.drawable.mu01, R.drawable.mu02, R.drawable.mu03
            , R.drawable.mu04, R.drawable.mu05, R.drawable.mu06, R.drawable.mu07
            , R.drawable.mu08,R.drawable.mu09, R.drawable.mu10, R.drawable.mu11
            , R.drawable.mu12, R.drawable.mu13, R.drawable.mu14, R.drawable.mu15
            , R.drawable.mu16, R.drawable.mu17};
    private static String[] moTitleArray = {"双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权","双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权", "享特权"};

    public static List<NewsInfo> getDefaultmo() {
        List<NewsInfo> appiList = new ArrayList<NewsInfo>();
        for (int i = 0; i < moImageArray.length; i++) {
            appiList.add(new com.example.myapp.bean.NewsInfo(moImageArray[i], moTitleArray[i], null));
        }
        return appiList;
    }


    //男装
    private static int[] manImageArray = {R.drawable.man01, R.drawable.man02, R.drawable.man03
            , R.drawable.man04, R.drawable.man05, R.drawable.man06, R.drawable.man07
            , R.drawable.man08,R.drawable.man09, R.drawable.man10, R.drawable.man11
            , R.drawable.man12, R.drawable.man13, R.drawable.man14, R.drawable.man15
            , R.drawable.man16, R.drawable.man17,R.drawable.man18
            , R.drawable.man19, R.drawable.man20};
    private static String[] manTitleArray = {"双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权","双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权", "享特权","付定金", "享特权", "享特权"};

    public static List<NewsInfo> getDefaultman() {
        List<NewsInfo> appiList = new ArrayList<NewsInfo>();
        for (int i = 0; i < manImageArray.length; i++) {
            appiList.add(new com.example.myapp.bean.NewsInfo(manImageArray[i], manTitleArray[i], null));
        }
        return appiList;
    }

    //食品
    private static int[] foodImageArray = {R.drawable.food01, R.drawable.food02, R.drawable.food03
            , R.drawable.food04, R.drawable.food05, R.drawable.food06, R.drawable.food07
            , R.drawable.food08,R.drawable.food09, R.drawable.food10, R.drawable.food11
            , R.drawable.food12, R.drawable.food13, R.drawable.food14, R.drawable.food15
            , R.drawable.food16, R.drawable.food17,R.drawable.food18, R.drawable.food19, R.drawable.food20};
    private static String[] foodTitleArray = {"双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权","双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权", "享特权", "付定金", "享特权", "享特权"};

    public static List<NewsInfo> getDefaultfood() {
        List<NewsInfo> appiList = new ArrayList<NewsInfo>();
        for (int i = 0; i < foodImageArray.length; i++) {
            appiList.add(new com.example.myapp.bean.NewsInfo(foodImageArray[i], foodTitleArray[i], null));
        }
        return appiList;
    }

    //手机 phone
    private static int[] phoneImageArray = {R.drawable.phone01, R.drawable.phone02, R.drawable.phone03
            , R.drawable.phone04, R.drawable.phone05, R.drawable.phone06, R.drawable.phone07
            , R.drawable.phone08,R.drawable.phone09, R.drawable.phone10, R.drawable.phone11
            , R.drawable.phone12, R.drawable.phone13, R.drawable.phone14, R.drawable.phone15
            , R.drawable.phone16, R.drawable.phone17,R.drawable.phone18, R.drawable.phone19, R.drawable.phone20};
    private static String[] phoneTitleArray = {"双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权","双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权", "享特权", "付定金", "享特权", "享特权"};

    public static List<NewsInfo> getDefaultphone() {
        List<NewsInfo> appiList = new ArrayList<NewsInfo>();
        for (int i = 0; i < phoneImageArray.length; i++) {
            appiList.add(new com.example.myapp.bean.NewsInfo(phoneImageArray[i], phoneTitleArray[i], null));
        }
        return appiList;
    }
}
