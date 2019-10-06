package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.view.g */
/* compiled from: LayoutInflaterCompat */
public final class C0624g {

    /* renamed from: a */
    private static Field f1848a;

    /* renamed from: b */
    private static boolean f1849b;

    /* renamed from: c */
    static final C0626b f1850c;

    /* renamed from: android.support.v4.view.g$a */
    /* compiled from: LayoutInflaterCompat */
    static class C0625a extends C0626b {
        C0625a() {
        }

        /* renamed from: a */
        public void mo5656a(LayoutInflater inflater, Factory2 factory) {
            inflater.setFactory2(factory);
        }
    }

    /* renamed from: android.support.v4.view.g$b */
    /* compiled from: LayoutInflaterCompat */
    static class C0626b {
        C0626b() {
        }

        /* renamed from: a */
        public void mo5656a(LayoutInflater inflater, Factory2 factory) {
            inflater.setFactory2(factory);
            Factory f = inflater.getFactory();
            if (f instanceof Factory2) {
                C0624g.m2883a(inflater, (Factory2) f);
            } else {
                C0624g.m2883a(inflater, factory);
            }
        }
    }

    /* renamed from: a */
    static void m2883a(LayoutInflater inflater, Factory2 factory) {
        String str = "; inflation may have unexpected results.";
        String str2 = "LayoutInflaterCompatHC";
        if (!f1849b) {
            try {
                f1848a = LayoutInflater.class.getDeclaredField("mFactory2");
                f1848a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                sb.append(LayoutInflater.class.getName());
                sb.append(str);
                Log.e(str2, sb.toString(), e);
            }
            f1849b = true;
        }
        Field field = f1848a;
        if (field != null) {
            try {
                field.set(inflater, factory);
            } catch (IllegalAccessException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                sb2.append(inflater);
                sb2.append(str);
                Log.e(str2, sb2.toString(), e2);
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1850c = new C0625a();
        } else {
            f1850c = new C0626b();
        }
    }

    /* renamed from: b */
    public static void m2884b(LayoutInflater inflater, Factory2 factory) {
        f1850c.mo5656a(inflater, factory);
    }
}
