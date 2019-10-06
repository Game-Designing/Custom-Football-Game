package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.C8098D.C8099a;
import com.google.android.exoplayer2.C8543v.C8545b;
import com.google.android.exoplayer2.C8569x.C8571b;
import com.google.android.exoplayer2.source.C8395r;
import com.google.android.exoplayer2.source.C8395r.C8396a;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.C8432h;
import com.google.android.exoplayer2.trackselection.C8435j;
import com.google.android.exoplayer2.trackselection.C8437k;
import com.google.android.exoplayer2.upstream.C8482e;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8517g;
import com.google.android.exoplayer2.util.C8526n;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.google.android.exoplayer2.j */
/* compiled from: ExoPlayerImpl */
final class C8323j extends C8147b implements C8320g {

    /* renamed from: b */
    final C8437k f17911b;

    /* renamed from: c */
    private final C8572y[] f17912c;

    /* renamed from: d */
    private final C8435j f17913d;

    /* renamed from: e */
    private final Handler f17914e;

    /* renamed from: f */
    private final C8326l f17915f;

    /* renamed from: g */
    private final Handler f17916g;

    /* renamed from: h */
    private final CopyOnWriteArraySet<C8545b> f17917h;

    /* renamed from: i */
    private final C8099a f17918i;

    /* renamed from: j */
    private final ArrayDeque<C8324a> f17919j;

    /* renamed from: k */
    private C8395r f17920k;

    /* renamed from: l */
    private boolean f17921l;

    /* renamed from: m */
    private boolean f17922m;

    /* renamed from: n */
    private int f17923n;

    /* renamed from: o */
    private boolean f17924o;

    /* renamed from: p */
    private int f17925p;

    /* renamed from: q */
    private boolean f17926q;

    /* renamed from: r */
    private boolean f17927r;

    /* renamed from: s */
    private C8438u f17928s;

    /* renamed from: t */
    private C8096B f17929t;

    /* renamed from: u */
    private ExoPlaybackException f17930u;

    /* renamed from: v */
    private C8414t f17931v;

    /* renamed from: w */
    private int f17932w;

    /* renamed from: x */
    private int f17933x;

    /* renamed from: y */
    private long f17934y;

    /* renamed from: com.google.android.exoplayer2.j$a */
    /* compiled from: ExoPlayerImpl */
    private static final class C8324a {

        /* renamed from: a */
        private final C8414t f17935a;

        /* renamed from: b */
        private final Set<C8545b> f17936b;

        /* renamed from: c */
        private final C8435j f17937c;

        /* renamed from: d */
        private final boolean f17938d;

        /* renamed from: e */
        private final int f17939e;

        /* renamed from: f */
        private final int f17940f;

        /* renamed from: g */
        private final boolean f17941g;

        /* renamed from: h */
        private final boolean f17942h;

        /* renamed from: i */
        private final boolean f17943i;

        /* renamed from: j */
        private final boolean f17944j;

        /* renamed from: k */
        private final boolean f17945k;

        /* renamed from: l */
        private final boolean f17946l;

        public C8324a(C8414t playbackInfo, C8414t previousPlaybackInfo, Set<C8545b> listeners, C8435j trackSelector, boolean positionDiscontinuity, int positionDiscontinuityReason, int timelineChangeReason, boolean seekProcessed, boolean playWhenReady, boolean playWhenReadyChanged) {
            this.f17935a = playbackInfo;
            this.f17936b = listeners;
            this.f17937c = trackSelector;
            this.f17938d = positionDiscontinuity;
            this.f17939e = positionDiscontinuityReason;
            this.f17940f = timelineChangeReason;
            this.f17941g = seekProcessed;
            this.f17942h = playWhenReady;
            boolean z = false;
            this.f17943i = playWhenReadyChanged || previousPlaybackInfo.f18370g != playbackInfo.f18370g;
            this.f17944j = (previousPlaybackInfo.f18365b == playbackInfo.f18365b && previousPlaybackInfo.f18366c == playbackInfo.f18366c) ? false : true;
            this.f17945k = previousPlaybackInfo.f18371h != playbackInfo.f18371h;
            if (previousPlaybackInfo.f18373j != playbackInfo.f18373j) {
                z = true;
            }
            this.f17946l = z;
        }

        /* renamed from: a */
        public void mo25485a() {
            if (this.f17944j || this.f17940f == 0) {
                for (C8545b listener : this.f17936b) {
                    C8414t tVar = this.f17935a;
                    listener.onTimelineChanged(tVar.f18365b, tVar.f18366c, this.f17940f);
                }
            }
            if (this.f17938d) {
                for (C8545b listener2 : this.f17936b) {
                    listener2.mo26157a(this.f17939e);
                }
            }
            if (this.f17946l) {
                this.f17937c.mo25847a(this.f17935a.f18373j.f18481d);
                for (C8545b listener3 : this.f17936b) {
                    C8414t tVar2 = this.f17935a;
                    listener3.onTracksChanged(tVar2.f18372i, tVar2.f18373j.f18480c);
                }
            }
            if (this.f17945k) {
                for (C8545b listener4 : this.f17936b) {
                    listener4.onLoadingChanged(this.f17935a.f18371h);
                }
            }
            if (this.f17943i) {
                for (C8545b listener5 : this.f17936b) {
                    listener5.onPlayerStateChanged(this.f17942h, this.f17935a.f18370g);
                }
            }
            if (this.f17941g) {
                for (C8545b listener6 : this.f17936b) {
                    listener6.mo26156a();
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public C8323j(C8572y[] renderers, C8435j trackSelector, C8363p loadControl, C8482e bandwidthMeter, C8517g clock, Looper looper) {
        C8572y[] yVarArr = renderers;
        StringBuilder sb = new StringBuilder();
        sb.append("Init ");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" [");
        sb.append("ExoPlayerLib/2.9.5");
        sb.append("] [");
        sb.append(C8509F.f18797e);
        sb.append("]");
        C8526n.m20533c("ExoPlayerImpl", sb.toString());
        C8514e.m20490b(yVarArr.length > 0);
        C8514e.m20486a(renderers);
        this.f17912c = yVarArr;
        C8514e.m20486a(trackSelector);
        this.f17913d = trackSelector;
        this.f17921l = false;
        this.f17923n = 0;
        this.f17924o = false;
        this.f17917h = new CopyOnWriteArraySet<>();
        this.f17911b = new C8437k(new C8095A[yVarArr.length], new C8432h[yVarArr.length], null);
        this.f17918i = new C8099a();
        this.f17928s = C8438u.f18482a;
        this.f17929t = C8096B.f16476e;
        this.f17914e = new C8322i(this, looper);
        this.f17931v = C8414t.m19998a(0, this.f17911b);
        this.f17919j = new ArrayDeque<>();
        C8326l lVar = new C8326l(renderers, trackSelector, this.f17911b, loadControl, bandwidthMeter, this.f17921l, this.f17923n, this.f17924o, this.f17914e, this, clock);
        this.f17915f = lVar;
        this.f17916g = new Handler(this.f17915f.mo25486a());
    }

    /* renamed from: a */
    public void mo25473a(C8545b listener) {
        this.f17917h.add(listener);
    }

    /* renamed from: i */
    public int mo25481i() {
        return this.f17931v.f18370g;
    }

    /* renamed from: a */
    public void mo25467a(C8395r mediaSource) {
        mo25472a(mediaSource, true, true);
    }

    /* renamed from: a */
    public void mo25472a(C8395r mediaSource, boolean resetPosition, boolean resetState) {
        this.f17930u = null;
        this.f17920k = mediaSource;
        C8414t playbackInfo = m19454a(resetPosition, resetState, 2);
        this.f17926q = true;
        this.f17925p++;
        this.f17915f.mo25490a(mediaSource, resetPosition, resetState);
        m19456a(playbackInfo, false, 4, 1, false, false);
    }

    /* renamed from: a */
    public void mo25474a(boolean playWhenReady) {
        mo25475a(playWhenReady, false);
    }

    /* renamed from: a */
    public void mo25475a(boolean playWhenReady, boolean suppressPlayback) {
        boolean internalPlayWhenReady = playWhenReady && !suppressPlayback;
        if (this.f17922m != internalPlayWhenReady) {
            this.f17922m = internalPlayWhenReady;
            this.f17915f.mo25493a(internalPlayWhenReady);
        }
        if (this.f17921l != playWhenReady) {
            this.f17921l = playWhenReady;
            m19456a(this.f17931v, false, 4, 1, false, true);
        }
    }

    /* renamed from: l */
    public boolean mo25484l() {
        return this.f17921l;
    }

    /* renamed from: a */
    public void mo25470a(int windowIndex, long positionMs) {
        C8098D timeline = this.f17931v.f18365b;
        if (windowIndex < 0 || (!timeline.mo24986c() && windowIndex >= timeline.mo24974b())) {
            throw new IllegalSeekPositionException(timeline, windowIndex, positionMs);
        }
        this.f17927r = true;
        this.f17925p++;
        if (mo25478d()) {
            C8526n.m20534d("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.f17914e.obtainMessage(0, 1, -1, this.f17931v).sendToTarget();
            return;
        }
        this.f17932w = windowIndex;
        if (timeline.mo24986c()) {
            this.f17934y = positionMs == -9223372036854775807L ? 0 : positionMs;
            this.f17933x = 0;
        } else {
            long windowPositionUs = positionMs == -9223372036854775807L ? timeline.mo24982a(windowIndex, this.f16815a).mo25002a() : C8275d.m19230a(positionMs);
            Pair<Object, Long> periodUidAndPosition = timeline.mo24978a(this.f16815a, this.f17918i, windowIndex, windowPositionUs);
            this.f17934y = C8275d.m19231b(windowPositionUs);
            this.f17933x = timeline.mo24970a(periodUidAndPosition.first);
        }
        this.f17915f.mo25487a(timeline, windowIndex, C8275d.m19230a(positionMs));
        Iterator it = this.f17917h.iterator();
        while (it.hasNext()) {
            ((C8545b) it.next()).mo26157a(1);
        }
    }

    /* renamed from: b */
    public void mo25476b(boolean reset) {
        if (reset) {
            this.f17930u = null;
            this.f17920k = null;
        }
        C8414t playbackInfo = m19454a(reset, reset, 1);
        this.f17925p++;
        this.f17915f.mo25497b(reset);
        m19456a(playbackInfo, false, 4, 1, false, false);
    }

    /* renamed from: a */
    public void mo25469a() {
        StringBuilder sb = new StringBuilder();
        sb.append("Release ");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" [");
        sb.append("ExoPlayerLib/2.9.5");
        String str = "] [";
        sb.append(str);
        sb.append(C8509F.f18797e);
        sb.append(str);
        sb.append(C8331m.m19553a());
        sb.append("]");
        C8526n.m20533c("ExoPlayerImpl", sb.toString());
        this.f17920k = null;
        this.f17915f.mo25494b();
        this.f17914e.removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    public C8569x mo25466a(C8571b target) {
        C8569x xVar = new C8569x(this.f17915f, target, this.f17931v.f18365b, mo25482j(), this.f17916g);
        return xVar;
    }

    /* renamed from: c */
    public int mo25477c() {
        if (m19457e()) {
            return this.f17933x;
        }
        C8414t tVar = this.f17931v;
        return tVar.f18365b.mo24970a(tVar.f18367d.f18288a);
    }

    /* renamed from: j */
    public int mo25482j() {
        if (m19457e()) {
            return this.f17932w;
        }
        C8414t tVar = this.f17931v;
        return tVar.f18365b.mo24981a(tVar.f18367d.f18288a, this.f17918i).f16482c;
    }

    public long getDuration() {
        if (!mo25478d()) {
            return mo25181b();
        }
        C8414t tVar = this.f17931v;
        C8396a periodId = tVar.f18367d;
        tVar.f18365b.mo24981a(periodId.f18288a, this.f17918i);
        return C8275d.m19231b(this.f17918i.mo24990a(periodId.f18289b, periodId.f18290c));
    }

    public long getCurrentPosition() {
        if (m19457e()) {
            return this.f17934y;
        }
        if (this.f17931v.f18367d.mo25724a()) {
            return C8275d.m19231b(this.f17931v.f18377n);
        }
        C8414t tVar = this.f17931v;
        return m19453a(tVar.f18367d, tVar.f18377n);
    }

    /* renamed from: d */
    public boolean mo25478d() {
        return !m19457e() && this.f17931v.f18367d.mo25724a();
    }

    /* renamed from: k */
    public C8098D mo25483k() {
        return this.f17931v.f18365b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25471a(Message msg) {
        int i = msg.what;
        boolean z = true;
        if (i == 0) {
            C8414t tVar = (C8414t) msg.obj;
            int i2 = msg.arg1;
            if (msg.arg2 == -1) {
                z = false;
            }
            m19455a(tVar, i2, z, msg.arg2);
        } else if (i == 1) {
            C8438u playbackParameters = (C8438u) msg.obj;
            if (!this.f17928s.equals(playbackParameters)) {
                this.f17928s = playbackParameters;
                Iterator it = this.f17917h.iterator();
                while (it.hasNext()) {
                    ((C8545b) it.next()).onPlaybackParametersChanged(playbackParameters);
                }
            }
        } else if (i == 2) {
            ExoPlaybackException playbackError = (ExoPlaybackException) msg.obj;
            this.f17930u = playbackError;
            Iterator it2 = this.f17917h.iterator();
            while (it2.hasNext()) {
                ((C8545b) it2.next()).onPlayerError(playbackError);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private void m19455a(C8414t playbackInfo, int operationAcks, boolean positionDiscontinuity, int positionDiscontinuityReason) {
        this.f17925p -= operationAcks;
        if (this.f17925p == 0) {
            if (playbackInfo.f18368e == -9223372036854775807L) {
                playbackInfo = playbackInfo.mo25801a(playbackInfo.f18367d, 0, playbackInfo.f18369f);
            }
            if ((!this.f17931v.f18365b.mo24986c() || this.f17926q) && playbackInfo.f18365b.mo24986c()) {
                this.f17933x = 0;
                this.f17932w = 0;
                this.f17934y = 0;
            }
            int timelineChangeReason = this.f17926q ? 0 : 2;
            boolean seekProcessed = this.f17927r;
            this.f17926q = false;
            this.f17927r = false;
            m19456a(playbackInfo, positionDiscontinuity, positionDiscontinuityReason, timelineChangeReason, seekProcessed, false);
        }
    }

    /* renamed from: a */
    private C8414t m19454a(boolean resetPosition, boolean resetState, int playbackState) {
        long j = 0;
        if (resetPosition) {
            this.f17932w = 0;
            this.f17933x = 0;
            this.f17934y = 0;
        } else {
            this.f17932w = mo25482j();
            this.f17933x = mo25477c();
            this.f17934y = getCurrentPosition();
        }
        C8396a mediaPeriodId = resetPosition ? this.f17931v.mo25796a(this.f17924o, this.f16815a) : this.f17931v.f18367d;
        if (!resetPosition) {
            j = this.f17931v.f18377n;
        }
        long startPositionUs = j;
        C8414t tVar = new C8414t(resetState ? C8098D.f16479a : this.f17931v.f18365b, resetState ? null : this.f17931v.f18366c, mediaPeriodId, startPositionUs, resetPosition ? -9223372036854775807L : this.f17931v.f18369f, playbackState, false, resetState ? TrackGroupArray.f18154a : this.f17931v.f18372i, resetState ? this.f17911b : this.f17931v.f18373j, mediaPeriodId, startPositionUs, 0, startPositionUs);
        return tVar;
    }

    /* renamed from: a */
    private void m19456a(C8414t playbackInfo, boolean positionDiscontinuity, int positionDiscontinuityReason, int timelineChangeReason, boolean seekProcessed, boolean playWhenReadyChanged) {
        boolean isRunningRecursiveListenerNotification = !this.f17919j.isEmpty();
        ArrayDeque<C8324a> arrayDeque = this.f17919j;
        C8324a aVar = new C8324a(playbackInfo, this.f17931v, this.f17917h, this.f17913d, positionDiscontinuity, positionDiscontinuityReason, timelineChangeReason, seekProcessed, this.f17921l, playWhenReadyChanged);
        arrayDeque.addLast(aVar);
        this.f17931v = playbackInfo;
        if (!isRunningRecursiveListenerNotification) {
            while (!this.f17919j.isEmpty()) {
                ((C8324a) this.f17919j.peekFirst()).mo25485a();
                this.f17919j.removeFirst();
            }
        }
    }

    /* renamed from: a */
    private long m19453a(C8396a periodId, long positionUs) {
        long positionMs = C8275d.m19231b(positionUs);
        this.f17931v.f18365b.mo24981a(periodId.f18288a, this.f17918i);
        return positionMs + this.f17918i.mo25000d();
    }

    /* renamed from: e */
    private boolean m19457e() {
        return this.f17931v.f18365b.mo24986c() || this.f17925p > 0;
    }
}
