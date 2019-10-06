package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.b */
/* compiled from: ApicFrame */
class C8347b implements Creator<ApicFrame> {
    C8347b() {
    }

    public ApicFrame createFromParcel(Parcel in) {
        return new ApicFrame(in);
    }

    public ApicFrame[] newArray(int size) {
        return new ApicFrame[size];
    }
}
