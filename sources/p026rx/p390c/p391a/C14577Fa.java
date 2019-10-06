package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C0125T;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p029i.C14977e;
import p026rx.p390c.p392b.C14771b;
import p026rx.p400f.C14948s;
import rx.Subscriber;

/* renamed from: rx.c.a.Fa */
/* compiled from: OperatorOnErrorResumeNextViaFunction */
class C14577Fa extends C14980ia<T> {

    /* renamed from: a */
    private boolean f43427a;

    /* renamed from: b */
    long f43428b;

    /* renamed from: c */
    final /* synthetic */ C14980ia f43429c;

    /* renamed from: d */
    final /* synthetic */ C14771b f43430d;

    /* renamed from: e */
    final /* synthetic */ C14977e f43431e;

    /* renamed from: f */
    final /* synthetic */ C14581Ga f43432f;

    C14577Fa(C14581Ga ga, C14980ia iaVar, C14771b bVar, C14977e eVar) {
        this.f43432f = ga;
        this.f43429c = iaVar;
        this.f43430d = bVar;
        this.f43431e = eVar;
    }

    public void onCompleted() {
        if (!this.f43427a) {
            this.f43427a = true;
            this.f43429c.onCompleted();
        }
    }

    public void onError(Throwable e) {
        if (this.f43427a) {
            C14927a.m46678c(e);
            C14948s.m46719b(e);
            return;
        }
        this.f43427a = true;
        try {
            unsubscribe();
            Subscriber<T> next = new C14573Ea<>(this);
            this.f43431e.mo46198a(next);
            long p = this.f43428b;
            if (p != 0) {
                this.f43430d.mo45914a(p);
            }
            ((C0120S) this.f43432f.f43440a.call(e)).mo3640b((C14980ia<? super T>) next);
        } catch (Throwable e2) {
            C14927a.m46672a(e2, (C0125T<?>) this.f43429c);
        }
    }

    public void onNext(T t) {
        if (!this.f43427a) {
            this.f43428b++;
            this.f43429c.onNext(t);
        }
    }

    public void setProducer(C14508U producer) {
        this.f43430d.mo45915a(producer);
    }
}
