package com.example.yesorno;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_app.db";
    private static final int DATABASE_VERSION = 1;

    // Define the table structure and create queries here

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your tables and initial data here
        db.execSQL("CREATE TABLE IF NOT EXISTS items (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, imageResource INTEGER);");

        insertInitialItems(db);
    }

    private void insertInitialItems(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put("title", "Monte Cara");
        values.put("imageResource", R.drawable.montecara);
        db.insert("items", null, values);

        values.clear();

        // Insert the rest of the 7 items in a similar manner
        values.put("title", "Vulcao");
        values.put("imageResource", R.drawable.vulcao);
        db.insert("items", null, values);

        values.clear();

        values.put("title", "Carbeirinho");
        values.put("imageResource", R.drawable.carbeirinho);
        db.insert("items", null, values);

        values.clear();

        values.put("title", "Salinas");
        values.put("imageResource", R.drawable.salinaspedradolume);
        db.insert("items", null, values);

        values.clear();

        values.put("title", "Praia Santa MARIA");
        values.put("imageResource", R.drawable.praiadesantamaria);
        db.insert("items", null, values);

        values.clear();

        // Repeat for the other 3 items
        values.put("title", "Deserto Viana");
        values.put("imageResource", R.drawable.desertodeviana);
        db.insert("items", null, values);

        values.clear();

        values.put("title", "Parque Natural");
        values.put("imageResource", R.drawable.parquemontenacgordo);
        db.insert("items", null, values);

        values.clear();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database schema upgrades here if needed
    }
}
