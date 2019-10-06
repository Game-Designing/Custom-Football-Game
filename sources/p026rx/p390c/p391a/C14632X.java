package p026rx.p390c.p391a;

import java.util.NoSuchElementException;
import p026rx.C14972ha;
import p026rx.C14980ia;

/* renamed from: rx.c.a.X */
/* compiled from: OnSubscribeSingle */
class C14632X extends C14980ia<T> {

    /* renamed from: a */
    private boolean f43581a;

    /* renamed from: b */
    private boolean f43582b;

    /* renamed from: c */
    private T f43583c;

    /* renamed from: d */
    final /* synthetic */ C14972ha f43584d;

    /* renamed from: e */
    final /* synthetic */ C14634Y f43585e;

    C14632X(C14634Y y, C14972ha haVar) {
        this.f43585e = y;
        this.f43584d = haVar;
    }

    public void onStart() {
        request(2);
    }

    public void onCompleted() {
        if (!this.f43581a) {
            if (this.f43582b) {
                this.f43584d.mo45712a(this.f43583c);
            } else {
                this.f43584d.onError(new NoSuchElementException("Observable emitted no items"));
            }
        }
    }

    public void onError(Throwable e) {
        this.f43584d.onError(e);
        unsubscribe();
    }

    public void onNext(T t) {
        if (this.f43582b) {
            this.f43581a = true;
            this.f43584d.onError(new IllegalArgumentException("Observable emitted too many elements"));
            unsubscribe();
            return;
        }
        this.f43582b = true;
        this.f43583c = t;
    }
}
