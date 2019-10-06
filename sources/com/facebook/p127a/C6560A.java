package com.facebook.p127a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* renamed from: com.facebook.a.A */
/* compiled from: PersistedEvents */
class C6560A implements Serializable {

    /* renamed from: a */
    private HashMap<C6593b, List<C6625g>> f11872a = new HashMap<>();

    /* renamed from: com.facebook.a.A$a */
    /* compiled from: PersistedEvents */
    static class C6561a implements Serializable {

        /* renamed from: a */
        private final HashMap<C6593b, List<C6625g>> f11873a;

        private C6561a(HashMap<C6593b, List<C6625g>> events) {
            this.f11873a = events;
        }

        private Object readResolve() {
            return new C6560A(this.f11873a);
        }
    }

    public C6560A() {
    }

    public C6560A(HashMap<C6593b, List<C6625g>> appEventMap) {
        this.f11872a.putAll(appEventMap);
    }

    /* renamed from: a */
    public Set<C6593b> mo19738a() {
        return this.f11872a.keySet();
    }

    /* renamed from: b */
    public List<C6625g> mo19741b(C6593b accessTokenAppIdPair) {
        return (List) this.f11872a.get(accessTokenAppIdPair);
    }

    /* renamed from: a */
    public boolean mo19740a(C6593b accessTokenAppIdPair) {
        return this.f11872a.containsKey(accessTokenAppIdPair);
    }

    /* renamed from: a */
    public void mo19739a(C6593b accessTokenAppIdPair, List<C6625g> appEvents) {
        if (!this.f11872a.containsKey(accessTokenAppIdPair)) {
            this.f11872a.put(accessTokenAppIdPair, appEvents);
        } else {
            ((List) this.f11872a.get(accessTokenAppIdPair)).addAll(appEvents);
        }
    }

    private Object writeReplace() {
        return new C6561a(this.f11872a);
    }
}
