package com.smaato.soma.p256e;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.smaato.soma.e.E */
/* compiled from: Views */
public class C12330E {
    /* renamed from: a */
    public static void m40539a(View view) {
        if (!(view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup))) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
