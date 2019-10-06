package p024io.realm.internal;

import java.util.Date;
import p024io.realm.RealmFieldType;

/* renamed from: io.realm.internal.UncheckedRow */
public class UncheckedRow implements C7333h, C7347r {

    /* renamed from: a */
    private static final long f14262a = nativeGetFinalizerPtr();

    /* renamed from: b */
    private final C7332g f14263b;

    /* renamed from: c */
    private final Table f14264c;

    /* renamed from: d */
    private final long f14265d;

    private static native long nativeGetFinalizerPtr();

    /* access modifiers changed from: protected */
    public native boolean nativeGetBoolean(long j, long j2);

    /* access modifiers changed from: protected */
    public native byte[] nativeGetByteArray(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetColumnCount(long j);

    /* access modifiers changed from: protected */
    public native long nativeGetColumnIndex(long j, String str);

    /* access modifiers changed from: protected */
    public native String nativeGetColumnName(long j, long j2);

    /* access modifiers changed from: protected */
    public native int nativeGetColumnType(long j, long j2);

    /* access modifiers changed from: protected */
    public native double nativeGetDouble(long j, long j2);

    /* access modifiers changed from: protected */
    public native float nativeGetFloat(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetIndex(long j);

    /* access modifiers changed from: protected */
    public native long nativeGetLinkView(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetLong(long j, long j2);

    /* access modifiers changed from: protected */
    public native String nativeGetString(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetTimestamp(long j, long j2);

    /* access modifiers changed from: protected */
    public native boolean nativeIsAttached(long j);

    /* access modifiers changed from: protected */
    public native boolean nativeIsNull(long j, long j2);

    /* access modifiers changed from: protected */
    public native boolean nativeIsNullLink(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeNullifyLink(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetBoolean(long j, long j2, boolean z);

    /* access modifiers changed from: protected */
    public native void nativeSetByteArray(long j, long j2, byte[] bArr);

    /* access modifiers changed from: protected */
    public native void nativeSetDouble(long j, long j2, double d);

    /* access modifiers changed from: protected */
    public native void nativeSetFloat(long j, long j2, float f);

    /* access modifiers changed from: protected */
    public native void nativeSetLink(long j, long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeSetLong(long j, long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeSetNull(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetString(long j, long j2, String str);

    /* access modifiers changed from: protected */
    public native void nativeSetTimestamp(long j, long j2, long j3);

    UncheckedRow(C7332g context, Table parent, long nativePtr) {
        this.f14263b = context;
        this.f14264c = parent;
        this.f14265d = nativePtr;
        context.mo23771a(this);
    }

    UncheckedRow(UncheckedRow row) {
        this.f14263b = row.f14263b;
        this.f14264c = row.f14264c;
        this.f14265d = row.f14265d;
    }

    public long getNativePtr() {
        return this.f14265d;
    }

    public long getNativeFinalizerPtr() {
        return f14262a;
    }

    /* renamed from: a */
    static UncheckedRow m16025a(C7332g context, Table table, long index) {
        return new UncheckedRow(context, table, table.nativeGetRowPtr(table.getNativePtr(), index));
    }

    /* renamed from: b */
    static UncheckedRow m16026b(C7332g context, Table table, long nativeRowPointer) {
        return new UncheckedRow(context, table, nativeRowPointer);
    }

    public long getColumnCount() {
        return nativeGetColumnCount(this.f14265d);
    }

    /* renamed from: j */
    public String mo23718j(long columnIndex) {
        return nativeGetColumnName(this.f14265d, columnIndex);
    }

    public long getColumnIndex(String columnName) {
        if (columnName != null) {
            return nativeGetColumnIndex(this.f14265d, columnName);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    /* renamed from: n */
    public RealmFieldType mo23721n(long columnIndex) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.f14265d, columnIndex));
    }

    /* renamed from: f */
    public Table mo23711f() {
        return this.f14264c;
    }

    public long getIndex() {
        return nativeGetIndex(this.f14265d);
    }

    /* renamed from: h */
    public long mo23716h(long columnIndex) {
        return nativeGetLong(this.f14265d, columnIndex);
    }

    /* renamed from: g */
    public boolean mo23712g(long columnIndex) {
        return nativeGetBoolean(this.f14265d, columnIndex);
    }

    /* renamed from: e */
    public float mo23708e(long columnIndex) {
        return nativeGetFloat(this.f14265d, columnIndex);
    }

    /* renamed from: d */
    public double mo23707d(long columnIndex) {
        return nativeGetDouble(this.f14265d, columnIndex);
    }

    /* renamed from: i */
    public Date mo23717i(long columnIndex) {
        return new Date(nativeGetTimestamp(this.f14265d, columnIndex));
    }

    /* renamed from: m */
    public String mo23720m(long columnIndex) {
        return nativeGetString(this.f14265d, columnIndex);
    }

    /* renamed from: c */
    public byte[] mo23706c(long columnIndex) {
        return nativeGetByteArray(this.f14265d, columnIndex);
    }

    /* renamed from: l */
    public boolean mo23513l(long columnIndex) {
        return nativeIsNullLink(this.f14265d, columnIndex);
    }

    /* renamed from: f */
    public LinkView mo23710f(long columnIndex) {
        LinkView linkView = new LinkView(this.f14263b, this.f14264c, columnIndex, nativeGetLinkView(this.f14265d, columnIndex));
        return linkView;
    }

    /* renamed from: b */
    public void mo23705b(long columnIndex, long value) {
        this.f14264c.mo23644a();
        mo23711f().mo23648a(columnIndex, getIndex(), value);
        nativeSetLong(this.f14265d, columnIndex, value);
    }

    /* renamed from: a */
    public void mo23703a(long columnIndex, boolean value) {
        this.f14264c.mo23644a();
        nativeSetBoolean(this.f14265d, columnIndex, value);
    }

    /* renamed from: a */
    public void mo23700a(long columnIndex, float value) {
        this.f14264c.mo23644a();
        nativeSetFloat(this.f14265d, columnIndex, value);
    }

    /* renamed from: a */
    public void mo23699a(long columnIndex, double value) {
        this.f14264c.mo23644a();
        nativeSetDouble(this.f14265d, columnIndex, value);
    }

    /* renamed from: a */
    public void mo23702a(long columnIndex, Date date) {
        this.f14264c.mo23644a();
        if (date != null) {
            nativeSetTimestamp(this.f14265d, columnIndex, date.getTime());
            return;
        }
        throw new IllegalArgumentException("Null Date is not allowed.");
    }

    public void setString(long columnIndex, String value) {
        this.f14264c.mo23644a();
        if (value == null) {
            mo23711f().mo23646a(columnIndex, getIndex());
            nativeSetNull(this.f14265d, columnIndex);
            return;
        }
        String str = value;
        mo23711f().mo23650a(columnIndex, getIndex(), str);
        nativeSetString(this.f14265d, columnIndex, str);
    }

    /* renamed from: a */
    public void mo23704a(long columnIndex, byte[] data) {
        this.f14264c.mo23644a();
        nativeSetByteArray(this.f14265d, columnIndex, data);
    }

    /* renamed from: a */
    public void mo23701a(long columnIndex, long value) {
        this.f14264c.mo23644a();
        nativeSetLink(this.f14265d, columnIndex, value);
    }

    /* renamed from: k */
    public void mo23719k(long columnIndex) {
        this.f14264c.mo23644a();
        nativeNullifyLink(this.f14265d, columnIndex);
    }

    /* renamed from: a */
    public boolean mo23511a(long columnIndex) {
        return nativeIsNull(this.f14265d, columnIndex);
    }

    /* renamed from: b */
    public void mo23512b(long columnIndex) {
        this.f14264c.mo23644a();
        mo23711f().mo23646a(columnIndex, getIndex());
        nativeSetNull(this.f14265d, columnIndex);
    }

    /* renamed from: e */
    public boolean mo23709e() {
        long j = this.f14265d;
        return j != 0 && nativeIsAttached(j);
    }
}
