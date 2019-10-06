package com.fyber.inneractive.sdk.p166g.p167a;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.g.a.b */
abstract class C7757b {

    /* renamed from: a */
    Map<String, String> f15560a = new HashMap();

    /* renamed from: com.fyber.inneractive.sdk.g.a.b$a */
    enum C7758a {
        ;
        

        /* renamed from: a */
        public static final int f15561a = 0;

        /* renamed from: b */
        public static final int f15562b = 0;

        /* renamed from: c */
        public static final int f15563c = 0;

        static {
            f15561a = 1;
            f15562b = 2;
            f15563c = 3;
            f15564d = new int[]{f15561a, f15562b, f15563c};
        }
    }

    /* renamed from: a */
    public abstract int mo24362a(C7756a aVar);

    protected C7757b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24363a(String str, String str2) {
        this.f15560a.put(str, str2);
    }
}
