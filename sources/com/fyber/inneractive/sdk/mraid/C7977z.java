package com.fyber.inneractive.sdk.mraid;

import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

/* renamed from: com.fyber.inneractive.sdk.mraid.z */
public final class C7977z extends C7970s {

    /* renamed from: a */
    private final boolean f16271a;

    public C7977z(boolean z) {
        this.f16271a = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo24817a() {
        StringBuilder sb = new StringBuilder("viewable: ");
        sb.append(this.f16271a ? "true" : AdultContentAnalytics.UNLOCK);
        return sb.toString();
    }
}
