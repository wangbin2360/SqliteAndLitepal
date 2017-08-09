package com.example.binder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class SqlLite extends SQLiteOpenHelper {

    private final static String CREATE_STUDENT_TABLE = "create table student("
            +"id integer primary key autoincrement,"
            +"name varchar(20) Not Null,"
            +"age integer)";

    private Context context;
    public SqlLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
          this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
           sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
          
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
