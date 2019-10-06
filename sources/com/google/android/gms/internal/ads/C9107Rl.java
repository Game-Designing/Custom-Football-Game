package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.Rl */
final /* synthetic */ class C9107Rl implements Callable {

    /* renamed from: a */
    private final List f21667a;

    /* renamed from: b */
    private final Object f21668b;

    C9107Rl(List list, Object obj) {
        this.f21667a = list;
        this.f21668b = obj;
    }

    public final Object call() {
        List list = this.f21667a;
        Object obj = this.f21668b;
        zzcvb.m28902a(list, obj);
        return obj;
    }
}
