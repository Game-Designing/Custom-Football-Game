package p024io.fabric.sdk.android.p348a.p349a;

import android.content.Context;

/* renamed from: io.fabric.sdk.android.a.a.a */
/* compiled from: AbstractValueCache */
public abstract class C13826a<T> implements C13828c<T> {

    /* renamed from: a */
    private final C13828c<T> f41985a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo43198a(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo43200a(Context context, T t);

    public C13826a(C13828c<T> childCache) {
        this.f41985a = childCache;
    }

    /* renamed from: a */
    public final synchronized T mo43199a(Context context, C13829d<T> loader) throws Exception {
        T value;
        value = mo43198a(context);
        if (value == null) {
            value = this.f41985a != null ? this.f41985a.mo43199a(context, loader) : loader.mo43201a(context);
            m43943b(context, value);
        }
        return value;
    }

    /* renamed from: b */
    private void m43943b(Context context, T value) {
        if (value != null) {
            mo43200a(context, value);
            return;
        }
        throw new NullPointerException();
    }
}
