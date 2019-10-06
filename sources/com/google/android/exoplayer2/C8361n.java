package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.n */
/* compiled from: Format */
class C8361n implements Creator<Format> {
    C8361n() {
    }

    public Format createFromParcel(Parcel in) {
        return new Format(in);
    }

    public Format[] newArray(int size) {
        return new Format[size];
    }
}
