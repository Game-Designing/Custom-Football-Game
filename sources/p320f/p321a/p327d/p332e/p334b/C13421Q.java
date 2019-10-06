package p320f.p321a.p327d.p332e.p334b;

import java.util.NoSuchElementException;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Q */
/* compiled from: ObservableElementAt */
public final class C13421Q<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f40816b;

    /* renamed from: c */
    final T f40817c;

    /* renamed from: d */
    final boolean f40818d;

    /* renamed from: f.a.d.e.b.Q$a */
    /* compiled from: ObservableElementAt */
    static final class C13422a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40819a;

        /* renamed from: b */
        final long f40820b;

        /* renamed from: c */
        final T f40821c;

        /* renamed from: d */
        final boolean f40822d;

        /* renamed from: e */
        C13194b f40823e;

        /* renamed from: f */
        long f40824f;

        /* renamed from: g */
        boolean f40825g;

        C13422a(C13804t<? super T> actual, long index, T defaultValue, boolean errorOnFewer) {
            this.f40819a = actual;
            this.f40820b = index;
            this.f40821c = defaultValue;
            this.f40822d = errorOnFewer;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40823e, s)) {
                this.f40823e = s;
                this.f40819a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40823e.dispose();
        }

        public void onNext(T t) {
            if (!this.f40825g) {
                long c = this.f40824f;
                if (c == this.f40820b) {
                    this.f40825g = true;
                    this.f40823e.dispose();
                    this.f40819a.onNext(t);
                    this.f40819a.onComplete();
                    return;
                }
                this.f40824f = 1 + c;
            }
        }

        public void onError(Throwable t) {
            if (this.f40825g) {
                C13774a.m43836b(t);
                return;
            }
            this.f40825g = true;
            this.f40819a.onError(t);
        }

        public void onComplete() {
            if (!this.f40825g) {
                this.f40825g = true;
                T v = this.f40821c;
                if (v != null || !this.f40822d) {
                    if (v != null) {
                        this.f40819a.onNext(v);
                    }
                    this.f40819a.onComplete();
                    return;
                }
                this.f40819a.onError(new NoSuchElementException());
            }
        }
    }

    public C13421Q(C13802r<T> source, long index, T defaultValue, boolean errorOnFewer) {
        super(source);
        this.f40816b = index;
        this.f40817c = defaultValue;
        this.f40818d = errorOnFewer;
    }

    public void subscribeActual(C13804t<? super T> t) {
        C13802r<T> rVar = this.f41005a;
        C13422a aVar = new C13422a(t, this.f40816b, this.f40817c, this.f40818d);
        rVar.subscribe(aVar);
    }
}
