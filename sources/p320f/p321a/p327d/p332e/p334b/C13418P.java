package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p327d.p331d.C13284j;

/* renamed from: f.a.d.e.b.P */
/* compiled from: ObservableDoOnLifecycle */
public final class C13418P<T> extends C13485a<T, T> {

    /* renamed from: b */
    private final C13204f<? super C13194b> f40809b;

    /* renamed from: c */
    private final C13199a f40810c;

    public C13418P(C13797m<T> upstream, C13204f<? super C13194b> onSubscribe, C13199a onDispose) {
        super(upstream);
        this.f40809b = onSubscribe;
        this.f40810c = onDispose;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f41005a.subscribe(new C13284j(observer, this.f40809b, this.f40810c));
    }
}
