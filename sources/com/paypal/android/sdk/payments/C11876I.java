package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.I */
final class C11876I implements Creator {
    C11876I() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return (C11918bg) parcel.readSerializable();
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new C11918bg[i];
    }
}
