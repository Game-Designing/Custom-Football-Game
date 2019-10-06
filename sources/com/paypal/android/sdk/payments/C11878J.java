package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.J */
final class C11878J implements Creator {
    C11878J() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayPalAuthorization(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayPalAuthorization[i];
    }
}
