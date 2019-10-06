package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzcro implements zzcuz<Bundle> {

    /* renamed from: a */
    private final zzyd f27282a;

    /* renamed from: b */
    private final String f27283b;

    /* renamed from: c */
    private final boolean f27284c;

    /* renamed from: d */
    private final String f27285d;

    /* renamed from: e */
    private final float f27286e;

    /* renamed from: f */
    private final int f27287f;

    /* renamed from: g */
    private final int f27288g;

    /* renamed from: h */
    private final String f27289h;

    public zzcro(zzyd zzyd, String str, boolean z, String str2, float f, int i, int i2, String str3) {
        Preconditions.m21858a(zzyd, (Object) "the adSize must not be null");
        this.f27282a = zzyd;
        this.f27283b = str;
        this.f27284c = z;
        this.f27285d = str2;
        this.f27286e = f;
        this.f27287f = i;
        this.f27288g = i2;
        this.f27289h = str3;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzcxz.m28994a(bundle, "smart_w", "full", this.f27282a.f29772e == -1);
        zzcxz.m28994a(bundle, "smart_h", "auto", this.f27282a.f29769b == -2);
        zzcxz.m28991a(bundle, "ene", Boolean.valueOf(true), this.f27282a.f29777j);
        zzcxz.m28993a(bundle, "format", this.f27283b);
        String str = "height";
        zzcxz.m28994a(bundle, "fluid", str, this.f27284c);
        String str2 = this.f27285d;
        zzcxz.m28994a(bundle, "sz", str2, !TextUtils.isEmpty(str2));
        bundle.putFloat("u_sd", this.f27286e);
        bundle.putInt("sw", this.f27287f);
        bundle.putInt("sh", this.f27288g);
        String str3 = this.f27289h;
        zzcxz.m28994a(bundle, "sc", str3, true ^ TextUtils.isEmpty(str3));
        ArrayList arrayList = new ArrayList();
        zzyd[] zzydArr = this.f27282a.f29774g;
        String str4 = "is_fluid_height";
        String str5 = "width";
        if (zzydArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(str, this.f27282a.f29769b);
            bundle2.putInt(str5, this.f27282a.f29772e);
            bundle2.putBoolean(str4, this.f27282a.f29776i);
            arrayList.add(bundle2);
        } else {
            for (zzyd zzyd : zzydArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean(str4, zzyd.f29776i);
                bundle3.putInt(str, zzyd.f29769b);
                bundle3.putInt(str5, zzyd.f29772e);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
