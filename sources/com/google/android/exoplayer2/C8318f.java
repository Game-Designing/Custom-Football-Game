package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.C8517g;
import com.google.android.exoplayer2.util.C8528p;
import com.google.android.exoplayer2.util.C8542z;

/* renamed from: com.google.android.exoplayer2.f */
/* compiled from: DefaultMediaClock */
final class C8318f implements C8528p {

    /* renamed from: a */
    private final C8542z f17905a;

    /* renamed from: b */
    private final C8319a f17906b;

    /* renamed from: c */
    private C8572y f17907c;

    /* renamed from: d */
    private C8528p f17908d;

    /* renamed from: com.google.android.exoplayer2.f$a */
    /* compiled from: DefaultMediaClock */
    public interface C8319a {
        void onPlaybackParametersChanged(C8438u uVar);
    }

    public C8318f(C8319a listener, C8517g clock) {
        this.f17906b = listener;
        this.f17905a = new C8542z(clock);
    }

    /* renamed from: b */
    public void mo25461b() {
        this.f17905a.mo26154b();
    }

    /* renamed from: c */
    public void mo25463c() {
        this.f17905a.mo26155c();
    }

    /* renamed from: a */
    public void mo25459a(long positionUs) {
        this.f17905a.mo26153a(positionUs);
    }

    /* renamed from: b */
    public void mo25462b(C8572y renderer) throws ExoPlaybackException {
        C8528p rendererMediaClock = renderer.mo25166l();
        if (rendererMediaClock != null) {
            C8528p pVar = this.f17908d;
            if (rendererMediaClock == pVar) {
                return;
            }
            if (pVar == null) {
                this.f17908d = rendererMediaClock;
                this.f17907c = renderer;
                this.f17908d.mo25147a(this.f17905a.mo25164e());
                m19436f();
                return;
            }
            throw ExoPlaybackException.m18242a((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    /* renamed from: a */
    public void mo25460a(C8572y renderer) {
        if (renderer == this.f17907c) {
            this.f17908d = null;
            this.f17907c = null;
        }
    }

    /* renamed from: d */
    public long mo25464d() {
        if (!m19437g()) {
            return this.f17905a.mo25145a();
        }
        m19436f();
        return this.f17908d.mo25145a();
    }

    /* renamed from: a */
    public long mo25145a() {
        if (m19437g()) {
            return this.f17908d.mo25145a();
        }
        return this.f17905a.mo25145a();
    }

    /* renamed from: a */
    public C8438u mo25147a(C8438u playbackParameters) {
        C8528p pVar = this.f17908d;
        if (pVar != null) {
            playbackParameters = pVar.mo25147a(playbackParameters);
        }
        this.f17905a.mo25147a(playbackParameters);
        this.f17906b.onPlaybackParametersChanged(playbackParameters);
        return playbackParameters;
    }

    /* renamed from: e */
    public C8438u mo25164e() {
        C8528p pVar = this.f17908d;
        if (pVar != null) {
            return pVar.mo25164e();
        }
        return this.f17905a.mo25164e();
    }

    /* renamed from: f */
    private void m19436f() {
        this.f17905a.mo26153a(this.f17908d.mo25145a());
        C8438u playbackParameters = this.f17908d.mo25164e();
        if (!playbackParameters.equals(this.f17905a.mo25164e())) {
            this.f17905a.mo25147a(playbackParameters);
            this.f17906b.onPlaybackParametersChanged(playbackParameters);
        }
    }

    /* renamed from: g */
    private boolean m19437g() {
        C8572y yVar = this.f17907c;
        return yVar != null && !yVar.mo25162b() && (this.f17907c.isReady() || !this.f17907c.mo25373f());
    }
}
