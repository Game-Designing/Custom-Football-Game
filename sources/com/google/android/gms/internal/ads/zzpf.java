package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CodecException;

public final class zzpf extends Exception {

    /* renamed from: a */
    private final String f29125a;

    /* renamed from: b */
    private final boolean f29126b;

    /* renamed from: c */
    private final String f29127c;

    /* renamed from: d */
    private final String f29128d;

    public zzpf(zzlh zzlh, Throwable th, boolean z, int i) {
        String valueOf = String.valueOf(zzlh);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
        sb.append("Decoder init failed: [");
        sb.append(i);
        sb.append("], ");
        sb.append(valueOf);
        super(sb.toString(), th);
        this.f29125a = zzlh.f28784f;
        this.f29126b = false;
        this.f29127c = null;
        String str = i < 0 ? "neg_" : "";
        int abs = Math.abs(i);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 64);
        sb2.append("com.google.android.exoplayer.MediaCodecTrackRenderer_");
        sb2.append(str);
        sb2.append(abs);
        this.f29128d = sb2.toString();
    }

    public zzpf(zzlh zzlh, Throwable th, boolean z, String str) {
        String valueOf = String.valueOf(zzlh);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(valueOf).length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(valueOf);
        super(sb.toString(), th);
        this.f29125a = zzlh.f28784f;
        this.f29126b = false;
        this.f29127c = str;
        String str2 = null;
        if (zzsy.f29345a >= 21 && (th instanceof CodecException)) {
            str2 = ((CodecException) th).getDiagnosticInfo();
        }
        this.f29128d = str2;
    }
}
