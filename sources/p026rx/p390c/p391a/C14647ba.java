package p026rx.p390c.p391a;

import p026rx.C0120S.C0122a;
import p026rx.C14980ia;

/* renamed from: rx.c.a.ba */
/* compiled from: OnSubscribeThrow */
public final class C14647ba<T> implements C0122a<T> {

    /* renamed from: a */
    private final Throwable f43615a;

    public C14647ba(Throwable exception) {
        this.f43615a = exception;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> observer) {
        observer.onError(this.f43615a);
    }
}
