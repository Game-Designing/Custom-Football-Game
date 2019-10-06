package com.astuetz;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.astuetz.a */
/* compiled from: PagerSlidingTabStrip */
class C5892a implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f10273a;

    /* renamed from: b */
    final /* synthetic */ PagerSlidingTabStrip f10274b;

    C5892a(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.f10274b = pagerSlidingTabStrip;
        this.f10273a = i;
    }

    public void onClick(View v) {
        if (this.f10274b.f10250h.getCurrentItem() != this.f10273a) {
            this.f10274b.m10718b(this.f10274b.f10244b.getChildAt(this.f10274b.f10250h.getCurrentItem()));
            this.f10274b.f10250h.setCurrentItem(this.f10273a);
        } else if (this.f10274b.f10248f != null) {
            this.f10274b.f10248f.mo18419a(this.f10273a);
        }
    }
}
