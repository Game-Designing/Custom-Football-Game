package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.eo */
public final class C11814eo implements Parcelable {
    public static final Creator CREATOR = new C11852nb();

    /* renamed from: a */
    private String f37185a;

    /* renamed from: b */
    private String f37186b;

    /* renamed from: c */
    private C11816eu f37187c;

    /* renamed from: d */
    private String f37188d;

    public C11814eo(Parcel parcel) {
        this.f37185a = parcel.readString();
        this.f37186b = parcel.readString();
        this.f37187c = (C11816eu) parcel.readParcelable(C11816eu.class.getClassLoader());
        this.f37188d = parcel.readString();
    }

    public C11814eo(C11816eu euVar, String str) {
        this.f37187c = euVar;
        this.f37188d = str;
    }

    public C11814eo(String str, String str2) {
        this.f37185a = str;
        this.f37186b = str2;
    }

    /* renamed from: a */
    public final boolean mo38772a() {
        return this.f37185a != null;
    }

    /* renamed from: b */
    public final String mo38773b() {
        return this.f37185a;
    }

    /* renamed from: c */
    public final String mo38774c() {
        return this.f37186b;
    }

    /* renamed from: d */
    public final C11816eu mo38775d() {
        return this.f37187c;
    }

    public final int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public final String mo38777e() {
        return this.f37188d;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37185a);
        parcel.writeString(this.f37186b);
        parcel.writeParcelable(this.f37187c, 0);
        parcel.writeString(this.f37188d);
    }
}
