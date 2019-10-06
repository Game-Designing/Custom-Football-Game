package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p027b.C0132p;
import p026rx.p029i.C14977e;
import p026rx.p390c.p392b.C14771b;
import rx.Subscriber;

/* renamed from: rx.c.a.Ga */
/* compiled from: OperatorOnErrorResumeNextViaFunction */
public final class C14581Ga<T> implements C0123b<T, T> {

    /* renamed from: a */
    final C0132p<? super Throwable, ? extends C0120S<? extends T>> f43440a;

    /* renamed from: a */
    public static <T> C14581Ga<T> m46219a(C0132p<? super Throwable, ? extends T> resumeFunction) {
        return new C14581Ga<>(new C14566Ca(resumeFunction));
    }

    /* renamed from: a */
    public static <T> C14581Ga<T> m46218a(C0120S<? extends T> other) {
        return new C14581Ga<>(new C14569Da(other));
    }

    public C14581Ga(C0132p<? super Throwable, ? extends C0120S<? extends T>> f) {
        this.f43440a = f;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        C14771b pa = new C14771b();
        C14977e serial = new C14977e();
        Subscriber<T> parent = new C14577Fa<>(this, child, pa, serial);
        serial.mo46198a(parent);
        child.add(serial);
        child.setProducer(pa);
        return parent;
    }
}
