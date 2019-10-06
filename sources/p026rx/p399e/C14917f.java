package p026rx.p399e;

import p026rx.C0125T;
import p026rx.C14980ia;

/* renamed from: rx.e.f */
/* compiled from: SerializedSubscriber */
public class C14917f<T> extends C14980ia<T> {

    /* renamed from: a */
    private final C0125T<T> f44237a;

    public C14917f(C14980ia<? super T> s) {
        this(s, true);
    }

    public C14917f(C14980ia<? super T> s, boolean shareSubscriptions) {
        super(s, shareSubscriptions);
        this.f44237a = new C14915e(s);
    }

    public void onCompleted() {
        this.f44237a.onCompleted();
    }

    public void onError(Throwable e) {
        this.f44237a.onError(e);
    }

    public void onNext(T t) {
        this.f44237a.onNext(t);
    }
}
