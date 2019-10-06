package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzlh implements Parcelable {
    public static final Creator<zzlh> CREATOR = new C8799Cr();

    /* renamed from: A */
    private int f28778A;

    /* renamed from: a */
    private final String f28779a;

    /* renamed from: b */
    public final int f28780b;

    /* renamed from: c */
    public final String f28781c;

    /* renamed from: d */
    private final zzpo f28782d;

    /* renamed from: e */
    private final String f28783e;

    /* renamed from: f */
    public final String f28784f;

    /* renamed from: g */
    public final int f28785g;

    /* renamed from: h */
    public final List<byte[]> f28786h;

    /* renamed from: i */
    public final zzne f28787i;

    /* renamed from: j */
    public final int f28788j;

    /* renamed from: k */
    public final int f28789k;

    /* renamed from: l */
    public final float f28790l;

    /* renamed from: m */
    public final int f28791m;

    /* renamed from: n */
    public final float f28792n;

    /* renamed from: o */
    private final int f28793o;

    /* renamed from: p */
    private final byte[] f28794p;

    /* renamed from: q */
    private final zztb f28795q;

    /* renamed from: r */
    public final int f28796r;

    /* renamed from: s */
    public final int f28797s;

    /* renamed from: t */
    public final int f28798t;

    /* renamed from: u */
    private final int f28799u;

    /* renamed from: v */
    private final int f28800v;

    /* renamed from: w */
    public final long f28801w;

    /* renamed from: x */
    public final int f28802x;

    /* renamed from: y */
    public final String f28803y;

    /* renamed from: z */
    private final int f28804z;

    /* renamed from: a */
    public static zzlh m30625a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zztb zztb, zzne zzne) {
        zzlh zzlh = new zzlh(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zztb, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, zzne, null);
        return zzlh;
    }

    /* renamed from: a */
    public static zzlh m30627a(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzne zzne, int i5, String str4) {
        return m30626a(str, str2, null, -1, -1, i3, i4, -1, null, zzne, 0, str4);
    }

    /* renamed from: a */
    public static zzlh m30626a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzne zzne, int i6, String str4) {
        zzlh zzlh = new zzlh(str, null, str2, null, -1, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzne, null);
        return zzlh;
    }

    /* renamed from: a */
    public static zzlh m30629a(String str, String str2, String str3, int i, int i2, String str4, zzne zzne) {
        return m30628a(str, str2, null, -1, i2, str4, -1, zzne, Long.MAX_VALUE, Collections.emptyList());
    }

    /* renamed from: a */
    public static zzlh m30628a(String str, String str2, String str3, int i, int i2, String str4, int i3, zzne zzne, long j, List<byte[]> list) {
        zzlh zzlh = new zzlh(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzne, null);
        return zzlh;
    }

    /* renamed from: a */
    public static zzlh m30631a(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzne zzne) {
        zzlh zzlh = new zzlh(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzne, null);
        return zzlh;
    }

    /* renamed from: a */
    public static zzlh m30630a(String str, String str2, String str3, int i, zzne zzne) {
        zzlh zzlh = new zzlh(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
        return zzlh;
    }

    private zzlh(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zztb zztb, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzne zzne, zzpo zzpo) {
        List<byte[]> list2;
        this.f28779a = str;
        this.f28783e = str2;
        this.f28784f = str3;
        this.f28781c = str4;
        this.f28780b = i;
        this.f28785g = i2;
        this.f28788j = i3;
        this.f28789k = i4;
        this.f28790l = f;
        this.f28791m = i5;
        this.f28792n = f2;
        this.f28794p = bArr;
        this.f28793o = i6;
        this.f28795q = zztb;
        this.f28796r = i7;
        this.f28797s = i8;
        this.f28798t = i9;
        this.f28799u = i10;
        this.f28800v = i11;
        this.f28802x = i12;
        this.f28803y = str5;
        this.f28804z = i13;
        this.f28801w = j;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = list;
        }
        this.f28786h = list2;
        this.f28787i = zzne;
        this.f28782d = zzpo;
    }

    zzlh(Parcel parcel) {
        this.f28779a = parcel.readString();
        this.f28783e = parcel.readString();
        this.f28784f = parcel.readString();
        this.f28781c = parcel.readString();
        this.f28780b = parcel.readInt();
        this.f28785g = parcel.readInt();
        this.f28788j = parcel.readInt();
        this.f28789k = parcel.readInt();
        this.f28790l = parcel.readFloat();
        this.f28791m = parcel.readInt();
        this.f28792n = parcel.readFloat();
        this.f28794p = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.f28793o = parcel.readInt();
        this.f28795q = (zztb) parcel.readParcelable(zztb.class.getClassLoader());
        this.f28796r = parcel.readInt();
        this.f28797s = parcel.readInt();
        this.f28798t = parcel.readInt();
        this.f28799u = parcel.readInt();
        this.f28800v = parcel.readInt();
        this.f28802x = parcel.readInt();
        this.f28803y = parcel.readString();
        this.f28804z = parcel.readInt();
        this.f28801w = parcel.readLong();
        int readInt = parcel.readInt();
        this.f28786h = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f28786h.add(parcel.createByteArray());
        }
        this.f28787i = (zzne) parcel.readParcelable(zzne.class.getClassLoader());
        this.f28782d = (zzpo) parcel.readParcelable(zzpo.class.getClassLoader());
    }

    /* renamed from: a */
    public final zzlh mo31939a(int i) {
        int i2 = i;
        zzlh zzlh = new zzlh(this.f28779a, this.f28783e, this.f28784f, this.f28781c, this.f28780b, i2, this.f28788j, this.f28789k, this.f28790l, this.f28791m, this.f28792n, this.f28794p, this.f28793o, this.f28795q, this.f28796r, this.f28797s, this.f28798t, this.f28799u, this.f28800v, this.f28802x, this.f28803y, this.f28804z, this.f28801w, this.f28786h, this.f28787i, this.f28782d);
        return zzlh;
    }

    /* renamed from: a */
    public final zzlh mo31941a(long j) {
        zzlh zzlh = new zzlh(this.f28779a, this.f28783e, this.f28784f, this.f28781c, this.f28780b, this.f28785g, this.f28788j, this.f28789k, this.f28790l, this.f28791m, this.f28792n, this.f28794p, this.f28793o, this.f28795q, this.f28796r, this.f28797s, this.f28798t, this.f28799u, this.f28800v, this.f28802x, this.f28803y, this.f28804z, j, this.f28786h, this.f28787i, this.f28782d);
        return zzlh;
    }

    /* renamed from: a */
    public final zzlh mo31940a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        zzlh zzlh = new zzlh(this.f28779a, this.f28783e, this.f28784f, this.f28781c, this.f28780b, this.f28785g, this.f28788j, this.f28789k, this.f28790l, this.f28791m, this.f28792n, this.f28794p, this.f28793o, this.f28795q, this.f28796r, this.f28797s, this.f28798t, i3, i4, this.f28802x, this.f28803y, this.f28804z, this.f28801w, this.f28786h, this.f28787i, this.f28782d);
        return zzlh;
    }

    /* renamed from: a */
    public final zzlh mo31942a(zzpo zzpo) {
        zzpo zzpo2 = zzpo;
        zzlh zzlh = new zzlh(this.f28779a, this.f28783e, this.f28784f, this.f28781c, this.f28780b, this.f28785g, this.f28788j, this.f28789k, this.f28790l, this.f28791m, this.f28792n, this.f28794p, this.f28793o, this.f28795q, this.f28796r, this.f28797s, this.f28798t, this.f28799u, this.f28800v, this.f28802x, this.f28803y, this.f28804z, this.f28801w, this.f28786h, this.f28787i, zzpo2);
        return zzlh;
    }

    /* renamed from: b */
    public final int mo31943b() {
        int i = this.f28788j;
        if (i != -1) {
            int i2 = this.f28789k;
            if (i2 != -1) {
                return i * i2;
            }
        }
        return -1;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    /* renamed from: a */
    public final MediaFormat mo31938a() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f28784f);
        String str = this.f28803y;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        m30632a(mediaFormat, "max-input-size", this.f28785g);
        m30632a(mediaFormat, "width", this.f28788j);
        m30632a(mediaFormat, "height", this.f28789k);
        float f = this.f28790l;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        m30632a(mediaFormat, "rotation-degrees", this.f28791m);
        m30632a(mediaFormat, "channel-count", this.f28796r);
        m30632a(mediaFormat, "sample-rate", this.f28797s);
        m30632a(mediaFormat, "encoder-delay", this.f28799u);
        m30632a(mediaFormat, "encoder-padding", this.f28800v);
        for (int i = 0; i < this.f28786h.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap((byte[]) this.f28786h.get(i)));
        }
        zztb zztb = this.f28795q;
        if (zztb != null) {
            m30632a(mediaFormat, "color-transfer", zztb.f29361c);
            m30632a(mediaFormat, "color-standard", zztb.f29359a);
            m30632a(mediaFormat, "color-range", zztb.f29360b);
            byte[] bArr = zztb.f29362d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        String str = this.f28779a;
        String str2 = this.f28783e;
        String str3 = this.f28784f;
        int i = this.f28780b;
        String str4 = this.f28803y;
        int i2 = this.f28788j;
        int i3 = this.f28789k;
        float f = this.f28790l;
        int i4 = this.f28796r;
        int i5 = this.f28797s;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        String str5 = ", ";
        sb.append(str5);
        sb.append(str2);
        sb.append(str5);
        sb.append(str3);
        sb.append(str5);
        sb.append(i);
        sb.append(str5);
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(str5);
        sb.append(i3);
        sb.append(str5);
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(str5);
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.f28778A == 0) {
            String str = this.f28779a;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.f28783e;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f28784f;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f28781c;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f28780b) * 31) + this.f28788j) * 31) + this.f28789k) * 31) + this.f28796r) * 31) + this.f28797s) * 31;
            String str5 = this.f28803y;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f28804z) * 31;
            zzne zzne = this.f28787i;
            int hashCode6 = (hashCode5 + (zzne == null ? 0 : zzne.hashCode())) * 31;
            zzpo zzpo = this.f28782d;
            if (zzpo != null) {
                i = zzpo.hashCode();
            }
            this.f28778A = hashCode6 + i;
        }
        return this.f28778A;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzlh.class != obj.getClass()) {
            return false;
        }
        zzlh zzlh = (zzlh) obj;
        if (this.f28780b != zzlh.f28780b || this.f28785g != zzlh.f28785g || this.f28788j != zzlh.f28788j || this.f28789k != zzlh.f28789k || this.f28790l != zzlh.f28790l || this.f28791m != zzlh.f28791m || this.f28792n != zzlh.f28792n || this.f28793o != zzlh.f28793o || this.f28796r != zzlh.f28796r || this.f28797s != zzlh.f28797s || this.f28798t != zzlh.f28798t || this.f28799u != zzlh.f28799u || this.f28800v != zzlh.f28800v || this.f28801w != zzlh.f28801w || this.f28802x != zzlh.f28802x || !zzsy.m31153a((Object) this.f28779a, (Object) zzlh.f28779a) || !zzsy.m31153a((Object) this.f28803y, (Object) zzlh.f28803y) || this.f28804z != zzlh.f28804z || !zzsy.m31153a((Object) this.f28783e, (Object) zzlh.f28783e) || !zzsy.m31153a((Object) this.f28784f, (Object) zzlh.f28784f) || !zzsy.m31153a((Object) this.f28781c, (Object) zzlh.f28781c) || !zzsy.m31153a((Object) this.f28787i, (Object) zzlh.f28787i) || !zzsy.m31153a((Object) this.f28782d, (Object) zzlh.f28782d) || !zzsy.m31153a((Object) this.f28795q, (Object) zzlh.f28795q) || !Arrays.equals(this.f28794p, zzlh.f28794p) || this.f28786h.size() != zzlh.f28786h.size()) {
            return false;
        }
        for (int i = 0; i < this.f28786h.size(); i++) {
            if (!Arrays.equals((byte[]) this.f28786h.get(i), (byte[]) zzlh.f28786h.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m30632a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f28779a);
        parcel.writeString(this.f28783e);
        parcel.writeString(this.f28784f);
        parcel.writeString(this.f28781c);
        parcel.writeInt(this.f28780b);
        parcel.writeInt(this.f28785g);
        parcel.writeInt(this.f28788j);
        parcel.writeInt(this.f28789k);
        parcel.writeFloat(this.f28790l);
        parcel.writeInt(this.f28791m);
        parcel.writeFloat(this.f28792n);
        parcel.writeInt(this.f28794p != null ? 1 : 0);
        byte[] bArr = this.f28794p;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.f28793o);
        parcel.writeParcelable(this.f28795q, i);
        parcel.writeInt(this.f28796r);
        parcel.writeInt(this.f28797s);
        parcel.writeInt(this.f28798t);
        parcel.writeInt(this.f28799u);
        parcel.writeInt(this.f28800v);
        parcel.writeInt(this.f28802x);
        parcel.writeString(this.f28803y);
        parcel.writeInt(this.f28804z);
        parcel.writeLong(this.f28801w);
        int size = this.f28786h.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray((byte[]) this.f28786h.get(i2));
        }
        parcel.writeParcelable(this.f28787i, 0);
        parcel.writeParcelable(this.f28782d, 0);
    }
}
