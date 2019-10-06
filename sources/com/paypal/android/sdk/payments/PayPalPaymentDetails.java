package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;

public final class PayPalPaymentDetails implements Parcelable {
    public static final Creator CREATOR = new C11899U();

    /* renamed from: a */
    private static final String f37399a = PayPalPaymentDetails.class.getSimpleName();

    /* renamed from: b */
    private BigDecimal f37400b;

    /* renamed from: c */
    private BigDecimal f37401c;

    /* renamed from: d */
    private BigDecimal f37402d;

    private PayPalPaymentDetails(Parcel parcel) {
        try {
            String readString = parcel.readString();
            BigDecimal bigDecimal = null;
            this.f37401c = readString == null ? null : new BigDecimal(readString);
            String readString2 = parcel.readString();
            this.f37400b = readString2 == null ? null : new BigDecimal(readString2);
            String readString3 = parcel.readString();
            if (readString3 != null) {
                bigDecimal = new BigDecimal(readString3);
            }
            this.f37402d = bigDecimal;
        } catch (NumberFormatException e) {
            throw new RuntimeException("error unparceling PayPalPaymentDetails");
        }
    }

    /* synthetic */ PayPalPaymentDetails(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    public final BigDecimal mo38945a() {
        return this.f37401c;
    }

    /* renamed from: b */
    public final BigDecimal mo38946b() {
        return this.f37400b;
    }

    /* renamed from: c */
    public final BigDecimal mo38947c() {
        return this.f37402d;
    }

    /* renamed from: d */
    public final boolean mo38948d() {
        return this.f37400b != null;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        BigDecimal bigDecimal = this.f37401c;
        String str = null;
        parcel.writeString(bigDecimal == null ? null : bigDecimal.toString());
        BigDecimal bigDecimal2 = this.f37400b;
        parcel.writeString(bigDecimal2 == null ? null : bigDecimal2.toString());
        BigDecimal bigDecimal3 = this.f37402d;
        if (bigDecimal3 != null) {
            str = bigDecimal3.toString();
        }
        parcel.writeString(str);
    }
}
