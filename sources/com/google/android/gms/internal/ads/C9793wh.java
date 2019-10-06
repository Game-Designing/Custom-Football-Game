package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.wh */
final class C9793wh implements zzaho<Object> {

    /* renamed from: a */
    private final /* synthetic */ zzagd f23408a;

    /* renamed from: b */
    private final /* synthetic */ zzbzq f23409b;

    C9793wh(zzbzq zzbzq, zzagd zzagd) {
        this.f23409b = zzbzq;
        this.f23408a = zzagd;
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        try {
            this.f23409b.f26215f = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException e) {
            zzbad.m26355b("Failed to call parse unconfirmedClickTimestamp.");
        }
        this.f23409b.f26214e = (String) map.get("id");
        String str = (String) map.get("asset_id");
        zzagd zzagd = this.f23408a;
        if (zzagd == null) {
            zzbad.m26352a("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzagd.onUnconfirmedClickReceived(str);
        } catch (RemoteException e2) {
            zzbad.m26360d("#007 Could not call remote method.", e2);
        }
    }
}
