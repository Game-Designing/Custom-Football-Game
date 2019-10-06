package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

public final class zzbg extends zzdst {

    /* renamed from: A */
    private int f25280A;

    /* renamed from: n */
    private Date f25281n;

    /* renamed from: o */
    private Date f25282o;

    /* renamed from: p */
    private long f25283p;

    /* renamed from: q */
    private long f25284q;

    /* renamed from: r */
    private double f25285r = 1.0d;

    /* renamed from: s */
    private float f25286s = 1.0f;

    /* renamed from: t */
    private zzdtd f25287t = zzdtd.f28286a;

    /* renamed from: u */
    private long f25288u;

    /* renamed from: v */
    private int f25289v;

    /* renamed from: w */
    private int f25290w;

    /* renamed from: x */
    private int f25291x;

    /* renamed from: y */
    private int f25292y;

    /* renamed from: z */
    private int f25293z;

    public zzbg() {
        super("mvhd");
    }

    /* renamed from: d */
    public final long mo30555d() {
        return this.f25283p;
    }

    /* renamed from: c */
    public final long mo30554c() {
        return this.f25284q;
    }

    /* renamed from: a */
    public final void mo29159a(ByteBuffer byteBuffer) {
        mo31686b(byteBuffer);
        if (mo31685b() == 1) {
            this.f25281n = zzdsy.m30097a(zzbc.m26413c(byteBuffer));
            this.f25282o = zzdsy.m30097a(zzbc.m26413c(byteBuffer));
            this.f25283p = zzbc.m26411a(byteBuffer);
            this.f25284q = zzbc.m26413c(byteBuffer);
        } else {
            this.f25281n = zzdsy.m30097a(zzbc.m26411a(byteBuffer));
            this.f25282o = zzdsy.m30097a(zzbc.m26411a(byteBuffer));
            this.f25283p = zzbc.m26411a(byteBuffer);
            this.f25284q = zzbc.m26411a(byteBuffer);
        }
        this.f25285r = zzbc.m26414d(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.f25286s = ((float) ((short) ((bArr[1] & 255) | ((short) (0 | ((bArr[0] << 8) & 65280)))))) / 256.0f;
        zzbc.m26412b(byteBuffer);
        zzbc.m26411a(byteBuffer);
        zzbc.m26411a(byteBuffer);
        this.f25287t = zzdtd.m30101a(byteBuffer);
        this.f25289v = byteBuffer.getInt();
        this.f25290w = byteBuffer.getInt();
        this.f25291x = byteBuffer.getInt();
        this.f25292y = byteBuffer.getInt();
        this.f25293z = byteBuffer.getInt();
        this.f25280A = byteBuffer.getInt();
        this.f25288u = zzbc.m26411a(byteBuffer);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MovieHeaderBox[");
        sb.append("creationTime=");
        sb.append(this.f25281n);
        String str = ";";
        sb.append(str);
        sb.append("modificationTime=");
        sb.append(this.f25282o);
        sb.append(str);
        sb.append("timescale=");
        sb.append(this.f25283p);
        sb.append(str);
        sb.append("duration=");
        sb.append(this.f25284q);
        sb.append(str);
        sb.append("rate=");
        sb.append(this.f25285r);
        sb.append(str);
        sb.append("volume=");
        sb.append(this.f25286s);
        sb.append(str);
        sb.append("matrix=");
        sb.append(this.f25287t);
        sb.append(str);
        sb.append("nextTrackId=");
        sb.append(this.f25288u);
        sb.append("]");
        return sb.toString();
    }
}
