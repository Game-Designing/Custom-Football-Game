package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: com.applovin.adview.i */
public class C5863i extends RelativeLayout {
    public C5863i(Context context, C7267q qVar) {
        super(context, null, new C7212tb(qVar).mo23289c());
        m10684a(context, qVar);
    }

    /* renamed from: a */
    private void m10684a(Context context, C7267q qVar) {
        LayoutParams layoutParams;
        C7212tb tbVar = new C7212tb(qVar);
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        int b = tbVar.mo23287b();
        if (b == -2 || b == -1) {
            layoutParams = new LayoutParams(b, b);
        } else {
            int a = C7269s.m15812a(context, b);
            layoutParams = new LayoutParams(a, a);
        }
        layoutParams.addRule(13);
        progressBar.setLayoutParams(layoutParams);
        setBackgroundColor(Color.parseColor(tbVar.mo23285a()));
        addView(progressBar);
    }
}
