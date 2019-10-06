package p026rx.p400f;

import p026rx.Single;
import p026rx.Single.C0124a;
import p026rx.p027b.C14541q;
import p026rx.p390c.p391a.C14605Lb;
import p026rx.p390c.p391a.C14751xb;

/* renamed from: rx.f.m */
/* compiled from: RxJavaHooks */
class C14942m implements C14541q<Single, C0124a, C0124a> {
    C14942m() {
    }

    /* renamed from: a */
    public C0124a call(Single t1, C0124a t2) {
        C14955z hook = C14953x.m46727c().mo46165f();
        if (hook == C14929A.m46680a()) {
            return t2;
        }
        C14605Lb lb = new C14605Lb(t2);
        hook.mo46171a(t1, lb);
        return new C14751xb(lb);
    }
}
