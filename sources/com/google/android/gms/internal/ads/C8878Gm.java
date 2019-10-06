package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbp.zza;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.ads.Gm */
final class C8878Gm implements BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    @VisibleForTesting

    /* renamed from: a */
    private zzdba f21071a;

    /* renamed from: b */
    private final String f21072b;

    /* renamed from: c */
    private final String f21073c;

    /* renamed from: d */
    private final LinkedBlockingQueue<zza> f21074d;

    /* renamed from: e */
    private final HandlerThread f21075e = new HandlerThread("GassClient");

    public C8878Gm(Context context, String str, String str2) {
        this.f21072b = str;
        this.f21073c = str2;
        this.f21075e.start();
        this.f21071a = new zzdba(context, this.f21075e.getLooper(), this, this);
        this.f21074d = new LinkedBlockingQueue<>();
        this.f21071a.checkAvailabilityAndConnect();
    }

    /* renamed from: a */
    public final zza mo28266a(int i) {
        zza zza;
        try {
            zza = (zza) this.f21074d.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zza = null;
        }
        return zza == null ? m22599c() : zza;
    }

    /* renamed from: b */
    private final zzdbf m22598b() {
        try {
            return this.f21071a.mo27780j();
        } catch (DeadObjectException | IllegalStateException e) {
            return null;
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.f21074d.put(m22599c());
        } catch (InterruptedException e) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        m22597a();
        r3.f21075e.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r3.f21074d.put(m22599c());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0025 A[ExcHandler:  FINALLY, Splitter:B:2:0x0006] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzdbf r4 = r3.m22598b()
            if (r4 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzdbb r0 = new com.google.android.gms.internal.ads.zzdbb     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r1 = r3.f21072b     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r2 = r3.f21073c     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdbd r4 = r4.mo31367a(r0)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbp$zza r4 = r4.mo31363a()     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzbp$zza> r0 = r3.f21074d     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.put(r4)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r3.m22597a()
            android.os.HandlerThread r4 = r3.f21075e
            r4.quit()
            return
        L_0x0025:
            r4 = move-exception
            goto L_0x0032
        L_0x0027:
            r4 = move-exception
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzbp$zza> r4 = r3.f21074d     // Catch:{ InterruptedException -> 0x003b, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbp$zza r0 = m22599c()     // Catch:{ InterruptedException -> 0x003b, all -> 0x0025 }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x003b, all -> 0x0025 }
            goto L_0x003c
        L_0x0032:
            r3.m22597a()
            android.os.HandlerThread r0 = r3.f21075e
            r0.quit()
            throw r4
        L_0x003b:
            r4 = move-exception
        L_0x003c:
            r3.m22597a()
            android.os.HandlerThread r4 = r3.f21075e
            r4.quit()
            return
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C8878Gm.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.f21074d.put(m22599c());
        } catch (InterruptedException e) {
        }
    }

    /* renamed from: a */
    private final void m22597a() {
        zzdba zzdba = this.f21071a;
        if (zzdba == null) {
            return;
        }
        if (zzdba.isConnected() || this.f21071a.isConnecting()) {
            this.f21071a.disconnect();
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private static zza m22599c() {
        return (zza) zza.m27422p().mo30797j(32768).mo31612g();
    }
}
