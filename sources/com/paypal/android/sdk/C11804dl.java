package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: com.paypal.android.sdk.dl */
public final class C11804dl implements Parcelable {
    public static final Creator CREATOR = new C11760Ra();

    /* renamed from: a */
    private C11816eu f37164a;

    /* renamed from: b */
    private String f37165b;

    /* renamed from: c */
    private C11763Sa f37166c;

    public C11804dl() {
    }

    public C11804dl(Parcel parcel) {
        this.f37164a = (C11816eu) parcel.readParcelable(C11816eu.class.getClassLoader());
        this.f37165b = parcel.readString();
        this.f37166c = (C11763Sa) parcel.readSerializable();
    }

    public C11804dl(String str, C11816eu euVar, C11763Sa sa) {
        this.f37165b = str;
        this.f37164a = euVar;
        this.f37166c = sa;
    }

    /* renamed from: a */
    public final C11816eu mo38717a() {
        return this.f37164a;
    }

    /* renamed from: a */
    public final void mo38718a(C11763Sa sa) {
        this.f37166c = sa;
    }

    /* renamed from: a */
    public final void mo38719a(C11816eu euVar) {
        this.f37164a = euVar;
    }

    /* renamed from: a */
    public final void mo38720a(String str) {
        this.f37165b = str;
    }

    /* renamed from: b */
    public final String mo38721b() {
        return this.f37165b;
    }

    /* renamed from: c */
    public final C11763Sa mo38722c() {
        return this.f37166c;
    }

    /* renamed from: d */
    public final boolean mo38723d() {
        C11763Sa sa = this.f37166c;
        return !(sa == null || ((this.f37164a == null && sa.equals(C11763Sa.PHONE)) || (TextUtils.isEmpty(this.f37165b) && this.f37166c.equals(C11763Sa.EMAIL))));
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f37164a, 0);
        parcel.writeString(this.f37165b);
        parcel.writeSerializable(this.f37166c);
    }
}
