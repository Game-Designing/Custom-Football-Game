package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.C8083c;
import com.google.ads.mediation.C8091d;
import com.google.ads.mediation.C8092e;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import p019d.p271g.p272a.C12720a;

@zzard
public final class zzanu<NETWORK_EXTRAS extends C8092e, SERVER_PARAMETERS extends MediationServerParameters> implements C8083c, C8091d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzamv f24516a;

    public zzanu(zzamv zzamv) {
        this.f24516a = zzamv;
    }

    /* renamed from: a */
    public final void mo24948a(MediationBannerAdapter<?, ?> mediationBannerAdapter, C12720a aVar) {
        String valueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzbad.m26352a(sb.toString());
        zzyt.m31532a();
        if (!zzazt.m26314b()) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", null);
            zzazt.f25042a.post(new C9184Va(this, aVar));
            return;
        }
        try {
            this.f24516a.onAdFailedToLoad(zzaog.m25541a(aVar));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo24955a(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, C12720a aVar) {
        String valueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzbad.m26352a(sb.toString());
        zzyt.m31532a();
        if (!zzazt.m26314b()) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", null);
            zzazt.f25042a.post(new C9226Xa(this, aVar));
            return;
        }
        try {
            this.f24516a.onAdFailedToLoad(zzaog.m25541a(aVar));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }
}
