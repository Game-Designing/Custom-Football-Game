package p024io.realm.internal;

import java.util.Collection;

/* renamed from: io.realm.internal.OsSchemaInfo */
public class OsSchemaInfo implements C7333h {

    /* renamed from: a */
    private static final long f14219a = nativeGetFinalizerPtr();

    /* renamed from: b */
    private long f14220b;

    private static native long nativeCreateFromList(long[] jArr);

    private static native long nativeGetFinalizerPtr();

    public OsSchemaInfo(Collection<OsObjectSchemaInfo> objectSchemaInfoList) {
        long[] schemaNativePointers = new long[objectSchemaInfoList.size()];
        int i = 0;
        for (OsObjectSchemaInfo info : objectSchemaInfoList) {
            schemaNativePointers[i] = info.getNativePtr();
            i++;
        }
        this.f14220b = nativeCreateFromList(schemaNativePointers);
        C7332g.f14313c.mo23771a(this);
    }

    public long getNativePtr() {
        return this.f14220b;
    }

    public long getNativeFinalizerPtr() {
        return f14219a;
    }
}
