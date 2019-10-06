package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.telephony.PhoneNumberUtils;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.paypal.android.sdk.eu */
public class C11816eu implements Parcelable {
    public static final Creator CREATOR = new C12000rb();

    /* renamed from: a */
    private static HashMap f37192a;

    /* renamed from: b */
    private C11812eh f37193b;

    /* renamed from: c */
    private String f37194c;

    static {
        HashMap hashMap = new HashMap();
        f37192a = hashMap;
        String str = "1";
        hashMap.put("US", str);
        f37192a.put("CA", str);
        String str2 = "44";
        f37192a.put("GB", str2);
        f37192a.put("FR", "33");
        f37192a.put("IT", "39");
        f37192a.put("ES", "34");
        f37192a.put("AU", "61");
        f37192a.put("MY", "60");
        String str3 = "65";
        String str4 = "SG";
        f37192a.put(str4, str3);
        f37192a.put("AR", "54");
        f37192a.put("UK", str2);
        f37192a.put("ZA", "27");
        f37192a.put("GR", "30");
        f37192a.put("NL", "31");
        f37192a.put("BE", "32");
        f37192a.put(str4, str3);
        f37192a.put("PT", "351");
        f37192a.put("LU", "352");
        f37192a.put("IE", "353");
        f37192a.put("IS", "354");
        f37192a.put("MT", "356");
        f37192a.put("CY", "357");
        f37192a.put("FI", "358");
        f37192a.put("HU", "36");
        f37192a.put("LT", "370");
        f37192a.put("LV", "371");
        f37192a.put("EE", "372");
        f37192a.put("SI", "386");
        f37192a.put("CH", "41");
        f37192a.put("CZ", "420");
        f37192a.put("SK", "421");
        f37192a.put("AT", "43");
        f37192a.put("DK", "45");
        f37192a.put("SE", "46");
        f37192a.put("NO", "47");
        f37192a.put("PL", "48");
        f37192a.put("DE", "49");
        f37192a.put("MX", "52");
        f37192a.put("BR", "55");
        f37192a.put("NZ", "64");
        f37192a.put("TH", "66");
        f37192a.put("JP", "81");
        f37192a.put("KR", "82");
        f37192a.put("HK", "852");
        f37192a.put("CN", "86");
        f37192a.put("TW", "886");
        f37192a.put("TR", "90");
        f37192a.put("IN", "91");
        f37192a.put("IL", "972");
        f37192a.put("MC", "377");
        f37192a.put("CR", "506");
        f37192a.put("CL", "56");
        f37192a.put("VE", "58");
        f37192a.put("EC", "593");
        f37192a.put("UY", "598");
    }

    public C11816eu(Parcel parcel) {
        this.f37193b = (C11812eh) parcel.readParcelable(C11812eh.class.getClassLoader());
        this.f37194c = parcel.readString();
    }

    public C11816eu(C11996qb qbVar, C11812eh ehVar, String str) {
        String e = C11992pb.m39653e(str);
        qbVar.mo38575a(e);
        m39130a(ehVar, e);
    }

    public C11816eu(C11996qb qbVar, String str) {
        C11812eh d = qbVar.mo38578d();
        String e = C11992pb.m39653e(str);
        qbVar.mo38575a(e);
        m39130a(d, e);
    }

    /* renamed from: a */
    public static C11816eu m39129a(C11996qb qbVar, String str) {
        String[] split = str.split("[|]");
        if (split.length == 2) {
            return new C11816eu(qbVar, new C11812eh(split[0]), split[1]);
        }
        throw new C11813en("");
    }

    /* renamed from: a */
    private void m39130a(C11812eh ehVar, String str) {
        this.f37193b = ehVar;
        this.f37194c = str;
    }

    /* renamed from: a */
    public final String mo38784a() {
        return this.f37194c;
    }

    /* renamed from: a */
    public final String mo38785a(C11996qb qbVar) {
        return qbVar.mo38576b().equals(Locale.US) ? PhoneNumberUtils.formatNumber(this.f37194c) : this.f37194c;
    }

    /* renamed from: b */
    public final String mo38786b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37193b.mo38767a());
        sb.append("|");
        sb.append(this.f37194c);
        return sb.toString();
    }

    /* renamed from: c */
    public final String mo38787c() {
        return (String) f37192a.get(this.f37193b.mo38767a());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f37193b, 0);
        parcel.writeString(this.f37194c);
    }
}
