package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

@zzard
public final class zzahr implements zzaho<zzbgz> {

    /* renamed from: a */
    private static final Map<String, Integer> f24340a = CollectionUtils.m22080a((K[]) new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, (V[]) new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7)});

    /* renamed from: b */
    private final zzb f24341b;

    /* renamed from: c */
    private final zzapr f24342c;

    /* renamed from: d */
    private final zzaqc f24343d;

    public zzahr(zzb zzb, zzapr zzapr, zzaqc zzaqc) {
        this.f24341b = zzb;
        this.f24342c = zzapr;
        this.f24343d = zzaqc;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        int intValue = ((Integer) f24340a.get((String) map.get("a"))).intValue();
        if (!(intValue == 5 || intValue == 7)) {
            zzb zzb = this.f24341b;
            if (zzb != null && !zzb.zzkx()) {
                this.f24341b.zzbk(null);
                return;
            }
        }
        if (intValue == 1) {
            this.f24342c.mo29977a(map);
        } else if (intValue == 3) {
            new zzapu(zzbgz, map).mo29981a();
        } else if (intValue == 4) {
            new zzapo(zzbgz, map).mo29974b();
        } else if (intValue == 5) {
            new zzapt(zzbgz, map).mo29980a();
        } else if (intValue != 6) {
            if (intValue != 7) {
                zzbad.m26357c("Unknown MRAID command called.");
            } else {
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24077da)).booleanValue()) {
                    this.f24343d.mo29250b();
                }
            }
        } else {
            this.f24342c.mo29978a(true);
        }
    }
}
