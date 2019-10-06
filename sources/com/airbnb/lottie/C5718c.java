package com.airbnb.lottie;

import android.support.p000v4.p037os.C0574d;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.airbnb.lottie.c */
/* compiled from: L */
public class C5718c {

    /* renamed from: a */
    public static boolean f9819a = false;

    /* renamed from: b */
    private static final Set<String> f9820b = new HashSet();

    /* renamed from: c */
    private static boolean f9821c = false;

    /* renamed from: d */
    private static String[] f9822d;

    /* renamed from: e */
    private static long[] f9823e;

    /* renamed from: f */
    private static int f9824f = 0;

    /* renamed from: g */
    private static int f9825g = 0;

    /* renamed from: b */
    public static void m10177b(String msg) {
        if (f9819a) {
            Log.d("LOTTIE", msg);
        }
    }

    /* renamed from: d */
    public static void m10179d(String msg) {
        if (!f9820b.contains(msg)) {
            Log.w("LOTTIE", msg);
            f9820b.add(msg);
        }
    }

    /* renamed from: a */
    public static void m10176a(String section) {
        if (f9821c) {
            int i = f9824f;
            if (i == 20) {
                f9825g++;
                return;
            }
            f9822d[i] = section;
            f9823e[i] = System.nanoTime();
            C0574d.m2755a(section);
            f9824f++;
        }
    }

    /* renamed from: c */
    public static float m10178c(String section) {
        int i = f9825g;
        if (i > 0) {
            f9825g = i - 1;
            return 0.0f;
        } else if (!f9821c) {
            return 0.0f;
        } else {
            f9824f--;
            int i2 = f9824f;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (section.equals(f9822d[i2])) {
                C0574d.m2754a();
                return ((float) (System.nanoTime() - f9823e[f9824f])) / 1000000.0f;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unbalanced trace call ");
                sb.append(section);
                sb.append(". Expected ");
                sb.append(f9822d[f9824f]);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
    }
}
