package p026rx.p390c.p391a;

import java.util.concurrent.Callable;
import p026rx.C14972ha;
import p026rx.Single.C0124a;
import p026rx.exceptions.C14927a;

/* renamed from: rx.c.a.wb */
/* compiled from: SingleFromCallable */
public final class C14747wb<T> implements C0124a<T> {

    /* renamed from: a */
    final Callable<? extends T> f43871a;

    public C14747wb(Callable<? extends T> callable) {
        this.f43871a = callable;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> t) {
        try {
            t.mo45712a(this.f43871a.call());
        } catch (Throwable ex) {
            C14927a.m46678c(ex);
            t.onError(ex);
        }
    }
}
