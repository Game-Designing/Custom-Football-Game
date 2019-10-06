package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.S */
final class C11895S implements Creator {
    C11895S() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayPalOAuthScopes(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayPalOAuthScopes[i];
    }
}
