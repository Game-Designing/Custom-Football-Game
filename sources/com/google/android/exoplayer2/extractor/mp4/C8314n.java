package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.n */
/* compiled from: Track */
public final class C8314n {

    /* renamed from: a */
    public final int f17862a;

    /* renamed from: b */
    public final int f17863b;

    /* renamed from: c */
    public final long f17864c;

    /* renamed from: d */
    public final long f17865d;

    /* renamed from: e */
    public final long f17866e;

    /* renamed from: f */
    public final Format f17867f;

    /* renamed from: g */
    public final int f17868g;

    /* renamed from: h */
    public final long[] f17869h;

    /* renamed from: i */
    public final long[] f17870i;

    /* renamed from: j */
    public final int f17871j;

    /* renamed from: k */
    private final C8315o[] f17872k;

    public C8314n(int id, int type, long timescale, long movieTimescale, long durationUs, Format format, int sampleTransformation, C8315o[] sampleDescriptionEncryptionBoxes, int nalUnitLengthFieldLength, long[] editListDurations, long[] editListMediaTimes) {
        this.f17862a = id;
        this.f17863b = type;
        this.f17864c = timescale;
        this.f17865d = movieTimescale;
        this.f17866e = durationUs;
        this.f17867f = format;
        this.f17868g = sampleTransformation;
        this.f17872k = sampleDescriptionEncryptionBoxes;
        this.f17871j = nalUnitLengthFieldLength;
        this.f17869h = editListDurations;
        this.f17870i = editListMediaTimes;
    }

    /* renamed from: a */
    public C8315o mo25449a(int sampleDescriptionIndex) {
        C8315o[] oVarArr = this.f17872k;
        if (oVarArr == null) {
            return null;
        }
        return oVarArr[sampleDescriptionIndex];
    }
}
