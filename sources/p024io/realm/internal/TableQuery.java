package p024io.realm.internal;

import p024io.realm.C14053e;

/* renamed from: io.realm.internal.TableQuery */
public class TableQuery implements C7333h {

    /* renamed from: a */
    private static final long f14257a = nativeGetFinalizerPtr();

    /* renamed from: b */
    private final C7332g f14258b;

    /* renamed from: c */
    private final Table f14259c;

    /* renamed from: d */
    private final long f14260d;

    /* renamed from: e */
    private boolean f14261e = true;

    private native void nativeContains(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native long nativeCount(long j, long j2, long j3, long j4);

    private native void nativeEndGroup(long j);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, boolean z);

    private native long nativeFind(long j, long j2);

    private static native long nativeGetFinalizerPtr();

    private native void nativeGreater(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeGroup(long j);

    private native void nativeIsNull(long j, long[] jArr, long[] jArr2);

    private native void nativeLess(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeOr(long j);

    private native String nativeValidateQuery(long j);

    public TableQuery(C7332g context, Table table, long nativeQueryPtr) {
        this.f14258b = context;
        this.f14259c = table;
        this.f14260d = nativeQueryPtr;
        context.mo23771a(this);
    }

    public long getNativePtr() {
        return this.f14260d;
    }

    public long getNativeFinalizerPtr() {
        return f14257a;
    }

    /* renamed from: d */
    public Table mo23695d() {
        return this.f14259c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo23698g() {
        if (!this.f14261e) {
            String invalidMessage = nativeValidateQuery(this.f14260d);
            if (invalidMessage.equals("")) {
                this.f14261e = true;
                return;
            }
            throw new UnsupportedOperationException(invalidMessage);
        }
    }

    /* renamed from: e */
    public TableQuery mo23696e() {
        nativeGroup(this.f14260d);
        this.f14261e = false;
        return this;
    }

    /* renamed from: b */
    public TableQuery mo23689b() {
        nativeEndGroup(this.f14260d);
        this.f14261e = false;
        return this;
    }

    /* renamed from: f */
    public TableQuery mo23697f() {
        nativeOr(this.f14260d);
        this.f14261e = false;
        return this;
    }

    /* renamed from: a */
    public TableQuery mo23686a(long[] columnIndexes, long[] tablePtrs, long value) {
        nativeEqual(this.f14260d, columnIndexes, tablePtrs, value);
        this.f14261e = false;
        return this;
    }

    /* renamed from: b */
    public TableQuery mo23690b(long[] columnIndex, long[] tablePtrs, long value) {
        nativeGreater(this.f14260d, columnIndex, tablePtrs, value);
        this.f14261e = false;
        return this;
    }

    /* renamed from: c */
    public TableQuery mo23693c(long[] columnIndex, long[] tablePtrs, long value) {
        nativeLess(this.f14260d, columnIndex, tablePtrs, value);
        this.f14261e = false;
        return this;
    }

    /* renamed from: a */
    public TableQuery mo23688a(long[] columnIndex, long[] tablePtrs, boolean value) {
        nativeEqual(this.f14260d, columnIndex, tablePtrs, value);
        this.f14261e = false;
        return this;
    }

    /* renamed from: b */
    public TableQuery mo23691b(long[] columnIndexes, long[] tablePtrs, String value, C14053e caseSensitive) {
        nativeEqual(this.f14260d, columnIndexes, tablePtrs, value, caseSensitive.mo43709e());
        this.f14261e = false;
        return this;
    }

    /* renamed from: c */
    public TableQuery mo23694c(long[] columnIndex, long[] tablePtrs, String value, C14053e caseSensitive) {
        nativeNotEqual(this.f14260d, columnIndex, tablePtrs, value, caseSensitive.mo43709e());
        this.f14261e = false;
        return this;
    }

    /* renamed from: a */
    public TableQuery mo23687a(long[] columnIndices, long[] tablePtrs, String value, C14053e caseSensitive) {
        nativeContains(this.f14260d, columnIndices, tablePtrs, value, caseSensitive.mo43709e());
        this.f14261e = false;
        return this;
    }

    /* renamed from: c */
    public long mo23692c() {
        mo23698g();
        return nativeFind(this.f14260d, 0);
    }

    /* renamed from: a */
    public TableQuery mo23685a(long[] columnIndices, long[] tablePtrs) {
        nativeIsNull(this.f14260d, columnIndices, tablePtrs);
        this.f14261e = false;
        return this;
    }

    /* renamed from: a */
    public long mo23684a() {
        mo23698g();
        return nativeCount(this.f14260d, 0, -1, -1);
    }
}
