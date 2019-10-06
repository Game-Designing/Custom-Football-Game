package com.applovin.adview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

/* renamed from: com.applovin.adview.h */
public class C5862h implements OnTouchListener {

    /* renamed from: a */
    private long f10200a;

    /* renamed from: b */
    private float f10201b;

    /* renamed from: c */
    private float f10202c;

    /* renamed from: d */
    private Context f10203d;

    /* renamed from: e */
    private OnClickListener f10204e;

    public C5862h(Context context, OnClickListener onClickListener) {
        this.f10203d = context;
        this.f10204e = onClickListener;
    }

    /* renamed from: a */
    private float m10682a(float f) {
        return f / this.f10203d.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    private float m10683a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return m10682a((float) Math.sqrt((double) ((f5 * f5) + (f6 * f6))));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f10200a = System.currentTimeMillis();
            this.f10201b = motionEvent.getX();
            this.f10202c = motionEvent.getY();
        } else if (action == 1 && System.currentTimeMillis() - this.f10200a < 1000 && m10683a(this.f10201b, this.f10202c, motionEvent.getX(), motionEvent.getY()) < 10.0f) {
            this.f10204e.onClick(view);
        }
        return true;
    }
}
