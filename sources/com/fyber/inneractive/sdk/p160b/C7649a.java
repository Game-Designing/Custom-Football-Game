package com.fyber.inneractive.sdk.p160b;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.p163d.C7718b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.fyber.inneractive.sdk.b.a */
public final class C7649a {

    /* renamed from: a */
    public Set<C7650a> f15182a;

    /* renamed from: com.fyber.inneractive.sdk.b.a$a */
    public interface C7650a {
        /* renamed from: a */
        C7718b mo24080a();

        /* renamed from: a */
        boolean mo24081a(InneractiveAdSpot inneractiveAdSpot);
    }

    /* renamed from: com.fyber.inneractive.sdk.b.a$b */
    private static class C7651b {

        /* renamed from: a */
        public static C7649a f15183a = new C7649a(0);
    }

    /* synthetic */ C7649a(byte b) {
        this();
    }

    private C7649a() {
        this.f15182a = new HashSet();
    }

    /* renamed from: a */
    public final C7718b mo24078a(InneractiveAdSpot inneractiveAdSpot) {
        for (C7650a aVar : this.f15182a) {
            if (aVar.mo24081a(inneractiveAdSpot)) {
                return aVar.mo24080a();
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo24079a(C7650a aVar) {
        this.f15182a.add(aVar);
    }
}
