package com.bumptech.glide.p107h;

/* renamed from: com.bumptech.glide.h.h */
/* compiled from: MultiClassKey */
public class C6023h {

    /* renamed from: a */
    private Class<?> f10661a;

    /* renamed from: b */
    private Class<?> f10662b;

    /* renamed from: c */
    private Class<?> f10663c;

    public C6023h() {
    }

    public C6023h(Class<?> first, Class<?> second) {
        mo18826a(first, second);
    }

    public C6023h(Class<?> first, Class<?> second, Class<?> third) {
        mo18827a(first, second, third);
    }

    /* renamed from: a */
    public void mo18826a(Class<?> first, Class<?> second) {
        mo18827a(first, second, null);
    }

    /* renamed from: a */
    public void mo18827a(Class<?> first, Class<?> second, Class<?> third) {
        this.f10661a = first;
        this.f10662b = second;
        this.f10663c = third;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiClassKey{first=");
        sb.append(this.f10661a);
        sb.append(", second=");
        sb.append(this.f10662b);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C6023h that = (C6023h) o;
        if (this.f10661a.equals(that.f10661a) && this.f10662b.equals(that.f10662b) && C6026k.m11286b((Object) this.f10663c, (Object) that.f10663c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = ((this.f10661a.hashCode() * 31) + this.f10662b.hashCode()) * 31;
        Class<?> cls = this.f10663c;
        return result + (cls != null ? cls.hashCode() : 0);
    }
}
