package com.astuetz;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: com.astuetz.b */
/* compiled from: PagerSlidingTabStrip */
class C5897b implements OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ PagerSlidingTabStrip f10276a;

    C5897b(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.f10276a = pagerSlidingTabStrip;
    }

    public void onGlobalLayout() {
        View view = this.f10276a.f10244b.getChildAt(0);
        if (VERSION.SDK_INT < 16) {
            m10741b();
        } else {
            m10740a();
        }
        if (this.f10276a.f10236B) {
            int mHalfWidthFirstTab = view.getWidth() / 2;
            PagerSlidingTabStrip pagerSlidingTabStrip = this.f10276a;
            int width = (pagerSlidingTabStrip.getWidth() / 2) - mHalfWidthFirstTab;
            pagerSlidingTabStrip.f10267y = width;
            pagerSlidingTabStrip.f10266x = width;
        }
        PagerSlidingTabStrip pagerSlidingTabStrip2 = this.f10276a;
        pagerSlidingTabStrip2.setPadding(pagerSlidingTabStrip2.f10266x, this.f10276a.getPaddingTop(), this.f10276a.f10267y, this.f10276a.getPaddingBottom());
        if (this.f10276a.f10240F == 0) {
            PagerSlidingTabStrip pagerSlidingTabStrip3 = this.f10276a;
            pagerSlidingTabStrip3.f10240F = (pagerSlidingTabStrip3.getWidth() / 2) - this.f10276a.f10266x;
        }
        PagerSlidingTabStrip pagerSlidingTabStrip4 = this.f10276a;
        pagerSlidingTabStrip4.f10252j = pagerSlidingTabStrip4.f10250h.getCurrentItem();
        this.f10276a.f10253k = 0.0f;
        PagerSlidingTabStrip pagerSlidingTabStrip5 = this.f10276a;
        pagerSlidingTabStrip5.m10710a(pagerSlidingTabStrip5.f10252j, 0);
        PagerSlidingTabStrip pagerSlidingTabStrip6 = this.f10276a;
        pagerSlidingTabStrip6.m10717b(pagerSlidingTabStrip6.f10252j);
    }

    /* renamed from: b */
    private void m10741b() {
        this.f10276a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    @TargetApi(16)
    /* renamed from: a */
    private void m10740a() {
        this.f10276a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
