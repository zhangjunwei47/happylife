package com.zc.happy.life.happylife.databasex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.zc.happy.life.happylife.databasex.MyDataBaseHelper.KEY_DATA;
import static com.zc.happy.life.happylife.databasex.MyDataBaseHelper.KEY_FILENAME;

/**
 * 类说明:
 * Created by zhangchao on 2017/3/27.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private String sql = "create table " + MyDataBaseHelper.DATA_BASE_NAME + "("
            + KEY_DATA + "int primary key not null, "
            + KEY_FILENAME + " TEXT, "
            + ")";

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
