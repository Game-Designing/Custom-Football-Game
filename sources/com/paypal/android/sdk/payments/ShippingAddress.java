package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.C11723Fa;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShippingAddress implements Parcelable {
    public static final Creator CREATOR = new C11914ab();

    /* renamed from: a */
    private static final String f37475a = ShippingAddress.class.getSimpleName();

    /* renamed from: b */
    private String f37476b;

    /* renamed from: c */
    private String f37477c;

    /* renamed from: d */
    private String f37478d;

    /* renamed from: e */
    private String f37479e;

    /* renamed from: f */
    private String f37480f;

    /* renamed from: g */
    private String f37481g;

    /* renamed from: h */
    private String f37482h;

    public ShippingAddress() {
    }

    private ShippingAddress(Parcel parcel) {
        this.f37476b = parcel.readString();
        this.f37477c = parcel.readString();
        this.f37478d = parcel.readString();
        this.f37479e = parcel.readString();
        this.f37480f = parcel.readString();
        this.f37481g = parcel.readString();
        this.f37482h = parcel.readString();
    }

    /* synthetic */ ShippingAddress(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    private static boolean m39505a(String str) {
        return C11723Fa.m38822b((CharSequence) str);
    }

    /* renamed from: a */
    private static boolean m39506a(String str, String str2) {
        if (C11723Fa.m38818a((CharSequence) str)) {
            return C11723Fa.m38818a((CharSequence) str2);
        }
        if (C11723Fa.m38818a((CharSequence) str2)) {
            return false;
        }
        return str.trim().equals(str2.trim());
    }

    /* renamed from: a */
    public final JSONObject mo39044a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.accumulate("recipient_name", this.f37476b);
            jSONObject.accumulate("line1", this.f37477c);
            jSONObject.accumulate("city", this.f37479e);
            jSONObject.accumulate("country_code", this.f37482h);
            if (m39505a(this.f37478d)) {
                jSONObject.accumulate("line2", this.f37478d);
            }
            if (m39505a(this.f37480f)) {
                jSONObject.accumulate("state", this.f37480f);
            }
            if (m39505a(this.f37481g)) {
                jSONObject.accumulate("postal_code", this.f37481g);
            }
        } catch (JSONException e) {
            Log.e(f37475a, e.getMessage());
        }
        return jSONObject;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo39045a(JSONObject jSONObject) {
        return m39506a(jSONObject.optString("recipient_name"), this.f37476b) && m39506a(jSONObject.optString("line1"), this.f37477c) && m39506a(jSONObject.optString("line2"), this.f37478d) && m39506a(jSONObject.optString("city"), this.f37479e) && m39506a(jSONObject.optString("state"), this.f37480f) && m39506a(jSONObject.optString("country_code"), this.f37482h) && m39506a(jSONObject.optString("postal_code"), this.f37481g);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37476b);
        parcel.writeString(this.f37477c);
        parcel.writeString(this.f37478d);
        parcel.writeString(this.f37479e);
        parcel.writeString(this.f37480f);
        parcel.writeString(this.f37481g);
        parcel.writeString(this.f37482h);
    }
}
