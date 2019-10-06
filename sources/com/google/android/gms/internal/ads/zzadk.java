package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzadk implements CustomRenderedAd {

    /* renamed from: a */
    private final zzadl f24243a;

    public zzadk(zzadl zzadl) {
        this.f24243a = zzadl;
    }

    public final String getBaseUrl() {
        try {
            return this.f24243a.mo29625qa();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final String getContent() {
        try {
            return this.f24243a.getContent();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void onAdRendered(View view) {
        try {
            this.f24243a.mo29623f(view != null ? ObjectWrapper.m22188a(view) : null);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void recordClick() {
        try {
            this.f24243a.recordClick();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void recordImpression() {
        try {
            this.f24243a.recordImpression();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }
}
