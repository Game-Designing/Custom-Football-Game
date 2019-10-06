package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzvd extends C9903E<String> implements zzve, RandomAccess {

    /* renamed from: b */
    private static final zzvd f30366b;

    /* renamed from: c */
    private static final zzve f30367c = f30366b;

    /* renamed from: d */
    private final List<Object> f30368d;

    public zzvd() {
        this(10);
    }

    public zzvd(int i) {
        this(new ArrayList<>(i));
    }

    private zzvd(ArrayList<Object> arrayList) {
        this.f30368d = arrayList;
    }

    public final int size() {
        return this.f30368d.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        mo32535a();
        if (collection instanceof zzve) {
            collection = ((zzve) collection).mo32915A();
        }
        boolean addAll = this.f30368d.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        mo32535a();
        this.f30368d.clear();
        this.modCount++;
    }

    /* renamed from: f */
    public final Object mo32917f(int i) {
        return this.f30368d.get(i);
    }

    /* renamed from: a */
    private static String m32559a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzte) {
            return ((zzte) obj).mo32845a();
        }
        return zzuq.m32545c((byte[]) obj);
    }

    /* renamed from: A */
    public final List<?> mo32915A() {
        return Collections.unmodifiableList(this.f30368d);
    }

    /* renamed from: z */
    public final zzve mo32922z() {
        if (mo32546w()) {
            return new zzxg(this);
        }
        return this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        mo32535a();
        return m32559a(this.f30368d.set(i, str));
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
        mo32535a();
        Object remove = this.f30368d.remove(i);
        this.modCount++;
        return m32559a(remove);
    }

    /* renamed from: w */
    public final /* bridge */ /* synthetic */ boolean mo32546w() {
        return super.mo32546w();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        mo32535a();
        this.f30368d.add(i, str);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: e */
    public final /* synthetic */ zzuu mo32721e(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f30368d);
            return new zzvd(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.f30368d.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzte) {
            zzte zzte = (zzte) obj;
            String a = zzte.mo32845a();
            if (zzte.mo32599b()) {
                this.f30368d.set(i, a);
            }
            return a;
        }
        byte[] bArr = (byte[]) obj;
        String c = zzuq.m32545c(bArr);
        if (zzuq.m32544b(bArr)) {
            this.f30368d.set(i, c);
        }
        return c;
    }

    static {
        zzvd zzvd = new zzvd();
        f30366b = zzvd;
        zzvd.mo32545s();
    }
}
