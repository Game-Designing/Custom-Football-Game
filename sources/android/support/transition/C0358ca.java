package android.support.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.ca */
/* compiled from: ViewGroupUtilsApi14 */
class C0358ca implements C0362ea {

    /* renamed from: a */
    private static LayoutTransition f1225a;

    /* renamed from: b */
    private static Field f1226b;

    /* renamed from: c */
    private static boolean f1227c;

    /* renamed from: d */
    private static Method f1228d;

    /* renamed from: e */
    private static boolean f1229e;

    C0358ca() {
    }

    /* renamed from: a */
    public C0351Z mo4811a(ViewGroup group) {
        return C0349X.m1869a(group);
    }

    /* renamed from: a */
    public void mo4812a(ViewGroup group, boolean suppress) {
        if (f1225a == null) {
            f1225a = new C0356ba(this);
            f1225a.setAnimator(2, null);
            f1225a.setAnimator(0, null);
            f1225a.setAnimator(1, null);
            f1225a.setAnimator(3, null);
            f1225a.setAnimator(4, null);
        }
        if (suppress) {
            LayoutTransition layoutTransition = group.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    m1889a(layoutTransition);
                }
                if (layoutTransition != f1225a) {
                    group.setTag(C0328G.transition_layout_save, layoutTransition);
                }
            }
            group.setLayoutTransition(f1225a);
            return;
        }
        group.setLayoutTransition(null);
        String str = "ViewGroupUtilsApi14";
        if (!f1227c) {
            try {
                f1226b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f1226b.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i(str, "Failed to access mLayoutSuppressed field by reflection");
            }
            f1227c = true;
        }
        boolean layoutSuppressed = false;
        Field field = f1226b;
        if (field != null) {
            try {
                layoutSuppressed = field.getBoolean(group);
                if (layoutSuppressed) {
                    f1226b.setBoolean(group, false);
                }
            } catch (IllegalAccessException e2) {
                Log.i(str, "Failed to get mLayoutSuppressed field by reflection");
            }
        }
        if (layoutSuppressed) {
            group.requestLayout();
        }
        LayoutTransition layoutTransition2 = (LayoutTransition) group.getTag(C0328G.transition_layout_save);
        if (layoutTransition2 != null) {
            group.setTag(C0328G.transition_layout_save, null);
            group.setLayoutTransition(layoutTransition2);
        }
    }

    /* renamed from: a */
    private static void m1889a(LayoutTransition t) {
        String str = "Failed to access cancel method by reflection";
        String str2 = "ViewGroupUtilsApi14";
        if (!f1229e) {
            try {
                f1228d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f1228d.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(str2, str);
            }
            f1229e = true;
        }
        Method method = f1228d;
        if (method != null) {
            try {
                method.invoke(t, new Object[0]);
            } catch (IllegalAccessException e2) {
                Log.i(str2, str);
            } catch (InvocationTargetException e3) {
                Log.i(str2, "Failed to invoke cancel method by reflection");
            }
        }
    }
}
