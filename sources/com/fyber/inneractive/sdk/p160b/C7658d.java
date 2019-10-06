package com.fyber.inneractive.sdk.p160b;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.p178k.C7920b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.fyber.inneractive.sdk.b.d */
public final class C7658d {

    /* renamed from: a */
    public Set<C7659a> f15188a;

    /* renamed from: com.fyber.inneractive.sdk.b.d$a */
    public interface C7659a {
        /* renamed from: a */
        boolean mo24091a(InneractiveAdRequest inneractiveAdRequest);

        /* renamed from: b */
        C7920b mo24092b(InneractiveAdRequest inneractiveAdRequest);
    }

    /* renamed from: com.fyber.inneractive.sdk.b.d$b */
    private static class C7660b {

        /* renamed from: a */
        public static C7658d f15189a = new C7658d(0);
    }

    /* synthetic */ C7658d(byte b) {
        this();
    }

    private C7658d() {
        this.f15188a = new HashSet();
    }

    /* renamed from: a */
    public final void mo24090a(C7659a aVar) {
        this.f15188a.add(aVar);
    }
}
