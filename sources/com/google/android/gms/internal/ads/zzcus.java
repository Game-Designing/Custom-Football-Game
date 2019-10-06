package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

public final class zzcus implements zzcva<zzcur> {

    /* renamed from: a */
    private final zzavg f27415a;

    /* renamed from: b */
    private final zzbbl f27416b;

    /* renamed from: c */
    private final Context f27417c;

    public zzcus(zzavg zzavg, zzbbl zzbbl, Context context) {
        this.f27415a = zzavg;
        this.f27416b = zzbbl;
        this.f27417c = context;
    }

    /* renamed from: a */
    public final zzbbh<zzcur> mo28586a() {
        return this.f27416b.mo30326a((Callable<T>) new C9024Nl<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcur mo31267b() throws Exception {
        Long l;
        if (!this.f27415a.mo30134f(this.f27417c)) {
            zzcur zzcur = new zzcur(null, null, null, null, null);
            return zzcur;
        }
        String a = this.f27415a.mo30121a(this.f27417c);
        String str = "";
        String str2 = a == null ? str : a;
        String b = this.f27415a.mo30125b(this.f27417c);
        String str3 = b == null ? str : b;
        String c = this.f27415a.mo30127c(this.f27417c);
        String str4 = c == null ? str : c;
        String d = this.f27415a.mo30129d(this.f27417c);
        String str5 = d == null ? str : d;
        if ("TIME_OUT".equals(str3)) {
            l = (Long) zzyt.m31536e().mo29599a(zzacu.f23921Ea);
        } else {
            l = null;
        }
        zzcur zzcur2 = new zzcur(str2, str3, str4, str5, l);
        return zzcur2;
    }
}
