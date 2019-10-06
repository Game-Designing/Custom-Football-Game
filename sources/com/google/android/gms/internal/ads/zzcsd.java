package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

public final class zzcsd implements zzcva<zzcsc> {

    /* renamed from: a */
    private final zzbbl f27321a;

    /* renamed from: b */
    private final Context f27322b;

    public zzcsd(zzbbl zzbbl, Context context) {
        this.f27321a = zzbbl;
        this.f27322b = context;
    }

    /* renamed from: a */
    public final zzbbh<zzcsc> mo28586a() {
        return this.f27321a.mo30326a((Callable<T>) new C9628ol<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcsc mo31254b() throws Exception {
        AudioManager audioManager = (AudioManager) this.f27322b.getSystemService("audio");
        zzcsc zzcsc = new zzcsc(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzk.zzll().mo30262a(), zzk.zzll().mo30265b());
        return zzcsc;
    }
}
