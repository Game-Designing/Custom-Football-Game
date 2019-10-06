package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.c */
/* compiled from: BinaryFrame */
class C8348c implements Creator<BinaryFrame> {
    C8348c() {
    }

    public BinaryFrame createFromParcel(Parcel in) {
        return new BinaryFrame(in);
    }

    public BinaryFrame[] newArray(int size) {
        return new BinaryFrame[size];
    }
}
