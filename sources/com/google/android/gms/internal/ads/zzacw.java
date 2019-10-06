package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.regex.Pattern;

@zzard
public final class zzacw {
    /* renamed from: a */
    public static boolean m24785a(String str) {
        return m24786a((String) zzyt.m31536e().mo29599a(zzacu.f24099ge), str);
    }

    /* renamed from: a */
    private static boolean m24786a(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        try {
            return Pattern.matches(str, str2);
        } catch (RuntimeException e) {
            zzk.zzlk().mo30168a((Throwable) e, "NonagonUtil.isPatternMatched");
            return false;
        }
    }
}
