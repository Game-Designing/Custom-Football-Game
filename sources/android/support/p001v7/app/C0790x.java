package android.support.p001v7.app;

import android.support.p000v4.view.C0592M;
import android.support.p000v4.view.C0641r;
import android.support.p000v4.view.C0646w;
import android.view.View;

/* renamed from: android.support.v7.app.x */
/* compiled from: AppCompatDelegateImplV9 */
class C0790x implements C0641r {

    /* renamed from: a */
    final /* synthetic */ C0737D f2379a;

    C0790x(C0737D this$0) {
        this.f2379a = this$0;
    }

    /* renamed from: a */
    public C0592M mo4252a(View v, C0592M insets) {
        int top = insets.mo5489e();
        int newTop = this.f2379a.mo6104f(top);
        if (top != newTop) {
            insets = insets.mo5485a(insets.mo5487c(), newTop, insets.mo5488d(), insets.mo5486b());
        }
        return C0646w.m2963b(v, insets);
    }
}
