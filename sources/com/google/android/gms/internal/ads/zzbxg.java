package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;

public final class zzbxg implements zzbrl, zzbur {

    /* renamed from: a */
    private final zzavf f25988a;

    /* renamed from: b */
    private final Context f25989b;

    /* renamed from: c */
    private final zzavg f25990c;

    /* renamed from: d */
    private final View f25991d;

    /* renamed from: e */
    private String f25992e;

    /* renamed from: f */
    private final int f25993f;

    public zzbxg(zzavf zzavf, Context context, zzavg zzavg, View view, int i) {
        this.f25988a = zzavf;
        this.f25989b = context;
        this.f25990c = zzavg;
        this.f25991d = view;
        this.f25993f = i;
    }

    public final void onAdOpened() {
        View view = this.f25991d;
        if (!(view == null || this.f25992e == null)) {
            this.f25990c.mo30128c(view.getContext(), this.f25992e);
        }
        this.f25988a.mo30119f(true);
    }

    public final void onAdClosed() {
        this.f25988a.mo30119f(false);
    }

    /* renamed from: F */
    public final void mo30918F() {
        this.f25992e = this.f25990c.mo30135g(this.f25989b);
        String valueOf = String.valueOf(this.f25992e);
        String valueOf2 = String.valueOf(this.f25993f == 7 ? "/Rewarded" : "/Interstitial");
        this.f25992e = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final void onAdLeftApplication() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void onRewardedVideoCompleted() {
    }

    /* renamed from: a */
    public final void mo30729a(zzasr zzasr, String str, String str2) {
        if (this.f25990c.mo30134f(this.f25989b)) {
            try {
                this.f25990c.mo30123a(this.f25989b, this.f25990c.mo30127c(this.f25989b), this.f25988a.mo30118C(), zzasr.getType(), zzasr.getAmount());
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception to get reward item.", e);
            }
        }
    }
}
