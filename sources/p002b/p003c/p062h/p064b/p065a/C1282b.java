package p002b.p003c.p062h.p064b.p065a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.content.C0510b;
import android.support.p001v7.widget.C1096p;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* renamed from: b.c.h.b.a.b */
/* compiled from: AppCompatResources */
public final class C1282b {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f4089a = new ThreadLocal<>();

    /* renamed from: b */
    private static final WeakHashMap<Context, SparseArray<C1283a>> f4090b = new WeakHashMap<>(0);

    /* renamed from: c */
    private static final Object f4091c = new Object();

    /* renamed from: b.c.h.b.a.b$a */
    /* compiled from: AppCompatResources */
    private static class C1283a {

        /* renamed from: a */
        final ColorStateList f4092a;

        /* renamed from: b */
        final Configuration f4093b;

        C1283a(ColorStateList value, Configuration configuration) {
            this.f4092a = value;
            this.f4093b = configuration;
        }
    }

    /* renamed from: a */
    public static ColorStateList m5997a(Context context, int resId) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(resId);
        }
        ColorStateList csl = m6001c(context, resId);
        if (csl != null) {
            return csl;
        }
        ColorStateList csl2 = m6002d(context, resId);
        if (csl2 == null) {
            return C0510b.m2569b(context, resId);
        }
        m5999a(context, resId, csl2);
        return csl2;
    }

    /* renamed from: b */
    public static Drawable m6000b(Context context, int resId) {
        return C1096p.m5420a().mo8565a(context, resId);
    }

    /* renamed from: d */
    private static ColorStateList m6002d(Context context, int resId) {
        if (m6003e(context, resId)) {
            return null;
        }
        Resources r = context.getResources();
        try {
            return C1281a.m5993a(r, r.getXml(resId), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        return null;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m6001c(android.content.Context r5, int r6) {
        /*
            java.lang.Object r0 = f4091c
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<b.c.h.b.a.b$a>> r1 = f4090b     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0035 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ all -> 0x0035 }
            if (r2 <= 0) goto L_0x0032
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0035 }
            b.c.h.b.a.b$a r2 = (p002b.p003c.p062h.p064b.p065a.C1282b.C1283a) r2     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0032
            android.content.res.Configuration r3 = r2.f4093b     // Catch:{ all -> 0x0035 }
            android.content.res.Resources r4 = r5.getResources()     // Catch:{ all -> 0x0035 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0035 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x002f
            android.content.res.ColorStateList r3 = r2.f4092a     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r3
        L_0x002f:
            r1.remove(r6)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            r0 = 0
            return r0
        L_0x0035:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p062h.p064b.p065a.C1282b.m6001c(android.content.Context, int):android.content.res.ColorStateList");
    }

    /* renamed from: a */
    private static void m5999a(Context context, int resId, ColorStateList value) {
        synchronized (f4091c) {
            SparseArray sparseArray = (SparseArray) f4090b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f4090b.put(context, sparseArray);
            }
            sparseArray.append(resId, new C1283a(value, context.getResources().getConfiguration()));
        }
    }

    /* renamed from: e */
    private static boolean m6003e(Context context, int resId) {
        Resources r = context.getResources();
        TypedValue value = m5998a();
        r.getValue(resId, value, true);
        int i = value.type;
        if (i < 28 || i > 31) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static TypedValue m5998a() {
        TypedValue tv = (TypedValue) f4089a.get();
        if (tv != null) {
            return tv;
        }
        TypedValue tv2 = new TypedValue();
        f4089a.set(tv2);
        return tv2;
    }
}
