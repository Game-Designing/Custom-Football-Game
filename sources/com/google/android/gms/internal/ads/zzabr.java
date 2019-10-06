package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzabr extends zzaac {

    /* renamed from: b */
    private zzait f23873b;

    /* renamed from: E */
    public final void mo29344E() throws RemoteException {
        zzbad.m26355b("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzazt.f25042a.post(new C9462h(this));
    }

    /* renamed from: a */
    public final void mo29350a(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29346a(float f) throws RemoteException {
    }

    /* renamed from: g */
    public final void mo29353g(String str) throws RemoteException {
    }

    /* renamed from: g */
    public final void mo29354g(boolean z) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29347a(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    /* renamed from: Ra */
    public final float mo29345Ra() throws RemoteException {
        return 1.0f;
    }

    /* renamed from: ga */
    public final boolean mo29355ga() throws RemoteException {
        return false;
    }

    /* renamed from: fa */
    public final String mo29352fa() {
        return "";
    }

    /* renamed from: p */
    public final void mo29356p(String str) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29349a(zzamp zzamp) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29348a(zzait zzait) throws RemoteException {
        this.f23873b = zzait;
    }

    /* renamed from: ba */
    public final List<zzaio> mo29351ba() throws RemoteException {
        return Collections.EMPTY_LIST;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ib */
    public final /* synthetic */ void mo29536ib() {
        zzait zzait = this.f23873b;
        if (zzait != null) {
            try {
                zzait.mo29756b(Collections.EMPTY_LIST);
            } catch (RemoteException e) {
                zzbad.m26358c("Could not notify onComplete event.", e);
            }
        }
    }
}
