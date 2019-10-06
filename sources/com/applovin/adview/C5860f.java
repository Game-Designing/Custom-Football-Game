package com.applovin.adview;

import android.content.Context;
import android.view.View;
import p019d.p143b.p144a.p146b.C6992c;
import p019d.p143b.p150d.C7267q;

/* renamed from: com.applovin.adview.f */
public class C5860f extends View {
    /* renamed from: a */
    public static C5861g m10676a(C7267q qVar, Context context) {
        if (qVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            return new C6992c().mo18326a(qVar, context);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }
}
