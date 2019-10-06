package com.flurry.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.id */
public final class C7537id extends C7447Rb {

    /* renamed from: b */
    public WeakReference<Context> f14883b;

    /* renamed from: c */
    public C7531hd f14884c;

    /* renamed from: d */
    public int f14885d;

    /* renamed from: e */
    public long f14886e;

    /* renamed from: com.flurry.sdk.id$a */
    public enum C7538a {
        ;
        

        /* renamed from: a */
        public static final int f14887a = 0;

        /* renamed from: b */
        public static final int f14888b = 0;

        /* renamed from: c */
        public static final int f14889c = 0;

        /* renamed from: d */
        public static final int f14890d = 0;

        /* renamed from: e */
        public static final int f14891e = 0;

        /* renamed from: a */
        public static int[] m16702a() {
            return (int[]) f14892f.clone();
        }

        static {
            f14887a = 1;
            f14888b = 2;
            f14889c = 3;
            f14890d = 4;
            f14891e = 5;
            f14892f = new int[]{f14887a, f14888b, f14889c, f14890d, f14891e};
        }
    }

    public C7537id() {
        super("com.flurry.android.sdk.FlurrySessionEvent");
    }
}
