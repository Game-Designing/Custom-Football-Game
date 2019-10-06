package com.fyber.inneractive.sdk.util;

import android.util.Log;

public class IAlog {

    /* renamed from: a */
    public static int f16291a = 4;

    /* renamed from: com.fyber.inneractive.sdk.util.IAlog$a */
    public static class C7984a {

        /* renamed from: a */
        long f16292a = System.currentTimeMillis();

        /* renamed from: b */
        String f16293b;

        /* renamed from: c */
        String f16294c;

        public C7984a(String str, String str2) {
            this.f16294c = str;
            this.f16293b = str2;
        }

        /* renamed from: a */
        public final void mo24830a() {
            StringBuilder sb = new StringBuilder(this.f16294c);
            sb.append("timelog: ");
            sb.append(this.f16293b);
            sb.append(" took ");
            sb.append(System.currentTimeMillis() - this.f16292a);
            sb.append(" msec");
            IAlog.m18019a(sb.toString());
        }
    }

    /* renamed from: a */
    public static void m18019a(String str) {
        if (f16291a <= 2) {
            Log.v("Inneractive_verbose", str);
        }
    }

    /* renamed from: b */
    public static void m18021b(String str) {
        if (f16291a <= 3) {
            Log.d("Inneractive_debug", str);
        }
    }

    /* renamed from: c */
    public static void m18022c(String str) {
        if (f16291a <= 4) {
            Log.i("Inneractive_info", str);
        }
    }

    /* renamed from: d */
    public static void m18023d(String str) {
        if (f16291a <= 5) {
            Log.w("Inneractive_warning", str);
        }
    }

    /* renamed from: e */
    public static void m18024e(String str) {
        if (f16291a <= 6) {
            Log.e("Inneractive_error", str);
        }
    }

    /* renamed from: a */
    public static void m18020a(String str, Throwable th) {
        if (f16291a <= 6) {
            Log.e("Inneractive_error", str, th);
        }
    }

    /* renamed from: a */
    public static String m18018a(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(Thread.currentThread().getName());
        sb.append("): ");
        sb.append(obj.getClass().getSimpleName());
        sb.append("[");
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("] ");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m18017a(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(Thread.currentThread().getName());
        sb.append("): ");
        sb.append(cls.getSimpleName());
        sb.append("[");
        sb.append(Integer.toHexString(System.identityHashCode(cls)));
        sb.append("] ");
        return sb.toString();
    }
}
