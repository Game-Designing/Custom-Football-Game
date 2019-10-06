package android.support.p001v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0646w;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.Ib */
/* compiled from: ViewUtils */
public class C0946Ib {

    /* renamed from: a */
    private static Method f3017a;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f3017a = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                if (!f3017a.isAccessible()) {
                    f3017a.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    /* renamed from: a */
    public static boolean m4565a(View view) {
        return C0646w.m2974h(view) == 1;
    }

    /* renamed from: a */
    public static void m4564a(View view, Rect inoutInsets, Rect outLocalInsets) {
        Method method = f3017a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{inoutInsets, outLocalInsets});
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    /* renamed from: b */
    public static void m4566b(View view) {
        String str = "Could not invoke makeOptionalFitsSystemWindows";
        String str2 = "ViewUtils";
        if (VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (NoSuchMethodException e) {
                Log.d(str2, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (InvocationTargetException e2) {
                Log.d(str2, str, e2);
            } catch (IllegalAccessException e3) {
                Log.d(str2, str, e3);
            }
        }
    }
}
