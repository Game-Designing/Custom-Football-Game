package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.dv */
public final class C11806dv extends C11790ab implements Parcelable {
    public static final Creator CREATOR = new C11784Za();

    /* renamed from: c */
    private boolean f37173c;

    /* renamed from: d */
    private String f37174d;

    static {
        C11806dv.class.getSimpleName();
    }

    public C11806dv(Parcel parcel) {
        super(parcel);
        this.f37174d = parcel.readString();
        this.f37173c = parcel.readByte() != 0;
    }

    public C11806dv(String str, String str2, long j, boolean z) {
        this.f37118a = str;
        this.f37119b = j;
        this.f37174d = str2;
        this.f37173c = z;
    }

    /* renamed from: c */
    public final boolean mo38736c() {
        return this.f37173c;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C11806dv.class.getSimpleName());
        sb.append("(token:");
        sb.append(this.f37118a);
        sb.append(", mGoodUntil:");
        sb.append(this.f37119b);
        sb.append(", isCreatedInternally:");
        sb.append(this.f37173c);
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37118a);
        parcel.writeLong(this.f37119b);
        parcel.writeString(this.f37174d);
        parcel.writeByte(this.f37173c ? (byte) 1 : 0);
    }
}
