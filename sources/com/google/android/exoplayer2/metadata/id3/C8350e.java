package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.e */
/* compiled from: ChapterTocFrame */
class C8350e implements Creator<ChapterTocFrame> {
    C8350e() {
    }

    public ChapterTocFrame createFromParcel(Parcel in) {
        return new ChapterTocFrame(in);
    }

    public ChapterTocFrame[] newArray(int size) {
        return new ChapterTocFrame[size];
    }
}
