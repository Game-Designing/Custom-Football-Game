package com.flurry.sdk;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.qc */
public final class C7584qc<T> extends WeakReference<T> {
    public C7584qc(T t) {
        super(t);
    }

    public final int hashCode() {
        Object obj = get();
        if (obj == null) {
            return super.hashCode();
        }
        return obj.hashCode();
    }

    public final boolean equals(Object obj) {
        Object obj2 = get();
        if (obj instanceof Reference) {
            return obj2.equals(((Reference) obj).get());
        }
        return obj2.equals(obj);
    }
}
