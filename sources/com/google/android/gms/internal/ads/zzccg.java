package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzccg extends zzagh {

    /* renamed from: b */
    private final String f26361b;

    /* renamed from: c */
    private final zzbyn f26362c;

    /* renamed from: d */
    private final zzbyt f26363d;

    public zzccg(String str, zzbyn zzbyn, zzbyt zzbyt) {
        this.f26361b = str;
        this.f26362c = zzbyn;
        this.f26363d = zzbyt;
    }

    /* renamed from: v */
    public final IObjectWrapper mo29734v() throws RemoteException {
        return ObjectWrapper.m22188a(this.f26362c);
    }

    /* renamed from: o */
    public final String mo29727o() throws RemoteException {
        return this.f26363d.mo31009g();
    }

    /* renamed from: q */
    public final List mo29729q() throws RemoteException {
        return this.f26363d.mo31010h();
    }

    /* renamed from: Qa */
    public final List mo29710Qa() throws RemoteException {
        if (mo29711X()) {
            return this.f26363d.mo31011i();
        }
        return Collections.emptyList();
    }

    /* renamed from: X */
    public final boolean mo29711X() throws RemoteException {
        return !this.f26363d.mo31011i().isEmpty() && this.f26363d.mo31018p() != null;
    }

    /* renamed from: p */
    public final String mo29728p() throws RemoteException {
        return this.f26363d.mo31005c();
    }

    /* renamed from: t */
    public final zzaei mo29731t() throws RemoteException {
        return this.f26363d.mo31025w();
    }

    /* renamed from: m */
    public final String mo29725m() throws RemoteException {
        return this.f26363d.mo31006d();
    }

    /* renamed from: x */
    public final String mo29735x() throws RemoteException {
        return this.f26363d.mo31001b();
    }

    /* renamed from: j */
    public final double mo29723j() throws RemoteException {
        return this.f26363d.mo31013k();
    }

    public final String getStore() throws RemoteException {
        return this.f26363d.mo31014l();
    }

    /* renamed from: u */
    public final String mo29732u() throws RemoteException {
        return this.f26363d.mo31012j();
    }

    public final void destroy() throws RemoteException {
        this.f26362c.mo30853a();
    }

    public final zzaar getVideoController() throws RemoteException {
        return this.f26363d.mo31015m();
    }

    /* renamed from: d */
    public final void mo29717d(Bundle bundle) throws RemoteException {
        this.f26362c.mo30963a(bundle);
    }

    /* renamed from: b */
    public final boolean mo29715b(Bundle bundle) throws RemoteException {
        return this.f26362c.mo30977c(bundle);
    }

    /* renamed from: c */
    public final void mo29716c(Bundle bundle) throws RemoteException {
        this.f26362c.mo30974b(bundle);
    }

    /* renamed from: l */
    public final zzaea mo29724l() throws RemoteException {
        return this.f26363d.mo31026x();
    }

    /* renamed from: n */
    public final IObjectWrapper mo29726n() throws RemoteException {
        return this.f26363d.mo31027y();
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f26361b;
    }

    public final Bundle getExtras() throws RemoteException {
        return this.f26363d.mo31008f();
    }

    /* renamed from: a */
    public final void mo29714a(zzagd zzagd) throws RemoteException {
        this.f26362c.mo30970a(zzagd);
    }

    /* renamed from: a */
    public final void mo29713a(zzaak zzaak) throws RemoteException {
        this.f26362c.mo30969a(zzaak);
    }

    /* renamed from: a */
    public final void mo29712a(zzaag zzaag) throws RemoteException {
        this.f26362c.mo30968a(zzaag);
    }

    /* renamed from: y */
    public final void mo29736y() {
        this.f26362c.mo30984l();
    }

    /* renamed from: ua */
    public final void mo29733ua() {
        this.f26362c.mo30979g();
    }

    /* renamed from: r */
    public final void mo29730r() throws RemoteException {
        this.f26362c.mo30978f();
    }

    /* renamed from: Ha */
    public final zzaee mo29709Ha() throws RemoteException {
        return this.f26362c.mo30985m();
    }
}
