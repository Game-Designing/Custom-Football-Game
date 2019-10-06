package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.google.android.gms.internal.ads.qj */
final class C9669qj implements zzban<SQLiteDatabase> {

    /* renamed from: a */
    private final /* synthetic */ zzczc f22902a;

    C9669qj(zzcjc zzcjc, zzczc zzczc) {
        this.f22902a = zzczc;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        String str = "Failed to get offline signal database: ";
        zzbad.m26355b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        try {
            this.f22902a.apply((SQLiteDatabase) obj);
        } catch (Exception e) {
            String str = "Error executing function on offline signal database: ";
            String valueOf = String.valueOf(e.getMessage());
            zzbad.m26355b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
