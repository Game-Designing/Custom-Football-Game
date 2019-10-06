package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.T */
final class C11897T implements Creator {
    C11897T() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayPalPayment(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayPalPayment[i];
    }
}
