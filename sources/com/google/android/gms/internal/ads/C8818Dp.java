package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Dp */
final class C8818Dp extends C8944Jp {

    /* renamed from: b */
    private final /* synthetic */ C8755Ap f20760b;

    private C8818Dp(C8755Ap ap) {
        this.f20760b = ap;
        super(ap, null);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new C8797Cp(this.f20760b, null);
    }

    /* synthetic */ C8818Dp(C8755Ap ap, C8776Bp bp) {
        this(ap);
    }
}
