package com.smaato.soma.p239c.p252i;

import android.util.Log;
import android.view.View;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.c.i.c */
/* compiled from: Controller */
public class C12277c {

    /* renamed from: a */
    private static C12277c f38429a;

    /* renamed from: b */
    private static int f38430b = 0;

    /* renamed from: c */
    private static boolean f38431c = false;

    private C12277c() {
    }

    /* renamed from: a */
    public static C12277c m40409a() {
        if (f38429a == null) {
            f38429a = new C12277c();
        }
        return f38429a;
    }

    /* renamed from: c */
    public void mo39667c() {
        f38430b++;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(getClass().getCanonicalName());
        C12146d.m39965a(new C12147e(sb.toString(), "Something went wrong !!", 1, C12143a.DEBUG));
        if (f38430b >= 10) {
            m40410a(true);
        }
    }

    /* renamed from: d */
    public void mo39668d() {
        Log.e("", "INIT SUCCESS");
        f38430b = 0;
        m40410a(false);
    }

    /* renamed from: b */
    public boolean mo39666b() {
        return f38431c;
    }

    /* renamed from: a */
    private void m40410a(boolean shouldInit) {
        f38431c = shouldInit;
    }

    /* renamed from: a */
    public boolean mo39665a(View view, float x, float y) {
        return ((Boolean) new C12276b(this, x, view, y).execute()).booleanValue();
    }
}
