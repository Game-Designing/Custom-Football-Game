package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzclb extends zzatl implements zzbsm {

    /* renamed from: b */
    private zzatk f26970b;

    /* renamed from: c */
    private zzbsn f26971c;

    /* renamed from: d */
    private zzbvo f26972d;

    /* renamed from: a */
    public final synchronized void mo31198a(zzatk zzatk) {
        this.f26970b = zzatk;
    }

    /* renamed from: a */
    public final synchronized void mo30888a(zzbsn zzbsn) {
        this.f26971c = zzbsn;
    }

    /* renamed from: a */
    public final synchronized void mo31199a(zzbvo zzbvo) {
        this.f26972d = zzbvo;
    }

    /* renamed from: w */
    public final synchronized void mo29307w(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29307w(iObjectWrapper);
        }
        if (this.f26972d != null) {
            this.f26972d.onInitializationSucceeded();
        }
    }

    /* renamed from: b */
    public final synchronized void mo29303b(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29303b(iObjectWrapper, i);
        }
        if (this.f26972d != null) {
            this.f26972d.mo29236a(i);
        }
    }

    /* renamed from: t */
    public final synchronized void mo29306t(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29306t(iObjectWrapper);
        }
    }

    /* renamed from: a */
    public final synchronized void mo29302a(IObjectWrapper iObjectWrapper, zzato zzato) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29302a(iObjectWrapper, zzato);
        }
    }

    /* renamed from: F */
    public final synchronized void mo29301F(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29301F(iObjectWrapper);
        }
    }

    /* renamed from: E */
    public final synchronized void mo29300E(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29300E(iObjectWrapper);
        }
    }

    /* renamed from: c */
    public final synchronized void mo29304c(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29304c(iObjectWrapper, i);
        }
        if (this.f26971c != null) {
            this.f26971c.onAdFailedToLoad(i);
        }
    }

    /* renamed from: z */
    public final synchronized void mo29309z(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29309z(iObjectWrapper);
        }
    }

    /* renamed from: B */
    public final synchronized void mo29299B(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29299B(iObjectWrapper);
        }
    }

    /* renamed from: s */
    public final synchronized void mo29305s(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29305s(iObjectWrapper);
        }
    }

    /* renamed from: y */
    public final synchronized void mo29308y(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.mo29308y(iObjectWrapper);
        }
        if (this.f26971c != null) {
            this.f26971c.onAdLoaded();
        }
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.f26970b != null) {
            this.f26970b.zzb(bundle);
        }
    }
}
