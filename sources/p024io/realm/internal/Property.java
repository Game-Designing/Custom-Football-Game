package p024io.realm.internal;

import p024io.realm.RealmFieldType;

/* renamed from: io.realm.internal.Property */
public class Property implements C7333h {

    /* renamed from: a */
    private static final long f14221a = nativeGetFinalizerPtr();

    /* renamed from: b */
    private long f14222b;

    private static native long nativeCreateProperty(String str, int i, String str2);

    private static native long nativeCreateProperty(String str, int i, boolean z, boolean z2, boolean z3);

    private static native long nativeGetFinalizerPtr();

    Property(String name, RealmFieldType type, boolean isPrimary, boolean isIndexed, boolean isRequired) {
        this.f14222b = nativeCreateProperty(name, type.getNativeValue(), isPrimary, isIndexed, !isRequired);
        C7332g.f14313c.mo23771a(this);
    }

    Property(String name, RealmFieldType type, String linkedClassName) {
        this.f14222b = nativeCreateProperty(name, type.getNativeValue(), linkedClassName);
        C7332g.f14313c.mo23771a(this);
    }

    public long getNativePtr() {
        return this.f14222b;
    }

    public long getNativeFinalizerPtr() {
        return f14221a;
    }
}
