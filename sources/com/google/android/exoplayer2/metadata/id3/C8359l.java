package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.l */
/* compiled from: TextInformationFrame */
class C8359l implements Creator<TextInformationFrame> {
    C8359l() {
    }

    public TextInformationFrame createFromParcel(Parcel in) {
        return new TextInformationFrame(in);
    }

    public TextInformationFrame[] newArray(int size) {
        return new TextInformationFrame[size];
    }
}
