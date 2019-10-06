package com.inmobi.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.p000v4.view.ViewPager;
import android.support.p000v4.view.ViewPager.C0597f;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

/* renamed from: com.inmobi.ads.bp */
/* compiled from: ScrollableDeckPagesContainer */
class C10464bp extends NativeScrollableContainer implements C0597f {

    /* renamed from: b */
    private static final String f31828b = C10464bp.class.getSimpleName();

    /* renamed from: a */
    C10326a f31829a;

    /* renamed from: c */
    private ViewPager f31830c;

    /* renamed from: d */
    private Point f31831d = new Point();

    /* renamed from: e */
    private Point f31832e = new Point();

    /* renamed from: f */
    private boolean f31833f;

    /* renamed from: g */
    private boolean f31834g = false;

    public C10464bp(Context context) {
        super(context, 0);
        setClipChildren(false);
        setLayerType(1, null);
        this.f31830c = new ViewPager(getContext());
        this.f31830c.addOnPageChangeListener(this);
        addView(this.f31830c);
    }

    /* renamed from: a */
    public final void mo33856a(C10402am amVar, C10434ax axVar, int i, int i2, C10326a aVar) {
        LayoutParams layoutParams = (LayoutParams) NativeViewFactory.m33742a(amVar.mo34098a(0), (ViewGroup) this);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(20);
            layoutParams.setMarginEnd(20);
        } else {
            layoutParams.setMargins(20, 0, 20, 0);
        }
        layoutParams.gravity = i2;
        this.f31830c.setLayoutParams(layoutParams);
        this.f31830c.setAdapter((C10409ap) axVar);
        this.f31830c.setOffscreenPageLimit(2);
        this.f31830c.setPageMargin(16);
        this.f31830c.setCurrentItem(i);
        this.f31829a = aVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Point point = this.f31831d;
        point.x = i / 2;
        point.y = i2 / 2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f31832e.x = (int) motionEvent.getX();
            this.f31832e.y = (int) motionEvent.getY();
        } else if (action == 1) {
            float f = (float) this.f31832e.x;
            float x = motionEvent.getX();
            int currentItem = this.f31830c.getCurrentItem();
            int count = this.f31830c.getAdapter().getCount();
            int width = this.f31830c.getWidth();
            int width2 = getWidth();
            int i = 0;
            if (currentItem == 0 || count - 1 == currentItem) {
                int i2 = width2 - width;
                if (currentItem == 0) {
                    float f2 = (float) i2;
                    if (f > f2 && x > f2) {
                        i = (int) Math.ceil((double) ((x - f2) / ((float) width)));
                    }
                } else {
                    float f3 = (float) i2;
                    if (f < f3 && x < f3) {
                        i = -((int) Math.ceil((double) ((f3 - x) / ((float) width))));
                    }
                }
            } else {
                float f4 = (float) ((width2 - width) / 2);
                if (f >= f4 || x >= f4) {
                    float f5 = (float) ((width2 + width) / 2);
                    if (f > f5 && x > f5) {
                        i = (int) Math.ceil((double) ((x - f5) / ((float) width)));
                    }
                } else {
                    i = -((int) Math.ceil((double) ((f4 - x) / ((float) width))));
                }
            }
            if (i != 0) {
                motionEvent.setAction(3);
                ViewPager viewPager = this.f31830c;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + i);
            }
            Point point = this.f31831d;
            int i3 = point.x;
            Point point2 = this.f31832e;
            motionEvent.offsetLocation((float) (i3 - point2.x), (float) (point.y - point2.y));
            return this.f31830c.dispatchTouchEvent(motionEvent);
        }
        Point point3 = this.f31831d;
        int i4 = point3.x;
        Point point4 = this.f31832e;
        motionEvent.offsetLocation((float) (i4 - point4.x), (float) (point3.y - point4.y));
        return this.f31830c.dispatchTouchEvent(motionEvent);
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f31833f) {
            invalidate();
        }
    }

    public void onPageSelected(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f31830c.getLayoutParams();
        C10326a aVar = this.f31829a;
        if (aVar != null) {
            layoutParams.gravity = aVar.mo33858a(i);
            this.f31830c.requestLayout();
        }
    }

    public void onPageScrollStateChanged(int i) {
        this.f31833f = i != 0;
    }
}
