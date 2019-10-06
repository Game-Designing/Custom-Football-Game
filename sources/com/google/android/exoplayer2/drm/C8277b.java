package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;

/* renamed from: com.google.android.exoplayer2.drm.b */
/* compiled from: DrmInitData */
class C8277b implements Creator<SchemeData> {
    C8277b() {
    }

    public SchemeData createFromParcel(Parcel in) {
        return new SchemeData(in);
    }

    public SchemeData[] newArray(int size) {
        return new SchemeData[size];
    }
}
