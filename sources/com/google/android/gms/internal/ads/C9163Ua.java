package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* renamed from: com.google.android.gms.internal.ads.Ua */
final class C9163Ua implements InitializationCompleteCallback {

    /* renamed from: a */
    private final /* synthetic */ zzaiq f21788a;

    C9163Ua(zzanl zzanl, zzaiq zzaiq) {
        this.f21788a = zzaiq;
    }

    public final void onInitializationSucceeded() {
        try {
            this.f21788a.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final void onInitializationFailed(String str) {
        try {
            this.f21788a.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
