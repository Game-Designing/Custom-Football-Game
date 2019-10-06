package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.Ki */
final class C8958Ki extends zzair {

    /* renamed from: b */
    private final /* synthetic */ Object f21398b;

    /* renamed from: c */
    private final /* synthetic */ String f21399c;

    /* renamed from: d */
    private final /* synthetic */ long f21400d;

    /* renamed from: e */
    private final /* synthetic */ zzbbr f21401e;

    /* renamed from: f */
    private final /* synthetic */ zzcgb f21402f;

    C8958Ki(zzcgb zzcgb, Object obj, String str, long j, zzbbr zzbbr) {
        this.f21402f = zzcgb;
        this.f21398b = obj;
        this.f21399c = str;
        this.f21400d = j;
        this.f21401e = zzbbr;
    }

    public final void onInitializationSucceeded() {
        synchronized (this.f21398b) {
            this.f21402f.m28406a(this.f21399c, true, "", (int) (zzk.zzln().mo27934a() - this.f21400d));
            this.f21401e.mo30338b(Boolean.valueOf(true));
        }
    }

    public final void onInitializationFailed(String str) {
        synchronized (this.f21398b) {
            this.f21402f.m28406a(this.f21399c, false, str, (int) (zzk.zzln().mo27934a() - this.f21400d));
            this.f21401e.mo30338b(Boolean.valueOf(false));
        }
    }
}
