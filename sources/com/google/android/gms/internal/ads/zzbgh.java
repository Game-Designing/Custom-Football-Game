package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;

@TargetApi(16)
@zzard
public final class zzbgh extends zzbgl {

    /* renamed from: h */
    private final String f25306h = null;

    public zzbgh(zzbdf zzbdf, String str) {
        super(zzbdf);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final zzhn mo30562c(String str) {
        zzjp zzjp;
        zzjp zzjt = new zzjt(this.f25277a, this.f25278b);
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24188vd)).booleanValue()) {
            zzjp = new zzbeh(this.f25277a, zzjt, new C8828Ee(this));
        } else {
            zzjp = zzjt;
        }
        zzig zzig = new zzig(Uri.parse(str), zzjp, "video/webm".equals(this.f25306h) ? new zzjg() : new zziv(), 2, ((Integer) zzyt.m31536e().mo29599a(zzacu.f23914D)).intValue());
        return zzig;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo30561c() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo30560b(boolean z, long j) {
        zzbdf zzbdf = (zzbdf) this.f25279c.get();
        if (zzbdf != null) {
            zzbbm.f25064a.execute(new C8849Fe(zzbdf, z, j));
        }
    }
}
