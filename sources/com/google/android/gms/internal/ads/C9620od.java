package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.od */
final class C9620od implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f22832a;

    /* renamed from: b */
    private final /* synthetic */ String f22833b;

    /* renamed from: c */
    private final /* synthetic */ zzbcd f22834c;

    C9620od(zzbcd zzbcd, String str, String str2) {
        this.f22834c = zzbcd;
        this.f22832a = str;
        this.f22833b = str2;
    }

    public final void run() {
        if (this.f22834c.f25092r != null) {
            this.f22834c.f25092r.mo30374a(this.f22832a, this.f22833b);
        }
    }
}
