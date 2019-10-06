package com.google.android.exoplayer2.extractor.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.i */
/* compiled from: MdtaMetadataEntry */
class C8307i implements Creator<MdtaMetadataEntry> {
    C8307i() {
    }

    public MdtaMetadataEntry createFromParcel(Parcel in) {
        return new MdtaMetadataEntry(in, null);
    }

    public MdtaMetadataEntry[] newArray(int size) {
        return new MdtaMetadataEntry[size];
    }
}
