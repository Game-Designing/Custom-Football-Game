package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(21)
@zzard
/* renamed from: com.google.android.gms.internal.ads.Cb */
final class C8783Cb {

    /* renamed from: a */
    private static final Map<String, String> f20533a;

    /* renamed from: b */
    private final Context f20534b;

    /* renamed from: c */
    private final List<String> f20535c;

    /* renamed from: d */
    private final zzauq f20536d;

    C8783Cb(Context context, List<String> list, zzauq zzauq) {
        this.f20534b = context;
        this.f20535c = list;
        this.f20536d = zzauq;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final List<String> mo28069a(String[] strArr) {
        boolean z;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Iterator it = this.f20535c.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                String str2 = (String) it.next();
                if (!str2.equals(str)) {
                    String valueOf = String.valueOf("android.webkit.resource.");
                    String valueOf2 = String.valueOf(str2);
                    if ((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).equals(str)) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                if (f20533a.containsKey(str)) {
                    zzk.zzlg();
                    if (!zzaxi.m26116a(this.f20534b, (String) f20533a.get(str))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                } else {
                    this.f20536d.mo30110c(str);
                }
            } else {
                this.f20536d.mo30109b(str);
            }
        }
        return arrayList;
    }

    static {
        HashMap hashMap = new HashMap();
        if (PlatformVersion.m22114h()) {
            hashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            hashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        f20533a = hashMap;
    }
}
