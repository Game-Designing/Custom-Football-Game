package p024io.realm.internal;

import java.util.ArrayList;
import java.util.List;
import p024io.realm.RealmFieldType;

/* renamed from: io.realm.internal.OsObjectSchemaInfo */
public class OsObjectSchemaInfo implements C7333h {

    /* renamed from: a */
    private static final long f14215a = nativeGetFinalizerPtr();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f14216b;

    /* renamed from: io.realm.internal.OsObjectSchemaInfo$a */
    public static class C7309a {

        /* renamed from: a */
        private String f14217a;

        /* renamed from: b */
        private List<Property> f14218b = new ArrayList();

        public C7309a(String className) {
            this.f14217a = className;
        }

        /* renamed from: a */
        public C7309a mo23605a(String name, RealmFieldType type, boolean isPrimaryKey, boolean isIndexed, boolean isRequired) {
            Property property = new Property(name, type, isPrimaryKey, isIndexed, isRequired);
            this.f14218b.add(property);
            return this;
        }

        /* renamed from: a */
        public C7309a mo23604a(String name, RealmFieldType type, String linkedClassName) {
            this.f14218b.add(new Property(name, type, linkedClassName));
            return this;
        }

        /* renamed from: a */
        public OsObjectSchemaInfo mo23606a() {
            OsObjectSchemaInfo info = new OsObjectSchemaInfo(this.f14217a);
            for (Property property : this.f14218b) {
                OsObjectSchemaInfo.nativeAddProperty(info.f14216b, property.getNativePtr());
            }
            return info;
        }
    }

    /* access modifiers changed from: private */
    public static native void nativeAddProperty(long j, long j2);

    private static native long nativeCreateRealmObjectSchema(String str);

    private static native long nativeGetFinalizerPtr();

    private OsObjectSchemaInfo(String className) {
        this(nativeCreateRealmObjectSchema(className));
    }

    private OsObjectSchemaInfo(long nativePtr) {
        this.f14216b = nativePtr;
        C7332g.f14313c.mo23771a(this);
    }

    public long getNativePtr() {
        return this.f14216b;
    }

    public long getNativeFinalizerPtr() {
        return f14215a;
    }
}
