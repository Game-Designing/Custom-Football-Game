package com.google.android.exoplayer2.trackselection;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.C8095A;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.C8422a.C8423a;
import com.google.android.exoplayer2.trackselection.C8430g.C8431a;
import com.google.android.exoplayer2.trackselection.C8432h.C8433a;
import com.google.android.exoplayer2.upstream.C8482e;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector extends C8430g {

    /* renamed from: d */
    private static final int[] f18400d = new int[0];

    /* renamed from: e */
    private final C8433a f18401e;

    /* renamed from: f */
    private final AtomicReference<Parameters> f18402f;

    public static final class Parameters implements Parcelable {
        public static final Creator<Parameters> CREATOR = new C8427d();

        /* renamed from: a */
        public static final Parameters f18403a = new Parameters();

        /* renamed from: b */
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> f18404b;

        /* renamed from: c */
        private final SparseBooleanArray f18405c;

        /* renamed from: d */
        public final String f18406d;

        /* renamed from: e */
        public final String f18407e;

        /* renamed from: f */
        public final boolean f18408f;

        /* renamed from: g */
        public final int f18409g;

        /* renamed from: h */
        public final int f18410h;

        /* renamed from: i */
        public final int f18411i;

        /* renamed from: j */
        public final int f18412j;

        /* renamed from: k */
        public final int f18413k;

        /* renamed from: l */
        public final boolean f18414l;

        /* renamed from: m */
        public final int f18415m;

        /* renamed from: n */
        public final int f18416n;

        /* renamed from: o */
        public final boolean f18417o;

        /* renamed from: p */
        public final boolean f18418p;

        /* renamed from: q */
        public final boolean f18419q;

        /* renamed from: r */
        public final boolean f18420r;

        /* renamed from: s */
        public final boolean f18421s;

        /* renamed from: t */
        public final boolean f18422t;

        /* renamed from: u */
        public final int f18423u;

        private Parameters() {
            SparseArray sparseArray = r2;
            SparseArray sparseArray2 = new SparseArray();
            SparseBooleanArray sparseBooleanArray = r3;
            SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
            this(sparseArray, sparseBooleanArray, null, null, false, 0, false, false, false, true, MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT, true, true, MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT, true, 0);
        }

        Parameters(SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides, SparseBooleanArray rendererDisabledFlags, String preferredAudioLanguage, String preferredTextLanguage, boolean selectUndeterminedTextLanguage, int disabledTextTrackSelectionFlags, boolean forceLowestBitrate, boolean forceHighestSupportedBitrate, boolean allowMixedMimeAdaptiveness, boolean allowNonSeamlessAdaptiveness, int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate, boolean exceedVideoConstraintsIfNecessary, boolean exceedRendererCapabilitiesIfNecessary, int viewportWidth, int viewportHeight, boolean viewportOrientationMayChange, int tunnelingAudioSessionId) {
            this.f18404b = selectionOverrides;
            this.f18405c = rendererDisabledFlags;
            this.f18406d = C8509F.m20476e(preferredAudioLanguage);
            this.f18407e = C8509F.m20476e(preferredTextLanguage);
            this.f18408f = selectUndeterminedTextLanguage;
            this.f18409g = disabledTextTrackSelectionFlags;
            this.f18418p = forceLowestBitrate;
            this.f18419q = forceHighestSupportedBitrate;
            this.f18420r = allowMixedMimeAdaptiveness;
            this.f18421s = allowNonSeamlessAdaptiveness;
            this.f18410h = maxVideoWidth;
            this.f18411i = maxVideoHeight;
            this.f18412j = maxVideoFrameRate;
            this.f18413k = maxVideoBitrate;
            this.f18414l = exceedVideoConstraintsIfNecessary;
            this.f18422t = exceedRendererCapabilitiesIfNecessary;
            this.f18415m = viewportWidth;
            this.f18416n = viewportHeight;
            this.f18417o = viewportOrientationMayChange;
            this.f18423u = tunnelingAudioSessionId;
        }

        Parameters(Parcel in) {
            this.f18404b = m20040a(in);
            this.f18405c = in.readSparseBooleanArray();
            this.f18406d = in.readString();
            this.f18407e = in.readString();
            this.f18408f = C8509F.m20454a(in);
            this.f18409g = in.readInt();
            this.f18418p = C8509F.m20454a(in);
            this.f18419q = C8509F.m20454a(in);
            this.f18420r = C8509F.m20454a(in);
            this.f18421s = C8509F.m20454a(in);
            this.f18410h = in.readInt();
            this.f18411i = in.readInt();
            this.f18412j = in.readInt();
            this.f18413k = in.readInt();
            this.f18414l = C8509F.m20454a(in);
            this.f18422t = C8509F.m20454a(in);
            this.f18415m = in.readInt();
            this.f18416n = in.readInt();
            this.f18417o = C8509F.m20454a(in);
            this.f18423u = in.readInt();
        }

        /* renamed from: a */
        public final boolean mo25812a(int rendererIndex) {
            return this.f18405c.get(rendererIndex);
        }

        /* renamed from: b */
        public final boolean mo25813b(int rendererIndex, TrackGroupArray groups) {
            Map<TrackGroupArray, SelectionOverride> overrides = (Map) this.f18404b.get(rendererIndex);
            return overrides != null && overrides.containsKey(groups);
        }

        /* renamed from: a */
        public final SelectionOverride mo25811a(int rendererIndex, TrackGroupArray groups) {
            Map<TrackGroupArray, SelectionOverride> overrides = (Map) this.f18404b.get(rendererIndex);
            if (overrides != null) {
                return (SelectionOverride) overrides.get(groups);
            }
            return null;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Parameters other = (Parameters) obj;
            if (!(this.f18408f == other.f18408f && this.f18409g == other.f18409g && this.f18418p == other.f18418p && this.f18419q == other.f18419q && this.f18420r == other.f18420r && this.f18421s == other.f18421s && this.f18410h == other.f18410h && this.f18411i == other.f18411i && this.f18412j == other.f18412j && this.f18414l == other.f18414l && this.f18422t == other.f18422t && this.f18417o == other.f18417o && this.f18415m == other.f18415m && this.f18416n == other.f18416n && this.f18413k == other.f18413k && this.f18423u == other.f18423u && TextUtils.equals(this.f18406d, other.f18406d) && TextUtils.equals(this.f18407e, other.f18407e) && m20043a(this.f18405c, other.f18405c) && m20042a(this.f18404b, other.f18404b))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            int i;
            int result = ((((((((((((((((((((((((((((((((int) this.f18408f) * true) + this.f18409g) * 31) + (this.f18418p ? 1 : 0)) * 31) + (this.f18419q ? 1 : 0)) * 31) + (this.f18420r ? 1 : 0)) * 31) + (this.f18421s ? 1 : 0)) * 31) + this.f18410h) * 31) + this.f18411i) * 31) + this.f18412j) * 31) + (this.f18414l ? 1 : 0)) * 31) + (this.f18422t ? 1 : 0)) * 31) + (this.f18417o ? 1 : 0)) * 31) + this.f18415m) * 31) + this.f18416n) * 31) + this.f18413k) * 31) + this.f18423u) * 31;
            String str = this.f18406d;
            int i2 = 0;
            if (str == null) {
                i = 0;
            } else {
                i = str.hashCode();
            }
            int result2 = (result + i) * 31;
            String str2 = this.f18407e;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return result2 + i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            m20041a(dest, this.f18404b);
            dest.writeSparseBooleanArray(this.f18405c);
            dest.writeString(this.f18406d);
            dest.writeString(this.f18407e);
            C8509F.m20449a(dest, this.f18408f);
            dest.writeInt(this.f18409g);
            C8509F.m20449a(dest, this.f18418p);
            C8509F.m20449a(dest, this.f18419q);
            C8509F.m20449a(dest, this.f18420r);
            C8509F.m20449a(dest, this.f18421s);
            dest.writeInt(this.f18410h);
            dest.writeInt(this.f18411i);
            dest.writeInt(this.f18412j);
            dest.writeInt(this.f18413k);
            C8509F.m20449a(dest, this.f18414l);
            C8509F.m20449a(dest, this.f18422t);
            dest.writeInt(this.f18415m);
            dest.writeInt(this.f18416n);
            C8509F.m20449a(dest, this.f18417o);
            dest.writeInt(this.f18423u);
        }

        /* renamed from: a */
        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> m20040a(Parcel in) {
            int renderersWithOverridesCount = in.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides = new SparseArray<>(renderersWithOverridesCount);
            for (int i = 0; i < renderersWithOverridesCount; i++) {
                int rendererIndex = in.readInt();
                int overrideCount = in.readInt();
                Map<TrackGroupArray, SelectionOverride> overrides = new HashMap<>(overrideCount);
                for (int j = 0; j < overrideCount; j++) {
                    overrides.put((TrackGroupArray) in.readParcelable(TrackGroupArray.class.getClassLoader()), (SelectionOverride) in.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                selectionOverrides.put(rendererIndex, overrides);
            }
            return selectionOverrides;
        }

        /* renamed from: a */
        private static void m20041a(Parcel dest, SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides) {
            int renderersWithOverridesCount = selectionOverrides.size();
            dest.writeInt(renderersWithOverridesCount);
            for (int i = 0; i < renderersWithOverridesCount; i++) {
                int rendererIndex = selectionOverrides.keyAt(i);
                Map<TrackGroupArray, SelectionOverride> overrides = (Map) selectionOverrides.valueAt(i);
                int overrideCount = overrides.size();
                dest.writeInt(rendererIndex);
                dest.writeInt(overrideCount);
                for (Entry<TrackGroupArray, SelectionOverride> override : overrides.entrySet()) {
                    dest.writeParcelable((Parcelable) override.getKey(), 0);
                    dest.writeParcelable((Parcelable) override.getValue(), 0);
                }
            }
        }

        /* renamed from: a */
        private static boolean m20043a(SparseBooleanArray first, SparseBooleanArray second) {
            int firstSize = first.size();
            if (second.size() != firstSize) {
                return false;
            }
            for (int indexInFirst = 0; indexInFirst < firstSize; indexInFirst++) {
                if (second.indexOfKey(first.keyAt(indexInFirst)) < 0) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        private static boolean m20042a(SparseArray<Map<TrackGroupArray, SelectionOverride>> first, SparseArray<Map<TrackGroupArray, SelectionOverride>> second) {
            int firstSize = first.size();
            if (second.size() != firstSize) {
                return false;
            }
            for (int indexInFirst = 0; indexInFirst < firstSize; indexInFirst++) {
                int indexInSecond = second.indexOfKey(first.keyAt(indexInFirst));
                if (indexInSecond < 0 || !m20044a((Map) first.valueAt(indexInFirst), (Map) second.valueAt(indexInSecond))) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        private static boolean m20044a(Map<TrackGroupArray, SelectionOverride> first, Map<TrackGroupArray, SelectionOverride> second) {
            if (second.size() != first.size()) {
                return false;
            }
            for (Entry<TrackGroupArray, SelectionOverride> firstEntry : first.entrySet()) {
                TrackGroupArray key = (TrackGroupArray) firstEntry.getKey();
                if (second.containsKey(key)) {
                    if (!C8509F.m20455a(firstEntry.getValue(), second.get(key))) {
                    }
                }
                return false;
            }
            return true;
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Creator<SelectionOverride> CREATOR = new C8428e();

        /* renamed from: a */
        public final int f18424a;

        /* renamed from: b */
        public final int[] f18425b;

        /* renamed from: c */
        public final int f18426c;

        public SelectionOverride(int groupIndex, int... tracks) {
            this.f18424a = groupIndex;
            this.f18425b = Arrays.copyOf(tracks, tracks.length);
            this.f18426c = tracks.length;
            Arrays.sort(this.f18425b);
        }

        SelectionOverride(Parcel in) {
            this.f18424a = in.readInt();
            this.f18426c = in.readByte();
            this.f18425b = new int[this.f18426c];
            in.readIntArray(this.f18425b);
        }

        /* renamed from: a */
        public boolean mo25818a(int track) {
            for (int overrideTrack : this.f18425b) {
                if (overrideTrack == track) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f18424a * 31) + Arrays.hashCode(this.f18425b);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SelectionOverride other = (SelectionOverride) obj;
            if (this.f18424a != other.f18424a || !Arrays.equals(this.f18425b, other.f18425b)) {
                z = false;
            }
            return z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f18424a);
            dest.writeInt(this.f18425b.length);
            dest.writeIntArray(this.f18425b);
        }
    }

    /* renamed from: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$a */
    private static final class C8420a {

        /* renamed from: a */
        public final int f18427a;

        /* renamed from: b */
        public final int f18428b;

        /* renamed from: c */
        public final String f18429c;

        public C8420a(int channelCount, int sampleRate, String mimeType) {
            this.f18427a = channelCount;
            this.f18428b = sampleRate;
            this.f18429c = mimeType;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C8420a other = (C8420a) obj;
            if (!(this.f18427a == other.f18427a && this.f18428b == other.f18428b && TextUtils.equals(this.f18429c, other.f18429c))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            int result = ((this.f18427a * 31) + this.f18428b) * 31;
            String str = this.f18429c;
            return result + (str != null ? str.hashCode() : 0);
        }
    }

    /* renamed from: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$b */
    protected static final class C8421b implements Comparable<C8421b> {

        /* renamed from: a */
        private final Parameters f18430a;

        /* renamed from: b */
        private final int f18431b;

        /* renamed from: c */
        private final int f18432c;

        /* renamed from: d */
        private final int f18433d;

        /* renamed from: e */
        private final int f18434e;

        /* renamed from: f */
        private final int f18435f;

        /* renamed from: g */
        private final int f18436g;

        public C8421b(Format format, Parameters parameters, int formatSupport) {
            this.f18430a = parameters;
            int i = 0;
            this.f18431b = DefaultTrackSelector.m20021a(formatSupport, false) ? 1 : 0;
            this.f18432c = DefaultTrackSelector.m20024a(format, parameters.f18406d) ? 1 : 0;
            if ((format.f16525y & 1) != 0) {
                i = 1;
            }
            this.f18433d = i;
            this.f18434e = format.f16520t;
            this.f18435f = format.f16521u;
            this.f18436g = format.f16503c;
        }

        /* renamed from: a */
        public int compareTo(C8421b other) {
            int i = this.f18431b;
            int i2 = other.f18431b;
            if (i != i2) {
                return DefaultTrackSelector.m20032c(i, i2);
            }
            int i3 = this.f18432c;
            int i4 = other.f18432c;
            if (i3 != i4) {
                return DefaultTrackSelector.m20032c(i3, i4);
            }
            int i5 = this.f18433d;
            int i6 = other.f18433d;
            if (i5 != i6) {
                return DefaultTrackSelector.m20032c(i5, i6);
            }
            if (this.f18430a.f18418p) {
                return DefaultTrackSelector.m20032c(other.f18436g, this.f18436g);
            }
            int i7 = 1;
            if (i != 1) {
                i7 = -1;
            }
            int resultSign = i7;
            int i8 = this.f18434e;
            int i9 = other.f18434e;
            if (i8 != i9) {
                return DefaultTrackSelector.m20032c(i8, i9) * resultSign;
            }
            int i10 = this.f18435f;
            int i11 = other.f18435f;
            if (i10 != i11) {
                return DefaultTrackSelector.m20032c(i10, i11) * resultSign;
            }
            return DefaultTrackSelector.m20032c(this.f18436g, other.f18436g) * resultSign;
        }
    }

    public DefaultTrackSelector() {
        this(new C8423a());
    }

    public DefaultTrackSelector(C8433a adaptiveTrackSelectionFactory) {
        this.f18401e = adaptiveTrackSelectionFactory;
        this.f18402f = new AtomicReference<>(Parameters.f18403a);
    }

    /* renamed from: c */
    public Parameters mo25810c() {
        return (Parameters) this.f18402f.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Pair<C8095A[], C8432h[]> mo25806a(C8431a mappedTrackInfo, int[][][] rendererFormatSupports, int[] rendererMixedMimeTypeAdaptationSupports) throws ExoPlaybackException {
        Parameters params = (Parameters) this.f18402f.get();
        int rendererCount = mappedTrackInfo.mo25849a();
        C8432h[] rendererTrackSelections = mo25808a(mappedTrackInfo, rendererFormatSupports, rendererMixedMimeTypeAdaptationSupports, params);
        for (int i = 0; i < rendererCount; i++) {
            if (params.mo25812a(i)) {
                rendererTrackSelections[i] = null;
            } else {
                TrackGroupArray rendererTrackGroups = mappedTrackInfo.mo25854b(i);
                if (params.mo25813b(i, rendererTrackGroups)) {
                    SelectionOverride override = params.mo25811a(i, rendererTrackGroups);
                    if (override == null) {
                        rendererTrackSelections[i] = null;
                    } else if (override.f18426c == 1) {
                        rendererTrackSelections[i] = new C8429f(rendererTrackGroups.mo25651a(override.f18424a), override.f18425b[0]);
                    } else {
                        C8433a aVar = this.f18401e;
                        C8514e.m20486a(aVar);
                        rendererTrackSelections[i] = aVar.mo25830a(rendererTrackGroups.mo25651a(override.f18424a), mo25859a(), override.f18425b);
                    }
                }
            }
        }
        C8095A[] rendererConfigurations = new C8095A[rendererCount];
        for (int i2 = 0; i2 < rendererCount; i2++) {
            rendererConfigurations[i2] = !params.mo25812a(i2) && (mappedTrackInfo.mo25850a(i2) == 6 || rendererTrackSelections[i2] != null) ? C8095A.f16470a : null;
        }
        m20020a(mappedTrackInfo, rendererFormatSupports, rendererConfigurations, rendererTrackSelections, params.f18423u);
        return Pair.create(rendererConfigurations, rendererTrackSelections);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C8432h[] mo25808a(C8431a mappedTrackInfo, int[][][] rendererFormatSupports, int[] rendererMixedMimeTypeAdaptationSupports, Parameters params) throws ExoPlaybackException {
        int i;
        int i2;
        int selectedTextTrackScore;
        int selectedTextRendererIndex;
        C8421b selectedAudioTrackScore;
        int selectedAudioRendererIndex;
        DefaultTrackSelector defaultTrackSelector = this;
        C8431a aVar = mappedTrackInfo;
        Parameters parameters = params;
        int rendererCount = mappedTrackInfo.mo25849a();
        C8432h[] rendererTrackSelections = new C8432h[rendererCount];
        boolean seenVideoRendererWithMappedTracks = false;
        boolean selectedVideoTracks = false;
        int i3 = 0;
        while (true) {
            i = 2;
            i2 = 1;
            if (i3 >= rendererCount) {
                break;
            }
            if (2 == aVar.mo25850a(i3)) {
                boolean z = false;
                if (!selectedVideoTracks) {
                    rendererTrackSelections[i3] = mo25809b(aVar.mo25854b(i3), rendererFormatSupports[i3], rendererMixedMimeTypeAdaptationSupports[i3], params, defaultTrackSelector.f18401e);
                    selectedVideoTracks = rendererTrackSelections[i3] != null;
                }
                if (aVar.mo25854b(i3).f18155b > 0) {
                    z = true;
                }
                seenVideoRendererWithMappedTracks |= z;
            }
            i3++;
        }
        C8421b selectedAudioTrackScore2 = null;
        int i4 = 0;
        int selectedAudioRendererIndex2 = -1;
        int selectedTextTrackScore2 = Integer.MIN_VALUE;
        int selectedTextRendererIndex2 = -1;
        while (i4 < rendererCount) {
            int trackType = aVar.mo25850a(i4);
            if (trackType == i2) {
                TrackGroupArray b = aVar.mo25854b(i4);
                int[][] iArr = rendererFormatSupports[i4];
                int i5 = rendererMixedMimeTypeAdaptationSupports[i4];
                C8433a aVar2 = seenVideoRendererWithMappedTracks ? null : defaultTrackSelector.f18401e;
                int i6 = trackType;
                TrackGroupArray trackGroupArray = b;
                selectedTextRendererIndex = selectedTextRendererIndex2;
                int[][] iArr2 = iArr;
                selectedTextTrackScore = selectedTextTrackScore2;
                selectedAudioRendererIndex = selectedAudioRendererIndex2;
                selectedAudioTrackScore = selectedAudioTrackScore2;
                Pair<TrackSelection, AudioTrackScore> audioSelection = mo25804a(trackGroupArray, iArr2, i5, params, aVar2);
                if (audioSelection != null && (selectedAudioTrackScore == null || ((C8421b) audioSelection.second).compareTo(selectedAudioTrackScore) > 0)) {
                    if (selectedAudioRendererIndex != -1) {
                        rendererTrackSelections[selectedAudioRendererIndex] = null;
                    }
                    rendererTrackSelections[i4] = (C8432h) audioSelection.first;
                    selectedAudioTrackScore2 = (C8421b) audioSelection.second;
                    selectedAudioRendererIndex2 = i4;
                    selectedTextRendererIndex2 = selectedTextRendererIndex;
                    selectedTextTrackScore2 = selectedTextTrackScore;
                    i4++;
                    i = 2;
                    i2 = 1;
                    defaultTrackSelector = this;
                    aVar = mappedTrackInfo;
                }
            } else if (trackType == i) {
                selectedTextRendererIndex = selectedTextRendererIndex2;
                selectedTextTrackScore = selectedTextTrackScore2;
                selectedAudioRendererIndex = selectedAudioRendererIndex2;
                selectedAudioTrackScore = selectedAudioTrackScore2;
            } else if (trackType != 3) {
                rendererTrackSelections[i4] = defaultTrackSelector.mo25807a(trackType, aVar.mo25854b(i4), rendererFormatSupports[i4], parameters);
                selectedTextRendererIndex = selectedTextRendererIndex2;
                selectedTextTrackScore = selectedTextTrackScore2;
                selectedAudioRendererIndex = selectedAudioRendererIndex2;
                selectedAudioTrackScore = selectedAudioTrackScore2;
            } else {
                Pair<TrackSelection, Integer> textSelection = defaultTrackSelector.mo25805a(aVar.mo25854b(i4), rendererFormatSupports[i4], parameters);
                if (textSelection == null || ((Integer) textSelection.second).intValue() <= selectedTextTrackScore2) {
                    selectedTextRendererIndex = selectedTextRendererIndex2;
                    selectedTextTrackScore = selectedTextTrackScore2;
                    selectedAudioRendererIndex = selectedAudioRendererIndex2;
                    selectedAudioTrackScore = selectedAudioTrackScore2;
                } else {
                    if (selectedTextRendererIndex2 != -1) {
                        rendererTrackSelections[selectedTextRendererIndex2] = null;
                    }
                    rendererTrackSelections[i4] = (C8432h) textSelection.first;
                    selectedTextRendererIndex2 = i4;
                    selectedTextTrackScore2 = ((Integer) textSelection.second).intValue();
                    i4++;
                    i = 2;
                    i2 = 1;
                    defaultTrackSelector = this;
                    aVar = mappedTrackInfo;
                }
            }
            selectedAudioRendererIndex2 = selectedAudioRendererIndex;
            selectedAudioTrackScore2 = selectedAudioTrackScore;
            selectedTextRendererIndex2 = selectedTextRendererIndex;
            selectedTextTrackScore2 = selectedTextTrackScore;
            i4++;
            i = 2;
            i2 = 1;
            defaultTrackSelector = this;
            aVar = mappedTrackInfo;
        }
        int i7 = selectedTextRendererIndex2;
        int i8 = selectedTextTrackScore2;
        int i9 = selectedAudioRendererIndex2;
        C8421b bVar = selectedAudioTrackScore2;
        return rendererTrackSelections;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C8432h mo25809b(TrackGroupArray groups, int[][] formatSupports, int mixedMimeTypeAdaptationSupports, Parameters params, C8433a adaptiveTrackSelectionFactory) throws ExoPlaybackException {
        C8432h selection = null;
        if (!params.f18419q && !params.f18418p && adaptiveTrackSelectionFactory != null) {
            selection = m20017a(groups, formatSupports, mixedMimeTypeAdaptationSupports, params, adaptiveTrackSelectionFactory, mo25859a());
        }
        if (selection == null) {
            return m20031b(groups, formatSupports, params);
        }
        return selection;
    }

    /* renamed from: a */
    private static C8432h m20017a(TrackGroupArray groups, int[][] formatSupport, int mixedMimeTypeAdaptationSupports, Parameters params, C8433a adaptiveTrackSelectionFactory, C8482e bandwidthMeter) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray = groups;
        Parameters parameters = params;
        int requiredAdaptiveSupport = parameters.f18421s ? 24 : 16;
        boolean allowMixedMimeTypes = parameters.f18420r && (mixedMimeTypeAdaptationSupports & requiredAdaptiveSupport) != 0;
        for (int i = 0; i < trackGroupArray.f18155b; i++) {
            TrackGroup group = trackGroupArray.mo25651a(i);
            int[] adaptiveTracks = m20028a(group, formatSupport[i], allowMixedMimeTypes, requiredAdaptiveSupport, parameters.f18410h, parameters.f18411i, parameters.f18412j, parameters.f18413k, parameters.f18415m, parameters.f18416n, parameters.f18417o);
            if (adaptiveTracks.length > 0) {
                C8514e.m20486a(adaptiveTrackSelectionFactory);
                return adaptiveTrackSelectionFactory.mo25830a(group, bandwidthMeter, adaptiveTracks);
            }
            C8482e eVar = bandwidthMeter;
        }
        C8482e eVar2 = bandwidthMeter;
        return null;
    }

    /* renamed from: a */
    private static int[] m20028a(TrackGroup group, int[] formatSupport, boolean allowMixedMimeTypes, int requiredAdaptiveSupport, int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate, int viewportWidth, int viewportHeight, boolean viewportOrientationMayChange) {
        String selectedMimeType;
        int i;
        int selectedMimeTypeTrackCount;
        TrackGroup trackGroup = group;
        if (trackGroup.f18151a < 2) {
            return f18400d;
        }
        List<Integer> selectedTrackIndices = m20018a(trackGroup, viewportWidth, viewportHeight, viewportOrientationMayChange);
        if (selectedTrackIndices.size() < 2) {
            return f18400d;
        }
        if (!allowMixedMimeTypes) {
            HashSet hashSet = new HashSet();
            selectedMimeType = null;
            int selectedMimeTypeTrackCount2 = 0;
            int i2 = 0;
            while (i2 < selectedTrackIndices.size()) {
                int trackIndex = ((Integer) selectedTrackIndices.get(i2)).intValue();
                String sampleMimeType = trackGroup.mo25645a(trackIndex).f16507g;
                if (hashSet.add(sampleMimeType)) {
                    String sampleMimeType2 = sampleMimeType;
                    int i3 = trackIndex;
                    selectedMimeTypeTrackCount = selectedMimeTypeTrackCount2;
                    i = i2;
                    int countForMimeType = m20030b(group, formatSupport, requiredAdaptiveSupport, sampleMimeType, maxVideoWidth, maxVideoHeight, maxVideoFrameRate, maxVideoBitrate, selectedTrackIndices);
                    if (countForMimeType > selectedMimeTypeTrackCount) {
                        selectedMimeType = sampleMimeType2;
                        selectedMimeTypeTrackCount2 = countForMimeType;
                        i2 = i + 1;
                    }
                } else {
                    int i4 = trackIndex;
                    selectedMimeTypeTrackCount = selectedMimeTypeTrackCount2;
                    i = i2;
                }
                selectedMimeTypeTrackCount2 = selectedMimeTypeTrackCount;
                i2 = i + 1;
            }
            int i5 = selectedMimeTypeTrackCount2;
            int i6 = i2;
        } else {
            selectedMimeType = null;
        }
        m20019a(group, formatSupport, requiredAdaptiveSupport, selectedMimeType, maxVideoWidth, maxVideoHeight, maxVideoFrameRate, maxVideoBitrate, selectedTrackIndices);
        return selectedTrackIndices.size() < 2 ? f18400d : C8509F.m20457a(selectedTrackIndices);
    }

    /* renamed from: b */
    private static int m20030b(TrackGroup group, int[] formatSupport, int requiredAdaptiveSupport, String mimeType, int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate, List<Integer> selectedTrackIndices) {
        int adaptiveTrackCount = 0;
        for (int i = 0; i < selectedTrackIndices.size(); i++) {
            int trackIndex = ((Integer) selectedTrackIndices.get(i)).intValue();
            TrackGroup trackGroup = group;
            if (m20025a(group.mo25645a(trackIndex), mimeType, formatSupport[trackIndex], requiredAdaptiveSupport, maxVideoWidth, maxVideoHeight, maxVideoFrameRate, maxVideoBitrate)) {
                adaptiveTrackCount++;
            }
        }
        TrackGroup trackGroup2 = group;
        List<Integer> list = selectedTrackIndices;
        return adaptiveTrackCount;
    }

    /* renamed from: a */
    private static void m20019a(TrackGroup group, int[] formatSupport, int requiredAdaptiveSupport, String mimeType, int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate, List<Integer> selectedTrackIndices) {
        List<Integer> list = selectedTrackIndices;
        for (int i = selectedTrackIndices.size() - 1; i >= 0; i--) {
            int trackIndex = ((Integer) list.get(i)).intValue();
            TrackGroup trackGroup = group;
            if (!m20025a(group.mo25645a(trackIndex), mimeType, formatSupport[trackIndex], requiredAdaptiveSupport, maxVideoWidth, maxVideoHeight, maxVideoFrameRate, maxVideoBitrate)) {
                list.remove(i);
            }
        }
        TrackGroup trackGroup2 = group;
    }

    /* renamed from: a */
    private static boolean m20025a(Format format, String mimeType, int formatSupport, int requiredAdaptiveSupport, int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate) {
        if (!m20021a(formatSupport, false) || (formatSupport & requiredAdaptiveSupport) == 0) {
            return false;
        }
        if (mimeType != null && !C8509F.m20455a((Object) format.f16507g, (Object) mimeType)) {
            return false;
        }
        int i = format.f16512l;
        if (i != -1 && i > maxVideoWidth) {
            return false;
        }
        int i2 = format.f16513m;
        if (i2 != -1 && i2 > maxVideoHeight) {
            return false;
        }
        float f = format.f16514n;
        if (f != -1.0f && f > ((float) maxVideoFrameRate)) {
            return false;
        }
        int i3 = format.f16503c;
        if (i3 == -1 || i3 <= maxVideoBitrate) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d2 A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.trackselection.C8432h m20031b(com.google.android.exoplayer2.source.TrackGroupArray r20, int[][] r21, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r22) {
        /*
            r0 = r20
            r1 = r22
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
            r7 = 0
        L_0x000a:
            int r8 = r0.f18155b
            if (r7 >= r8) goto L_0x00de
            com.google.android.exoplayer2.source.TrackGroup r8 = r0.mo25651a(r7)
            int r9 = r1.f18415m
            int r10 = r1.f18416n
            boolean r11 = r1.f18417o
            java.util.List r9 = m20018a(r8, r9, r10, r11)
            r10 = r21[r7]
            r11 = 0
        L_0x001f:
            int r12 = r8.f18151a
            if (r11 >= r12) goto L_0x00d8
            r12 = r10[r11]
            boolean r13 = r1.f18422t
            boolean r12 = m20021a(r12, r13)
            if (r12 == 0) goto L_0x00d2
            com.google.android.exoplayer2.Format r12 = r8.mo25645a(r11)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            boolean r13 = r9.contains(r13)
            if (r13 == 0) goto L_0x0066
            int r13 = r12.f16512l
            r15 = -1
            if (r13 == r15) goto L_0x0045
            int r14 = r1.f18410h
            if (r13 > r14) goto L_0x0066
        L_0x0045:
            int r13 = r12.f16513m
            if (r13 == r15) goto L_0x004d
            int r14 = r1.f18411i
            if (r13 > r14) goto L_0x0066
        L_0x004d:
            float r13 = r12.f16514n
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r14 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r14 == 0) goto L_0x005c
            int r14 = r1.f18412j
            float r14 = (float) r14
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r13 > 0) goto L_0x0066
        L_0x005c:
            int r13 = r12.f16503c
            if (r13 == r15) goto L_0x0064
            int r14 = r1.f18413k
            if (r13 > r14) goto L_0x0066
        L_0x0064:
            r13 = 1
            goto L_0x0067
        L_0x0066:
            r13 = 0
        L_0x0067:
            if (r13 != 0) goto L_0x006f
            boolean r14 = r1.f18414l
            if (r14 != 0) goto L_0x006f
            goto L_0x00d2
        L_0x006f:
            if (r13 == 0) goto L_0x0073
            r15 = 2
            goto L_0x0074
        L_0x0073:
            r15 = 1
        L_0x0074:
            r14 = r15
            r15 = r10[r11]
            r0 = 0
            boolean r15 = m20021a(r15, r0)
            if (r15 == 0) goto L_0x0080
            int r14 = r14 + 1000
        L_0x0080:
            if (r14 <= r4) goto L_0x0085
            r17 = 1
            goto L_0x0087
        L_0x0085:
            r17 = 0
        L_0x0087:
            if (r14 != r4) goto L_0x00c7
            boolean r0 = r1.f18418p
            if (r0 == 0) goto L_0x009d
            int r0 = r12.f16503c
            int r0 = m20029b(r0, r5)
            if (r0 >= 0) goto L_0x0098
            r16 = 1
            goto L_0x009a
        L_0x0098:
            r16 = 0
        L_0x009a:
            r17 = r16
            goto L_0x00c7
        L_0x009d:
            int r0 = r12.mo25006a()
            if (r0 == r6) goto L_0x00ae
            int r18 = m20029b(r0, r6)
            r19 = r18
            r18 = r0
            r0 = r19
            goto L_0x00b6
        L_0x00ae:
            r18 = r0
            int r0 = r12.f16503c
            int r0 = m20029b(r0, r5)
        L_0x00b6:
            if (r15 == 0) goto L_0x00be
            if (r13 == 0) goto L_0x00be
            if (r0 <= 0) goto L_0x00c3
            goto L_0x00c0
        L_0x00be:
            if (r0 >= 0) goto L_0x00c3
        L_0x00c0:
            r16 = 1
            goto L_0x00c5
        L_0x00c3:
            r16 = 0
        L_0x00c5:
            r17 = r16
        L_0x00c7:
            if (r17 == 0) goto L_0x00d2
            r2 = r8
            r3 = r11
            r4 = r14
            int r5 = r12.f16503c
            int r6 = r12.mo25006a()
        L_0x00d2:
            int r11 = r11 + 1
            r0 = r20
            goto L_0x001f
        L_0x00d8:
            int r7 = r7 + 1
            r0 = r20
            goto L_0x000a
        L_0x00de:
            if (r2 != 0) goto L_0x00e2
            r0 = 0
            goto L_0x00e7
        L_0x00e2:
            com.google.android.exoplayer2.trackselection.f r0 = new com.google.android.exoplayer2.trackselection.f
            r0.<init>(r2, r3)
        L_0x00e7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.m20031b(com.google.android.exoplayer2.source.TrackGroupArray, int[][], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2.trackselection.h");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Pair<C8432h, C8421b> mo25804a(TrackGroupArray groups, int[][] formatSupports, int mixedMimeTypeAdaptationSupports, Parameters params, C8433a adaptiveTrackSelectionFactory) throws ExoPlaybackException {
        int selectedTrackIndex = -1;
        int selectedGroupIndex = -1;
        C8421b selectedTrackScore = null;
        for (int groupIndex = 0; groupIndex < groups.f18155b; groupIndex++) {
            TrackGroup trackGroup = groups.mo25651a(groupIndex);
            int[] trackFormatSupport = formatSupports[groupIndex];
            for (int trackIndex = 0; trackIndex < trackGroup.f18151a; trackIndex++) {
                if (m20021a(trackFormatSupport[trackIndex], params.f18422t)) {
                    C8421b trackScore = new C8421b(trackGroup.mo25645a(trackIndex), params, trackFormatSupport[trackIndex]);
                    if (selectedTrackScore == null || trackScore.compareTo(selectedTrackScore) > 0) {
                        selectedGroupIndex = groupIndex;
                        selectedTrackIndex = trackIndex;
                        selectedTrackScore = trackScore;
                    }
                }
            }
        }
        if (selectedGroupIndex == -1) {
            return null;
        }
        TrackGroup selectedGroup = groups.mo25651a(selectedGroupIndex);
        C8432h selection = null;
        if (!params.f18419q && !params.f18418p && adaptiveTrackSelectionFactory != null) {
            int[] adaptiveTracks = m20027a(selectedGroup, formatSupports[selectedGroupIndex], params.f18420r);
            if (adaptiveTracks.length > 0) {
                selection = adaptiveTrackSelectionFactory.mo25830a(selectedGroup, mo25859a(), adaptiveTracks);
            }
        }
        if (selection == null) {
            selection = new C8429f(selectedGroup, selectedTrackIndex);
        }
        C8514e.m20486a(selectedTrackScore);
        return Pair.create(selection, selectedTrackScore);
    }

    /* renamed from: a */
    private static int[] m20027a(TrackGroup group, int[] formatSupport, boolean allowMixedMimeTypes) {
        int selectedConfigurationTrackCount = 0;
        C8420a selectedConfiguration = null;
        HashSet<AudioConfigurationTuple> seenConfigurationTuples = new HashSet<>();
        for (int i = 0; i < group.f18151a; i++) {
            Format format = group.mo25645a(i);
            C8420a configuration = new C8420a(format.f16520t, format.f16521u, allowMixedMimeTypes ? null : format.f16507g);
            if (seenConfigurationTuples.add(configuration)) {
                int configurationCount = m20015a(group, formatSupport, configuration);
                if (configurationCount > selectedConfigurationTrackCount) {
                    selectedConfiguration = configuration;
                    selectedConfigurationTrackCount = configurationCount;
                }
            }
        }
        if (selectedConfigurationTrackCount <= 1) {
            return f18400d;
        }
        int[] adaptiveIndices = new int[selectedConfigurationTrackCount];
        int index = 0;
        for (int i2 = 0; i2 < group.f18151a; i2++) {
            Format a = group.mo25645a(i2);
            int i3 = formatSupport[i2];
            C8514e.m20486a(selectedConfiguration);
            if (m20023a(a, i3, selectedConfiguration)) {
                int index2 = index + 1;
                adaptiveIndices[index] = i2;
                index = index2;
            }
        }
        return adaptiveIndices;
    }

    /* renamed from: a */
    private static int m20015a(TrackGroup group, int[] formatSupport, C8420a configuration) {
        int count = 0;
        for (int i = 0; i < group.f18151a; i++) {
            if (m20023a(group.mo25645a(i), formatSupport[i], configuration)) {
                count++;
            }
        }
        return count;
    }

    /* renamed from: a */
    private static boolean m20023a(Format format, int formatSupport, C8420a configuration) {
        if (!m20021a(formatSupport, false) || format.f16520t != configuration.f18427a || format.f16521u != configuration.f18428b) {
            return false;
        }
        String str = configuration.f18429c;
        if (str == null || TextUtils.equals(str, format.f16507g)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Pair<C8432h, Integer> mo25805a(TrackGroupArray groups, int[][] formatSupport, Parameters params) throws ExoPlaybackException {
        int trackScore;
        int trackScore2;
        TrackGroupArray trackGroupArray = groups;
        Parameters parameters = params;
        TrackGroup selectedGroup = null;
        int selectedTrackIndex = 0;
        int selectedTrackScore = 0;
        int groupIndex = 0;
        while (groupIndex < trackGroupArray.f18155b) {
            TrackGroup trackGroup = trackGroupArray.mo25651a(groupIndex);
            int[] trackFormatSupport = formatSupport[groupIndex];
            int trackIndex = 0;
            while (trackIndex < trackGroup.f18151a) {
                if (m20021a(trackFormatSupport[trackIndex], parameters.f18422t)) {
                    Format format = trackGroup.mo25645a(trackIndex);
                    int maskedSelectionFlags = format.f16525y & (parameters.f18409g ^ -1);
                    boolean isForced = true;
                    boolean isDefault = (maskedSelectionFlags & 1) != 0;
                    if ((maskedSelectionFlags & 2) == 0) {
                        isForced = false;
                    }
                    boolean preferredLanguageFound = m20024a(format, parameters.f18407e);
                    if (preferredLanguageFound || (parameters.f18408f && m20022a(format))) {
                        if (isDefault) {
                            trackScore2 = 8;
                        } else if (!isForced) {
                            trackScore2 = 6;
                        } else {
                            trackScore2 = 4;
                        }
                        trackScore = trackScore2 + (preferredLanguageFound);
                    } else if (isDefault) {
                        trackScore = 3;
                    } else if (isForced) {
                        if (m20024a(format, parameters.f18406d)) {
                            trackScore = 2;
                        } else {
                            trackScore = 1;
                        }
                    }
                    if (m20021a(trackFormatSupport[trackIndex], false)) {
                        trackScore += 1000;
                    }
                    if (trackScore > selectedTrackScore) {
                        selectedGroup = trackGroup;
                        selectedTrackIndex = trackIndex;
                        selectedTrackScore = trackScore;
                    }
                }
                trackIndex++;
                TrackGroupArray trackGroupArray2 = groups;
            }
            groupIndex++;
            trackGroupArray = groups;
        }
        if (selectedGroup == null) {
            return null;
        }
        return Pair.create(new C8429f(selectedGroup, selectedTrackIndex), Integer.valueOf(selectedTrackScore));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C8432h mo25807a(int trackType, TrackGroupArray groups, int[][] formatSupport, Parameters params) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray = groups;
        TrackGroup selectedGroup = null;
        int selectedTrackIndex = 0;
        int selectedTrackScore = 0;
        for (int groupIndex = 0; groupIndex < trackGroupArray.f18155b; groupIndex++) {
            TrackGroup trackGroup = trackGroupArray.mo25651a(groupIndex);
            int[] trackFormatSupport = formatSupport[groupIndex];
            for (int trackIndex = 0; trackIndex < trackGroup.f18151a; trackIndex++) {
                if (m20021a(trackFormatSupport[trackIndex], params.f18422t)) {
                    int trackScore = 1;
                    if ((trackGroup.mo25645a(trackIndex).f16525y & 1) != 0) {
                        trackScore = 2;
                    }
                    if (m20021a(trackFormatSupport[trackIndex], false)) {
                        trackScore += 1000;
                    }
                    if (trackScore > selectedTrackScore) {
                        selectedGroup = trackGroup;
                        selectedTrackIndex = trackIndex;
                        selectedTrackScore = trackScore;
                    }
                }
            }
            Parameters parameters = params;
        }
        Parameters parameters2 = params;
        if (selectedGroup == null) {
            return null;
        }
        return new C8429f(selectedGroup, selectedTrackIndex);
    }

    /* renamed from: a */
    private static void m20020a(C8431a mappedTrackInfo, int[][][] renderererFormatSupports, C8095A[] rendererConfigurations, C8432h[] trackSelections, int tunnelingAudioSessionId) {
        boolean z;
        if (tunnelingAudioSessionId != 0) {
            int tunnelingAudioRendererIndex = -1;
            int tunnelingVideoRendererIndex = -1;
            boolean enableTunneling = true;
            int i = 0;
            while (true) {
                z = true;
                if (i >= mappedTrackInfo.mo25849a()) {
                    break;
                }
                int rendererType = mappedTrackInfo.mo25850a(i);
                C8432h trackSelection = trackSelections[i];
                if ((rendererType == 1 || rendererType == 2) && trackSelection != null && m20026a(renderererFormatSupports[i], mappedTrackInfo.mo25854b(i), trackSelection)) {
                    if (rendererType == 1) {
                        if (tunnelingAudioRendererIndex != -1) {
                            enableTunneling = false;
                            break;
                        }
                        tunnelingAudioRendererIndex = i;
                    } else if (tunnelingVideoRendererIndex != -1) {
                        enableTunneling = false;
                        break;
                    } else {
                        tunnelingVideoRendererIndex = i;
                    }
                }
                i++;
            }
            if (tunnelingAudioRendererIndex == -1 || tunnelingVideoRendererIndex == -1) {
                z = false;
            }
            if (enableTunneling && z) {
                C8095A tunnelingRendererConfiguration = new C8095A(tunnelingAudioSessionId);
                rendererConfigurations[tunnelingAudioRendererIndex] = tunnelingRendererConfiguration;
                rendererConfigurations[tunnelingVideoRendererIndex] = tunnelingRendererConfiguration;
            }
        }
    }

    /* renamed from: a */
    private static boolean m20026a(int[][] formatSupports, TrackGroupArray trackGroups, C8432h selection) {
        if (selection == null) {
            return false;
        }
        int trackGroupIndex = trackGroups.mo25650a(selection.mo25834b());
        for (int i = 0; i < selection.length(); i++) {
            if ((formatSupports[trackGroupIndex][selection.mo25833b(i)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static int m20029b(int first, int second) {
        if (first == -1) {
            return second == -1 ? 0 : -1;
        }
        if (second == -1) {
            return 1;
        }
        return first - second;
    }

    /* renamed from: a */
    protected static boolean m20021a(int formatSupport, boolean allowExceedsCapabilities) {
        int maskedSupport = formatSupport & 7;
        return maskedSupport == 4 || (allowExceedsCapabilities && maskedSupport == 3);
    }

    /* renamed from: a */
    protected static boolean m20022a(Format format) {
        return TextUtils.isEmpty(format.f16526z) || m20024a(format, "und");
    }

    /* renamed from: a */
    protected static boolean m20024a(Format format, String language) {
        return language != null && TextUtils.equals(language, C8509F.m20476e(format.f16526z));
    }

    /* renamed from: a */
    private static List<Integer> m20018a(TrackGroup group, int viewportWidth, int viewportHeight, boolean orientationMayChange) {
        ArrayList<Integer> selectedTrackIndices = new ArrayList<>(group.f18151a);
        for (int i = 0; i < group.f18151a; i++) {
            selectedTrackIndices.add(Integer.valueOf(i));
        }
        if (viewportWidth == Integer.MAX_VALUE || viewportHeight == Integer.MAX_VALUE) {
            return selectedTrackIndices;
        }
        int maxVideoPixelsToRetain = MoPubClientPositioning.NO_REPEAT;
        for (int i2 = 0; i2 < group.f18151a; i2++) {
            Format format = group.mo25645a(i2);
            int i3 = format.f16512l;
            if (i3 > 0) {
                int i4 = format.f16513m;
                if (i4 > 0) {
                    Point maxVideoSizeInViewport = m20016a(orientationMayChange, viewportWidth, viewportHeight, i3, i4);
                    int i5 = format.f16512l;
                    int i6 = format.f16513m;
                    int videoPixels = i5 * i6;
                    if (i5 >= ((int) (((float) maxVideoSizeInViewport.x) * 0.98f)) && i6 >= ((int) (((float) maxVideoSizeInViewport.y) * 0.98f)) && videoPixels < maxVideoPixelsToRetain) {
                        maxVideoPixelsToRetain = videoPixels;
                    }
                }
            }
        }
        if (maxVideoPixelsToRetain != Integer.MAX_VALUE) {
            for (int i7 = selectedTrackIndices.size() - 1; i7 >= 0; i7--) {
                int pixelCount = group.mo25645a(((Integer) selectedTrackIndices.get(i7)).intValue()).mo25006a();
                if (pixelCount == -1 || pixelCount > maxVideoPixelsToRetain) {
                    selectedTrackIndices.remove(i7);
                }
            }
        }
        return selectedTrackIndices;
    }

    /* renamed from: a */
    private static Point m20016a(boolean orientationMayChange, int viewportWidth, int viewportHeight, int videoWidth, int videoHeight) {
        if (orientationMayChange) {
            boolean z = true;
            boolean z2 = videoWidth > videoHeight;
            if (viewportWidth <= viewportHeight) {
                z = false;
            }
            if (z2 != z) {
                int tempViewportWidth = viewportWidth;
                viewportWidth = viewportHeight;
                viewportHeight = tempViewportWidth;
            }
        }
        if (videoWidth * viewportHeight >= videoHeight * viewportWidth) {
            return new Point(viewportWidth, C8509F.m20432a(viewportWidth * videoHeight, videoWidth));
        }
        return new Point(C8509F.m20432a(viewportHeight * videoWidth, videoHeight), viewportHeight);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static int m20032c(int first, int second) {
        if (first > second) {
            return 1;
        }
        return second > first ? -1 : 0;
    }
}
