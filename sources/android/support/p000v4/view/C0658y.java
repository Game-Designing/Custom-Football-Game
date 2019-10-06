package android.support.p000v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.view.y */
/* compiled from: ViewConfigurationCompat */
public final class C0658y {

    /* renamed from: a */
    private static Method f1874a;

    static {
        if (VERSION.SDK_INT == 25) {
            try {
                f1874a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception e) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    /* renamed from: a */
    public static float m3093a(ViewConfiguration config, Context context) {
        if (VERSION.SDK_INT >= 26) {
            return config.getScaledHorizontalScrollFactor();
        }
        return m3095c(config, context);
    }

    /* renamed from: b */
    public static float m3094b(ViewConfiguration config, Context context) {
        if (VERSION.SDK_INT >= 26) {
            return config.getScaledVerticalScrollFactor();
        }
        return m3095c(config, context);
    }

    /* renamed from: c */
    private static float m3095c(ViewConfiguration config, Context context) {
        if (VERSION.SDK_INT >= 25) {
            Method method = f1874a;
            if (method != null) {
                try {
                    return (float) ((Integer) method.invoke(config, new Object[0])).intValue();
                } catch (Exception e) {
                    Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
                }
            }
        }
        TypedValue outValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, outValue, true)) {
            return outValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }
}
