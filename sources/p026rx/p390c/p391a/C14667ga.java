package p026rx.p390c.p391a;

import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p390c.p392b.C14772c;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.a.ga */
/* compiled from: OperatorAny */
class C14667ga extends C14980ia<T> {

    /* renamed from: a */
    boolean f43660a;

    /* renamed from: b */
    boolean f43661b;

    /* renamed from: c */
    final /* synthetic */ C14772c f43662c;

    /* renamed from: d */
    final /* synthetic */ C14980ia f43663d;

    /* renamed from: e */
    final /* synthetic */ C14670ha f43664e;

    C14667ga(C14670ha haVar, C14772c cVar, C14980ia iaVar) {
        this.f43664e = haVar;
        this.f43662c = cVar;
        this.f43663d = iaVar;
    }

    public void onNext(T t) {
        if (!this.f43661b) {
            this.f43660a = true;
            try {
                if (((Boolean) this.f43664e.f43673a.call(t)).booleanValue()) {
                    this.f43661b = true;
                    this.f43662c.mo45916a(Boolean.valueOf(true ^ this.f43664e.f43674b));
                    unsubscribe();
                }
            } catch (Throwable e) {
                C14927a.m46673a(e, (C0125T<?>) this, (Object) t);
            }
        }
    }

    public void onError(Throwable e) {
        if (!this.f43661b) {
            this.f43661b = true;
            this.f43663d.onError(e);
            return;
        }
        C14948s.m46719b(e);
    }

    public void onCompleted() {
        if (!this.f43661b) {
            this.f43661b = true;
            if (this.f43660a) {
                this.f43662c.mo45916a(Boolean.valueOf(false));
            } else {
                this.f43662c.mo45916a(Boolean.valueOf(this.f43664e.f43674b));
            }
        }
    }
}
