package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Creator<ChapterTocFrame> CREATOR = new C8350e();

    /* renamed from: b */
    public final String f18083b;

    /* renamed from: c */
    public final boolean f18084c;

    /* renamed from: d */
    public final boolean f18085d;

    /* renamed from: e */
    public final String[] f18086e;

    /* renamed from: f */
    private final Id3Frame[] f18087f;

    public ChapterTocFrame(String elementId, boolean isRoot, boolean isOrdered, String[] children, Id3Frame[] subFrames) {
        super("CTOC");
        this.f18083b = elementId;
        this.f18084c = isRoot;
        this.f18085d = isOrdered;
        this.f18086e = children;
        this.f18087f = subFrames;
    }

    ChapterTocFrame(Parcel in) {
        super("CTOC");
        String readString = in.readString();
        C8509F.m20443a(readString);
        this.f18083b = readString;
        boolean z = false;
        this.f18084c = in.readByte() != 0;
        if (in.readByte() != 0) {
            z = true;
        }
        this.f18085d = z;
        this.f18086e = in.createStringArray();
        int subFrameCount = in.readInt();
        this.f18087f = new Id3Frame[subFrameCount];
        for (int i = 0; i < subFrameCount; i++) {
            this.f18087f[i] = (Id3Frame) in.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterTocFrame other = (ChapterTocFrame) obj;
        if (this.f18084c != other.f18084c || this.f18085d != other.f18085d || !C8509F.m20455a((Object) this.f18083b, (Object) other.f18083b) || !Arrays.equals(this.f18086e, other.f18086e) || !Arrays.equals(this.f18087f, other.f18087f)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int result = ((((17 * 31) + (this.f18084c ? 1 : 0)) * 31) + (this.f18085d ? 1 : 0)) * 31;
        String str = this.f18083b;
        return result + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f18083b);
        dest.writeByte(this.f18084c ? (byte) 1 : 0);
        dest.writeByte(this.f18085d ? (byte) 1 : 0);
        dest.writeStringArray(this.f18086e);
        dest.writeInt(this.f18087f.length);
        for (Id3Frame subFrame : this.f18087f) {
            dest.writeParcelable(subFrame, 0);
        }
    }
}
