package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzaxi;
import java.util.List;

@zzard
public final class zzb {

    /* renamed from: a */
    private final Context f19121a;

    /* renamed from: b */
    private boolean f19122b;

    /* renamed from: c */
    private zzavb f19123c;

    /* renamed from: d */
    private zzark f19124d = null;

    public zzb(Context context, zzavb zzavb, zzark zzark) {
        this.f19121a = context;
        this.f19123c = zzavb;
        if (this.f19124d == null) {
            this.f19124d = new zzark();
        }
    }

    /* renamed from: a */
    private final boolean m20838a() {
        zzavb zzavb = this.f19123c;
        return (zzavb != null && zzavb.mo30112d().f24854f) || this.f19124d.f24710a;
    }

    public final void recordClick() {
        this.f19122b = true;
    }

    public final boolean zzkx() {
        return !m20838a() || this.f19122b;
    }

    public final void zzbk(String str) {
        if (m20838a()) {
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            zzavb zzavb = this.f19123c;
            if (zzavb != null) {
                zzavb.mo30106a(str, null, 3);
                return;
            }
            zzark zzark = this.f19124d;
            if (zzark.f24710a) {
                List<String> list = zzark.f24711b;
                if (list != null) {
                    for (String str3 : list) {
                        if (!TextUtils.isEmpty(str3)) {
                            String replace = str3.replace("{NAVIGATION_URL}", Uri.encode(str));
                            zzk.zzlg();
                            zzaxi.m26111a(this.f19121a, str2, replace);
                        }
                    }
                }
            }
        }
    }
}
