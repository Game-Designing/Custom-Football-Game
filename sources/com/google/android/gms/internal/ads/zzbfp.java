package com.google.android.gms.internal.ads;

@zzard
public final class zzbfp implements zzaho<zzbdf> {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0079 A[Catch:{ NullPointerException | NumberFormatException -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007c A[Catch:{ NullPointerException | NumberFormatException -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0087 A[Catch:{ NullPointerException | NumberFormatException -> 0x00cc }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void mo27996a(java.lang.Object r8, java.util.Map r9) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbdf r8 = (com.google.android.gms.internal.ads.zzbdf) r8
            com.google.android.gms.internal.ads.zzbhq r0 = r8.mo28754g()
            java.lang.String r1 = "duration"
            java.lang.String r2 = "1"
            if (r0 != 0) goto L_0x0033
            java.lang.Object r0 = r9.get(r1)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r3 = "customControlsAllowed"
            java.lang.Object r3 = r9.get(r3)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            boolean r3 = r2.equals(r3)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r4 = "clickToExpandAllowed"
            java.lang.Object r4 = r9.get(r4)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            boolean r4 = r2.equals(r4)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            com.google.android.gms.internal.ads.zzbhq r5 = new com.google.android.gms.internal.ads.zzbhq     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r5.<init>(r8, r0, r3, r4)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r8.mo28722a(r5)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r0 = r5
        L_0x0033:
            java.lang.Object r8 = r9.get(r1)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            float r8 = java.lang.Float.parseFloat(r8)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r1 = "muted"
            java.lang.Object r1 = r9.get(r1)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            boolean r4 = r2.equals(r1)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r1 = "currentTime"
            java.lang.Object r1 = r9.get(r1)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r2 = "playbackState"
            java.lang.Object r2 = r9.get(r2)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r3 = 3
            if (r2 < 0) goto L_0x0068
            if (r3 >= r2) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r5 = r2
            goto L_0x006a
        L_0x0068:
            r2 = 0
            r5 = 0
        L_0x006a:
            java.lang.String r2 = "aspectRatio"
            java.lang.Object r9 = r9.get(r2)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            if (r2 == 0) goto L_0x007c
            r2 = 0
            r6 = 0
            goto L_0x0081
        L_0x007c:
            float r2 = java.lang.Float.parseFloat(r9)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r6 = r2
        L_0x0081:
            boolean r2 = com.google.android.gms.internal.ads.zzbad.m26354a(r3)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            if (r2 == 0) goto L_0x00c5
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            int r2 = r2.length()     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            int r2 = r2 + 140
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r3.<init>(r2)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r2 = "Video Meta GMSG: currentTime : "
            r3.append(r2)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r3.append(r1)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r2 = " , duration : "
            r3.append(r2)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r3.append(r8)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r2 = " , isMuted : "
            r3.append(r2)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r3.append(r4)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r2 = " , playbackState : "
            r3.append(r2)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r3.append(r5)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r2 = " , aspectRatio : "
            r3.append(r2)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            r3.append(r9)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            java.lang.String r9 = r3.toString()     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            com.google.android.gms.internal.ads.zzbad.m26352a(r9)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
        L_0x00c5:
            r2 = r8
            r3 = r5
            r5 = r6
            r0.mo30628a(r1, r2, r3, r4, r5)     // Catch:{ NullPointerException -> 0x00ce, NumberFormatException -> 0x00cc }
            return
        L_0x00cc:
            r8 = move-exception
            goto L_0x00cf
        L_0x00ce:
            r8 = move-exception
        L_0x00cf:
            java.lang.String r9 = "Unable to parse videoMeta message."
            com.google.android.gms.internal.ads.zzbad.m26356b(r9, r8)
            com.google.android.gms.internal.ads.zzawm r9 = com.google.android.gms.ads.internal.zzk.zzlk()
            java.lang.String r0 = "VideoMetaGmsgHandler.onGmsg"
            r9.mo30168a(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfp.mo27996a(java.lang.Object, java.util.Map):void");
    }
}
