package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.drm.a */
/* compiled from: DrmInitData */
class C8276a implements Creator<DrmInitData> {
    C8276a() {
    }

    public DrmInitData createFromParcel(Parcel in) {
        return new DrmInitData(in);
    }

    public DrmInitData[] newArray(int size) {
        return new DrmInitData[size];
    }
}
