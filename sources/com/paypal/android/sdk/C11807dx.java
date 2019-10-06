package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.dx */
public final class C11807dx implements Parcelable {
    public static final Creator CREATOR = new C11786_a();

    /* renamed from: a */
    private String f37175a;

    /* renamed from: b */
    private String f37176b;

    static {
        C11807dx.class.getSimpleName();
    }

    public C11807dx(Parcel parcel) {
        this.f37175a = parcel.readString();
        this.f37176b = parcel.readString();
    }

    public C11807dx(String str, String str2) {
        this.f37175a = str;
        this.f37176b = str2;
    }

    /* renamed from: a */
    public final String mo38740a() {
        return this.f37175a;
    }

    /* renamed from: b */
    public final String mo38741b() {
        return this.f37176b;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C11807dx.class.getSimpleName());
        sb.append("(authCode:");
        sb.append(this.f37175a);
        sb.append(", scope:");
        sb.append(this.f37176b);
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37175a);
        parcel.writeString(this.f37176b);
    }
}
