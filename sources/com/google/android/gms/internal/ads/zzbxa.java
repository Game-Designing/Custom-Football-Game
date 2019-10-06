package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;

public final class zzbxa implements zzo, zzbsr {

    /* renamed from: a */
    private final Context f25971a;

    /* renamed from: b */
    private final zzbgz f25972b;

    /* renamed from: c */
    private final zzcxm f25973c;

    /* renamed from: d */
    private final zzbai f25974d;

    /* renamed from: e */
    private final int f25975e;
    @VisibleForTesting

    /* renamed from: f */
    private IObjectWrapper f25976f;

    public zzbxa(Context context, zzbgz zzbgz, zzcxm zzcxm, zzbai zzbai, int i) {
        this.f25971a = context;
        this.f25972b = zzbgz;
        this.f25973c = zzcxm;
        this.f25974d = zzbai;
        this.f25975e = i;
    }

    public final void onAdLoaded() {
        String str;
        int i = this.f25975e;
        if ((i == 7 || i == 3) && this.f25973c.f27544J && this.f25972b != null && zzk.zzlv().mo30001b(this.f25971a)) {
            zzbai zzbai = this.f25974d;
            int i2 = zzbai.f25058b;
            int i3 = zzbai.f25059c;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i2);
            sb.append(".");
            sb.append(i3);
            String sb2 = sb.toString();
            if (this.f25973c.f27546L.optInt("media_type", -1) == 0) {
                str = null;
            } else {
                str = "javascript";
            }
            this.f25976f = zzk.zzlv().mo29995a(sb2, this.f25972b.getWebView(), "", "javascript", str);
            if (this.f25976f != null && this.f25972b.getView() != null) {
                zzk.zzlv().mo29999a(this.f25976f, this.f25972b.getView());
                this.f25972b.mo28719a(this.f25976f);
                zzk.zzlv().mo29998a(this.f25976f);
            }
        }
    }

    public final void zzsz() {
        this.f25976f = null;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void zzta() {
        if (this.f25976f != null) {
            zzbgz zzbgz = this.f25972b;
            if (zzbgz != null) {
                zzbgz.mo28729a("onSdkImpression", (Map<String, ?>) new HashMap<String,Object>());
            }
        }
    }
}
