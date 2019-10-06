package p320f.p321a.p327d.p328a;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p320f.p321a.p325b.C13194b;

/* renamed from: f.a.d.a.a */
/* compiled from: ArrayCompositeDisposable */
public final class C13216a extends AtomicReferenceArray<C13194b> implements C13194b {
    public C13216a(int capacity) {
        super(capacity);
    }

    /* renamed from: a */
    public boolean mo42273a(int index, C13194b resource) {
        C13194b o;
        do {
            o = (C13194b) get(index);
            if (o == C13218c.DISPOSED) {
                resource.dispose();
                return false;
            }
        } while (!compareAndSet(index, o, resource));
        if (o != null) {
            o.dispose();
        }
        return true;
    }

    public void dispose() {
        if (get(0) != C13218c.DISPOSED) {
            int s = length();
            for (int i = 0; i < s; i++) {
                C13194b o = (C13194b) get(i);
                C13218c cVar = C13218c.DISPOSED;
                if (o != cVar) {
                    C13194b o2 = (C13194b) getAndSet(i, cVar);
                    if (!(o2 == C13218c.DISPOSED || o2 == null)) {
                        o2.dispose();
                    }
                }
            }
        }
    }
}
