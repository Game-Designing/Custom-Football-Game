package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8529q;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.mediacodec.a */
/* compiled from: MediaCodecInfo */
public final class C8338a {

    /* renamed from: a */
    public final String f18061a;

    /* renamed from: b */
    public final String f18062b;

    /* renamed from: c */
    public final CodecCapabilities f18063c;

    /* renamed from: d */
    public final boolean f18064d;

    /* renamed from: e */
    public final boolean f18065e;

    /* renamed from: f */
    public final boolean f18066f;

    /* renamed from: g */
    public final boolean f18067g;

    /* renamed from: h */
    private final boolean f18068h;

    /* renamed from: b */
    public static C8338a m19652b(String name) {
        C8338a aVar = new C8338a(name, null, null, true, false, false);
        return aVar;
    }

    /* renamed from: a */
    public static C8338a m19649a(String name, String mimeType, CodecCapabilities capabilities, boolean forceDisableAdaptive, boolean forceSecure) {
        C8338a aVar = new C8338a(name, mimeType, capabilities, false, forceDisableAdaptive, forceSecure);
        return aVar;
    }

    private C8338a(String name, String mimeType, CodecCapabilities capabilities, boolean passthrough, boolean forceDisableAdaptive, boolean forceSecure) {
        C8514e.m20486a(name);
        this.f18061a = name;
        this.f18062b = mimeType;
        this.f18063c = capabilities;
        this.f18067g = passthrough;
        boolean z = true;
        this.f18064d = !forceDisableAdaptive && capabilities != null && m19650a(capabilities);
        this.f18065e = capabilities != null && m19658e(capabilities);
        if (!forceSecure && (capabilities == null || !m19655c(capabilities))) {
            z = false;
        }
        this.f18066f = z;
        this.f18068h = C8529q.m20549h(mimeType);
    }

    public String toString() {
        return this.f18061a;
    }

    /* renamed from: a */
    public CodecProfileLevel[] mo25535a() {
        CodecCapabilities codecCapabilities = this.f18063c;
        if (codecCapabilities != null) {
            CodecProfileLevel[] codecProfileLevelArr = codecCapabilities.profileLevels;
            if (codecProfileLevelArr != null) {
                return codecProfileLevelArr;
            }
        }
        return new CodecProfileLevel[0];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        if (mo25530a(r0) == false) goto L_0x0070;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo25532a(com.google.android.exoplayer2.Format r7) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r6 = this;
            java.lang.String r0 = r7.f16504d
            boolean r0 = r6.mo25534a(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            boolean r0 = r6.f18068h
            r2 = 21
            r3 = 1
            if (r0 == 0) goto L_0x0054
            int r0 = r7.f16512l
            if (r0 <= 0) goto L_0x0053
            int r4 = r7.f16513m
            if (r4 > 0) goto L_0x001a
            goto L_0x0053
        L_0x001a:
            int r5 = com.google.android.exoplayer2.util.C8509F.f18793a
            if (r5 < r2) goto L_0x0026
            float r1 = r7.f16514n
            double r1 = (double) r1
            boolean r0 = r6.mo25531a(r0, r4, r1)
            return r0
        L_0x0026:
            int r0 = r0 * r4
            int r2 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.m19626b()
            if (r0 > r2) goto L_0x002f
            r1 = 1
        L_0x002f:
            r0 = r1
            if (r0 != 0) goto L_0x0052
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "legacyFrameSize, "
            r1.append(r2)
            int r2 = r7.f16512l
            r1.append(r2)
            java.lang.String r2 = "x"
            r1.append(r2)
            int r2 = r7.f16513m
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.m19656d(r1)
        L_0x0052:
            return r0
        L_0x0053:
            return r3
        L_0x0054:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            if (r0 < r2) goto L_0x006f
            int r0 = r7.f16521u
            r2 = -1
            if (r0 == r2) goto L_0x0063
            boolean r0 = r6.mo25536b(r0)
            if (r0 == 0) goto L_0x006e
        L_0x0063:
            int r0 = r7.f16520t
            if (r0 == r2) goto L_0x006f
            boolean r0 = r6.mo25530a(r0)
            if (r0 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            goto L_0x0070
        L_0x006f:
            r1 = 1
        L_0x0070:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.C8338a.mo25532a(com.google.android.exoplayer2.Format):boolean");
    }

    /* renamed from: a */
    public boolean mo25534a(String codec) {
        CodecProfileLevel[] a;
        if (codec == null || this.f18062b == null) {
            return true;
        }
        String codecMimeType = C8529q.m20544c(codec);
        if (codecMimeType == null) {
            return true;
        }
        String str = ", ";
        if (!this.f18062b.equals(codecMimeType)) {
            StringBuilder sb = new StringBuilder();
            sb.append("codec.mime ");
            sb.append(codec);
            sb.append(str);
            sb.append(codecMimeType);
            m19656d(sb.toString());
            return false;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.m19619a(codec);
        if (codecProfileAndLevel == null) {
            return true;
        }
        int profile = ((Integer) codecProfileAndLevel.first).intValue();
        int level = ((Integer) codecProfileAndLevel.second).intValue();
        if (!this.f18068h && profile != 42) {
            return true;
        }
        for (CodecProfileLevel capabilities : mo25535a()) {
            if (capabilities.profile == profile && capabilities.level >= level) {
                return true;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("codec.profileLevel, ");
        sb2.append(codec);
        sb2.append(str);
        sb2.append(codecMimeType);
        m19656d(sb2.toString());
        return false;
    }

    /* renamed from: b */
    public boolean mo25537b(Format format) {
        if (this.f18068h) {
            return this.f18064d;
        }
        Pair<Integer, Integer> codecProfileLevel = MediaCodecUtil.m19619a(format.f16504d);
        return codecProfileLevel != null && ((Integer) codecProfileLevel.first).intValue() == 42;
    }

    /* renamed from: a */
    public boolean mo25533a(Format oldFormat, Format newFormat, boolean isNewFormatComplete) {
        boolean z = true;
        if (this.f18068h) {
            if (!oldFormat.f16507g.equals(newFormat.f16507g) || oldFormat.f16515o != newFormat.f16515o || ((!this.f18064d && !(oldFormat.f16512l == newFormat.f16512l && oldFormat.f16513m == newFormat.f16513m)) || ((isNewFormatComplete || newFormat.f16519s != null) && !C8509F.m20455a((Object) oldFormat.f16519s, (Object) newFormat.f16519s)))) {
                z = false;
            }
            return z;
        }
        if (!"audio/mp4a-latm".equals(this.f18062b) || !oldFormat.f16507g.equals(newFormat.f16507g) || oldFormat.f16520t != newFormat.f16520t || oldFormat.f16521u != newFormat.f16521u) {
            return false;
        }
        Pair<Integer, Integer> oldCodecProfileLevel = MediaCodecUtil.m19619a(oldFormat.f16504d);
        Pair<Integer, Integer> newCodecProfileLevel = MediaCodecUtil.m19619a(newFormat.f16504d);
        if (oldCodecProfileLevel == null || newCodecProfileLevel == null) {
            return false;
        }
        int oldProfile = ((Integer) oldCodecProfileLevel.first).intValue();
        int newProfile = ((Integer) newCodecProfileLevel.first).intValue();
        if (!(oldProfile == 42 && newProfile == 42)) {
            z = false;
        }
        return z;
    }

    @TargetApi(21)
    /* renamed from: a */
    public boolean mo25531a(int width, int height, double frameRate) {
        CodecCapabilities codecCapabilities = this.f18063c;
        if (codecCapabilities == null) {
            m19656d("sizeAndRate.caps");
            return false;
        }
        VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            m19656d("sizeAndRate.vCaps");
            return false;
        }
        if (!m19651a(videoCapabilities, width, height, frameRate)) {
            String str = "x";
            if (width >= height || !m19651a(videoCapabilities, height, width, frameRate)) {
                StringBuilder sb = new StringBuilder();
                sb.append("sizeAndRate.support, ");
                sb.append(width);
                sb.append(str);
                sb.append(height);
                sb.append(str);
                sb.append(frameRate);
                m19656d(sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sizeAndRate.rotated, ");
            sb2.append(width);
            sb2.append(str);
            sb2.append(height);
            sb2.append(str);
            sb2.append(frameRate);
            m19654c(sb2.toString());
        }
        return true;
    }

    @TargetApi(21)
    /* renamed from: a */
    public Point mo25529a(int width, int height) {
        CodecCapabilities codecCapabilities = this.f18063c;
        if (codecCapabilities == null) {
            m19656d("align.caps");
            return null;
        }
        VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            m19656d("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(C8509F.m20432a(width, widthAlignment) * widthAlignment, C8509F.m20432a(height, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    /* renamed from: b */
    public boolean mo25536b(int sampleRate) {
        CodecCapabilities codecCapabilities = this.f18063c;
        if (codecCapabilities == null) {
            m19656d("sampleRate.caps");
            return false;
        }
        AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            m19656d("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(sampleRate)) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("sampleRate.support, ");
            sb.append(sampleRate);
            m19656d(sb.toString());
            return false;
        }
    }

    @TargetApi(21)
    /* renamed from: a */
    public boolean mo25530a(int channelCount) {
        CodecCapabilities codecCapabilities = this.f18063c;
        if (codecCapabilities == null) {
            m19656d("channelCount.caps");
            return false;
        }
        AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            m19656d("channelCount.aCaps");
            return false;
        } else if (m19648a(this.f18061a, this.f18062b, audioCapabilities.getMaxInputChannelCount()) >= channelCount) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("channelCount.support, ");
            sb.append(channelCount);
            m19656d(sb.toString());
            return false;
        }
    }

    /* renamed from: d */
    private void m19656d(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("NoSupport [");
        sb.append(message);
        String str = "] [";
        sb.append(str);
        sb.append(this.f18061a);
        sb.append(", ");
        sb.append(this.f18062b);
        sb.append(str);
        sb.append(C8509F.f18797e);
        sb.append("]");
        C8526n.m20529a("MediaCodecInfo", sb.toString());
    }

    /* renamed from: c */
    private void m19654c(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("AssumedSupport [");
        sb.append(message);
        String str = "] [";
        sb.append(str);
        sb.append(this.f18061a);
        sb.append(", ");
        sb.append(this.f18062b);
        sb.append(str);
        sb.append(C8509F.f18797e);
        sb.append("]");
        C8526n.m20529a("MediaCodecInfo", sb.toString());
    }

    /* renamed from: a */
    private static int m19648a(String name, String mimeType, int maxChannelCount) {
        int assumedMaxChannelCount;
        if (maxChannelCount > 1 || ((C8509F.f18793a >= 26 && maxChannelCount > 0) || "audio/mpeg".equals(mimeType) || "audio/3gpp".equals(mimeType) || "audio/amr-wb".equals(mimeType) || "audio/mp4a-latm".equals(mimeType) || "audio/vorbis".equals(mimeType) || "audio/opus".equals(mimeType) || "audio/raw".equals(mimeType) || "audio/flac".equals(mimeType) || "audio/g711-alaw".equals(mimeType) || "audio/g711-mlaw".equals(mimeType) || "audio/gsm".equals(mimeType))) {
            return maxChannelCount;
        }
        if ("audio/ac3".equals(mimeType)) {
            assumedMaxChannelCount = 6;
        } else if ("audio/eac3".equals(mimeType)) {
            assumedMaxChannelCount = 16;
        } else {
            assumedMaxChannelCount = 30;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("AssumedMaxChannelAdjustment: ");
        sb.append(name);
        sb.append(", [");
        sb.append(maxChannelCount);
        sb.append(" to ");
        sb.append(assumedMaxChannelCount);
        sb.append("]");
        C8526n.m20534d("MediaCodecInfo", sb.toString());
        return assumedMaxChannelCount;
    }

    /* renamed from: a */
    private static boolean m19650a(CodecCapabilities capabilities) {
        return C8509F.f18793a >= 19 && m19653b(capabilities);
    }

    @TargetApi(19)
    /* renamed from: b */
    private static boolean m19653b(CodecCapabilities capabilities) {
        return capabilities.isFeatureSupported("adaptive-playback");
    }

    /* renamed from: e */
    private static boolean m19658e(CodecCapabilities capabilities) {
        return C8509F.f18793a >= 21 && m19659f(capabilities);
    }

    @TargetApi(21)
    /* renamed from: f */
    private static boolean m19659f(CodecCapabilities capabilities) {
        return capabilities.isFeatureSupported("tunneled-playback");
    }

    /* renamed from: c */
    private static boolean m19655c(CodecCapabilities capabilities) {
        return C8509F.f18793a >= 21 && m19657d(capabilities);
    }

    @TargetApi(21)
    /* renamed from: d */
    private static boolean m19657d(CodecCapabilities capabilities) {
        return capabilities.isFeatureSupported("secure-playback");
    }

    @TargetApi(21)
    /* renamed from: a */
    private static boolean m19651a(VideoCapabilities capabilities, int width, int height, double frameRate) {
        if (frameRate == -1.0d || frameRate <= 0.0d) {
            return capabilities.isSizeSupported(width, height);
        }
        return capabilities.areSizeAndRateSupported(width, height, frameRate);
    }
}
