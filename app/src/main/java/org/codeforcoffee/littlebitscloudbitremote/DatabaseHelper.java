package org.codeforcoffee.littlebitscloudbitremote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by codeforcoffee on 8/8/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // singleton
    private static DatabaseHelper mInstance;
    public static synchronized DatabaseHelper getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    // db version & name
    public static final String DATABASE_NAME = "CloudBits.db";
    public static final int DATABASE_VERSION = 1;

    // table specific private classes statements
    public static final String TOKENS_TABLE_NAME = "bearer_tokens";
    public static final String TOKENS_COL_ID = "_id";
    public static final String TOKENS_COL_BEARER = "token";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTokenTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(dropTokenTable());
        onCreate(db);
    }

    private String createTokenTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(TOKENS_TABLE_NAME);
        sb.append(" (");
        sb.append(TOKENS_COL_ID);
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sb.append(TOKENS_COL_BEARER);
        sb.append(" TEXT);");
        return sb.toString();
    }

    private String dropTokenTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE IF EXISTS ");
        sb.append(TOKENS_TABLE_NAME);
        sb.append(";");
        return sb.toString();
    }
}
