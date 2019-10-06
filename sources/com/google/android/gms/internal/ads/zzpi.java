package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.file.CacheHelper;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class zzpi {

    /* renamed from: a */
    private static final zzpd f29130a = zzpd.m30871b("OMX.google.raw.decoder");

    /* renamed from: b */
    private static final Pattern f29131b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c */
    private static final HashMap<C9881a, List<zzpd>> f29132c = new HashMap<>();

    /* renamed from: d */
    private static final SparseIntArray f29133d;

    /* renamed from: e */
    private static final SparseIntArray f29134e;

    /* renamed from: f */
    private static final Map<String, Integer> f29135f;

    /* renamed from: g */
    private static int f29136g = -1;

    /* renamed from: com.google.android.gms.internal.ads.zzpi$a */
    static final class C9881a {

        /* renamed from: a */
        public final String f29137a;

        /* renamed from: b */
        public final boolean f29138b;

        public C9881a(String str, boolean z) {
            this.f29137a = str;
            this.f29138b = z;
        }

        public final int hashCode() {
            String str = this.f29137a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f29138b ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != C9881a.class) {
                return false;
            }
            C9881a aVar = (C9881a) obj;
            if (!TextUtils.equals(this.f29137a, aVar.f29137a) || this.f29138b != aVar.f29138b) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: a */
    public static zzpd m30911a() {
        return f29130a;
    }

    /* renamed from: a */
    public static zzpd m30912a(String str, boolean z) throws zzpk {
        List b = m30915b(str, z);
        if (b.isEmpty()) {
            return null;
        }
        return (zzpd) b.get(0);
    }

    /* renamed from: b */
    private static synchronized List<zzpd> m30915b(String str, boolean z) throws zzpk {
        synchronized (zzpi.class) {
            C9881a aVar = new C9881a(str, z);
            List<zzpd> list = (List) f29132c.get(aVar);
            if (list != null) {
                return list;
            }
            List a = m30913a(aVar, zzsy.f29345a >= 21 ? new C8779Bs(z) : new C8758As());
            if (z && a.isEmpty() && 21 <= zzsy.f29345a && zzsy.f29345a <= 23) {
                a = m30913a(aVar, (C9867zs) new C8758As());
                if (!a.isEmpty()) {
                    String str2 = ((zzpd) a.get(0)).f29080a;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzpd> unmodifiableList = Collections.unmodifiableList(a);
            f29132c.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    /* renamed from: b */
    public static int m30914b() throws zzpk {
        int i;
        if (f29136g == -1) {
            int i2 = 0;
            zzpd a = m30912a("video/avc", false);
            if (a != null) {
                CodecProfileLevel[] a2 = a.mo32077a();
                int length = a2.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = a2[i2].level;
                    if (i4 == 1) {
                        i = 25344;
                    } else if (i4 != 2) {
                        switch (i4) {
                            case 8:
                                i = 101376;
                                break;
                            case 16:
                                i = 101376;
                                break;
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                                i = 414720;
                                break;
                            case Opcodes.ACC_NATIVE /*256*/:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case Opcodes.ACC_ABSTRACT /*1024*/:
                                i = 1310720;
                                break;
                            case Opcodes.ACC_STRICT /*2048*/:
                                i = 2097152;
                                break;
                            case Opcodes.ACC_SYNTHETIC /*4096*/:
                                i = 2097152;
                                break;
                            case Opcodes.ACC_ANNOTATION /*8192*/:
                                i = 2228224;
                                break;
                            case Opcodes.ACC_ENUM /*16384*/:
                                i = 5652480;
                                break;
                            case Opcodes.ACC_MANDATED /*32768*/:
                                i = 9437184;
                                break;
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzsy.f29345a >= 21 ? 345600 : 172800);
            }
            f29136g = i2;
        }
        return f29136g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r3.equals("hev1") != false) goto L_0x0041;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> m30909a(java.lang.String r9) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r9.split(r1)
            r2 = 0
            r3 = r1[r2]
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r5) {
                case 3006243: goto L_0x0036;
                case 3006244: goto L_0x002c;
                case 3199032: goto L_0x0023;
                case 3214780: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0040
        L_0x0019:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 1
            goto L_0x0041
        L_0x0023:
            java.lang.String r5 = "hev1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0018
            goto L_0x0041
        L_0x002c:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 3
            goto L_0x0041
        L_0x0036:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 2
            goto L_0x0041
        L_0x0040:
            r2 = -1
        L_0x0041:
            if (r2 == 0) goto L_0x004f
            if (r2 == r8) goto L_0x004f
            if (r2 == r7) goto L_0x004a
            if (r2 == r6) goto L_0x004a
            return r0
        L_0x004a:
            android.util.Pair r9 = m30910a(r9, r1)
            return r9
        L_0x004f:
            int r2 = r1.length
            r3 = 4
            java.lang.String r4 = "Ignoring malformed HEVC codec string: "
            java.lang.String r5 = "MediaCodecUtil"
            if (r2 >= r3) goto L_0x0070
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r1 = r9.length()
            if (r1 == 0) goto L_0x0067
            java.lang.String r9 = r4.concat(r9)
            goto L_0x006c
        L_0x0067:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r4)
        L_0x006c:
            android.util.Log.w(r5, r9)
            return r0
        L_0x0070:
            java.util.regex.Pattern r2 = f29131b
            r3 = r1[r8]
            java.util.regex.Matcher r2 = r2.matcher(r3)
            boolean r3 = r2.matches()
            if (r3 != 0) goto L_0x0096
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r1 = r9.length()
            if (r1 == 0) goto L_0x008d
            java.lang.String r9 = r4.concat(r9)
            goto L_0x0092
        L_0x008d:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r4)
        L_0x0092:
            android.util.Log.w(r5, r9)
            return r0
        L_0x0096:
            java.lang.String r9 = r2.group(r8)
            java.lang.String r3 = "1"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x00a4
            r7 = 1
            goto L_0x00ad
        L_0x00a4:
            java.lang.String r3 = "2"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x00e2
        L_0x00ad:
            java.util.Map<java.lang.String, java.lang.Integer> r9 = f29135f
            r1 = r1[r6]
            java.lang.Object r9 = r9.get(r1)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 != 0) goto L_0x00d8
            java.lang.String r9 = "Unknown HEVC level string: "
            java.lang.String r1 = r2.group(r8)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x00ce
            java.lang.String r9 = r9.concat(r1)
            goto L_0x00d4
        L_0x00ce:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r9)
            r9 = r1
        L_0x00d4:
            android.util.Log.w(r5, r9)
            return r0
        L_0x00d8:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0.<init>(r1, r9)
            return r0
        L_0x00e2:
            java.lang.String r1 = "Unknown HEVC profile string: "
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r2 = r9.length()
            if (r2 == 0) goto L_0x00f3
            java.lang.String r9 = r1.concat(r9)
            goto L_0x00f8
        L_0x00f3:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r1)
        L_0x00f8:
            android.util.Log.w(r5, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpi.m30909a(java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01ba A[Catch:{ Exception -> 0x02b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0241 A[SYNTHETIC, Splitter:B:156:0x0241] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x026b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02af A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.android.gms.internal.ads.zzpd> m30913a(com.google.android.gms.internal.ads.zzpi.C9881a r17, com.google.android.gms.internal.ads.C9867zs r18) throws com.google.android.gms.internal.ads.zzpk {
        /*
            r1 = r17
            r2 = r18
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x02b8 }
            r3.<init>()     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r4 = r1.f29137a     // Catch:{ Exception -> 0x02b8 }
            int r5 = r18.mo28051a()     // Catch:{ Exception -> 0x02b8 }
            boolean r6 = r18.mo28054b()     // Catch:{ Exception -> 0x02b8 }
            r8 = 0
        L_0x0014:
            if (r8 >= r5) goto L_0x02b7
            android.media.MediaCodecInfo r9 = r2.mo28052a(r8)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r10 = r9.getName()     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r9.isEncoder()     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r11 = ".secure"
            if (r0 != 0) goto L_0x01b7
            if (r6 != 0) goto L_0x0031
            boolean r0 = r10.endsWith(r11)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x0031
            goto L_0x01b7
        L_0x0031:
            int r0 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ Exception -> 0x02b8 }
            r13 = 21
            if (r0 >= r13) goto L_0x006a
            java.lang.String r0 = "CIPAACDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x0067
            java.lang.String r0 = "CIPMP3Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x0067
            java.lang.String r0 = "CIPVorbisDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x0067
            java.lang.String r0 = "CIPAMRNBDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x0067
            java.lang.String r0 = "AACDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x0067
            java.lang.String r0 = "MP3Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x006a
        L_0x0067:
            r0 = 0
            goto L_0x01b8
        L_0x006a:
            int r0 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ Exception -> 0x02b8 }
            r13 = 18
            if (r0 >= r13) goto L_0x007b
            java.lang.String r0 = "OMX.SEC.MP3.Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x007b
            r0 = 0
            goto L_0x01b8
        L_0x007b:
            int r0 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ Exception -> 0x02b8 }
            if (r0 >= r13) goto L_0x0094
            java.lang.String r0 = "OMX.MTK.AUDIO.DECODER.AAC"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x0094
            java.lang.String r0 = "a70"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x0094
            r0 = 0
            goto L_0x01b8
        L_0x0094:
            int r0 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ Exception -> 0x02b8 }
            r13 = 16
            if (r0 != r13) goto L_0x011d
            java.lang.String r0 = "OMX.qcom.audio.decoder.mp3"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x011d
            java.lang.String r0 = "dlxu"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "protou"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "ville"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "villeplus"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "villec2"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r14 = "gee"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "C6602"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "C6603"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "C6606"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "C6616"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "L36h"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "SO-02E"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x011d
        L_0x011a:
            r0 = 0
            goto L_0x01b8
        L_0x011d:
            int r0 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ Exception -> 0x02b8 }
            if (r0 != r13) goto L_0x0153
            java.lang.String r0 = "OMX.qcom.audio.decoder.aac"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x0153
            java.lang.String r0 = "C1504"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x0151
            java.lang.String r0 = "C1505"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x0151
            java.lang.String r0 = "C1604"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x0151
            java.lang.String r0 = "C1605"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x0153
        L_0x0151:
            r0 = 0
            goto L_0x01b8
        L_0x0153:
            int r0 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r13 = "jflte"
            r14 = 19
            if (r0 > r14) goto L_0x019f
            java.lang.String r0 = "OMX.SEC.vp8.dec"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x019f
            java.lang.String r0 = "samsung"
            java.lang.String r15 = com.google.android.gms.internal.ads.zzsy.f29347c     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.equals(r15)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x019f
            java.lang.String r0 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r15 = "d2"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x019d
            java.lang.String r0 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r15 = "serrano"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x019d
            java.lang.String r0 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.startsWith(r13)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x019d
            java.lang.String r0 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r15 = "santos"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x02b8 }
            if (r0 != 0) goto L_0x019d
            java.lang.String r0 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r15 = "t0"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x019f
        L_0x019d:
            r0 = 0
            goto L_0x01b8
        L_0x019f:
            int r0 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ Exception -> 0x02b8 }
            if (r0 > r14) goto L_0x01b5
            java.lang.String r0 = com.google.android.gms.internal.ads.zzsy.f29346b     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r0.startsWith(r13)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x01b5
            java.lang.String r0 = "OMX.qcom.video.decoder.vp8"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x01b5
            r0 = 0
            goto L_0x01b8
        L_0x01b5:
            r0 = 1
            goto L_0x01b8
        L_0x01b7:
            r0 = 0
        L_0x01b8:
            if (r0 == 0) goto L_0x02ad
            java.lang.String[] r13 = r9.getSupportedTypes()     // Catch:{ Exception -> 0x02b8 }
            int r14 = r13.length     // Catch:{ Exception -> 0x02b8 }
            r15 = 0
        L_0x01c0:
            if (r15 >= r14) goto L_0x02aa
            r12 = r13[r15]     // Catch:{ Exception -> 0x02b8 }
            boolean r0 = r12.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x02b8 }
            if (r0 == 0) goto L_0x02a0
            android.media.MediaCodecInfo$CodecCapabilities r0 = r9.getCapabilitiesForType(r12)     // Catch:{ Exception -> 0x0235 }
            boolean r7 = r2.mo28053a(r4, r0)     // Catch:{ Exception -> 0x0235 }
            int r2 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ Exception -> 0x0235 }
            r16 = r5
            r5 = 22
            if (r2 > r5) goto L_0x0203
            java.lang.String r2 = com.google.android.gms.internal.ads.zzsy.f29348d     // Catch:{ Exception -> 0x0201 }
            java.lang.String r5 = "ODROID-XU3"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0201 }
            if (r2 != 0) goto L_0x01ef
            java.lang.String r2 = com.google.android.gms.internal.ads.zzsy.f29348d     // Catch:{ Exception -> 0x0201 }
            java.lang.String r5 = "Nexus 10"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0201 }
            if (r2 == 0) goto L_0x0203
        L_0x01ef:
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x0201 }
            if (r2 != 0) goto L_0x01ff
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x0201 }
            if (r2 == 0) goto L_0x0203
        L_0x01ff:
            r2 = 1
            goto L_0x0204
        L_0x0201:
            r0 = move-exception
            goto L_0x0238
        L_0x0203:
            r2 = 0
        L_0x0204:
            if (r6 == 0) goto L_0x020b
            boolean r5 = r1.f29138b     // Catch:{ Exception -> 0x0201 }
            if (r5 == r7) goto L_0x0211
        L_0x020b:
            if (r6 != 0) goto L_0x021b
            boolean r5 = r1.f29138b     // Catch:{ Exception -> 0x0201 }
            if (r5 != 0) goto L_0x021b
        L_0x0211:
            r5 = 0
            com.google.android.gms.internal.ads.zzpd r0 = com.google.android.gms.internal.ads.zzpd.m30869a(r10, r4, r0, r2, r5)     // Catch:{ Exception -> 0x0201 }
            r3.add(r0)     // Catch:{ Exception -> 0x0201 }
            goto L_0x02a2
        L_0x021b:
            r5 = 0
            if (r6 != 0) goto L_0x0233
            if (r7 == 0) goto L_0x0233
            java.lang.String r7 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0201 }
            java.lang.String r7 = r7.concat(r11)     // Catch:{ Exception -> 0x0201 }
            r5 = 1
            com.google.android.gms.internal.ads.zzpd r0 = com.google.android.gms.internal.ads.zzpd.m30869a(r7, r4, r0, r2, r5)     // Catch:{ Exception -> 0x0231 }
            r3.add(r0)     // Catch:{ Exception -> 0x0231 }
            return r3
        L_0x0231:
            r0 = move-exception
            goto L_0x0239
        L_0x0233:
            r5 = 1
            goto L_0x02a2
        L_0x0235:
            r0 = move-exception
            r16 = r5
        L_0x0238:
            r5 = 1
        L_0x0239:
            int r2 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ Exception -> 0x02b8 }
            r7 = 23
            java.lang.String r5 = "MediaCodecUtil"
            if (r2 > r7) goto L_0x026b
            boolean r2 = r3.isEmpty()     // Catch:{ Exception -> 0x02b8 }
            if (r2 != 0) goto L_0x026b
            java.lang.String r0 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x02b8 }
            int r0 = r0.length()     // Catch:{ Exception -> 0x02b8 }
            int r0 = r0 + 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b8 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r0 = "Skipping codec "
            r2.append(r0)     // Catch:{ Exception -> 0x02b8 }
            r2.append(r10)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r0 = " (failed to query capabilities)"
            r2.append(r0)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x02b8 }
            android.util.Log.e(r5, r0)     // Catch:{ Exception -> 0x02b8 }
            goto L_0x02a2
        L_0x026b:
            java.lang.String r1 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x02b8 }
            int r1 = r1.length()     // Catch:{ Exception -> 0x02b8 }
            int r1 = r1 + 25
            java.lang.String r2 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x02b8 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x02b8 }
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b8 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r1 = "Failed to query codec "
            r2.append(r1)     // Catch:{ Exception -> 0x02b8 }
            r2.append(r10)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x02b8 }
            r2.append(r12)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x02b8 }
            android.util.Log.e(r5, r1)     // Catch:{ Exception -> 0x02b8 }
            throw r0     // Catch:{ Exception -> 0x02b8 }
        L_0x02a0:
            r16 = r5
        L_0x02a2:
            int r15 = r15 + 1
            r2 = r18
            r5 = r16
            goto L_0x01c0
        L_0x02aa:
            r16 = r5
            goto L_0x02af
        L_0x02ad:
            r16 = r5
        L_0x02af:
            int r8 = r8 + 1
            r2 = r18
            r5 = r16
            goto L_0x0014
        L_0x02b7:
            return r3
        L_0x02b8:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzpk r1 = new com.google.android.gms.internal.ads.zzpk
            r2 = 0
            r1.<init>(r0)
            goto L_0x02c1
        L_0x02c0:
            throw r1
        L_0x02c1:
            goto L_0x02c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpi.m30913a(com.google.android.gms.internal.ads.zzpi$a, com.google.android.gms.internal.ads.zs):java.util.List");
    }

    /* renamed from: a */
    private static Pair<Integer, Integer> m30910a(String str, String[] strArr) {
        Integer num;
        Integer num2;
        String str2 = "Ignoring malformed AVC codec string: ";
        String str3 = "MediaCodecUtil";
        if (strArr.length < 2) {
            String valueOf = String.valueOf(str);
            Log.w(str3, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                num2 = valueOf2;
            } else if (strArr.length >= 3) {
                num2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                num = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                String valueOf3 = String.valueOf(str);
                Log.w(str3, valueOf3.length() != 0 ? str2.concat(valueOf3) : new String(str2));
                return null;
            }
            Integer valueOf4 = Integer.valueOf(f29133d.get(num2.intValue()));
            if (valueOf4 == null) {
                String valueOf5 = String.valueOf(num2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf5);
                Log.w(str3, sb.toString());
                return null;
            }
            Integer valueOf6 = Integer.valueOf(f29134e.get(num.intValue()));
            if (valueOf6 != null) {
                return new Pair<>(valueOf4, valueOf6);
            }
            String valueOf7 = String.valueOf(num);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf7).length() + 19);
            sb2.append("Unknown AVC level: ");
            sb2.append(valueOf7);
            Log.w(str3, sb2.toString());
            return null;
        } catch (NumberFormatException e) {
            String valueOf8 = String.valueOf(str);
            Log.w(str3, valueOf8.length() != 0 ? str2.concat(valueOf8) : new String(str2));
            return null;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29133d = sparseIntArray;
        sparseIntArray.put(66, 1);
        f29133d.put(77, 2);
        f29133d.put(88, 4);
        f29133d.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f29134e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        f29134e.put(11, 4);
        f29134e.put(12, 8);
        f29134e.put(13, 16);
        f29134e.put(20, 32);
        f29134e.put(21, 64);
        f29134e.put(22, 128);
        f29134e.put(30, Opcodes.ACC_NATIVE);
        f29134e.put(31, 512);
        f29134e.put(32, Opcodes.ACC_ABSTRACT);
        f29134e.put(40, Opcodes.ACC_STRICT);
        f29134e.put(41, Opcodes.ACC_SYNTHETIC);
        f29134e.put(42, Opcodes.ACC_ANNOTATION);
        f29134e.put(50, Opcodes.ACC_ENUM);
        f29134e.put(51, Opcodes.ACC_MANDATED);
        f29134e.put(52, 65536);
        HashMap hashMap = new HashMap();
        f29135f = hashMap;
        hashMap.put("L30", Integer.valueOf(1));
        f29135f.put("L60", Integer.valueOf(4));
        f29135f.put("L63", Integer.valueOf(16));
        f29135f.put("L90", Integer.valueOf(64));
        f29135f.put("L93", Integer.valueOf(Opcodes.ACC_NATIVE));
        f29135f.put("L120", Integer.valueOf(Opcodes.ACC_ABSTRACT));
        f29135f.put("L123", Integer.valueOf(Opcodes.ACC_SYNTHETIC));
        f29135f.put("L150", Integer.valueOf(Opcodes.ACC_ENUM));
        f29135f.put("L153", Integer.valueOf(65536));
        f29135f.put("L156", Integer.valueOf(Opcodes.ASM4));
        f29135f.put("L180", Integer.valueOf(CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES));
        f29135f.put("L183", Integer.valueOf(4194304));
        f29135f.put("L186", Integer.valueOf(16777216));
        f29135f.put("H30", Integer.valueOf(2));
        f29135f.put("H60", Integer.valueOf(8));
        f29135f.put("H63", Integer.valueOf(32));
        f29135f.put("H90", Integer.valueOf(128));
        f29135f.put("H93", Integer.valueOf(512));
        f29135f.put("H120", Integer.valueOf(Opcodes.ACC_STRICT));
        f29135f.put("H123", Integer.valueOf(Opcodes.ACC_ANNOTATION));
        f29135f.put("H150", Integer.valueOf(Opcodes.ACC_MANDATED));
        f29135f.put("H153", Integer.valueOf(Opcodes.ACC_DEPRECATED));
        f29135f.put("H156", Integer.valueOf(524288));
        f29135f.put("H180", Integer.valueOf(2097152));
        f29135f.put("H183", Integer.valueOf(8388608));
        f29135f.put("H186", Integer.valueOf(33554432));
    }
}
