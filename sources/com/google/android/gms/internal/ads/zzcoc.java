package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

public final class zzcoc implements zzcjz<zzaov, zzcla> {

    /* renamed from: a */
    private final zzclc f27106a;

    public zzcoc(zzclc zzclc) {
        this.f27106a = zzclc;
    }

    /* renamed from: a */
    public final zzcjy<zzaov, zzcla> mo31189a(String str, JSONObject jSONObject) throws RemoteException {
        zzaov a = this.f27106a.mo31201a(str);
        if (a == null) {
            return null;
        }
        return new zzcjy<>(a, new zzcla(), str);
    }
}
