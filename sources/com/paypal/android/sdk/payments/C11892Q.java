package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.Q */
final class C11892Q implements Creator {
    C11892Q() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayPalItem(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayPalItem[i];
    }
}
