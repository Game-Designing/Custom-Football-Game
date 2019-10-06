package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.ya */
final class C10014ya<T> implements C9906Fa<T> {

    /* renamed from: a */
    private final zzvv f30206a;

    /* renamed from: b */
    private final C9939Wa<?, ?> f30207b;

    /* renamed from: c */
    private final boolean f30208c;

    /* renamed from: d */
    private final C9938W<?> f30209d;

    private C10014ya(C9939Wa<?, ?> wa, C9938W<?> w, zzvv zzvv) {
        this.f30207b = wa;
        this.f30208c = w.mo32664a(zzvv);
        this.f30209d = w;
        this.f30206a = zzvv;
    }

    /* renamed from: a */
    static <T> C10014ya<T> m32247a(C9939Wa<?, ?> wa, C9938W<?> w, zzvv zzvv) {
        return new C10014ya<>(wa, w, zzvv);
    }

    /* renamed from: b */
    public final boolean mo32556b(T t, T t2) {
        if (!this.f30207b.mo32670b(t).equals(this.f30207b.mo32670b(t2))) {
            return false;
        }
        if (this.f30208c) {
            return this.f30209d.mo32662a((Object) t).equals(this.f30209d.mo32662a((Object) t2));
        }
        return true;
    }

    /* renamed from: a */
    public final int mo32552a(T t) {
        int hashCode = this.f30207b.mo32670b(t).hashCode();
        if (this.f30208c) {
            return (hashCode * 53) + this.f30209d.mo32662a((Object) t).hashCode();
        }
        return hashCode;
    }

    /* renamed from: a */
    public final void mo32554a(T t, T t2) {
        C9910Ha.m31800a(this.f30207b, t, t2);
        if (this.f30208c) {
            C9910Ha.m31799a(this.f30209d, t, t2);
        }
    }

    /* renamed from: a */
    public final void mo32553a(T t, C9986lb lbVar) throws IOException {
        Iterator e = this.f30209d.mo32662a((Object) t).mo32690e();
        while (e.hasNext()) {
            Entry entry = (Entry) e.next();
            zzuh zzuh = (zzuh) entry.getKey();
            if (zzuh.mo32890r() != zzxx.MESSAGE || zzuh.mo32889q() || zzuh.mo32888p()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof C9970ga) {
                lbVar.mo32625a(zzuh.mo32886h(), (Object) ((C9970ga) entry).mo32727a().mo32912a());
            } else {
                lbVar.mo32625a(zzuh.mo32886h(), entry.getValue());
            }
        }
        C9939Wa<?, ?> wa = this.f30207b;
        wa.mo32672b(wa.mo32670b(t), lbVar);
    }

    /* renamed from: d */
    public final void mo32558d(T t) {
        this.f30207b.mo32674d(t);
        this.f30209d.mo32666c(t);
    }

    /* renamed from: c */
    public final boolean mo32557c(T t) {
        return this.f30209d.mo32662a((Object) t).mo32689d();
    }

    /* renamed from: b */
    public final int mo32555b(T t) {
        C9939Wa<?, ?> wa = this.f30207b;
        int c = wa.mo32673c(wa.mo32670b(t)) + 0;
        if (this.f30208c) {
            return c + this.f30209d.mo32662a((Object) t).mo32695i();
        }
        return c;
    }
}
