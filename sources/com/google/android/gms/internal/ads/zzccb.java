package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzccb extends zzafb {

    /* renamed from: b */
    private final String f26347b;

    /* renamed from: c */
    private final zzbyn f26348c;

    /* renamed from: d */
    private final zzbyt f26349d;

    public zzccb(String str, zzbyn zzbyn, zzbyt zzbyt) {
        this.f26347b = str;
        this.f26348c = zzbyn;
        this.f26349d = zzbyt;
    }

    /* renamed from: v */
    public final IObjectWrapper mo29683v() throws RemoteException {
        return ObjectWrapper.m22188a(this.f26348c);
    }

    /* renamed from: o */
    public final String mo29680o() throws RemoteException {
        return this.f26349d.mo31009g();
    }

    /* renamed from: q */
    public final List mo29682q() throws RemoteException {
        return this.f26349d.mo31010h();
    }

    /* renamed from: p */
    public final String mo29681p() throws RemoteException {
        return this.f26349d.mo31005c();
    }

    /* renamed from: J */
    public final zzaei mo29669J() throws RemoteException {
        return this.f26349d.mo31028z();
    }

    /* renamed from: m */
    public final String mo29678m() throws RemoteException {
        return this.f26349d.mo31006d();
    }

    /* renamed from: x */
    public final String mo29684x() throws RemoteException {
        return this.f26349d.mo31001b();
    }

    public final Bundle getExtras() throws RemoteException {
        return this.f26349d.mo31008f();
    }

    public final void destroy() throws RemoteException {
        this.f26348c.mo30853a();
    }

    public final zzaar getVideoController() throws RemoteException {
        return this.f26349d.mo31015m();
    }

    /* renamed from: d */
    public final void mo29672d(Bundle bundle) throws RemoteException {
        this.f26348c.mo30963a(bundle);
    }

    /* renamed from: b */
    public final boolean mo29670b(Bundle bundle) throws RemoteException {
        return this.f26348c.mo30977c(bundle);
    }

    /* renamed from: c */
    public final void mo29671c(Bundle bundle) throws RemoteException {
        this.f26348c.mo30974b(bundle);
    }

    /* renamed from: l */
    public final zzaea mo29677l() throws RemoteException {
        return this.f26349d.mo31026x();
    }

    /* renamed from: n */
    public final IObjectWrapper mo29679n() throws RemoteException {
        return this.f26349d.mo31027y();
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f26347b;
    }
}
