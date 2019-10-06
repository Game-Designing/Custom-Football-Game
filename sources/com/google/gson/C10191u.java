package com.google.gson;

import com.google.gson.p192b.C10164x;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.gson.u */
/* compiled from: JsonObject */
public final class C10191u extends C10188s {

    /* renamed from: a */
    private final C10164x<String, C10188s> f30875a = new C10164x<>();

    /* renamed from: a */
    public void mo33467a(String property, C10188s value) {
        if (value == null) {
            value = C10190t.f30874a;
        }
        this.f30875a.put(property, value);
    }

    /* renamed from: a */
    public void mo33470a(String property, String value) {
        mo33467a(property, m33168a((Object) value));
    }

    /* renamed from: a */
    public void mo33469a(String property, Number value) {
        mo33467a(property, m33168a((Object) value));
    }

    /* renamed from: a */
    public void mo33468a(String property, Boolean value) {
        mo33467a(property, m33168a((Object) value));
    }

    /* renamed from: a */
    private C10188s m33168a(Object value) {
        return value == null ? C10190t.f30874a : new C10192v(value);
    }

    /* renamed from: m */
    public Set<Entry<String, C10188s>> mo33476m() {
        return this.f30875a.entrySet();
    }

    /* renamed from: d */
    public boolean mo33473d(String memberName) {
        return this.f30875a.containsKey(memberName);
    }

    /* renamed from: a */
    public C10188s mo33466a(String memberName) {
        return (C10188s) this.f30875a.get(memberName);
    }

    /* renamed from: b */
    public C10185p mo33471b(String memberName) {
        return (C10185p) this.f30875a.get(memberName);
    }

    /* renamed from: c */
    public C10191u mo33472c(String memberName) {
        return (C10191u) this.f30875a.get(memberName);
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C10191u) && ((C10191u) o).f30875a.equals(this.f30875a));
    }

    public int hashCode() {
        return this.f30875a.hashCode();
    }
}
