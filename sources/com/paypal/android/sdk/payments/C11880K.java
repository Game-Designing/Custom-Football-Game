package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.K */
final class C11880K implements Creator {
    C11880K() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayPalConfiguration(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayPalConfiguration[i];
    }
}
