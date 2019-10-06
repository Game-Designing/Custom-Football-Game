package com.fyber.inneractive.sdk.p166g.p167a;

/* renamed from: com.fyber.inneractive.sdk.g.a.f */
final class C7782f extends C7757b {
    protected C7782f() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[Catch:{ all -> 0x0072 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo24362a(com.fyber.inneractive.sdk.p166g.p167a.C7756a r7) {
        /*
            r6 = this;
            int r0 = com.fyber.inneractive.sdk.p166g.p167a.C7757b.C7758a.f15563c
            android.media.MediaPlayer r1 = new android.media.MediaPlayer
            r1.<init>()
            java.io.File r2 = r7.mo24359a()
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x0077
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.io.File r4 = r7.mo24359a()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r3.<init>(r4)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            java.io.File r2 = r7.mo24359a()     // Catch:{ IOException -> 0x0058 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ IOException -> 0x0058 }
            r1.setDataSource(r2)     // Catch:{ IOException -> 0x0058 }
            r1.prepare()     // Catch:{ IOException -> 0x0058 }
            int r2 = r1.getDuration()     // Catch:{ IOException -> 0x0058 }
            if (r2 <= 0) goto L_0x006e
            int r0 = com.fyber.inneractive.sdk.p166g.p167a.C7757b.C7758a.f15561a     // Catch:{ IOException -> 0x0058 }
            int r2 = r1.getVideoWidth()     // Catch:{ IOException -> 0x0058 }
            if (r2 <= 0) goto L_0x006e
            int r2 = r1.getVideoHeight()     // Catch:{ IOException -> 0x0058 }
            if (r2 <= 0) goto L_0x006e
            java.lang.String r2 = "video.width"
            int r4 = r1.getVideoWidth()     // Catch:{ IOException -> 0x0058 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0058 }
            r6.mo24363a(r2, r4)     // Catch:{ IOException -> 0x0058 }
            java.lang.String r2 = "video.height"
            int r4 = r1.getVideoHeight()     // Catch:{ IOException -> 0x0058 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0058 }
            r6.mo24363a(r2, r4)     // Catch:{ IOException -> 0x0058 }
            goto L_0x006e
        L_0x0058:
            r2 = move-exception
            goto L_0x0061
        L_0x005a:
            r7 = move-exception
            r3 = r2
            goto L_0x0073
        L_0x005d:
            r3 = move-exception
            r5 = r3
            r3 = r2
            r2 = r5
        L_0x0061:
            java.lang.String r4 = "Exception raised while trying to open a cache candidate"
            com.fyber.inneractive.sdk.util.IAlog.m18020a(r4, r2)     // Catch:{ all -> 0x0072 }
            boolean r7 = r7.f15554c     // Catch:{ all -> 0x0072 }
            if (r7 == 0) goto L_0x006e
            int r7 = com.fyber.inneractive.sdk.p166g.p167a.C7757b.C7758a.f15562b     // Catch:{ all -> 0x0072 }
            r0 = r7
        L_0x006e:
            com.fyber.inneractive.sdk.p166g.p167a.C7789k.m17288a(r3)
            goto L_0x0077
        L_0x0072:
            r7 = move-exception
        L_0x0073:
            com.fyber.inneractive.sdk.p166g.p167a.C7789k.m17288a(r3)
            throw r7
        L_0x0077:
            r1.release()     // Catch:{ Throwable -> 0x007b }
        L_0x007a:
            goto L_0x007d
        L_0x007b:
            r7 = move-exception
            goto L_0x007a
        L_0x007d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7782f.mo24362a(com.fyber.inneractive.sdk.g.a.a):int");
    }
}
