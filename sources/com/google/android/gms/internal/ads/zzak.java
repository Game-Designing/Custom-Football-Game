package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class zzak implements zzm {

    /* renamed from: a */
    private static final boolean f24380a = zzag.f24300b;
    @Deprecated

    /* renamed from: b */
    private final zzas f24381b;

    /* renamed from: c */
    private final zzaj f24382c;

    /* renamed from: d */
    private final zzal f24383d;

    @Deprecated
    public zzak(zzas zzas) {
        this(zzas, new zzal(Opcodes.ACC_SYNTHETIC));
    }

    @Deprecated
    private zzak(zzas zzas, zzal zzal) {
        this.f24381b = zzas;
        this.f24382c = new C9033O(zzas);
        this.f24383d = zzal;
    }

    public zzak(zzaj zzaj) {
        this(zzaj, new zzal(Opcodes.ACC_SYNTHETIC));
    }

    private zzak(zzaj zzaj, zzal zzal) {
        this.f24382c = zzaj;
        this.f24381b = zzaj;
        this.f24383d = zzal;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f4, code lost:
        throw new com.google.android.gms.internal.ads.zzad(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f5, code lost:
        m25158a("auth", r2, new com.google.android.gms.internal.ads.zza(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0201, code lost:
        m25158a("network", r2, new com.google.android.gms.internal.ads.zzo());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0212, code lost:
        throw new com.google.android.gms.internal.ads.zzq(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0213, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0214, code lost:
        r4 = "Bad URL ";
        r2 = java.lang.String.valueOf(r22.mo32131g());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0224, code lost:
        if (r2.length() != 0) goto L_0x0226;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0226, code lost:
        r2 = r4.concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x022b, code lost:
        r2 = new java.lang.String(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0233, code lost:
        throw new java.lang.RuntimeException(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0235, code lost:
        m25158a("socket", r2, new com.google.android.gms.internal.ads.zzae());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0197, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0198, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x019b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x019c, code lost:
        r17 = r5;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x019f, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a2, code lost:
        r0 = r10.mo30010c();
        com.google.android.gms.internal.ads.zzag.m24968b("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r22.mo32131g());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b9, code lost:
        if (r13 != null) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01bb, code lost:
        r11 = new com.google.android.gms.internal.ads.zzp(r0, r13, false, android.os.SystemClock.elapsedRealtime() - r3, r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01cb, code lost:
        if (r0 == 401) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01d4, code lost:
        if (r0 < 400) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01e0, code lost:
        throw new com.google.android.gms.internal.ads.zzg(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01e3, code lost:
        if (r0 < 500) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ee, code lost:
        throw new com.google.android.gms.internal.ads.zzad(r11);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0213 A[ExcHandler: MalformedURLException (r0v2 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0234 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:2:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x020d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01a2  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzp mo29752a(com.google.android.gms.internal.ads.zzr<?> r22) throws com.google.android.gms.internal.ads.zzaf {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            long r3 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.List r5 = java.util.Collections.emptyList()
            r6 = 1
            r7 = 2
            r9 = 0
            com.google.android.gms.internal.ads.zzc r0 = r22.mo32135t()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            if (r0 != 0) goto L_0x001d
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            goto L_0x0041
        L_0x001d:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            r10.<init>()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            java.lang.String r11 = r0.f26225b     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            if (r11 == 0) goto L_0x002d
            java.lang.String r11 = "If-None-Match"
            java.lang.String r12 = r0.f26225b     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            r10.put(r11, r12)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
        L_0x002d:
            long r11 = r0.f26227d     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            r13 = 0
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x0040
            java.lang.String r11 = "If-Modified-Since"
            long r12 = r0.f26227d     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaq.m25653a(r12)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            r10.put(r11, r0)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
        L_0x0040:
            r0 = r10
        L_0x0041:
            com.google.android.gms.internal.ads.zzaj r10 = r1.f24382c     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            com.google.android.gms.internal.ads.zzar r10 = r10.mo28471b(r2, r0)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x019b }
            int r12 = r10.mo30010c()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.util.List r5 = r10.mo30011d()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r0 = 304(0x130, float:4.26E-43)
            if (r12 != r0) goto L_0x011e
            com.google.android.gms.internal.ads.zzc r0 = r22.mo32135t()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r0 != 0) goto L_0x006e
            com.google.android.gms.internal.ads.zzp r0 = new com.google.android.gms.internal.ads.zzp     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r14 = 304(0x130, float:4.26E-43)
            r15 = 0
            r16 = 1
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            long r17 = r11 - r3
            r13 = r0
            r19 = r5
            r13.<init>(r14, r15, r16, r17, r19)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            return r0
        L_0x006e:
            java.util.TreeSet r11 = new java.util.TreeSet     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.util.Comparator r12 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r11.<init>(r12)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            boolean r12 = r5.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r12 != 0) goto L_0x0094
            java.util.Iterator r12 = r5.iterator()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
        L_0x0080:
            boolean r13 = r12.hasNext()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r13 == 0) goto L_0x0094
            java.lang.Object r13 = r12.next()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            com.google.android.gms.internal.ads.zzl r13 = (com.google.android.gms.internal.ads.zzl) r13     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.lang.String r13 = r13.mo31933a()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r11.add(r13)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            goto L_0x0080
        L_0x0094:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r12.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.util.List<com.google.android.gms.internal.ads.zzl> r13 = r0.f26231h     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r13 == 0) goto L_0x00c6
            java.util.List<com.google.android.gms.internal.ads.zzl> r13 = r0.f26231h     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            boolean r13 = r13.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r13 != 0) goto L_0x0105
            java.util.List<com.google.android.gms.internal.ads.zzl> r13 = r0.f26231h     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
        L_0x00ab:
            boolean r14 = r13.hasNext()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r14 == 0) goto L_0x00c5
            java.lang.Object r14 = r13.next()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            com.google.android.gms.internal.ads.zzl r14 = (com.google.android.gms.internal.ads.zzl) r14     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.lang.String r15 = r14.mo31933a()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            boolean r15 = r11.contains(r15)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r15 != 0) goto L_0x00c4
            r12.add(r14)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
        L_0x00c4:
            goto L_0x00ab
        L_0x00c5:
            goto L_0x0105
        L_0x00c6:
            java.util.Map<java.lang.String, java.lang.String> r13 = r0.f26230g     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            boolean r13 = r13.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r13 != 0) goto L_0x0105
            java.util.Map<java.lang.String, java.lang.String> r13 = r0.f26230g     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.util.Set r13 = r13.entrySet()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
        L_0x00d8:
            boolean r14 = r13.hasNext()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r14 == 0) goto L_0x0105
            java.lang.Object r14 = r13.next()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.lang.Object r15 = r14.getKey()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            boolean r15 = r11.contains(r15)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r15 != 0) goto L_0x0104
            com.google.android.gms.internal.ads.zzl r15 = new com.google.android.gms.internal.ads.zzl     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.lang.Object r16 = r14.getKey()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r8 = r16
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.lang.Object r14 = r14.getValue()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r15.<init>(r8, r14)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r12.add(r15)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
        L_0x0104:
            goto L_0x00d8
        L_0x0105:
            com.google.android.gms.internal.ads.zzp r8 = new com.google.android.gms.internal.ads.zzp     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r15 = 304(0x130, float:4.26E-43)
            byte[] r0 = r0.f26224a     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r17 = 1
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            long r18 = r13 - r3
            r14 = r8
            r16 = r0
            r20 = r12
            r14.<init>(r15, r16, r17, r18, r20)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            return r8
        L_0x011e:
            java.io.InputStream r0 = r10.mo30008a()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            if (r0 == 0) goto L_0x012f
            int r8 = r10.mo30009b()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            byte[] r0 = r1.m25159a(r0, r8)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r8 = r0
            goto L_0x0132
        L_0x012f:
            byte[] r0 = new byte[r9]     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0197 }
            r8 = r0
        L_0x0132:
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            long r13 = r13 - r3
            boolean r0 = f24380a     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            if (r0 != 0) goto L_0x0142
            r15 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x0174
        L_0x0142:
            java.lang.String r0 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r11 = 5
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            r11[r9] = r2     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            r11[r6] = r13     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            if (r8 == 0) goto L_0x0157
            int r13 = r8.length     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            goto L_0x0159
        L_0x0157:
            java.lang.String r13 = "null"
        L_0x0159:
            r11[r7] = r13     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            r13 = 3
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            r11[r13] = r14     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            r13 = 4
            com.google.android.gms.internal.ads.zzac r14 = r22.mo32139x()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            int r14 = r14.mo29578h()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            r11[r13] = r14     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            com.google.android.gms.internal.ads.zzag.m24966a(r0, r11)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
        L_0x0174:
            r0 = 200(0xc8, float:2.8E-43)
            if (r12 < r0) goto L_0x018c
            r0 = 299(0x12b, float:4.19E-43)
            if (r12 > r0) goto L_0x018c
            com.google.android.gms.internal.ads.zzp r0 = new com.google.android.gms.internal.ads.zzp     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            r14 = 0
            long r15 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            long r15 = r15 - r3
            r11 = r0
            r13 = r8
            r17 = r5
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            return r0
        L_0x018c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
            throw r0     // Catch:{ SocketTimeoutException -> 0x0234, MalformedURLException -> 0x0213, IOException -> 0x0192 }
        L_0x0192:
            r0 = move-exception
            r17 = r5
            r13 = r8
            goto L_0x01a0
        L_0x0197:
            r0 = move-exception
            r17 = r5
            goto L_0x019f
        L_0x019b:
            r0 = move-exception
            r17 = r5
            r10 = 0
        L_0x019f:
            r13 = 0
        L_0x01a0:
            if (r10 == 0) goto L_0x020d
            int r0 = r10.mo30010c()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            r5[r9] = r7
            java.lang.String r7 = r22.mo32131g()
            r5[r6] = r7
            java.lang.String r6 = "Unexpected response code %d for %s"
            com.google.android.gms.internal.ads.zzag.m24968b(r6, r5)
            if (r13 == 0) goto L_0x0201
            com.google.android.gms.internal.ads.zzp r5 = new com.google.android.gms.internal.ads.zzp
            r14 = 0
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r15 = r6 - r3
            r11 = r5
            r12 = r0
            r11.<init>(r12, r13, r14, r15, r17)
            r6 = 401(0x191, float:5.62E-43)
            if (r0 == r6) goto L_0x01f5
            r6 = 403(0x193, float:5.65E-43)
            if (r0 != r6) goto L_0x01d2
            goto L_0x01f5
        L_0x01d2:
            r2 = 400(0x190, float:5.6E-43)
            if (r0 < r2) goto L_0x01e1
            r2 = 499(0x1f3, float:6.99E-43)
            if (r0 <= r2) goto L_0x01db
            goto L_0x01e1
        L_0x01db:
            com.google.android.gms.internal.ads.zzg r0 = new com.google.android.gms.internal.ads.zzg
            r0.<init>(r5)
            throw r0
        L_0x01e1:
            r2 = 500(0x1f4, float:7.0E-43)
            if (r0 < r2) goto L_0x01ef
            r2 = 599(0x257, float:8.4E-43)
            if (r0 > r2) goto L_0x01ef
            com.google.android.gms.internal.ads.zzad r0 = new com.google.android.gms.internal.ads.zzad
            r0.<init>(r5)
            throw r0
        L_0x01ef:
            com.google.android.gms.internal.ads.zzad r0 = new com.google.android.gms.internal.ads.zzad
            r0.<init>(r5)
            throw r0
        L_0x01f5:
            com.google.android.gms.internal.ads.zza r0 = new com.google.android.gms.internal.ads.zza
            r0.<init>(r5)
            java.lang.String r5 = "auth"
            m25158a(r5, r2, r0)
            goto L_0x0008
        L_0x0201:
            com.google.android.gms.internal.ads.zzo r0 = new com.google.android.gms.internal.ads.zzo
            r0.<init>()
            java.lang.String r5 = "network"
            m25158a(r5, r2, r0)
            goto L_0x0008
        L_0x020d:
            com.google.android.gms.internal.ads.zzq r2 = new com.google.android.gms.internal.ads.zzq
            r2.<init>(r0)
            throw r2
        L_0x0213:
            r0 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r4 = "Bad URL "
            java.lang.String r2 = r22.mo32131g()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r5 = r2.length()
            if (r5 == 0) goto L_0x022b
            java.lang.String r2 = r4.concat(r2)
            goto L_0x0230
        L_0x022b:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r4)
        L_0x0230:
            r3.<init>(r2, r0)
            throw r3
        L_0x0234:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzae r0 = new com.google.android.gms.internal.ads.zzae
            r0.<init>()
            java.lang.String r5 = "socket"
            m25158a(r5, r2, r0)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzak.mo29752a(com.google.android.gms.internal.ads.zzr):com.google.android.gms.internal.ads.zzp");
    }

    /* renamed from: a */
    private static void m25158a(String str, zzr<?> zzr, zzaf zzaf) throws zzaf {
        zzac x = zzr.mo32139x();
        int w = zzr.mo32138w();
        try {
            x.mo29577a(zzaf);
            zzr.mo32126a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(w)}));
        } catch (zzaf e) {
            zzr.mo32126a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(w)}));
            throw e;
        }
    }

    /* renamed from: a */
    private final byte[] m25159a(InputStream inputStream, int i) throws IOException, zzad {
        zzaw zzaw = new zzaw(this.f24383d, i);
        String str = "Error occurred when closing InputStream";
        byte[] bArr = null;
        if (inputStream != null) {
            try {
                bArr = this.f24383d.mo29800a((int) Opcodes.ACC_ABSTRACT);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zzaw.write(bArr, 0, read);
                }
                byte[] byteArray = zzaw.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        zzag.m24969c(str, new Object[0]);
                    }
                }
                return byteArray;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        zzag.m24969c(str, new Object[0]);
                    }
                }
                this.f24383d.mo29799a(bArr);
                zzaw.close();
            }
        } else {
            throw new zzad();
        }
    }
}
