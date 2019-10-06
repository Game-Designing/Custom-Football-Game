package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class zzdsr implements zzbd {

    /* renamed from: a */
    private static zzdtc f28255a = zzdtc.m30099a(zzdsr.class);

    /* renamed from: b */
    private String f28256b;

    /* renamed from: c */
    private zzbe f28257c;

    /* renamed from: d */
    boolean f28258d;

    /* renamed from: e */
    private boolean f28259e;

    /* renamed from: f */
    private ByteBuffer f28260f;

    /* renamed from: g */
    private long f28261g;

    /* renamed from: h */
    private long f28262h;

    /* renamed from: i */
    private long f28263i = -1;

    /* renamed from: j */
    private zzdsw f28264j;

    /* renamed from: k */
    private ByteBuffer f28265k = null;

    /* renamed from: b */
    private final synchronized void mo31685b() {
        if (!this.f28259e) {
            try {
                zzdtc zzdtc = f28255a;
                String str = "mem mapping ";
                String valueOf = String.valueOf(this.f28256b);
                zzdtc.mo31691a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                this.f28260f = this.f28264j.mo29173a(this.f28261g, this.f28263i);
                this.f28259e = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo29159a(ByteBuffer byteBuffer);

    protected zzdsr(String str) {
        this.f28256b = str;
        this.f28259e = true;
        this.f28258d = true;
    }

    /* renamed from: a */
    public final void mo30420a(zzdsw zzdsw, ByteBuffer byteBuffer, long j, zzba zzba) throws IOException {
        this.f28261g = zzdsw.position();
        this.f28262h = this.f28261g - ((long) byteBuffer.remaining());
        this.f28263i = j;
        this.f28264j = zzdsw;
        zzdsw.mo29175g(zzdsw.position() + j);
        this.f28259e = false;
        this.f28258d = false;
        mo31683a();
    }

    /* renamed from: a */
    public final synchronized void mo31683a() {
        mo31685b();
        zzdtc zzdtc = f28255a;
        String str = "parsing details of ";
        String valueOf = String.valueOf(this.f28256b);
        zzdtc.mo31691a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        if (this.f28260f != null) {
            ByteBuffer byteBuffer = this.f28260f;
            this.f28258d = true;
            byteBuffer.rewind();
            mo29159a(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.f28265k = byteBuffer.slice();
            }
            this.f28260f = null;
        }
    }

    public final String getType() {
        return this.f28256b;
    }

    /* renamed from: a */
    public final void mo30419a(zzbe zzbe) {
        this.f28257c = zzbe;
    }
}
