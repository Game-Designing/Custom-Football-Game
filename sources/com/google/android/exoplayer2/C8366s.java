package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.C8098D.C8099a;
import com.google.android.exoplayer2.C8098D.C8100b;
import com.google.android.exoplayer2.source.C8393q;
import com.google.android.exoplayer2.source.C8395r;
import com.google.android.exoplayer2.source.C8395r.C8396a;
import com.google.android.exoplayer2.trackselection.C8435j;
import com.google.android.exoplayer2.upstream.C8481d;
import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.s */
/* compiled from: MediaPeriodQueue */
final class C8366s {

    /* renamed from: a */
    private final C8099a f18139a = new C8099a();

    /* renamed from: b */
    private final C8100b f18140b = new C8100b();

    /* renamed from: c */
    private long f18141c;

    /* renamed from: d */
    private C8098D f18142d = C8098D.f16479a;

    /* renamed from: e */
    private int f18143e;

    /* renamed from: f */
    private boolean f18144f;

    /* renamed from: g */
    private C8364q f18145g;

    /* renamed from: h */
    private C8364q f18146h;

    /* renamed from: i */
    private C8364q f18147i;

    /* renamed from: j */
    private int f18148j;

    /* renamed from: k */
    private Object f18149k;

    /* renamed from: l */
    private long f18150l;

    /* renamed from: a */
    public void mo25630a(C8098D timeline) {
        this.f18142d = timeline;
    }

    /* renamed from: a */
    public boolean mo25632a(int repeatMode) {
        this.f18143e = repeatMode;
        return m19751i();
    }

    /* renamed from: b */
    public boolean mo25637b(boolean shuffleModeEnabled) {
        this.f18144f = shuffleModeEnabled;
        return m19751i();
    }

    /* renamed from: a */
    public boolean mo25634a(C8393q mediaPeriod) {
        C8364q qVar = this.f18147i;
        return qVar != null && qVar.f18118a == mediaPeriod;
    }

    /* renamed from: a */
    public void mo25629a(long rendererPositionUs) {
        C8364q qVar = this.f18147i;
        if (qVar != null) {
            qVar.mo25615b(rendererPositionUs);
        }
    }

    /* renamed from: h */
    public boolean mo25643h() {
        C8364q qVar = this.f18147i;
        return qVar == null || (!qVar.f18124g.f18138f && qVar.mo25621e() && this.f18147i.f18124g.f18136d != -9223372036854775807L && this.f18148j < 100);
    }

    /* renamed from: a */
    public C8365r mo25625a(long rendererPositionUs, C8414t playbackInfo) {
        C8364q qVar = this.f18147i;
        if (qVar == null) {
            return m19744a(playbackInfo);
        }
        return m19742a(qVar, rendererPositionUs);
    }

    /* renamed from: a */
    public C8393q mo25627a(C8573z[] rendererCapabilities, C8435j trackSelector, C8481d allocator, C8395r mediaSource, C8365r info) {
        long rendererPositionOffsetUs;
        C8364q qVar = this.f18147i;
        if (qVar == null) {
            rendererPositionOffsetUs = info.f18134b;
        } else {
            rendererPositionOffsetUs = qVar.mo25617c() + this.f18147i.f18124g.f18136d;
        }
        C8364q qVar2 = new C8364q(rendererCapabilities, rendererPositionOffsetUs, trackSelector, allocator, mediaSource, info);
        if (this.f18147i != null) {
            C8514e.m20490b(mo25642g());
            this.f18147i.f18125h = qVar2;
        }
        this.f18149k = null;
        this.f18147i = qVar2;
        this.f18148j++;
        return qVar2.f18118a;
    }

    /* renamed from: d */
    public C8364q mo25639d() {
        return this.f18147i;
    }

    /* renamed from: e */
    public C8364q mo25640e() {
        return this.f18145g;
    }

    /* renamed from: f */
    public C8364q mo25641f() {
        return this.f18146h;
    }

    /* renamed from: c */
    public C8364q mo25638c() {
        return mo25642g() ? this.f18145g : this.f18147i;
    }

    /* renamed from: g */
    public boolean mo25642g() {
        return this.f18145g != null;
    }

    /* renamed from: b */
    public C8364q mo25636b() {
        C8364q qVar = this.f18146h;
        C8514e.m20490b((qVar == null || qVar.f18125h == null) ? false : true);
        this.f18146h = this.f18146h.f18125h;
        return this.f18146h;
    }

    /* renamed from: a */
    public C8364q mo25624a() {
        C8364q qVar = this.f18145g;
        if (qVar != null) {
            if (qVar == this.f18146h) {
                this.f18146h = qVar.f18125h;
            }
            this.f18145g.mo25622f();
            this.f18148j--;
            if (this.f18148j == 0) {
                this.f18147i = null;
                C8364q qVar2 = this.f18145g;
                this.f18149k = qVar2.f18119b;
                this.f18150l = qVar2.f18124g.f18133a.f18291d;
            }
            this.f18145g = this.f18145g.f18125h;
        } else {
            C8364q qVar3 = this.f18147i;
            this.f18145g = qVar3;
            this.f18146h = qVar3;
        }
        return this.f18145g;
    }

    /* renamed from: a */
    public boolean mo25633a(C8364q mediaPeriodHolder) {
        C8514e.m20490b(mediaPeriodHolder != null);
        boolean removedReading = false;
        this.f18147i = mediaPeriodHolder;
        while (mediaPeriodHolder.f18125h != null) {
            mediaPeriodHolder = mediaPeriodHolder.f18125h;
            if (mediaPeriodHolder == this.f18146h) {
                this.f18146h = this.f18145g;
                removedReading = true;
            }
            mediaPeriodHolder.mo25622f();
            this.f18148j--;
        }
        this.f18147i.f18125h = null;
        return removedReading;
    }

    /* renamed from: a */
    public void mo25631a(boolean keepFrontPeriodUid) {
        C8364q front = mo25638c();
        if (front != null) {
            this.f18149k = keepFrontPeriodUid ? front.f18119b : null;
            this.f18150l = front.f18124g.f18133a.f18291d;
            front.mo25622f();
            mo25633a(front);
        } else if (!keepFrontPeriodUid) {
            this.f18149k = null;
        }
        this.f18145g = null;
        this.f18147i = null;
        this.f18146h = null;
        this.f18148j = 0;
    }

    /* renamed from: a */
    public boolean mo25635a(C8396a playingPeriodId, long rendererPositionUs) {
        int periodIndex = this.f18142d.mo24970a(playingPeriodId.f18288a);
        C8364q previousPeriodHolder = null;
        for (C8364q periodHolder = mo25638c(); periodHolder != null; periodHolder = periodHolder.f18125h) {
            if (previousPeriodHolder == null) {
                periodHolder.f18124g = mo25626a(periodHolder.f18124g);
            } else if (periodIndex == -1 || !periodHolder.f18119b.equals(this.f18142d.mo24973a(periodIndex))) {
                return true ^ mo25633a(previousPeriodHolder);
            } else {
                C8365r periodInfo = m19742a(previousPeriodHolder, rendererPositionUs);
                if (periodInfo == null) {
                    return true ^ mo25633a(previousPeriodHolder);
                }
                periodHolder.f18124g = mo25626a(periodHolder.f18124g);
                if (!m19747a(periodHolder, periodInfo)) {
                    return true ^ mo25633a(previousPeriodHolder);
                }
            }
            if (periodHolder.f18124g.f18137e) {
                periodIndex = this.f18142d.mo24976a(periodIndex, this.f18139a, this.f18140b, this.f18143e, this.f18144f);
            }
            previousPeriodHolder = periodHolder;
        }
        return true;
    }

    /* renamed from: a */
    public C8365r mo25626a(C8365r info) {
        long durationUs;
        boolean isLastInPeriod = m19748a(info.f18133a);
        boolean isLastInTimeline = m19749a(info.f18133a, isLastInPeriod);
        this.f18142d.mo24981a(info.f18133a.f18288a, this.f18139a);
        if (info.f18133a.mo25724a()) {
            C8099a aVar = this.f18139a;
            C8396a aVar2 = info.f18133a;
            durationUs = aVar.mo24990a(aVar2.f18289b, aVar2.f18290c);
        } else {
            long j = info.f18133a.f18292e;
            if (j == Long.MIN_VALUE) {
                j = this.f18139a.mo24998c();
            }
            durationUs = j;
        }
        C8365r rVar = new C8365r(info.f18133a, info.f18134b, info.f18135c, durationUs, isLastInPeriod, isLastInTimeline);
        return rVar;
    }

    /* renamed from: a */
    public C8396a mo25628a(Object periodUid, long positionUs) {
        return m19750b(periodUid, positionUs, m19741a(periodUid));
    }

    /* renamed from: b */
    private C8396a m19750b(Object periodUid, long positionUs, long windowSequenceNumber) {
        long endPositionUs;
        long j = positionUs;
        Object obj = periodUid;
        this.f18142d.mo24981a(periodUid, this.f18139a);
        int adGroupIndex = this.f18139a.mo24994b(j);
        if (adGroupIndex == -1) {
            int nextAdGroupIndex = this.f18139a.mo24989a(j);
            if (nextAdGroupIndex == -1) {
                endPositionUs = Long.MIN_VALUE;
            } else {
                endPositionUs = this.f18139a.mo24996b(nextAdGroupIndex);
            }
            C8396a aVar = new C8396a(periodUid, windowSequenceNumber, endPositionUs);
            return aVar;
        }
        C8396a aVar2 = new C8396a(periodUid, adGroupIndex, this.f18139a.mo24997c(adGroupIndex), windowSequenceNumber);
        return aVar2;
    }

    /* renamed from: a */
    private long m19741a(Object periodUid) {
        int windowIndex = this.f18142d.mo24981a(periodUid, this.f18139a).f16482c;
        Object obj = this.f18149k;
        if (obj != null) {
            int oldFrontPeriodIndex = this.f18142d.mo24970a(obj);
            if (oldFrontPeriodIndex != -1 && this.f18142d.mo24980a(oldFrontPeriodIndex, this.f18139a).f16482c == windowIndex) {
                return this.f18150l;
            }
        }
        for (C8364q mediaPeriodHolder = mo25638c(); mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.f18125h) {
            if (mediaPeriodHolder.f18119b.equals(periodUid)) {
                return mediaPeriodHolder.f18124g.f18133a.f18291d;
            }
        }
        for (C8364q mediaPeriodHolder2 = mo25638c(); mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.f18125h) {
            int indexOfHolderInTimeline = this.f18142d.mo24970a(mediaPeriodHolder2.f18119b);
            if (indexOfHolderInTimeline != -1 && this.f18142d.mo24980a(indexOfHolderInTimeline, this.f18139a).f16482c == windowIndex) {
                return mediaPeriodHolder2.f18124g.f18133a.f18291d;
            }
        }
        long j = this.f18141c;
        this.f18141c = 1 + j;
        return j;
    }

    /* renamed from: a */
    private boolean m19747a(C8364q periodHolder, C8365r info) {
        C8365r periodHolderInfo = periodHolder.f18124g;
        return periodHolderInfo.f18134b == info.f18134b && periodHolderInfo.f18133a.equals(info.f18133a);
    }

    /* renamed from: i */
    private boolean m19751i() {
        C8364q lastValidPeriodHolder = mo25638c();
        boolean z = true;
        if (lastValidPeriodHolder == null) {
            return true;
        }
        int currentPeriodIndex = this.f18142d.mo24970a(lastValidPeriodHolder.f18119b);
        while (true) {
            int nextPeriodIndex = this.f18142d.mo24976a(currentPeriodIndex, this.f18139a, this.f18140b, this.f18143e, this.f18144f);
            while (lastValidPeriodHolder.f18125h != null && !lastValidPeriodHolder.f18124g.f18137e) {
                lastValidPeriodHolder = lastValidPeriodHolder.f18125h;
            }
            if (nextPeriodIndex == -1) {
                break;
            }
            C8364q qVar = lastValidPeriodHolder.f18125h;
            if (qVar == null || this.f18142d.mo24970a(qVar.f18119b) != nextPeriodIndex) {
                break;
            }
            lastValidPeriodHolder = lastValidPeriodHolder.f18125h;
            currentPeriodIndex = nextPeriodIndex;
        }
        boolean readingPeriodRemoved = mo25633a(lastValidPeriodHolder);
        lastValidPeriodHolder.f18124g = mo25626a(lastValidPeriodHolder.f18124g);
        if (readingPeriodRemoved && mo25642g()) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private C8365r m19744a(C8414t playbackInfo) {
        return m19743a(playbackInfo.f18367d, playbackInfo.f18369f, playbackInfo.f18368e);
    }

    /* renamed from: a */
    private C8365r m19742a(C8364q mediaPeriodHolder, long rendererPositionUs) {
        C8365r rVar;
        long startPositionUs;
        C8365r rVar2;
        long windowSequenceNumber;
        long startPositionUs2;
        Object nextPeriodUid;
        Object nextPeriodUid2;
        long windowSequenceNumber2;
        C8364q qVar = mediaPeriodHolder;
        C8365r mediaPeriodInfo = qVar.f18124g;
        long bufferedDurationUs = (mediaPeriodHolder.mo25617c() + mediaPeriodInfo.f18136d) - rendererPositionUs;
        if (mediaPeriodInfo.f18137e) {
            int currentPeriodIndex = this.f18142d.mo24970a(mediaPeriodInfo.f18133a.f18288a);
            int nextPeriodIndex = this.f18142d.mo24976a(currentPeriodIndex, this.f18139a, this.f18140b, this.f18143e, this.f18144f);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int nextWindowIndex = this.f18142d.mo24971a(nextPeriodIndex, this.f18139a, true).f16482c;
            Object nextPeriodUid3 = this.f18139a.f16481b;
            long windowSequenceNumber3 = mediaPeriodInfo.f18133a.f18291d;
            if (this.f18142d.mo24982a(nextWindowIndex, this.f18140b).f16491f == nextPeriodIndex) {
                C8098D d = this.f18142d;
                C8100b bVar = this.f18140b;
                long windowSequenceNumber4 = windowSequenceNumber3;
                Pair<Object, Long> defaultPosition = d.mo24979a(bVar, this.f18139a, nextWindowIndex, -9223372036854775807L, Math.max(0, bufferedDurationUs));
                if (defaultPosition == null) {
                    return null;
                }
                Object nextPeriodUid4 = defaultPosition.first;
                long startPositionUs3 = ((Long) defaultPosition.second).longValue();
                C8364q qVar2 = qVar.f18125h;
                if (qVar2 == null || !qVar2.f18119b.equals(nextPeriodUid4)) {
                    nextPeriodUid2 = nextPeriodUid4;
                    long j = windowSequenceNumber4;
                    long j2 = this.f18141c;
                    Pair pair = defaultPosition;
                    this.f18141c = j2 + 1;
                    windowSequenceNumber2 = j2;
                } else {
                    windowSequenceNumber2 = qVar.f18125h.f18124g.f18133a.f18291d;
                    nextPeriodUid2 = nextPeriodUid4;
                }
                windowSequenceNumber = windowSequenceNumber2;
                startPositionUs2 = startPositionUs3;
                nextPeriodUid = nextPeriodUid2;
            } else {
                nextPeriodUid = nextPeriodUid3;
                windowSequenceNumber = windowSequenceNumber3;
                startPositionUs2 = 0;
            }
            long j3 = startPositionUs2;
            int i = nextWindowIndex;
            return m19743a(m19750b(nextPeriodUid, j3, windowSequenceNumber), j3, startPositionUs2);
        }
        C8396a currentPeriodId = mediaPeriodInfo.f18133a;
        this.f18142d.mo24981a(currentPeriodId.f18288a, this.f18139a);
        if (currentPeriodId.mo25724a()) {
            int adGroupIndex = currentPeriodId.f18289b;
            int adCountInCurrentAdGroup = this.f18139a.mo24988a(adGroupIndex);
            if (adCountInCurrentAdGroup == -1) {
                return null;
            }
            int nextAdIndexInAdGroup = this.f18139a.mo24993b(adGroupIndex, currentPeriodId.f18290c);
            if (nextAdIndexInAdGroup < adCountInCurrentAdGroup) {
                if (!this.f18139a.mo24999c(adGroupIndex, nextAdIndexInAdGroup)) {
                    int i2 = nextAdIndexInAdGroup;
                    rVar2 = null;
                } else {
                    int i3 = nextAdIndexInAdGroup;
                    rVar2 = m19745a(currentPeriodId.f18288a, adGroupIndex, nextAdIndexInAdGroup, mediaPeriodInfo.f18135c, currentPeriodId.f18291d);
                }
                return rVar2;
            }
            long startPositionUs4 = mediaPeriodInfo.f18135c;
            if (this.f18139a.mo24987a() == 1 && this.f18139a.mo24996b(0) == 0) {
                C8098D d2 = this.f18142d;
                C8100b bVar2 = this.f18140b;
                C8099a aVar = this.f18139a;
                Pair<Object, Long> defaultPosition2 = d2.mo24979a(bVar2, aVar, aVar.f16482c, -9223372036854775807L, Math.max(0, bufferedDurationUs));
                if (defaultPosition2 == null) {
                    return null;
                }
                startPositionUs = ((Long) defaultPosition2.second).longValue();
            } else {
                startPositionUs = startPositionUs4;
            }
            return m19746a(currentPeriodId.f18288a, startPositionUs, currentPeriodId.f18291d);
        }
        long j4 = mediaPeriodInfo.f18133a.f18292e;
        if (j4 != Long.MIN_VALUE) {
            int nextAdGroupIndex = this.f18139a.mo24994b(j4);
            if (nextAdGroupIndex == -1) {
                return m19746a(currentPeriodId.f18288a, mediaPeriodInfo.f18133a.f18292e, currentPeriodId.f18291d);
            }
            int adIndexInAdGroup = this.f18139a.mo24997c(nextAdGroupIndex);
            if (!this.f18139a.mo24999c(nextAdGroupIndex, adIndexInAdGroup)) {
                rVar = null;
            } else {
                rVar = m19745a(currentPeriodId.f18288a, nextAdGroupIndex, adIndexInAdGroup, mediaPeriodInfo.f18133a.f18292e, currentPeriodId.f18291d);
            }
            return rVar;
        }
        int adGroupCount = this.f18139a.mo24987a();
        if (adGroupCount == 0) {
            return null;
        }
        int adGroupIndex2 = adGroupCount - 1;
        if (this.f18139a.mo24996b(adGroupIndex2) != Long.MIN_VALUE || this.f18139a.mo25001d(adGroupIndex2)) {
            return null;
        }
        int adIndexInAdGroup2 = this.f18139a.mo24997c(adGroupIndex2);
        if (!this.f18139a.mo24999c(adGroupIndex2, adIndexInAdGroup2)) {
            return null;
        }
        long contentDurationUs = this.f18139a.mo24998c();
        int i4 = adIndexInAdGroup2;
        return m19745a(currentPeriodId.f18288a, adGroupIndex2, adIndexInAdGroup2, contentDurationUs, currentPeriodId.f18291d);
    }

    /* renamed from: a */
    private C8365r m19743a(C8396a id, long contentPositionUs, long startPositionUs) {
        this.f18142d.mo24981a(id.f18288a, this.f18139a);
        if (!id.mo25724a()) {
            return m19746a(id.f18288a, startPositionUs, id.f18291d);
        } else if (!this.f18139a.mo24999c(id.f18289b, id.f18290c)) {
            return null;
        } else {
            return m19745a(id.f18288a, id.f18289b, id.f18290c, contentPositionUs, id.f18291d);
        }
    }

    /* renamed from: a */
    private C8365r m19745a(Object periodUid, int adGroupIndex, int adIndexInAdGroup, long contentPositionUs, long windowSequenceNumber) {
        C8396a id = new C8396a(periodUid, adGroupIndex, adIndexInAdGroup, windowSequenceNumber);
        boolean isLastInPeriod = m19748a(id);
        boolean isLastInTimeline = m19749a(id, isLastInPeriod);
        C8365r rVar = new C8365r(id, adIndexInAdGroup == this.f18139a.mo24997c(adGroupIndex) ? this.f18139a.mo24995b() : 0, contentPositionUs, this.f18142d.mo24981a(id.f18288a, this.f18139a).mo24990a(id.f18289b, id.f18290c), isLastInPeriod, isLastInTimeline);
        return rVar;
    }

    /* renamed from: a */
    private C8365r m19746a(Object periodUid, long startPositionUs, long windowSequenceNumber) {
        long j;
        int nextAdGroupIndex = this.f18139a.mo24989a(startPositionUs);
        if (nextAdGroupIndex == -1) {
            j = Long.MIN_VALUE;
        } else {
            j = this.f18139a.mo24996b(nextAdGroupIndex);
        }
        long endPositionUs = j;
        C8396a aVar = new C8396a(periodUid, windowSequenceNumber, endPositionUs);
        C8396a id = aVar;
        this.f18142d.mo24981a(id.f18288a, this.f18139a);
        boolean isLastInPeriod = m19748a(id);
        boolean z = isLastInPeriod;
        C8396a aVar2 = id;
        C8365r rVar = new C8365r(id, startPositionUs, -9223372036854775807L, endPositionUs == Long.MIN_VALUE ? this.f18139a.mo24998c() : endPositionUs, isLastInPeriod, m19749a(id, isLastInPeriod));
        return rVar;
    }

    /* renamed from: a */
    private boolean m19748a(C8396a id) {
        int adGroupCount = this.f18142d.mo24981a(id.f18288a, this.f18139a).mo24987a();
        boolean z = true;
        if (adGroupCount == 0) {
            return true;
        }
        int lastAdGroupIndex = adGroupCount - 1;
        boolean isAd = id.mo25724a();
        if (this.f18139a.mo24996b(lastAdGroupIndex) != Long.MIN_VALUE) {
            if (isAd || id.f18292e != Long.MIN_VALUE) {
                z = false;
            }
            return z;
        }
        int postrollAdCount = this.f18139a.mo24988a(lastAdGroupIndex);
        if (postrollAdCount == -1) {
            return false;
        }
        if (!(isAd && id.f18289b == lastAdGroupIndex && id.f18290c == postrollAdCount + -1) && (isAd || this.f18139a.mo24997c(lastAdGroupIndex) != postrollAdCount)) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m19749a(C8396a id, boolean isLastMediaPeriodInPeriod) {
        int periodIndex = this.f18142d.mo24970a(id.f18288a);
        if (!this.f18142d.mo24982a(this.f18142d.mo24980a(periodIndex, this.f18139a).f16482c, this.f18140b).f16490e) {
            if (this.f18142d.mo24985b(periodIndex, this.f18139a, this.f18140b, this.f18143e, this.f18144f) && isLastMediaPeriodInPeriod) {
                return true;
            }
        }
        return false;
    }
}
