package com.facebook;

import com.facebook.AccessToken.C6535a;
import com.facebook.C6814y.C6815a;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.f */
/* compiled from: AccessTokenManager */
class C6662f implements C6815a {

    /* renamed from: a */
    final /* synthetic */ AccessToken f12133a;

    /* renamed from: b */
    final /* synthetic */ C6535a f12134b;

    /* renamed from: c */
    final /* synthetic */ AtomicBoolean f12135c;

    /* renamed from: d */
    final /* synthetic */ C6664a f12136d;

    /* renamed from: e */
    final /* synthetic */ Set f12137e;

    /* renamed from: f */
    final /* synthetic */ Set f12138f;

    /* renamed from: g */
    final /* synthetic */ Set f12139g;

    /* renamed from: h */
    final /* synthetic */ C6663g f12140h;

    C6662f(C6663g this$0, AccessToken accessToken, C6535a aVar, AtomicBoolean atomicBoolean, C6664a aVar2, Set set, Set set2, Set set3) {
        this.f12140h = this$0;
        this.f12133a = accessToken;
        this.f12134b = aVar;
        this.f12135c = atomicBoolean;
        this.f12136d = aVar2;
        this.f12137e = set;
        this.f12138f = set2;
        this.f12139g = set3;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x005b=Splitter:B:21:0x005b, B:51:0x011b=Splitter:B:51:0x011b} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19866a(com.facebook.C6814y r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = 0
            r3 = 0
            com.facebook.g r0 = com.facebook.C6663g.m13290d()     // Catch:{ all -> 0x013f }
            com.facebook.AccessToken r0 = r0.mo19871c()     // Catch:{ all -> 0x013f }
            if (r0 == 0) goto L_0x011b
            com.facebook.g r0 = com.facebook.C6663g.m13290d()     // Catch:{ all -> 0x013f }
            com.facebook.AccessToken r0 = r0.mo19871c()     // Catch:{ all -> 0x013f }
            java.lang.String r0 = r0.mo19632l()     // Catch:{ all -> 0x013f }
            com.facebook.AccessToken r4 = r1.f12133a     // Catch:{ all -> 0x013f }
            java.lang.String r4 = r4.mo19632l()     // Catch:{ all -> 0x013f }
            if (r0 == r4) goto L_0x0024
            goto L_0x011b
        L_0x0024:
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f12135c     // Catch:{ all -> 0x013f }
            boolean r0 = r0.get()     // Catch:{ all -> 0x013f }
            if (r0 != 0) goto L_0x005b
            com.facebook.g$a r0 = r1.f12136d     // Catch:{ all -> 0x013f }
            java.lang.String r0 = r0.f12147a     // Catch:{ all -> 0x013f }
            if (r0 != 0) goto L_0x005b
            com.facebook.g$a r0 = r1.f12136d     // Catch:{ all -> 0x013f }
            int r0 = r0.f12148b     // Catch:{ all -> 0x013f }
            if (r0 != 0) goto L_0x005b
            com.facebook.AccessToken$a r0 = r1.f12134b     // Catch:{ all -> 0x013f }
            if (r0 == 0) goto L_0x0048
            com.facebook.AccessToken$a r0 = r1.f12134b     // Catch:{ all -> 0x013f }
            com.facebook.FacebookException r4 = new com.facebook.FacebookException     // Catch:{ all -> 0x013f }
            java.lang.String r5 = "Failed to refresh access token"
            r4.<init>(r5)     // Catch:{ all -> 0x013f }
            r0.mo19638a(r4)     // Catch:{ all -> 0x013f }
        L_0x0048:
            com.facebook.g r0 = r1.f12140h
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f12145e
            r0.set(r3)
            com.facebook.AccessToken$a r0 = r1.f12134b
            if (r0 == 0) goto L_0x005a
            if (r2 == 0) goto L_0x005a
            r0.mo19637a(r2)
        L_0x005a:
            return
        L_0x005b:
            com.facebook.AccessToken r0 = new com.facebook.AccessToken     // Catch:{ all -> 0x013f }
            com.facebook.g$a r4 = r1.f12136d     // Catch:{ all -> 0x013f }
            java.lang.String r4 = r4.f12147a     // Catch:{ all -> 0x013f }
            if (r4 == 0) goto L_0x0069
            com.facebook.g$a r4 = r1.f12136d     // Catch:{ all -> 0x013f }
            java.lang.String r4 = r4.f12147a     // Catch:{ all -> 0x013f }
            r5 = r4
            goto L_0x0070
        L_0x0069:
            com.facebook.AccessToken r4 = r1.f12133a     // Catch:{ all -> 0x013f }
            java.lang.String r4 = r4.mo19631k()     // Catch:{ all -> 0x013f }
            r5 = r4
        L_0x0070:
            com.facebook.AccessToken r4 = r1.f12133a     // Catch:{ all -> 0x013f }
            java.lang.String r6 = r4.mo19620b()     // Catch:{ all -> 0x013f }
            com.facebook.AccessToken r4 = r1.f12133a     // Catch:{ all -> 0x013f }
            java.lang.String r7 = r4.mo19632l()     // Catch:{ all -> 0x013f }
            java.util.concurrent.atomic.AtomicBoolean r4 = r1.f12135c     // Catch:{ all -> 0x013f }
            boolean r4 = r4.get()     // Catch:{ all -> 0x013f }
            if (r4 == 0) goto L_0x0088
            java.util.Set r4 = r1.f12137e     // Catch:{ all -> 0x013f }
            r8 = r4
            goto L_0x008f
        L_0x0088:
            com.facebook.AccessToken r4 = r1.f12133a     // Catch:{ all -> 0x013f }
            java.util.Set r4 = r4.mo19629i()     // Catch:{ all -> 0x013f }
            r8 = r4
        L_0x008f:
            java.util.concurrent.atomic.AtomicBoolean r4 = r1.f12135c     // Catch:{ all -> 0x013f }
            boolean r4 = r4.get()     // Catch:{ all -> 0x013f }
            if (r4 == 0) goto L_0x009b
            java.util.Set r4 = r1.f12138f     // Catch:{ all -> 0x013f }
            r9 = r4
            goto L_0x00a2
        L_0x009b:
            com.facebook.AccessToken r4 = r1.f12133a     // Catch:{ all -> 0x013f }
            java.util.Set r4 = r4.mo19623e()     // Catch:{ all -> 0x013f }
            r9 = r4
        L_0x00a2:
            java.util.concurrent.atomic.AtomicBoolean r4 = r1.f12135c     // Catch:{ all -> 0x013f }
            boolean r4 = r4.get()     // Catch:{ all -> 0x013f }
            if (r4 == 0) goto L_0x00ae
            java.util.Set r4 = r1.f12139g     // Catch:{ all -> 0x013f }
            r10 = r4
            goto L_0x00b5
        L_0x00ae:
            com.facebook.AccessToken r4 = r1.f12133a     // Catch:{ all -> 0x013f }
            java.util.Set r4 = r4.mo19625f()     // Catch:{ all -> 0x013f }
            r10 = r4
        L_0x00b5:
            com.facebook.AccessToken r4 = r1.f12133a     // Catch:{ all -> 0x013f }
            com.facebook.h r11 = r4.mo19630j()     // Catch:{ all -> 0x013f }
            com.facebook.g$a r4 = r1.f12136d     // Catch:{ all -> 0x013f }
            int r4 = r4.f12148b     // Catch:{ all -> 0x013f }
            r12 = 1000(0x3e8, double:4.94E-321)
            if (r4 == 0) goto L_0x00d1
            java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x013f }
            com.facebook.g$a r14 = r1.f12136d     // Catch:{ all -> 0x013f }
            int r14 = r14.f12148b     // Catch:{ all -> 0x013f }
            long r14 = (long) r14     // Catch:{ all -> 0x013f }
            long r14 = r14 * r12
            r4.<init>(r14)     // Catch:{ all -> 0x013f }
            r14 = r4
            goto L_0x00d8
        L_0x00d1:
            com.facebook.AccessToken r4 = r1.f12133a     // Catch:{ all -> 0x013f }
            java.util.Date r4 = r4.mo19626g()     // Catch:{ all -> 0x013f }
            r14 = r4
        L_0x00d8:
            java.util.Date r15 = new java.util.Date     // Catch:{ all -> 0x013f }
            r15.<init>()     // Catch:{ all -> 0x013f }
            com.facebook.g$a r4 = r1.f12136d     // Catch:{ all -> 0x013f }
            java.lang.Long r4 = r4.f12149c     // Catch:{ all -> 0x013f }
            if (r4 == 0) goto L_0x00f4
            java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x013f }
            com.facebook.g$a r3 = r1.f12136d     // Catch:{ all -> 0x013f }
            java.lang.Long r3 = r3.f12149c     // Catch:{ all -> 0x013f }
            long r16 = r3.longValue()     // Catch:{ all -> 0x013f }
            long r12 = r12 * r16
            r4.<init>(r12)     // Catch:{ all -> 0x013f }
            r3 = r4
            goto L_0x00fa
        L_0x00f4:
            com.facebook.AccessToken r3 = r1.f12133a     // Catch:{ all -> 0x013f }
            java.util.Date r3 = r3.mo19621d()     // Catch:{ all -> 0x013f }
        L_0x00fa:
            r4 = r0
            r12 = r14
            r13 = r15
            r14 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x013f }
            r2 = r0
            com.facebook.g r0 = com.facebook.C6663g.m13290d()     // Catch:{ all -> 0x013f }
            r0.mo19869a(r2)     // Catch:{ all -> 0x013f }
            com.facebook.g r0 = r1.f12140h
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f12145e
            r3 = 0
            r0.set(r3)
            com.facebook.AccessToken$a r0 = r1.f12134b
            if (r0 == 0) goto L_0x011a
            r0.mo19637a(r2)
        L_0x011a:
            return
        L_0x011b:
            com.facebook.AccessToken$a r0 = r1.f12134b     // Catch:{ all -> 0x013f }
            if (r0 == 0) goto L_0x012b
            com.facebook.AccessToken$a r0 = r1.f12134b     // Catch:{ all -> 0x013f }
            com.facebook.FacebookException r3 = new com.facebook.FacebookException     // Catch:{ all -> 0x013f }
            java.lang.String r4 = "No current access token to refresh"
            r3.<init>(r4)     // Catch:{ all -> 0x013f }
            r0.mo19638a(r3)     // Catch:{ all -> 0x013f }
        L_0x012b:
            com.facebook.g r0 = r1.f12140h
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f12145e
            r3 = 0
            r0.set(r3)
            com.facebook.AccessToken$a r0 = r1.f12134b
            if (r0 == 0) goto L_0x013e
            if (r2 == 0) goto L_0x013e
            r0.mo19637a(r2)
        L_0x013e:
            return
        L_0x013f:
            r0 = move-exception
            com.facebook.g r3 = r1.f12140h
            java.util.concurrent.atomic.AtomicBoolean r3 = r3.f12145e
            r4 = 0
            r3.set(r4)
            com.facebook.AccessToken$a r3 = r1.f12134b
            if (r3 == 0) goto L_0x0153
            if (r2 == 0) goto L_0x0153
            r3.mo19637a(r2)
        L_0x0153:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.C6662f.mo19866a(com.facebook.y):void");
    }
}
