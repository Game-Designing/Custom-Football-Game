package p024io.realm.internal;

/* renamed from: io.realm.internal.LinkView */
public class LinkView implements C7333h {

    /* renamed from: a */
    private static final long f14197a = nativeGetFinalizerPtr();

    /* renamed from: b */
    private final C7332g f14198b;

    /* renamed from: c */
    final Table f14199c;

    /* renamed from: d */
    final long f14200d;

    /* renamed from: e */
    private final long f14201e;

    public static native void nativeAdd(long j, long j2);

    public static native void nativeClear(long j);

    private static native long nativeGetFinalizerPtr();

    private native long nativeGetTargetRowIndex(long j, long j2);

    private native long nativeGetTargetTable(long j);

    private native void nativeInsert(long j, long j2, long j3);

    private native boolean nativeIsAttached(long j);

    private native void nativeRemove(long j, long j2);

    private native void nativeSet(long j, long j2, long j3);

    private native long nativeSize(long j);

    public LinkView(C7332g context, Table parent, long columnIndexInParent, long nativeLinkViewPtr) {
        this.f14198b = context;
        this.f14199c = parent;
        this.f14200d = columnIndexInParent;
        this.f14201e = nativeLinkViewPtr;
        context.mo23771a(this);
    }

    public long getNativePtr() {
        return this.f14201e;
    }

    public long getNativeFinalizerPtr() {
        return f14197a;
    }

    /* renamed from: b */
    public long mo23589b(long linkViewIndex) {
        return nativeGetTargetRowIndex(this.f14201e, linkViewIndex);
    }

    /* renamed from: a */
    public void mo23587a(long rowIndex) {
        m15892e();
        nativeAdd(this.f14201e, rowIndex);
    }

    /* renamed from: a */
    public void mo23588a(long pos, long rowIndex) {
        m15892e();
        nativeInsert(this.f14201e, pos, rowIndex);
    }

    /* renamed from: b */
    public void mo23591b(long pos, long rowIndex) {
        m15892e();
        nativeSet(this.f14201e, pos, rowIndex);
    }

    /* renamed from: c */
    public void mo23592c(long pos) {
        m15892e();
        nativeRemove(this.f14201e, pos);
    }

    /* renamed from: a */
    public void mo23586a() {
        m15892e();
        nativeClear(this.f14201e);
    }

    /* renamed from: d */
    public long mo23594d() {
        return nativeSize(this.f14201e);
    }

    /* renamed from: c */
    public boolean mo23593c() {
        return nativeIsAttached(this.f14201e);
    }

    /* renamed from: b */
    public Table mo23590b() {
        return new Table(this.f14199c, nativeGetTargetTable(this.f14201e));
    }

    /* renamed from: e */
    private void m15892e() {
        if (this.f14199c.mo23673i()) {
            throw new IllegalStateException("Changing Realm data can only be done from inside a write transaction.");
        }
    }
}
