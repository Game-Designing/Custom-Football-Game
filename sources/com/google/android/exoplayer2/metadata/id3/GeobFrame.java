package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Creator<GeobFrame> CREATOR = new C8352g();

    /* renamed from: b */
    public final String f18091b;

    /* renamed from: c */
    public final String f18092c;

    /* renamed from: d */
    public final String f18093d;

    /* renamed from: e */
    public final byte[] f18094e;

    public GeobFrame(String mimeType, String filename, String description, byte[] data) {
        super("GEOB");
        this.f18091b = mimeType;
        this.f18092c = filename;
        this.f18093d = description;
        this.f18094e = data;
    }

    GeobFrame(Parcel in) {
        super("GEOB");
        String readString = in.readString();
        C8509F.m20443a(readString);
        this.f18091b = readString;
        String readString2 = in.readString();
        C8509F.m20443a(readString2);
        this.f18092c = readString2;
        String readString3 = in.readString();
        C8509F.m20443a(readString3);
        this.f18093d = readString3;
        byte[] createByteArray = in.createByteArray();
        C8509F.m20443a(createByteArray);
        this.f18094e = createByteArray;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeobFrame other = (GeobFrame) obj;
        if (!C8509F.m20455a((Object) this.f18091b, (Object) other.f18091b) || !C8509F.m20455a((Object) this.f18092c, (Object) other.f18092c) || !C8509F.m20455a((Object) this.f18093d, (Object) other.f18093d) || !Arrays.equals(this.f18094e, other.f18094e)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 17 * 31;
        String str = this.f18091b;
        int i2 = 0;
        int result = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18092c;
        int result2 = (result + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f18093d;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((result2 + i2) * 31) + Arrays.hashCode(this.f18094e);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18095a);
        sb.append(": mimeType=");
        sb.append(this.f18091b);
        sb.append(", filename=");
        sb.append(this.f18092c);
        sb.append(", description=");
        sb.append(this.f18093d);
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f18091b);
        dest.writeString(this.f18092c);
        dest.writeString(this.f18093d);
        dest.writeByteArray(this.f18094e);
    }
}
