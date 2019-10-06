package p026rx.p399e;

import p026rx.C0137ja;
import p026rx.C14503O;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.CompositeException;
import p026rx.exceptions.OnCompletedFailedException;
import p026rx.exceptions.OnErrorFailedException;
import p026rx.p400f.C14948s;

/* renamed from: rx.e.c */
/* compiled from: SafeCompletableSubscriber */
public final class C14913c implements C14503O, C0137ja {

    /* renamed from: a */
    final C14503O f44226a;

    /* renamed from: b */
    C0137ja f44227b;

    /* renamed from: c */
    boolean f44228c;

    public C14913c(C14503O actual) {
        this.f44226a = actual;
    }

    public void onCompleted() {
        if (!this.f44228c) {
            this.f44228c = true;
            try {
                this.f44226a.onCompleted();
            } catch (Throwable ex) {
                C14927a.m46678c(ex);
                throw new OnCompletedFailedException(ex);
            }
        }
    }

    public void onError(Throwable e) {
        C14948s.m46719b(e);
        if (!this.f44228c) {
            this.f44228c = true;
            try {
                this.f44226a.onError(e);
            } catch (Throwable ex) {
                C14927a.m46678c(ex);
                throw new OnErrorFailedException(new CompositeException(e, ex));
            }
        }
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f44227b = d;
        try {
            this.f44226a.mo45688a(this);
        } catch (Throwable ex) {
            C14927a.m46678c(ex);
            d.unsubscribe();
            onError(ex);
        }
    }

    public void unsubscribe() {
        this.f44227b.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.f44228c || this.f44227b.isUnsubscribed();
    }
}
