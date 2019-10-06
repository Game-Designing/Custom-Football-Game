package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.io */
final class C9499io extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f22568a;

    public C9499io(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f22568a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.f22568a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != C9499io.class) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C9499io ioVar = (C9499io) obj;
        if (this.f22568a == ioVar.f22568a && get() == ioVar.get()) {
            return true;
        }
        return false;
    }
}
