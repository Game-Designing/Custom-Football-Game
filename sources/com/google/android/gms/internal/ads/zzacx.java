package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzk;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p005cm.aptoide.p006pt.BuildConfig;

@zzard
public final class zzacx {

    /* renamed from: a */
    private String f24214a;

    /* renamed from: b */
    private Map<String, String> f24215b;

    /* renamed from: c */
    private Context f24216c = null;

    /* renamed from: d */
    private String f24217d = null;

    public zzacx(Context context, String str) {
        String str2;
        this.f24216c = context;
        this.f24217d = str;
        this.f24214a = (String) zzyt.m31536e().mo29599a(zzacu.f24089fa);
        this.f24215b = new LinkedHashMap();
        this.f24215b.put("s", "gmob_sdk");
        this.f24215b.put("v", "3");
        this.f24215b.put("os", VERSION.RELEASE);
        this.f24215b.put("sdk", VERSION.SDK);
        Map<String, String> map = this.f24215b;
        zzk.zzlg();
        map.put("device", zzaxi.m26121b());
        Map<String, String> map2 = this.f24215b;
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        map2.put("app", str2);
        Map<String, String> map3 = this.f24215b;
        zzk.zzlg();
        map3.put("is_lite_sdk", zzaxi.m26142j(context) ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        Future a = zzk.zzlr().mo30045a(this.f24216c);
        try {
            this.f24215b.put("network_coarse", Integer.toString(((zzase) a.get()).f24755o));
            this.f24215b.put("network_fine", Integer.toString(((zzase) a.get()).f24756p));
        } catch (Exception e) {
            zzk.zzlk().mo30168a((Throwable) e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final String mo29605c() {
        return this.f24214a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Context mo29603a() {
        return this.f24216c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final String mo29604b() {
        return this.f24217d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final Map<String, String> mo29606d() {
        return this.f24215b;
    }
}
