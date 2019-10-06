package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;

public final class zzccw extends VideoLifecycleCallbacks {

    /* renamed from: a */
    private final zzbyt f26395a;

    public zzccw(zzbyt zzbyt) {
        this.f26395a = zzbyt;
    }

    public final void onVideoStart() {
        zzaau a = m28283a(this.f26395a);
        if (a != null) {
            try {
                a.onVideoStart();
            } catch (RemoteException e) {
                zzbad.m26358c("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzaau a = m28283a(this.f26395a);
        if (a != null) {
            try {
                a.onVideoPause();
            } catch (RemoteException e) {
                zzbad.m26358c("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoEnd() {
        zzaau a = m28283a(this.f26395a);
        if (a != null) {
            try {
                a.mo29375M();
            } catch (RemoteException e) {
                zzbad.m26358c("Unable to call onVideoEnd()", e);
            }
        }
    }

    /* renamed from: a */
    private static zzaau m28283a(zzbyt zzbyt) {
        zzaar m = zzbyt.mo31015m();
        if (m == null) {
            return null;
        }
        try {
            return m.mo29370ma();
        } catch (RemoteException e) {
            return null;
        }
    }
}
