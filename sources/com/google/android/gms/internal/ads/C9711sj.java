package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwt.zzg;
import com.google.android.gms.internal.ads.zzwt.zzi.zzc;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ads.sj */
final /* synthetic */ class C9711sj implements zzczc {

    /* renamed from: a */
    private final C9690rj f22959a;

    /* renamed from: b */
    private final boolean f22960b;

    /* renamed from: c */
    private final ArrayList f22961c;

    /* renamed from: d */
    private final zzg f22962d;

    /* renamed from: e */
    private final zzc f22963e;

    C9711sj(C9690rj rjVar, boolean z, ArrayList arrayList, zzg zzg, zzc zzc) {
        this.f22959a = rjVar;
        this.f22960b = z;
        this.f22961c = arrayList;
        this.f22962d = zzg;
        this.f22963e = zzc;
    }

    public final Object apply(Object obj) {
        C9690rj rjVar = this.f22959a;
        boolean z = this.f22960b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        byte[] a = rjVar.f22939b.m28494a(z, this.f22961c, this.f22962d, this.f22963e);
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzk.zzln().mo27935b()));
        contentValues.put("serialized_proto_data", a);
        sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
        String str = "UPDATE offline_signal_statistics SET total = total+1 WHERE statistic_name = '%s'";
        sQLiteDatabase.execSQL(String.format(str, new Object[]{"total_requests"}));
        if (!z) {
            sQLiteDatabase.execSQL(String.format(str, new Object[]{"failed_requests"}));
        }
        return null;
    }
}
