package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzauy extends AbstractSafeParcelable {
    public static final Creator<zzauy> CREATOR = new zzauz();

    /* renamed from: a */
    public final String f24849a;

    /* renamed from: b */
    public final String f24850b;

    /* renamed from: c */
    public final boolean f24851c;

    /* renamed from: d */
    public final boolean f24852d;

    /* renamed from: e */
    public final List<String> f24853e;

    /* renamed from: f */
    public final boolean f24854f;

    /* renamed from: g */
    public final boolean f24855g;

    /* renamed from: h */
    public final List<String> f24856h;

    @Constructor
    public zzauy(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) boolean z, @Param(id = 5) boolean z2, @Param(id = 6) List<String> list, @Param(id = 7) boolean z3, @Param(id = 8) boolean z4, @Param(id = 9) List<String> list2) {
        this.f24849a = str;
        this.f24850b = str2;
        this.f24851c = z;
        this.f24852d = z2;
        this.f24853e = list;
        this.f24854f = z3;
        this.f24855g = z4;
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        this.f24856h = list2;
    }

    /* renamed from: a */
    public static zzauy m25881a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String str = "";
        zzauy zzauy = new zzauy(jSONObject.optString("click_string", str), jSONObject.optString("report_url", str), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzazc.m26263a(jSONObject.optJSONArray("allowed_headers"), null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzazc.m26263a(jSONObject.optJSONArray("webview_permissions"), null));
        return zzauy;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f24849a, false);
        SafeParcelWriter.m21965a(parcel, 3, this.f24850b, false);
        SafeParcelWriter.m21968a(parcel, 4, this.f24851c);
        SafeParcelWriter.m21968a(parcel, 5, this.f24852d);
        SafeParcelWriter.m21975b(parcel, 6, this.f24853e, false);
        SafeParcelWriter.m21968a(parcel, 7, this.f24854f);
        SafeParcelWriter.m21968a(parcel, 8, this.f24855g);
        SafeParcelWriter.m21975b(parcel, 9, this.f24856h, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
