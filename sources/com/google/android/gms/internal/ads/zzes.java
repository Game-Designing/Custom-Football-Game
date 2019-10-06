package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import com.google.android.gms.internal.ads.zzbp.zza.zzc;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public final class zzes extends zzfk {
    public zzes(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 24);
    }

    /* renamed from: b */
    public final Void call() throws Exception {
        if (this.f28406b.mo31714b()) {
            return super.call();
        }
        if (this.f28406b.mo31720h()) {
            m30190c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        if (this.f28406b.mo31720h()) {
            m30190c();
            return;
        }
        synchronized (this.f28409e) {
            this.f28409e.mo30790f((String) this.f28410f.invoke(null, new Object[]{this.f28406b.mo31709a()}));
        }
    }

    /* renamed from: c */
    private final void m30190c() {
        AdvertisingIdClient n = this.f28406b.mo31726n();
        if (n != null) {
            try {
                Info info = n.getInfo();
                String a = zzef.m30166a(info.getId());
                if (a != null) {
                    synchronized (this.f28409e) {
                        this.f28409e.mo30790f(a);
                        this.f28409e.mo30776a(info.isLimitAdTrackingEnabled());
                        this.f28409e.mo30770a(zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    }
                }
            } catch (IOException e) {
            }
        }
    }
}
