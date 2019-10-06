package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.g */
/* compiled from: GeobFrame */
class C8352g implements Creator<GeobFrame> {
    C8352g() {
    }

    public GeobFrame createFromParcel(Parcel in) {
        return new GeobFrame(in);
    }

    public GeobFrame[] newArray(int size) {
        return new GeobFrame[size];
    }
}
