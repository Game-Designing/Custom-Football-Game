package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.ads.Rp */
final class C9111Rp implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f21672a = this.f21673b.f28120a.iterator();

    /* renamed from: b */
    private final /* synthetic */ zzdqw f21673b;

    C9111Rp(zzdqw zzdqw) {
        this.f21673b = zzdqw;
    }

    public final boolean hasNext() {
        return this.f21672a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f21672a.next();
    }
}
