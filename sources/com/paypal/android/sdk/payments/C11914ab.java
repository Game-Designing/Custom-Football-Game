package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.ab */
final class C11914ab implements Creator {
    C11914ab() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ShippingAddress(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ShippingAddress[i];
    }
}
