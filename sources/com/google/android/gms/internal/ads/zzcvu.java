package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

public final class zzcvu implements zzcva<zzcvt> {

    /* renamed from: a */
    private final zzawi f27473a;

    /* renamed from: b */
    private final Executor f27474b;

    /* renamed from: c */
    private final String f27475c;

    /* renamed from: d */
    private final PackageInfo f27476d;

    public zzcvu(zzawi zzawi, Executor executor, String str, PackageInfo packageInfo) {
        this.f27473a = zzawi;
        this.f27474b = executor;
        this.f27475c = str;
        this.f27476d = packageInfo;
    }

    /* renamed from: a */
    public final zzbbh<zzcvt> mo28586a() {
        return zzbar.m26381a(zzbar.m26380a(this.f27473a.mo30150a(this.f27475c, this.f27476d), C9237Xl.f21928a, this.f27474b), Throwable.class, (zzbal<? super X, ? extends V>) new C9258Yl<Object,Object>(this), this.f27474b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31272a(Throwable th) throws Exception {
        return zzbar.m26376a(new zzcvt(this.f27475c));
    }
}
