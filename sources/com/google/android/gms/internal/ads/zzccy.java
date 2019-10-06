package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzccy implements zzbrx {

    /* renamed from: a */
    private final zzams f26397a;

    public zzccy(zzams zzams) {
        this.f26397a = zzams;
    }

    /* renamed from: b */
    public final void mo29183b(Context context) {
        try {
            this.f26397a.pause();
        } catch (RemoteException e) {
            zzbad.m26358c("Nonagon: Can't invoke onPause for rewarded video.", e);
        }
    }

    /* renamed from: d */
    public final void mo29185d(Context context) {
        try {
            this.f26397a.resume();
            if (context != null) {
                this.f26397a.mo29860m(ObjectWrapper.m22188a(context));
            }
        } catch (RemoteException e) {
            zzbad.m26358c("Nonagon: Can't invoke onResume for rewarded video.", e);
        }
    }

    /* renamed from: c */
    public final void mo29184c(Context context) {
        try {
            this.f26397a.destroy();
        } catch (RemoteException e) {
            zzbad.m26358c("Nonagon: Can't invoke onDestroy for rewarded video.", e);
        }
    }
}
