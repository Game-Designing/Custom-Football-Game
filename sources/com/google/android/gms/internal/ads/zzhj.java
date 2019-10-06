package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzhj {

    /* renamed from: a */
    public final String f28509a;

    /* renamed from: b */
    private final int f28510b;

    /* renamed from: c */
    public final long f28511c;

    /* renamed from: d */
    public final int f28512d;

    /* renamed from: e */
    public final int f28513e;

    /* renamed from: f */
    public final float f28514f;

    /* renamed from: g */
    private final int f28515g;

    /* renamed from: h */
    private final int f28516h;

    /* renamed from: i */
    public final List<byte[]> f28517i;

    /* renamed from: j */
    private int f28518j;

    /* renamed from: k */
    private int f28519k;

    /* renamed from: l */
    private int f28520l;

    /* renamed from: m */
    private MediaFormat f28521m;

    @TargetApi(16)
    /* renamed from: a */
    public static zzhj m30355a(MediaFormat mediaFormat) {
        return new zzhj(mediaFormat);
    }

    /* renamed from: a */
    public static zzhj m30358a(String str, int i, long j, int i2, int i3, List<byte[]> list) {
        return m30357a(str, -1, j, i2, i3, 1.0f, list);
    }

    /* renamed from: a */
    public static zzhj m30357a(String str, int i, long j, int i2, int i3, float f, List<byte[]> list) {
        zzhj zzhj = new zzhj(str, -1, j, i2, i3, f, -1, -1, list);
        return zzhj;
    }

    /* renamed from: a */
    public static zzhj m30356a(String str, int i, int i2, int i3, List<byte[]> list) {
        return m30360b(str, -1, -1, i2, i3, list);
    }

    /* renamed from: b */
    public static zzhj m30360b(String str, int i, long j, int i2, int i3, List<byte[]> list) {
        zzhj zzhj = new zzhj(str, i, j, -1, -1, -1.0f, i2, i3, list);
        return zzhj;
    }

    /* renamed from: a */
    public static zzhj m30354a() {
        zzhj zzhj = new zzhj("application/ttml+xml", -1, -1, -1, -1, -1.0f, -1, -1, null);
        return zzhj;
    }

    @TargetApi(16)
    private zzhj(MediaFormat mediaFormat) {
        this.f28521m = mediaFormat;
        this.f28509a = mediaFormat.getString("mime");
        this.f28510b = m30353a(mediaFormat, "max-input-size");
        this.f28512d = m30353a(mediaFormat, "width");
        this.f28513e = m30353a(mediaFormat, "height");
        this.f28515g = m30353a(mediaFormat, "channel-count");
        this.f28516h = m30353a(mediaFormat, "sample-rate");
        String str = "com.google.android.videos.pixelWidthHeightRatio";
        this.f28514f = mediaFormat.containsKey(str) ? mediaFormat.getFloat(str) : -1.0f;
        this.f28517i = new ArrayList();
        int i = 0;
        while (true) {
            StringBuilder sb = new StringBuilder(15);
            String str2 = "csd-";
            sb.append(str2);
            sb.append(i);
            if (!mediaFormat.containsKey(sb.toString())) {
                break;
            }
            StringBuilder sb2 = new StringBuilder(15);
            sb2.append(str2);
            sb2.append(i);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb2.toString());
            byte[] bArr = new byte[byteBuffer.limit()];
            byteBuffer.get(bArr);
            this.f28517i.add(bArr);
            byteBuffer.flip();
            i++;
        }
        String str3 = "durationUs";
        this.f28511c = mediaFormat.containsKey(str3) ? mediaFormat.getLong(str3) : -1;
        this.f28518j = -1;
        this.f28519k = -1;
    }

    private zzhj(String str, int i, long j, int i2, int i3, float f, int i4, int i5, List<byte[]> list) {
        this.f28509a = str;
        this.f28510b = i;
        this.f28511c = j;
        this.f28512d = i2;
        this.f28513e = i3;
        this.f28514f = f;
        this.f28515g = i4;
        this.f28516h = i5;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f28517i = list;
        this.f28518j = -1;
        this.f28519k = -1;
    }

    public final int hashCode() {
        if (this.f28520l == 0) {
            String str = this.f28509a;
            int hashCode = (((((((((((((((((((str == null ? 0 : str.hashCode()) + 527) * 31) + this.f28510b) * 31) + this.f28512d) * 31) + this.f28513e) * 31) + Float.floatToRawIntBits(this.f28514f)) * 31) + ((int) this.f28511c)) * 31) + this.f28518j) * 31) + this.f28519k) * 31) + this.f28515g) * 31) + this.f28516h;
            for (int i = 0; i < this.f28517i.size(); i++) {
                hashCode = (hashCode * 31) + Arrays.hashCode((byte[]) this.f28517i.get(i));
            }
            this.f28520l = hashCode;
        }
        return this.f28520l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzhj.class != obj.getClass()) {
            return false;
        }
        zzhj zzhj = (zzhj) obj;
        if (this.f28510b != zzhj.f28510b || this.f28512d != zzhj.f28512d || this.f28513e != zzhj.f28513e || this.f28514f != zzhj.f28514f || this.f28518j != zzhj.f28518j || this.f28519k != zzhj.f28519k || this.f28515g != zzhj.f28515g || this.f28516h != zzhj.f28516h || !zzkq.m30568a((Object) this.f28509a, (Object) zzhj.f28509a) || this.f28517i.size() != zzhj.f28517i.size()) {
            return false;
        }
        for (int i = 0; i < this.f28517i.size(); i++) {
            if (!Arrays.equals((byte[]) this.f28517i.get(i), (byte[]) zzhj.f28517i.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        String str = this.f28509a;
        int i = this.f28510b;
        int i2 = this.f28512d;
        int i3 = this.f28513e;
        float f = this.f28514f;
        int i4 = this.f28515g;
        int i5 = this.f28516h;
        long j = this.f28511c;
        int i6 = this.f28518j;
        int i7 = this.f28519k;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + Opcodes.D2L);
        sb.append("MediaFormat(");
        sb.append(str);
        String str2 = ", ";
        sb.append(str2);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        sb.append(str2);
        sb.append(f);
        sb.append(str2);
        sb.append(i4);
        sb.append(str2);
        sb.append(i5);
        sb.append(str2);
        sb.append(j);
        sb.append(str2);
        sb.append(i6);
        sb.append(str2);
        sb.append(i7);
        sb.append(")");
        return sb.toString();
    }

    @TargetApi(16)
    /* renamed from: b */
    public final MediaFormat mo31806b() {
        if (this.f28521m == null) {
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", this.f28509a);
            m30359a(mediaFormat, "max-input-size", this.f28510b);
            m30359a(mediaFormat, "width", this.f28512d);
            m30359a(mediaFormat, "height", this.f28513e);
            m30359a(mediaFormat, "channel-count", this.f28515g);
            m30359a(mediaFormat, "sample-rate", this.f28516h);
            float f = this.f28514f;
            if (f != -1.0f) {
                mediaFormat.setFloat("com.google.android.videos.pixelWidthHeightRatio", f);
            }
            for (int i = 0; i < this.f28517i.size(); i++) {
                StringBuilder sb = new StringBuilder(15);
                sb.append("csd-");
                sb.append(i);
                mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap((byte[]) this.f28517i.get(i)));
            }
            long j = this.f28511c;
            if (j != -1) {
                mediaFormat.setLong("durationUs", j);
            }
            m30359a(mediaFormat, "max-width", this.f28518j);
            m30359a(mediaFormat, "max-height", this.f28519k);
            this.f28521m = mediaFormat;
        }
        return this.f28521m;
    }

    @TargetApi(16)
    /* renamed from: a */
    private static final void m30359a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private static final int m30353a(MediaFormat mediaFormat, String str) {
        if (mediaFormat.containsKey(str)) {
            return mediaFormat.getInteger(str);
        }
        return -1;
    }
}
