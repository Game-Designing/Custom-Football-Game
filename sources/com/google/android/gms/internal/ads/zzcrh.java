package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class zzcrh implements zzcuz<Bundle> {

    /* renamed from: a */
    private final zzcxv f27275a;

    public zzcrh(zzcxv zzcxv) {
        Preconditions.m21858a(zzcxv, (Object) "the targeting must not be null");
        this.f27275a = zzcxv;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzcxv zzcxv = this.f27275a;
        zzxz zzxz = zzcxv.f27600d;
        bundle.putString("slotname", zzcxv.f27602f);
        boolean z = true;
        if (this.f27275a.f27611o.contains("new_rewarded")) {
            bundle.putBoolean("is_new_rewarded", true);
        }
        zzcxz.m28994a(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzxz.f29724b)), zzxz.f29724b != -1);
        zzcxz.m28990a(bundle, "extras", zzxz.f29725c);
        zzcxz.m28992a(bundle, "cust_gender", Integer.valueOf(zzxz.f29726d), zzxz.f29726d != -1);
        zzcxz.m28995a(bundle, "kw", zzxz.f29727e);
        zzcxz.m28992a(bundle, "tag_for_child_directed_treatment", Integer.valueOf(zzxz.f29729g), zzxz.f29729g != -1);
        boolean z2 = zzxz.f29728f;
        if (z2) {
            bundle.putBoolean("test_request", z2);
        }
        zzcxz.m28992a(bundle, "d_imp_hdr", Integer.valueOf(1), zzxz.f29723a >= 2 && zzxz.f29730h);
        String str = zzxz.f29731i;
        zzcxz.m28994a(bundle, "ppid", str, zzxz.f29723a >= 2 && !TextUtils.isEmpty(str));
        Location location = zzxz.f29733k;
        if (location != null) {
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", valueOf.floatValue());
            bundle2.putLong("lat", valueOf3.longValue());
            bundle2.putLong("long", valueOf4.longValue());
            bundle2.putLong("time", valueOf2.longValue());
            bundle.putBundle("uule", bundle2);
        }
        zzcxz.m28993a(bundle, "url", zzxz.f29734l);
        zzcxz.m28990a(bundle, "custom_targeting", zzxz.f29736n);
        zzcxz.m28995a(bundle, "category_exclusions", zzxz.f29737o);
        zzcxz.m28993a(bundle, "request_agent", zzxz.f29738p);
        zzcxz.m28993a(bundle, "request_pkg", zzxz.f29739q);
        zzcxz.m28991a(bundle, "is_designed_for_families", Boolean.valueOf(zzxz.f29740r), zzxz.f29723a >= 7);
        if (zzxz.f29723a >= 8) {
            Integer valueOf5 = Integer.valueOf(zzxz.f29742t);
            if (zzxz.f29742t == -1) {
                z = false;
            }
            zzcxz.m28992a(bundle, "tag_for_under_age_of_consent", valueOf5, z);
            zzcxz.m28993a(bundle, "max_ad_content_rating", zzxz.f29743u);
        }
    }
}
