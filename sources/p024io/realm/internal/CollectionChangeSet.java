package p024io.realm.internal;

import p024io.realm.C14093z;

/* renamed from: io.realm.internal.CollectionChangeSet */
public class CollectionChangeSet implements C14093z, C7333h {

    /* renamed from: a */
    private static long f14195a = nativeGetFinalizerPtr();

    /* renamed from: b */
    private final long f14196b;

    private static native long nativeGetFinalizerPtr();

    public CollectionChangeSet(long nativePtr) {
        this.f14196b = nativePtr;
        C7332g.f14313c.mo23771a(this);
    }

    public long getNativePtr() {
        return this.f14196b;
    }

    public long getNativeFinalizerPtr() {
        return f14195a;
    }
}
