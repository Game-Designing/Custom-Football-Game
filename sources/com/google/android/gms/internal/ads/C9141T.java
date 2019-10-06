package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

/* renamed from: com.google.android.gms.internal.ads.T */
final class C9141T implements BaseConnectionCallbacks {

    /* renamed from: a */
    private final /* synthetic */ zzbbr f21761a;

    /* renamed from: b */
    private final /* synthetic */ zzaii f21762b;

    C9141T(zzaii zzaii, zzbbr zzbbr) {
        this.f21762b = zzaii;
        this.f21761a = zzbbr;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.f21761a.mo30338b(this.f21762b.f24363a.mo27780j());
        } catch (DeadObjectException e) {
            this.f21761a.mo30337a(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        zzbbr zzbbr = this.f21761a;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbbr.mo30337a(new RuntimeException(sb.toString()));
    }
}
