package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.ads.tl */
final class C9734tl implements zzcuz<Bundle> {

    /* renamed from: a */
    private final String f23026a;

    /* renamed from: b */
    private final Bundle f23027b;

    private C9734tl(String str, Bundle bundle) {
        this.f23026a = str;
        this.f23027b = bundle;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("consent_string", this.f23026a);
        bundle.putBundle("iab_consent_info", this.f23027b);
    }
}
