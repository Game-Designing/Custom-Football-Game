package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.Date;

/* renamed from: com.paypal.android.sdk.ds */
public final class C11805ds extends C11766Ta implements Parcelable {
    public static final Creator CREATOR = new C11778Xa();

    /* renamed from: b */
    private String f37167b;

    /* renamed from: c */
    private Date f37168c;

    /* renamed from: d */
    private String f37169d;

    /* renamed from: e */
    private C11781Ya f37170e;

    /* renamed from: f */
    private int f37171f;

    /* renamed from: g */
    private int f37172g;

    public C11805ds() {
    }

    private C11805ds(Parcel parcel) {
        this.f37033a = parcel.readString();
        this.f37167b = parcel.readString();
        this.f37169d = parcel.readString();
        this.f37168c = (Date) parcel.readSerializable();
        this.f37170e = (C11781Ya) parcel.readSerializable();
        this.f37171f = parcel.readInt();
        this.f37172g = parcel.readInt();
    }

    /* synthetic */ C11805ds(Parcel parcel, byte b) {
        this(parcel);
    }

    public C11805ds(C11788a aVar, String str, String str2, Date date, String str3, String str4, int i, int i2) {
        this.f37033a = aVar.mo38693b(str2);
        this.f37167b = str;
        this.f37168c = date;
        m39086b(str3);
        m39087c(str4);
        this.f37171f = i;
        this.f37172g = i2;
    }

    public C11805ds(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        this.f37033a = str2;
        this.f37167b = str;
        this.f37168c = C12004sb.m39705a(str3);
        m39086b(str4);
        m39087c(str5);
        this.f37171f = i;
        this.f37172g = i2;
    }

    /* renamed from: a */
    public static String m39085a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("x-");
        sb.append(str.substring(str.length() - 4));
        return sb.toString();
    }

    /* renamed from: b */
    private void m39086b(String str) {
        this.f37169d = str != null ? str.substring(str.length() - 4) : null;
    }

    /* renamed from: c */
    private void m39087c(String str) {
        this.f37170e = C11781Ya.m39015a(str);
    }

    /* renamed from: b */
    public final boolean mo38726b() {
        if (!TextUtils.isEmpty(this.f37167b) && !TextUtils.isEmpty(this.f37169d) && !TextUtils.isEmpty(this.f37033a)) {
            Date date = this.f37168c;
            if (date != null && !date.before(new Date())) {
                C11781Ya ya = this.f37170e;
                if (!(ya == null || ya == C11781Ya.UNKNOWN)) {
                    int i = this.f37171f;
                    if (i > 0 && i <= 12) {
                        int i2 = this.f37172g;
                        if (i2 >= 0 && i2 <= 9999) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public final Date mo38727c() {
        return this.f37168c;
    }

    /* renamed from: d */
    public final String mo38728d() {
        return m39085a(this.f37169d);
    }

    public final int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public final String mo38730e() {
        return this.f37167b;
    }

    /* renamed from: f */
    public final int mo38731f() {
        return this.f37171f;
    }

    /* renamed from: g */
    public final int mo38732g() {
        return this.f37172g;
    }

    /* renamed from: h */
    public final C11781Ya mo38733h() {
        return this.f37170e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TokenizedCreditCard(token=");
        sb.append(this.f37167b);
        sb.append(",lastFourDigits=");
        sb.append(this.f37169d);
        sb.append(",payerId=");
        sb.append(this.f37033a);
        sb.append(",tokenValidUntil=");
        sb.append(this.f37168c);
        sb.append(",cardType=");
        sb.append(this.f37170e);
        sb.append(",expiryMonth/year=");
        sb.append(this.f37171f);
        sb.append("/");
        sb.append(this.f37172g);
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37033a);
        parcel.writeString(this.f37167b);
        parcel.writeString(this.f37169d);
        parcel.writeSerializable(this.f37168c);
        parcel.writeSerializable(this.f37170e);
        parcel.writeInt(this.f37171f);
        parcel.writeInt(this.f37172g);
    }
}
