package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzdos extends C9565lo<String> implements zzdot, RandomAccess {

    /* renamed from: b */
    private static final zzdos f28108b;

    /* renamed from: c */
    private static final zzdot f28109c = f28108b;

    /* renamed from: d */
    private final List<Object> f28110d;

    public zzdos() {
        this(10);
    }

    public zzdos(int i) {
        this(new ArrayList<>(i));
    }

    private zzdos(ArrayList<Object> arrayList) {
        this.f28110d = arrayList;
    }

    public final int size() {
        return this.f28110d.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        mo29061a();
        if (collection instanceof zzdot) {
            collection = ((zzdot) collection).mo31632x();
        }
        boolean addAll = this.f28110d.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        mo29061a();
        this.f28110d.clear();
        this.modCount++;
    }

    /* renamed from: a */
    public final void mo31625a(zzdmr zzdmr) {
        mo29061a();
        this.f28110d.add(zzdmr);
        this.modCount++;
    }

    /* renamed from: g */
    public final Object mo31627g(int i) {
        return this.f28110d.get(i);
    }

    /* renamed from: a */
    private static String m29943a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdmr) {
            return ((zzdmr) obj).mo31540b();
        }
        return zzdod.m29920c((byte[]) obj);
    }

    /* renamed from: x */
    public final List<?> mo31632x() {
        return Collections.unmodifiableList(this.f28110d);
    }

    /* renamed from: y */
    public final zzdot mo31633y() {
        if (mo29067t()) {
            return new zzdqw(this);
        }
        return this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        mo29061a();
        return m29943a(this.f28110d.set(i, str));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        mo29061a();
        Object remove = this.f28110d.remove(i);
        this.modCount++;
        return m29943a(remove);
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ boolean mo29067t() {
        return super.mo29067t();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        mo29061a();
        this.f28110d.add(i, str);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: b */
    public final /* synthetic */ zzdoj mo28270b(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f28110d);
            return new zzdos(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.f28110d.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdmr) {
            zzdmr zzdmr = (zzdmr) obj;
            String b = zzdmr.mo31540b();
            if (zzdmr.mo29330c()) {
                this.f28110d.set(i, b);
            }
            return b;
        }
        byte[] bArr = (byte[]) obj;
        String c = zzdod.m29920c(bArr);
        if (zzdod.m29919b(bArr)) {
            this.f28110d.set(i, c);
        }
        return c;
    }

    static {
        zzdos zzdos = new zzdos();
        f28108b = zzdos;
        zzdos.mo29068u();
    }
}
