package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.Ma */
final class C11885Ma implements Creator {
    C11885Ma() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PaymentConfirmation(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PaymentConfirmation[i];
    }
}
