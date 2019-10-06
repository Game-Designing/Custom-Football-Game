package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwl.zza.zzb;
import com.google.android.gms.internal.ads.zzwt.zzi;
import com.google.android.gms.internal.ads.zzwt.zzi.zza;

public final class zzcjr {

    /* renamed from: a */
    private zzwj f26720a;

    /* renamed from: b */
    private Context f26721b;

    /* renamed from: c */
    private zzcjc f26722c;

    /* renamed from: d */
    private zzbai f26723d;

    public zzcjr(Context context, zzbai zzbai, zzwj zzwj, zzcjc zzcjc) {
        this.f26721b = context;
        this.f26723d = zzbai;
        this.f26720a = zzwj;
        this.f26722c = zzcjc;
    }

    /* renamed from: a */
    public final void mo31184a() {
        try {
            this.f26722c.mo31173a(new C9732tj(this));
        } catch (Exception e) {
            String str = "Error in offline signals database startup: ";
            String valueOf = String.valueOf(e.getMessage());
            zzbad.m26355b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ Void mo31183a(SQLiteDatabase sQLiteDatabase) throws Exception {
        int i = 2;
        this.f26720a.mo32329a((zzwk) new C9753uj((zzi) zzi.m31391l().mo32352a(this.f26721b.getPackageName()).mo32354b(Build.MODEL).mo32349a(zzcjq.m28502a(sQLiteDatabase, 1)).mo32351a((Iterable<? extends zza>) zzcjq.m28503a(sQLiteDatabase)).mo32353b(zzcjq.m28502a(sQLiteDatabase, 2)).mo32350a(zzk.zzln().mo27935b()).mo31612g()));
        zzxo zzxo = new zzxo();
        zzxo.f29698c = Integer.valueOf(this.f26723d.f25058b);
        zzxo.f29699d = Integer.valueOf(this.f26723d.f25059c);
        boolean z = this.f26723d.f25060d;
        Integer valueOf = Integer.valueOf(0);
        if (z) {
            i = 0;
        }
        zzxo.f29700e = Integer.valueOf(i);
        this.f26720a.mo32329a((zzwk) new C9774vj(zzxo));
        this.f26720a.mo32330a(zzb.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues = new ContentValues();
        String str = "total";
        contentValues.put(str, valueOf);
        String str2 = "statistic_name = ?";
        String str3 = "offline_signal_statistics";
        sQLiteDatabase.update(str3, contentValues, str2, new String[]{"failed_requests"});
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(str, valueOf);
        sQLiteDatabase.update(str3, contentValues2, str2, new String[]{"total_requests"});
        return null;
    }
}
