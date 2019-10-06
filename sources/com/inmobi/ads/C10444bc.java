package com.inmobi.ads;

import android.content.ContentValues;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.bc */
/* compiled from: NativeVideoAd */
class C10444bc extends C10359a {

    /* renamed from: o */
    private static final String f31768o = C10444bc.class.getSimpleName();

    /* renamed from: l */
    final String f31769l;

    /* renamed from: m */
    final String f31770m;

    /* renamed from: n */
    final String f31771n;

    /* renamed from: p */
    private final String f31772p;

    /* renamed from: q */
    private final String f31773q;

    C10444bc(JSONObject jSONObject, String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, MonetizationContext monetizationContext, boolean z, long j2, float f, String str11) {
        super(jSONObject, str, j, str2, str3, str4, str5, monetizationContext, z, j2, f, str11);
        this.f31769l = str6;
        this.f31770m = str7;
        this.f31771n = str8;
        this.f31772p = str9;
        this.f31773q = str10;
    }

    C10444bc(ContentValues contentValues) {
        super(contentValues);
        this.f31769l = contentValues.getAsString("video_url");
        this.f31770m = contentValues.getAsString("video_track_duration");
        this.f31771n = contentValues.getAsString("click_url");
        this.f31772p = contentValues.getAsString("video_trackers");
        this.f31773q = contentValues.getAsString("companion_ads");
    }

    /* renamed from: a */
    public final ContentValues mo33949a() {
        ContentValues a = super.mo33949a();
        a.put("video_url", this.f31769l);
        a.put("video_track_duration", this.f31770m);
        a.put("click_url", this.f31771n);
        a.put("video_trackers", this.f31772p);
        a.put("companion_ads", this.f31773q);
        return a;
    }

    /* renamed from: h */
    public final List<NativeTracker> mo34145h() {
        ArrayList arrayList = new ArrayList();
        String str = this.f31772p;
        if (str == null || str.length() == 0) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.f31772p);
            if (jSONArray.length() == 0) {
                return arrayList;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                NativeTracker a = NativeTracker.m33703a(new JSONObject(jSONArray.getString(i)));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return arrayList;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final List<C10468bt> mo34146i() {
        ArrayList arrayList = new ArrayList();
        String str = this.f31773q;
        if (str == null || str.length() == 0) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.f31773q);
            if (jSONArray.length() == 0) {
                return arrayList;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                C10468bt a = C10468bt.m34256a(new JSONObject(jSONArray.getString(i)));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return arrayList;
        }
    }
}
