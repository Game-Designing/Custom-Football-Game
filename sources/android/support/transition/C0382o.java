package android.support.transition;

import android.support.transition.C0334M.C0337c;
import android.view.ViewGroup;

/* renamed from: android.support.transition.o */
/* compiled from: ChangeBounds */
class C0382o extends C0338N {

    /* renamed from: a */
    boolean f1264a = false;

    /* renamed from: b */
    final /* synthetic */ ViewGroup f1265b;

    /* renamed from: c */
    final /* synthetic */ C0384p f1266c;

    C0382o(C0384p this$0, ViewGroup viewGroup) {
        this.f1266c = this$0;
        this.f1265b = viewGroup;
    }

    /* renamed from: d */
    public void mo4787d(C0334M transition) {
        if (!this.f1264a) {
            C0353aa.m1882a(this.f1265b, false);
        }
        transition.mo4764b((C0337c) this);
    }

    /* renamed from: b */
    public void mo4785b(C0334M transition) {
        C0353aa.m1882a(this.f1265b, false);
    }

    /* renamed from: a */
    public void mo4784a(C0334M transition) {
        C0353aa.m1882a(this.f1265b, true);
    }
}
