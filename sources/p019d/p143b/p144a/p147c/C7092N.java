package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.N */
class C7092N implements C7254d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7254d f13310a;

    /* renamed from: b */
    final /* synthetic */ C7080K f13311b;

    C7092N(C7080K k, C7254d dVar) {
        this.f13311b = k;
        this.f13310a = dVar;
    }

    public void adReceived(C7251a aVar) {
        this.f13311b.f13261c = aVar;
        if (this.f13310a != null) {
            C7269s.m15816a((Runnable) new C7096O(this, aVar));
        }
    }

    public void failedToReceiveAd(int i) {
        if (this.f13310a != null) {
            C7269s.m15816a((Runnable) new C7100P(this, i));
        }
    }
}
