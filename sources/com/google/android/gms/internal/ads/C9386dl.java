package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: com.google.android.gms.internal.ads.dl */
final /* synthetic */ class C9386dl implements zzbal {

    /* renamed from: a */
    private final zzarx f22186a;

    C9386dl(zzarx zzarx) {
        this.f22186a = zzarx;
    }

    /* renamed from: a */
    public final zzbbh mo26658a(Object obj) {
        return zzbar.m26376a(new zzcrc(new JsonReader(new InputStreamReader((InputStream) obj))).mo31250a(this.f22186a.f24715a));
    }
}
