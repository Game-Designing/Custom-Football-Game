package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.database.realm.Update;

@zzard
public final class zzagy implements zzaho<zzbgz> {
    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get(Update.LABEL);
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzbad.m26359d("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzbad.m26359d("No timestamp given for CSI tick.");
            } else {
                try {
                    long a = zzk.zzln().mo27934a() + (Long.parseLong(str4) - zzk.zzln().mo27935b());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbgz.mo28706B().mo29616a(str2, str3, a);
                } catch (NumberFormatException e) {
                    zzbad.m26358c("Malformed timestamp for CSI tick.", e);
                }
            }
        } else {
            boolean equals = "experiment".equals(str);
            String str5 = DonationsAnalytics.VALUE;
            if (equals) {
                String str6 = (String) map.get(str5);
                if (TextUtils.isEmpty(str6)) {
                    zzbad.m26359d("No value given for CSI experiment.");
                    return;
                }
                zzadi a2 = zzbgz.mo28706B().mo29614a();
                if (a2 == null) {
                    zzbad.m26359d("No ticker for WebView, dropping experiment ID.");
                } else {
                    a2.mo29620a("e", str6);
                }
            } else {
                if ("extra".equals(str)) {
                    String str7 = (String) map.get("name");
                    String str8 = (String) map.get(str5);
                    if (TextUtils.isEmpty(str8)) {
                        zzbad.m26359d("No value given for CSI extra.");
                    } else if (TextUtils.isEmpty(str7)) {
                        zzbad.m26359d("No name given for CSI extra.");
                    } else {
                        zzadi a3 = zzbgz.mo28706B().mo29614a();
                        if (a3 == null) {
                            zzbad.m26359d("No ticker for WebView, dropping extra parameter.");
                            return;
                        }
                        a3.mo29620a(str7, str8);
                    }
                }
            }
        }
    }
}
