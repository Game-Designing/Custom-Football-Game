package android.support.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.da */
/* compiled from: ViewGroupUtilsApi18 */
class C0360da extends C0358ca {

    /* renamed from: f */
    private static Method f1230f;

    /* renamed from: g */
    private static boolean f1231g;

    C0360da() {
    }

    /* renamed from: a */
    public C0351Z mo4811a(ViewGroup group) {
        return new C0350Y(group);
    }

    /* renamed from: a */
    public void mo4812a(ViewGroup group, boolean suppress) {
        String str = "ViewUtilsApi18";
        m1895a();
        Method method = f1230f;
        if (method != null) {
            try {
                method.invoke(group, new Object[]{Boolean.valueOf(suppress)});
            } catch (IllegalAccessException e) {
                Log.i(str, "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i(str, "Error invoking suppressLayout method", e2);
            }
        }
    }

    /* renamed from: a */
    private void m1895a() {
        if (!f1231g) {
            try {
                f1230f = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                f1230f.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
            }
            f1231g = true;
        }
    }
}
