package com.google.android.exoplayer2.p183b.p189f;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.C8110B;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.f.d */
/* compiled from: WavHeaderReader */
final class C8258d {

    /* renamed from: com.google.android.exoplayer2.b.f.d$a */
    /* compiled from: WavHeaderReader */
    private static final class C8259a {

        /* renamed from: a */
        public final int f17490a;

        /* renamed from: b */
        public final long f17491b;

        private C8259a(int id, long size) {
            this.f17490a = id;
            this.f17491b = size;
        }

        /* renamed from: a */
        public static C8259a m19168a(C8261h input, C8535t scratch) throws IOException, InterruptedException {
            input.mo25241a(scratch.f18861a, 0, 8);
            scratch.mo26118e(0);
            return new C8259a(scratch.mo26119f(), scratch.mo26124j());
        }
    }

    /* renamed from: a */
    public static C8257c m19166a(C8261h input) throws IOException, InterruptedException {
        C8261h hVar = input;
        C8514e.m20486a(input);
        C8535t scratch = new C8535t(16);
        if (C8259a.m19168a(hVar, scratch).f17490a != C8110B.f16575a) {
            return null;
        }
        hVar.mo25241a(scratch.f18861a, 0, 4);
        scratch.mo26118e(0);
        int riffFormat = scratch.mo26119f();
        String str = "WavHeaderReader";
        if (riffFormat != C8110B.f16576b) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported RIFF format: ");
            sb.append(riffFormat);
            C8526n.m20531b(str, sb.toString());
            return null;
        }
        C8259a chunkHeader = C8259a.m19168a(hVar, scratch);
        while (chunkHeader.f17490a != C8110B.f16577c) {
            hVar.mo25240a((int) chunkHeader.f17491b);
            chunkHeader = C8259a.m19168a(hVar, scratch);
        }
        C8514e.m20490b(chunkHeader.f17491b >= 16);
        hVar.mo25241a(scratch.f18861a, 0, 16);
        scratch.mo26118e(0);
        int type = scratch.mo26126l();
        int numChannels = scratch.mo26126l();
        int sampleRateHz = scratch.mo26125k();
        int averageBytesPerSecond = scratch.mo26125k();
        int blockAlignment = scratch.mo26126l();
        int bitsPerSample = scratch.mo26126l();
        int expectedBlockAlignment = (numChannels * bitsPerSample) / 8;
        if (blockAlignment == expectedBlockAlignment) {
            int encoding = C8110B.m18324a(type, bitsPerSample);
            if (encoding == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unsupported WAV format: ");
                sb2.append(bitsPerSample);
                sb2.append(" bit/sample, type ");
                sb2.append(type);
                C8526n.m20531b(str, sb2.toString());
                return null;
            }
            hVar.mo25240a(((int) chunkHeader.f17491b) - 16);
            int i = expectedBlockAlignment;
            int i2 = bitsPerSample;
            int i3 = blockAlignment;
            C8257c cVar = new C8257c(numChannels, sampleRateHz, averageBytesPerSecond, blockAlignment, bitsPerSample, encoding);
            return cVar;
        }
        int expectedBlockAlignment2 = expectedBlockAlignment;
        int i4 = bitsPerSample;
        int blockAlignment2 = blockAlignment;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Expected block alignment: ");
        sb3.append(expectedBlockAlignment2);
        sb3.append("; got: ");
        sb3.append(blockAlignment2);
        throw new ParserException(sb3.toString());
    }

    /* renamed from: a */
    public static void m19167a(C8261h input, C8257c wavHeader) throws IOException, InterruptedException {
        C8514e.m20486a(input);
        C8514e.m20486a(wavHeader);
        input.mo25239a();
        C8535t scratch = new C8535t(8);
        C8259a chunkHeader = C8259a.m19168a(input, scratch);
        while (chunkHeader.f17490a != C8509F.m20464b("data")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring unknown WAV chunk: ");
            sb.append(chunkHeader.f17490a);
            C8526n.m20534d("WavHeaderReader", sb.toString());
            long bytesToSkip = chunkHeader.f17491b + 8;
            if (chunkHeader.f17490a == C8509F.m20464b("RIFF")) {
                bytesToSkip = 12;
            }
            if (bytesToSkip <= 2147483647L) {
                input.mo25248c((int) bytesToSkip);
                chunkHeader = C8259a.m19168a(input, scratch);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                sb2.append(chunkHeader.f17490a);
                throw new ParserException(sb2.toString());
            }
        }
        input.mo25248c(8);
        wavHeader.mo25343a(input.getPosition(), chunkHeader.f17491b);
    }
}
