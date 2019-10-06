package p320f.p321a.p327d.p338h;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13773g;
import p320f.p321a.p327d.p339i.C13737b;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p327d.p340j.C13750k;
import p363i.p368b.C14229b;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.h.a */
/* compiled from: StrictSubscriber */
public class C13735a<T> extends AtomicInteger implements C13773g<T>, C14230c {

    /* renamed from: a */
    final C14229b<? super T> f41836a;

    /* renamed from: b */
    final C13741c f41837b = new C13741c();

    /* renamed from: c */
    final AtomicLong f41838c = new AtomicLong();

    /* renamed from: d */
    final AtomicReference<C14230c> f41839d = new AtomicReference<>();

    /* renamed from: e */
    final AtomicBoolean f41840e = new AtomicBoolean();

    /* renamed from: f */
    volatile boolean f41841f;

    public C13735a(C14229b<? super T> actual) {
        this.f41836a = actual;
    }

    public void request(long n) {
        if (n <= 0) {
            cancel();
            StringBuilder sb = new StringBuilder();
            sb.append("§3.9 violated: positive request amount required but it was ");
            sb.append(n);
            onError(new IllegalArgumentException(sb.toString()));
            return;
        }
        C13737b.m43734a(this.f41839d, this.f41838c, n);
    }

    public void cancel() {
        if (!this.f41841f) {
            C13737b.m43737a(this.f41839d);
        }
    }

    /* renamed from: a */
    public void mo42355a(C14230c s) {
        if (this.f41840e.compareAndSet(false, true)) {
            this.f41836a.mo42355a(this);
            C13737b.m43739a(this.f41839d, this.f41838c, s);
            return;
        }
        s.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void onNext(T t) {
        C13750k.m43767a(this.f41836a, t, (AtomicInteger) this, this.f41837b);
    }

    public void onError(Throwable t) {
        this.f41841f = true;
        C13750k.m43768a(this.f41836a, t, (AtomicInteger) this, this.f41837b);
    }

    public void onComplete() {
        this.f41841f = true;
        C13750k.m43769a(this.f41836a, (AtomicInteger) this, this.f41837b);
    }
}
