package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.j */
/* compiled from: MlltFrame */
class C8357j implements Creator<MlltFrame> {
    C8357j() {
    }

    public MlltFrame createFromParcel(Parcel in) {
        return new MlltFrame(in);
    }

    public MlltFrame[] newArray(int size) {
        return new MlltFrame[size];
    }
}
