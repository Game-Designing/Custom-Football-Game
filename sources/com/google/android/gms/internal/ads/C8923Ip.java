package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Ip */
final class C8923Ip implements Iterator<Entry<K, V>> {

    /* renamed from: a */
    private int f21264a;

    /* renamed from: b */
    private boolean f21265b;

    /* renamed from: c */
    private Iterator<Entry<K, V>> f21266c;

    /* renamed from: d */
    private final /* synthetic */ C8755Ap f21267d;

    private C8923Ip(C8755Ap ap) {
        this.f21267d = ap;
        this.f21264a = -1;
    }

    public final boolean hasNext() {
        if (this.f21264a + 1 < this.f21267d.f20465b.size() || (!this.f21267d.f20466c.isEmpty() && m22713a().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.f21265b) {
            this.f21265b = false;
            this.f21267d.m22291f();
            if (this.f21264a < this.f21267d.f20465b.size()) {
                C8755Ap ap = this.f21267d;
                int i = this.f21264a;
                this.f21264a = i - 1;
                ap.m22288c(i);
                return;
            }
            m22713a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* renamed from: a */
    private final Iterator<Entry<K, V>> m22713a() {
        if (this.f21266c == null) {
            this.f21266c = this.f21267d.f20466c.entrySet().iterator();
        }
        return this.f21266c;
    }

    public final /* synthetic */ Object next() {
        this.f21265b = true;
        int i = this.f21264a + 1;
        this.f21264a = i;
        if (i < this.f21267d.f20465b.size()) {
            return (Entry) this.f21267d.f20465b.get(this.f21264a);
        }
        return (Entry) m22713a().next();
    }

    /* synthetic */ C8923Ip(C8755Ap ap, C8776Bp bp) {
        this(ap);
    }
}
