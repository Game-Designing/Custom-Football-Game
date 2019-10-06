package com.mopub.common;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: com.mopub.common.L */
/* compiled from: VisibilityTracker */
class C11236L implements OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ VisibilityTracker f34332a;

    C11236L(VisibilityTracker this$0) {
        this.f34332a = this$0;
    }

    public boolean onPreDraw() {
        this.f34332a.scheduleVisibilityCheck();
        return true;
    }
}
