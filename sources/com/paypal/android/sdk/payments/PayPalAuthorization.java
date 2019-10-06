package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class PayPalAuthorization implements Parcelable {
    public static final Creator CREATOR = new C11878J();

    /* renamed from: a */
    private final String f37347a;

    /* renamed from: b */
    private final String f37348b;

    /* renamed from: c */
    private final String f37349c;

    static {
        PayPalAuthorization.class.getSimpleName();
    }

    private PayPalAuthorization(Parcel parcel) {
        this.f37347a = parcel.readString();
        this.f37348b = parcel.readString();
        this.f37349c = parcel.readString();
    }

    /* synthetic */ PayPalAuthorization(Parcel parcel, byte b) {
        this(parcel);
    }

    PayPalAuthorization(String str, String str2, String str3) {
        this.f37347a = str;
        this.f37348b = str2;
        if ("partner".equals("general")) {
            this.f37349c = str3;
        } else {
            this.f37349c = null;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37347a);
        parcel.writeString(this.f37348b);
        parcel.writeString(this.f37349c);
    }
}
