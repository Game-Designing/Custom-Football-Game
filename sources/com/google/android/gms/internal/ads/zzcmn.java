package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class zzcmn<AdT> implements zzcjv<AdT> {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract zzbbh<AdT> mo31209a(zzcxv zzcxv, Bundle bundle);

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        return !TextUtils.isEmpty(zzcxm.f27568s.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    /* renamed from: a */
    public final zzbbh<AdT> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        zzcxu zzcxu2 = zzcxu;
        zzcxm zzcxm2 = zzcxm;
        String optString = zzcxm2.f27568s.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzcxv zzcxv = zzcxu2.f27595a.f27589a;
        zzcxx a = new zzcxx().mo31291a(zzcxv.f27600d).mo31292a(zzcxv.f27601e).mo31293a(zzcxv.f27597a).mo31294a(zzcxv.f27602f).mo31288a(zzcxv.f27598b).mo31295a(zzcxv.f27603g).mo31299b(zzcxv.f27604h).mo31289a(zzcxv.f27605i).mo31298b(zzcxv.f27606j).mo31287a(zzcxv.f27609m).mo31302c(zzcxv.f27607k).mo31294a(optString);
        Bundle a2 = m28587a(zzcxv.f27600d.f29735m);
        String str = "com.google.ads.mediation.admob.AdMobAdapter";
        Bundle a3 = m28587a(a2.getBundle(str));
        a3.putInt("gw", 1);
        String str2 = "mad_hac";
        String optString2 = zzcxm2.f27568s.optString(str2, null);
        if (optString2 != null) {
            a3.putString(str2, optString2);
        }
        String optString3 = zzcxm2.f27568s.optString("adJson", null);
        if (optString3 != null) {
            a3.putString("_ad", optString3);
        }
        a3.putBoolean("_noRefresh", true);
        Iterator keys = zzcxm2.f27535A.keys();
        while (keys.hasNext()) {
            String str3 = (String) keys.next();
            String optString4 = zzcxm2.f27535A.optString(str3, null);
            if (str3 != null) {
                a3.putString(str3, optString4);
            }
        }
        a2.putBundle(str, a3);
        zzxz zzxz = zzcxv.f27600d;
        zzxz zzxz2 = r5;
        zzxz zzxz3 = new zzxz(zzxz.f29723a, zzxz.f29724b, a3, zzxz.f29726d, zzxz.f29727e, zzxz.f29728f, zzxz.f29729g, zzxz.f29730h, zzxz.f29731i, zzxz.f29732j, zzxz.f29733k, zzxz.f29734l, a2, zzxz.f29736n, zzxz.f29737o, zzxz.f29738p, zzxz.f29739q, zzxz.f29740r, zzxz.f29741s, zzxz.f29742t, zzxz.f29743u);
        zzcxv c = a.mo31291a(zzxz2).mo31301c();
        Bundle bundle = new Bundle();
        zzcxu zzcxu3 = zzcxu;
        zzcxo zzcxo = zzcxu3.f27596b.f27591b;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzcxo.f27579a));
        bundle2.putInt("refresh_interval", zzcxo.f27581c);
        bundle2.putString("gws_query_id", zzcxo.f27580b);
        bundle.putBundle("parent_common_config", bundle2);
        String str4 = zzcxu3.f27595a.f27589a.f27602f;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str4);
        zzcxm zzcxm3 = zzcxm;
        bundle3.putString("allocation_id", zzcxm3.f27569t);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzcxm3.f27552c));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzcxm3.f27553d));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzcxm3.f27563n));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzcxm3.f27562m));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzcxm3.f27556g));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzcxm3.f27557h));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzcxm3.f27558i));
        bundle3.putString("transaction_id", zzcxm3.f27559j);
        bundle3.putString("valid_from_timestamp", zzcxm3.f27560k);
        bundle3.putBoolean("is_closable_area_disabled", zzcxm3.f27541G);
        if (zzcxm3.f27561l != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzcxm3.f27561l.f24821b);
            bundle4.putString("rb_type", zzcxm3.f27561l.f24820a);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return mo31209a(c, bundle);
    }

    /* renamed from: a */
    private static Bundle m28587a(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }
}
