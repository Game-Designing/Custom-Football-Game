package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzwo {
    @VisibleForTesting

    /* renamed from: a */
    zzfx f29607a;
    @VisibleForTesting

    /* renamed from: b */
    boolean f29608b;

    /* renamed from: a */
    public final zzws mo32331a(byte[] bArr) {
        return new zzws(this, bArr);
    }

    public zzwo(Context context, String str, String str2) {
        zzacu.m24782a(context);
        try {
            this.f29607a = (zzfx) zzbae.m26364a(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", C9053Ot.f21573a);
            ObjectWrapper.m22188a(context);
            this.f29607a.mo31756a(ObjectWrapper.m22188a(context), str, null);
            this.f29608b = true;
        } catch (RemoteException | zzbag | NullPointerException e) {
            zzbad.m26352a("Cannot dynamite load clearcut");
        }
    }

    public zzwo(Context context) {
        zzacu.m24782a(context);
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23990Pd)).booleanValue()) {
            try {
                this.f29607a = (zzfx) zzbae.m26364a(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", C9074Pt.f21601a);
                ObjectWrapper.m22188a(context);
                this.f29607a.mo31760b(ObjectWrapper.m22188a(context), "GMA_SDK");
                this.f29608b = true;
            } catch (RemoteException | zzbag | NullPointerException e) {
                zzbad.m26352a("Cannot dynamite load clearcut");
            }
        }
    }

    public zzwo() {
    }
}
