package com.smaato.soma.p239c.p241b;

import android.os.Handler;
import android.view.View;

/* renamed from: com.smaato.soma.c.b.F */
/* compiled from: ScreenMetricsWaiter */
class C12159F {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Handler f38112a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static View[] f38113b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Runnable f38114c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f38115d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f38116e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Runnable f38117f = new C12156C();

    /* renamed from: a */
    static void m39987a(Runnable successRunnable, View... views) {
        new C12157D(successRunnable, views).execute();
    }

    /* renamed from: g */
    static boolean m39995g() {
        return (f38113b == null && f38114c == null) ? false : true;
    }

    /* renamed from: f */
    static void m39994f() {
        new C12158E().execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static void m39996h() {
        f38115d--;
        if (f38115d == 0) {
            Runnable runnable = f38114c;
            if (runnable != null) {
                runnable.run();
                f38114c = null;
                f38113b = null;
            }
        }
    }
}
