package p019d.p022i.p023b;

import com.jakewharton.rxrelay.RelaySubscriptionManager;
import com.jakewharton.rxrelay.RelaySubscriptionManager.RelayObserver;
import p026rx.C0120S.C0122a;

/* renamed from: d.i.b.e */
/* compiled from: PublishRelay */
public class C0100e<T> extends C0101f<T, T> {

    /* renamed from: b */
    private final C13063h<T> f142b;

    /* renamed from: o */
    public static <T> C0100e<T> m565o() {
        RelaySubscriptionManager<T> state = new C13063h<>();
        return new C0100e<>(state, state);
    }

    protected C0100e(C0122a<T> onSubscribe, C13063h<T> state) {
        super(onSubscribe);
        this.f142b = state;
    }

    public void call(T v) {
        for (RelayObserver<T> ro : this.f142b.mo41961b()) {
            ro.onNext(v);
        }
    }
}
