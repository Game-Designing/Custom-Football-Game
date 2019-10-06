package p026rx.p400f;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0120S.C0123b;
import p026rx.C0137ja;

/* renamed from: rx.f.t */
/* compiled from: RxJavaObservableExecutionHook */
public abstract class C14949t {
    @Deprecated
    public <T> C0122a<T> onCreate(C0122a<T> f) {
        return f;
    }

    @Deprecated
    public <T> C0122a<T> onSubscribeStart(C0120S<? extends T> s, C0122a<T> onSubscribe) {
        return onSubscribe;
    }

    @Deprecated
    public <T> C0137ja onSubscribeReturn(C0137ja subscription) {
        return subscription;
    }

    @Deprecated
    public <T> Throwable onSubscribeError(Throwable e) {
        return e;
    }

    @Deprecated
    public <T, R> C0123b<? extends R, ? super T> onLift(C0123b<? extends R, ? super T> lift) {
        return lift;
    }
}
