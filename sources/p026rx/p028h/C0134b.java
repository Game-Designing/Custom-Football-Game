package p026rx.p028h;

import java.util.ArrayList;
import java.util.List;
import p026rx.C0120S.C0122a;
import p026rx.exceptions.C14927a;
import p026rx.p390c.p391a.C14689m;
import rx.subjects.SubjectSubscriptionManager;
import rx.subjects.SubjectSubscriptionManager.SubjectObserver;

/* renamed from: rx.h.b */
/* compiled from: BehaviorSubject */
public final class C0134b<T> extends C0135f<T, T> {

    /* renamed from: b */
    private static final Object[] f158b = new Object[0];

    /* renamed from: c */
    private final C14969h<T> f159c;

    /* renamed from: p */
    public static <T> C0134b<T> m768p() {
        return m767a(null, false);
    }

    /* renamed from: a */
    private static <T> C0134b<T> m767a(T defaultValue, boolean hasDefault) {
        SubjectSubscriptionManager<T> state = new C14969h<>();
        if (hasDefault) {
            state.mo46186b(C14689m.m46326d(defaultValue));
        }
        state.f44308d = new C14962a(state);
        state.f44309e = state.f44308d;
        return new C0134b<>(state, state);
    }

    protected C0134b(C0122a<T> onSubscribe, C14969h<T> state) {
        super(onSubscribe);
        this.f159c = state;
    }

    public void onCompleted() {
        if (this.f159c.mo46181a() == null || this.f159c.f44306b) {
            Object n = C14689m.m46320a();
            for (SubjectObserver<T> bo : this.f159c.mo46188c(n)) {
                bo.mo46194c(n);
            }
        }
    }

    public void onError(Throwable e) {
        if (this.f159c.mo46181a() == null || this.f159c.f44306b) {
            Object n = C14689m.m46321a(e);
            List<Throwable> errors = null;
            for (SubjectObserver<T> bo : this.f159c.mo46188c(n)) {
                try {
                    bo.mo46194c(n);
                } catch (Throwable e2) {
                    if (errors == null) {
                        errors = new ArrayList<>();
                    }
                    errors.add(e2);
                }
            }
            C14927a.m46676a(errors);
        }
    }

    public void onNext(T v) {
        if (this.f159c.mo46181a() == null || this.f159c.f44306b) {
            Object n = C14689m.m46326d(v);
            for (SubjectObserver<T> bo : this.f159c.mo46185a(n)) {
                bo.mo46194c(n);
            }
        }
    }
}
