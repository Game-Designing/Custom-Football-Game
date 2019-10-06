package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Creator<Format> CREATOR = new C8361n();

    /* renamed from: A */
    public final int f16499A;

    /* renamed from: B */
    private int f16500B;

    /* renamed from: a */
    public final String f16501a;

    /* renamed from: b */
    public final String f16502b;

    /* renamed from: c */
    public final int f16503c;

    /* renamed from: d */
    public final String f16504d;

    /* renamed from: e */
    public final Metadata f16505e;

    /* renamed from: f */
    public final String f16506f;

    /* renamed from: g */
    public final String f16507g;

    /* renamed from: h */
    public final int f16508h;

    /* renamed from: i */
    public final List<byte[]> f16509i;

    /* renamed from: j */
    public final DrmInitData f16510j;

    /* renamed from: k */
    public final long f16511k;

    /* renamed from: l */
    public final int f16512l;

    /* renamed from: m */
    public final int f16513m;

    /* renamed from: n */
    public final float f16514n;

    /* renamed from: o */
    public final int f16515o;

    /* renamed from: p */
    public final float f16516p;

    /* renamed from: q */
    public final int f16517q;

    /* renamed from: r */
    public final byte[] f16518r;

    /* renamed from: s */
    public final ColorInfo f16519s;

    /* renamed from: t */
    public final int f16520t;

    /* renamed from: u */
    public final int f16521u;

    /* renamed from: v */
    public final int f16522v;

    /* renamed from: w */
    public final int f16523w;

    /* renamed from: x */
    public final int f16524x;

    /* renamed from: y */
    public final int f16525y;

    /* renamed from: z */
    public final String f16526z;

    /* renamed from: a */
    public static Format m18246a(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int width, int height, float frameRate, List<byte[]> initializationData, int rotationDegrees, float pixelWidthHeightRatio, DrmInitData drmInitData) {
        return m18247a(id, sampleMimeType, codecs, bitrate, maxInputSize, width, height, frameRate, initializationData, rotationDegrees, pixelWidthHeightRatio, (byte[]) null, -1, (ColorInfo) null, drmInitData);
    }

    /* renamed from: a */
    public static Format m18247a(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int width, int height, float frameRate, List<byte[]> initializationData, int rotationDegrees, float pixelWidthHeightRatio, byte[] projectionData, int stereoMode, ColorInfo colorInfo, DrmInitData drmInitData) {
        Format format = new Format(id, null, null, sampleMimeType, codecs, bitrate, maxInputSize, width, height, frameRate, rotationDegrees, pixelWidthHeightRatio, projectionData, stereoMode, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, initializationData, drmInitData, null);
        return format;
    }

    /* renamed from: a */
    public static Format m18250a(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int channelCount, int sampleRate, List<byte[]> initializationData, DrmInitData drmInitData, int selectionFlags, String language) {
        return m18249a(id, sampleMimeType, codecs, bitrate, maxInputSize, channelCount, sampleRate, -1, initializationData, drmInitData, selectionFlags, language);
    }

    /* renamed from: a */
    public static Format m18249a(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int channelCount, int sampleRate, int pcmEncoding, List<byte[]> initializationData, DrmInitData drmInitData, int selectionFlags, String language) {
        return m18248a(id, sampleMimeType, codecs, bitrate, maxInputSize, channelCount, sampleRate, pcmEncoding, -1, -1, initializationData, drmInitData, selectionFlags, language, (Metadata) null);
    }

    /* renamed from: a */
    public static Format m18248a(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int channelCount, int sampleRate, int pcmEncoding, int encoderDelay, int encoderPadding, List<byte[]> initializationData, DrmInitData drmInitData, int selectionFlags, String language, Metadata metadata) {
        Format format = new Format(id, null, null, sampleMimeType, codecs, bitrate, maxInputSize, -1, -1, -1.0f, -1, -1.0f, null, -1, null, channelCount, sampleRate, pcmEncoding, encoderDelay, encoderPadding, selectionFlags, language, -1, Long.MAX_VALUE, initializationData, drmInitData, metadata);
        return format;
    }

    /* renamed from: a */
    public static Format m18243a(String id, String sampleMimeType, int selectionFlags, String language) {
        return m18244a(id, sampleMimeType, selectionFlags, language, (DrmInitData) null);
    }

    /* renamed from: a */
    public static Format m18244a(String id, String sampleMimeType, int selectionFlags, String language, DrmInitData drmInitData) {
        return m18251a(id, sampleMimeType, null, -1, selectionFlags, language, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    /* renamed from: a */
    public static Format m18251a(String id, String sampleMimeType, String codecs, int bitrate, int selectionFlags, String language, int accessibilityChannel, DrmInitData drmInitData, long subsampleOffsetUs, List<byte[]> initializationData) {
        Format format = new Format(id, null, null, sampleMimeType, codecs, bitrate, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, selectionFlags, language, accessibilityChannel, subsampleOffsetUs, initializationData, drmInitData, null);
        return format;
    }

    /* renamed from: a */
    public static Format m18252a(String id, String sampleMimeType, String codecs, int bitrate, int selectionFlags, List<byte[]> initializationData, String language, DrmInitData drmInitData) {
        Format format = new Format(id, null, null, sampleMimeType, codecs, bitrate, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, selectionFlags, language, -1, Long.MAX_VALUE, initializationData, drmInitData, null);
        return format;
    }

    /* renamed from: a */
    public static Format m18245a(String id, String sampleMimeType, long subsampleOffsetUs) {
        Format format = new Format(id, null, null, sampleMimeType, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, subsampleOffsetUs, null, null, null);
        return format;
    }

    /* renamed from: a */
    public static Format m18253a(String id, String sampleMimeType, String codecs, int bitrate, DrmInitData drmInitData) {
        Format format = new Format(id, null, null, sampleMimeType, codecs, bitrate, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, drmInitData, null);
        return format;
    }

    Format(String id, String label, String containerMimeType, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int width, int height, float frameRate, int rotationDegrees, float pixelWidthHeightRatio, byte[] projectionData, int stereoMode, ColorInfo colorInfo, int channelCount, int sampleRate, int pcmEncoding, int encoderDelay, int encoderPadding, int selectionFlags, String language, int accessibilityChannel, long subsampleOffsetUs, List<byte[]> initializationData, DrmInitData drmInitData, Metadata metadata) {
        this.f16501a = id;
        this.f16502b = label;
        this.f16506f = containerMimeType;
        this.f16507g = sampleMimeType;
        this.f16504d = codecs;
        this.f16503c = bitrate;
        this.f16508h = maxInputSize;
        this.f16512l = width;
        this.f16513m = height;
        this.f16514n = frameRate;
        int i = rotationDegrees;
        this.f16515o = i == -1 ? 0 : i;
        this.f16516p = pixelWidthHeightRatio == -1.0f ? 1.0f : pixelWidthHeightRatio;
        this.f16518r = projectionData;
        this.f16517q = stereoMode;
        this.f16519s = colorInfo;
        this.f16520t = channelCount;
        this.f16521u = sampleRate;
        this.f16522v = pcmEncoding;
        int i2 = encoderDelay;
        this.f16523w = i2 == -1 ? 0 : i2;
        int i3 = encoderPadding;
        this.f16524x = i3 == -1 ? 0 : i3;
        this.f16525y = selectionFlags;
        this.f16526z = language;
        this.f16499A = accessibilityChannel;
        this.f16511k = subsampleOffsetUs;
        this.f16509i = initializationData == null ? Collections.emptyList() : initializationData;
        this.f16510j = drmInitData;
        this.f16505e = metadata;
    }

    Format(Parcel in) {
        this.f16501a = in.readString();
        this.f16502b = in.readString();
        this.f16506f = in.readString();
        this.f16507g = in.readString();
        this.f16504d = in.readString();
        this.f16503c = in.readInt();
        this.f16508h = in.readInt();
        this.f16512l = in.readInt();
        this.f16513m = in.readInt();
        this.f16514n = in.readFloat();
        this.f16515o = in.readInt();
        this.f16516p = in.readFloat();
        this.f16518r = C8509F.m20454a(in) ? in.createByteArray() : null;
        this.f16517q = in.readInt();
        this.f16519s = (ColorInfo) in.readParcelable(ColorInfo.class.getClassLoader());
        this.f16520t = in.readInt();
        this.f16521u = in.readInt();
        this.f16522v = in.readInt();
        this.f16523w = in.readInt();
        this.f16524x = in.readInt();
        this.f16525y = in.readInt();
        this.f16526z = in.readString();
        this.f16499A = in.readInt();
        this.f16511k = in.readLong();
        int initializationDataSize = in.readInt();
        this.f16509i = new ArrayList(initializationDataSize);
        for (int i = 0; i < initializationDataSize; i++) {
            this.f16509i.add(in.createByteArray());
        }
        this.f16510j = (DrmInitData) in.readParcelable(DrmInitData.class.getClassLoader());
        this.f16505e = (Metadata) in.readParcelable(Metadata.class.getClassLoader());
    }

    /* renamed from: a */
    public Format mo25008a(int maxInputSize) {
        int i = maxInputSize;
        Format format = new Format(this.f16501a, this.f16502b, this.f16506f, this.f16507g, this.f16504d, this.f16503c, i, this.f16512l, this.f16513m, this.f16514n, this.f16515o, this.f16516p, this.f16518r, this.f16517q, this.f16519s, this.f16520t, this.f16521u, this.f16522v, this.f16523w, this.f16524x, this.f16525y, this.f16526z, this.f16499A, this.f16511k, this.f16509i, this.f16510j, this.f16505e);
        return format;
    }

    /* renamed from: a */
    public Format mo25010a(long subsampleOffsetUs) {
        Format format = new Format(this.f16501a, this.f16502b, this.f16506f, this.f16507g, this.f16504d, this.f16503c, this.f16508h, this.f16512l, this.f16513m, this.f16514n, this.f16515o, this.f16516p, this.f16518r, this.f16517q, this.f16519s, this.f16520t, this.f16521u, this.f16522v, this.f16523w, this.f16524x, this.f16525y, this.f16526z, this.f16499A, subsampleOffsetUs, this.f16509i, this.f16510j, this.f16505e);
        return format;
    }

    /* renamed from: a */
    public Format mo25009a(int encoderDelay, int encoderPadding) {
        int i = encoderDelay;
        int i2 = encoderPadding;
        Format format = new Format(this.f16501a, this.f16502b, this.f16506f, this.f16507g, this.f16504d, this.f16503c, this.f16508h, this.f16512l, this.f16513m, this.f16514n, this.f16515o, this.f16516p, this.f16518r, this.f16517q, this.f16519s, this.f16520t, this.f16521u, this.f16522v, i, i2, this.f16525y, this.f16526z, this.f16499A, this.f16511k, this.f16509i, this.f16510j, this.f16505e);
        return format;
    }

    /* renamed from: a */
    public Format mo25007a(float frameRate) {
        float f = frameRate;
        Format format = new Format(this.f16501a, this.f16502b, this.f16506f, this.f16507g, this.f16504d, this.f16503c, this.f16508h, this.f16512l, this.f16513m, f, this.f16515o, this.f16516p, this.f16518r, this.f16517q, this.f16519s, this.f16520t, this.f16521u, this.f16522v, this.f16523w, this.f16524x, this.f16525y, this.f16526z, this.f16499A, this.f16511k, this.f16509i, this.f16510j, this.f16505e);
        return format;
    }

    /* renamed from: a */
    public Format mo25011a(DrmInitData drmInitData) {
        DrmInitData drmInitData2 = drmInitData;
        Format format = new Format(this.f16501a, this.f16502b, this.f16506f, this.f16507g, this.f16504d, this.f16503c, this.f16508h, this.f16512l, this.f16513m, this.f16514n, this.f16515o, this.f16516p, this.f16518r, this.f16517q, this.f16519s, this.f16520t, this.f16521u, this.f16522v, this.f16523w, this.f16524x, this.f16525y, this.f16526z, this.f16499A, this.f16511k, this.f16509i, drmInitData2, this.f16505e);
        return format;
    }

    /* renamed from: a */
    public Format mo25012a(Metadata metadata) {
        Metadata metadata2 = metadata;
        Format format = new Format(this.f16501a, this.f16502b, this.f16506f, this.f16507g, this.f16504d, this.f16503c, this.f16508h, this.f16512l, this.f16513m, this.f16514n, this.f16515o, this.f16516p, this.f16518r, this.f16517q, this.f16519s, this.f16520t, this.f16521u, this.f16522v, this.f16523w, this.f16524x, this.f16525y, this.f16526z, this.f16499A, this.f16511k, this.f16509i, this.f16510j, metadata2);
        return format;
    }

    /* renamed from: a */
    public int mo25006a() {
        int i = this.f16512l;
        if (i == -1) {
            return -1;
        }
        int i2 = this.f16513m;
        if (i2 == -1) {
            return -1;
        }
        return i * i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Format(");
        sb.append(this.f16501a);
        String str = ", ";
        sb.append(str);
        sb.append(this.f16502b);
        sb.append(str);
        sb.append(this.f16506f);
        sb.append(str);
        sb.append(this.f16507g);
        sb.append(str);
        sb.append(this.f16504d);
        sb.append(str);
        sb.append(this.f16503c);
        sb.append(str);
        sb.append(this.f16526z);
        sb.append(", [");
        sb.append(this.f16512l);
        sb.append(str);
        sb.append(this.f16513m);
        sb.append(str);
        sb.append(this.f16514n);
        sb.append("], [");
        sb.append(this.f16520t);
        sb.append(str);
        sb.append(this.f16521u);
        sb.append("])");
        return sb.toString();
    }

    public int hashCode() {
        if (this.f16500B == 0) {
            int i = 17 * 31;
            String str = this.f16501a;
            int i2 = 0;
            int result = (i + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f16506f;
            int result2 = (result + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f16507g;
            int result3 = (result2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f16504d;
            int result4 = (((((((((((result3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f16503c) * 31) + this.f16512l) * 31) + this.f16513m) * 31) + this.f16520t) * 31) + this.f16521u) * 31;
            String str5 = this.f16526z;
            int result5 = (((result4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f16499A) * 31;
            DrmInitData drmInitData = this.f16510j;
            int result6 = (result5 + (drmInitData == null ? 0 : drmInitData.hashCode())) * 31;
            Metadata metadata = this.f16505e;
            int result7 = (result6 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str6 = this.f16502b;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            this.f16500B = ((((((((((((((((((((result7 + i2) * 31) + this.f16508h) * 31) + ((int) this.f16511k)) * 31) + Float.floatToIntBits(this.f16514n)) * 31) + Float.floatToIntBits(this.f16516p)) * 31) + this.f16515o) * 31) + this.f16517q) * 31) + this.f16522v) * 31) + this.f16523w) * 31) + this.f16524x) * 31) + this.f16525y;
        }
        return this.f16500B;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format other = (Format) obj;
        int i = this.f16500B;
        if (i != 0) {
            int i2 = other.f16500B;
            if (!(i2 == 0 || i == i2)) {
                return false;
            }
        }
        if (!(this.f16503c == other.f16503c && this.f16508h == other.f16508h && this.f16512l == other.f16512l && this.f16513m == other.f16513m && Float.compare(this.f16514n, other.f16514n) == 0 && this.f16515o == other.f16515o && Float.compare(this.f16516p, other.f16516p) == 0 && this.f16517q == other.f16517q && this.f16520t == other.f16520t && this.f16521u == other.f16521u && this.f16522v == other.f16522v && this.f16523w == other.f16523w && this.f16524x == other.f16524x && this.f16511k == other.f16511k && this.f16525y == other.f16525y && C8509F.m20455a((Object) this.f16501a, (Object) other.f16501a) && C8509F.m20455a((Object) this.f16502b, (Object) other.f16502b) && C8509F.m20455a((Object) this.f16526z, (Object) other.f16526z) && this.f16499A == other.f16499A && C8509F.m20455a((Object) this.f16506f, (Object) other.f16506f) && C8509F.m20455a((Object) this.f16507g, (Object) other.f16507g) && C8509F.m20455a((Object) this.f16504d, (Object) other.f16504d) && C8509F.m20455a((Object) this.f16510j, (Object) other.f16510j) && C8509F.m20455a((Object) this.f16505e, (Object) other.f16505e) && C8509F.m20455a((Object) this.f16519s, (Object) other.f16519s) && Arrays.equals(this.f16518r, other.f16518r) && mo25013a(other))) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo25013a(Format other) {
        if (this.f16509i.size() != other.f16509i.size()) {
            return false;
        }
        for (int i = 0; i < this.f16509i.size(); i++) {
            if (!Arrays.equals((byte[]) this.f16509i.get(i), (byte[]) other.f16509i.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f16501a);
        dest.writeString(this.f16502b);
        dest.writeString(this.f16506f);
        dest.writeString(this.f16507g);
        dest.writeString(this.f16504d);
        dest.writeInt(this.f16503c);
        dest.writeInt(this.f16508h);
        dest.writeInt(this.f16512l);
        dest.writeInt(this.f16513m);
        dest.writeFloat(this.f16514n);
        dest.writeInt(this.f16515o);
        dest.writeFloat(this.f16516p);
        C8509F.m20449a(dest, this.f16518r != null);
        byte[] bArr = this.f16518r;
        if (bArr != null) {
            dest.writeByteArray(bArr);
        }
        dest.writeInt(this.f16517q);
        dest.writeParcelable(this.f16519s, flags);
        dest.writeInt(this.f16520t);
        dest.writeInt(this.f16521u);
        dest.writeInt(this.f16522v);
        dest.writeInt(this.f16523w);
        dest.writeInt(this.f16524x);
        dest.writeInt(this.f16525y);
        dest.writeString(this.f16526z);
        dest.writeInt(this.f16499A);
        dest.writeLong(this.f16511k);
        int initializationDataSize = this.f16509i.size();
        dest.writeInt(initializationDataSize);
        for (int i = 0; i < initializationDataSize; i++) {
            dest.writeByteArray((byte[]) this.f16509i.get(i));
        }
        dest.writeParcelable(this.f16510j, 0);
        dest.writeParcelable(this.f16505e, 0);
    }
}
