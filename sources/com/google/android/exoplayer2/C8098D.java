package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.ads.C8368a;
import com.google.android.exoplayer2.source.ads.C8368a.C8369a;
import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.D */
/* compiled from: Timeline */
public abstract class C8098D {

    /* renamed from: a */
    public static final C8098D f16479a = new C8097C();

    /* renamed from: com.google.android.exoplayer2.D$a */
    /* compiled from: Timeline */
    public static final class C8099a {

        /* renamed from: a */
        public Object f16480a;

        /* renamed from: b */
        public Object f16481b;

        /* renamed from: c */
        public int f16482c;

        /* renamed from: d */
        public long f16483d;

        /* renamed from: e */
        private long f16484e;

        /* renamed from: f */
        private C8368a f16485f;

        /* renamed from: a */
        public C8099a mo24991a(Object id, Object uid, int windowIndex, long durationUs, long positionInWindowUs) {
            mo24992a(id, uid, windowIndex, durationUs, positionInWindowUs, C8368a.f18160a);
            return this;
        }

        /* renamed from: a */
        public C8099a mo24992a(Object id, Object uid, int windowIndex, long durationUs, long positionInWindowUs, C8368a adPlaybackState) {
            this.f16480a = id;
            this.f16481b = uid;
            this.f16482c = windowIndex;
            this.f16483d = durationUs;
            this.f16484e = positionInWindowUs;
            this.f16485f = adPlaybackState;
            return this;
        }

        /* renamed from: c */
        public long mo24998c() {
            return this.f16483d;
        }

        /* renamed from: d */
        public long mo25000d() {
            return C8275d.m19231b(this.f16484e);
        }

        /* renamed from: a */
        public int mo24987a() {
            return this.f16485f.f18161b;
        }

        /* renamed from: b */
        public long mo24996b(int adGroupIndex) {
            return this.f16485f.f18162c[adGroupIndex];
        }

        /* renamed from: c */
        public int mo24997c(int adGroupIndex) {
            return this.f16485f.f18163d[adGroupIndex].mo25661a();
        }

        /* renamed from: b */
        public int mo24993b(int adGroupIndex, int lastPlayedAdIndex) {
            return this.f16485f.f18163d[adGroupIndex].mo25662a(lastPlayedAdIndex);
        }

        /* renamed from: d */
        public boolean mo25001d(int adGroupIndex) {
            return !this.f16485f.f18163d[adGroupIndex].mo25663b();
        }

        /* renamed from: b */
        public int mo24994b(long positionUs) {
            return this.f16485f.mo25658b(positionUs);
        }

        /* renamed from: a */
        public int mo24989a(long positionUs) {
            return this.f16485f.mo25657a(positionUs);
        }

        /* renamed from: a */
        public int mo24988a(int adGroupIndex) {
            return this.f16485f.f18163d[adGroupIndex].f18166a;
        }

        /* renamed from: c */
        public boolean mo24999c(int adGroupIndex, int adIndexInAdGroup) {
            C8369a adGroup = this.f16485f.f18163d[adGroupIndex];
            return (adGroup.f18166a == -1 || adGroup.f18168c[adIndexInAdGroup] == 0) ? false : true;
        }

        /* renamed from: a */
        public long mo24990a(int adGroupIndex, int adIndexInAdGroup) {
            C8369a adGroup = this.f16485f.f18163d[adGroupIndex];
            if (adGroup.f18166a != -1) {
                return adGroup.f18169d[adIndexInAdGroup];
            }
            return -9223372036854775807L;
        }

        /* renamed from: b */
        public long mo24995b() {
            return this.f16485f.f18164e;
        }
    }

    /* renamed from: com.google.android.exoplayer2.D$b */
    /* compiled from: Timeline */
    public static final class C8100b {

        /* renamed from: a */
        public Object f16486a;

        /* renamed from: b */
        public long f16487b;

        /* renamed from: c */
        public long f16488c;

        /* renamed from: d */
        public boolean f16489d;

        /* renamed from: e */
        public boolean f16490e;

        /* renamed from: f */
        public int f16491f;

        /* renamed from: g */
        public int f16492g;

        /* renamed from: h */
        public long f16493h;

        /* renamed from: i */
        public long f16494i;

        /* renamed from: j */
        public long f16495j;

        /* renamed from: a */
        public C8100b mo25003a(Object tag, long presentationStartTimeMs, long windowStartTimeMs, boolean isSeekable, boolean isDynamic, long defaultPositionUs, long durationUs, int firstPeriodIndex, int lastPeriodIndex, long positionInFirstPeriodUs) {
            this.f16486a = tag;
            this.f16487b = presentationStartTimeMs;
            this.f16488c = windowStartTimeMs;
            this.f16489d = isSeekable;
            this.f16490e = isDynamic;
            this.f16493h = defaultPositionUs;
            this.f16494i = durationUs;
            this.f16491f = firstPeriodIndex;
            this.f16492g = lastPeriodIndex;
            this.f16495j = positionInFirstPeriodUs;
            return this;
        }

        /* renamed from: a */
        public long mo25002a() {
            return this.f16493h;
        }

        /* renamed from: b */
        public long mo25004b() {
            return C8275d.m19231b(this.f16494i);
        }

        /* renamed from: c */
        public long mo25005c() {
            return this.f16495j;
        }
    }

    /* renamed from: a */
    public abstract int mo24969a();

    /* renamed from: a */
    public abstract int mo24970a(Object obj);

    /* renamed from: a */
    public abstract C8099a mo24971a(int i, C8099a aVar, boolean z);

    /* renamed from: a */
    public abstract C8100b mo24972a(int i, C8100b bVar, boolean z, long j);

    /* renamed from: a */
    public abstract Object mo24973a(int i);

    /* renamed from: b */
    public abstract int mo24974b();

    /* renamed from: c */
    public final boolean mo24986c() {
        return mo24974b() == 0;
    }

    /* renamed from: a */
    public int mo24975a(int windowIndex, int repeatMode, boolean shuffleModeEnabled) {
        if (repeatMode == 0) {
            return windowIndex == mo24984b(shuffleModeEnabled) ? -1 : windowIndex + 1;
        } else if (repeatMode == 1) {
            return windowIndex;
        } else {
            if (repeatMode == 2) {
                return windowIndex == mo24984b(shuffleModeEnabled) ? mo24977a(shuffleModeEnabled) : windowIndex + 1;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    public int mo24984b(boolean shuffleModeEnabled) {
        if (mo24986c()) {
            return -1;
        }
        return mo24974b() - 1;
    }

    /* renamed from: a */
    public int mo24977a(boolean shuffleModeEnabled) {
        return mo24986c() ? -1 : 0;
    }

    /* renamed from: a */
    public final C8100b mo24982a(int windowIndex, C8100b window) {
        return mo24983a(windowIndex, window, false);
    }

    /* renamed from: a */
    public final C8100b mo24983a(int windowIndex, C8100b window, boolean setTag) {
        return mo24972a(windowIndex, window, setTag, 0);
    }

    /* renamed from: a */
    public final int mo24976a(int periodIndex, C8099a period, C8100b window, int repeatMode, boolean shuffleModeEnabled) {
        int windowIndex = mo24980a(periodIndex, period).f16482c;
        if (mo24982a(windowIndex, window).f16492g != periodIndex) {
            return periodIndex + 1;
        }
        int nextWindowIndex = mo24975a(windowIndex, repeatMode, shuffleModeEnabled);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return mo24982a(nextWindowIndex, window).f16491f;
    }

    /* renamed from: b */
    public final boolean mo24985b(int periodIndex, C8099a period, C8100b window, int repeatMode, boolean shuffleModeEnabled) {
        return mo24976a(periodIndex, period, window, repeatMode, shuffleModeEnabled) == -1;
    }

    /* renamed from: a */
    public final Pair<Object, Long> mo24978a(C8100b window, C8099a period, int windowIndex, long windowPositionUs) {
        return mo24979a(window, period, windowIndex, windowPositionUs, 0);
    }

    /* renamed from: a */
    public final Pair<Object, Long> mo24979a(C8100b window, C8099a period, int windowIndex, long windowPositionUs, long defaultPositionProjectionUs) {
        long windowPositionUs2;
        C8100b bVar = window;
        C8099a aVar = period;
        C8514e.m20485a(windowIndex, 0, mo24974b());
        mo24972a(windowIndex, window, false, defaultPositionProjectionUs);
        if (windowPositionUs == -9223372036854775807L) {
            windowPositionUs2 = window.mo25002a();
            if (windowPositionUs2 == -9223372036854775807L) {
                return null;
            }
        } else {
            windowPositionUs2 = windowPositionUs;
        }
        int periodIndex = bVar.f16491f;
        long periodPositionUs = window.mo25005c() + windowPositionUs2;
        long periodDurationUs = mo24971a(periodIndex, aVar, true).mo24998c();
        while (periodDurationUs != -9223372036854775807L && periodPositionUs >= periodDurationUs && periodIndex < bVar.f16492g) {
            periodPositionUs -= periodDurationUs;
            periodIndex++;
            periodDurationUs = mo24971a(periodIndex, aVar, true).mo24998c();
        }
        return Pair.create(aVar.f16481b, Long.valueOf(periodPositionUs));
    }

    /* renamed from: a */
    public C8099a mo24981a(Object periodUid, C8099a period) {
        return mo24971a(mo24970a(periodUid), period, true);
    }

    /* renamed from: a */
    public final C8099a mo24980a(int periodIndex, C8099a period) {
        return mo24971a(periodIndex, period, false);
    }
}
