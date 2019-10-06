package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.Vk */
final class C9194Vk extends zzaap {

    /* renamed from: b */
    private final /* synthetic */ zzaao f21856b;

    /* renamed from: c */
    private final /* synthetic */ zzcqf f21857c;

    C9194Vk(zzcqf zzcqf, zzaao zzaao) {
        this.f21857c = zzcqf;
        this.f21856b = zzaao;
    }

    public final void onAdMetadataChanged() throws RemoteException {
        if (this.f21857c.f27235k) {
            zzaao zzaao = this.f21856b;
            if (zzaao != null) {
                zzaao.onAdMetadataChanged();
            }
        }
    }
}
