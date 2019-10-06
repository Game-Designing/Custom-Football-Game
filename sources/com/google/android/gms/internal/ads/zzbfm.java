package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;

@zzard
public final class zzbfm implements zzbgd {
    /* renamed from: a */
    public final zzbft mo30535a(zzbdf zzbdf, int i, String str, zzbde zzbde) {
        if (VERSION.SDK_INT >= 16 && i > 0) {
            List asList = Arrays.asList(zzbde.f25151e.split(","));
            if (asList.contains("3")) {
                int e = zzbfa.m26661e();
                if (e < zzbde.f25154h) {
                    return new zzbgp(zzbdf, zzbde);
                }
                if (e < zzbde.f25148b) {
                    return new zzbgo(zzbdf, zzbde);
                }
                return new zzbgf(zzbdf);
            } else if (asList.contains("1")) {
                int c = zzbdk.m26551c();
                if (c < zzbde.f25154h) {
                    if (i == 1) {
                        return new zzbgk(zzbdf);
                    }
                    if (i == 2) {
                        return new zzbgh(zzbdf, null);
                    }
                }
                if (c < zzbde.f25148b) {
                    return new zzbgg(zzbdf, zzbde);
                }
                return new zzbgf(zzbdf);
            }
        }
        return new zzbge(zzbdf);
    }
}
