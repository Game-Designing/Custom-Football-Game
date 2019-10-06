package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.paypal.android.sdk.C11723Fa;

public final class ProofOfPayment implements Parcelable {
    public static final Creator CREATOR = new C11910Za();

    /* renamed from: a */
    private static final String f37466a = ProofOfPayment.class.getSimpleName();

    /* renamed from: b */
    private String f37467b;

    /* renamed from: c */
    private String f37468c;

    /* renamed from: d */
    private String f37469d;

    /* renamed from: e */
    private String f37470e;

    /* renamed from: f */
    private String f37471f;

    private ProofOfPayment(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
    }

    /* synthetic */ ProofOfPayment(Parcel parcel, byte b) {
        this(parcel);
    }

    ProofOfPayment(String str, String str2, String str3, String str4, String str5) {
        this.f37467b = str;
        this.f37468c = str2;
        this.f37469d = str3;
        this.f37470e = str4;
        this.f37471f = str5;
        new StringBuilder("ProofOfPayment created: ").append(toString());
    }

    /* renamed from: a */
    public final String mo39033a() {
        return this.f37468c;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str = C11723Fa.m38822b((CharSequence) this.f37471f) ? this.f37471f : "no transactionId";
        StringBuilder sb = new StringBuilder("{");
        sb.append(this.f37470e);
        sb.append(": ");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37467b);
        parcel.writeString(this.f37468c);
        parcel.writeString(this.f37469d);
        parcel.writeString(this.f37470e);
        parcel.writeString(this.f37471f);
    }
}
