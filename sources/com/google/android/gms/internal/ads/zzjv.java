package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class zzjv implements zzkf {

    /* renamed from: a */
    private final zzke f28722a;

    /* renamed from: b */
    private RandomAccessFile f28723b;

    /* renamed from: c */
    private String f28724c;

    /* renamed from: d */
    private long f28725d;

    /* renamed from: e */
    private boolean f28726e;

    public zzjv() {
        this(null);
    }

    public zzjv(zzke zzke) {
        this.f28722a = zzke;
    }

    /* renamed from: a */
    public final long mo28817a(zzjq zzjq) throws zzjw {
        long j;
        try {
            this.f28724c = zzjq.f28690a.toString();
            this.f28723b = new RandomAccessFile(zzjq.f28690a.getPath(), "r");
            this.f28723b.seek(zzjq.f28692c);
            if (zzjq.f28693d == -1) {
                j = this.f28723b.length() - zzjq.f28692c;
            } else {
                j = zzjq.f28693d;
            }
            this.f28725d = j;
            if (this.f28725d >= 0) {
                this.f28726e = true;
                zzke zzke = this.f28722a;
                if (zzke != null) {
                    zzke.mo31883a();
                }
                return this.f28725d;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new zzjw(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws zzjw {
        long j = this.f28725d;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.f28723b.read(bArr, i, (int) Math.min(j, (long) i2));
            if (read > 0) {
                this.f28725d -= (long) read;
                zzke zzke = this.f28722a;
                if (zzke != null) {
                    zzke.mo31884a(read);
                }
            }
            return read;
        } catch (IOException e) {
            throw new zzjw(e);
        }
    }

    public final void close() throws zzjw {
        RandomAccessFile randomAccessFile = this.f28723b;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
                this.f28723b = null;
                this.f28724c = null;
                if (this.f28726e) {
                    this.f28726e = false;
                    zzke zzke = this.f28722a;
                    if (zzke != null) {
                        zzke.mo31885b();
                    }
                }
            } catch (IOException e) {
                throw new zzjw(e);
            } catch (Throwable th) {
                this.f28723b = null;
                this.f28724c = null;
                if (this.f28726e) {
                    this.f28726e = false;
                    zzke zzke2 = this.f28722a;
                    if (zzke2 != null) {
                        zzke2.mo31885b();
                    }
                }
                throw th;
            }
        }
    }
}
