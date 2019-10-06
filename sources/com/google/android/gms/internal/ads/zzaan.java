package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

@zzard
public final class zzaan implements MuteThisAdReason {

    /* renamed from: a */
    private final String f23794a;

    /* renamed from: b */
    private zzaak f23795b;

    public zzaan(zzaak zzaak) {
        String str;
        this.f23795b = zzaak;
        try {
            str = zzaak.getDescription();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
            str = null;
        }
        this.f23794a = str;
    }

    public final String getDescription() {
        return this.f23794a;
    }

    /* renamed from: a */
    public final zzaak mo29362a() {
        return this.f23795b;
    }
}
