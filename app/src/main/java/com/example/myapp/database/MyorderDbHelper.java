package com.example.myapp.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.myapp.bean.CartInfo;
//import com.example.myapp.bean.MyorderInfo;
import com.example.myapp.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("DefaultLocale")
abstract public class MyorderDbHelper extends SQLiteOpenHelper {
    protected static String TAG = "MyorderDbHelper";
    protected static String db_name = "myorder2.db";
    protected Context mContext;
    protected int mVersion;
    protected SQLiteDatabase mReadDB;
    protected SQLiteDatabase mWriteDB;
    protected String mTableName;
    protected String mCreateSQL;
    protected String mSelectSQL;

    public MyorderDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
        mVersion = version;
        mWriteDB = this.getWritableDatabase();
        mReadDB = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        mCreateSQL = "CREATE TABLE IF NOT EXISTS goods_myorder ("
                + "_id INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,"
                + "goods_name VARCHAR NOT NULL,"
                + "price DOUBLE NOT NULL,"
                + "num DOUBLE NOT NULL,"
//                + "evaluate_status INTEGER NOT NULL,"
                + "sum DOUBLE NOT NULL,"
                + "create_time VARCHAR NOT NULL"
                + ");";
        Log.d(TAG, "create_sql:" + mCreateSQL);
        db.execSQL(mCreateSQL);
//        mCreateSQL = "CREATE TABLE IF NOT EXISTS evaluate_info ("
//                + "_id INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,"
//                + "order_id INTEGER NOT NULL," + "goods_name VARCHAR NOT NULL,"
//                + "evaluate_star INTEGER NOT NULL," + "evaluate_content VARCHAR NOT NULL,"
//                + "create_time VARCHAR NOT NULL" + ");";
//        Log.d(TAG, "create_sql:" + mCreateSQL);
//        db.execSQL(mCreateSQL);
//        mCreateSQL = "CREATE TABLE IF NOT EXISTS evaluate_photo ("
//                + "_id INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,"
//                + "evaluate_id INTEGER NOT NULL," + "image_path VARCHAR NOT NULL"
//                + ");";
//        Log.d(TAG, "create_sql:" + mCreateSQL);
//        db.execSQL(mCreateSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    // 根据序号删除记录
    public void delete(int id) {
        String delete_sql = String.format("delete from %s where _id=%d;", mTableName, id);
        Log.d(TAG, "delete sql="+delete_sql);
        mWriteDB.execSQL(delete_sql);
    }

    // 根据行号删除记录
    public void deleteByRowid(long rowid) {
        String delete_sql = String.format("delete from %s where rowid=%d;", mTableName, rowid);
        Log.d(TAG, "delete sql="+delete_sql);
        mWriteDB.execSQL(delete_sql);
    }

    abstract protected List<?> query(String sql);

    // 根据序号查询记录
    public List<?> queryById(int id) {
        String sql = " _id=" + id + ";";
        return query(sql);
    }

    // 根据行号查询记录
    public List<?> queryByRowid(long rowid) {
        String sql = " rowid=" + rowid + ";";
        return query(sql);
    }

    // 查询所有记录
    public List<?> queryAll() {
        String sql = " 1=1;";
        return query(sql);
    }

    // 统计记录数量
    public int queryCount(String sql) {
        int count = 0;
        Cursor cursor = mReadDB.rawQuery(sql, null);
        count = cursor.getCount();
        cursor.close();
        Log.d(TAG, "count="+count+",sql="+sql);
        return count;
    }
}



//@SuppressLint("DefaultLocale")
//public class MyorderDbHelper extends SQLiteOpenHelper {
//    private static final String TAG = "MyorderDbHelper";
//    private static final String DB_NAME = "myorder.db"; // 数据库的名称
//    private static final int DB_VERSION = 1; // 数据库的版本号
//    private static com.example.myapp.database.MyorderDbHelper mHelper = null; // 数据库帮助器的实例
//    private SQLiteDatabase mDB = null; // 数据库的实例
//    private static final String TABLE_NAME = "myorder_info"; // 表的名称
//
//    private MyorderDbHelper(Context context) {
//        super(context, DB_NAME, null, DB_VERSION);
//    }
//
//    private MyorderDbHelper(Context context, int version) {
//        super(context, DB_NAME, null, version);
//    }
//
//    // 利用单例模式获取数据库帮助器的唯一实例
//    public static com.example.myapp.database.MyorderDbHelper getInstance(Context context, int version) {
//        if (version > 0 && mHelper == null) {
//            mHelper = new com.example.myapp.database.MyorderDbHelper(context, version);
//        } else if (mHelper == null) {
//            mHelper = new com.example.myapp.database.MyorderDbHelper(context);
//        }
//        return mHelper;
//    }
//
//    // 打开数据库的读连接
//    public SQLiteDatabase openReadLink() {
//        if (mDB == null || !mDB.isOpen()) {
//            mDB = mHelper.getReadableDatabase();
//        }
//        return mDB;
//    }
//
//    // 打开数据库的写连接
//    public SQLiteDatabase openWriteLink() {
//        if (mDB == null || !mDB.isOpen()) {
//            mDB = mHelper.getWritableDatabase();
//        }
//        return mDB;
//    }
//
//    // 关闭数据库连接
//    public void closeLink() {
//        if (mDB != null && mDB.isOpen()) {
//            mDB.close();
//            mDB = null;
//        }
//    }
//
//    // 创建数据库，执行建表语句
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        Log.d(TAG, "onCreate");
//        String drop_sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
//        Log.d(TAG, "drop_sql:" + drop_sql);
//        db.execSQL(drop_sql);
//        String create_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
//                + "_id INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,"
//                + "order_id INTEGER NOT NULL,"
//                + "goods_name VARCHAR NOT NULL,"
//                + "evaluate_star INTEGER NOT NULL,"
//                + "evaluate_content VARCHAR NOT NULL,"
//                + "create_time VARCHAR NOT NULL"
//                + ");";
//        Log.d(TAG, "create_sql:" + create_sql);
//        db.execSQL(create_sql); // 执行完整的SQL语句
//    }
//
//    // 修改数据库，执行表结构变更语句
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//    }
//
//    // 根据指定条件删除表记录
//    public int delete(String condition) {
//        // 执行删除记录动作，该语句返回删除记录的数目
//        return mDB.delete(TABLE_NAME, condition, null);
//    }
//
//    // 删除该表的所有记录
//    public int deleteAll() {
//        // 执行删除记录动作，该语句返回删除记录的数目
//        return mDB.delete(TABLE_NAME, "1=1", null);
//    }
//
//    // 往该表添加一条记录
//    public long insert(MyorderInfo info) {
//        List<MyorderInfo> infoList = new ArrayList<MyorderInfo>();
//        infoList.add(info);
//        return insert(infoList);
//    }
//
//    // 往该表添加多条记录
//    public long insert(List<MyorderInfo> infoList) {
//        long result = -1;
//        for (MyorderInfo info : infoList) {
//            Log.d(TAG, "goods_id=" + info.goods_id + ", count=" + info.count);
//            // 如果存在相同rowid的记录，则更新记录
//            if (info.rowid > 0) {
//                String condition = String.format("rowid='%d'", info.rowid);
//                update(info, condition);
//                result = info.rowid;
//                continue;
//            }
//            // 不存在唯一性重复的记录，则插入新记录
//            ContentValues cv = new ContentValues();
//            cv.put("goods_id", info.goods_id);
//            cv.put("count", info.count);
//            cv.put("update_time", info.update_time);
//            // 执行插入记录动作，该语句返回插入记录的行号
//            result = mDB.insert(TABLE_NAME, "", cv);
//            if (result == -1) { // 添加成功则返回行号，添加失败则返回-1
//                return result;
//            }
//        }
//        return result;
//    }
//
//    // 根据条件更新指定的表记录
//    public int update(CartInfo info, String condition) {
//        ContentValues cv = new ContentValues();
//        cv.put("goods_id", info.goods_id);
//        cv.put("count", info.count);
//        cv.put("update_time", info.update_time);
//        // 执行更新记录动作，该语句返回更新的记录数量
//        return mDB.update(TABLE_NAME, cv, condition, null);
//    }
//
//    public int update(CartInfo info) {
//        // 执行更新记录动作，该语句返回更新的记录数量
//        return update(info, "rowid=" + info.rowid);
//    }
//
//    public void save(long goods_id) {
//        CartInfo info = queryByGoodsId(goods_id);
//        if (info == null) { // 不存在该商品，则插入一条记录
//            info = new CartInfo();
//            info.goods_id = goods_id;
//            info.count = 1;
//            info.update_time = DateUtil.getNowDateTime("");
//            insert(info); // 往购物车数据库中添加一条新的商品记录
//        } else { // 已存在该商品，则更新原记录
//            info.count++; // 该商品的数量加一
//            info.update_time = DateUtil.getNowDateTime("");
//            update(info); // 更新购物车数据库中的商品记录信息
//        }
//    }
//
//    // 根据指定条件查询记录，并返回结果数据列表
//    public List<CartInfo> query(String condition) {
//        String sql = String.format("select rowid,_id,goods_id,count,update_time" +
//                " from %s where %s;", TABLE_NAME, condition);
//        Log.d(TAG, "query sql: " + sql);
//        List<CartInfo> infoList = new ArrayList<CartInfo>();
//        // 执行记录查询动作，该语句返回结果集的游标
//        Cursor cursor = mDB.rawQuery(sql, null);
//        // 循环取出游标指向的每条记录
//        while (cursor.moveToNext()) {
//            CartInfo info = new CartInfo();
//            info.rowid = cursor.getLong(0);
//            info.xuhao = cursor.getInt(1);
//            info.goods_id = cursor.getLong(2);
//            info.count = cursor.getInt(3);
//            info.update_time = cursor.getString(4);
//            infoList.add(info);
//        }
//        cursor.close(); // 查询完毕，关闭数据库游标
//        return infoList;
//    }
//
//    // 根据行号查询指定记录
//    public CartInfo queryById(long rowid) {
//        CartInfo info = null;
//        List<CartInfo> infoList = query(String.format("rowid='%d'", rowid));
//        if (infoList.size() > 0) {
//            info = infoList.get(0);
//        }
//        return info;
//    }
//
//    // 根据商品编号查询指定记录
//    public CartInfo queryByGoodsId(long goods_id) {
//        CartInfo info = null;
//        List<CartInfo> infoList = query(String.format("goods_id='%d'", goods_id));
//        if (infoList.size() > 0) {
//            info = infoList.get(0);
//        }
//        return info;
//    }
//
//    public int queryCount() {
//        int count = 0;
//        String sql = String.format("select sum(count) from %s;", TABLE_NAME);
//        // 执行记录查询动作，该语句返回结果集的游标
//        Cursor cursor = mDB.rawQuery(sql, null);
//        // 循环取出游标指向的每条记录
//        while (cursor.moveToNext()) {
//            count = cursor.getInt(0);
//        }
//        Log.d(TAG, "count="+count);
//        return count;
//    }
//
//}