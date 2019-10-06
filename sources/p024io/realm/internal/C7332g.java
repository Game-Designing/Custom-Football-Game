package p024io.realm.internal;

import java.lang.ref.ReferenceQueue;

/* renamed from: io.realm.internal.g */
/* compiled from: NativeContext */
public class C7332g {

    /* renamed from: a */
    private static final ReferenceQueue<C7333h> f14311a = new ReferenceQueue<>();

    /* renamed from: b */
    private static final Thread f14312b = new Thread(new C7330d(f14311a));

    /* renamed from: c */
    static final C7332g f14313c = new C7332g();

    static {
        f14312b.setName("RealmFinalizingDaemon");
        f14312b.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23771a(C7333h referent) {
        new NativeObjectReference(this, referent, f14311a);
    }
}
