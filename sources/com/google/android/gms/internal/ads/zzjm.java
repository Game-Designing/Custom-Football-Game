package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class zzjm implements zzkf {

    /* renamed from: a */
    private final AssetManager f28681a;

    /* renamed from: b */
    private final zzke f28682b;

    /* renamed from: c */
    private String f28683c;

    /* renamed from: d */
    private InputStream f28684d;

    /* renamed from: e */
    private long f28685e;

    /* renamed from: f */
    private boolean f28686f;

    public zzjm(Context context, zzke zzke) {
        this.f28681a = context.getAssets();
        this.f28682b = zzke;
    }

    /* renamed from: a */
    public final long mo28817a(zzjq zzjq) throws zzjn {
        long j;
        try {
            this.f28683c = zzjq.f28690a.toString();
            String path = zzjq.f28690a.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.f28684d = this.f28681a.open(path, 1);
            zzkh.m30537b(this.f28684d.skip(zzjq.f28692c) == zzjq.f28692c);
            if (zzjq.f28693d == -1) {
                j = (long) this.f28684d.available();
            } else {
                j = zzjq.f28693d;
            }
            this.f28685e = j;
            if (this.f28685e >= 0) {
                this.f28686f = true;
                zzke zzke = this.f28682b;
                if (zzke != null) {
                    zzke.mo31883a();
                }
                return this.f28685e;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new zzjn(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws zzjn {
        long j = this.f28685e;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.f28684d.read(bArr, i, (int) Math.min(j, (long) i2));
            if (read > 0) {
                this.f28685e -= (long) read;
                zzke zzke = this.f28682b;
                if (zzke != null) {
                    zzke.mo31884a(read);
                }
            }
            return read;
        } catch (IOException e) {
            throw new zzjn(e);
        }
    }

    public final void close() throws zzjn {
        InputStream inputStream = this.f28684d;
        if (inputStream != null) {
            try {
                inputStream.close();
                this.f28684d = null;
                if (this.f28686f) {
                    this.f28686f = false;
                    zzke zzke = this.f28682b;
                    if (zzke != null) {
                        zzke.mo31885b();
                    }
                }
            } catch (IOException e) {
                throw new zzjn(e);
            } catch (Throwable th) {
                this.f28684d = null;
                if (this.f28686f) {
                    this.f28686f = false;
                    zzke zzke2 = this.f28682b;
                    if (zzke2 != null) {
                        zzke2.mo31885b();
                    }
                }
                throw th;
            }
        }
    }
}
