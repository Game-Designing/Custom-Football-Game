package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.a */
/* compiled from: Metadata */
class C8344a implements Creator<Metadata> {
    C8344a() {
    }

    public Metadata createFromParcel(Parcel in) {
        return new Metadata(in);
    }

    public Metadata[] newArray(int size) {
        return new Metadata[0];
    }
}
