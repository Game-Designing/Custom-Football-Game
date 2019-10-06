package p019d.p022i.p023b;

import com.jakewharton.rxrelay.RelaySubscriptionManager;
import com.jakewharton.rxrelay.RelaySubscriptionManager.RelayObserver;
import p026rx.C0120S.C0122a;

/* renamed from: d.i.b.b */
/* compiled from: BehaviorRelay */
public class C0099b<T> extends C0101f<T, T> {

    /* renamed from: b */
    private static final Object[] f140b = new Object[0];

    /* renamed from: c */
    private final C13063h<T> f141c;

    /* renamed from: o */
    public static <T> C0099b<T> m564o() {
        return m563a(null, false);
    }

    /* renamed from: a */
    private static <T> C0099b<T> m563a(T defaultValue, boolean hasDefault) {
        RelaySubscriptionManager<T> state = new C13063h<>();
        if (hasDefault) {
            state.mo41960b(C13061d.m42512a(defaultValue));
        }
        state.f40052d = new C13059a(state);
        return new C0099b<>(state, state);
    }

    protected C0099b(C0122a<T> onSubscribe, C13063h<T> state) {
        super(onSubscribe);
        this.f141c = state;
    }

    public void call(T v) {
        if (this.f141c.mo41956a() == null || this.f141c.f40050b) {
            Object n = C13061d.m42512a(v);
            for (RelayObserver<T> ro : this.f141c.mo41959a(n)) {
                ro.mo41963b(n);
            }
        }
    }
}
