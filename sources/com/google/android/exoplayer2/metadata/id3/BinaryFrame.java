package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Creator<BinaryFrame> CREATOR = new C8348c();

    /* renamed from: b */
    public final byte[] f18076b;

    public BinaryFrame(String id, byte[] data) {
        super(id);
        this.f18076b = data;
    }

    BinaryFrame(Parcel in) {
        String readString = in.readString();
        C8509F.m20443a(readString);
        super(readString);
        byte[] createByteArray = in.createByteArray();
        C8509F.m20443a(createByteArray);
        this.f18076b = createByteArray;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinaryFrame other = (BinaryFrame) obj;
        if (!this.f18095a.equals(other.f18095a) || !Arrays.equals(this.f18076b, other.f18076b)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((17 * 31) + this.f18095a.hashCode()) * 31) + Arrays.hashCode(this.f18076b);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f18095a);
        dest.writeByteArray(this.f18076b);
    }
}
