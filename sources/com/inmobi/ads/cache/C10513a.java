package com.inmobi.ads.cache;

import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.inmobi.ads.cache.a */
/* compiled from: AdAsset */
public class C10513a {
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final String f32044m = C10513a.class.getSimpleName();

    /* renamed from: a */
    public long f32045a = 0;

    /* renamed from: b */
    int f32046b;

    /* renamed from: c */
    int f32047c;

    /* renamed from: d */
    public String f32048d;

    /* renamed from: e */
    public String f32049e;

    /* renamed from: f */
    long f32050f;

    /* renamed from: g */
    long f32051g;

    /* renamed from: h */
    public long f32052h;

    /* renamed from: i */
    long f32053i;

    /* renamed from: j */
    public boolean f32054j;

    /* renamed from: k */
    public String f32055k;

    /* renamed from: l */
    public int f32056l;

    /* renamed from: com.inmobi.ads.cache.a$a */
    /* compiled from: AdAsset */
    public static final class C10514a {

        /* renamed from: a */
        int f32057a = (new Random().nextInt() & MoPubClientPositioning.NO_REPEAT);

        /* renamed from: b */
        int f32058b;

        /* renamed from: c */
        String f32059c;

        /* renamed from: d */
        String f32060d;

        /* renamed from: e */
        long f32061e = System.currentTimeMillis();

        /* renamed from: f */
        long f32062f = System.currentTimeMillis();

        /* renamed from: g */
        long f32063g;

        /* renamed from: h */
        long f32064h;

        /* renamed from: a */
        public final C10514a mo34238a(String str, int i, long j) {
            this.f32059c = str;
            this.f32058b = i;
            this.f32063g = System.currentTimeMillis() + j;
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0110  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0130  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0143  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.inmobi.ads.cache.C10513a.C10514a mo34239a(java.lang.String r22, java.lang.String r23, com.inmobi.commons.core.network.C10677d r24, int r25, long r26) {
            /*
                r21 = this;
                r1 = r21
                r0 = r24
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2 = r0.f32593d
                long r3 = java.lang.System.currentTimeMillis()
                java.lang.String r0 = "Date"
                java.lang.Object r5 = r2.get(r0)
                java.util.List r5 = (java.util.List) r5
                r6 = 0
                r8 = 0
                if (r5 == 0) goto L_0x0039
                int r5 = r5.size()
                if (r5 <= 0) goto L_0x0039
                java.lang.Object r0 = r2.get(r0)
                java.util.List r0 = (java.util.List) r0
                java.lang.Object r0 = r0.get(r8)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 == 0) goto L_0x0039
                long r9 = m34422a(r0)
                goto L_0x003a
            L_0x0039:
                r9 = r6
            L_0x003a:
                java.lang.String r0 = "Cache-Control"
                java.lang.Object r5 = r2.get(r0)
                java.util.List r5 = (java.util.List) r5
                if (r5 == 0) goto L_0x00c9
                int r5 = r5.size()
                if (r5 <= 0) goto L_0x00c9
                java.lang.Object r0 = r2.get(r0)
                java.util.List r0 = (java.util.List) r0
                java.lang.Object r0 = r0.get(r8)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 == 0) goto L_0x00c9
                java.lang.String r5 = ","
                java.lang.String[] r5 = r0.split(r5)
                int r12 = r5.length
                r15 = r6
                r17 = r15
                r13 = 0
                r14 = 0
            L_0x0065:
                if (r13 >= r12) goto L_0x00c7
                r0 = r5[r13]
                java.lang.String r0 = r0.trim()
                java.lang.String r11 = "no-cache"
                boolean r11 = r0.equals(r11)
                if (r11 != 0) goto L_0x00c4
                java.lang.String r11 = "no-store"
                boolean r11 = r0.equals(r11)
                if (r11 != 0) goto L_0x00c4
                java.lang.String r11 = "max-age="
                boolean r11 = r0.startsWith(r11)
                if (r11 == 0) goto L_0x0098
                r11 = 8
                java.lang.String r0 = r0.substring(r11)     // Catch:{ Exception -> 0x0090 }
                long r15 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0090 }
            L_0x008f:
                goto L_0x00c4
            L_0x0090:
                r0 = move-exception
                com.inmobi.ads.cache.C10513a.f32044m
                r0.getMessage()
                goto L_0x008f
            L_0x0098:
                java.lang.String r11 = "stale-while-revalidate="
                boolean r11 = r0.startsWith(r11)
                if (r11 == 0) goto L_0x00b3
                r11 = 23
                java.lang.String r0 = r0.substring(r11)     // Catch:{ Exception -> 0x00ab }
                long r17 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00ab }
            L_0x00aa:
                goto L_0x00c4
            L_0x00ab:
                r0 = move-exception
                com.inmobi.ads.cache.C10513a.f32044m
                r0.getMessage()
                goto L_0x00aa
            L_0x00b3:
                java.lang.String r11 = "must-revalidate"
                boolean r11 = r0.equals(r11)
                if (r11 != 0) goto L_0x00c3
                java.lang.String r11 = "proxy-revalidate"
                boolean r0 = r0.equals(r11)
                if (r0 == 0) goto L_0x00c4
            L_0x00c3:
                r14 = 1
            L_0x00c4:
                int r13 = r13 + 1
                goto L_0x0065
            L_0x00c7:
                r0 = 1
                goto L_0x00ce
            L_0x00c9:
                r15 = r6
                r17 = r15
                r0 = 0
                r14 = 0
            L_0x00ce:
                java.lang.String r5 = "Expires"
                java.lang.Object r11 = r2.get(r5)
                java.util.List r11 = (java.util.List) r11
                if (r11 == 0) goto L_0x00f1
                int r11 = r11.size()
                if (r11 <= 0) goto L_0x00f1
                java.lang.Object r5 = r2.get(r5)
                java.util.List r5 = (java.util.List) r5
                java.lang.Object r5 = r5.get(r8)
                java.lang.String r5 = (java.lang.String) r5
                if (r5 == 0) goto L_0x00f1
                long r11 = m34422a(r5)
                goto L_0x00f2
            L_0x00f1:
                r11 = r6
            L_0x00f2:
                java.lang.String r5 = "Last-Modified"
                java.lang.Object r13 = r2.get(r5)
                java.util.List r13 = (java.util.List) r13
                if (r13 == 0) goto L_0x0113
                int r13 = r13.size()
                if (r13 <= 0) goto L_0x0113
                java.lang.Object r5 = r2.get(r5)
                java.util.List r5 = (java.util.List) r5
                java.lang.Object r5 = r5.get(r8)
                java.lang.String r5 = (java.lang.String) r5
                if (r5 == 0) goto L_0x0113
                m34422a(r5)
            L_0x0113:
                java.lang.String r5 = "ETag"
                java.lang.Object r13 = r2.get(r5)
                java.util.List r13 = (java.util.List) r13
                if (r13 == 0) goto L_0x012c
                int r13 = r13.size()
                if (r13 <= 0) goto L_0x012c
                java.lang.Object r2 = r2.get(r5)
                java.util.List r2 = (java.util.List) r2
                r2.get(r8)
            L_0x012c:
                r19 = 1000(0x3e8, double:4.94E-321)
                if (r0 == 0) goto L_0x0143
                long r15 = r15 * r19
                long r6 = r3 + r15
                if (r14 == 0) goto L_0x0139
                r17 = r6
                goto L_0x0140
            L_0x0139:
                java.lang.Long.signum(r17)
                long r17 = r17 * r19
                long r17 = r6 + r17
            L_0x0140:
                r8 = r17
                goto L_0x0151
            L_0x0143:
                int r0 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x0150
                int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r0 < 0) goto L_0x0150
                long r11 = r11 - r9
                long r6 = r3 + r11
                r8 = r6
                goto L_0x0151
            L_0x0150:
                r8 = r6
            L_0x0151:
                r2 = r22
                r1.f32059c = r2
                r2 = r23
                r1.f32060d = r2
                r2 = r25
                r1.f32058b = r2
                long r10 = r26 * r19
                long r3 = r3 + r10
                r1.f32063g = r3
                r1.f32064h = r6
                long r2 = r1.f32063g
                long r2 = java.lang.Math.min(r2, r8)
                r1.f32063g = r2
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.cache.C10513a.C10514a.mo34239a(java.lang.String, java.lang.String, com.inmobi.commons.core.network.d, int, long):com.inmobi.ads.cache.a$a");
        }

        /* renamed from: a */
        private static long m34422a(String str) {
            try {
                return new SimpleDateFormat("EEE,dd MMM yyyy HH:mm:ss z", Locale.ENGLISH).parse(str).getTime();
            } catch (ParseException e) {
                C10621a.m34854a().mo34423a(new C10658a(e));
                return 0;
            }
        }

        /* renamed from: a */
        public final C10513a mo34240a() {
            C10513a aVar = new C10513a(this.f32057a, this.f32059c, this.f32060d, this.f32058b, this.f32061e, this.f32062f, this.f32063g, this.f32064h);
            return aVar;
        }
    }

    C10513a(int i, String str, String str2, int i2, long j, long j2, long j3, long j4) {
        this.f32046b = i;
        this.f32048d = str;
        this.f32049e = str2;
        this.f32047c = i2;
        this.f32050f = j;
        this.f32051g = j2;
        this.f32052h = j3;
        this.f32053i = j4;
        this.f32054j = false;
        this.f32055k = null;
    }

    /* renamed from: a */
    public final boolean mo34234a() {
        String str = this.f32049e;
        return (str == null || str.length() == 0 || !new File(this.f32049e).exists()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C10513a.class != obj.getClass()) {
            return false;
        }
        return this.f32048d.equals(((C10513a) obj).f32048d);
    }

    public int hashCode() {
        return this.f32048d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdAsset{url='");
        sb.append(this.f32048d);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
