package p026rx.p390c.p391a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p390c.p392b.C14772c;

/* renamed from: rx.c.a.lb */
/* compiled from: OperatorToObservableList */
class C14688lb extends C14980ia<T> {

    /* renamed from: a */
    boolean f43707a;

    /* renamed from: b */
    List<T> f43708b = new LinkedList();

    /* renamed from: c */
    final /* synthetic */ C14772c f43709c;

    /* renamed from: d */
    final /* synthetic */ C14980ia f43710d;

    /* renamed from: e */
    final /* synthetic */ C14693mb f43711e;

    C14688lb(C14693mb mbVar, C14772c cVar, C14980ia iaVar) {
        this.f43711e = mbVar;
        this.f43709c = cVar;
        this.f43710d = iaVar;
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    public void onCompleted() {
        if (!this.f43707a) {
            this.f43707a = true;
            try {
                List<T> result = new ArrayList<>(this.f43708b);
                this.f43708b = null;
                this.f43709c.mo45916a(result);
            } catch (Throwable t) {
                C14927a.m46672a(t, (C0125T<?>) this);
            }
        }
    }

    public void onError(Throwable e) {
        this.f43710d.onError(e);
    }

    public void onNext(T value) {
        if (!this.f43707a) {
            this.f43708b.add(value);
        }
    }
}
