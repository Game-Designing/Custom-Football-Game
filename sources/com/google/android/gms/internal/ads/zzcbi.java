package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcbi {

    /* renamed from: a */
    private final Context f26313a;

    /* renamed from: b */
    private final zzcxv f26314b;

    /* renamed from: c */
    private final Executor f26315c;

    /* renamed from: d */
    private final zzcdn f26316d;

    public zzcbi(Context context, zzcxv zzcxv, Executor executor, zzcdn zzcdn) {
        this.f26313a = context;
        this.f26314b = zzcxv;
        this.f26315c = executor;
        this.f26316d = zzcdn;
    }

    /* renamed from: a */
    public final zzbbh<zzbgz> mo31099a(JSONObject jSONObject) {
        return zzbar.m26379a(zzbar.m26379a((zzbbh<A>) zzbar.m26376a(null), (zzbal<? super A, ? extends B>) new C9149Th<Object,Object>(this), this.f26315c), (zzbal<? super A, ? extends B>) new C9103Rh<Object,Object>(this, jSONObject), this.f26315c);
    }

    /* renamed from: a */
    public final zzbbh<zzbgz> mo31097a(String str, String str2) {
        return zzbar.m26379a((zzbbh<A>) zzbar.m26376a(null), (zzbal<? super A, ? extends B>) new C9124Sh<Object,Object>(this, str, str2), this.f26315c);
    }

    /* renamed from: a */
    private final void m28191a(zzbgz zzbgz) {
        zzbgz.mo28726a("/video", zzagz.f24332l);
        zzbgz.mo28726a("/videoMeta", zzagz.f24333m);
        zzbgz.mo28726a("/precache", (zzaho<? super zzbgz>) new zzbgc<Object>());
        zzbgz.mo28726a("/delayPageLoaded", zzagz.f24336p);
        zzbgz.mo28726a("/instrument", zzagz.f24334n);
        zzbgz.mo28726a("/log", zzagz.f24327g);
        zzbgz.mo28726a("/videoClicked", zzagz.f24328h);
        zzbgz.mo28714a().mo30602a(true);
        if (this.f26314b.f27599c != null) {
            zzbgz.mo28726a("/open", (zzaho<? super zzbgz>) new zzahs<Object>(null, null));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31096a(Object obj) throws Exception {
        zzbgz a = this.f26316d.mo31124a(zzyd.m31511a(this.f26313a));
        zzbbq c = zzbbq.m26396c(a);
        m28191a(a);
        a.mo28714a().mo30598a((zzbik) new C9170Uh(c));
        a.loadUrl((String) zzyt.m31536e().mo29599a(zzacu.f23947Ic));
        return c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31098a(String str, String str2, Object obj) throws Exception {
        zzbgz a = this.f26316d.mo31124a(zzyd.m31511a(this.f26313a));
        zzbbq c = zzbbq.m26396c(a);
        m28191a(a);
        if (this.f26314b.f27599c != null) {
            a.mo28723a(zzbin.m27017d());
        } else {
            a.mo28723a(zzbin.m27016c());
        }
        a.mo28714a().mo30597a((zzbij) new C9191Vh(this, a, c));
        a.mo28728a(str, str2, null);
        return c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31101a(zzbgz zzbgz, zzbbq zzbbq, boolean z) {
        if (!(this.f26314b.f27598b == null || zzbgz.mo28754g() == null)) {
            zzbgz.mo28754g().mo30631b(this.f26314b.f27598b);
        }
        zzbbq.mo30336a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31100a(JSONObject jSONObject, zzbgz zzbgz) throws Exception {
        zzbbq c = zzbbq.m26396c(zzbgz);
        if (this.f26314b.f27599c != null) {
            zzbgz.mo28723a(zzbin.m27017d());
        } else {
            zzbgz.mo28723a(zzbin.m27016c());
        }
        zzbgz.mo28714a().mo30597a((zzbij) new C9212Wh(this, zzbgz, c));
        zzbgz.mo28740b("google.afma.nativeAds.renderVideo", jSONObject);
        return c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo31102b(zzbgz zzbgz, zzbbq zzbbq, boolean z) {
        if (!(this.f26314b.f27598b == null || zzbgz.mo28754g() == null)) {
            zzbgz.mo28754g().mo30631b(this.f26314b.f27598b);
        }
        zzbbq.mo30336a();
    }
}
