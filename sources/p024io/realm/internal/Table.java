package p024io.realm.internal;

import p024io.realm.RealmFieldType;
import p024io.realm.exceptions.RealmException;
import p024io.realm.exceptions.RealmPrimaryKeyConstraintException;

/* renamed from: io.realm.internal.Table */
public class Table implements C7349t, C7333h {

    /* renamed from: a */
    private static final String f14251a = Util.m16051a();

    /* renamed from: b */
    private static final long f14252b = nativeGetFinalizerPtr();

    /* renamed from: c */
    private final long f14253c;

    /* renamed from: d */
    private final C7332g f14254d;

    /* renamed from: e */
    private final SharedRealm f14255e;

    /* renamed from: f */
    private long f14256f;

    private native long nativeAddColumn(long j, int i, String str, boolean z);

    private native void nativeAddSearchIndex(long j, long j2);

    private native void nativeClear(long j);

    private native void nativeConvertColumnToNotNullable(long j, long j2, boolean z);

    private native void nativeConvertColumnToNullable(long j, long j2, boolean z);

    public static native long nativeFindFirstInt(long j, long j2, long j3);

    public static native long nativeFindFirstNull(long j, long j2);

    public static native long nativeFindFirstString(long j, long j2, String str);

    private native long nativeGetColumnCount(long j);

    private native long nativeGetColumnIndex(long j, String str);

    private native String nativeGetColumnName(long j, long j2);

    private native int nativeGetColumnType(long j, long j2);

    private static native long nativeGetFinalizerPtr();

    private native long nativeGetLinkTarget(long j, long j2);

    public static native long nativeGetLinkView(long j, long j2, long j3);

    private native String nativeGetName(long j);

    private native boolean nativeHasSameSchema(long j, long j2);

    private native boolean nativeHasSearchIndex(long j, long j2);

    private native boolean nativeIsColumnNullable(long j, long j2);

    private static native boolean nativeMigratePrimaryKeyTableIfNeeded(long j, long j2);

    private native void nativeMoveLastOver(long j, long j2);

    private static native boolean nativePrimaryKeyTableNeedsMigration(long j);

    private native void nativeRemoveColumn(long j, long j2);

    private native void nativeRemoveSearchIndex(long j, long j2);

    public static native void nativeSetBoolean(long j, long j2, long j3, boolean z, boolean z2);

    public static native void nativeSetDouble(long j, long j2, long j3, double d, boolean z);

    public static native void nativeSetLong(long j, long j2, long j3, long j4, boolean z);

    public static native void nativeSetNull(long j, long j2, long j3, boolean z);

    private native long nativeSetPrimaryKey(long j, long j2, String str);

    public static native void nativeSetString(long j, long j2, long j3, String str, boolean z);

    private native long nativeSize(long j);

    private native long nativeWhere(long j);

    /* access modifiers changed from: 0000 */
    public native long nativeGetRowPtr(long j, long j2);

    Table(Table parent, long nativePointer) {
        this(parent.f14255e, nativePointer);
    }

    Table(SharedRealm sharedRealm, long nativePointer) {
        this.f14256f = -1;
        this.f14254d = sharedRealm.f14234l;
        this.f14255e = sharedRealm;
        this.f14253c = nativePointer;
        this.f14254d.mo23771a(this);
    }

    public long getNativePtr() {
        return this.f14253c;
    }

    public long getNativeFinalizerPtr() {
        return f14252b;
    }

    /* renamed from: e */
    private void m15963e(String name) {
        if (name.length() > 63) {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        }
    }

    /* renamed from: a */
    public long mo23643a(RealmFieldType type, String name, boolean isNullable) {
        m15963e(name);
        return nativeAddColumn(this.f14253c, type.getNativeValue(), name, isNullable);
    }

    /* renamed from: a */
    public long mo23642a(RealmFieldType type, String name) {
        return mo23643a(type, name, false);
    }

    /* renamed from: n */
    public void mo23680n(long columnIndex) {
        long oldPkColumnIndex = mo23666f();
        nativeRemoveColumn(this.f14253c, columnIndex);
        if (oldPkColumnIndex < 0) {
            return;
        }
        if (oldPkColumnIndex == columnIndex) {
            mo23663d((String) null);
        } else if (oldPkColumnIndex > columnIndex) {
            m15965m();
        }
    }

    /* renamed from: l */
    public boolean mo23678l(long columnIndex) {
        return nativeIsColumnNullable(this.f14253c, columnIndex);
    }

    /* renamed from: c */
    public void mo23660c(long columnIndex) {
        nativeConvertColumnToNullable(this.f14253c, columnIndex, m15967p(columnIndex));
    }

    /* renamed from: b */
    public void mo23658b(long columnIndex) {
        nativeConvertColumnToNotNullable(this.f14253c, columnIndex, m15967p(columnIndex));
    }

    /* renamed from: j */
    public long mo23674j() {
        return nativeSize(this.f14253c);
    }

    /* renamed from: b */
    public void mo23657b() {
        mo23644a();
        nativeClear(this.f14253c);
    }

    /* renamed from: d */
    public long mo23661d() {
        return nativeGetColumnCount(this.f14253c);
    }

    /* renamed from: f */
    public String mo23667f(long columnIndex) {
        return nativeGetColumnName(this.f14253c, columnIndex);
    }

    /* renamed from: b */
    public long mo23656b(String columnName) {
        if (columnName != null) {
            return nativeGetColumnIndex(this.f14253c, columnName);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    /* renamed from: g */
    public RealmFieldType mo23668g(long columnIndex) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.f14253c, columnIndex));
    }

    /* renamed from: m */
    public void mo23679m(long rowIndex) {
        mo23644a();
        nativeMoveLastOver(this.f14253c, rowIndex);
    }

    /* renamed from: q */
    private boolean m15968q(long columnIndex) {
        return columnIndex == mo23666f();
    }

    /* renamed from: f */
    public long mo23666f() {
        long j = this.f14256f;
        if (j >= 0 || j == -2) {
            return this.f14256f;
        }
        Table pkTable = m15964l();
        if (pkTable == null) {
            return -2;
        }
        long rowIndex = pkTable.mo23641a(0, mo23659c());
        if (rowIndex != -1) {
            this.f14256f = mo23656b(pkTable.mo23672i(rowIndex).mo23720m(1));
        } else {
            this.f14256f = -2;
        }
        return this.f14256f;
    }

    /* renamed from: p */
    private boolean m15967p(long columnIndex) {
        return columnIndex >= 0 && columnIndex == mo23666f();
    }

    /* renamed from: h */
    public boolean mo23671h() {
        return mo23666f() >= 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23650a(long columnIndex, long rowToUpdate, String value) {
        if (m15967p(columnIndex)) {
            long rowIndex = mo23641a(columnIndex, value);
            if (rowIndex != rowToUpdate && rowIndex != -1) {
                m15959a((Object) value);
                throw null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23648a(long columnIndex, long rowToUpdate, long value) {
        if (m15968q(columnIndex)) {
            long rowIndex = mo23655b(columnIndex, value);
            if (rowIndex != rowToUpdate && rowIndex != -1) {
                m15959a((Object) Long.valueOf(value));
                throw null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23646a(long columnIndex, long rowToUpdate) {
        if (m15968q(columnIndex)) {
            int i = C7348s.f14333a[mo23668g(columnIndex).ordinal()];
            if (i == 1 || i == 2) {
                long rowIndex = mo23662d(columnIndex);
                if (rowIndex != rowToUpdate && rowIndex != -1) {
                    m15959a((Object) "null");
                    throw null;
                }
            }
        }
    }

    /* renamed from: a */
    public static void m15959a(Object value) {
        StringBuilder sb = new StringBuilder();
        sb.append("Value already exists: ");
        sb.append(value);
        throw new RealmPrimaryKeyConstraintException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public SharedRealm mo23669g() {
        return this.f14255e;
    }

    /* renamed from: h */
    public Table mo23670h(long columnIndex) {
        return new Table(this.f14255e, nativeGetLinkTarget(this.f14253c, columnIndex));
    }

    /* renamed from: i */
    public UncheckedRow mo23672i(long index) {
        return UncheckedRow.m16025a(this.f14254d, this, index);
    }

    /* renamed from: j */
    public UncheckedRow mo23675j(long nativeRowPointer) {
        return UncheckedRow.m16026b(this.f14254d, this, nativeRowPointer);
    }

    /* renamed from: e */
    public CheckedRow mo23664e(long index) {
        return CheckedRow.m15877c(this.f14254d, this, index);
    }

    /* renamed from: a */
    public void mo23649a(long columnIndex, long rowIndex, long value, boolean isDefault) {
        mo23644a();
        mo23648a(columnIndex, rowIndex, value);
        nativeSetLong(this.f14253c, columnIndex, rowIndex, value, isDefault);
    }

    /* renamed from: a */
    public void mo23653a(long columnIndex, long rowIndex, boolean value, boolean isDefault) {
        mo23644a();
        nativeSetBoolean(this.f14253c, columnIndex, rowIndex, value, isDefault);
    }

    /* renamed from: a */
    public void mo23647a(long columnIndex, long rowIndex, double value, boolean isDefault) {
        mo23644a();
        nativeSetDouble(this.f14253c, columnIndex, rowIndex, value, isDefault);
    }

    /* renamed from: a */
    public void mo23651a(long columnIndex, long rowIndex, String value, boolean isDefault) {
        mo23644a();
        if (value == null) {
            mo23646a(columnIndex, rowIndex);
            nativeSetNull(this.f14253c, columnIndex, rowIndex, isDefault);
            return;
        }
        mo23650a(columnIndex, rowIndex, value);
        nativeSetString(this.f14253c, columnIndex, rowIndex, value, isDefault);
    }

    /* renamed from: a */
    public void mo23652a(long columnIndex, long rowIndex, boolean isDefault) {
        mo23644a();
        mo23646a(columnIndex, rowIndex);
        nativeSetNull(this.f14253c, columnIndex, rowIndex, isDefault);
    }

    /* renamed from: a */
    public void mo23645a(long columnIndex) {
        mo23644a();
        nativeAddSearchIndex(this.f14253c, columnIndex);
    }

    /* renamed from: o */
    public void mo23682o(long columnIndex) {
        mo23644a();
        nativeRemoveSearchIndex(this.f14253c, columnIndex);
    }

    /* renamed from: d */
    public void mo23663d(String columnName) {
        Table pkTable = m15964l();
        if (pkTable != null) {
            this.f14256f = nativeSetPrimaryKey(pkTable.f14253c, this.f14253c, columnName);
            return;
        }
        throw new RealmException("Primary keys are only supported if Table is part of a Group");
    }

    /* renamed from: l */
    private Table m15964l() {
        SharedRealm sharedRealm = this.f14255e;
        if (sharedRealm == null) {
            return null;
        }
        String str = "pk";
        if (!sharedRealm.mo23625c(str)) {
            this.f14255e.mo23616a(str);
        }
        Table pkTable = this.f14255e.mo23622b(str);
        if (pkTable.mo23661d() == 0) {
            mo23644a();
            pkTable.mo23645a(pkTable.mo23642a(RealmFieldType.STRING, "pk_table"));
            pkTable.mo23642a(RealmFieldType.STRING, "pk_property");
        }
        return pkTable;
    }

    /* renamed from: m */
    private void m15965m() {
        this.f14256f = -1;
    }

    /* renamed from: a */
    public static boolean m15960a(SharedRealm sharedRealm) {
        if (sharedRealm == null || !sharedRealm.mo23636j()) {
            m15966n();
            throw null;
        }
        String str = "pk";
        if (!sharedRealm.mo23625c(str)) {
            return false;
        }
        return nativeMigratePrimaryKeyTableIfNeeded(sharedRealm.mo23629e(), sharedRealm.mo23622b(str).f14253c);
    }

    /* renamed from: b */
    public static boolean m15961b(SharedRealm sharedRealm) {
        String str = "pk";
        if (!sharedRealm.mo23625c(str)) {
            return false;
        }
        return nativePrimaryKeyTableNeedsMigration(sharedRealm.mo23622b(str).f14253c);
    }

    /* renamed from: k */
    public boolean mo23677k(long columnIndex) {
        return nativeHasSearchIndex(this.f14253c, columnIndex);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo23673i() {
        SharedRealm sharedRealm = this.f14255e;
        return sharedRealm != null && !sharedRealm.mo23636j();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23644a() {
        if (mo23673i()) {
            m15966n();
            throw null;
        }
    }

    /* renamed from: k */
    public TableQuery mo23676k() {
        return new TableQuery(this.f14254d, this, nativeWhere(this.f14253c));
    }

    /* renamed from: b */
    public long mo23655b(long columnIndex, long value) {
        return nativeFindFirstInt(this.f14253c, columnIndex, value);
    }

    /* renamed from: a */
    public long mo23641a(long columnIndex, String value) {
        if (value != null) {
            return nativeFindFirstString(this.f14253c, columnIndex, value);
        }
        throw new IllegalArgumentException("null is not supported");
    }

    /* renamed from: d */
    public long mo23662d(long columnIndex) {
        return nativeFindFirstNull(this.f14253c, columnIndex);
    }

    /* renamed from: e */
    public String mo23665e() {
        return nativeGetName(this.f14253c);
    }

    /* renamed from: c */
    public String mo23659c() {
        return m15958a(mo23665e());
    }

    public String toString() {
        long columnCount = mo23661d();
        String name = mo23665e();
        StringBuilder stringBuilder = new StringBuilder("The Table ");
        if (name != null && !name.isEmpty()) {
            stringBuilder.append(mo23665e());
            stringBuilder.append(" ");
        }
        if (mo23671h()) {
            String pkFieldName = mo23667f(mo23666f());
            stringBuilder.append("has '");
            stringBuilder.append(pkFieldName);
            stringBuilder.append("' field as a PrimaryKey, and ");
        }
        stringBuilder.append("contains ");
        stringBuilder.append(columnCount);
        stringBuilder.append(" columns: ");
        for (int i = 0; ((long) i) < columnCount; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(mo23667f((long) i));
        }
        stringBuilder.append(".");
        stringBuilder.append(" And ");
        stringBuilder.append(mo23674j());
        stringBuilder.append(" rows.");
        return stringBuilder.toString();
    }

    /* renamed from: n */
    private static void m15966n() {
        throw new IllegalStateException("Cannot modify managed objects outside of a write transaction.");
    }

    /* renamed from: a */
    public boolean mo23654a(Table table) {
        if (table != null) {
            return nativeHasSameSchema(this.f14253c, table.f14253c);
        }
        throw new IllegalArgumentException("The argument cannot be null");
    }

    /* renamed from: a */
    public static String m15958a(String name) {
        if (name == null) {
            return null;
        }
        if (!name.startsWith(f14251a)) {
            return name;
        }
        return name.substring(f14251a.length());
    }

    /* renamed from: c */
    public static String m15962c(String name) {
        if (name == null) {
            return null;
        }
        if (name.startsWith(f14251a)) {
            return name;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f14251a);
        sb.append(name);
        return sb.toString();
    }
}
