package com.flurry.sdk;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.Ib */
public final class C7395Ib extends C7447Rb {

    /* renamed from: b */
    public WeakReference<Activity> f14499b = new WeakReference<>(null);

    /* renamed from: c */
    public int f14500c;

    /* renamed from: com.flurry.sdk.Ib$a */
    public enum C7396a {
        ;
        

        /* renamed from: a */
        public static final int f14501a = 0;

        /* renamed from: b */
        public static final int f14502b = 0;

        /* renamed from: c */
        public static final int f14503c = 0;

        /* renamed from: d */
        public static final int f14504d = 0;

        /* renamed from: e */
        public static final int f14505e = 0;

        /* renamed from: f */
        public static final int f14506f = 0;

        /* renamed from: g */
        public static final int f14507g = 0;

        /* renamed from: a */
        public static int[] m16371a() {
            return (int[]) f14508h.clone();
        }

        static {
            f14501a = 1;
            f14502b = 2;
            f14503c = 3;
            f14504d = 4;
            f14505e = 5;
            f14506f = 6;
            f14507g = 7;
            f14508h = new int[]{f14501a, f14502b, f14503c, f14504d, f14505e, f14506f, f14507g};
        }
    }

    C7395Ib() {
        super("com.flurry.android.sdk.ActivityLifecycleEvent");
    }
}
