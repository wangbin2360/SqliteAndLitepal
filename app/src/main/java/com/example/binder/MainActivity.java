/*package com.example.binder;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.insert_value);
        addData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "Da");
                values.put("author", "Dan");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book", null, values);
            }
        });
        Button updateData = (Button) findViewById(R.id.update);
        updateData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                db.update("Book", values, "name = ?",
                        new String[] { "Da" });
            }
        });
        Button deleteButton = (Button) findViewById(R.id.delete);
        deleteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book", "price = ?", new String[] { "10.99" });
            }
        });
        Button queryButton = (Button) findViewById(R.id.select_value);
        queryButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null,
                        null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor
                                .getColumnIndex("name"));
                        String author = cursor.getString(cursor
                                .getColumnIndex("author"));
                        int pages = cursor.getInt(cursor
                                .getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor
                                .getColumnIndex("price"));
                        Toast.makeText(MainActivity.this, "[name:"+name+",author:"+ author+"page:"+pages+"" +
                                ",price:"+price+"]",Toast.LENGTH_SHORT).show();
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
      *//*  Button replaceData = (Button) findViewById(R.id.replace_data);
        replaceData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.beginTransaction();
                try {
                    db.delete("Book", null, null);
//					if (true) {
//						throw new NullPointerException();
//					}
                    ContentValues values = new ContentValues();
                    values.put("name", "Game of Thrones");
                    values.put("author", "George Martin");
                    values.put("pages", 720);
                    values.put("price", 20.85);
                    db.insert("Book", null, values);
                    db.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    db.endTransaction();
                }
            }
        });*//*
    }

}*/


package com.example.binder;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase =  (Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
            }
        });
        Button insert = (Button)findViewById(R.id.insert_value);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setAuthor("wb");
                book.setName("QSMY");
                book.setPages(1);
                book.setPrice(20.5);
                book.save();
            }
        });

        Button update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("20");
                book.updateAll("name=? and author=?","QSMY","wb");
            }
        });

        Button select = (Button)findViewById(R.id.select_value);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               List<Book> list = DataSupport.findAll(Book.class);
                for(Book b :list){
                     Toast.makeText(MainActivity.this,b.toString(),Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button button = (Button)findViewById(R.id.delete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 DataSupport.deleteAll(Book.class,"name=?","20");
            }
        });






    }
}


/*
    private Button button;
    private SqlLite sqlLite;
    private SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlLite = new SqlLite(this,"Student.db",null,1);
        button = (Button)findViewById(R.id.create_database);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.create_database)
            sqLiteDatabase = sqlLite.getWritableDatabase();
        if(view.getId() == R.id.insert_value){
            sqLiteDatabase = sqlLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name","cc");
            contentValues.put("age","5");
            sqLiteDatabase.insert("student",null,contentValues);
        }
       else if(view.getId()==R.id.select_value){
            sqLiteDatabase = sqlLite.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from student",null);
            if(cursor.moveToFirst()){
                while (cursor.moveToNext()){
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String age = cursor.getString(cursor.getColumnIndex("age"));
                    Toast.makeText(MainActivity.this,"[id:"+id+",name:"+name+",age:"+age+"]",Toast.LENGTH_SHORT).show();
                }
            }
        }
      else  if(view.getId()==R.id.update){
            sqLiteDatabase = sqlLite.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name","wb");
            sqLiteDatabase.update("student",values,"name=?",new String[]{"cc"});
        }
       else if(view.getId()==R.id.delete){
            sqLiteDatabase = sqlLite.getWritableDatabase();
            sqLiteDatabase.delete("student","name=?",new String[]{"wb"});
        }
    }
}
*/

