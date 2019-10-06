package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

/* renamed from: com.flurry.sdk.xd */
public final class C7624xd {
    /* renamed from: a */
    public static int m16861a() {
        Point b = m16862b();
        int i = b.x;
        int i2 = b.y;
        if (i == i2) {
            return 3;
        }
        if (i < i2) {
            return 1;
        }
        return 2;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static Point m16862b() {
        Display defaultDisplay = ((WindowManager) C7379Fb.m16300a().f14432d.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Throwable th) {
                defaultDisplay.getSize(point);
            }
        }
        return point;
    }
}
