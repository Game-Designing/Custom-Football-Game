package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.C8509F;

/* renamed from: com.google.android.exoplayer2.audio.B */
/* compiled from: WavUtil */
public final class C8110B {

    /* renamed from: a */
    public static final int f16575a = C8509F.m20464b("RIFF");

    /* renamed from: b */
    public static final int f16576b = C8509F.m20464b("WAVE");

    /* renamed from: c */
    public static final int f16577c = C8509F.m20464b("fmt ");

    /* renamed from: d */
    public static final int f16578d = C8509F.m20464b("data");

    /* renamed from: a */
    public static int m18324a(int type, int bitsPerSample) {
        if (type != 1) {
            int i = 0;
            if (type == 3) {
                if (bitsPerSample == 32) {
                    i = 4;
                }
                return i;
            } else if (type != 65534) {
                if (type == 6) {
                    return 536870912;
                }
                if (type != 7) {
                    return 0;
                }
                return 268435456;
            }
        }
        return C8509F.m20470c(bitsPerSample);
    }
}
