package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Creator<PrivFrame> CREATOR = new C8358k();

    /* renamed from: b */
    public final String f18104b;

    /* renamed from: c */
    public final byte[] f18105c;

    public PrivFrame(String owner, byte[] privateData) {
        super("PRIV");
        this.f18104b = owner;
        this.f18105c = privateData;
    }

    PrivFrame(Parcel in) {
        super("PRIV");
        String readString = in.readString();
        C8509F.m20443a(readString);
        this.f18104b = readString;
        byte[] createByteArray = in.createByteArray();
        C8509F.m20443a(createByteArray);
        this.f18105c = createByteArray;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrivFrame other = (PrivFrame) obj;
        if (!C8509F.m20455a((Object) this.f18104b, (Object) other.f18104b) || !Arrays.equals(this.f18105c, other.f18105c)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 17 * 31;
        String str = this.f18104b;
        return ((i + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f18105c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18095a);
        sb.append(": owner=");
        sb.append(this.f18104b);
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f18104b);
        dest.writeByteArray(this.f18105c);
    }
}
