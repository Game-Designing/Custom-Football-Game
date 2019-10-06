package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzcex implements zzczz {

    /* renamed from: a */
    private Map<zzczs, zzcez> f26503a;

    /* renamed from: b */
    private zzwj f26504b;

    zzcex(zzwj zzwj, Map<zzczs, zzcez> map) {
        this.f26503a = map;
        this.f26504b = zzwj;
    }

    /* renamed from: c */
    public final void mo31139c(zzczs zzczs, String str) {
    }

    /* renamed from: b */
    public final void mo31138b(zzczs zzczs, String str) {
        if (this.f26503a.containsKey(zzczs)) {
            this.f26504b.mo32330a(((zzcez) this.f26503a.get(zzczs)).f26505a);
        }
    }

    /* renamed from: a */
    public final void mo31137a(zzczs zzczs, String str, Throwable th) {
        if (this.f26503a.containsKey(zzczs)) {
            this.f26504b.mo32330a(((zzcez) this.f26503a.get(zzczs)).f26507c);
        }
    }

    /* renamed from: a */
    public final void mo31136a(zzczs zzczs, String str) {
        if (this.f26503a.containsKey(zzczs)) {
            this.f26504b.mo32330a(((zzcez) this.f26503a.get(zzczs)).f26506b);
        }
    }
}
