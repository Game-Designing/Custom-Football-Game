package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Log;

@TargetApi(16)
public final class zzpd {

    /* renamed from: a */
    public final String f29080a;

    /* renamed from: b */
    public final boolean f29081b;

    /* renamed from: c */
    public final boolean f29082c;

    /* renamed from: d */
    public final boolean f29083d;

    /* renamed from: e */
    private final String f29084e;

    /* renamed from: f */
    private final CodecCapabilities f29085f;

    /* renamed from: b */
    public static zzpd m30871b(String str) {
        zzpd zzpd = new zzpd(str, null, null, false, false);
        return zzpd;
    }

    /* renamed from: a */
    public static zzpd m30869a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        zzpd zzpd = new zzpd(str, str2, codecCapabilities, z, z2);
        return zzpd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
        if ((com.google.android.gms.internal.ads.zzsy.f29345a >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzpd(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            com.google.android.gms.internal.ads.zzsk.m31078a(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.f29080a = r2
            r1.f29084e = r3
            r1.f29085f = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L_0x0029
            if (r4 == 0) goto L_0x0029
            int r5 = com.google.android.gms.internal.ads.zzsy.f29345a
            r0 = 19
            if (r5 < r0) goto L_0x0024
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x0024
            r5 = 1
            goto L_0x0025
        L_0x0024:
            r5 = 0
        L_0x0025:
            if (r5 == 0) goto L_0x0029
            r5 = 1
            goto L_0x002a
        L_0x0029:
            r5 = 0
        L_0x002a:
            r1.f29081b = r5
            r5 = 21
            if (r4 == 0) goto L_0x0043
            int r0 = com.google.android.gms.internal.ads.zzsy.f29345a
            if (r0 < r5) goto L_0x003e
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            if (r0 == 0) goto L_0x0043
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            r1.f29082c = r0
            if (r6 != 0) goto L_0x005e
            if (r4 == 0) goto L_0x005c
            int r6 = com.google.android.gms.internal.ads.zzsy.f29345a
            if (r6 < r5) goto L_0x0058
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L_0x0058
            r4 = 1
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            if (r4 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r2 = 0
            goto L_0x005f
        L_0x005e:
        L_0x005f:
            r1.f29083d = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpd.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    /* renamed from: a */
    public final CodecProfileLevel[] mo32077a() {
        CodecCapabilities codecCapabilities = this.f29085f;
        if (codecCapabilities != null) {
            CodecProfileLevel[] codecProfileLevelArr = codecCapabilities.profileLevels;
            if (codecProfileLevelArr != null) {
                return codecProfileLevelArr;
            }
        }
        return new CodecProfileLevel[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c9  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo32076a(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            if (r12 == 0) goto L_0x015d
            java.lang.String r1 = r11.f29084e
            if (r1 != 0) goto L_0x0009
            goto L_0x015d
        L_0x0009:
            if (r12 == 0) goto L_0x00c4
            java.lang.String r1 = r12.trim()
            java.lang.String r2 = "avc1"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00c1
            java.lang.String r2 = "avc3"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0022
            goto L_0x00c1
        L_0x0022:
            java.lang.String r2 = "hev1"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00be
            java.lang.String r2 = "hvc1"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0034
            goto L_0x00be
        L_0x0034:
            java.lang.String r2 = "vp9"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0040
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            goto L_0x00c5
        L_0x0040:
            java.lang.String r2 = "vp8"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x004c
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            goto L_0x00c5
        L_0x004c:
            java.lang.String r2 = "mp4a"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0058
            java.lang.String r1 = "audio/mp4a-latm"
            goto L_0x00c5
        L_0x0058:
            java.lang.String r2 = "ac-3"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00bb
            java.lang.String r2 = "dac3"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0069
            goto L_0x00bb
        L_0x0069:
            java.lang.String r2 = "ec-3"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00b8
            java.lang.String r2 = "dec3"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x007a
            goto L_0x00b8
        L_0x007a:
            java.lang.String r2 = "dtsc"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00b5
            java.lang.String r2 = "dtse"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x008b
            goto L_0x00b5
        L_0x008b:
            java.lang.String r2 = "dtsh"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00b2
            java.lang.String r2 = "dtsl"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x009c
            goto L_0x00b2
        L_0x009c:
            java.lang.String r2 = "opus"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x00a7
            java.lang.String r1 = "audio/opus"
            goto L_0x00c5
        L_0x00a7:
            java.lang.String r2 = "vorbis"
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L_0x00c4
            java.lang.String r1 = "audio/vorbis"
            goto L_0x00c5
        L_0x00b2:
            java.lang.String r1 = "audio/vnd.dts.hd"
            goto L_0x00c5
        L_0x00b5:
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x00c5
        L_0x00b8:
            java.lang.String r1 = "audio/eac3"
            goto L_0x00c5
        L_0x00bb:
            java.lang.String r1 = "audio/ac3"
            goto L_0x00c5
        L_0x00be:
            java.lang.String r1 = "video/hevc"
            goto L_0x00c5
        L_0x00c1:
            java.lang.String r1 = "video/avc"
            goto L_0x00c5
        L_0x00c4:
            r1 = 0
        L_0x00c5:
            if (r1 != 0) goto L_0x00c9
            return r0
        L_0x00c9:
            java.lang.String r2 = r11.f29084e
            boolean r2 = r2.equals(r1)
            java.lang.String r3 = ", "
            r4 = 0
            if (r2 != 0) goto L_0x0102
            java.lang.String r0 = java.lang.String.valueOf(r12)
            int r0 = r0.length()
            int r0 = r0 + 13
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "codec.mime "
            r2.append(r0)
            r2.append(r12)
            r2.append(r3)
            r2.append(r1)
            java.lang.String r12 = r2.toString()
            r11.m30872c(r12)
            return r4
        L_0x0102:
            android.util.Pair r2 = com.google.android.gms.internal.ads.zzpi.m30909a(r12)
            if (r2 != 0) goto L_0x0109
            return r0
        L_0x0109:
            android.media.MediaCodecInfo$CodecProfileLevel[] r5 = r11.mo32077a()
            int r6 = r5.length
            r7 = 0
        L_0x010f:
            if (r7 >= r6) goto L_0x012f
            r8 = r5[r7]
            int r9 = r8.profile
            java.lang.Object r10 = r2.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r9 != r10) goto L_0x012c
            int r8 = r8.level
            java.lang.Object r9 = r2.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r8 < r9) goto L_0x012c
            return r0
        L_0x012c:
            int r7 = r7 + 1
            goto L_0x010f
        L_0x012f:
            java.lang.String r0 = java.lang.String.valueOf(r12)
            int r0 = r0.length()
            int r0 = r0 + 22
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "codec.profileLevel, "
            r2.append(r0)
            r2.append(r12)
            r2.append(r3)
            r2.append(r1)
            java.lang.String r12 = r2.toString()
            r11.m30872c(r12)
            return r4
        L_0x015d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpd.mo32076a(java.lang.String):boolean");
    }

    @TargetApi(21)
    /* renamed from: a */
    public final boolean mo32075a(int i, int i2, double d) {
        CodecCapabilities codecCapabilities = this.f29085f;
        if (codecCapabilities == null) {
            m30872c("sizeAndRate.caps");
            return false;
        }
        VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            m30872c("sizeAndRate.vCaps");
            return false;
        }
        if (!m30870a(videoCapabilities, i, i2, d)) {
            String str = "x";
            if (i >= i2 || !m30870a(videoCapabilities, i2, i, d)) {
                StringBuilder sb = new StringBuilder(69);
                sb.append("sizeAndRate.support, ");
                sb.append(i);
                sb.append(str);
                sb.append(i2);
                sb.append(str);
                sb.append(d);
                m30872c(sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("sizeAndRate.rotated, ");
            sb2.append(i);
            sb2.append(str);
            sb2.append(i2);
            sb2.append(str);
            sb2.append(d);
            String sb3 = sb2.toString();
            String str2 = this.f29080a;
            String str3 = this.f29084e;
            String str4 = zzsy.f29349e;
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
            sb4.append("AssumedSupport [");
            sb4.append(sb3);
            String str5 = "] [";
            sb4.append(str5);
            sb4.append(str2);
            sb4.append(", ");
            sb4.append(str3);
            sb4.append(str5);
            sb4.append(str4);
            sb4.append("]");
            Log.d("MediaCodecInfo", sb4.toString());
        }
        return true;
    }

    @TargetApi(21)
    /* renamed from: a */
    public final Point mo32073a(int i, int i2) {
        CodecCapabilities codecCapabilities = this.f29085f;
        if (codecCapabilities == null) {
            m30872c("align.caps");
            return null;
        }
        VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            m30872c("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzsy.m31145a(i, widthAlignment) * widthAlignment, zzsy.m31145a(i2, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    /* renamed from: a */
    public final boolean mo32074a(int i) {
        CodecCapabilities codecCapabilities = this.f29085f;
        if (codecCapabilities == null) {
            m30872c("sampleRate.caps");
            return false;
        }
        AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            m30872c("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder(31);
            sb.append("sampleRate.support, ");
            sb.append(i);
            m30872c(sb.toString());
            return false;
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    public final boolean mo32078b(int i) {
        CodecCapabilities codecCapabilities = this.f29085f;
        if (codecCapabilities == null) {
            m30872c("channelCount.caps");
            return false;
        }
        AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            m30872c("channelCount.aCaps");
            return false;
        } else if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder(33);
            sb.append("channelCount.support, ");
            sb.append(i);
            m30872c(sb.toString());
            return false;
        }
    }

    /* renamed from: c */
    private final void m30872c(String str) {
        String str2 = this.f29080a;
        String str3 = this.f29084e;
        String str4 = zzsy.f29349e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        String str5 = "] [";
        sb.append(str5);
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(str5);
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    /* renamed from: a */
    private static boolean m30870a(VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }
}
