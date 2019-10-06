package android.support.transition;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.pa */
/* compiled from: ViewUtilsApi22 */
class C0386pa extends C0383oa {

    /* renamed from: i */
    private static Method f1289i;

    /* renamed from: j */
    private static boolean f1290j;

    C0386pa() {
    }

    /* renamed from: a */
    public void mo4859a(View v, int left, int top, int right, int bottom) {
        m1975e();
        Method method = f1289i;
        if (method != null) {
            try {
                method.invoke(v, new Object[]{Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom)});
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: e */
    private void m1975e() {
        if (!f1290j) {
            try {
                f1289i = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                f1289i.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
            }
            f1290j = true;
        }
    }
}
