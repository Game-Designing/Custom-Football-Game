package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

@zzard
public final class zzahx implements zzaho<Object> {

    /* renamed from: a */
    private final zzahy f24351a;

    /* renamed from: a */
    public static void m25065a(zzbgz zzbgz, zzahy zzahy) {
        zzbgz.mo28726a("/reward", (zzaho<? super zzbgz>) new zzahx<Object>(zzahy));
    }

    private zzahx(zzahy zzahy) {
        this.f24351a = zzahy;
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zzato zzato = null;
            try {
                int parseInt = Integer.parseInt((String) map.get("amount"));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzato = new zzato(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzbad.m26358c("Unable to parse reward amount.", e);
            }
            this.f24351a.mo29744a(zzato);
        } else if ("video_start".equals(str)) {
            this.f24351a.mo29743E();
        } else {
            if ("video_complete".equals(str)) {
                this.f24351a.mo29742D();
            }
        }
    }
}
