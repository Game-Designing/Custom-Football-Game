package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzdqw extends AbstractList<String> implements zzdot, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzdot f28120a;

    public zzdqw(zzdot zzdot) {
        this.f28120a = zzdot;
    }

    /* renamed from: g */
    public final Object mo31627g(int i) {
        return this.f28120a.mo31627g(i);
    }

    public final int size() {
        return this.f28120a.size();
    }

    /* renamed from: a */
    public final void mo31625a(zzdmr zzdmr) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new C9091Qp(this, i);
    }

    public final Iterator<String> iterator() {
        return new C9111Rp(this);
    }

    /* renamed from: x */
    public final List<?> mo31632x() {
        return this.f28120a.mo31632x();
    }

    /* renamed from: y */
    public final zzdot mo31633y() {
        return this;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.f28120a.get(i);
    }
}
