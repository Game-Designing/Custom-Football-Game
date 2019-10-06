package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzbts<ListenerT> {

    /* renamed from: a */
    private final Map<ListenerT, Executor> f25858a = new HashMap();

    protected zzbts(Set<zzbuz<ListenerT>> set) {
        m27767a(set);
    }

    /* renamed from: a */
    public final synchronized void mo30896a(zzbuz<ListenerT> zzbuz) {
        mo30897a(zzbuz.f25900a, zzbuz.f25901b);
    }

    /* renamed from: a */
    public final synchronized void mo30897a(ListenerT listenert, Executor executor) {
        this.f25858a.put(listenert, executor);
    }

    /* renamed from: a */
    private final synchronized void m27767a(Set<zzbuz<ListenerT>> set) {
        for (zzbuz a : set) {
            mo30896a(a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized void mo30895a(zzbtu<ListenerT> zzbtu) {
        for (Entry entry : this.f25858a.entrySet()) {
            ((Executor) entry.getValue()).execute(new C9040Og(zzbtu, entry.getKey()));
        }
    }
}
