package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.Uc */
final /* synthetic */ class C9165Uc implements Runnable {

    /* renamed from: a */
    private final zzbbr f21792a;

    /* renamed from: b */
    private final zzbbh f21793b;

    /* renamed from: c */
    private final Class f21794c;

    /* renamed from: d */
    private final zzbal f21795d;

    /* renamed from: e */
    private final Executor f21796e;

    C9165Uc(zzbbr zzbbr, zzbbh zzbbh, Class cls, zzbal zzbal, Executor executor) {
        this.f21792a = zzbbr;
        this.f21793b = zzbbh;
        this.f21794c = cls;
        this.f21795d = zzbal;
        this.f21796e = executor;
    }

    public final void run() {
        zzbar.m26387a(this.f21792a, this.f21793b, this.f21794c, this.f21795d, this.f21796e);
    }
}
