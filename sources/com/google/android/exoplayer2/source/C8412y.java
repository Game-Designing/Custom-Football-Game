package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.source.y */
/* compiled from: TrackGroup */
class C8412y implements Creator<TrackGroup> {
    C8412y() {
    }

    public TrackGroup createFromParcel(Parcel in) {
        return new TrackGroup(in);
    }

    public TrackGroup[] newArray(int size) {
        return new TrackGroup[size];
    }
}
