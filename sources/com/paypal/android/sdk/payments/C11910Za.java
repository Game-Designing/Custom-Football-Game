package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.Za */
final class C11910Za implements Creator {
    C11910Za() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ProofOfPayment(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ProofOfPayment[i];
    }
}
