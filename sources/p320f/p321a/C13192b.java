package p320f.p321a;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.b */
/* compiled from: Completable */
public abstract class C13192b implements C13215d {
    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo42247b(C13198c cVar);

    /* renamed from: a */
    private static NullPointerException m43121a(Throwable ex) {
        NullPointerException npe = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        npe.initCause(ex);
        return npe;
    }

    /* renamed from: a */
    public final void mo42246a(C13198c s) {
        C13264b.m43226a(s, "s is null");
        try {
            mo42247b(C13774a.m43816a(this, s));
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            C13980a.m44462b(ex2);
            C13774a.m43836b(ex2);
            throw m43121a(ex2);
        }
    }
}
