package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* renamed from: com.google.android.gms.internal.ads.Ng */
final /* synthetic */ class C9019Ng implements zzbtu {

    /* renamed from: a */
    private final String f21510a;

    /* renamed from: b */
    private final String f21511b;

    C9019Ng(String str, String str2) {
        this.f21510a = str;
        this.f21511b = str2;
    }

    /* renamed from: a */
    public final void mo28017a(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.f21510a, this.f21511b);
    }
}
