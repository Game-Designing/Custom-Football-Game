package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class zzcpy implements AppEventListener {

    /* renamed from: a */
    private zzzs f27208a;

    /* renamed from: a */
    public final synchronized void mo31234a(zzzs zzzs) {
        this.f27208a = zzzs;
    }

    /* renamed from: a */
    public final synchronized zzzs mo31233a() {
        return this.f27208a;
    }

    public final synchronized void onAppEvent(String str, String str2) {
        if (this.f27208a != null) {
            try {
                this.f27208a.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAppEvent.", e);
            }
        }
    }
}
