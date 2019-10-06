package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzbfq extends zzawv {

    /* renamed from: d */
    final zzbdf f25272d;

    /* renamed from: e */
    final zzbft f25273e;

    /* renamed from: f */
    private final String f25274f;

    /* renamed from: g */
    private final String[] f25275g;

    zzbfq(zzbdf zzbdf, zzbft zzbft, String str, String[] strArr) {
        this.f25272d = zzbdf;
        this.f25273e = zzbft;
        this.f25274f = str;
        this.f25275g = strArr;
        zzk.zzmc().mo30536a(this);
    }

    /* renamed from: a */
    public final void mo26663a() {
        try {
            this.f25273e.mo30547a(this.f25274f, this.f25275g);
        } finally {
            zzaxi.f24961a.post(new C9769ve(this));
        }
    }
}
