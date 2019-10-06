package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.gson.p */
/* compiled from: JsonArray */
public final class C10185p extends C10188s implements Iterable<C10188s> {

    /* renamed from: a */
    private final List<C10188s> f30872a = new ArrayList();

    /* renamed from: a */
    public void mo33432a(String string) {
        this.f30872a.add(string == null ? C10190t.f30874a : new C10192v(string));
    }

    /* renamed from: a */
    public void mo33431a(C10188s element) {
        if (element == null) {
            element = C10190t.f30874a;
        }
        this.f30872a.add(element);
    }

    public int size() {
        return this.f30872a.size();
    }

    public Iterator<C10188s> iterator() {
        return this.f30872a.iterator();
    }

    public C10188s get(int i) {
        return (C10188s) this.f30872a.get(i);
    }

    /* renamed from: h */
    public String mo33439h() {
        if (this.f30872a.size() == 1) {
            return ((C10188s) this.f30872a.get(0)).mo33439h();
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public float mo33434b() {
        if (this.f30872a.size() == 1) {
            return ((C10188s) this.f30872a.get(0)).mo33434b();
        }
        throw new IllegalStateException();
    }

    /* renamed from: g */
    public long mo33437g() {
        if (this.f30872a.size() == 1) {
            return ((C10188s) this.f30872a.get(0)).mo33437g();
        }
        throw new IllegalStateException();
    }

    /* renamed from: c */
    public int mo33435c() {
        if (this.f30872a.size() == 1) {
            return ((C10188s) this.f30872a.get(0)).mo33435c();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public boolean mo33433a() {
        if (this.f30872a.size() == 1) {
            return ((C10188s) this.f30872a.get(0)).mo33433a();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C10185p) && ((C10185p) o).f30872a.equals(this.f30872a));
    }

    public int hashCode() {
        return this.f30872a.hashCode();
    }
}
