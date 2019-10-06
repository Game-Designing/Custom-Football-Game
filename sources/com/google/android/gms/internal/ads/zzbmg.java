package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzbmg {

    /* renamed from: a */
    private final String f25537a;

    /* renamed from: b */
    private final zzaly f25538b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Executor f25539c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzbmn f25540d;

    /* renamed from: e */
    private final zzaho<Object> f25541e = new C9018Nf(this);

    /* renamed from: f */
    private final zzaho<Object> f25542f = new C9060Pf(this);

    public zzbmg(String str, zzaly zzaly, Executor executor) {
        this.f25537a = str;
        this.f25538b = zzaly;
        this.f25539c = executor;
    }

    /* renamed from: a */
    public final void mo30737a(zzbmn zzbmn) {
        this.f25538b.mo29811a("/updateActiveView", this.f25541e);
        this.f25538b.mo29811a("/untrackActiveViewUnit", this.f25542f);
        this.f25540d = zzbmn;
    }

    /* renamed from: a */
    public final void mo30736a(zzbgz zzbgz) {
        zzbgz.mo28726a("/updateActiveView", this.f25541e);
        zzbgz.mo28726a("/untrackActiveViewUnit", this.f25542f);
    }

    /* renamed from: b */
    public final void mo30738b(zzbgz zzbgz) {
        zzbgz.mo28739b("/updateActiveView", this.f25541e);
        zzbgz.mo28739b("/untrackActiveViewUnit", this.f25542f);
    }

    /* renamed from: a */
    public final void mo30735a() {
        this.f25538b.mo29812b("/updateActiveView", this.f25541e);
        this.f25538b.mo29812b("/untrackActiveViewUnit", this.f25542f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m27247a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(this.f25537a)) {
            return false;
        }
        return true;
    }
}
