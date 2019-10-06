package p019d.p151c.p152a.p153a;

import android.app.Activity;
import android.util.TypedValue;

/* renamed from: d.c.a.a.b */
/* compiled from: ColorUtils */
public class C7272b {
    /* renamed from: a */
    public static int m15830a(Activity activity, String attr, int fallbackColor) {
        TypedValue color = new TypedValue();
        try {
            if (activity.getTheme().resolveAttribute(activity.getResources().getIdentifier(attr, "attr", activity.getPackageName()), color, true)) {
                return color.data;
            }
        } catch (Exception e) {
        }
        return activity.getResources().getColor(fallbackColor);
    }
}
