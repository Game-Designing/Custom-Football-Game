package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.U */
final class C11899U implements Creator {
    C11899U() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayPalPaymentDetails(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayPalPaymentDetails[i];
    }
}
