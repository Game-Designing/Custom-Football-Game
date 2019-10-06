package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;
import p002b.p003c.p049c.C1163b;
import p002b.p003c.p049c.C1163b.C1164a;

public final class zzckr implements zzcjv<zzbvx> {

    /* renamed from: a */
    private final Context f26754a;

    /* renamed from: b */
    private final zzbws f26755b;

    /* renamed from: c */
    private final Executor f26756c;

    /* renamed from: d */
    private final zzcxk f26757d;

    public zzckr(Context context, Executor executor, zzbws zzbws, zzcxk zzcxk) {
        this.f26754a = context;
        this.f26755b = zzbws;
        this.f26756c = executor;
        this.f26757d = zzcxk;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        return (this.f26754a instanceof Activity) && PlatformVersion.m22108b() && zzads.m24825a(this.f26754a) && !TextUtils.isEmpty(m28524a(zzcxm));
    }

    /* renamed from: a */
    public final zzbbh<zzbvx> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        String a = m28524a(zzcxm);
        return zzbar.m26379a((zzbbh<A>) zzbar.m26376a(null), (zzbal<? super A, ? extends B>) new C8896Hj<Object,Object>(this, a != null ? Uri.parse(a) : null, zzcxu, zzcxm), this.f26756c);
    }

    /* renamed from: a */
    private static String m28524a(zzcxm zzcxm) {
        try {
            return zzcxm.f27568s.getString("tab_url");
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31194a(Uri uri, zzcxu zzcxu, zzcxm zzcxm, Object obj) throws Exception {
        try {
            C1163b b = new C1164a().mo8787b();
            b.f3816a.setData(uri);
            zzc zzc = new zzc(b.f3816a);
            zzbbr zzbbr = new zzbbr();
            zzbvy a = this.f26755b.mo28122a(new zzbpr(zzcxu, zzcxm, null), new zzbvz(new C8917Ij(zzbbr)));
            AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzc, null, a.mo28183i(), null, new zzbai(0, 0, false));
            zzbbr.mo30338b(adOverlayInfoParcel);
            this.f26757d.mo31284c();
            return zzbar.m26376a(a.mo28182h());
        } catch (Throwable th) {
            zzbad.m26356b("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
