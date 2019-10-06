package p026rx.p390c.p391a;

import p026rx.C14508U;
import p026rx.C14980ia;

/* renamed from: rx.c.a.Va */
/* compiled from: OperatorTake */
class C14629Va extends C14980ia<T> {

    /* renamed from: a */
    int f43572a;

    /* renamed from: b */
    boolean f43573b;

    /* renamed from: c */
    final /* synthetic */ C14980ia f43574c;

    /* renamed from: d */
    final /* synthetic */ C14631Wa f43575d;

    C14629Va(C14631Wa wa, C14980ia iaVar) {
        this.f43575d = wa;
        this.f43574c = iaVar;
    }

    public void onCompleted() {
        if (!this.f43573b) {
            this.f43573b = true;
            this.f43574c.onCompleted();
        }
    }

    public void onError(Throwable e) {
        if (!this.f43573b) {
            this.f43573b = true;
            try {
                this.f43574c.onError(e);
            } finally {
                unsubscribe();
            }
        }
    }

    public void onNext(T i) {
        if (!isUnsubscribed()) {
            int i2 = this.f43572a;
            this.f43572a = i2 + 1;
            int i3 = this.f43575d.f43580a;
            if (i2 < i3) {
                boolean stop = this.f43572a == i3;
                this.f43574c.onNext(i);
                if (stop && !this.f43573b) {
                    this.f43573b = true;
                    try {
                        this.f43574c.onCompleted();
                    } finally {
                        unsubscribe();
                    }
                }
            }
        }
    }

    public void setProducer(C14508U producer) {
        this.f43574c.setProducer(new C14627Ua(this, producer));
    }
}
