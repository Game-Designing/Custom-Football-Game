package android.support.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.na */
/* compiled from: ViewUtilsApi19 */
class C0381na extends C0379ma {

    /* renamed from: a */
    private static Method f1260a;

    /* renamed from: b */
    private static boolean f1261b;

    /* renamed from: c */
    private static Method f1262c;

    /* renamed from: d */
    private static boolean f1263d;

    C0381na() {
    }

    /* renamed from: a */
    public void mo4858a(View view, float alpha) {
        m1954b();
        Method method = f1260a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Float.valueOf(alpha)});
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            view.setAlpha(alpha);
        }
    }

    /* renamed from: d */
    public float mo4864d(View view) {
        m1953a();
        Method method = f1262c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.mo4864d(view);
    }

    /* renamed from: a */
    public void mo4857a(View view) {
    }

    /* renamed from: c */
    public void mo4863c(View view) {
    }

    /* renamed from: b */
    private void m1954b() {
        if (!f1261b) {
            try {
                f1260a = View.class.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                f1260a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
            }
            f1261b = true;
        }
    }

    /* renamed from: a */
    private void m1953a() {
        if (!f1263d) {
            try {
                f1262c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                f1262c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
            }
            f1263d = true;
        }
    }
}
