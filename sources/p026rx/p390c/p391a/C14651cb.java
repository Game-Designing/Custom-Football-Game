package p026rx.p390c.p391a;

import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C14541q;

/* renamed from: rx.c.a.cb */
/* compiled from: OperatorTakeWhile */
class C14651cb extends C14980ia<T> {

    /* renamed from: a */
    private int f43620a;

    /* renamed from: b */
    private boolean f43621b;

    /* renamed from: c */
    final /* synthetic */ C14980ia f43622c;

    /* renamed from: d */
    final /* synthetic */ C14656db f43623d;

    C14651cb(C14656db dbVar, C14980ia x0, boolean x1, C14980ia iaVar) {
        this.f43623d = dbVar;
        this.f43622c = iaVar;
        super(x0, x1);
    }

    public void onNext(T t) {
        try {
            C14541q<? super T, ? super Integer, Boolean> qVar = this.f43623d.f43634a;
            int i = this.f43620a;
            this.f43620a = i + 1;
            if (((Boolean) qVar.call(t, Integer.valueOf(i))).booleanValue()) {
                this.f43622c.onNext(t);
            } else {
                this.f43621b = true;
                this.f43622c.onCompleted();
                unsubscribe();
            }
        } catch (Throwable e) {
            this.f43621b = true;
            C14927a.m46673a(e, (C0125T<?>) this.f43622c, (Object) t);
            unsubscribe();
        }
    }

    public void onCompleted() {
        if (!this.f43621b) {
            this.f43622c.onCompleted();
        }
    }

    public void onError(Throwable e) {
        if (!this.f43621b) {
            this.f43622c.onError(e);
        }
    }
}
