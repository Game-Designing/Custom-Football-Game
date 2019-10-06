package com.inmobi.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.inmobi.ads.C10598t.C10599a;
import com.mopub.volley.BuildConfig;

public class GifView extends ImageView implements C10599a {

    /* renamed from: a */
    private C10598t f31250a;

    /* renamed from: b */
    private float f31251b;

    /* renamed from: c */
    private boolean f31252c;

    /* renamed from: d */
    private String f31253d;

    public GifView(Context context) {
        this(context, null);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f31251b = -1.0f;
        this.f31252c = true;
        this.f31253d = BuildConfig.VERSION_NAME;
        setLayerType(1, null);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31251b = -1.0f;
        this.f31252c = true;
        this.f31253d = BuildConfig.VERSION_NAME;
        setLayerType(1, null);
    }

    public void setPaused(boolean z) {
        this.f31250a.mo34339a(z);
    }

    public void setGif(C10598t tVar) {
        this.f31250a = tVar;
        C10598t tVar2 = this.f31250a;
        if (tVar2 != null) {
            tVar2.mo34338a((C10599a) this);
            this.f31250a.mo34336a();
        }
        requestLayout();
    }

    public void setContentMode(String str) {
        this.f31253d = str;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f31251b = getScale();
        Drawable drawable = getDrawable();
        int i3 = 0;
        int i4 = 1;
        if (drawable != null) {
            i3 = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (i3 <= 0) {
                i3 = 1;
            }
            if (intrinsicHeight > 0) {
                i4 = intrinsicHeight;
            }
        } else {
            C10598t tVar = this.f31250a;
            if (tVar != null) {
                int b = tVar.mo34340b();
                int c = this.f31250a.mo34341c();
                if (b <= 0) {
                    b = 1;
                }
                if (c <= 0) {
                    i3 = b;
                } else {
                    i4 = c;
                    i3 = b;
                }
            } else {
                i4 = 0;
            }
        }
        int paddingTop = i4 + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ImageView.resolveSize(Math.max(i3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i), ImageView.resolveSize(Math.max(paddingTop, getSuggestedMinimumHeight()), i2));
    }

    private int getDensity() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (!(getContext() instanceof Activity)) {
            return 240;
        }
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    private float getScale() {
        this.f31251b = ((float) getContext().getResources().getDisplayMetrics().densityDpi) / ((float) getDensity());
        if (this.f31251b < 0.1f) {
            this.f31251b = 0.1f;
        }
        if (this.f31251b > 5.0f) {
            this.f31251b = 5.0f;
        }
        return this.f31251b;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f31252c = getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        C10598t tVar = this.f31250a;
        if (tVar != null) {
            if (tVar.mo34342d()) {
                this.f31250a.mo34343e();
                m33592a(canvas);
                m33593b();
                return;
            }
            m33592a(canvas);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0080  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m33592a(android.graphics.Canvas r10) {
        /*
            r9 = this;
            r10.save()
            float r0 = r9.f31251b
            r10.scale(r0, r0)
            int r0 = r9.getWidth()
            float r0 = (float) r0
            int r1 = r9.getHeight()
            float r1 = (float) r1
            com.inmobi.ads.t r2 = r9.f31250a
            int r2 = r2.mo34340b()
            float r2 = (float) r2
            float r3 = r9.f31251b
            float r2 = r2 * r3
            com.inmobi.ads.t r3 = r9.f31250a
            int r3 = r3.mo34341c()
            float r3 = (float) r3
            float r4 = r9.f31251b
            float r3 = r3 * r4
            java.lang.String r4 = r9.f31253d
            int r5 = r4.hashCode()
            r6 = -1362001767(0xffffffffaed18099, float:-9.527063E-11)
            r7 = 0
            r8 = 1
            if (r5 == r6) goto L_0x0046
            r6 = 727618043(0x2b5e91fb, float:7.907283E-13)
            if (r5 == r6) goto L_0x003c
        L_0x003b:
            goto L_0x0050
        L_0x003c:
            java.lang.String r5 = "aspectFill"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x003b
            r4 = 0
            goto L_0x0051
        L_0x0046:
            java.lang.String r5 = "aspectFit"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x003b
            r4 = 1
            goto L_0x0051
        L_0x0050:
            r4 = -1
        L_0x0051:
            r5 = 0
            r6 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L_0x0080
            if (r4 == r8) goto L_0x0062
            float r0 = r0 / r2
            float r1 = r1 / r3
            r10.scale(r0, r1)
            r4 = r1
            r0 = 0
            goto L_0x009e
        L_0x0062:
            float r4 = r0 / r2
            float r5 = r1 / r3
            float r4 = java.lang.Math.min(r4, r5)
            float r2 = r2 * r4
            float r0 = r0 - r2
            float r0 = r0 / r6
            float r2 = r9.f31251b
            float r5 = r4 * r2
            float r5 = r0 / r5
            float r3 = r3 * r4
            float r1 = r1 - r3
            float r1 = r1 / r6
            float r2 = r2 * r4
            float r0 = r1 / r2
            r10.scale(r4, r4)
            goto L_0x009e
        L_0x0080:
            float r4 = r0 / r2
            float r5 = r1 / r3
            float r4 = java.lang.Math.max(r4, r5)
            float r2 = r2 * r4
            float r0 = r0 - r2
            float r0 = r0 / r6
            float r2 = r9.f31251b
            float r5 = r4 * r2
            float r5 = r0 / r5
            float r3 = r3 * r4
            float r1 = r1 - r3
            float r1 = r1 / r6
            float r2 = r2 * r4
            float r0 = r1 / r2
            r10.scale(r4, r4)
        L_0x009e:
            r1 = 3
            float[] r1 = new float[r1]
            r1[r7] = r5
            r1[r8] = r0
            r0 = 2
            r1[r0] = r4
            com.inmobi.ads.t r0 = r9.f31250a
            r2 = r1[r7]
            r1 = r1[r8]
            r0.mo34337a(r10, r2, r1)
            r10.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.GifView.m33592a(android.graphics.Canvas):void");
    }

    /* renamed from: b */
    private void m33593b() {
        if (this.f31252c) {
            if (VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
                return;
            }
            invalidate();
        }
    }

    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.f31252c = z;
        m33593b();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.f31252c = i == 0;
        m33593b();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f31252c = i == 0;
        m33593b();
    }

    /* renamed from: a */
    public final void mo33695a() {
        invalidate();
    }
}
