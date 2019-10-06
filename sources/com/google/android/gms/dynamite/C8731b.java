package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb;

/* renamed from: com.google.android.gms.dynamite.b */
final class C8731b implements VersionPolicy {
    C8731b() {
    }

    /* renamed from: a */
    public final zzb mo27985a(Context context, String str, zza zza) throws LoadingException {
        zzb zzb = new zzb();
        zzb.f20359b = zza.mo27987a(context, str, true);
        if (zzb.f20359b != 0) {
            zzb.f20360c = 1;
        } else {
            zzb.f20358a = zza.mo27986a(context, str);
            if (zzb.f20358a != 0) {
                zzb.f20360c = -1;
            }
        }
        return zzb;
    }
}
