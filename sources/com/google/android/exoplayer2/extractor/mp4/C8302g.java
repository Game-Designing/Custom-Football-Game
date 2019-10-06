package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.C8509F;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.g */
/* compiled from: FixedSampleSizeRechunker */
final class C8302g {

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.g$a */
    /* compiled from: FixedSampleSizeRechunker */
    public static final class C8303a {

        /* renamed from: a */
        public final long[] f17748a;

        /* renamed from: b */
        public final int[] f17749b;

        /* renamed from: c */
        public final int f17750c;

        /* renamed from: d */
        public final long[] f17751d;

        /* renamed from: e */
        public final int[] f17752e;

        /* renamed from: f */
        public final long f17753f;

        private C8303a(long[] offsets, int[] sizes, int maximumSize, long[] timestamps, int[] flags, long duration) {
            this.f17748a = offsets;
            this.f17749b = sizes;
            this.f17750c = maximumSize;
            this.f17751d = timestamps;
            this.f17752e = flags;
            this.f17753f = duration;
        }
    }

    /* renamed from: a */
    public static C8303a m19332a(int fixedSampleSize, long[] chunkOffsets, int[] chunkSampleCounts, long timestampDeltaInTimeUnits) {
        int[] iArr = chunkSampleCounts;
        int maxSampleCount = Opcodes.ACC_ANNOTATION / fixedSampleSize;
        int rechunkedSampleCount = 0;
        for (int chunkSampleCount : iArr) {
            rechunkedSampleCount += C8509F.m20432a(chunkSampleCount, maxSampleCount);
        }
        long[] offsets = new long[rechunkedSampleCount];
        int[] sizes = new int[rechunkedSampleCount];
        long[] timestamps = new long[rechunkedSampleCount];
        int[] flags = new int[rechunkedSampleCount];
        int chunkIndex = 0;
        int maximumSize = 0;
        int originalSampleIndex = 0;
        int newSampleIndex = 0;
        while (chunkIndex < iArr.length) {
            int chunkSamplesRemaining = iArr[chunkIndex];
            long sampleOffset = chunkOffsets[chunkIndex];
            int maximumSize2 = maximumSize;
            while (chunkSamplesRemaining > 0) {
                int bufferSampleCount = Math.min(maxSampleCount, chunkSamplesRemaining);
                offsets[newSampleIndex] = sampleOffset;
                sizes[newSampleIndex] = fixedSampleSize * bufferSampleCount;
                maximumSize2 = Math.max(maximumSize2, sizes[newSampleIndex]);
                timestamps[newSampleIndex] = ((long) originalSampleIndex) * timestampDeltaInTimeUnits;
                flags[newSampleIndex] = 1;
                sampleOffset += (long) sizes[newSampleIndex];
                originalSampleIndex += bufferSampleCount;
                chunkSamplesRemaining -= bufferSampleCount;
                newSampleIndex++;
            }
            chunkIndex++;
            maximumSize = maximumSize2;
        }
        int i = originalSampleIndex;
        C8303a aVar = new C8303a(offsets, sizes, maximumSize, timestamps, flags, timestampDeltaInTimeUnits * ((long) originalSampleIndex));
        return aVar;
    }
}
