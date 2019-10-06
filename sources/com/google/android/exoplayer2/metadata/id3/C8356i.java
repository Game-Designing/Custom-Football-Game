package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.i */
/* compiled from: InternalFrame */
class C8356i implements Creator<InternalFrame> {
    C8356i() {
    }

    public InternalFrame createFromParcel(Parcel in) {
        return new InternalFrame(in);
    }

    public InternalFrame[] newArray(int size) {
        return new InternalFrame[size];
    }
}
