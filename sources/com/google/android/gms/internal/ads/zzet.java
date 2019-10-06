package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.util.concurrent.Callable;

public final class zzet implements Callable {

    /* renamed from: a */
    private final zzdy f28382a;

    /* renamed from: b */
    private final C15005zza f28383b;

    public zzet(zzdy zzdy, C15005zza zza) {
        this.f28382a = zzdy;
        this.f28383b = zza;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Void call() throws Exception {
        if (this.f28382a.mo31725m() != null) {
            this.f28382a.mo31725m().get();
        }
        zza l = this.f28382a.mo31724l();
        if (l != null) {
            try {
                synchronized (this.f28383b) {
                    C15005zza zza = this.f28383b;
                    byte[] byteArray = l.toByteArray();
                    zza.mo31610a(byteArray, 0, byteArray.length, zzdno.m29867c());
                }
            } catch (zzdok e) {
            }
        }
        return null;
    }
}
