package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.p179l.C7930d.C7943e;

/* renamed from: com.fyber.inneractive.sdk.mraid.u */
public final class C7972u extends C7970s {

    /* renamed from: a */
    private final C7943e f16256a;

    private C7972u(C7943e eVar) {
        this.f16256a = eVar;
    }

    /* renamed from: a */
    public static C7972u m18000a(C7943e eVar) {
        return new C7972u(eVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo24817a() {
        StringBuilder sb = new StringBuilder("placementType: '");
        sb.append(this.f16256a.toString().toLowerCase());
        sb.append("'");
        return sb.toString();
    }
}
