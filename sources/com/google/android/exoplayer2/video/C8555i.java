package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.video.i */
/* compiled from: ColorInfo */
class C8555i implements Creator<ColorInfo> {
    C8555i() {
    }

    public ColorInfo createFromParcel(Parcel in) {
        return new ColorInfo(in);
    }

    public ColorInfo[] newArray(int size) {
        return new ColorInfo[0];
    }
}
