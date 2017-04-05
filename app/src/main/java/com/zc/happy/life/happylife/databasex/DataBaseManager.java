package com.zc.happy.life.happylife.databasex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zc.happy.life.happylife.util.StringUtil;

/**
 * 类说明:
 * Created by zhangchao on 2017/3/27.
 */

public class DataBaseManager {
    private SQLiteDatabase db;

    private DataBaseManager() {

    }

    private static class DATABASE_CLASS_INSTANCE {
        private final static DataBaseManager DATA_MANAGER = new DataBaseManager();
    }

    public static DataBaseManager getInstance() {
        return DATABASE_CLASS_INSTANCE.DATA_MANAGER;
    }

    /**
     * 初始化数据库
     */
    public void initDatabase(Context context) {
        if (db == null) {
            DataBaseHelper helper = new DataBaseHelper(context, MyDataBaseHelper.DATA_BASE_NAME, null, MyDataBaseHelper.VERSION);
            db = helper.getWritableDatabase();
        }
    }

    public void insertData(DataBaseBean dataBaseBean) {
        deleteData(dataBaseBean.getDate());
        insert(dataBaseBean);
    }

    private void insert(DataBaseBean dataBaseBean) {
        ContentValues cValue = new ContentValues();
        cValue.put(MyDataBaseHelper.KEY_DATA, dataBaseBean.getDate());
        cValue.put(MyDataBaseHelper.KEY_PS, dataBaseBean.getPs());
        db.insert(MyDataBaseHelper.DATA_BASE_NAME, null, cValue);
    }

    public void deleteData(String date) {
        String whereClause = MyDataBaseHelper.KEY_DATA + "=?";
        String[] whereArgs = {String.valueOf(date)};
        db.delete(MyDataBaseHelper.DATA_BASE_NAME, whereClause, whereArgs);
    }

    /**
     * 获取数据
     *
     * @param id 要获取的id
     * @return 返回查找到的数据
     */
    public DataBaseBean getData(String date) {
        String sql = StringUtil.join("SELECT * FROM ", MyDataBaseHelper.DATA_BASE_NAME
                , " WHERE ", MyDataBaseHelper.KEY_DATA, "=", date);
        Cursor cursor = db.rawQuery(sql, null);
        DataBaseBean dataBaseBean = null;
        if (cursor != null) {
            while (cursor.moveToNext()) {
                dataBaseBean.setDate(cursor.getString(0));
                dataBaseBean.setDate(cursor.getString(1));
            }
            cursor.close();
        }
        return dataBaseBean;
    }

}
