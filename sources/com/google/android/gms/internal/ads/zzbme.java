package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzbme implements zzbrl, zzbrw, zzbsr, zzxr {

    /* renamed from: a */
    private final zzcxu f25529a;

    /* renamed from: b */
    private final zzcxm f25530b;

    /* renamed from: c */
    private final zzdae f25531c;

    /* renamed from: d */
    private boolean f25532d;

    /* renamed from: e */
    private boolean f25533e;

    public zzbme(zzcxu zzcxu, zzcxm zzcxm, zzdae zzdae) {
        this.f25529a = zzcxu;
        this.f25530b = zzcxm;
        this.f25531c = zzdae;
    }

    public final synchronized void onAdLoaded() {
        if (this.f25532d) {
            ArrayList arrayList = new ArrayList(this.f25530b.f27553d);
            arrayList.addAll(this.f25530b.f27555f);
            this.f25531c.mo31341a(this.f25529a, this.f25530b, true, (List<String>) arrayList);
        } else {
            this.f25531c.mo31339a(this.f25529a, this.f25530b, this.f25530b.f27562m);
            this.f25531c.mo31339a(this.f25529a, this.f25530b, this.f25530b.f27555f);
        }
        this.f25532d = true;
    }

    public final void onAdClicked() {
        zzdae zzdae = this.f25531c;
        zzcxu zzcxu = this.f25529a;
        zzcxm zzcxm = this.f25530b;
        zzdae.mo31339a(zzcxu, zzcxm, zzcxm.f27552c);
    }

    public final synchronized void onAdImpression() {
        if (!this.f25533e) {
            this.f25531c.mo31339a(this.f25529a, this.f25530b, this.f25530b.f27553d);
            this.f25533e = true;
        }
    }

    public final void onAdOpened() {
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    /* renamed from: a */
    public final void mo30729a(zzasr zzasr, String str, String str2) {
        zzdae zzdae = this.f25531c;
        zzcxu zzcxu = this.f25529a;
        zzcxm zzcxm = this.f25530b;
        zzdae.mo31340a(zzcxu, zzcxm, zzcxm.f27557h, zzasr);
    }

    public final void onRewardedVideoStarted() {
        zzdae zzdae = this.f25531c;
        zzcxu zzcxu = this.f25529a;
        zzcxm zzcxm = this.f25530b;
        zzdae.mo31339a(zzcxu, zzcxm, zzcxm.f27556g);
    }

    public final void onRewardedVideoCompleted() {
        zzdae zzdae = this.f25531c;
        zzcxu zzcxu = this.f25529a;
        zzcxm zzcxm = this.f25530b;
        zzdae.mo31339a(zzcxu, zzcxm, zzcxm.f27558i);
    }
}
