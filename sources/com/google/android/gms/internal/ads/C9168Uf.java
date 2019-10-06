package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.Uf */
final class C9168Uf extends zzbnf {

    /* renamed from: f */
    private final Context f21805f;

    /* renamed from: g */
    private final View f21806g;

    /* renamed from: h */
    private final zzbgz f21807h;

    /* renamed from: i */
    private final zzcxn f21808i;

    /* renamed from: j */
    private final zzbpb f21809j;

    /* renamed from: k */
    private final zzbzc f21810k;

    /* renamed from: l */
    private final zzbvd f21811l;

    /* renamed from: m */
    private final zzdte<zzcpm> f21812m;

    /* renamed from: n */
    private final Executor f21813n;

    C9168Uf(Context context, zzcxn zzcxn, View view, zzbgz zzbgz, zzbpb zzbpb, zzbzc zzbzc, zzbvd zzbvd, zzdte<zzcpm> zzdte, Executor executor) {
        this.f21805f = context;
        this.f21806g = view;
        this.f21807h = zzbgz;
        this.f21808i = zzcxn;
        this.f21809j = zzbpb;
        this.f21810k = zzbzc;
        this.f21811l = zzbvd;
        this.f21812m = zzdte;
        this.f21813n = executor;
    }

    /* renamed from: g */
    public final View mo28635g() {
        return this.f21806g;
    }

    /* renamed from: a */
    public final void mo28632a(ViewGroup viewGroup, zzyd zzyd) {
        if (viewGroup != null) {
            zzbgz zzbgz = this.f21807h;
            if (zzbgz != null) {
                zzbgz.mo28723a(zzbin.m27014a(zzyd));
                viewGroup.setMinimumHeight(zzyd.f29770c);
                viewGroup.setMinimumWidth(zzyd.f29773f);
            }
        }
    }

    /* renamed from: f */
    public final zzaar mo28634f() {
        try {
            return this.f21809j.getVideoController();
        } catch (RemoteException e) {
            return null;
        }
    }

    /* renamed from: h */
    public final zzcxn mo28636h() {
        return (zzcxn) this.f25747b.f27564o.get(0);
    }

    /* renamed from: i */
    public final int mo28637i() {
        return this.f25746a.f27596b.f27591b.f27581c;
    }

    /* renamed from: j */
    public final void mo28638j() {
        this.f21811l.mo30925G();
    }

    /* renamed from: c */
    public final void mo28633c() {
        this.f21813n.execute(new C9189Vf(this));
        super.mo28633c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public final /* synthetic */ void mo28639k() {
        if (this.f21810k.mo31038d() != null) {
            try {
                this.f21810k.mo31038d().mo29701a((zzzk) this.f21812m.get(), ObjectWrapper.m22188a(this.f21805f));
            } catch (RemoteException e) {
                zzbad.m26356b("RemoteException when notifyAdLoad is called", e);
            }
        }
    }
}
