package com.google.android.exoplayer2.p183b.p186c;

import com.google.android.exoplayer2.p183b.C8172c;
import com.google.android.exoplayer2.p183b.C8266m;

/* renamed from: com.google.android.exoplayer2.b.c.c */
/* compiled from: ConstantBitrateSeeker */
final class C8175c extends C8172c implements C8178a {
    public C8175c(long inputLength, long firstFramePosition, C8266m mpegAudioHeader) {
        super(inputLength, firstFramePosition, mpegAudioHeader.f17508m, mpegAudioHeader.f17505j);
    }

    /* renamed from: b */
    public long mo25237b(long position) {
        return mo25235c(position);
    }

    /* renamed from: c */
    public long mo25238c() {
        return -1;
    }
}
