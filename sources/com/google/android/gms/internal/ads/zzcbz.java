package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzcbz extends zzaex {

    /* renamed from: b */
    private final String f26334b;

    /* renamed from: c */
    private final zzbyn f26335c;

    /* renamed from: d */
    private final zzbyt f26336d;

    public zzcbz(String str, zzbyn zzbyn, zzbyt zzbyt) {
        this.f26334b = str;
        this.f26335c = zzbyn;
        this.f26336d = zzbyt;
    }

    /* renamed from: v */
    public final IObjectWrapper mo29667v() throws RemoteException {
        return ObjectWrapper.m22188a(this.f26335c);
    }

    /* renamed from: o */
    public final String mo29662o() throws RemoteException {
        return this.f26336d.mo31009g();
    }

    /* renamed from: q */
    public final List mo29664q() throws RemoteException {
        return this.f26336d.mo31010h();
    }

    /* renamed from: p */
    public final String mo29663p() throws RemoteException {
        return this.f26336d.mo31005c();
    }

    /* renamed from: t */
    public final zzaei mo29665t() throws RemoteException {
        return this.f26336d.mo31025w();
    }

    /* renamed from: m */
    public final String mo29660m() throws RemoteException {
        return this.f26336d.mo31006d();
    }

    /* renamed from: j */
    public final double mo29658j() throws RemoteException {
        return this.f26336d.mo31013k();
    }

    public final String getStore() throws RemoteException {
        return this.f26336d.mo31014l();
    }

    /* renamed from: u */
    public final String mo29666u() throws RemoteException {
        return this.f26336d.mo31012j();
    }

    public final Bundle getExtras() throws RemoteException {
        return this.f26336d.mo31008f();
    }

    public final void destroy() throws RemoteException {
        this.f26335c.mo30853a();
    }

    public final zzaar getVideoController() throws RemoteException {
        return this.f26336d.mo31015m();
    }

    /* renamed from: d */
    public final void mo29652d(Bundle bundle) throws RemoteException {
        this.f26335c.mo30963a(bundle);
    }

    /* renamed from: b */
    public final boolean mo29650b(Bundle bundle) throws RemoteException {
        return this.f26335c.mo30977c(bundle);
    }

    /* renamed from: c */
    public final void mo29651c(Bundle bundle) throws RemoteException {
        this.f26335c.mo30974b(bundle);
    }

    /* renamed from: l */
    public final zzaea mo29659l() throws RemoteException {
        return this.f26336d.mo31026x();
    }

    /* renamed from: n */
    public final IObjectWrapper mo29661n() throws RemoteException {
        return this.f26336d.mo31027y();
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f26334b;
    }
}
