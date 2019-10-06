package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class zzcja extends SQLiteOpenHelper {
    public zzcja(Context context) {
        super(context, "OfflineUpload.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_signal_contents (timestamp INTEGER PRIMARY_KEY, serialized_proto_data BLOB)");
        sQLiteDatabase.execSQL("CREATE TABLE offline_signal_statistics (statistic_name TEXT PRIMARY_KEY, total INTEGER)");
        ContentValues contentValues = new ContentValues();
        String str = "statistic_name";
        contentValues.put(str, "failed_requests");
        Integer valueOf = Integer.valueOf(0);
        String str2 = "total";
        contentValues.put(str2, valueOf);
        String str3 = "offline_signal_statistics";
        sQLiteDatabase.insert(str3, null, contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(str, "total_requests");
        contentValues2.put(str2, valueOf);
        sQLiteDatabase.insert(str3, null, contentValues2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_contents");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_statistics");
    }
}
