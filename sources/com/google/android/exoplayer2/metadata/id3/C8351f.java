package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.exoplayer2.metadata.id3.f */
/* compiled from: CommentFrame */
class C8351f implements Creator<CommentFrame> {
    C8351f() {
    }

    public CommentFrame createFromParcel(Parcel in) {
        return new CommentFrame(in);
    }

    public CommentFrame[] newArray(int size) {
        return new CommentFrame[size];
    }
}
