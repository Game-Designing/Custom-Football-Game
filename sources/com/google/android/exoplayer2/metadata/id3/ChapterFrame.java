package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Creator<ChapterFrame> CREATOR = new C8349d();

    /* renamed from: b */
    public final String f18077b;

    /* renamed from: c */
    public final int f18078c;

    /* renamed from: d */
    public final int f18079d;

    /* renamed from: e */
    public final long f18080e;

    /* renamed from: f */
    public final long f18081f;

    /* renamed from: g */
    private final Id3Frame[] f18082g;

    public ChapterFrame(String chapterId, int startTimeMs, int endTimeMs, long startOffset, long endOffset, Id3Frame[] subFrames) {
        super("CHAP");
        this.f18077b = chapterId;
        this.f18078c = startTimeMs;
        this.f18079d = endTimeMs;
        this.f18080e = startOffset;
        this.f18081f = endOffset;
        this.f18082g = subFrames;
    }

    ChapterFrame(Parcel in) {
        super("CHAP");
        String readString = in.readString();
        C8509F.m20443a(readString);
        this.f18077b = readString;
        this.f18078c = in.readInt();
        this.f18079d = in.readInt();
        this.f18080e = in.readLong();
        this.f18081f = in.readLong();
        int subFrameCount = in.readInt();
        this.f18082g = new Id3Frame[subFrameCount];
        for (int i = 0; i < subFrameCount; i++) {
            this.f18082g[i] = (Id3Frame) in.readParcelable(Id3Frame.class.getClassLoader());
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
        ChapterFrame other = (ChapterFrame) obj;
        if (!(this.f18078c == other.f18078c && this.f18079d == other.f18079d && this.f18080e == other.f18080e && this.f18081f == other.f18081f && C8509F.m20455a((Object) this.f18077b, (Object) other.f18077b) && Arrays.equals(this.f18082g, other.f18082g))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int result = ((((((((17 * 31) + this.f18078c) * 31) + this.f18079d) * 31) + ((int) this.f18080e)) * 31) + ((int) this.f18081f)) * 31;
        String str = this.f18077b;
        return result + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f18077b);
        dest.writeInt(this.f18078c);
        dest.writeInt(this.f18079d);
        dest.writeLong(this.f18080e);
        dest.writeLong(this.f18081f);
        dest.writeInt(this.f18082g.length);
        for (Id3Frame subFrame : this.f18082g) {
            dest.writeParcelable(subFrame, 0);
        }
    }

    public int describeContents() {
        return 0;
    }
}
