package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzaed extends AdChoicesInfo {

    /* renamed from: a */
    private final zzaea f24273a;

    /* renamed from: b */
    private final List<Image> f24274b = new ArrayList();

    /* renamed from: c */
    private String f24275c;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[Catch:{ RemoteException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0025 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaed(com.google.android.gms.internal.ads.zzaea r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r4.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r4.f24274b = r1
            r4.f24273a = r5
            com.google.android.gms.internal.ads.zzaea r1 = r4.f24273a     // Catch:{ RemoteException -> 0x0017 }
            java.lang.String r1 = r1.getText()     // Catch:{ RemoteException -> 0x0017 }
            r4.f24275c = r1     // Catch:{ RemoteException -> 0x0017 }
            goto L_0x001d
        L_0x0017:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r1)
            r4.f24275c = r0
        L_0x001d:
            java.util.List r5 = r5.mo29636za()     // Catch:{ RemoteException -> 0x005b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ RemoteException -> 0x005b }
        L_0x0025:
            boolean r1 = r5.hasNext()     // Catch:{ RemoteException -> 0x005b }
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r5.next()     // Catch:{ RemoteException -> 0x005b }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005b }
            if (r2 == 0) goto L_0x004b
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x005b }
            if (r1 == 0) goto L_0x004b
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x005b }
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaei     // Catch:{ RemoteException -> 0x005b }
            if (r3 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzaei r2 = (com.google.android.gms.internal.ads.zzaei) r2     // Catch:{ RemoteException -> 0x005b }
            goto L_0x004c
        L_0x0045:
            com.google.android.gms.internal.ads.zzaek r2 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x005b }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x005b }
            goto L_0x004c
        L_0x004b:
            r2 = 0
        L_0x004c:
            if (r2 == 0) goto L_0x0025
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r1 = r4.f24274b     // Catch:{ RemoteException -> 0x005b }
            com.google.android.gms.internal.ads.zzael r3 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x005b }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005b }
            r1.add(r3)     // Catch:{ RemoteException -> 0x005b }
            goto L_0x0025
        L_0x005a:
            return
        L_0x005b:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaed.<init>(com.google.android.gms.internal.ads.zzaea):void");
    }

    public final CharSequence getText() {
        return this.f24275c;
    }

    public final List<Image> getImages() {
        return this.f24274b;
    }
}
