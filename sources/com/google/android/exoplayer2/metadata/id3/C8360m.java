package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.m */
/* compiled from: UrlLinkFrame */
class C8360m implements Creator<UrlLinkFrame> {
    C8360m() {
    }

    public UrlLinkFrame createFromParcel(Parcel in) {
        return new UrlLinkFrame(in);
    }

    public UrlLinkFrame[] newArray(int size) {
        return new UrlLinkFrame[size];
    }
}
