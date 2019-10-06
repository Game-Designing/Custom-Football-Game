package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters;

/* renamed from: com.google.android.exoplayer2.trackselection.d */
/* compiled from: DefaultTrackSelector */
class C8427d implements Creator<Parameters> {
    C8427d() {
    }

    public Parameters createFromParcel(Parcel in) {
        return new Parameters(in);
    }

    public Parameters[] newArray(int size) {
        return new Parameters[size];
    }
}
