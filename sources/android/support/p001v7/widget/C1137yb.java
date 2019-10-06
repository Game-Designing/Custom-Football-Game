package android.support.p001v7.widget;

import android.support.p000v4.view.C0590K;
import android.view.View;

/* renamed from: android.support.v7.widget.yb */
/* compiled from: ToolbarWidgetWrapper */
class C1137yb extends C0590K {

    /* renamed from: a */
    private boolean f3768a = false;

    /* renamed from: b */
    final /* synthetic */ int f3769b;

    /* renamed from: c */
    final /* synthetic */ C1140zb f3770c;

    C1137yb(C1140zb this$0, int i) {
        this.f3770c = this$0;
        this.f3769b = i;
    }

    public void onAnimationStart(View view) {
        this.f3770c.f3773a.setVisibility(0);
    }

    public void onAnimationEnd(View view) {
        if (!this.f3768a) {
            this.f3770c.f3773a.setVisibility(this.f3769b);
        }
    }

    public void onAnimationCancel(View view) {
        this.f3768a = true;
    }
}
