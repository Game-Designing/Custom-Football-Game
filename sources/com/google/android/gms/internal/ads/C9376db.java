package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* renamed from: com.google.android.gms.internal.ads.db */
final class C9376db implements SignalCallbacks {

    /* renamed from: a */
    private final /* synthetic */ zzaoy f22174a;

    C9376db(zzapc zzapc, zzaoy zzaoy) {
        this.f22174a = zzaoy;
    }

    public final void onSuccess(String str) {
        try {
            this.f22174a.mo29967d(str);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.f22174a.onFailure(str);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
