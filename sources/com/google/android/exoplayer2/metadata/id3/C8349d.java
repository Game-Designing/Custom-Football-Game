package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.d */
/* compiled from: ChapterFrame */
class C8349d implements Creator<ChapterFrame> {
    C8349d() {
    }

    public ChapterFrame createFromParcel(Parcel in) {
        return new ChapterFrame(in);
    }

    public ChapterFrame[] newArray(int size) {
        return new ChapterFrame[size];
    }
}
