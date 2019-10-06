package com.google.android.gms.internal.ads;

import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.ads.rb */
final class C9682rb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ OutputStream f22928a;

    /* renamed from: b */
    private final /* synthetic */ byte[] f22929b;

    C9682rb(zzaru zzaru, OutputStream outputStream, byte[] bArr) {
        this.f22928a = outputStream;
        this.f22929b = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x001f, all -> 0x001a }
            java.io.OutputStream r2 = r5.f22928a     // Catch:{ IOException -> 0x001f, all -> 0x001a }
            r1.<init>(r2)     // Catch:{ IOException -> 0x001f, all -> 0x001a }
            byte[] r0 = r5.f22929b     // Catch:{ IOException -> 0x0018 }
            int r0 = r0.length     // Catch:{ IOException -> 0x0018 }
            r1.writeInt(r0)     // Catch:{ IOException -> 0x0018 }
            byte[] r0 = r5.f22929b     // Catch:{ IOException -> 0x0018 }
            r1.write(r0)     // Catch:{ IOException -> 0x0018 }
            com.google.android.gms.common.util.IOUtils.m22102a(r1)
            return
        L_0x0018:
            r0 = move-exception
            goto L_0x0023
        L_0x001a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x003e
        L_0x001f:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0023:
            java.lang.String r2 = "Error transporting the ad response"
            com.google.android.gms.internal.ads.zzbad.m26356b(r2, r0)     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.ads.zzawm r2 = com.google.android.gms.ads.internal.zzk.zzlk()     // Catch:{ all -> 0x003d }
            java.lang.String r3 = "LargeParcelTeleporter.pipeData.1"
            r2.mo30168a(r0, r3)     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x0039
            java.io.OutputStream r0 = r5.f22928a
            com.google.android.gms.common.util.IOUtils.m22102a(r0)
            return
        L_0x0039:
            com.google.android.gms.common.util.IOUtils.m22102a(r1)
            return
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            if (r1 != 0) goto L_0x0046
            java.io.OutputStream r1 = r5.f22928a
            com.google.android.gms.common.util.IOUtils.m22102a(r1)
            goto L_0x0049
        L_0x0046:
            com.google.android.gms.common.util.IOUtils.m22102a(r1)
        L_0x0049:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9682rb.run():void");
    }
}
