package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import com.vungle.warren.model.Advertisement;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.util.q */
/* compiled from: MimeTypes */
public final class C8529q {

    /* renamed from: a */
    private static final ArrayList<C8530a> f18833a = new ArrayList<>();

    /* renamed from: com.google.android.exoplayer2.util.q$a */
    /* compiled from: MimeTypes */
    private static final class C8530a {

        /* renamed from: a */
        public final String f18834a;

        /* renamed from: b */
        public final String f18835b;

        /* renamed from: c */
        public final int f18836c;
    }

    /* renamed from: f */
    public static boolean m20547f(String mimeType) {
        return "audio".equals(m20551j(mimeType));
    }

    /* renamed from: h */
    public static boolean m20549h(String mimeType) {
        return Advertisement.KEY_VIDEO.equals(m20551j(mimeType));
    }

    /* renamed from: g */
    public static boolean m20548g(String mimeType) {
        return CommandHandler.TEXT.equals(m20551j(mimeType));
    }

    /* renamed from: e */
    public static String m20546e(String codecs) {
        if (codecs == null) {
            return null;
        }
        for (String codec : C8509F.m20479f(codecs)) {
            String mimeType = m20544c(codec);
            if (mimeType != null && m20549h(mimeType)) {
                return mimeType;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m20542a(String codecs) {
        if (codecs == null) {
            return null;
        }
        for (String codec : C8509F.m20479f(codecs)) {
            String mimeType = m20544c(codec);
            if (mimeType != null && m20547f(mimeType)) {
                return mimeType;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m20544c(String codec) {
        if (codec == null) {
            return null;
        }
        String codec2 = C8509F.m20480g(codec.trim());
        if (codec2.startsWith("avc1") || codec2.startsWith("avc3")) {
            return "video/avc";
        }
        if (codec2.startsWith("hev1") || codec2.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (codec2.startsWith("vp9") || codec2.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (codec2.startsWith("vp8") || codec2.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (codec2.startsWith("mp4a")) {
            String mimeType = null;
            if (codec2.startsWith("mp4a.")) {
                String objectTypeString = codec2.substring(5);
                if (objectTypeString.length() >= 2) {
                    try {
                        mimeType = m20541a(Integer.parseInt(C8509F.m20481h(objectTypeString.substring(0, 2)), 16));
                    } catch (NumberFormatException e) {
                    }
                }
            }
            return mimeType == null ? "audio/mp4a-latm" : mimeType;
        } else if (codec2.startsWith("ac-3") || codec2.startsWith("dac3")) {
            return "audio/ac3";
        } else {
            if (codec2.startsWith("ec-3") || codec2.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (codec2.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (codec2.startsWith("dtsc") || codec2.startsWith("dtse")) {
                return "audio/vnd.dts";
            }
            if (codec2.startsWith("dtsh") || codec2.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (codec2.startsWith("opus")) {
                return "audio/opus";
            }
            if (codec2.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if (codec2.startsWith("flac")) {
                return "audio/flac";
            }
            return m20550i(codec2);
        }
    }

    /* renamed from: a */
    public static String m20541a(int objectType) {
        if (objectType == 32) {
            return "video/mp4v-es";
        }
        if (objectType == 33) {
            return "video/avc";
        }
        if (objectType == 35) {
            return "video/hevc";
        }
        if (objectType != 64) {
            if (objectType == 163) {
                return "video/wvc1";
            }
            if (objectType == 177) {
                return "video/x-vnd.on2.vp9";
            }
            if (objectType == 165) {
                return "audio/ac3";
            }
            if (objectType == 166) {
                return "audio/eac3";
            }
            switch (objectType) {
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                    return "video/mpeg2";
                case 102:
                case 103:
                case 104:
                    break;
                case 105:
                case 107:
                    return "audio/mpeg";
                case 106:
                    return "video/mpeg";
                default:
                    switch (objectType) {
                        case Opcodes.RET /*169*/:
                        case Opcodes.IRETURN /*172*/:
                            return "audio/vnd.dts";
                        case Opcodes.TABLESWITCH /*170*/:
                        case Opcodes.LOOKUPSWITCH /*171*/:
                            return "audio/vnd.dts.hd";
                        case Opcodes.LRETURN /*173*/:
                            return "audio/opus";
                        default:
                            return null;
                    }
            }
        }
        return "audio/mp4a-latm";
    }

    /* renamed from: d */
    public static int m20545d(String mimeType) {
        if (TextUtils.isEmpty(mimeType)) {
            return -1;
        }
        if (m20547f(mimeType)) {
            return 1;
        }
        if (m20549h(mimeType)) {
            return 2;
        }
        if (m20548g(mimeType) || "application/cea-608".equals(mimeType) || "application/cea-708".equals(mimeType) || "application/x-mp4-cea-608".equals(mimeType) || "application/x-subrip".equals(mimeType) || "application/ttml+xml".equals(mimeType) || "application/x-quicktime-tx3g".equals(mimeType) || "application/x-mp4-vtt".equals(mimeType) || "application/x-rawcc".equals(mimeType) || "application/vobsub".equals(mimeType) || "application/pgs".equals(mimeType) || "application/dvbsubs".equals(mimeType)) {
            return 3;
        }
        if ("application/id3".equals(mimeType) || "application/x-emsg".equals(mimeType) || "application/x-scte35".equals(mimeType)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(mimeType)) {
            return 5;
        }
        return m20552k(mimeType);
    }

    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m20543b(java.lang.String r7) {
        /*
            int r0 = r7.hashCode()
            r1 = 0
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 5
            switch(r0) {
                case -2123537834: goto L_0x0040;
                case -1095064472: goto L_0x0036;
                case 187078296: goto L_0x002c;
                case 1504578661: goto L_0x0022;
                case 1505942594: goto L_0x0018;
                case 1556697186: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x004a
        L_0x000e:
            java.lang.String r0 = "audio/true-hd"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x000d
            r0 = 5
            goto L_0x004b
        L_0x0018:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x000d
            r0 = 4
            goto L_0x004b
        L_0x0022:
            java.lang.String r0 = "audio/eac3"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x000d
            r0 = 1
            goto L_0x004b
        L_0x002c:
            java.lang.String r0 = "audio/ac3"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x000d
            r0 = 0
            goto L_0x004b
        L_0x0036:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x000d
            r0 = 3
            goto L_0x004b
        L_0x0040:
            java.lang.String r0 = "audio/eac3-joc"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x000d
            r0 = 2
            goto L_0x004b
        L_0x004a:
            r0 = -1
        L_0x004b:
            if (r0 == 0) goto L_0x0062
            if (r0 == r5) goto L_0x0060
            if (r0 == r4) goto L_0x0060
            if (r0 == r3) goto L_0x005e
            if (r0 == r2) goto L_0x005b
            if (r0 == r6) goto L_0x0058
            return r1
        L_0x0058:
            r0 = 14
            return r0
        L_0x005b:
            r0 = 8
            return r0
        L_0x005e:
            r0 = 7
            return r0
        L_0x0060:
            r0 = 6
            return r0
        L_0x0062:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.C8529q.m20543b(java.lang.String):int");
    }

    /* renamed from: j */
    private static String m20551j(String mimeType) {
        if (mimeType == null) {
            return null;
        }
        int indexOfSlash = mimeType.indexOf(47);
        if (indexOfSlash != -1) {
            return mimeType.substring(0, indexOfSlash);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid mime type: ");
        sb.append(mimeType);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: i */
    private static String m20550i(String codec) {
        int customMimeTypeCount = f18833a.size();
        for (int i = 0; i < customMimeTypeCount; i++) {
            C8530a customMimeType = (C8530a) f18833a.get(i);
            if (codec.startsWith(customMimeType.f18835b)) {
                return customMimeType.f18834a;
            }
        }
        return null;
    }

    /* renamed from: k */
    private static int m20552k(String mimeType) {
        int customMimeTypeCount = f18833a.size();
        for (int i = 0; i < customMimeTypeCount; i++) {
            C8530a customMimeType = (C8530a) f18833a.get(i);
            if (mimeType.equals(customMimeType.f18834a)) {
                return customMimeType.f18836c;
            }
        }
        return -1;
    }
}
