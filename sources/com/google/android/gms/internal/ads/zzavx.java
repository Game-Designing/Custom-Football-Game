package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzavx {
    /* renamed from: a */
    public static String m25931a(String str, Context context, boolean z) {
        if ((((Boolean) zzyt.m31536e().mo29599a(zzacu.f23957Ka)).booleanValue() && !z) || !zzk.zzme().mo30134f(context) || TextUtils.isEmpty(str)) {
            return str;
        }
        String c = zzk.zzme().mo30127c(context);
        if (c == null) {
            return str;
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23909Ca)).booleanValue()) {
            String str2 = (String) zzyt.m31536e().mo29599a(zzacu.f23915Da);
            if (str.contains(str2)) {
                if (zzk.zzlg().mo30240c(str)) {
                    zzk.zzme().mo30130d(context, c);
                    return str.replace(str2, c);
                } else if (zzk.zzlg().mo30242d(str)) {
                    zzk.zzme().mo30132e(context, c);
                    return str.replace(str2, c);
                }
            }
        } else {
            String str3 = "fbs_aeid";
            if (!str.contains(str3)) {
                if (zzk.zzlg().mo30240c(str)) {
                    zzk.zzme().mo30130d(context, c);
                    return m25929a(str, str3, c).toString();
                } else if (zzk.zzlg().mo30242d(str)) {
                    zzk.zzme().mo30132e(context, c);
                    return m25929a(str, str3, c).toString();
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m25930a(Uri uri, Context context) {
        if (!zzk.zzme().mo30134f(context)) {
            return uri.toString();
        }
        String c = zzk.zzme().mo30127c(context);
        if (c == null) {
            return uri.toString();
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23909Ca)).booleanValue()) {
            String str = (String) zzyt.m31536e().mo29599a(zzacu.f23915Da);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                zzk.zzme().mo30130d(context, c);
                return uri2.replace(str, c);
            }
        } else {
            String str2 = "fbs_aeid";
            if (TextUtils.isEmpty(uri.getQueryParameter(str2))) {
                uri = m25929a(uri.toString(), str2, c);
                zzk.zzme().mo30130d(context, c);
            }
        }
        return uri.toString();
    }

    @VisibleForTesting
    /* renamed from: a */
    private static Uri m25929a(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        StringBuilder sb = new StringBuilder(str.substring(0, i));
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        sb.append("&");
        sb.append(str.substring(i));
        return Uri.parse(sb.toString());
    }
}
