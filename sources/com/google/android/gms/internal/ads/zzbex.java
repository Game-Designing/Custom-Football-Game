package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzard
public final class zzbex implements zzrv {

    /* renamed from: a */
    private InputStream f25242a;

    /* renamed from: b */
    private boolean f25243b;

    /* renamed from: c */
    private final Context f25244c;

    /* renamed from: d */
    private final zzrv f25245d;

    /* renamed from: e */
    private final zzsj<zzrv> f25246e;

    /* renamed from: f */
    private final zzbey f25247f;

    /* renamed from: g */
    private Uri f25248g;

    public zzbex(Context context, zzrv zzrv, zzsj<zzrv> zzsj, zzbey zzbey) {
        this.f25244c = context;
        this.f25245d = zzrv;
        this.f25246e = zzsj;
        this.f25247f = zzbey;
    }

    public final void close() throws IOException {
        if (this.f25243b) {
            this.f25243b = false;
            this.f25248g = null;
            InputStream inputStream = this.f25242a;
            if (inputStream != null) {
                IOUtils.m22102a(inputStream);
                this.f25242a = null;
            } else {
                this.f25245d.close();
            }
            zzsj<zzrv> zzsj = this.f25246e;
            if (zzsj != null) {
                zzsj.mo30517a(this);
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    /* renamed from: a */
    public final long mo29017a(zzry zzry) throws IOException {
        zzry zzry2;
        Long l;
        zzry zzry3 = zzry;
        String str = "ms";
        String str2 = "Cache connection took ";
        if (!this.f25243b) {
            boolean z = true;
            this.f25243b = z;
            this.f25248g = zzry3.f29268a;
            zzsj<zzrv> zzsj = this.f25246e;
            if (zzsj != null) {
                zzsj.mo30519a(this, zzry3);
            }
            zzvv a = zzvv.m31316a(zzry3.f29268a);
            if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24194wd)).booleanValue()) {
                zzvs zzvs = null;
                if (a != null) {
                    a.f29558h = zzry3.f29271d;
                    zzvs = zzk.zzlm().mo32314a(a);
                }
                if (zzvs != null && zzvs.mo32317a()) {
                    this.f25242a = zzvs.mo32318c();
                    return -1;
                }
            } else if (a != null) {
                a.f29558h = zzry3.f29271d;
                if (a.f29557g) {
                    l = (Long) zzyt.m31536e().mo29599a(zzacu.f24206yd);
                } else {
                    l = (Long) zzyt.m31536e().mo29599a(zzacu.f24200xd);
                }
                long longValue = l.longValue();
                long a2 = zzk.zzln().mo27934a();
                zzk.zzma();
                Future a3 = zzwi.m31330a(this.f25244c, a);
                z = false;
                try {
                    this.f25242a = (InputStream) a3.get(longValue, TimeUnit.MILLISECONDS);
                    return -1;
                } catch (ExecutionException | TimeoutException e) {
                    a3.cancel(z);
                } catch (InterruptedException e2) {
                    a3.cancel(z);
                    Thread.currentThread().interrupt();
                } finally {
                    long j = zzk.zzln().mo27934a() - a2;
                    this.f25247f.mo29154a(z, j);
                    StringBuilder sb = new StringBuilder(44);
                    sb.append(str2);
                    sb.append(j);
                    sb.append(str);
                    zzawz.m26003f(sb.toString());
                }
            }
            if (a != null) {
                zzry2 = new zzry(Uri.parse(a.f29551a), zzry3.f29269b, zzry3.f29270c, zzry3.f29271d, zzry3.f29272e, zzry3.f29273f, zzry3.f29274g);
            } else {
                zzry2 = zzry3;
            }
            return this.f25245d.mo29017a(zzry2);
        }
        throw new IOException("Attempt to open an already open CacheDataSource.");
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.f25243b) {
            InputStream inputStream = this.f25242a;
            if (inputStream != null) {
                i3 = inputStream.read(bArr, i, i2);
            } else {
                i3 = this.f25245d.read(bArr, i, i2);
            }
            zzsj<zzrv> zzsj = this.f25246e;
            if (zzsj != null) {
                zzsj.mo30518a(this, i3);
            }
            return i3;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    public final Uri getUri() {
        return this.f25248g;
    }
}
