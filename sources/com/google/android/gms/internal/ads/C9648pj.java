package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.pj */
final /* synthetic */ class C9648pj implements Callable {

    /* renamed from: a */
    private final zzcja f22869a;

    private C9648pj(zzcja zzcja) {
        this.f22869a = zzcja;
    }

    /* renamed from: a */
    static Callable m24020a(zzcja zzcja) {
        return new C9648pj(zzcja);
    }

    public final Object call() {
        return this.f22869a.getWritableDatabase();
    }
}
