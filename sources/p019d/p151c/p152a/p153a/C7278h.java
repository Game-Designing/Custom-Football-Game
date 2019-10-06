package p019d.p151c.p152a.p153a;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import p019d.p151c.p152a.C7282e;

/* renamed from: d.c.a.a.h */
/* compiled from: ViewUtils */
public class C7278h {
    /* renamed from: a */
    public static boolean m15847a(Activity activity) {
        int color = activity.getResources().getColor(C7282e.bt_white);
        try {
            Drawable background = activity.getWindow().getDecorView().getRootView().getBackground();
            if (background instanceof ColorDrawable) {
                color = ((ColorDrawable) background).getColor();
            }
        } catch (Exception e) {
        }
        double red = (double) Color.red(color);
        Double.isNaN(red);
        double d = red * 0.2126d;
        double green = (double) Color.green(color);
        Double.isNaN(green);
        double d2 = d + (green * 0.7152d);
        double blue = (double) Color.blue(color);
        Double.isNaN(blue);
        return d2 + (blue * 0.0722d) < 128.0d;
    }
}
