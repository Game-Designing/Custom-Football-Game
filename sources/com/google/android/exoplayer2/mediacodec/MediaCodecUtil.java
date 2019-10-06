package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8529q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.file.CacheHelper;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class MediaCodecUtil {

    /* renamed from: a */
    private static final Pattern f18050a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b */
    private static final HashMap<C8332a, List<C8338a>> f18051b = new HashMap<>();

    /* renamed from: c */
    private static final SparseIntArray f18052c = new SparseIntArray();

    /* renamed from: d */
    private static final SparseIntArray f18053d = new SparseIntArray();

    /* renamed from: e */
    private static final Map<String, Integer> f18054e = new HashMap();

    /* renamed from: f */
    private static final SparseIntArray f18055f = new SparseIntArray();

    /* renamed from: g */
    private static int f18056g = -1;

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable cause) {
            super("Failed to query underlying media codecs", cause);
        }
    }

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$a */
    private static final class C8332a {

        /* renamed from: a */
        public final String f18057a;

        /* renamed from: b */
        public final boolean f18058b;

        public C8332a(String mimeType, boolean secure) {
            this.f18057a = mimeType;
            this.f18058b = secure;
        }

        public int hashCode() {
            int i = 1 * 31;
            String str = this.f18057a;
            return ((i + (str == null ? 0 : str.hashCode())) * 31) + (this.f18058b ? 1231 : 1237);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != C8332a.class) {
                return false;
            }
            C8332a other = (C8332a) obj;
            if (!TextUtils.equals(this.f18057a, other.f18057a) || this.f18058b != other.f18058b) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$b */
    private interface C8333b {
        /* renamed from: a */
        int mo25521a();

        /* renamed from: a */
        MediaCodecInfo mo25522a(int i);

        /* renamed from: a */
        boolean mo25523a(String str, CodecCapabilities codecCapabilities);

        /* renamed from: b */
        boolean mo25524b();
    }

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c */
    private static final class C8334c implements C8333b {
        private C8334c() {
        }

        /* renamed from: a */
        public int mo25521a() {
            return MediaCodecList.getCodecCount();
        }

        /* renamed from: a */
        public MediaCodecInfo mo25522a(int index) {
            return MediaCodecList.getCodecInfoAt(index);
        }

        /* renamed from: b */
        public boolean mo25524b() {
            return false;
        }

        /* renamed from: a */
        public boolean mo25523a(String mimeType, CodecCapabilities capabilities) {
            return "video/avc".equals(mimeType);
        }
    }

    @TargetApi(21)
    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$d */
    private static final class C8335d implements C8333b {

        /* renamed from: a */
        private final int f18059a;

        /* renamed from: b */
        private MediaCodecInfo[] f18060b;

        public C8335d(boolean includeSecure) {
            this.f18059a = includeSecure;
        }

        /* renamed from: a */
        public int mo25521a() {
            m19639c();
            return this.f18060b.length;
        }

        /* renamed from: a */
        public MediaCodecInfo mo25522a(int index) {
            m19639c();
            return this.f18060b[index];
        }

        /* renamed from: b */
        public boolean mo25524b() {
            return true;
        }

        /* renamed from: a */
        public boolean mo25523a(String mimeType, CodecCapabilities capabilities) {
            return capabilities.isFeatureSupported("secure-playback");
        }

        /* renamed from: c */
        private void m19639c() {
            if (this.f18060b == null) {
                this.f18060b = new MediaCodecList(this.f18059a).getCodecInfos();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$e */
    private static final class C8336e implements Comparator<C8338a> {
        private C8336e() {
        }

        /* renamed from: a */
        public int compare(C8338a a, C8338a b) {
            return m19644a(a) - m19644a(b);
        }

        /* renamed from: a */
        private static int m19644a(C8338a mediaCodecInfo) {
            return mediaCodecInfo.f18061a.startsWith("OMX.google") ? -1 : 0;
        }
    }

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$f */
    private static final class C8337f implements Comparator<C8338a> {
        private C8337f() {
        }

        /* renamed from: a */
        public int compare(C8338a a, C8338a b) {
            return m19646a(a) - m19646a(b);
        }

        /* renamed from: a */
        private static int m19646a(C8338a mediaCodecInfo) {
            String name = mediaCodecInfo.f18061a;
            if (name.startsWith("OMX.google") || name.startsWith("c2.android")) {
                return -1;
            }
            if (C8509F.f18793a >= 26 || !name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                return 0;
            }
            return 1;
        }
    }

    static {
        f18052c.put(66, 1);
        f18052c.put(77, 2);
        f18052c.put(88, 4);
        f18052c.put(100, 8);
        f18052c.put(110, 16);
        f18052c.put(Opcodes.ISHR, 32);
        f18052c.put(244, 64);
        f18053d.put(10, 1);
        f18053d.put(11, 4);
        f18053d.put(12, 8);
        f18053d.put(13, 16);
        f18053d.put(20, 32);
        f18053d.put(21, 64);
        f18053d.put(22, 128);
        f18053d.put(30, Opcodes.ACC_NATIVE);
        f18053d.put(31, 512);
        f18053d.put(32, Opcodes.ACC_ABSTRACT);
        f18053d.put(40, Opcodes.ACC_STRICT);
        f18053d.put(41, Opcodes.ACC_SYNTHETIC);
        f18053d.put(42, Opcodes.ACC_ANNOTATION);
        f18053d.put(50, Opcodes.ACC_ENUM);
        f18053d.put(51, Opcodes.ACC_MANDATED);
        f18053d.put(52, 65536);
        f18054e.put("L30", Integer.valueOf(1));
        f18054e.put("L60", Integer.valueOf(4));
        f18054e.put("L63", Integer.valueOf(16));
        f18054e.put("L90", Integer.valueOf(64));
        f18054e.put("L93", Integer.valueOf(Opcodes.ACC_NATIVE));
        f18054e.put("L120", Integer.valueOf(Opcodes.ACC_ABSTRACT));
        f18054e.put("L123", Integer.valueOf(Opcodes.ACC_SYNTHETIC));
        f18054e.put("L150", Integer.valueOf(Opcodes.ACC_ENUM));
        f18054e.put("L153", Integer.valueOf(65536));
        f18054e.put("L156", Integer.valueOf(Opcodes.ASM4));
        f18054e.put("L180", Integer.valueOf(CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES));
        f18054e.put("L183", Integer.valueOf(4194304));
        f18054e.put("L186", Integer.valueOf(16777216));
        f18054e.put("H30", Integer.valueOf(2));
        f18054e.put("H60", Integer.valueOf(8));
        f18054e.put("H63", Integer.valueOf(32));
        f18054e.put("H90", Integer.valueOf(128));
        f18054e.put("H93", Integer.valueOf(512));
        f18054e.put("H120", Integer.valueOf(Opcodes.ACC_STRICT));
        f18054e.put("H123", Integer.valueOf(Opcodes.ACC_ANNOTATION));
        f18054e.put("H150", Integer.valueOf(Opcodes.ACC_MANDATED));
        f18054e.put("H153", Integer.valueOf(Opcodes.ACC_DEPRECATED));
        f18054e.put("H156", Integer.valueOf(524288));
        f18054e.put("H180", Integer.valueOf(2097152));
        f18054e.put("H183", Integer.valueOf(8388608));
        f18054e.put("H186", Integer.valueOf(33554432));
        f18055f.put(1, 1);
        f18055f.put(2, 2);
        f18055f.put(3, 3);
        f18055f.put(4, 4);
        f18055f.put(5, 5);
        f18055f.put(6, 6);
        f18055f.put(17, 17);
        f18055f.put(20, 20);
        f18055f.put(23, 23);
        f18055f.put(29, 29);
        f18055f.put(39, 39);
        f18055f.put(42, 42);
    }

    /* renamed from: a */
    public static C8338a m19621a() throws DecoderQueryException {
        C8338a decoderInfo = m19622a("audio/raw", false);
        if (decoderInfo == null) {
            return null;
        }
        return C8338a.m19652b(decoderInfo.f18061a);
    }

    /* renamed from: a */
    public static C8338a m19622a(String mimeType, boolean secure) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = m19628b(mimeType, secure);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return (C8338a) decoderInfos.get(0);
    }

    /* renamed from: b */
    public static synchronized List<C8338a> m19628b(String mimeType, boolean secure) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            C8332a key = new C8332a(mimeType, secure);
            List<MediaCodecInfo> cachedDecoderInfos = (List) f18051b.get(key);
            if (cachedDecoderInfos != null) {
                return cachedDecoderInfos;
            }
            C8333b mediaCodecList = C8509F.f18793a >= 21 ? new C8335d(secure) : new C8334c();
            ArrayList a = m19623a(key, mediaCodecList, mimeType);
            if (secure && a.isEmpty() && 21 <= C8509F.f18793a && C8509F.f18793a <= 23) {
                mediaCodecList = new C8334c();
                a = m19623a(key, mediaCodecList, mimeType);
                if (!a.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(mimeType);
                    sb.append(". Assuming: ");
                    sb.append(((C8338a) a.get(0)).f18061a);
                    C8526n.m20534d("MediaCodecUtil", sb.toString());
                }
            }
            if ("audio/eac3-joc".equals(mimeType)) {
                a.addAll(m19623a(new C8332a("audio/eac3", key.f18058b), mediaCodecList, mimeType));
            }
            m19624a(mimeType, (List<C8338a>) a);
            List<MediaCodecInfo> unmodifiableDecoderInfos = Collections.unmodifiableList(a);
            f18051b.put(key, unmodifiableDecoderInfos);
            return unmodifiableDecoderInfos;
        }
    }

    /* renamed from: b */
    public static int m19626b() throws DecoderQueryException {
        if (f18056g == -1) {
            int result = 0;
            C8338a decoderInfo = m19622a("video/avc", false);
            if (decoderInfo != null) {
                for (CodecProfileLevel profileLevel : decoderInfo.mo25535a()) {
                    result = Math.max(m19618a(profileLevel.level), result);
                }
                result = Math.max(result, C8509F.f18793a >= 21 ? 345600 : 172800);
            }
            f18056g = result;
        }
        return f18056g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r3.equals("hev1") != false) goto L_0x004c;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> m19619a(java.lang.String r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r10.split(r1)
            r2 = 0
            r3 = r1[r2]
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            switch(r5) {
                case 3006243: goto L_0x0041;
                case 3006244: goto L_0x0037;
                case 3199032: goto L_0x002e;
                case 3214780: goto L_0x0024;
                case 3356560: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x004b
        L_0x001a:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0019
            r2 = 4
            goto L_0x004c
        L_0x0024:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0019
            r2 = 1
            goto L_0x004c
        L_0x002e:
            java.lang.String r5 = "hev1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0019
            goto L_0x004c
        L_0x0037:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0019
            r2 = 3
            goto L_0x004c
        L_0x0041:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0019
            r2 = 2
            goto L_0x004c
        L_0x004b:
            r2 = -1
        L_0x004c:
            if (r2 == 0) goto L_0x0061
            if (r2 == r9) goto L_0x0061
            if (r2 == r8) goto L_0x005c
            if (r2 == r7) goto L_0x005c
            if (r2 == r6) goto L_0x0057
            return r0
        L_0x0057:
            android.util.Pair r0 = m19620a(r10, r1)
            return r0
        L_0x005c:
            android.util.Pair r0 = m19627b(r10, r1)
            return r0
        L_0x0061:
            android.util.Pair r0 = m19630c(r10, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.m19619a(java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (r1.f18058b != r2) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        if (r1.f18058b == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r3.add(com.google.android.exoplayer2.mediacodec.C8338a.m19649a(r9, r4, r0, r18, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
        r0 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6 A[SYNTHETIC, Splitter:B:46:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c6 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.google.android.exoplayer2.mediacodec.C8338a> m19623a(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.C8332a r19, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.C8333b r20, java.lang.String r21) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r1 = r19
            r2 = r20
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x010b }
            r0.<init>()     // Catch:{ Exception -> 0x010b }
            r3 = r0
            java.lang.String r0 = r1.f18057a     // Catch:{ Exception -> 0x010b }
            r4 = r0
            int r0 = r20.mo25521a()     // Catch:{ Exception -> 0x010b }
            r5 = r0
            boolean r0 = r20.mo25524b()     // Catch:{ Exception -> 0x010b }
            r6 = r0
            r0 = 0
            r7 = r0
        L_0x0019:
            if (r7 >= r5) goto L_0x0106
            android.media.MediaCodecInfo r0 = r2.mo25522a(r7)     // Catch:{ Exception -> 0x010b }
            r8 = r0
            java.lang.String r0 = r8.getName()     // Catch:{ Exception -> 0x010b }
            r9 = r0
            r10 = r21
            boolean r0 = m19625a(r8, r9, r6, r10)     // Catch:{ Exception -> 0x0104 }
            if (r0 == 0) goto L_0x00f8
            java.lang.String[] r11 = r8.getSupportedTypes()     // Catch:{ Exception -> 0x0104 }
            int r12 = r11.length     // Catch:{ Exception -> 0x0104 }
            r14 = 0
        L_0x0033:
            if (r14 >= r12) goto L_0x00f5
            r0 = r11[r14]     // Catch:{ Exception -> 0x0104 }
            r15 = r0
            boolean r0 = r15.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0104 }
            if (r0 == 0) goto L_0x00e9
            android.media.MediaCodecInfo$CodecCapabilities r0 = r8.getCapabilitiesForType(r15)     // Catch:{ Exception -> 0x009b }
            boolean r16 = r2.mo25523a(r4, r0)     // Catch:{ Exception -> 0x009b }
            r17 = r16
            boolean r16 = m19629b(r9)     // Catch:{ Exception -> 0x009b }
            r18 = r16
            if (r6 == 0) goto L_0x005b
            boolean r13 = r1.f18058b     // Catch:{ Exception -> 0x0057 }
            r2 = r17
            if (r13 == r2) goto L_0x0063
            goto L_0x005d
        L_0x0057:
            r0 = move-exception
            r16 = r5
            goto L_0x009e
        L_0x005b:
            r2 = r17
        L_0x005d:
            if (r6 != 0) goto L_0x0077
            boolean r13 = r1.f18058b     // Catch:{ Exception -> 0x0072 }
            if (r13 != 0) goto L_0x0077
        L_0x0063:
            r16 = r5
            r13 = r18
            r1 = 0
            com.google.android.exoplayer2.mediacodec.a r5 = com.google.android.exoplayer2.mediacodec.C8338a.m19649a(r9, r4, r0, r13, r1)     // Catch:{ Exception -> 0x0070 }
            r3.add(r5)     // Catch:{ Exception -> 0x0070 }
            goto L_0x009a
        L_0x0070:
            r0 = move-exception
            goto L_0x009e
        L_0x0072:
            r0 = move-exception
            r16 = r5
            r1 = 0
            goto L_0x009e
        L_0x0077:
            r16 = r5
            r13 = r18
            r1 = 0
            if (r6 != 0) goto L_0x009a
            if (r2 == 0) goto L_0x009a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0070 }
            r5.<init>()     // Catch:{ Exception -> 0x0070 }
            r5.append(r9)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r1 = ".secure"
            r5.append(r1)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x0070 }
            r5 = 1
            com.google.android.exoplayer2.mediacodec.a r1 = com.google.android.exoplayer2.mediacodec.C8338a.m19649a(r1, r4, r0, r13, r5)     // Catch:{ Exception -> 0x0070 }
            r3.add(r1)     // Catch:{ Exception -> 0x0070 }
            return r3
        L_0x009a:
            goto L_0x00eb
        L_0x009b:
            r0 = move-exception
            r16 = r5
        L_0x009e:
            int r1 = com.google.android.exoplayer2.util.C8509F.f18793a     // Catch:{ Exception -> 0x0104 }
            r2 = 23
            java.lang.String r5 = "MediaCodecUtil"
            if (r1 > r2) goto L_0x00c6
            boolean r1 = r3.isEmpty()     // Catch:{ Exception -> 0x0104 }
            if (r1 != 0) goto L_0x00c6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r1.<init>()     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = "Skipping codec "
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            r1.append(r9)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = " (failed to query capabilities)"
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0104 }
            com.google.android.exoplayer2.util.C8526n.m20531b(r5, r1)     // Catch:{ Exception -> 0x0104 }
            goto L_0x00eb
        L_0x00c6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r1.<init>()     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = "Failed to query codec "
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            r1.append(r9)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = " ("
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            r1.append(r15)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0104 }
            com.google.android.exoplayer2.util.C8526n.m20531b(r5, r1)     // Catch:{ Exception -> 0x0104 }
            throw r0     // Catch:{ Exception -> 0x0104 }
        L_0x00e9:
            r16 = r5
        L_0x00eb:
            int r14 = r14 + 1
            r1 = r19
            r2 = r20
            r5 = r16
            goto L_0x0033
        L_0x00f5:
            r16 = r5
            goto L_0x00fa
        L_0x00f8:
            r16 = r5
        L_0x00fa:
            int r7 = r7 + 1
            r1 = r19
            r2 = r20
            r5 = r16
            goto L_0x0019
        L_0x0104:
            r0 = move-exception
            goto L_0x010e
        L_0x0106:
            r10 = r21
            r16 = r5
            return r3
        L_0x010b:
            r0 = move-exception
            r10 = r21
        L_0x010e:
            com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException r1 = new com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException
            r2 = 0
            r1.<init>(r0)
            goto L_0x0116
        L_0x0115:
            throw r1
        L_0x0116:
            goto L_0x0115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.m19623a(com.google.android.exoplayer2.mediacodec.MediaCodecUtil$a, com.google.android.exoplayer2.mediacodec.MediaCodecUtil$b, java.lang.String):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0074, code lost:
        if (com.google.android.exoplayer2.util.C8509F.f18794b.startsWith("HM") != false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fb, code lost:
        if ("SO-02E".equals(com.google.android.exoplayer2.util.C8509F.f18794b) != false) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0130, code lost:
        if ("C1605".equals(com.google.android.exoplayer2.util.C8509F.f18794b) != false) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01a1, code lost:
        if ("SCV31".equals(com.google.android.exoplayer2.util.C8509F.f18794b) != false) goto L_0x01a3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m19625a(android.media.MediaCodecInfo r5, java.lang.String r6, boolean r7, java.lang.String r8) {
        /*
            boolean r0 = r5.isEncoder()
            r1 = 0
            if (r0 != 0) goto L_0x0215
            if (r7 != 0) goto L_0x0013
            java.lang.String r0 = ".secure"
            boolean r0 = r6.endsWith(r0)
            if (r0 == 0) goto L_0x0013
            goto L_0x0215
        L_0x0013:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r2 = 21
            if (r0 >= r2) goto L_0x004a
            java.lang.String r0 = "CIPAACDecoder"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = "CIPMP3Decoder"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = "CIPVorbisDecoder"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = "CIPAMRNBDecoder"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = "AACDecoder"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = "MP3Decoder"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x004a
        L_0x0049:
            return r1
        L_0x004a:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r2 = 18
            if (r0 >= r2) goto L_0x0077
            java.lang.String r0 = "OMX.MTK.AUDIO.DECODER.AAC"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "a70"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18795c
            java.lang.String r2 = "Xiaomi"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "HM"
            boolean r0 = r0.startsWith(r2)
            if (r0 == 0) goto L_0x0077
        L_0x0076:
            return r1
        L_0x0077:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r2 = 16
            if (r0 != r2) goto L_0x00fe
            java.lang.String r0 = "OMX.qcom.audio.decoder.mp3"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00fe
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "dlxu"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "protou"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "ville"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "villeplus"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "villec2"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "gee"
            boolean r0 = r0.startsWith(r3)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "C6602"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "C6603"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "C6606"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "C6616"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "L36h"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "SO-02E"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00fe
        L_0x00fd:
            return r1
        L_0x00fe:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            if (r0 != r2) goto L_0x0133
            java.lang.String r0 = "OMX.qcom.audio.decoder.aac"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0133
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "C1504"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0132
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "C1505"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0132
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "C1604"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0132
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "C1605"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0133
        L_0x0132:
            return r1
        L_0x0133:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r2 = 24
            java.lang.String r3 = "samsung"
            if (r0 >= r2) goto L_0x01a4
            java.lang.String r0 = "OMX.SEC.aac.dec"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x014b
            java.lang.String r0 = "OMX.Exynos.AAC.Decoder"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x01a4
        L_0x014b:
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18795c
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x01a4
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "zeroflte"
            boolean r0 = r0.startsWith(r2)
            if (r0 != 0) goto L_0x01a3
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "zerolte"
            boolean r0 = r0.startsWith(r2)
            if (r0 != 0) goto L_0x01a3
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "zenlte"
            boolean r0 = r0.startsWith(r2)
            if (r0 != 0) goto L_0x01a3
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "SC-05G"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x01a3
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "marinelteatt"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x01a3
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "404SC"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x01a3
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "SC-04G"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x01a3
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r2 = "SCV31"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x01a4
        L_0x01a3:
            return r1
        L_0x01a4:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            java.lang.String r2 = "jflte"
            r4 = 19
            if (r0 > r4) goto L_0x01ed
            java.lang.String r0 = "OMX.SEC.vp8.dec"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x01ed
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18795c
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x01ed
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "d2"
            boolean r0 = r0.startsWith(r3)
            if (r0 != 0) goto L_0x01ec
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "serrano"
            boolean r0 = r0.startsWith(r3)
            if (r0 != 0) goto L_0x01ec
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            boolean r0 = r0.startsWith(r2)
            if (r0 != 0) goto L_0x01ec
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "santos"
            boolean r0 = r0.startsWith(r3)
            if (r0 != 0) goto L_0x01ec
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r3 = "t0"
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L_0x01ed
        L_0x01ec:
            return r1
        L_0x01ed:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            if (r0 > r4) goto L_0x0202
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            boolean r0 = r0.startsWith(r2)
            if (r0 == 0) goto L_0x0202
            java.lang.String r0 = "OMX.qcom.video.decoder.vp8"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0202
            return r1
        L_0x0202:
            java.lang.String r0 = "audio/eac3-joc"
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0213
            java.lang.String r0 = "OMX.MTK.AUDIO.DECODER.DSPAC3"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0213
            return r1
        L_0x0213:
            r0 = 1
            return r0
        L_0x0215:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.m19625a(android.media.MediaCodecInfo, java.lang.String, boolean, java.lang.String):boolean");
    }

    /* renamed from: a */
    private static void m19624a(String mimeType, List<C8338a> decoderInfos) {
        if ("audio/raw".equals(mimeType)) {
            Collections.sort(decoderInfos, new C8337f());
        } else if (C8509F.f18793a < 21 && decoderInfos.size() > 1) {
            String firstCodecName = ((C8338a) decoderInfos.get(0)).f18061a;
            if ("OMX.SEC.mp3.dec".equals(firstCodecName) || "OMX.SEC.MP3.Decoder".equals(firstCodecName) || "OMX.brcm.audio.mp3.decoder".equals(firstCodecName)) {
                Collections.sort(decoderInfos, new C8336e());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if ("Nexus 10".equals(com.google.android.exoplayer2.util.C8509F.f18796d) != false) goto L_0x001a;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m19629b(java.lang.String r2) {
        /*
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r1 = 22
            if (r0 > r1) goto L_0x002c
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r1 = "ODROID-XU3"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x001a
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r1 = "Nexus 10"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x002c
        L_0x001a:
            java.lang.String r0 = "OMX.Exynos.AVC.Decoder"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x002a
            java.lang.String r0 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x002c
        L_0x002a:
            r0 = 1
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.m19629b(java.lang.String):boolean");
    }

    /* renamed from: c */
    private static Pair<Integer, Integer> m19630c(String codec, String[] parts) {
        int profile;
        String str = "Ignoring malformed HEVC codec string: ";
        String str2 = "MediaCodecUtil";
        if (parts.length < 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(codec);
            C8526n.m20534d(str2, sb.toString());
            return null;
        }
        Matcher matcher = f18050a.matcher(parts[1]);
        if (!matcher.matches()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(codec);
            C8526n.m20534d(str2, sb2.toString());
            return null;
        }
        String profileString = matcher.group(1);
        if ("1".equals(profileString)) {
            profile = 1;
        } else if ("2".equals(profileString)) {
            profile = 2;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unknown HEVC profile string: ");
            sb3.append(profileString);
            C8526n.m20534d(str2, sb3.toString());
            return null;
        }
        Integer level = (Integer) f18054e.get(parts[3]);
        if (level != null) {
            return new Pair<>(Integer.valueOf(profile), level);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Unknown HEVC level string: ");
        sb4.append(matcher.group(1));
        C8526n.m20534d(str2, sb4.toString());
        return null;
    }

    /* renamed from: b */
    private static Pair<Integer, Integer> m19627b(String codec, String[] parts) {
        Integer levelInteger;
        Integer profileInteger;
        String str = "Ignoring malformed AVC codec string: ";
        String str2 = "MediaCodecUtil";
        if (parts.length < 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(codec);
            C8526n.m20534d(str2, sb.toString());
            return null;
        }
        try {
            if (parts[1].length() == 6) {
                Integer profileInteger2 = Integer.valueOf(Integer.parseInt(parts[1].substring(0, 2), 16));
                levelInteger = Integer.valueOf(Integer.parseInt(parts[1].substring(4), 16));
                profileInteger = profileInteger2;
            } else if (parts.length >= 3) {
                profileInteger = Integer.valueOf(Integer.parseInt(parts[1]));
                levelInteger = Integer.valueOf(Integer.parseInt(parts[2]));
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(codec);
                C8526n.m20534d(str2, sb2.toString());
                return null;
            }
            int profile = f18052c.get(profileInteger.intValue(), -1);
            if (profile == -1) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unknown AVC profile: ");
                sb3.append(profileInteger);
                C8526n.m20534d(str2, sb3.toString());
                return null;
            }
            int level = f18053d.get(levelInteger.intValue(), -1);
            if (level != -1) {
                return new Pair<>(Integer.valueOf(profile), Integer.valueOf(level));
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Unknown AVC level: ");
            sb4.append(levelInteger);
            C8526n.m20534d(str2, sb4.toString());
            return null;
        } catch (NumberFormatException e) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(codec);
            C8526n.m20534d(str2, sb5.toString());
            return null;
        }
    }

    /* renamed from: a */
    private static int m19618a(int avcLevel) {
        if (avcLevel == 1 || avcLevel == 2) {
            return 25344;
        }
        switch (avcLevel) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case Opcodes.ACC_NATIVE /*256*/:
                return 414720;
            case 512:
                return 921600;
            case Opcodes.ACC_ABSTRACT /*1024*/:
                return 1310720;
            case Opcodes.ACC_STRICT /*2048*/:
            case Opcodes.ACC_SYNTHETIC /*4096*/:
                return 2097152;
            case Opcodes.ACC_ANNOTATION /*8192*/:
                return 2228224;
            case Opcodes.ACC_ENUM /*16384*/:
                return 5652480;
            case Opcodes.ACC_MANDATED /*32768*/:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    /* renamed from: a */
    private static Pair<Integer, Integer> m19620a(String codec, String[] parts) {
        String str = "Ignoring malformed MP4A codec string: ";
        String str2 = "MediaCodecUtil";
        if (parts.length != 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(codec);
            C8526n.m20534d(str2, sb.toString());
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(C8529q.m20541a(Integer.parseInt(parts[1], 16)))) {
                int profile = f18055f.get(Integer.parseInt(parts[2]), -1);
                if (profile != -1) {
                    return new Pair<>(Integer.valueOf(profile), Integer.valueOf(0));
                }
            }
        } catch (NumberFormatException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(codec);
            C8526n.m20534d(str2, sb2.toString());
        }
        return null;
    }
}
