package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class PaymentConfirmation implements Parcelable {
    public static final Creator CREATOR = new C11885Ma();

    /* renamed from: a */
    private static final String f37450a = PaymentConfirmation.class.getSimpleName();

    /* renamed from: b */
    private String f37451b;

    /* renamed from: c */
    private PayPalPayment f37452c;

    /* renamed from: d */
    private ProofOfPayment f37453d;

    private PaymentConfirmation(Parcel parcel) {
        this.f37451b = parcel.readString();
        this.f37452c = (PayPalPayment) parcel.readParcelable(PayPalPayment.class.getClassLoader());
        this.f37453d = (ProofOfPayment) parcel.readParcelable(ProofOfPayment.class.getClassLoader());
    }

    /* synthetic */ PaymentConfirmation(Parcel parcel, byte b) {
        this(parcel);
    }

    PaymentConfirmation(String str, PayPalPayment payPalPayment, ProofOfPayment proofOfPayment) {
        this.f37451b = str;
        this.f37452c = payPalPayment;
        this.f37453d = proofOfPayment;
    }

    /* renamed from: a */
    public final ProofOfPayment mo39021a() {
        return this.f37453d;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37451b);
        parcel.writeParcelable(this.f37452c, 0);
        parcel.writeParcelable(this.f37453d, 0);
    }
}
