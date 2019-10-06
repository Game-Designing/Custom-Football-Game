package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: android.support.transition.ka */
/* compiled from: ViewUtils */
class C0375ka {

    /* renamed from: a */
    private static final C0388qa f1245a;

    /* renamed from: b */
    private static Field f1246b;

    /* renamed from: c */
    private static boolean f1247c;

    /* renamed from: d */
    static final Property<View, Float> f1248d = new C0371ia(Float.class, "translationAlpha");

    /* renamed from: e */
    static final Property<View, Rect> f1249e = new C0373ja(Rect.class, "clipBounds");

    static {
        int i = VERSION.SDK_INT;
        if (i >= 22) {
            f1245a = new C0386pa();
        } else if (i >= 21) {
            f1245a = new C0383oa();
        } else if (i >= 19) {
            f1245a = new C0381na();
        } else if (i >= 18) {
            f1245a = new C0379ma();
        } else {
            f1245a = new C0377la();
        }
    }

    /* renamed from: b */
    static C0369ha m1935b(View view) {
        return f1245a.mo4861b(view);
    }

    /* renamed from: d */
    static C0401va m1938d(View view) {
        return f1245a.mo4865e(view);
    }

    /* renamed from: a */
    static void m1931a(View view, float alpha) {
        f1245a.mo4858a(view, alpha);
    }

    /* renamed from: c */
    static float m1937c(View view) {
        return f1245a.mo4864d(view);
    }

    /* renamed from: e */
    static void m1939e(View view) {
        f1245a.mo4857a(view);
    }

    /* renamed from: a */
    static void m1930a(View view) {
        f1245a.mo4863c(view);
    }

    /* renamed from: a */
    static void m1932a(View view, int visibility) {
        m1929a();
        Field field = f1246b;
        if (field != null) {
            try {
                f1246b.setInt(view, (field.getInt(view) & -13) | visibility);
            } catch (IllegalAccessException e) {
            }
        }
    }

    /* renamed from: a */
    static void m1934a(View view, Matrix matrix) {
        f1245a.mo4862b(view, matrix);
    }

    /* renamed from: b */
    static void m1936b(View view, Matrix matrix) {
        f1245a.mo4860a(view, matrix);
    }

    /* renamed from: a */
    static void m1933a(View v, int left, int top, int right, int bottom) {
        f1245a.mo4859a(v, left, top, right, bottom);
    }

    /* renamed from: a */
    private static void m1929a() {
        if (!f1247c) {
            try {
                f1246b = View.class.getDeclaredField("mViewFlags");
                f1246b.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            f1247c = true;
        }
    }
}
