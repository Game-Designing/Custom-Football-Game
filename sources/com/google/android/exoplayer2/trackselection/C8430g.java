package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.C8095A;
import com.google.android.exoplayer2.C8573z;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.trackselection.g */
/* compiled from: MappingTrackSelector */
public abstract class C8430g extends C8435j {

    /* renamed from: c */
    private C8431a f18465c;

    /* renamed from: com.google.android.exoplayer2.trackselection.g$a */
    /* compiled from: MappingTrackSelector */
    public static final class C8431a {
        @Deprecated

        /* renamed from: a */
        public final int f18466a = this.f18467b;

        /* renamed from: b */
        private final int f18467b;

        /* renamed from: c */
        private final int[] f18468c;

        /* renamed from: d */
        private final TrackGroupArray[] f18469d;

        /* renamed from: e */
        private final int[] f18470e;

        /* renamed from: f */
        private final int[][][] f18471f;

        /* renamed from: g */
        private final TrackGroupArray f18472g;

        C8431a(int[] rendererTrackTypes, TrackGroupArray[] rendererTrackGroups, int[] rendererMixedMimeTypeAdaptiveSupports, int[][][] rendererFormatSupports, TrackGroupArray unmappedTrackGroups) {
            this.f18468c = rendererTrackTypes;
            this.f18469d = rendererTrackGroups;
            this.f18471f = rendererFormatSupports;
            this.f18470e = rendererMixedMimeTypeAdaptiveSupports;
            this.f18472g = unmappedTrackGroups;
            this.f18467b = rendererTrackTypes.length;
        }

        /* renamed from: a */
        public int mo25849a() {
            return this.f18467b;
        }

        /* renamed from: a */
        public int mo25850a(int rendererIndex) {
            return this.f18468c[rendererIndex];
        }

        /* renamed from: b */
        public TrackGroupArray mo25854b(int rendererIndex) {
            return this.f18469d[rendererIndex];
        }

        /* renamed from: a */
        public int mo25851a(int rendererIndex, int groupIndex, int trackIndex) {
            return this.f18471f[rendererIndex][groupIndex][trackIndex] & 7;
        }

        /* renamed from: a */
        public int mo25852a(int rendererIndex, int groupIndex, boolean includeCapabilitiesExceededTracks) {
            int trackCount = this.f18469d[rendererIndex].mo25651a(groupIndex).f18151a;
            int[] trackIndices = new int[trackCount];
            int trackIndexCount = 0;
            for (int i = 0; i < trackCount; i++) {
                int fixedSupport = mo25851a(rendererIndex, groupIndex, i);
                if (fixedSupport == 4 || (includeCapabilitiesExceededTracks && fixedSupport == 3)) {
                    int trackIndexCount2 = trackIndexCount + 1;
                    trackIndices[trackIndexCount] = i;
                    trackIndexCount = trackIndexCount2;
                }
            }
            return mo25853a(rendererIndex, groupIndex, Arrays.copyOf(trackIndices, trackIndexCount));
        }

        /* renamed from: a */
        public int mo25853a(int rendererIndex, int groupIndex, int[] trackIndices) {
            int handledTrackCount = 0;
            int adaptiveSupport = 16;
            boolean multipleMimeTypes = false;
            Object obj = null;
            int i = 0;
            while (i < trackIndices.length) {
                String sampleMimeType = this.f18469d[rendererIndex].mo25651a(groupIndex).mo25645a(trackIndices[i]).f16507g;
                int handledTrackCount2 = handledTrackCount + 1;
                if (handledTrackCount == 0) {
                    obj = sampleMimeType;
                } else {
                    multipleMimeTypes = (!C8509F.m20455a(obj, (Object) sampleMimeType)) | multipleMimeTypes;
                }
                adaptiveSupport = Math.min(adaptiveSupport, this.f18471f[rendererIndex][groupIndex][i] & 24);
                i++;
                handledTrackCount = handledTrackCount2;
            }
            return multipleMimeTypes ? Math.min(adaptiveSupport, this.f18470e[rendererIndex]) : adaptiveSupport;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Pair<C8095A[], C8432h[]> mo25806a(C8431a aVar, int[][][] iArr, int[] iArr2) throws ExoPlaybackException;

    /* renamed from: b */
    public final C8431a mo25848b() {
        return this.f18465c;
    }

    /* renamed from: a */
    public final void mo25847a(Object info) {
        this.f18465c = (C8431a) info;
    }

    /* renamed from: a */
    public final C8437k mo25846a(C8573z[] rendererCapabilities, TrackGroupArray trackGroups) throws ExoPlaybackException {
        int[] rendererFormatSupport;
        C8573z[] zVarArr = rendererCapabilities;
        TrackGroupArray trackGroupArray = trackGroups;
        int[] rendererTrackGroupCounts = new int[(zVarArr.length + 1)];
        TrackGroup[][] rendererTrackGroups = new TrackGroup[(zVarArr.length + 1)][];
        int[][][] rendererFormatSupports = new int[(zVarArr.length + 1)][][];
        for (int i = 0; i < rendererTrackGroups.length; i++) {
            int i2 = trackGroupArray.f18155b;
            rendererTrackGroups[i] = new TrackGroup[i2];
            rendererFormatSupports[i] = new int[i2][];
        }
        int[] rendererMixedMimeTypeAdaptationSupports = m20068a(rendererCapabilities);
        for (int groupIndex = 0; groupIndex < trackGroupArray.f18155b; groupIndex++) {
            TrackGroup group = trackGroupArray.mo25651a(groupIndex);
            int rendererIndex = m20066a(zVarArr, group);
            if (rendererIndex == zVarArr.length) {
                rendererFormatSupport = new int[group.f18151a];
            } else {
                rendererFormatSupport = m20067a(zVarArr[rendererIndex], group);
            }
            int rendererTrackGroupCount = rendererTrackGroupCounts[rendererIndex];
            rendererTrackGroups[rendererIndex][rendererTrackGroupCount] = group;
            rendererFormatSupports[rendererIndex][rendererTrackGroupCount] = rendererFormatSupport;
            rendererTrackGroupCounts[rendererIndex] = rendererTrackGroupCounts[rendererIndex] + 1;
        }
        TrackGroupArray[] rendererTrackGroupArrays = new TrackGroupArray[zVarArr.length];
        int[] rendererTrackTypes = new int[zVarArr.length];
        for (int i3 = 0; i3 < zVarArr.length; i3++) {
            int rendererTrackGroupCount2 = rendererTrackGroupCounts[i3];
            rendererTrackGroupArrays[i3] = new TrackGroupArray((TrackGroup[]) C8509F.m20459a((T[]) rendererTrackGroups[i3], rendererTrackGroupCount2));
            rendererFormatSupports[i3] = (int[][]) C8509F.m20459a((T[]) rendererFormatSupports[i3], rendererTrackGroupCount2);
            rendererTrackTypes[i3] = zVarArr[i3].mo25372d();
        }
        int[] iArr = rendererTrackTypes;
        TrackGroupArray[] trackGroupArrayArr = rendererTrackGroupArrays;
        int[] iArr2 = rendererMixedMimeTypeAdaptationSupports;
        int[][][] iArr3 = rendererFormatSupports;
        C8431a mappedTrackInfo = new C8431a(iArr, trackGroupArrayArr, iArr2, iArr3, new TrackGroupArray((TrackGroup[]) C8509F.m20459a((T[]) rendererTrackGroups[zVarArr.length], rendererTrackGroupCounts[zVarArr.length])));
        Pair<RendererConfiguration[], TrackSelection[]> result = mo25806a(mappedTrackInfo, rendererFormatSupports, rendererMixedMimeTypeAdaptationSupports);
        return new C8437k((C8095A[]) result.first, (C8432h[]) result.second, mappedTrackInfo);
    }

    /* renamed from: a */
    private static int m20066a(C8573z[] rendererCapabilities, TrackGroup group) throws ExoPlaybackException {
        int bestRendererIndex = rendererCapabilities.length;
        int bestFormatSupportLevel = 0;
        for (int rendererIndex = 0; rendererIndex < rendererCapabilities.length; rendererIndex++) {
            C8573z rendererCapability = rendererCapabilities[rendererIndex];
            for (int trackIndex = 0; trackIndex < group.f18151a; trackIndex++) {
                int formatSupportLevel = rendererCapability.mo25507a(group.mo25645a(trackIndex)) & 7;
                if (formatSupportLevel > bestFormatSupportLevel) {
                    bestRendererIndex = rendererIndex;
                    bestFormatSupportLevel = formatSupportLevel;
                    if (bestFormatSupportLevel == 4) {
                        return bestRendererIndex;
                    }
                }
            }
        }
        return bestRendererIndex;
    }

    /* renamed from: a */
    private static int[] m20067a(C8573z rendererCapabilities, TrackGroup group) throws ExoPlaybackException {
        int[] formatSupport = new int[group.f18151a];
        for (int i = 0; i < group.f18151a; i++) {
            formatSupport[i] = rendererCapabilities.mo25507a(group.mo25645a(i));
        }
        return formatSupport;
    }

    /* renamed from: a */
    private static int[] m20068a(C8573z[] rendererCapabilities) throws ExoPlaybackException {
        int[] mixedMimeTypeAdaptationSupport = new int[rendererCapabilities.length];
        for (int i = 0; i < mixedMimeTypeAdaptationSupport.length; i++) {
            mixedMimeTypeAdaptationSupport[i] = rendererCapabilities[i].mo25512m();
        }
        return mixedMimeTypeAdaptationSupport;
    }
}
