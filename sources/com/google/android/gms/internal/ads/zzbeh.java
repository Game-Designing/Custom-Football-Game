package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzard
public final class zzbeh implements zzjp {

    /* renamed from: a */
    private InputStream f25217a;

    /* renamed from: b */
    private boolean f25218b;

    /* renamed from: c */
    private final Context f25219c;

    /* renamed from: d */
    private final zzjp f25220d;

    /* renamed from: e */
    private final WeakReference<zzbei> f25221e;

    public zzbeh(Context context, zzjp zzjp, zzbei zzbei) {
        this.f25219c = context;
        this.f25220d = zzjp;
        this.f25221e = new WeakReference<>(zzbei);
    }

    public final void close() throws IOException {
        if (this.f25218b) {
            this.f25218b = false;
            InputStream inputStream = this.f25217a;
            if (inputStream != null) {
                IOUtils.m22102a(inputStream);
                this.f25217a = null;
                return;
            }
            this.f25220d.close();
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    /* renamed from: a */
    public final long mo28817a(zzjq zzjq) throws IOException {
        zzjq zzjq2;
        Long l;
        zzjq zzjq3 = zzjq;
        String str = "ms";
        String str2 = "Cache connection took ";
        if (!this.f25218b) {
            this.f25218b = true;
            zzvv a = zzvv.m31316a(zzjq3.f28690a);
            if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24194wd)).booleanValue()) {
                zzvs zzvs = null;
                if (a != null) {
                    a.f29558h = zzjq3.f28692c;
                    zzvs = zzk.zzlm().mo32314a(a);
                }
                if (zzvs != null && zzvs.mo32317a()) {
                    this.f25217a = zzvs.mo32318c();
                    return -1;
                }
            } else if (a != null) {
                a.f29558h = zzjq3.f28692c;
                if (a.f29557g) {
                    l = (Long) zzyt.m31536e().mo29599a(zzacu.f24206yd);
                } else {
                    l = (Long) zzyt.m31536e().mo29599a(zzacu.f24200xd);
                }
                long longValue = l.longValue();
                long a2 = zzk.zzln().mo27934a();
                zzk.zzma();
                Future a3 = zzwi.m31330a(this.f25219c, a);
                try {
                    this.f25217a = (InputStream) a3.get(longValue, TimeUnit.MILLISECONDS);
                    long a4 = zzk.zzln().mo27934a() - a2;
                    zzbei zzbei = (zzbei) this.f25221e.get();
                    if (zzbei != null) {
                        zzbei.mo28180a(true, a4);
                    }
                    StringBuilder sb = new StringBuilder(44);
                    sb.append(str2);
                    sb.append(a4);
                    sb.append(str);
                    zzawz.m26003f(sb.toString());
                    return -1;
                } catch (ExecutionException | TimeoutException e) {
                    a3.cancel(true);
                    long a5 = zzk.zzln().mo27934a() - a2;
                    zzbei zzbei2 = (zzbei) this.f25221e.get();
                    if (zzbei2 != null) {
                        zzbei2.mo28180a(false, a5);
                    }
                    StringBuilder sb2 = new StringBuilder(44);
                    sb2.append(str2);
                    sb2.append(a5);
                    sb2.append(str);
                    zzawz.m26003f(sb2.toString());
                } catch (InterruptedException e2) {
                    a3.cancel(true);
                    Thread.currentThread().interrupt();
                    long a6 = zzk.zzln().mo27934a() - a2;
                    zzbei zzbei3 = (zzbei) this.f25221e.get();
                    if (zzbei3 != null) {
                        zzbei3.mo28180a(false, a6);
                    }
                    StringBuilder sb3 = new StringBuilder(44);
                    sb3.append(str2);
                    sb3.append(a6);
                    sb3.append(str);
                    zzawz.m26003f(sb3.toString());
                } catch (Throwable th) {
                    long a7 = zzk.zzln().mo27934a() - a2;
                    zzbei zzbei4 = (zzbei) this.f25221e.get();
                    if (zzbei4 != null) {
                        zzbei4.mo28180a(false, a7);
                    }
                    StringBuilder sb4 = new StringBuilder(44);
                    sb4.append(str2);
                    sb4.append(a7);
                    sb4.append(str);
                    zzawz.m26003f(sb4.toString());
                    throw th;
                }
            }
            if (a != null) {
                zzjq2 = new zzjq(Uri.parse(a.f29551a), zzjq3.f28691b, zzjq3.f28692c, zzjq3.f28693d, zzjq3.f28694e, zzjq3.f28695f);
            } else {
                zzjq2 = zzjq3;
            }
            return this.f25220d.mo28817a(zzjq2);
        }
        throw new IOException("Attempt to open an already open CacheDataSource.");
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f25218b) {
            InputStream inputStream = this.f25217a;
            if (inputStream != null) {
                return inputStream.read(bArr, i, i2);
            }
            return this.f25220d.read(bArr, i, i2);
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }
}
