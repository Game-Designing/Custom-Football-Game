package p024io.realm.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/* renamed from: io.realm.internal.NativeObjectReference */
final class NativeObjectReference extends PhantomReference<C7333h> {

    /* renamed from: a */
    private static C7305a f14202a = new C7305a();

    /* renamed from: b */
    private final long f14203b;

    /* renamed from: c */
    private final long f14204c;

    /* renamed from: d */
    private final C7332g f14205d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public NativeObjectReference f14206e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public NativeObjectReference f14207f;

    /* renamed from: io.realm.internal.NativeObjectReference$a */
    private static class C7305a {

        /* renamed from: a */
        NativeObjectReference f14208a;

        private C7305a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public synchronized void mo23596a(NativeObjectReference ref) {
            ref.f14206e = null;
            ref.f14207f = this.f14208a;
            if (this.f14208a != null) {
                this.f14208a.f14206e = ref;
            }
            this.f14208a = ref;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public synchronized void mo23597b(NativeObjectReference ref) {
            NativeObjectReference next = ref.f14207f;
            NativeObjectReference prev = ref.f14206e;
            ref.f14207f = null;
            ref.f14206e = null;
            if (prev != null) {
                prev.f14207f = next;
            } else {
                this.f14208a = next;
            }
            if (next != null) {
                next.f14206e = prev;
            }
        }
    }

    private static native void nativeCleanUp(long j, long j2);

    NativeObjectReference(C7332g context, C7333h referent, ReferenceQueue<? super C7333h> referenceQueue) {
        super(referent, referenceQueue);
        this.f14203b = referent.getNativePtr();
        this.f14204c = referent.getNativeFinalizerPtr();
        this.f14205d = context;
        f14202a.mo23596a(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23595a() {
        synchronized (this.f14205d) {
            nativeCleanUp(this.f14204c, this.f14203b);
        }
        f14202a.mo23597b(this);
    }
}
