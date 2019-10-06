package android.support.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.oa */
/* compiled from: ViewUtilsApi21 */
class C0383oa extends C0381na {

    /* renamed from: e */
    private static Method f1267e;

    /* renamed from: f */
    private static boolean f1268f;

    /* renamed from: g */
    private static Method f1269g;

    /* renamed from: h */
    private static boolean f1270h;

    C0383oa() {
    }

    /* renamed from: b */
    public void mo4862b(View view, Matrix matrix) {
        m1962c();
        Method method = f1267e;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    /* renamed from: a */
    public void mo4860a(View view, Matrix matrix) {
        m1963d();
        Method method = f1269g;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    /* renamed from: c */
    private void m1962c() {
        if (!f1268f) {
            try {
                f1267e = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                f1267e.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
            }
            f1268f = true;
        }
    }

    /* renamed from: d */
    private void m1963d() {
        if (!f1270h) {
            try {
                f1269g = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                f1269g.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
            }
            f1270h = true;
        }
    }
}
