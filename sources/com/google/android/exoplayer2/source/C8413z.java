package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.source.z */
/* compiled from: TrackGroupArray */
class C8413z implements Creator<TrackGroupArray> {
    C8413z() {
    }

    public TrackGroupArray createFromParcel(Parcel in) {
        return new TrackGroupArray(in);
    }

    public TrackGroupArray[] newArray(int size) {
        return new TrackGroupArray[size];
    }
}
