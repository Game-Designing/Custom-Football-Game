package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzabx extends zzasx {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzatb f23874b;

    /* renamed from: a */
    public final void mo29562a(zzath zzath) throws RemoteException {
        zzbad.m26355b("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.f25042a.post(new C9506j(this));
    }

    public final void show() throws RemoteException {
    }

    /* renamed from: A */
    public final void mo29557A(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29561a(zzatb zzatb) throws RemoteException {
        this.f23874b = zzatb;
    }

    /* renamed from: a */
    public final void mo29560a(zzasu zzasu) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29563a(zzzp zzzp) throws RemoteException {
    }

    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }

    public final void setUserId(String str) throws RemoteException {
    }

    public final void setCustomData(String str) throws RemoteException {
    }

    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    /* renamed from: h */
    public final void mo29568h(String str) {
    }

    public final void pause() throws RemoteException {
    }

    public final void resume() throws RemoteException {
    }

    public final void destroy() throws RemoteException {
    }

    /* renamed from: G */
    public final void mo29559G(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    /* renamed from: D */
    public final void mo29558D(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    /* renamed from: h */
    public final void mo29567h(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
    }
}
