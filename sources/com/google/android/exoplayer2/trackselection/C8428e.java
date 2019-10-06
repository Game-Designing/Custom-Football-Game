package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride;

/* renamed from: com.google.android.exoplayer2.trackselection.e */
/* compiled from: DefaultTrackSelector */
class C8428e implements Creator<SelectionOverride> {
    C8428e() {
    }

    public SelectionOverride createFromParcel(Parcel in) {
        return new SelectionOverride(in);
    }

    public SelectionOverride[] newArray(int size) {
        return new SelectionOverride[size];
    }
}
