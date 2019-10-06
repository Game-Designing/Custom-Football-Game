package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Creator<ApicFrame> CREATOR = new C8347b();

    /* renamed from: b */
    public final String f18072b;

    /* renamed from: c */
    public final String f18073c;

    /* renamed from: d */
    public final int f18074d;

    /* renamed from: e */
    public final byte[] f18075e;

    public ApicFrame(String mimeType, String description, int pictureType, byte[] pictureData) {
        super("APIC");
        this.f18072b = mimeType;
        this.f18073c = description;
        this.f18074d = pictureType;
        this.f18075e = pictureData;
    }

    ApicFrame(Parcel in) {
        super("APIC");
        String readString = in.readString();
        C8509F.m20443a(readString);
        this.f18072b = readString;
        String readString2 = in.readString();
        C8509F.m20443a(readString2);
        this.f18073c = readString2;
        this.f18074d = in.readInt();
        byte[] createByteArray = in.createByteArray();
        C8509F.m20443a(createByteArray);
        this.f18075e = createByteArray;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApicFrame other = (ApicFrame) obj;
        if (this.f18074d != other.f18074d || !C8509F.m20455a((Object) this.f18072b, (Object) other.f18072b) || !C8509F.m20455a((Object) this.f18073c, (Object) other.f18073c) || !Arrays.equals(this.f18075e, other.f18075e)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int result = ((17 * 31) + this.f18074d) * 31;
        String str = this.f18072b;
        int i = 0;
        int result2 = (result + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18073c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((result2 + i) * 31) + Arrays.hashCode(this.f18075e);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18095a);
        sb.append(": mimeType=");
        sb.append(this.f18072b);
        sb.append(", description=");
        sb.append(this.f18073c);
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f18072b);
        dest.writeString(this.f18073c);
        dest.writeInt(this.f18074d);
        dest.writeByteArray(this.f18075e);
    }
}
