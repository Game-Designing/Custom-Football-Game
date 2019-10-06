package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzbvx extends zzbpc {

    /* renamed from: f */
    private final Context f25917f;

    /* renamed from: g */
    private final zzbup f25918g;

    /* renamed from: h */
    private final zzbwz f25919h;

    /* renamed from: i */
    private final zzbpv f25920i;

    /* renamed from: j */
    private final zzdan f25921j;

    /* renamed from: k */
    private boolean f25922k = false;

    zzbvx(Context context, zzbry zzbry, zzbup zzbup, zzbwz zzbwz, zzbpv zzbpv, zzdan zzdan) {
        this.f25917f = context;
        this.f25748c = zzbry;
        this.f25918g = zzbup;
        this.f25919h = zzbwz;
        this.f25920i = zzbpv;
        this.f25921j = zzdan;
    }

    /* renamed from: a */
    public final void mo30931a(boolean z) {
        this.f25918g.mo30918F();
        this.f25919h.mo28355a(z, this.f25917f);
        this.f25922k = true;
    }

    /* renamed from: g */
    public final zzbry mo30933g() {
        return this.f25748c;
    }

    /* renamed from: f */
    public final boolean mo30932f() {
        return this.f25920i.mo30863a();
    }

    /* renamed from: h */
    public final boolean mo30934h() {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23963La)).booleanValue()) {
            zzk.zzlg();
            if (zzaxi.m26139g(this.f25917f)) {
                zzbad.m26359d("It is not recommended to show an interstitial when app is not in foreground.");
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23969Ma)).booleanValue()) {
                    this.f25921j.mo31351a(this.f25746a.f27596b.f27591b.f27580b);
                }
                return false;
            }
        }
        if (!this.f25922k) {
            return true;
        }
        return false;
    }
}
