package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzalr;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawl;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbh;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzyt;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment.BundleCons;

@zzard
public final class zzd {

    /* renamed from: a */
    private Context f19125a;

    /* renamed from: b */
    private long f19126b = 0;

    public final void zza(Context context, zzbai zzbai, String str, Runnable runnable) {
        m20839a(context, zzbai, true, null, str, null, runnable);
    }

    public final void zza(Context context, zzbai zzbai, String str, zzawl zzawl) {
        m20839a(context, zzbai, false, zzawl, zzawl != null ? zzawl.mo30162d() : null, str, null);
    }

    @VisibleForTesting
    /* renamed from: a */
    private final void m20839a(Context context, zzbai zzbai, boolean z, zzawl zzawl, String str, String str2, Runnable runnable) {
        if (zzk.zzln().mo27934a() - this.f19126b < 5000) {
            zzbad.m26359d("Not retrying to fetch app settings");
            return;
        }
        this.f19126b = zzk.zzln().mo27934a();
        boolean z2 = true;
        if (zzawl != null) {
            if (!(zzk.zzln().mo27935b() - zzawl.mo30159a() > ((Long) zzyt.m31536e().mo29599a(zzacu.f24074cd)).longValue()) && zzawl.mo30160b()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                zzbad.m26359d("Context not provided to fetch application settings");
            } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                this.f19125a = applicationContext;
                zzalr b = zzk.zzlt().mo29807b(this.f19125a, zzbai);
                zzaln<JSONObject> zzaln = zzalo.f24411b;
                zzalj a = b.mo29808a("google.afma.config.fetchAppSettings", zzaln, zzaln);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(BundleCons.APP_ID, str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("ad_unit_id", str2);
                    }
                    jSONObject.put("is_init", z);
                    jSONObject.put("pn", context.getPackageName());
                    zzbbh b2 = a.mo29805b(jSONObject);
                    zzbbh a2 = zzbar.m26379a(b2, C8582a.f19077a, zzbbm.f25065b);
                    if (runnable != null) {
                        b2.mo28811a(runnable, zzbbm.f25065b);
                    }
                    zzbao.m26373a(a2, "ConfigLoader.maybeFetchNewAppSettings");
                } catch (Exception e) {
                    zzbad.m26356b("Error requesting application settings", e);
                }
            } else {
                zzbad.m26359d("App settings could not be fetched. Required parameters missing");
            }
        }
    }
}
