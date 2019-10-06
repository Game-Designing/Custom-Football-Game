package com.ironsource.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AdUnitsState implements Parcelable {
    public static final Creator<AdUnitsState> CREATOR = new C10889b();

    /* renamed from: a */
    private String f33218a;

    /* renamed from: b */
    private String f33219b;

    /* renamed from: c */
    private String f33220c;

    /* renamed from: d */
    private boolean f33221d;

    /* renamed from: e */
    private int f33222e;

    /* renamed from: f */
    private ArrayList<String> f33223f;

    /* renamed from: g */
    private ArrayList<String> f33224g;

    /* renamed from: h */
    private ArrayList<String> f33225h;

    /* renamed from: i */
    private ArrayList<String> f33226i;

    /* renamed from: j */
    private String f33227j;

    /* renamed from: k */
    private String f33228k;

    /* renamed from: l */
    private Map<String, String> f33229l;

    /* renamed from: m */
    private boolean f33230m;

    /* renamed from: n */
    private boolean f33231n;

    /* renamed from: o */
    private Map<String, String> f33232o;

    /* synthetic */ AdUnitsState(Parcel x0, C10889b x1) {
        this(x0);
    }

    public AdUnitsState() {
        m35615j();
    }

    private AdUnitsState(Parcel source) {
        m35615j();
        try {
            boolean z = true;
            this.f33221d = source.readByte() != 0;
            this.f33222e = source.readInt();
            this.f33218a = source.readString();
            this.f33219b = source.readString();
            this.f33220c = source.readString();
            this.f33227j = source.readString();
            this.f33228k = source.readString();
            this.f33229l = m35614f(source.readString());
            this.f33231n = source.readByte() != 0;
            if (source.readByte() == 0) {
                z = false;
            }
            this.f33230m = z;
            this.f33232o = m35614f(source.readString());
        } catch (Throwable th) {
            m35615j();
        }
    }

    /* renamed from: j */
    private void m35615j() {
        this.f33221d = false;
        this.f33222e = -1;
        this.f33223f = new ArrayList<>();
        this.f33224g = new ArrayList<>();
        this.f33225h = new ArrayList<>();
        this.f33226i = new ArrayList<>();
        this.f33230m = true;
        this.f33231n = false;
        String str = "";
        this.f33228k = str;
        this.f33227j = str;
        this.f33229l = new HashMap();
        this.f33232o = new HashMap();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        try {
            int i = 1;
            dest.writeByte((byte) (this.f33221d ? 1 : 0));
            dest.writeInt(this.f33222e);
            dest.writeString(this.f33218a);
            dest.writeString(this.f33219b);
            dest.writeString(this.f33220c);
            dest.writeString(this.f33227j);
            dest.writeString(this.f33228k);
            dest.writeString(new JSONObject(this.f33229l).toString());
            dest.writeByte((byte) (this.f33231n ? 1 : 0));
            if (!this.f33230m) {
                i = 0;
            }
            dest.writeByte((byte) i);
            dest.writeString(new JSONObject(this.f33232o).toString());
        } catch (Throwable th) {
        }
    }

    /* renamed from: d */
    public String mo35626d() {
        return this.f33227j;
    }

    /* renamed from: e */
    public String mo35629e() {
        return this.f33228k;
    }

    /* renamed from: i */
    public boolean mo35634i() {
        return this.f33221d;
    }

    /* renamed from: c */
    public int mo35623c() {
        return this.f33222e;
    }

    /* renamed from: b */
    public String mo35620b() {
        return this.f33220c;
    }

    /* renamed from: h */
    public boolean mo35633h() {
        return this.f33230m;
    }

    /* renamed from: a */
    public void mo35618a(Map<String, String> offerWallExtraParams) {
        this.f33232o = offerWallExtraParams;
    }

    /* renamed from: b */
    public void mo35621b(String mInterstitialAppKey) {
        this.f33227j = mInterstitialAppKey;
    }

    /* renamed from: c */
    public void mo35624c(String mInterstitialUserId) {
        this.f33228k = mInterstitialUserId;
    }

    /* renamed from: a */
    public void mo35617a(String demandSourceName, boolean shouldReport) {
        if (TextUtils.isEmpty(demandSourceName)) {
            return;
        }
        if (!shouldReport) {
            this.f33225h.remove(demandSourceName);
        } else if (this.f33225h.indexOf(demandSourceName) == -1) {
            this.f33225h.add(demandSourceName);
        }
    }

    /* renamed from: c */
    public void mo35625c(boolean mShouldRestore) {
        this.f33221d = mShouldRestore;
    }

    /* renamed from: a */
    public void mo35615a(int product) {
        this.f33222e = product;
    }

    /* renamed from: a */
    public void mo35614a() {
        this.f33222e = -1;
    }

    /* renamed from: a */
    public void mo35619a(boolean offerwallInitSuccess) {
        this.f33231n = offerwallInitSuccess;
    }

    /* renamed from: b */
    public void mo35622b(boolean offerwallReportInit) {
        this.f33230m = offerwallReportInit;
    }

    /* renamed from: f */
    public String mo35631f() {
        return this.f33218a;
    }

    /* renamed from: d */
    public void mo35627d(String mRVAppKey) {
        this.f33218a = mRVAppKey;
    }

    /* renamed from: g */
    public String mo35632g() {
        return this.f33219b;
    }

    /* renamed from: a */
    public void mo35616a(String displayedDemandSourceName) {
        this.f33220c = displayedDemandSourceName;
    }

    /* renamed from: e */
    public void mo35630e(String mRVUserId) {
        this.f33219b = mRVUserId;
    }

    /* renamed from: f */
    private Map<String, String> m35614f(String jsonString) {
        Map<String, String> result = new HashMap<>();
        try {
            JSONObject json = new JSONObject(jsonString);
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                result.put(key, json.getString(key));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
        return result;
    }

    public String toString() {
        String str = ", ";
        StringBuilder builder = new StringBuilder();
        try {
            builder.append("shouldRestore:");
            builder.append(this.f33221d);
            builder.append(str);
            builder.append("displayedProduct:");
            builder.append(this.f33222e);
            builder.append(str);
            builder.append("ISReportInit:");
            builder.append(this.f33223f);
            builder.append(str);
            builder.append("ISInitSuccess:");
            builder.append(this.f33224g);
            builder.append(str);
            builder.append("ISAppKey");
            builder.append(this.f33227j);
            builder.append(str);
            builder.append("ISUserId");
            builder.append(this.f33228k);
            builder.append(str);
            builder.append("ISExtraParams");
            builder.append(this.f33229l);
            builder.append(str);
            builder.append("OWReportInit");
            builder.append(this.f33230m);
            builder.append(str);
            builder.append("OWInitSuccess");
            builder.append(this.f33231n);
            builder.append(str);
            builder.append("OWExtraParams");
            builder.append(this.f33232o);
            builder.append(str);
        } catch (Throwable th) {
        }
        return builder.toString();
    }
}
