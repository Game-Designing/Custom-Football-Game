package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class MlltFrame extends Id3Frame {
    public static final Creator<MlltFrame> CREATOR = new C8357j();

    /* renamed from: b */
    public final int f18099b;

    /* renamed from: c */
    public final int f18100c;

    /* renamed from: d */
    public final int f18101d;

    /* renamed from: e */
    public final int[] f18102e;

    /* renamed from: f */
    public final int[] f18103f;

    public MlltFrame(int mpegFramesBetweenReference, int bytesBetweenReference, int millisecondsBetweenReference, int[] bytesDeviations, int[] millisecondsDeviations) {
        super("MLLT");
        this.f18099b = mpegFramesBetweenReference;
        this.f18100c = bytesBetweenReference;
        this.f18101d = millisecondsBetweenReference;
        this.f18102e = bytesDeviations;
        this.f18103f = millisecondsDeviations;
    }

    MlltFrame(Parcel in) {
        super("MLLT");
        this.f18099b = in.readInt();
        this.f18100c = in.readInt();
        this.f18101d = in.readInt();
        this.f18102e = in.createIntArray();
        this.f18103f = in.createIntArray();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MlltFrame other = (MlltFrame) obj;
        if (!(this.f18099b == other.f18099b && this.f18100c == other.f18100c && this.f18101d == other.f18101d && Arrays.equals(this.f18102e, other.f18102e) && Arrays.equals(this.f18103f, other.f18103f))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((((((17 * 31) + this.f18099b) * 31) + this.f18100c) * 31) + this.f18101d) * 31) + Arrays.hashCode(this.f18102e)) * 31) + Arrays.hashCode(this.f18103f);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f18099b);
        dest.writeInt(this.f18100c);
        dest.writeInt(this.f18101d);
        dest.writeIntArray(this.f18102e);
        dest.writeIntArray(this.f18103f);
    }

    public int describeContents() {
        return 0;
    }
}
