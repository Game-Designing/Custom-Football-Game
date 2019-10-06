package android.support.p000v4.view;

import android.graphics.Rect;
import android.view.View;

/* renamed from: android.support.v4.view.D */
/* compiled from: ViewPager */
class C0579D implements C0641r {

    /* renamed from: a */
    private final Rect f1794a = new Rect();

    /* renamed from: b */
    final /* synthetic */ ViewPager f1795b;

    C0579D(ViewPager this$0) {
        this.f1795b = this$0;
    }

    /* renamed from: a */
    public C0592M mo4252a(View v, C0592M originalInsets) {
        C0592M applied = C0646w.m2963b(v, originalInsets);
        if (applied.mo5491f()) {
            return applied;
        }
        Rect res = this.f1794a;
        res.left = applied.mo5487c();
        res.top = applied.mo5489e();
        res.right = applied.mo5488d();
        res.bottom = applied.mo5486b();
        int count = this.f1795b.getChildCount();
        for (int i = 0; i < count; i++) {
            C0592M childInsets = C0646w.m2946a(this.f1795b.getChildAt(i), applied);
            res.left = Math.min(childInsets.mo5487c(), res.left);
            res.top = Math.min(childInsets.mo5489e(), res.top);
            res.right = Math.min(childInsets.mo5488d(), res.right);
            res.bottom = Math.min(childInsets.mo5486b(), res.bottom);
        }
        return applied.mo5485a(res.left, res.top, res.right, res.bottom);
    }
}
