package p320f.p321a;

import org.reactivestreams.Subscriber;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.p327d.p329b.C13226a;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p332e.p333a.C13298c;
import p320f.p321a.p327d.p332e.p333a.C13300d;
import p320f.p321a.p327d.p332e.p333a.C13304f;
import p320f.p321a.p327d.p338h.C13735a;
import p320f.p321a.p343g.C13774a;
import p363i.p368b.C14228a;
import p363i.p368b.C14229b;

/* renamed from: f.a.f */
/* compiled from: Flowable */
public abstract class C13764f<T> implements C14228a<T> {

    /* renamed from: a */
    static final int f41876a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo42351b(C14229b<? super T> bVar);

    /* renamed from: a */
    public static int m43802a() {
        return f41876a;
    }

    /* renamed from: b */
    public final C13764f<T> mo42782b() {
        return mo42779a(m43802a(), false, true);
    }

    /* renamed from: a */
    public final C13764f<T> mo42779a(int capacity, boolean delayError, boolean unbounded) {
        C13264b.m43222a(capacity, "bufferSize");
        C13298c cVar = new C13298c(this, capacity, unbounded, delayError, C13226a.f40312c);
        return C13774a.m43818a((C13764f<T>) cVar);
    }

    /* renamed from: c */
    public final C13764f<T> mo42783c() {
        return C13774a.m43818a((C13764f<T>) new C13300d<T>(this));
    }

    /* renamed from: d */
    public final C13764f<T> mo42784d() {
        return C13774a.m43818a((C13764f<T>) new C13304f<T>(this));
    }

    /* renamed from: a */
    public final void mo42781a(C14229b<? super T> s) {
        if (s instanceof C13773g) {
            mo42780a((C13773g) s);
            return;
        }
        C13264b.m43226a(s, "s is null");
        mo42780a((C13773g<? super T>) new C13735a<Object>(s));
    }

    /* renamed from: a */
    public final void mo42780a(C13773g<? super T> s) {
        C13264b.m43226a(s, "s is null");
        try {
            Subscriber<? super T> z = C13774a.m43828a(this, (C14229b<? super T>) s);
            C13264b.m43226a(z, "Plugin returned null Subscriber");
            mo42351b(z);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable e2) {
            C13980a.m44462b(e2);
            C13774a.m43836b(e2);
            NullPointerException npe = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            npe.initCause(e2);
            throw npe;
        }
    }
}
