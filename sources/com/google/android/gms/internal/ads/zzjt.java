package com.google.android.gms.internal.ads;

import android.content.Context;
import com.mopub.common.Constants;
import java.io.IOException;

public final class zzjt implements zzkf {

    /* renamed from: a */
    private final zzkf f28717a;

    /* renamed from: b */
    private final zzkf f28718b;

    /* renamed from: c */
    private final zzkf f28719c;

    /* renamed from: d */
    private zzkf f28720d;

    public zzjt(Context context, String str) {
        this(context, null, str, false);
    }

    private zzjt(Context context, zzke zzke, String str, boolean z) {
        zzjs zzjs = new zzjs(str, null, null, 8000, 8000, false);
        this(context, null, zzjs);
    }

    private zzjt(Context context, zzke zzke, zzkf zzkf) {
        zzkh.m30534a(zzkf);
        this.f28717a = zzkf;
        this.f28718b = new zzjv(null);
        this.f28719c = new zzjm(context, null);
    }

    /* renamed from: a */
    public final long mo28817a(zzjq zzjq) throws IOException {
        zzkh.m30537b(this.f28720d == null);
        String scheme = zzjq.f28690a.getScheme();
        if (Constants.HTTP.equals(scheme) || "https".equals(scheme)) {
            this.f28720d = this.f28717a;
        } else if ("file".equals(scheme)) {
            if (zzjq.f28690a.getPath().startsWith("/android_asset/")) {
                this.f28720d = this.f28719c;
            } else {
                this.f28720d = this.f28718b;
            }
        } else if ("asset".equals(scheme)) {
            this.f28720d = this.f28719c;
        } else {
            throw new zzju(scheme);
        }
        return this.f28720d.mo28817a(zzjq);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f28720d.read(bArr, i, i2);
    }

    public final void close() throws IOException {
        zzkf zzkf = this.f28720d;
        if (zzkf != null) {
            try {
                zzkf.close();
            } finally {
                this.f28720d = null;
            }
        }
    }
}
