package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;

@zzard
public final class zza {
    public static boolean zza(Context context, zzc zzc, zzu zzu) {
        int i = 0;
        if (zzc == null) {
            zzbad.m26359d("No intent data for launcher overlay.");
            return false;
        }
        zzacu.m24782a(context);
        Intent intent = zzc.intent;
        if (intent != null) {
            return m20829a(context, intent, zzu);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzc.url)) {
            zzbad.m26359d("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzc.mimeType)) {
            intent2.setDataAndType(Uri.parse(zzc.url), zzc.mimeType);
        } else {
            intent2.setData(Uri.parse(zzc.url));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.packageName)) {
            intent2.setPackage(zzc.packageName);
        }
        if (!TextUtils.isEmpty(zzc.zzdjh)) {
            String[] split = zzc.zzdjh.split("/", 2);
            if (split.length < 2) {
                String str = "Could not parse component name from open GMSG: ";
                String valueOf = String.valueOf(zzc.zzdjh);
                zzbad.m26359d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str2 = zzc.zzdji;
        if (!TextUtils.isEmpty(str2)) {
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException e) {
                zzbad.m26359d("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23918Dd)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23912Cd)).booleanValue()) {
                zzk.zzlg();
                zzaxi.m26122b(context, intent2);
            }
        }
        return m20829a(context, intent2, zzu);
    }

    /* renamed from: a */
    private static boolean m20829a(Context context, Intent intent, zzu zzu) {
        String str = "Launching an intent: ";
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzawz.m26003f(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            zzk.zzlg();
            zzaxi.m26109a(context, intent);
            if (zzu != null) {
                zzu.zztq();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzbad.m26359d(e.getMessage());
            return false;
        }
    }
}
