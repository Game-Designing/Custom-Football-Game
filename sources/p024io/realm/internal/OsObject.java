package p024io.realm.internal;

import p024io.realm.C0105Y;
import p024io.realm.C14040aa;
import p024io.realm.C14092y;
import p024io.realm.RealmFieldType;
import p024io.realm.exceptions.RealmException;
import p024io.realm.internal.C7336k.C7337a;
import p024io.realm.internal.C7336k.C7338b;

@KeepMember
/* renamed from: io.realm.internal.OsObject */
public class OsObject implements C7333h {

    /* renamed from: a */
    private static final long f14209a = nativeGetFinalizerPtr();

    /* renamed from: b */
    private final long f14210b;

    /* renamed from: c */
    private C7336k<C7307b> f14211c = new C7336k<>();

    /* renamed from: io.realm.internal.OsObject$a */
    private static class C7306a implements C7337a<C7307b> {

        /* renamed from: a */
        private final String[] f14212a;

        C7306a(String[] changedFields) {
            this.f14212a = changedFields;
        }

        /* renamed from: a */
        private C14092y m15918a() {
            boolean isDeleted = this.f14212a == null;
            return new C7308c(isDeleted ? new String[0] : this.f14212a, isDeleted);
        }

        /* renamed from: a */
        public void mo23567a(C7307b pair, Object observer) {
            pair.mo23603a((C0105Y) observer, m15918a());
        }
    }

    /* renamed from: io.realm.internal.OsObject$b */
    public static class C7307b<T extends C0105Y> extends C7338b<T, C14040aa<T>> {
        public C7307b(T observer, C14040aa<T> listener) {
            super(observer, listener);
        }

        /* renamed from: a */
        public void mo23603a(T observer, C14092y changeSet) {
            ((C14040aa) this.f14319b).mo43522a(observer, changeSet);
        }
    }

    /* renamed from: io.realm.internal.OsObject$c */
    private static class C7308c implements C14092y {

        /* renamed from: a */
        final String[] f14213a;

        /* renamed from: b */
        final boolean f14214b;

        C7308c(String[] changedFields, boolean deleted) {
            this.f14213a = changedFields;
            this.f14214b = deleted;
        }
    }

    private static native long nativeCreate(long j, long j2);

    private static native long nativeCreateNewObject(long j, long j2);

    private static native long nativeCreateNewObjectWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    private static native long nativeCreateNewObjectWithStringPrimaryKey(long j, long j2, long j3, String str);

    private static native long nativeCreateRow(long j, long j2);

    private static native long nativeCreateRowWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    private static native long nativeCreateRowWithStringPrimaryKey(long j, long j2, long j3, String str);

    private static native long nativeGetFinalizerPtr();

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    public OsObject(SharedRealm sharedRealm, UncheckedRow row) {
        this.f14210b = nativeCreate(sharedRealm.getNativePtr(), row.getNativePtr());
        sharedRealm.f14234l.mo23771a(this);
    }

    public long getNativePtr() {
        return this.f14210b;
    }

    public long getNativeFinalizerPtr() {
        return f14209a;
    }

    /* renamed from: a */
    public <T extends C0105Y> void mo23599a(T observer, C14040aa<T> listener) {
        if (this.f14211c.mo23784b()) {
            nativeStartListening(this.f14210b);
        }
        this.f14211c.mo23781a(new C7307b<>(observer, listener));
    }

    /* renamed from: a */
    public <T extends C0105Y> void mo23598a(T observer) {
        this.f14211c.mo23782a((Object) observer);
        if (this.f14211c.mo23784b()) {
            nativeStopListening(this.f14210b);
        }
    }

    /* renamed from: b */
    public <T extends C0105Y> void mo23601b(T observer, C14040aa<T> listener) {
        this.f14211c.mo23783a(observer, listener);
        if (this.f14211c.mo23784b()) {
            nativeStopListening(this.f14210b);
        }
    }

    /* renamed from: a */
    public void mo23600a(C7336k<C7307b> pairs) {
        if (this.f14211c.mo23784b()) {
            this.f14211c = pairs;
            if (!pairs.mo23784b()) {
                nativeStartListening(this.f14210b);
                return;
            }
            return;
        }
        throw new IllegalStateException("'observerPairs' is not empty. Listeners have been added before.");
    }

    /* renamed from: a */
    public static UncheckedRow m15910a(Table table) {
        SharedRealm sharedRealm = table.mo23669g();
        return new UncheckedRow(sharedRealm.f14234l, table, nativeCreateNewObject(sharedRealm.getNativePtr(), table.getNativePtr()));
    }

    /* renamed from: b */
    public static long m15911b(Table table) {
        return nativeCreateRow(table.mo23669g().getNativePtr(), table.getNativePtr());
    }

    /* renamed from: c */
    private static long m15913c(Table table) {
        long primaryKeyColumnIndex = table.mo23666f();
        if (primaryKeyColumnIndex != -2) {
            return primaryKeyColumnIndex;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(table.mo23665e());
        sb.append(" has no primary key defined.");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: b */
    public static UncheckedRow m15912b(Table table, Object primaryKeyValue) {
        Table table2 = table;
        Object obj = primaryKeyValue;
        long primaryKeyColumnIndex = m15913c(table);
        RealmFieldType type = table2.mo23668g(primaryKeyColumnIndex);
        SharedRealm sharedRealm = table.mo23669g();
        if (type == RealmFieldType.STRING) {
            if (obj == null || (obj instanceof String)) {
                return new UncheckedRow(sharedRealm.f14234l, table2, nativeCreateNewObjectWithStringPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), primaryKeyColumnIndex, (String) obj));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Primary key value is not a String: ");
            sb.append(obj);
            throw new IllegalArgumentException(sb.toString());
        } else if (type == RealmFieldType.INTEGER) {
            return new UncheckedRow(sharedRealm.f14234l, table2, nativeCreateNewObjectWithLongPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), primaryKeyColumnIndex, obj == null ? 0 : Long.parseLong(primaryKeyValue.toString()), obj == null));
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot check for duplicate rows for unsupported primary key type: ");
            sb2.append(type);
            throw new RealmException(sb2.toString());
        }
    }

    /* renamed from: a */
    public static long m15909a(Table table, Object primaryKeyValue) {
        long primaryKeyColumnIndex = m15913c(table);
        RealmFieldType type = table.mo23668g(primaryKeyColumnIndex);
        SharedRealm sharedRealm = table.mo23669g();
        if (type == RealmFieldType.STRING) {
            if (primaryKeyValue == null || (primaryKeyValue instanceof String)) {
                return nativeCreateRowWithStringPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), primaryKeyColumnIndex, (String) primaryKeyValue);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Primary key value is not a String: ");
            sb.append(primaryKeyValue);
            throw new IllegalArgumentException(sb.toString());
        } else if (type == RealmFieldType.INTEGER) {
            return nativeCreateRowWithLongPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), primaryKeyColumnIndex, primaryKeyValue == null ? 0 : Long.parseLong(primaryKeyValue.toString()), primaryKeyValue == null);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot check for duplicate rows for unsupported primary key type: ");
            sb2.append(type);
            throw new RealmException(sb2.toString());
        }
    }

    @KeepMember
    private void notifyChangeListeners(String[] changedFields) {
        this.f14211c.mo23780a((C7337a<T>) new C7306a<T>(changedFields));
    }
}
