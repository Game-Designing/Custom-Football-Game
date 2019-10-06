package com.google.android.exoplayer2.extractor.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

public final class MdtaMetadataEntry implements Entry {
    public static final Creator<MdtaMetadataEntry> CREATOR = new C8307i();

    /* renamed from: a */
    public final String f17600a;

    /* renamed from: b */
    public final byte[] f17601b;

    /* renamed from: c */
    public final int f17602c;

    /* renamed from: d */
    public final int f17603d;

    /* synthetic */ MdtaMetadataEntry(Parcel x0, C8307i x1) {
        this(x0);
    }

    public MdtaMetadataEntry(String key, byte[] value, int localeIndicator, int typeIndicator) {
        this.f17600a = key;
        this.f17601b = value;
        this.f17602c = localeIndicator;
        this.f17603d = typeIndicator;
    }

    private MdtaMetadataEntry(Parcel in) {
        String readString = in.readString();
        C8509F.m20443a(readString);
        this.f17600a = readString;
        this.f17601b = new byte[in.readInt()];
        in.readByteArray(this.f17601b);
        this.f17602c = in.readInt();
        this.f17603d = in.readInt();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry other = (MdtaMetadataEntry) obj;
        if (!this.f17600a.equals(other.f17600a) || !Arrays.equals(this.f17601b, other.f17601b) || this.f17602c != other.f17602c || this.f17603d != other.f17603d) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((((17 * 31) + this.f17600a.hashCode()) * 31) + Arrays.hashCode(this.f17601b)) * 31) + this.f17602c) * 31) + this.f17603d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mdta: key=");
        sb.append(this.f17600a);
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f17600a);
        dest.writeInt(this.f17601b.length);
        dest.writeByteArray(this.f17601b);
        dest.writeInt(this.f17602c);
        dest.writeInt(this.f17603d);
    }

    public int describeContents() {
        return 0;
    }
}
