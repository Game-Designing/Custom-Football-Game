package p019d.p135a.p136a.p138b;

import p019d.p135a.p136a.p137a.C6848d;
import p320f.p321a.C13799o;

/* renamed from: d.a.a.b.b */
/* compiled from: ModuleAvailabilityUtil */
class C6857b implements C6848d {

    /* renamed from: a */
    final /* synthetic */ C13799o f12564a;

    /* renamed from: b */
    final /* synthetic */ C6858c f12565b;

    C6857b(C6858c this$1, C13799o oVar) {
        this.f12565b = this$1;
        this.f12564a = oVar;
    }

    /* renamed from: a */
    public void mo22281a(boolean isAvailable) {
        if (!this.f12564a.mo42373a() && isAvailable) {
            this.f12564a.onNext(this.f12565b.f12566a);
        }
        this.f12564a.onComplete();
    }
}
