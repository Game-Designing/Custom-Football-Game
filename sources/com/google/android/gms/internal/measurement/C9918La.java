package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.La */
final class C9918La extends C9929Ra {

    /* renamed from: b */
    private final /* synthetic */ C9912Ia f30017b;

    private C9918La(C9912Ia ia) {
        this.f30017b = ia;
        super(ia, null);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new C9916Ka(this.f30017b, null);
    }

    /* synthetic */ C9918La(C9912Ia ia, C9914Ja ja) {
        this(ia);
    }
}
