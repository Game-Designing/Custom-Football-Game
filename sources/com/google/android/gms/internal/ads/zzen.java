package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbk.zza;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.util.concurrent.ExecutionException;

public final class zzen extends zzfk {

    /* renamed from: i */
    private static final zzfl<zzch> f28376i = new zzfl<>();

    /* renamed from: j */
    private final Context f28377j;

    /* renamed from: k */
    private zza f28378k = null;

    public zzen(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2, Context context, zza zza2) {
        super(zzdy, str, str2, zza, i, 27);
        this.f28377j = context;
        this.f28378k = zza2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo31743a() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzfl<com.google.android.gms.internal.ads.zzch> r0 = f28376i
            android.content.Context r1 = r8.f28377j
            java.lang.String r1 = r1.getPackageName()
            java.util.concurrent.atomic.AtomicReference r0 = r0.mo31748a(r1)
            monitor-enter(r0)
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzch r1 = (com.google.android.gms.internal.ads.zzch) r1     // Catch:{ all -> 0x0123 }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0036
            java.lang.String r4 = r1.f26608b     // Catch:{ all -> 0x0123 }
            boolean r4 = com.google.android.gms.internal.ads.zzef.m30170b(r4)     // Catch:{ all -> 0x0123 }
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = r1.f26608b     // Catch:{ all -> 0x0123 }
            java.lang.String r5 = "E"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0123 }
            if (r4 != 0) goto L_0x0036
            java.lang.String r1 = r1.f26608b     // Catch:{ all -> 0x0123 }
            java.lang.String r4 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0123 }
            if (r1 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 == 0) goto L_0x00ef
            com.google.android.gms.internal.ads.zzbk$zza r1 = r8.f28378k     // Catch:{ all -> 0x0123 }
            java.lang.String r1 = m30184a(r1)     // Catch:{ all -> 0x0123 }
            boolean r1 = com.google.android.gms.internal.ads.zzef.m30170b(r1)     // Catch:{ all -> 0x0123 }
            if (r1 != 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzbm r1 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED     // Catch:{ all -> 0x0123 }
            goto L_0x0083
        L_0x0049:
            com.google.android.gms.internal.ads.zzbk$zza r1 = r8.f28378k     // Catch:{ all -> 0x0123 }
            java.lang.String r4 = m30184a(r1)     // Catch:{ all -> 0x0123 }
            boolean r4 = com.google.android.gms.internal.ads.zzef.m30170b(r4)     // Catch:{ all -> 0x0123 }
            if (r4 == 0) goto L_0x006b
            if (r1 == 0) goto L_0x006b
            boolean r4 = r1.mo30710l()     // Catch:{ all -> 0x0123 }
            if (r4 == 0) goto L_0x006b
            com.google.android.gms.internal.ads.zzbk$zzb r1 = r1.mo30711m()     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzbm r1 = r1.mo30714n()     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzbm r4 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x0123 }
            if (r1 != r4) goto L_0x006b
            r1 = 1
            goto L_0x006c
        L_0x006b:
            r1 = 0
        L_0x006c:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0123 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0123 }
            if (r1 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzdy r1 = r8.f28406b     // Catch:{ all -> 0x0123 }
            boolean r1 = r1.mo31722j()     // Catch:{ all -> 0x0123 }
            if (r1 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzbm r1 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x0123 }
            goto L_0x0083
        L_0x0081:
            com.google.android.gms.internal.ads.zzbm r1 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x0123 }
        L_0x0083:
            java.lang.reflect.Method r4 = r8.f28410f     // Catch:{ all -> 0x0123 }
            r5 = 0
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0123 }
            android.content.Context r7 = r8.f28377j     // Catch:{ all -> 0x0123 }
            r6[r2] = r7     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzbm r7 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x0123 }
            if (r1 != r7) goto L_0x0093
            r2 = 1
        L_0x0093:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0123 }
            r6[r3] = r2     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzacu.f24145oc     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzacr r7 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x0123 }
            java.lang.Object r2 = r7.mo29599a(r2)     // Catch:{ all -> 0x0123 }
            r7 = 2
            r6[r7] = r2     // Catch:{ all -> 0x0123 }
            java.lang.Object r2 = r4.invoke(r5, r6)     // Catch:{ all -> 0x0123 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzch r4 = new com.google.android.gms.internal.ads.zzch     // Catch:{ all -> 0x0123 }
            r4.<init>(r2)     // Catch:{ all -> 0x0123 }
            java.lang.String r2 = r4.f26608b     // Catch:{ all -> 0x0123 }
            boolean r2 = com.google.android.gms.internal.ads.zzef.m30170b(r2)     // Catch:{ all -> 0x0123 }
            if (r2 != 0) goto L_0x00c4
            java.lang.String r2 = r4.f26608b     // Catch:{ all -> 0x0123 }
            java.lang.String r5 = "E"
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x0123 }
            if (r2 == 0) goto L_0x00eb
        L_0x00c4:
            int[] r2 = com.google.android.gms.internal.ads.C8840Eq.f20843a     // Catch:{ all -> 0x0123 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x0123 }
            r1 = r2[r1]     // Catch:{ all -> 0x0123 }
            if (r1 == r3) goto L_0x00de
            if (r1 == r7) goto L_0x00d1
            goto L_0x00eb
        L_0x00d1:
            java.lang.String r1 = r8.m30185c()     // Catch:{ all -> 0x0123 }
            boolean r2 = com.google.android.gms.internal.ads.zzef.m30170b(r1)     // Catch:{ all -> 0x0123 }
            if (r2 != 0) goto L_0x00eb
            r4.f26608b = r1     // Catch:{ all -> 0x0123 }
            goto L_0x00eb
        L_0x00de:
            com.google.android.gms.internal.ads.zzbk$zza r1 = r8.f28378k     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzbk$zzc r1 = r1.mo30713o()     // Catch:{ all -> 0x0123 }
            java.lang.String r1 = r1.mo30715l()     // Catch:{ all -> 0x0123 }
            r4.f26608b = r1     // Catch:{ all -> 0x0123 }
        L_0x00eb:
            r0.set(r4)     // Catch:{ all -> 0x0123 }
        L_0x00ef:
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzch r1 = (com.google.android.gms.internal.ads.zzch) r1     // Catch:{ all -> 0x0123 }
            monitor-exit(r0)     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.zzbp$zza$zza r2 = r8.f28409e
            monitor-enter(r2)
            if (r1 == 0) goto L_0x011e
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.f28409e     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = r1.f26608b     // Catch:{ all -> 0x0120 }
            r0.mo30796i(r3)     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.f28409e     // Catch:{ all -> 0x0120 }
            long r3 = r1.f26609c     // Catch:{ all -> 0x0120 }
            r0.mo30804p(r3)     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.f28409e     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = r1.f26610d     // Catch:{ all -> 0x0120 }
            r0.mo30780b(r3)     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.f28409e     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = r1.f26611e     // Catch:{ all -> 0x0120 }
            r0.mo30783c(r3)     // Catch:{ all -> 0x0120 }
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.f28409e     // Catch:{ all -> 0x0120 }
            java.lang.String r1 = r1.f26612f     // Catch:{ all -> 0x0120 }
            r0.mo30786d(r1)     // Catch:{ all -> 0x0120 }
        L_0x011e:
            monitor-exit(r2)     // Catch:{ all -> 0x0120 }
            return
        L_0x0120:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0120 }
            throw r0
        L_0x0123:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0123 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.mo31743a():void");
    }

    /* renamed from: a */
    private static String m30184a(zza zza) {
        if (zza == null || !zza.mo30712n() || zzef.m30170b(zza.mo30713o().mo30715l())) {
            return null;
        }
        return zza.mo30713o().mo30715l();
    }

    /* renamed from: c */
    private final String m30185c() {
        try {
            if (this.f28406b.mo31725m() != null) {
                this.f28406b.mo31725m().get();
            }
            zzbp.zza l = this.f28406b.mo31724l();
            if (l != null && l.mo30759m()) {
                return l.mo30758l();
            }
        } catch (InterruptedException | ExecutionException e) {
        }
        return null;
    }
}
