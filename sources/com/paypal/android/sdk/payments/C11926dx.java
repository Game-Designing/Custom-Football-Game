package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.paypal.android.sdk.C11708Bb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.payments.dx */
final class C11926dx implements Parcelable {
    public static final Creator CREATOR = new C11911_a();

    /* renamed from: a */
    private JSONArray f37533a;

    /* renamed from: b */
    private ShippingAddress f37534b;

    /* renamed from: c */
    private int f37535c = -1;

    /* renamed from: d */
    private int f37536d;

    /* renamed from: e */
    private JSONObject f37537e;

    /* renamed from: f */
    private JSONArray f37538f;

    /* renamed from: g */
    private int f37539g = -1;

    /* renamed from: h */
    private String f37540h;

    /* renamed from: i */
    private String f37541i;

    public C11926dx(Parcel parcel) {
        if (parcel != null) {
            try {
                String readString = parcel.readString();
                if (readString != null) {
                    this.f37533a = new JSONArray(readString);
                } else {
                    this.f37533a = null;
                }
            } catch (JSONException e) {
                this.f37533a = null;
            }
            this.f37534b = (ShippingAddress) parcel.readParcelable(ShippingAddress.class.getClassLoader());
            try {
                String readString2 = parcel.readString();
                if (readString2 != null) {
                    this.f37537e = new JSONObject(readString2);
                } else {
                    this.f37537e = null;
                }
            } catch (JSONException e2) {
                this.f37537e = null;
            }
            try {
                String readString3 = parcel.readString();
                if (readString3 != null) {
                    this.f37538f = new JSONArray(readString3);
                } else {
                    this.f37538f = null;
                }
            } catch (JSONException e3) {
                this.f37538f = null;
            }
            this.f37540h = parcel.readString();
            this.f37541i = parcel.readString();
            this.f37539g = parcel.readInt();
            this.f37535c = parcel.readInt();
            this.f37536d = parcel.readInt();
        }
    }

    public C11926dx(C11708Bb bb, ShippingAddress shippingAddress) {
        this.f37533a = bb.mo38540v();
        this.f37537e = bb.mo38541w();
        this.f37538f = bb.mo38542x();
        this.f37540h = bb.mo38538t();
        this.f37541i = bb.mo38539u();
        this.f37534b = shippingAddress;
        ShippingAddress shippingAddress2 = this.f37534b;
        if (shippingAddress2 != null) {
            this.f37535c = 0;
            this.f37536d = m39533a(shippingAddress2, this.f37533a);
            return;
        }
        this.f37535c = m39534a(this.f37533a);
        this.f37536d = -1;
    }

    /* renamed from: a */
    private static int m39533a(ShippingAddress shippingAddress, JSONArray jSONArray) {
        if (!(shippingAddress == null || jSONArray == null)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (shippingAddress.mo39045a(jSONArray.optJSONObject(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    private static int m39534a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return -1;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.optJSONObject(i).optBoolean("default_address", false)) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public final JSONArray mo39094a() {
        return this.f37533a;
    }

    /* renamed from: a */
    public final void mo39095a(int i) {
        this.f37539g = i;
    }

    /* renamed from: b */
    public final ShippingAddress mo39096b() {
        return this.f37534b;
    }

    /* renamed from: b */
    public final void mo39097b(int i) {
        this.f37535c = i;
    }

    /* renamed from: c */
    public final JSONObject mo39098c() {
        return this.f37537e;
    }

    /* renamed from: d */
    public final JSONArray mo39099d() {
        return this.f37538f;
    }

    public final int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public final String mo39101e() {
        return this.f37540h;
    }

    /* renamed from: f */
    public final String mo39102f() {
        return this.f37541i;
    }

    /* renamed from: g */
    public final int mo39103g() {
        int i = this.f37539g;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    /* renamed from: h */
    public final int mo39104h() {
        int i = this.f37535c;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    /* renamed from: i */
    public final int mo39105i() {
        return this.f37536d;
    }

    /* renamed from: j */
    public final boolean mo39106j() {
        return this.f37539g != -1;
    }

    /* renamed from: k */
    public final boolean mo39107k() {
        return this.f37535c != -1;
    }

    /* renamed from: l */
    public final JSONObject mo39108l() {
        int i = this.f37539g;
        if (i <= 0) {
            return null;
        }
        return this.f37538f.optJSONObject(i - 1);
    }

    /* renamed from: m */
    public final JSONObject mo39109m() {
        int i = this.f37535c;
        if (i < 0) {
            return null;
        }
        ShippingAddress shippingAddress = this.f37534b;
        if (shippingAddress != null) {
            if (i == 0) {
                i = this.f37536d;
                if (i < 0) {
                    return shippingAddress.mo39044a();
                }
            } else {
                i--;
                int i2 = this.f37536d;
                if (i2 >= 0 && i >= i2) {
                    i++;
                }
            }
        }
        return this.f37533a.optJSONObject(i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        JSONArray jSONArray = this.f37533a;
        String str = null;
        parcel.writeString(jSONArray != null ? jSONArray.toString() : null);
        parcel.writeParcelable(this.f37534b, 0);
        JSONObject jSONObject = this.f37537e;
        parcel.writeString(jSONObject != null ? jSONObject.toString() : null);
        JSONArray jSONArray2 = this.f37538f;
        if (jSONArray2 != null) {
            str = jSONArray2.toString();
        }
        parcel.writeString(str);
        parcel.writeString(this.f37540h);
        parcel.writeString(this.f37541i);
        parcel.writeInt(this.f37539g);
        parcel.writeInt(this.f37535c);
        parcel.writeInt(this.f37536d);
    }
}
