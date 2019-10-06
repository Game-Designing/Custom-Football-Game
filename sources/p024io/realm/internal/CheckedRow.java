package p024io.realm.internal;

import p024io.realm.RealmFieldType;

/* renamed from: io.realm.internal.CheckedRow */
public class CheckedRow extends UncheckedRow {

    /* renamed from: e */
    private UncheckedRow f14178e;

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
    public native long nativeGetLinkView(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetLong(long j, long j2);

    /* access modifiers changed from: protected */
    public native String nativeGetString(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetTimestamp(long j, long j2);

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
    public native void nativeSetString(long j, long j2, String str);

    /* access modifiers changed from: protected */
    public native void nativeSetTimestamp(long j, long j2, long j3);

    private CheckedRow(C7332g context, Table parent, long nativePtr) {
        super(context, parent, nativePtr);
    }

    private CheckedRow(UncheckedRow row) {
        super(row);
        this.f14178e = row;
    }

    /* renamed from: c */
    public static CheckedRow m15877c(C7332g context, Table table, long index) {
        return new CheckedRow(context, table, table.nativeGetRowPtr(table.getNativePtr(), index));
    }

    /* renamed from: a */
    public static CheckedRow m15876a(UncheckedRow row) {
        return new CheckedRow(row);
    }

    /* renamed from: l */
    public boolean mo23513l(long columnIndex) {
        RealmFieldType columnType = mo23721n(columnIndex);
        if (columnType == RealmFieldType.OBJECT || columnType == RealmFieldType.LIST) {
            return super.mo23513l(columnIndex);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo23511a(long columnIndex) {
        return super.mo23511a(columnIndex);
    }

    /* renamed from: b */
    public void mo23512b(long columnIndex) {
        if (mo23721n(columnIndex) == RealmFieldType.BINARY) {
            super.mo23704a(columnIndex, (byte[]) null);
        } else {
            super.mo23512b(columnIndex);
        }
    }
}
