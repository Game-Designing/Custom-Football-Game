package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Creator<ColorInfo> CREATOR = new C8555i();

    /* renamed from: a */
    public final int f18886a;

    /* renamed from: b */
    public final int f18887b;

    /* renamed from: c */
    public final int f18888c;

    /* renamed from: d */
    public final byte[] f18889d;

    /* renamed from: e */
    private int f18890e;

    public ColorInfo(int colorSpace, int colorRange, int colorTransfer, byte[] hdrStaticInfo) {
        this.f18886a = colorSpace;
        this.f18887b = colorRange;
        this.f18888c = colorTransfer;
        this.f18889d = hdrStaticInfo;
    }

    ColorInfo(Parcel in) {
        this.f18886a = in.readInt();
        this.f18887b = in.readInt();
        this.f18888c = in.readInt();
        this.f18889d = C8509F.m20454a(in) ? in.createByteArray() : null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorInfo other = (ColorInfo) obj;
        if (!(this.f18886a == other.f18886a && this.f18887b == other.f18887b && this.f18888c == other.f18888c && Arrays.equals(this.f18889d, other.f18889d))) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f18886a);
        String str = ", ";
        sb.append(str);
        sb.append(this.f18887b);
        sb.append(str);
        sb.append(this.f18888c);
        sb.append(str);
        sb.append(this.f18889d != null);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        if (this.f18890e == 0) {
            this.f18890e = (((((((17 * 31) + this.f18886a) * 31) + this.f18887b) * 31) + this.f18888c) * 31) + Arrays.hashCode(this.f18889d);
        }
        return this.f18890e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f18886a);
        dest.writeInt(this.f18887b);
        dest.writeInt(this.f18888c);
        C8509F.m20449a(dest, this.f18889d != null);
        byte[] bArr = this.f18889d;
        if (bArr != null) {
            dest.writeByteArray(bArr);
        }
    }
}
