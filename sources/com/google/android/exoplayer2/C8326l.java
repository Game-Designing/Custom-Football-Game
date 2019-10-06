package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C8098D.C8099a;
import com.google.android.exoplayer2.C8098D.C8100b;
import com.google.android.exoplayer2.C8318f.C8319a;
import com.google.android.exoplayer2.C8569x.C8570a;
import com.google.android.exoplayer2.source.C8393q;
import com.google.android.exoplayer2.source.C8393q.C8394a;
import com.google.android.exoplayer2.source.C8395r;
import com.google.android.exoplayer2.source.C8395r.C8396a;
import com.google.android.exoplayer2.source.C8395r.C8397b;
import com.google.android.exoplayer2.source.C8408v;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.C8432h;
import com.google.android.exoplayer2.trackselection.C8435j;
import com.google.android.exoplayer2.trackselection.C8435j.C8436a;
import com.google.android.exoplayer2.trackselection.C8437k;
import com.google.android.exoplayer2.upstream.C8482e;
import com.google.android.exoplayer2.util.C8507E;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8517g;
import com.google.android.exoplayer2.util.C8525m;
import com.google.android.exoplayer2.util.C8526n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: com.google.android.exoplayer2.l */
/* compiled from: ExoPlayerImplInternal */
final class C8326l implements Callback, C8394a, C8436a, C8397b, C8319a, C8570a {

    /* renamed from: A */
    private int f17947A;

    /* renamed from: B */
    private boolean f17948B;

    /* renamed from: C */
    private int f17949C;

    /* renamed from: D */
    private C8330d f17950D;

    /* renamed from: E */
    private long f17951E;

    /* renamed from: F */
    private int f17952F;

    /* renamed from: a */
    private final C8572y[] f17953a;

    /* renamed from: b */
    private final C8573z[] f17954b;

    /* renamed from: c */
    private final C8435j f17955c;

    /* renamed from: d */
    private final C8437k f17956d;

    /* renamed from: e */
    private final C8363p f17957e;

    /* renamed from: f */
    private final C8482e f17958f;

    /* renamed from: g */
    private final C8525m f17959g;

    /* renamed from: h */
    private final HandlerThread f17960h;

    /* renamed from: i */
    private final Handler f17961i;

    /* renamed from: j */
    private final C8320g f17962j;

    /* renamed from: k */
    private final C8100b f17963k;

    /* renamed from: l */
    private final C8099a f17964l;

    /* renamed from: m */
    private final long f17965m;

    /* renamed from: n */
    private final boolean f17966n;

    /* renamed from: o */
    private final C8318f f17967o;

    /* renamed from: p */
    private final C8329c f17968p;

    /* renamed from: q */
    private final ArrayList<C8328b> f17969q;

    /* renamed from: r */
    private final C8517g f17970r;

    /* renamed from: s */
    private final C8366s f17971s = new C8366s();

    /* renamed from: t */
    private C8096B f17972t;

    /* renamed from: u */
    private C8414t f17973u;

    /* renamed from: v */
    private C8395r f17974v;

    /* renamed from: w */
    private C8572y[] f17975w;

    /* renamed from: x */
    private boolean f17976x;

    /* renamed from: y */
    private boolean f17977y;

    /* renamed from: z */
    private boolean f17978z;

    /* renamed from: com.google.android.exoplayer2.l$a */
    /* compiled from: ExoPlayerImplInternal */
    private static final class C8327a {

        /* renamed from: a */
        public final C8395r f17979a;

        /* renamed from: b */
        public final C8098D f17980b;

        /* renamed from: c */
        public final Object f17981c;

        public C8327a(C8395r source, C8098D timeline, Object manifest) {
            this.f17979a = source;
            this.f17980b = timeline;
            this.f17981c = manifest;
        }
    }

    /* renamed from: com.google.android.exoplayer2.l$b */
    /* compiled from: ExoPlayerImplInternal */
    private static final class C8328b implements Comparable<C8328b> {

        /* renamed from: a */
        public final C8569x f17982a;

        /* renamed from: b */
        public int f17983b;

        /* renamed from: c */
        public long f17984c;

        /* renamed from: d */
        public Object f17985d;

        public C8328b(C8569x message) {
            this.f17982a = message;
        }

        /* renamed from: a */
        public void mo25500a(int periodIndex, long periodTimeUs, Object periodUid) {
            this.f17983b = periodIndex;
            this.f17984c = periodTimeUs;
            this.f17985d = periodUid;
        }

        /* renamed from: a */
        public int compareTo(C8328b other) {
            int i = 1;
            if ((this.f17985d == null) != (other.f17985d == null)) {
                if (this.f17985d != null) {
                    i = -1;
                }
                return i;
            } else if (this.f17985d == null) {
                return 0;
            } else {
                int comparePeriodIndex = this.f17983b - other.f17983b;
                if (comparePeriodIndex != 0) {
                    return comparePeriodIndex;
                }
                return C8509F.m20434a(this.f17984c, other.f17984c);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.l$c */
    /* compiled from: ExoPlayerImplInternal */
    private static final class C8329c {

        /* renamed from: a */
        private C8414t f17986a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f17987b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f17988c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f17989d;

        private C8329c() {
        }

        /* renamed from: a */
        public boolean mo25503a(C8414t playbackInfo) {
            return playbackInfo != this.f17986a || this.f17987b > 0 || this.f17988c;
        }

        /* renamed from: b */
        public void mo25505b(C8414t playbackInfo) {
            this.f17986a = playbackInfo;
            this.f17987b = 0;
            this.f17988c = false;
        }

        /* renamed from: a */
        public void mo25502a(int operationAcks) {
            this.f17987b += operationAcks;
        }

        /* renamed from: b */
        public void mo25504b(int discontinuityReason) {
            boolean z = true;
            if (!this.f17988c || this.f17989d == 4) {
                this.f17988c = true;
                this.f17989d = discontinuityReason;
                return;
            }
            if (discontinuityReason != 4) {
                z = false;
            }
            C8514e.m20488a(z);
        }
    }

    /* renamed from: com.google.android.exoplayer2.l$d */
    /* compiled from: ExoPlayerImplInternal */
    private static final class C8330d {

        /* renamed from: a */
        public final C8098D f17990a;

        /* renamed from: b */
        public final int f17991b;

        /* renamed from: c */
        public final long f17992c;

        public C8330d(C8098D timeline, int windowIndex, long windowPositionUs) {
            this.f17990a = timeline;
            this.f17991b = windowIndex;
            this.f17992c = windowPositionUs;
        }
    }

    public C8326l(C8572y[] renderers, C8435j trackSelector, C8437k emptyTrackSelectorResult, C8363p loadControl, C8482e bandwidthMeter, boolean playWhenReady, int repeatMode, boolean shuffleModeEnabled, Handler eventHandler, C8320g player, C8517g clock) {
        this.f17953a = renderers;
        this.f17955c = trackSelector;
        this.f17956d = emptyTrackSelectorResult;
        this.f17957e = loadControl;
        this.f17958f = bandwidthMeter;
        this.f17977y = playWhenReady;
        this.f17947A = repeatMode;
        this.f17948B = shuffleModeEnabled;
        this.f17961i = eventHandler;
        this.f17962j = player;
        this.f17970r = clock;
        this.f17965m = loadControl.mo25417c();
        this.f17966n = loadControl.mo25416b();
        this.f17972t = C8096B.f16476e;
        this.f17973u = C8414t.m19998a(-9223372036854775807L, emptyTrackSelectorResult);
        this.f17968p = new C8329c();
        this.f17954b = new C8573z[renderers.length];
        for (int i = 0; i < renderers.length; i++) {
            renderers[i].setIndex(i);
            this.f17954b[i] = renderers[i].mo25378j();
        }
        this.f17967o = new C8318f(this, clock);
        this.f17969q = new ArrayList<>();
        this.f17975w = new C8572y[0];
        this.f17963k = new C8100b();
        this.f17964l = new C8099a();
        trackSelector.mo25860a((C8436a) this, bandwidthMeter);
        this.f17960h = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f17960h.start();
        this.f17959g = clock.mo26037a(this.f17960h.getLooper(), this);
    }

    /* renamed from: a */
    public void mo25490a(C8395r mediaSource, boolean resetPosition, boolean resetState) {
        this.f17959g.mo26041a(0, resetPosition, resetState, mediaSource).sendToTarget();
    }

    /* renamed from: a */
    public void mo25493a(boolean playWhenReady) {
        this.f17959g.mo26040a(1, playWhenReady, 0).sendToTarget();
    }

    /* renamed from: a */
    public void mo25487a(C8098D timeline, int windowIndex, long positionUs) {
        this.f17959g.mo26042a(3, (Object) new C8330d(timeline, windowIndex, positionUs)).sendToTarget();
    }

    /* renamed from: b */
    public void mo25497b(boolean reset) {
        this.f17959g.mo26040a(6, reset, 0).sendToTarget();
    }

    /* renamed from: a */
    public synchronized void mo25492a(C8569x message) {
        if (this.f17976x) {
            C8526n.m20534d("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            message.mo26232a(false);
            return;
        }
        this.f17959g.mo26042a(14, (Object) message).sendToTarget();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo25494b() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f17976x     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            com.google.android.exoplayer2.util.m r0 = r2.f17959g     // Catch:{ all -> 0x0024 }
            r1 = 7
            r0.mo26043a(r1)     // Catch:{ all -> 0x0024 }
            r0 = 0
        L_0x000e:
            boolean r1 = r2.f17976x     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0019
            r2.wait()     // Catch:{ InterruptedException -> 0x0016 }
            goto L_0x000e
        L_0x0016:
            r1 = move-exception
            r0 = 1
            goto L_0x000e
        L_0x0019:
            if (r0 == 0) goto L_0x0022
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r1.interrupt()     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0028
        L_0x0027:
            throw r0
        L_0x0028:
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.C8326l.mo25494b():void");
    }

    /* renamed from: a */
    public Looper mo25486a() {
        return this.f17960h.getLooper();
    }

    /* renamed from: a */
    public void mo25489a(C8395r source, C8098D timeline, Object manifest) {
        this.f17959g.mo26042a(8, (Object) new C8327a(source, timeline, manifest)).sendToTarget();
    }

    /* renamed from: a */
    public void mo25488a(C8393q source) {
        this.f17959g.mo26042a(9, (Object) source).sendToTarget();
    }

    /* renamed from: b */
    public void mo25491a(C8393q source) {
        this.f17959g.mo26042a(10, (Object) source).sendToTarget();
    }

    public void onPlaybackParametersChanged(C8438u playbackParameters) {
        this.f17959g.mo26042a(16, (Object) playbackParameters).sendToTarget();
    }

    public boolean handleMessage(Message msg) {
        String str = "ExoPlayerImplInternal";
        try {
            switch (msg.what) {
                case 0:
                    m19500b((C8395r) msg.obj, msg.arg1 != 0, msg.arg2 != 0);
                    break;
                case 1:
                    m19516f(msg.arg1 != 0);
                    break;
                case 2:
                    m19503c();
                    break;
                case 3:
                    m19486a((C8330d) msg.obj);
                    break;
                case 4:
                    m19501b((C8438u) msg.obj);
                    break;
                case 5:
                    m19484a((C8096B) msg.obj);
                    break;
                case 6:
                    m19491a(msg.arg1 != 0, true);
                    break;
                case 7:
                    m19525l();
                    return true;
                case 8:
                    m19485a((C8327a) msg.obj);
                    break;
                case 9:
                    m19509d((C8393q) msg.obj);
                    break;
                case 10:
                    m19504c((C8393q) msg.obj);
                    break;
                case 11:
                    m19526m();
                    break;
                case 12:
                    m19481a(msg.arg1);
                    break;
                case 13:
                    m19519g(msg.arg1 != 0);
                    break;
                case 14:
                    m19510d((C8569x) msg.obj);
                    break;
                case 15:
                    m19515f((C8569x) msg.obj);
                    break;
                case 16:
                    m19489a((C8438u) msg.obj);
                    break;
                default:
                    return false;
            }
            m19520h();
        } catch (ExoPlaybackException e) {
            C8526n.m20530a(str, "Playback error.", e);
            m19491a(false, false);
            this.f17961i.obtainMessage(2, e).sendToTarget();
            m19520h();
        } catch (IOException e2) {
            C8526n.m20530a(str, "Source error.", e2);
            m19491a(false, false);
            this.f17961i.obtainMessage(2, ExoPlaybackException.m18240a(e2)).sendToTarget();
            m19520h();
        } catch (RuntimeException e3) {
            C8526n.m20530a(str, "Internal runtime error.", e3);
            m19491a(false, false);
            this.f17961i.obtainMessage(2, ExoPlaybackException.m18242a(e3)).sendToTarget();
            m19520h();
        }
        return true;
    }

    /* renamed from: b */
    private void m19497b(int state) {
        C8414t tVar = this.f17973u;
        if (tVar.f18370g != state) {
            this.f17973u = tVar.mo25797a(state);
        }
    }

    /* renamed from: e */
    private void m19514e(boolean isLoading) {
        C8414t tVar = this.f17973u;
        if (tVar.f18371h != isLoading) {
            this.f17973u = tVar.mo25803a(isLoading);
        }
    }

    /* renamed from: h */
    private void m19520h() {
        if (this.f17968p.mo25503a(this.f17973u)) {
            this.f17961i.obtainMessage(0, this.f17968p.f17987b, this.f17968p.f17988c ? this.f17968p.f17989d : -1, this.f17973u).sendToTarget();
            this.f17968p.mo25505b(this.f17973u);
        }
    }

    /* renamed from: b */
    private void m19500b(C8395r mediaSource, boolean resetPosition, boolean resetState) {
        this.f17949C++;
        m19492a(true, resetPosition, resetState);
        this.f17957e.mo25418d();
        this.f17974v = mediaSource;
        m19497b(2);
        mediaSource.mo25677a(this.f17962j, true, this, this.f17958f.mo26009a());
        this.f17959g.mo26043a(2);
    }

    /* renamed from: f */
    private void m19516f(boolean playWhenReady) throws ExoPlaybackException {
        this.f17978z = false;
        this.f17977y = playWhenReady;
        if (!playWhenReady) {
            m19529p();
            m19531r();
            return;
        }
        int i = this.f17973u.f18370g;
        if (i == 3) {
            m19528o();
            this.f17959g.mo26043a(2);
        } else if (i == 2) {
            this.f17959g.mo26043a(2);
        }
    }

    /* renamed from: a */
    private void m19481a(int repeatMode) throws ExoPlaybackException {
        this.f17947A = repeatMode;
        if (!this.f17971s.mo25632a(repeatMode)) {
            m19511d(true);
        }
        m19506c(false);
    }

    /* renamed from: g */
    private void m19519g(boolean shuffleModeEnabled) throws ExoPlaybackException {
        this.f17948B = shuffleModeEnabled;
        if (!this.f17971s.mo25637b(shuffleModeEnabled)) {
            m19511d(true);
        }
        m19506c(false);
    }

    /* renamed from: d */
    private void m19511d(boolean sendDiscontinuity) throws ExoPlaybackException {
        C8396a periodId = this.f17971s.mo25640e().f18124g.f18133a;
        long newPositionUs = m19477a(periodId, this.f17973u.f18377n, true);
        if (newPositionUs != this.f17973u.f18377n) {
            C8414t tVar = this.f17973u;
            this.f17973u = tVar.mo25802a(periodId, newPositionUs, tVar.f18369f, m19508d());
            if (sendDiscontinuity) {
                this.f17968p.mo25504b(4);
            }
        }
    }

    /* renamed from: o */
    private void m19528o() throws ExoPlaybackException {
        this.f17978z = false;
        this.f17967o.mo25461b();
        for (C8572y renderer : this.f17975w) {
            renderer.start();
        }
    }

    /* renamed from: p */
    private void m19529p() throws ExoPlaybackException {
        this.f17967o.mo25463c();
        for (C8572y renderer : this.f17975w) {
            m19502b(renderer);
        }
    }

    /* renamed from: r */
    private void m19531r() throws ExoPlaybackException {
        if (this.f17971s.mo25642g()) {
            C8364q playingPeriodHolder = this.f17971s.mo25640e();
            long periodPositionUs = playingPeriodHolder.f18118a.mo25687b();
            if (periodPositionUs != -9223372036854775807L) {
                m19498b(periodPositionUs);
                if (periodPositionUs != this.f17973u.f18377n) {
                    C8414t tVar = this.f17973u;
                    this.f17973u = tVar.mo25802a(tVar.f18367d, periodPositionUs, tVar.f18369f, m19508d());
                    this.f17968p.mo25504b(4);
                }
            } else {
                this.f17951E = this.f17967o.mo25464d();
                long periodPositionUs2 = playingPeriodHolder.mo25618c(this.f17951E);
                m19483a(this.f17973u.f18377n, periodPositionUs2);
                this.f17973u.f18377n = periodPositionUs2;
            }
            C8364q loadingPeriod = this.f17971s.mo25639d();
            this.f17973u.f18375l = loadingPeriod.mo25609a();
            this.f17973u.f18376m = m19508d();
        }
    }

    /* renamed from: c */
    private void m19503c() throws ExoPlaybackException, IOException {
        C8572y[] yVarArr;
        long operationStartTimeMs = this.f17970r.mo26038b();
        m19530q();
        if (!this.f17971s.mo25642g()) {
            m19522i();
            m19499b(operationStartTimeMs, 10);
            return;
        }
        C8364q playingPeriodHolder = this.f17971s.mo25640e();
        C8507E.m20417a("doSomeWork");
        m19531r();
        long rendererPositionElapsedRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        playingPeriodHolder.f18118a.mo25685a(this.f17973u.f18377n - this.f17965m, this.f17966n);
        boolean renderersReadyOrEnded = true;
        boolean renderersEnded = true;
        for (C8572y renderer : this.f17975w) {
            renderer.mo25509a(this.f17951E, rendererPositionElapsedRealtimeUs);
            boolean z = true;
            renderersEnded = renderersEnded && renderer.mo25162b();
            boolean rendererReadyOrEnded = renderer.isReady() || renderer.mo25162b() || m19507c(renderer);
            if (!rendererReadyOrEnded) {
                renderer.mo25376h();
            }
            if (!renderersReadyOrEnded || !rendererReadyOrEnded) {
                z = false;
            }
            renderersReadyOrEnded = z;
        }
        if (!renderersReadyOrEnded) {
            m19522i();
        }
        long playingPeriodDurationUs = playingPeriodHolder.f18124g.f18136d;
        if (renderersEnded && ((playingPeriodDurationUs == -9223372036854775807L || playingPeriodDurationUs <= this.f17973u.f18377n) && playingPeriodHolder.f18124g.f18138f)) {
            m19497b(4);
            m19529p();
        } else if (this.f17973u.f18370g == 2 && m19521h(renderersReadyOrEnded)) {
            m19497b(3);
            if (this.f17977y) {
                m19528o();
            }
        } else if (this.f17973u.f18370g == 3 && (this.f17975w.length != 0 ? !renderersReadyOrEnded : !m19517f())) {
            this.f17978z = this.f17977y;
            m19497b(2);
            m19529p();
        }
        if (this.f17973u.f18370g == 2) {
            for (C8572y renderer2 : this.f17975w) {
                renderer2.mo25376h();
            }
        }
        if (!this.f17977y || this.f17973u.f18370g != 3) {
            int i = this.f17973u.f18370g;
            if (i != 2) {
                if (this.f17975w.length == 0 || i == 4) {
                    this.f17959g.mo26045b(2);
                } else {
                    m19499b(operationStartTimeMs, 1000);
                }
                C8507E.m20416a();
            }
        }
        m19499b(operationStartTimeMs, 10);
        C8507E.m20416a();
    }

    /* renamed from: b */
    private void m19499b(long thisOperationStartTimeMs, long intervalMs) {
        this.f17959g.mo26045b(2);
        this.f17959g.mo26044a(2, thisOperationStartTimeMs + intervalMs);
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m19486a(com.google.android.exoplayer2.C8326l.C8330d r26) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            com.google.android.exoplayer2.l$c r0 = r1.f17968p
            r3 = 1
            r0.mo25502a(r3)
            android.util.Pair r4 = r1.m19478a(r2, r3)
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0 = 0
            if (r4 != 0) goto L_0x0033
            com.google.android.exoplayer2.t r7 = r1.f17973u
            boolean r8 = r1.f17948B
            com.google.android.exoplayer2.D$b r9 = r1.f17963k
            com.google.android.exoplayer2.source.r$a r7 = r7.mo25796a(r8, r9)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r12 = 1
            r23 = r8
            r8 = r7
            r7 = r12
            r12 = r23
            goto L_0x0060
        L_0x0033:
            java.lang.Object r7 = r4.first
            java.lang.Object r8 = r4.second
            java.lang.Long r8 = (java.lang.Long) r8
            long r10 = r8.longValue()
            com.google.android.exoplayer2.s r8 = r1.f17971s
            com.google.android.exoplayer2.source.r$a r8 = r8.mo25628a(r7, r10)
            boolean r9 = r8.mo25724a()
            if (r9 == 0) goto L_0x004e
            r12 = 0
            r9 = 1
            r7 = r9
            goto L_0x0060
        L_0x004e:
            java.lang.Object r9 = r4.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            long r14 = r2.f17992c
            int r9 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x005e
            r9 = 1
            goto L_0x005f
        L_0x005e:
            r9 = 0
        L_0x005f:
            r7 = r9
        L_0x0060:
            r9 = 2
            com.google.android.exoplayer2.source.r r14 = r1.f17974v     // Catch:{ all -> 0x0106 }
            if (r14 == 0) goto L_0x00e7
            int r14 = r1.f17949C     // Catch:{ all -> 0x0106 }
            if (r14 <= 0) goto L_0x006d
            r22 = r4
            goto L_0x00e9
        L_0x006d:
            int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r14 != 0) goto L_0x0081
            r5 = 4
            r1.m19497b(r5)     // Catch:{ all -> 0x007c }
            r1.m19492a(r0, r3, r0)     // Catch:{ all -> 0x007c }
            r22 = r4
            goto L_0x00eb
        L_0x007c:
            r0 = move-exception
            r22 = r4
            goto L_0x0109
        L_0x0081:
            r5 = r12
            com.google.android.exoplayer2.t r14 = r1.f17973u     // Catch:{ all -> 0x0106 }
            com.google.android.exoplayer2.source.r$a r14 = r14.f18367d     // Catch:{ all -> 0x0106 }
            boolean r14 = r8.equals(r14)     // Catch:{ all -> 0x0106 }
            if (r14 == 0) goto L_0x00d7
            com.google.android.exoplayer2.s r14 = r1.f17971s     // Catch:{ all -> 0x0106 }
            com.google.android.exoplayer2.q r14 = r14.mo25640e()     // Catch:{ all -> 0x0106 }
            r15 = r14
            if (r15 == 0) goto L_0x00a5
            r16 = 0
            int r14 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r14 == 0) goto L_0x00a5
            com.google.android.exoplayer2.source.q r14 = r15.f18118a     // Catch:{ all -> 0x007c }
            com.google.android.exoplayer2.B r0 = r1.f17972t     // Catch:{ all -> 0x007c }
            long r17 = r14.mo25683a(r5, r0)     // Catch:{ all -> 0x007c }
            r5 = r17
        L_0x00a5:
            long r17 = com.google.android.exoplayer2.C8275d.m19231b(r5)     // Catch:{ all -> 0x0106 }
            com.google.android.exoplayer2.t r0 = r1.f17973u     // Catch:{ all -> 0x0106 }
            r22 = r4
            long r3 = r0.f18377n     // Catch:{ all -> 0x0104 }
            long r3 = com.google.android.exoplayer2.C8275d.m19231b(r3)     // Catch:{ all -> 0x0104 }
            int r0 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x00d5
            com.google.android.exoplayer2.t r0 = r1.f17973u     // Catch:{ all -> 0x0104 }
            long r3 = r0.f18377n     // Catch:{ all -> 0x0104 }
            r16 = r3
            com.google.android.exoplayer2.t r14 = r1.f17973u
            long r20 = r25.m19508d()
            r0 = r15
            r15 = r8
            r18 = r10
            com.google.android.exoplayer2.t r3 = r14.mo25802a(r15, r16, r18, r20)
            r1.f17973u = r3
            if (r7 == 0) goto L_0x00d4
            com.google.android.exoplayer2.l$c r3 = r1.f17968p
            r3.mo25504b(r9)
        L_0x00d4:
            return
        L_0x00d5:
            r0 = r15
            goto L_0x00d9
        L_0x00d7:
            r22 = r4
        L_0x00d9:
            long r3 = r1.m19476a(r8, r5)     // Catch:{ all -> 0x0104 }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x00e3
            r14 = 1
            goto L_0x00e4
        L_0x00e3:
            r14 = 0
        L_0x00e4:
            r7 = r7 | r14
            r12 = r3
            goto L_0x00eb
        L_0x00e7:
            r22 = r4
        L_0x00e9:
            r1.f17950D = r2     // Catch:{ all -> 0x0104 }
        L_0x00eb:
            com.google.android.exoplayer2.t r14 = r1.f17973u
            long r20 = r25.m19508d()
            r15 = r8
            r16 = r12
            r18 = r10
            com.google.android.exoplayer2.t r0 = r14.mo25802a(r15, r16, r18, r20)
            r1.f17973u = r0
            if (r7 == 0) goto L_0x0103
            com.google.android.exoplayer2.l$c r0 = r1.f17968p
            r0.mo25504b(r9)
        L_0x0103:
            return
        L_0x0104:
            r0 = move-exception
            goto L_0x0109
        L_0x0106:
            r0 = move-exception
            r22 = r4
        L_0x0109:
            com.google.android.exoplayer2.t r14 = r1.f17973u
            long r20 = r25.m19508d()
            r15 = r8
            r16 = r12
            r18 = r10
            com.google.android.exoplayer2.t r3 = r14.mo25802a(r15, r16, r18, r20)
            r1.f17973u = r3
            if (r7 == 0) goto L_0x0121
            com.google.android.exoplayer2.l$c r3 = r1.f17968p
            r3.mo25504b(r9)
        L_0x0121:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.C8326l.m19486a(com.google.android.exoplayer2.l$d):void");
    }

    /* renamed from: a */
    private long m19476a(C8396a periodId, long periodPositionUs) throws ExoPlaybackException {
        return m19477a(periodId, periodPositionUs, this.f17971s.mo25640e() != this.f17971s.mo25641f());
    }

    /* renamed from: a */
    private long m19477a(C8396a periodId, long periodPositionUs, boolean forceDisableRenderers) throws ExoPlaybackException {
        m19529p();
        this.f17978z = false;
        m19497b(2);
        C8364q oldPlayingPeriodHolder = this.f17971s.mo25640e();
        C8364q newPlayingPeriodHolder = oldPlayingPeriodHolder;
        while (true) {
            if (newPlayingPeriodHolder != null) {
                if (periodId.equals(newPlayingPeriodHolder.f18124g.f18133a) && newPlayingPeriodHolder.f18122e) {
                    this.f17971s.mo25633a(newPlayingPeriodHolder);
                    break;
                }
                newPlayingPeriodHolder = this.f17971s.mo25624a();
            } else {
                break;
            }
        }
        if (oldPlayingPeriodHolder != newPlayingPeriodHolder || forceDisableRenderers) {
            for (C8572y renderer : this.f17975w) {
                m19490a(renderer);
            }
            this.f17975w = new C8572y[0];
            oldPlayingPeriodHolder = null;
        }
        if (newPlayingPeriodHolder != null) {
            m19487a(oldPlayingPeriodHolder);
            if (newPlayingPeriodHolder.f18123f) {
                periodPositionUs = newPlayingPeriodHolder.f18118a.mo25682a(periodPositionUs);
                newPlayingPeriodHolder.f18118a.mo25685a(periodPositionUs - this.f17965m, this.f17966n);
            }
            m19498b(periodPositionUs);
            m19518g();
        } else {
            this.f17971s.mo25631a(true);
            this.f17973u = this.f17973u.mo25799a(TrackGroupArray.f18154a, this.f17956d);
            m19498b(periodPositionUs);
        }
        m19506c(false);
        this.f17959g.mo26043a(2);
        return periodPositionUs;
    }

    /* renamed from: b */
    private void m19498b(long periodPositionUs) throws ExoPlaybackException {
        long j;
        if (!this.f17971s.mo25642g()) {
            j = periodPositionUs;
        } else {
            j = this.f17971s.mo25640e().mo25620d(periodPositionUs);
        }
        this.f17951E = j;
        this.f17967o.mo25459a(this.f17951E);
        for (C8572y renderer : this.f17975w) {
            renderer.mo25367a(this.f17951E);
        }
    }

    /* renamed from: b */
    private void m19501b(C8438u playbackParameters) {
        this.f17967o.mo25147a(playbackParameters);
    }

    /* renamed from: a */
    private void m19484a(C8096B seekParameters) {
        this.f17972t = seekParameters;
    }

    /* renamed from: a */
    private void m19491a(boolean reset, boolean acknowledgeStop) {
        m19492a(true, reset, reset);
        this.f17968p.mo25502a(this.f17949C + (acknowledgeStop));
        this.f17949C = 0;
        this.f17957e.mo25412a();
        m19497b(1);
    }

    /* renamed from: l */
    private void m19525l() {
        m19492a(true, true, true);
        this.f17957e.mo25420f();
        m19497b(1);
        this.f17960h.quit();
        synchronized (this) {
            this.f17976x = true;
            notifyAll();
        }
    }

    /* renamed from: a */
    private void m19492a(boolean releaseMediaSource, boolean resetPosition, boolean resetState) {
        this.f17959g.mo26045b(2);
        this.f17978z = false;
        this.f17967o.mo25463c();
        this.f17951E = 0;
        for (C8572y renderer : this.f17975w) {
            try {
                m19490a(renderer);
            } catch (ExoPlaybackException | RuntimeException e) {
                C8526n.m20530a("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.f17975w = new C8572y[0];
        this.f17971s.mo25631a(!resetPosition);
        m19514e(false);
        if (resetPosition) {
            this.f17950D = null;
        }
        if (resetState) {
            this.f17971s.mo25630a(C8098D.f16479a);
            Iterator it = this.f17969q.iterator();
            while (it.hasNext()) {
                ((C8328b) it.next()).f17982a.mo26232a(false);
            }
            this.f17969q.clear();
            this.f17952F = 0;
        }
        C8396a mediaPeriodId = resetPosition ? this.f17973u.mo25796a(this.f17948B, this.f17963k) : this.f17973u.f18367d;
        long j = -9223372036854775807L;
        long startPositionUs = resetPosition ? -9223372036854775807L : this.f17973u.f18377n;
        if (!resetPosition) {
            j = this.f17973u.f18369f;
        }
        long contentPositionUs = j;
        C8098D d = resetState ? C8098D.f16479a : this.f17973u.f18365b;
        Object obj = resetState ? null : this.f17973u.f18366c;
        C8414t tVar = this.f17973u;
        C8414t tVar2 = new C8414t(d, obj, mediaPeriodId, startPositionUs, contentPositionUs, tVar.f18370g, false, resetState ? TrackGroupArray.f18154a : tVar.f18372i, resetState ? this.f17956d : this.f17973u.f18373j, mediaPeriodId, startPositionUs, 0, startPositionUs);
        this.f17973u = tVar2;
        if (releaseMediaSource) {
            C8395r rVar = this.f17974v;
            if (rVar != null) {
                rVar.mo25679a((C8397b) this);
                this.f17974v = null;
            }
        }
    }

    /* renamed from: d */
    private void m19510d(C8569x message) throws ExoPlaybackException {
        if (message.mo26236d() == -9223372036854775807L) {
            m19513e(message);
        } else if (this.f17974v == null || this.f17949C > 0) {
            this.f17969q.add(new C8328b(message));
        } else {
            C8328b pendingMessageInfo = new C8328b(message);
            if (m19494a(pendingMessageInfo)) {
                this.f17969q.add(pendingMessageInfo);
                Collections.sort(this.f17969q);
                return;
            }
            message.mo26232a(false);
        }
    }

    /* renamed from: e */
    private void m19513e(C8569x message) throws ExoPlaybackException {
        if (message.mo26234b().getLooper() == this.f17959g.mo26039a()) {
            m19505c(message);
            int i = this.f17973u.f18370g;
            if (i == 3 || i == 2) {
                this.f17959g.mo26043a(2);
                return;
            }
            return;
        }
        this.f17959g.mo26042a(15, (Object) message).sendToTarget();
    }

    /* renamed from: f */
    private void m19515f(C8569x message) {
        message.mo26234b().post(new C8101a(this, message));
    }

    /* renamed from: b */
    public /* synthetic */ void mo25496b(C8569x message) {
        try {
            m19505c(message);
        } catch (ExoPlaybackException e) {
            C8526n.m20530a("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    private void m19505c(C8569x message) throws ExoPlaybackException {
        if (!message.mo26241i()) {
            try {
                message.mo26237e().mo25151a(message.mo26239g(), message.mo26235c());
            } finally {
                message.mo26232a(true);
            }
        }
    }

    /* renamed from: n */
    private void m19527n() {
        for (int i = this.f17969q.size() - 1; i >= 0; i--) {
            if (!m19494a((C8328b) this.f17969q.get(i))) {
                ((C8328b) this.f17969q.get(i)).f17982a.mo26232a(false);
                this.f17969q.remove(i);
            }
        }
        Collections.sort(this.f17969q);
    }

    /* renamed from: a */
    private boolean m19494a(C8328b pendingMessageInfo) {
        Object obj = pendingMessageInfo.f17985d;
        if (obj == null) {
            Pair<Object, Long> periodPosition = m19478a(new C8330d(pendingMessageInfo.f17982a.mo26238f(), pendingMessageInfo.f17982a.mo26240h(), C8275d.m19230a(pendingMessageInfo.f17982a.mo26236d())), false);
            if (periodPosition == null) {
                return false;
            }
            pendingMessageInfo.mo25500a(this.f17973u.f18365b.mo24970a(periodPosition.first), ((Long) periodPosition.second).longValue(), periodPosition.first);
        } else {
            int index = this.f17973u.f18365b.mo24970a(obj);
            if (index == -1) {
                return false;
            }
            pendingMessageInfo.f17983b = index;
        }
        return true;
    }

    /* renamed from: a */
    private void m19483a(long oldPeriodPositionUs, long newPeriodPositionUs) throws ExoPlaybackException {
        if (!this.f17969q.isEmpty() && !this.f17973u.f18367d.mo25724a()) {
            if (this.f17973u.f18368e == oldPeriodPositionUs) {
                oldPeriodPositionUs--;
            }
            C8414t tVar = this.f17973u;
            int currentPeriodIndex = tVar.f18365b.mo24970a(tVar.f18367d.f18288a);
            int i = this.f17952F;
            C8328b previousInfo = i > 0 ? (C8328b) this.f17969q.get(i - 1) : null;
            while (previousInfo != null) {
                int i2 = previousInfo.f17983b;
                if (i2 <= currentPeriodIndex && (i2 != currentPeriodIndex || previousInfo.f17984c <= oldPeriodPositionUs)) {
                    break;
                }
                this.f17952F--;
                int i3 = this.f17952F;
                previousInfo = i3 > 0 ? (C8328b) this.f17969q.get(i3 - 1) : null;
            }
            C8328b nextInfo = this.f17952F < this.f17969q.size() ? (C8328b) this.f17969q.get(this.f17952F) : null;
            while (nextInfo != null && nextInfo.f17985d != null) {
                int i4 = nextInfo.f17983b;
                if (i4 >= currentPeriodIndex && (i4 != currentPeriodIndex || nextInfo.f17984c > oldPeriodPositionUs)) {
                    break;
                }
                this.f17952F++;
                nextInfo = this.f17952F < this.f17969q.size() ? (C8328b) this.f17969q.get(this.f17952F) : null;
            }
            while (nextInfo != null && nextInfo.f17985d != null && nextInfo.f17983b == currentPeriodIndex) {
                long j = nextInfo.f17984c;
                if (j <= oldPeriodPositionUs || j > newPeriodPositionUs) {
                    break;
                }
                m19513e(nextInfo.f17982a);
                if (nextInfo.f17982a.mo26233a() || nextInfo.f17982a.mo26241i()) {
                    this.f17969q.remove(this.f17952F);
                } else {
                    this.f17952F++;
                }
                nextInfo = this.f17952F < this.f17969q.size() ? (C8328b) this.f17969q.get(this.f17952F) : null;
            }
        }
    }

    /* renamed from: b */
    private void m19502b(C8572y renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    /* renamed from: a */
    private void m19490a(C8572y renderer) throws ExoPlaybackException {
        this.f17967o.mo25460a(renderer);
        m19502b(renderer);
        renderer.mo25371c();
    }

    /* renamed from: m */
    private void m19526m() throws ExoPlaybackException {
        C8364q playingPeriodHolder;
        boolean selectionsChangedForReadPeriod;
        if (this.f17971s.mo25642g()) {
            float playbackSpeed = this.f17967o.mo25164e().f18483b;
            C8364q periodHolder = this.f17971s.mo25640e();
            C8364q readingPeriodHolder = this.f17971s.mo25641f();
            boolean selectionsChangedForReadPeriod2 = true;
            while (true) {
                if (periodHolder == null) {
                    boolean z = selectionsChangedForReadPeriod2;
                    break;
                } else if (!periodHolder.f18122e) {
                    boolean z2 = selectionsChangedForReadPeriod2;
                    break;
                } else if (periodHolder.mo25616b(playbackSpeed)) {
                    if (selectionsChangedForReadPeriod2) {
                        C8364q playingPeriodHolder2 = this.f17971s.mo25640e();
                        boolean[] streamResetFlags = new boolean[this.f17953a.length];
                        long periodPositionUs = playingPeriodHolder2.mo25611a(this.f17973u.f18377n, this.f17971s.mo25633a(playingPeriodHolder2), streamResetFlags);
                        C8414t tVar = this.f17973u;
                        if (tVar.f18370g == 4 || periodPositionUs == tVar.f18377n) {
                            playingPeriodHolder = playingPeriodHolder2;
                        } else {
                            C8414t tVar2 = this.f17973u;
                            playingPeriodHolder = playingPeriodHolder2;
                            this.f17973u = tVar2.mo25802a(tVar2.f18367d, periodPositionUs, tVar2.f18369f, m19508d());
                            this.f17968p.mo25504b(4);
                            m19498b(periodPositionUs);
                        }
                        int enabledRendererCount = 0;
                        boolean[] rendererWasEnabledFlags = new boolean[this.f17953a.length];
                        int i = 0;
                        while (true) {
                            C8572y[] yVarArr = this.f17953a;
                            if (i >= yVarArr.length) {
                                break;
                            }
                            C8572y renderer = yVarArr[i];
                            rendererWasEnabledFlags[i] = renderer.getState() != 0;
                            C8364q playingPeriodHolder3 = playingPeriodHolder;
                            C8408v sampleStream = playingPeriodHolder3.f18120c[i];
                            if (sampleStream != null) {
                                enabledRendererCount++;
                            }
                            if (!rendererWasEnabledFlags[i]) {
                                selectionsChangedForReadPeriod = selectionsChangedForReadPeriod2;
                            } else if (sampleStream != renderer.mo25379k()) {
                                m19490a(renderer);
                                selectionsChangedForReadPeriod = selectionsChangedForReadPeriod2;
                            } else if (streamResetFlags[i]) {
                                selectionsChangedForReadPeriod = selectionsChangedForReadPeriod2;
                                renderer.mo25367a(this.f17951E);
                            } else {
                                selectionsChangedForReadPeriod = selectionsChangedForReadPeriod2;
                            }
                            i++;
                            playingPeriodHolder = playingPeriodHolder3;
                            selectionsChangedForReadPeriod2 = selectionsChangedForReadPeriod;
                        }
                        C8364q playingPeriodHolder4 = playingPeriodHolder;
                        this.f17973u = this.f17973u.mo25799a(playingPeriodHolder4.f18126i, playingPeriodHolder4.f18127j);
                        m19493a(rendererWasEnabledFlags, enabledRendererCount);
                    } else {
                        this.f17971s.mo25633a(periodHolder);
                        if (periodHolder.f18122e) {
                            periodHolder.mo25610a(Math.max(periodHolder.f18124g.f18134b, periodHolder.mo25618c(this.f17951E)), false);
                        }
                    }
                    m19506c(true);
                    if (this.f17973u.f18370g != 4) {
                        m19518g();
                        m19531r();
                        this.f17959g.mo26043a(2);
                    }
                    return;
                } else {
                    boolean selectionsChangedForReadPeriod3 = selectionsChangedForReadPeriod2;
                    if (periodHolder == readingPeriodHolder) {
                        selectionsChangedForReadPeriod2 = false;
                    } else {
                        selectionsChangedForReadPeriod2 = selectionsChangedForReadPeriod3;
                    }
                    periodHolder = periodHolder.f18125h;
                }
            }
        }
    }

    /* renamed from: a */
    private void m19480a(float playbackSpeed) {
        C8432h[] trackSelections;
        for (C8364q periodHolder = this.f17971s.mo25638c(); periodHolder != null; periodHolder = periodHolder.f18125h) {
            C8437k kVar = periodHolder.f18127j;
            if (kVar != null) {
                for (C8432h trackSelection : kVar.f18480c.mo25856a()) {
                    if (trackSelection != null) {
                        trackSelection.mo25828a(playbackSpeed);
                    }
                }
            }
        }
    }

    /* renamed from: h */
    private boolean m19521h(boolean renderersReadyOrEnded) {
        if (this.f17975w.length == 0) {
            return m19517f();
        }
        boolean z = false;
        if (!renderersReadyOrEnded) {
            return false;
        }
        if (!this.f17973u.f18371h) {
            return true;
        }
        C8364q loadingHolder = this.f17971s.mo25639d();
        if ((loadingHolder.mo25621e() && loadingHolder.f18124g.f18138f) || this.f17957e.mo25415a(m19508d(), this.f17967o.mo25164e().f18483b, this.f17978z)) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    private boolean m19517f() {
        C8364q playingPeriodHolder = this.f17971s.mo25640e();
        long playingPeriodDurationUs = playingPeriodHolder.f18124g.f18136d;
        if (playingPeriodDurationUs != -9223372036854775807L && this.f17973u.f18377n >= playingPeriodDurationUs) {
            C8364q qVar = playingPeriodHolder.f18125h;
            if (qVar == null || (!qVar.f18122e && !qVar.f18124g.f18133a.mo25724a())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: j */
    private void m19523j() throws IOException {
        if (this.f17971s.mo25639d() != null) {
            C8572y[] yVarArr = this.f17975w;
            int length = yVarArr.length;
            int i = 0;
            while (i < length) {
                if (yVarArr[i].mo25373f()) {
                    i++;
                } else {
                    return;
                }
            }
        }
        this.f17974v.mo25720a();
    }

    /* renamed from: i */
    private void m19522i() throws IOException {
        C8364q loadingPeriodHolder = this.f17971s.mo25639d();
        C8364q readingPeriodHolder = this.f17971s.mo25641f();
        if (loadingPeriodHolder != null && !loadingPeriodHolder.f18122e && (readingPeriodHolder == null || readingPeriodHolder.f18125h == loadingPeriodHolder)) {
            C8572y[] yVarArr = this.f17975w;
            int length = yVarArr.length;
            int i = 0;
            while (i < length) {
                if (yVarArr[i].mo25373f()) {
                    i++;
                } else {
                    return;
                }
            }
            loadingPeriodHolder.f18118a.mo25690c();
        }
    }

    /* renamed from: a */
    private void m19485a(C8327a sourceRefreshInfo) throws ExoPlaybackException {
        C8327a aVar = sourceRefreshInfo;
        if (aVar.f17979a == this.f17974v) {
            C8098D oldTimeline = this.f17973u.f18365b;
            C8098D timeline = aVar.f17980b;
            Object manifest = aVar.f17981c;
            this.f17971s.mo25630a(timeline);
            this.f17973u = this.f17973u.mo25798a(timeline, manifest);
            m19527n();
            int i = this.f17949C;
            if (i > 0) {
                this.f17968p.mo25502a(i);
                this.f17949C = 0;
                C8330d dVar = this.f17950D;
                if (dVar != null) {
                    try {
                        Pair<Object, Long> periodPosition = m19478a(dVar, true);
                        this.f17950D = null;
                        if (periodPosition == null) {
                            m19512e();
                        } else {
                            Object periodUid = periodPosition.first;
                            long positionUs = ((Long) periodPosition.second).longValue();
                            C8396a periodId = this.f17971s.mo25628a(periodUid, positionUs);
                            this.f17973u = this.f17973u.mo25801a(periodId, periodId.mo25724a() ? 0 : positionUs, positionUs);
                        }
                    } catch (IllegalSeekPositionException e) {
                        IllegalSeekPositionException e2 = e;
                        this.f17973u = this.f17973u.mo25801a(this.f17973u.mo25796a(this.f17948B, this.f17963k), -9223372036854775807L, -9223372036854775807L);
                        throw e2;
                    }
                } else if (this.f17973u.f18368e == -9223372036854775807L) {
                    if (timeline.mo24986c()) {
                        m19512e();
                    } else {
                        Pair<Object, Long> defaultPosition = m19496b(timeline, timeline.mo24977a(this.f17948B), -9223372036854775807L);
                        Object periodUid2 = defaultPosition.first;
                        long startPositionUs = ((Long) defaultPosition.second).longValue();
                        C8396a periodId2 = this.f17971s.mo25628a(periodUid2, startPositionUs);
                        this.f17973u = this.f17973u.mo25801a(periodId2, periodId2.mo25724a() ? 0 : startPositionUs, startPositionUs);
                    }
                }
            } else if (oldTimeline.mo24986c()) {
                if (!timeline.mo24986c()) {
                    Pair<Object, Long> defaultPosition2 = m19496b(timeline, timeline.mo24977a(this.f17948B), -9223372036854775807L);
                    Object periodUid3 = defaultPosition2.first;
                    long startPositionUs2 = ((Long) defaultPosition2.second).longValue();
                    C8396a periodId3 = this.f17971s.mo25628a(periodUid3, startPositionUs2);
                    this.f17973u = this.f17973u.mo25801a(periodId3, periodId3.mo25724a() ? 0 : startPositionUs2, startPositionUs2);
                }
            } else {
                C8364q periodHolder = this.f17971s.mo25638c();
                C8414t tVar = this.f17973u;
                long contentPositionUs = tVar.f18369f;
                Object playingPeriodUid = periodHolder == null ? tVar.f18367d.f18288a : periodHolder.f18119b;
                int periodIndex = timeline.mo24970a(playingPeriodUid);
                if (periodIndex == -1) {
                    Object newPeriodUid = m19479a(playingPeriodUid, oldTimeline, timeline);
                    if (newPeriodUid == null) {
                        m19512e();
                        return;
                    }
                    Pair<Object, Long> defaultPosition3 = m19496b(timeline, timeline.mo24981a(newPeriodUid, this.f17964l).f16482c, -9223372036854775807L);
                    Object newPeriodUid2 = defaultPosition3.first;
                    long contentPositionUs2 = ((Long) defaultPosition3.second).longValue();
                    C8396a periodId4 = this.f17971s.mo25628a(newPeriodUid2, contentPositionUs2);
                    if (periodHolder != null) {
                        while (periodHolder.f18125h != null) {
                            periodHolder = periodHolder.f18125h;
                            if (periodHolder.f18124g.f18133a.equals(periodId4)) {
                                periodHolder.f18124g = this.f17971s.mo25626a(periodHolder.f18124g);
                            }
                        }
                    }
                    this.f17973u = this.f17973u.mo25802a(periodId4, m19476a(periodId4, periodId4.mo25724a() ? 0 : contentPositionUs2), contentPositionUs2, m19508d());
                    return;
                }
                C8396a playingPeriodId = this.f17973u.f18367d;
                if (playingPeriodId.mo25724a()) {
                    C8396a periodId5 = this.f17971s.mo25628a(playingPeriodUid, contentPositionUs);
                    if (!periodId5.equals(playingPeriodId)) {
                        int i2 = periodIndex;
                        this.f17973u = this.f17973u.mo25802a(periodId5, m19476a(periodId5, periodId5.mo25724a() ? 0 : contentPositionUs), contentPositionUs, m19508d());
                        return;
                    }
                    long j = contentPositionUs;
                } else {
                    long j2 = contentPositionUs;
                }
                if (!this.f17971s.mo25635a(playingPeriodId, this.f17951E)) {
                    m19511d(false);
                }
                m19506c(false);
            }
        }
    }

    /* renamed from: e */
    private void m19512e() {
        m19497b(4);
        m19492a(false, true, false);
    }

    /* renamed from: a */
    private Object m19479a(Object oldPeriodUid, C8098D oldTimeline, C8098D newTimeline) {
        int oldPeriodIndex = oldTimeline.mo24970a(oldPeriodUid);
        int newPeriodIndex = -1;
        int maxIterations = oldTimeline.mo24969a();
        for (int i = 0; i < maxIterations && newPeriodIndex == -1; i++) {
            oldPeriodIndex = oldTimeline.mo24976a(oldPeriodIndex, this.f17964l, this.f17963k, this.f17947A, this.f17948B);
            if (oldPeriodIndex == -1) {
                break;
            }
            newPeriodIndex = newTimeline.mo24970a(oldTimeline.mo24973a(oldPeriodIndex));
        }
        if (newPeriodIndex == -1) {
            return null;
        }
        return newTimeline.mo24973a(newPeriodIndex);
    }

    /* renamed from: a */
    private Pair<Object, Long> m19478a(C8330d seekPosition, boolean trySubsequentPeriods) {
        C8098D timeline = this.f17973u.f18365b;
        C8098D seekTimeline = seekPosition.f17990a;
        if (timeline.mo24986c()) {
            return null;
        }
        if (seekTimeline.mo24986c()) {
            seekTimeline = timeline;
        }
        try {
            Pair<Object, Long> periodPosition = seekTimeline.mo24978a(this.f17963k, this.f17964l, seekPosition.f17991b, seekPosition.f17992c);
            if (timeline == seekTimeline) {
                return periodPosition;
            }
            int periodIndex = timeline.mo24970a(periodPosition.first);
            if (periodIndex != -1) {
                return periodPosition;
            }
            if (!trySubsequentPeriods || m19479a(periodPosition.first, seekTimeline, timeline) == null) {
                return null;
            }
            return m19496b(timeline, timeline.mo24980a(periodIndex, this.f17964l).f16482c, -9223372036854775807L);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalSeekPositionException(timeline, seekPosition.f17991b, seekPosition.f17992c);
        }
    }

    /* renamed from: b */
    private Pair<Object, Long> m19496b(C8098D timeline, int windowIndex, long windowPositionUs) {
        return timeline.mo24978a(this.f17963k, this.f17964l, windowIndex, windowPositionUs);
    }

    /* renamed from: q */
    private void m19530q() throws ExoPlaybackException, IOException {
        C8364q playingPeriodHolder;
        C8364q loadingPeriodHolder;
        C8326l lVar = this;
        C8395r rVar = lVar.f17974v;
        if (rVar != null) {
            if (lVar.f17949C > 0) {
                rVar.mo25720a();
                return;
            }
            m19524k();
            C8364q loadingPeriodHolder2 = lVar.f17971s.mo25639d();
            if (loadingPeriodHolder2 == null || loadingPeriodHolder2.mo25621e()) {
                lVar.m19514e(false);
            } else if (!lVar.f17973u.f18371h) {
                m19518g();
            }
            if (lVar.f17971s.mo25642g()) {
                C8364q playingPeriodHolder2 = lVar.f17971s.mo25640e();
                C8364q readingPeriodHolder = lVar.f17971s.mo25641f();
                boolean advancedPlayingPeriod = false;
                while (lVar.f17977y && playingPeriodHolder2 != readingPeriodHolder && lVar.f17951E >= playingPeriodHolder2.f18125h.mo25619d()) {
                    if (advancedPlayingPeriod) {
                        m19520h();
                    }
                    int discontinuityReason = playingPeriodHolder2.f18124g.f18137e ? 0 : 3;
                    C8364q oldPlayingPeriodHolder = playingPeriodHolder2;
                    playingPeriodHolder2 = lVar.f17971s.mo25624a();
                    lVar.m19487a(oldPlayingPeriodHolder);
                    C8414t tVar = lVar.f17973u;
                    C8365r rVar2 = playingPeriodHolder2.f18124g;
                    lVar.f17973u = tVar.mo25802a(rVar2.f18133a, rVar2.f18134b, rVar2.f18135c, m19508d());
                    lVar.f17968p.mo25504b(discontinuityReason);
                    m19531r();
                    advancedPlayingPeriod = true;
                }
                if (readingPeriodHolder.f18124g.f18138f) {
                    int i = 0;
                    while (true) {
                        C8572y[] yVarArr = lVar.f17953a;
                        if (i < yVarArr.length) {
                            C8572y renderer = yVarArr[i];
                            C8408v sampleStream = readingPeriodHolder.f18120c[i];
                            if (sampleStream != null && renderer.mo25379k() == sampleStream && renderer.mo25373f()) {
                                renderer.mo25374g();
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                } else if (readingPeriodHolder.f18125h != null) {
                    int i2 = 0;
                    while (true) {
                        C8572y[] yVarArr2 = lVar.f17953a;
                        if (i2 < yVarArr2.length) {
                            C8572y renderer2 = yVarArr2[i2];
                            C8408v sampleStream2 = readingPeriodHolder.f18120c[i2];
                            if (renderer2.mo25379k() == sampleStream2 && (sampleStream2 == null || renderer2.mo25373f())) {
                                i2++;
                            }
                        } else if (!readingPeriodHolder.f18125h.f18122e) {
                            m19522i();
                            return;
                        } else {
                            C8437k oldTrackSelectorResult = readingPeriodHolder.f18127j;
                            C8364q readingPeriodHolder2 = lVar.f17971s.mo25636b();
                            C8437k newTrackSelectorResult = readingPeriodHolder2.f18127j;
                            boolean initialDiscontinuity = readingPeriodHolder2.f18118a.mo25687b() != -9223372036854775807L;
                            int i3 = 0;
                            while (true) {
                                C8572y[] yVarArr3 = lVar.f17953a;
                                if (i3 < yVarArr3.length) {
                                    C8572y renderer3 = yVarArr3[i3];
                                    if (!oldTrackSelectorResult.mo25861a(i3)) {
                                        loadingPeriodHolder = loadingPeriodHolder2;
                                        playingPeriodHolder = playingPeriodHolder2;
                                    } else if (initialDiscontinuity) {
                                        renderer3.mo25374g();
                                        loadingPeriodHolder = loadingPeriodHolder2;
                                        playingPeriodHolder = playingPeriodHolder2;
                                    } else if (!renderer3.mo25377i()) {
                                        C8432h newSelection = newTrackSelectorResult.f18480c.mo25855a(i3);
                                        boolean newRendererEnabled = newTrackSelectorResult.mo25861a(i3);
                                        boolean isNoSampleRenderer = lVar.f17954b[i3].mo25372d() == 6;
                                        C8095A oldConfig = oldTrackSelectorResult.f18479b[i3];
                                        C8095A newConfig = newTrackSelectorResult.f18479b[i3];
                                        if (!newRendererEnabled || !newConfig.equals(oldConfig) || isNoSampleRenderer) {
                                            loadingPeriodHolder = loadingPeriodHolder2;
                                            boolean z = isNoSampleRenderer;
                                            playingPeriodHolder = playingPeriodHolder2;
                                            renderer3.mo25374g();
                                        } else {
                                            loadingPeriodHolder = loadingPeriodHolder2;
                                            boolean z2 = isNoSampleRenderer;
                                            playingPeriodHolder = playingPeriodHolder2;
                                            renderer3.mo25369a(m19495a(newSelection), readingPeriodHolder2.f18120c[i3], readingPeriodHolder2.mo25617c());
                                        }
                                    } else {
                                        loadingPeriodHolder = loadingPeriodHolder2;
                                        playingPeriodHolder = playingPeriodHolder2;
                                    }
                                    i3++;
                                    lVar = this;
                                    loadingPeriodHolder2 = loadingPeriodHolder;
                                    playingPeriodHolder2 = playingPeriodHolder;
                                } else {
                                    C8364q qVar = playingPeriodHolder2;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: k */
    private void m19524k() throws IOException {
        this.f17971s.mo25629a(this.f17951E);
        if (this.f17971s.mo25643h()) {
            C8365r info = this.f17971s.mo25625a(this.f17951E, this.f17973u);
            if (info == null) {
                m19523j();
                return;
            }
            this.f17971s.mo25627a(this.f17954b, this.f17955c, this.f17957e.mo25419e(), this.f17974v, info).mo25686a((C8394a) this, info.f18134b);
            m19514e(true);
            m19506c(false);
        }
    }

    /* renamed from: d */
    private void m19509d(C8393q mediaPeriod) throws ExoPlaybackException {
        if (this.f17971s.mo25634a(mediaPeriod)) {
            C8364q loadingPeriodHolder = this.f17971s.mo25639d();
            loadingPeriodHolder.mo25612a(this.f17967o.mo25164e().f18483b);
            m19488a(loadingPeriodHolder.f18126i, loadingPeriodHolder.f18127j);
            if (!this.f17971s.mo25642g()) {
                m19498b(this.f17971s.mo25624a().f18124g.f18134b);
                m19487a((C8364q) null);
            }
            m19518g();
        }
    }

    /* renamed from: c */
    private void m19504c(C8393q mediaPeriod) {
        if (this.f17971s.mo25634a(mediaPeriod)) {
            this.f17971s.mo25629a(this.f17951E);
            m19518g();
        }
    }

    /* renamed from: a */
    private void m19489a(C8438u playbackParameters) throws ExoPlaybackException {
        C8572y[] yVarArr;
        this.f17961i.obtainMessage(1, playbackParameters).sendToTarget();
        m19480a(playbackParameters.f18483b);
        for (C8572y renderer : this.f17953a) {
            if (renderer != null) {
                renderer.mo25508a(playbackParameters.f18483b);
            }
        }
    }

    /* renamed from: g */
    private void m19518g() {
        C8364q loadingPeriodHolder = this.f17971s.mo25639d();
        long nextLoadPositionUs = loadingPeriodHolder.mo25614b();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            m19514e(false);
            return;
        }
        boolean continueLoading = this.f17957e.mo25414a(m19475a(nextLoadPositionUs), this.f17967o.mo25164e().f18483b);
        m19514e(continueLoading);
        if (continueLoading) {
            loadingPeriodHolder.mo25613a(this.f17951E);
        }
    }

    /* renamed from: a */
    private void m19487a(C8364q oldPlayingPeriodHolder) throws ExoPlaybackException {
        C8364q newPlayingPeriodHolder = this.f17971s.mo25640e();
        if (newPlayingPeriodHolder != null && oldPlayingPeriodHolder != newPlayingPeriodHolder) {
            int enabledRendererCount = 0;
            boolean[] rendererWasEnabledFlags = new boolean[this.f17953a.length];
            int i = 0;
            while (true) {
                C8572y[] yVarArr = this.f17953a;
                if (i < yVarArr.length) {
                    C8572y renderer = yVarArr[i];
                    rendererWasEnabledFlags[i] = renderer.getState() != 0;
                    if (newPlayingPeriodHolder.f18127j.mo25861a(i)) {
                        enabledRendererCount++;
                    }
                    if (rendererWasEnabledFlags[i] && (!newPlayingPeriodHolder.f18127j.mo25861a(i) || (renderer.mo25377i() && renderer.mo25379k() == oldPlayingPeriodHolder.f18120c[i]))) {
                        m19490a(renderer);
                    }
                    i++;
                } else {
                    this.f17973u = this.f17973u.mo25799a(newPlayingPeriodHolder.f18126i, newPlayingPeriodHolder.f18127j);
                    m19493a(rendererWasEnabledFlags, enabledRendererCount);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m19493a(boolean[] rendererWasEnabledFlags, int totalEnabledRendererCount) throws ExoPlaybackException {
        this.f17975w = new C8572y[totalEnabledRendererCount];
        int enabledRendererCount = 0;
        C8364q playingPeriodHolder = this.f17971s.mo25640e();
        for (int i = 0; i < this.f17953a.length; i++) {
            if (playingPeriodHolder.f18127j.mo25861a(i)) {
                int enabledRendererCount2 = enabledRendererCount + 1;
                m19482a(i, rendererWasEnabledFlags[i], enabledRendererCount);
                enabledRendererCount = enabledRendererCount2;
            }
        }
    }

    /* renamed from: a */
    private void m19482a(int rendererIndex, boolean wasRendererEnabled, int enabledRendererIndex) throws ExoPlaybackException {
        int i = rendererIndex;
        C8364q playingPeriodHolder = this.f17971s.mo25640e();
        C8572y renderer = this.f17953a[i];
        this.f17975w[enabledRendererIndex] = renderer;
        if (renderer.getState() == 0) {
            C8437k kVar = playingPeriodHolder.f18127j;
            C8095A rendererConfiguration = kVar.f18479b[i];
            Format[] formats = m19495a(kVar.f18480c.mo25855a(i));
            boolean playing = this.f17977y && this.f17973u.f18370g == 3;
            renderer.mo25368a(rendererConfiguration, formats, playingPeriodHolder.f18120c[i], this.f17951E, !wasRendererEnabled && playing, playingPeriodHolder.mo25617c());
            this.f17967o.mo25462b(renderer);
            if (playing) {
                renderer.start();
            }
        }
    }

    /* renamed from: c */
    private boolean m19507c(C8572y renderer) {
        C8364q qVar = this.f17971s.mo25641f().f18125h;
        return qVar != null && qVar.f18122e && renderer.mo25373f();
    }

    /* renamed from: c */
    private void m19506c(boolean loadingTrackSelectionChanged) {
        long j;
        C8364q loadingMediaPeriodHolder = this.f17971s.mo25639d();
        C8396a loadingMediaPeriodId = loadingMediaPeriodHolder == null ? this.f17973u.f18367d : loadingMediaPeriodHolder.f18124g.f18133a;
        boolean loadingMediaPeriodChanged = !this.f17973u.f18374k.equals(loadingMediaPeriodId);
        if (loadingMediaPeriodChanged) {
            this.f17973u = this.f17973u.mo25800a(loadingMediaPeriodId);
        }
        C8414t tVar = this.f17973u;
        if (loadingMediaPeriodHolder == null) {
            j = tVar.f18377n;
        } else {
            j = loadingMediaPeriodHolder.mo25609a();
        }
        tVar.f18375l = j;
        this.f17973u.f18376m = m19508d();
        if ((loadingMediaPeriodChanged || loadingTrackSelectionChanged) && loadingMediaPeriodHolder != null && loadingMediaPeriodHolder.f18122e) {
            m19488a(loadingMediaPeriodHolder.f18126i, loadingMediaPeriodHolder.f18127j);
        }
    }

    /* renamed from: d */
    private long m19508d() {
        return m19475a(this.f17973u.f18375l);
    }

    /* renamed from: a */
    private long m19475a(long bufferedPositionInLoadingPeriodUs) {
        C8364q loadingPeriodHolder = this.f17971s.mo25639d();
        if (loadingPeriodHolder == null) {
            return 0;
        }
        return bufferedPositionInLoadingPeriodUs - loadingPeriodHolder.mo25618c(this.f17951E);
    }

    /* renamed from: a */
    private void m19488a(TrackGroupArray trackGroups, C8437k trackSelectorResult) {
        this.f17957e.mo25413a(this.f17953a, trackGroups, trackSelectorResult.f18480c);
    }

    /* renamed from: a */
    private static Format[] m19495a(C8432h newSelection) {
        int length = newSelection != null ? newSelection.length() : 0;
        Format[] formats = new Format[length];
        for (int i = 0; i < length; i++) {
            formats[i] = newSelection.mo25831a(i);
        }
        return formats;
    }
}
