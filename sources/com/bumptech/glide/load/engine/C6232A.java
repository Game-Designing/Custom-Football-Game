package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.A */
/* compiled from: Jobs */
final class C6232A {

    /* renamed from: a */
    private final Map<C6344g, C6334u<?>> f11002a = new HashMap();

    /* renamed from: b */
    private final Map<C6344g, C6334u<?>> f11003b = new HashMap();

    C6232A() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C6334u<?> mo19095a(C6344g key, boolean onlyRetrieveFromCache) {
        return (C6334u) m11879a(onlyRetrieveFromCache).get(key);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19096a(C6344g key, C6334u<?> job) {
        m11879a(job.mo19293f()).put(key, job);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo19097b(C6344g key, C6334u<?> expected) {
        Map<Key, EngineJob<?>> jobMap = m11879a(expected.mo19293f());
        if (expected.equals(jobMap.get(key))) {
            jobMap.remove(key);
        }
    }

    /* renamed from: a */
    private Map<C6344g, C6334u<?>> m11879a(boolean onlyRetrieveFromCache) {
        return onlyRetrieveFromCache ? this.f11003b : this.f11002a;
    }
}
