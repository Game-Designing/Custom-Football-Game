package com.paypal.android.sdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.paypal.android.sdk.oa */
public abstract class C11855oa extends C11847ma {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f37282b = C11855oa.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C11707Ba f37283c;

    /* renamed from: d */
    private final ThreadPoolExecutor f37284d = ((ThreadPoolExecutor) Executors.newCachedThreadPool());
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f37285e;

    public C11855oa(int i, C11707Ba ba) {
        this.f37285e = i;
        this.f37283c = ba;
    }

    /* renamed from: a */
    public final void mo38828a() {
    }

    /* renamed from: a */
    public final boolean mo38829a(C11703Aa aa) {
        this.f37284d.submit(new C11859pa(this, aa));
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract String mo38611b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract int mo38612c();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract boolean mo38613c(C11703Aa aa);
}
