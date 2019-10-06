package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
public final class zzapt {

    /* renamed from: a */
    private final zzbgz f24553a;

    /* renamed from: b */
    private final boolean f24554b;

    /* renamed from: c */
    private final String f24555c;

    public zzapt(zzbgz zzbgz, Map<String, String> map) {
        this.f24553a = zzbgz;
        this.f24555c = (String) map.get("forceOrientation");
        String str = "allowOrientationChange";
        if (map.containsKey(str)) {
            this.f24554b = Boolean.parseBoolean((String) map.get(str));
        } else {
            this.f24554b = true;
        }
    }

    /* renamed from: a */
    public final void mo29980a() {
        int i;
        if (this.f24553a == null) {
            zzbad.m26359d("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.f24555c)) {
            zzk.zzli();
            i = 7;
        } else {
            if ("landscape".equalsIgnoreCase(this.f24555c)) {
                zzk.zzli();
                i = 6;
            } else if (this.f24554b) {
                i = -1;
            } else {
                i = zzk.zzli().mo30243a();
            }
        }
        this.f24553a.setRequestedOrientation(i);
    }
}
