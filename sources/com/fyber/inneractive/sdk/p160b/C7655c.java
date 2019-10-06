package com.fyber.inneractive.sdk.p160b;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.p163d.C7719c;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.fyber.inneractive.sdk.b.c */
public final class C7655c {

    /* renamed from: a */
    public Set<C7656a> f15186a;

    /* renamed from: com.fyber.inneractive.sdk.b.c$a */
    public interface C7656a {
        /* renamed from: a */
        boolean mo24088a(InneractiveAdSpot inneractiveAdSpot);

        /* renamed from: b */
        C7719c mo24089b(InneractiveAdSpot inneractiveAdSpot);
    }

    /* renamed from: com.fyber.inneractive.sdk.b.c$b */
    private static class C7657b {

        /* renamed from: a */
        public static C7655c f15187a = new C7655c(0);
    }

    /* synthetic */ C7655c(byte b) {
        this();
    }

    private C7655c() {
        this.f15186a = new HashSet();
    }

    /* renamed from: a */
    public final C7719c mo24086a(InneractiveAdSpot inneractiveAdSpot) {
        for (C7656a aVar : this.f15186a) {
            if (aVar.mo24088a(inneractiveAdSpot)) {
                return aVar.mo24089b(inneractiveAdSpot);
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo24087a(C7656a aVar) {
        this.f15186a.add(aVar);
    }
}
