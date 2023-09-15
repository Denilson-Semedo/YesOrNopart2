package com.example.yesorno;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private SQLiteDatabase database;
    private MyDatabaseHelper dbHelper;

    public ItemDAO(Context context) {
        dbHelper = new MyDatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public List<DashboardItem> getAllItems() {
        List<DashboardItem> itemList = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = database.query("items", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                @SuppressLint("Range") int imageResource = cursor.getInt(cursor.getColumnIndex("imageResource"));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
                itemList.add(new DashboardItem(imageResource, title));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return itemList;
    }

    // Add methods for inserting, updating, and deleting items as needed
}
