package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: android.support.design.widget.F */
/* compiled from: DrawableUtils */
class C0244F {

    /* renamed from: a */
    private static Method f947a;

    /* renamed from: b */
    private static boolean f948b;

    /* renamed from: a */
    static boolean m1506a(DrawableContainer drawable, ConstantState constantState) {
        return m1507b(drawable, constantState);
    }

    /* renamed from: b */
    private static boolean m1507b(DrawableContainer drawable, ConstantState constantState) {
        String str = "DrawableUtils";
        if (!f948b) {
            try {
                f947a = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                f947a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.e(str, "Could not fetch setConstantState(). Oh well.");
            }
            f948b = true;
        }
        Method method = f947a;
        if (method != null) {
            try {
                method.invoke(drawable, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
                Log.e(str, "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }
}
