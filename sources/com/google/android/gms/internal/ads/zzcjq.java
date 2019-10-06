package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzwt.zzi.zza;
import java.util.ArrayList;

public final class zzcjq {
    /* renamed from: a */
    public static ArrayList<zza> m28503a(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zza> arrayList = new ArrayList<>();
        String str = "serialized_proto_data";
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("offline_signal_contents", new String[]{str}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zza.m31394a(query.getBlob(query.getColumnIndexOrThrow(str))));
            } catch (zzdok e) {
                zzbad.m26355b("Unable to deserialize proto from offline signals database:");
                zzbad.m26355b(e.getMessage());
            }
        }
        query.close();
        return arrayList;
    }

    /* renamed from: a */
    public static int m28502a(SQLiteDatabase sQLiteDatabase, int i) {
        String str = "total";
        int i2 = 0;
        String[] strArr = {str};
        String[] strArr2 = new String[1];
        if (i == 1) {
            strArr2[0] = "failed_requests";
        } else if (i == 2) {
            strArr2[0] = "total_requests";
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, null, null, null);
        if (query.getCount() > 0) {
            query.moveToNext();
            i2 = 0 + query.getInt(query.getColumnIndexOrThrow(str));
        }
        query.close();
        return i2;
    }
}
