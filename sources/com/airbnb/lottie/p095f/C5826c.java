package com.airbnb.lottie.p095f;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.airbnb.lottie.C5830g;

/* renamed from: com.airbnb.lottie.f.c */
/* compiled from: LottieValueAnimator */
public class C5826c extends C5824a implements FrameCallback {

    /* renamed from: c */
    private float f10094c = 1.0f;

    /* renamed from: d */
    private boolean f10095d = false;

    /* renamed from: e */
    private long f10096e = 0;

    /* renamed from: f */
    private float f10097f = 0.0f;

    /* renamed from: g */
    private int f10098g = 0;

    /* renamed from: h */
    private float f10099h = -2.14748365E9f;

    /* renamed from: i */
    private float f10100i = 2.14748365E9f;

    /* renamed from: j */
    private C5830g f10101j;

    /* renamed from: k */
    protected boolean f10102k = false;

    public Object getAnimatedValue() {
        return Float.valueOf(mo18175k());
    }

    /* renamed from: k */
    public float mo18175k() {
        C5830g gVar = this.f10101j;
        if (gVar == null) {
            return 0.0f;
        }
        return (this.f10097f - gVar.mo18201k()) / (this.f10101j.mo18195e() - this.f10101j.mo18201k());
    }

    public float getAnimatedFraction() {
        if (this.f10101j == null) {
            return 0.0f;
        }
        if (m10501u()) {
            return (mo18177m() - this.f10097f) / (mo18177m() - mo18178n());
        }
        return (this.f10097f - mo18178n()) / (mo18177m() - mo18178n());
    }

    public long getDuration() {
        C5830g gVar = this.f10101j;
        if (gVar == null) {
            return 0;
        }
        return (long) gVar.mo18193c();
    }

    /* renamed from: l */
    public float mo18176l() {
        return this.f10097f;
    }

    public boolean isRunning() {
        return this.f10102k;
    }

    public void doFrame(long frameTimeNanos) {
        mo18181q();
        if (this.f10101j != null && isRunning()) {
            long now = System.nanoTime();
            float dFrames = ((float) (now - this.f10096e)) / m10500t();
            this.f10097f += m10501u() ? -dFrames : dFrames;
            boolean ended = !C5828e.m10532b(this.f10097f, mo18178n(), mo18177m());
            this.f10097f = C5828e.m10523a(this.f10097f, mo18178n(), mo18177m());
            this.f10096e = now;
            mo18151c();
            if (ended) {
                if (getRepeatCount() == -1 || this.f10098g < getRepeatCount()) {
                    mo18149b();
                    this.f10098g++;
                    if (getRepeatMode() == 2) {
                        this.f10095d = !this.f10095d;
                        mo18183s();
                    } else {
                        this.f10097f = m10501u() ? mo18177m() : mo18178n();
                    }
                    this.f10096e = now;
                } else {
                    this.f10097f = mo18177m();
                    mo18182r();
                    mo18146a(m10501u());
                }
            }
            m10502w();
        }
    }

    /* renamed from: t */
    private float m10500t() {
        C5830g gVar = this.f10101j;
        if (gVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / gVar.mo18197g()) / Math.abs(this.f10094c);
    }

    /* renamed from: d */
    public void mo18168d() {
        this.f10101j = null;
        this.f10099h = -2.14748365E9f;
        this.f10100i = 2.14748365E9f;
    }

    /* renamed from: a */
    public void mo18163a(C5830g composition) {
        boolean keepMinAndMaxFrames = this.f10101j == null;
        this.f10101j = composition;
        if (keepMinAndMaxFrames) {
            mo18162a((int) Math.max(this.f10099h, composition.mo18201k()), (int) Math.min(this.f10100i, composition.mo18195e()));
        } else {
            mo18162a((int) composition.mo18201k(), (int) composition.mo18195e());
        }
        mo18161a((int) this.f10097f);
        this.f10096e = System.nanoTime();
    }

    /* renamed from: a */
    public void mo18161a(int frame) {
        if (this.f10097f != ((float) frame)) {
            this.f10097f = C5828e.m10523a((float) frame, mo18178n(), mo18177m());
            this.f10096e = System.nanoTime();
            mo18151c();
        }
    }

    /* renamed from: c */
    public void mo18165c(int minFrame) {
        mo18162a(minFrame, (int) this.f10100i);
    }

    /* renamed from: b */
    public void mo18164b(int maxFrame) {
        mo18162a((int) this.f10099h, maxFrame);
    }

    /* renamed from: a */
    public void mo18162a(int minFrame, int maxFrame) {
        C5830g gVar = this.f10101j;
        float compositionMinFrame = gVar == null ? -3.4028235E38f : gVar.mo18201k();
        C5830g gVar2 = this.f10101j;
        float compositionMaxFrame = gVar2 == null ? Float.MAX_VALUE : gVar2.mo18195e();
        this.f10099h = C5828e.m10523a((float) minFrame, compositionMinFrame, compositionMaxFrame);
        this.f10100i = C5828e.m10523a((float) maxFrame, compositionMinFrame, compositionMaxFrame);
        mo18161a((int) C5828e.m10523a(this.f10097f, (float) minFrame, (float) maxFrame));
    }

    /* renamed from: s */
    public void mo18183s() {
        mo18160a(-mo18179o());
    }

    /* renamed from: a */
    public void mo18160a(float speed) {
        this.f10094c = speed;
    }

    /* renamed from: o */
    public float mo18179o() {
        return this.f10094c;
    }

    public void setRepeatMode(int value) {
        super.setRepeatMode(value);
        if (value != 2 && this.f10095d) {
            this.f10095d = false;
            mo18183s();
        }
    }

    /* renamed from: p */
    public void mo18180p() {
        this.f10102k = true;
        mo18150b(m10501u());
        mo18161a((int) (m10501u() ? mo18177m() : mo18178n()));
        this.f10096e = System.nanoTime();
        this.f10098g = 0;
        mo18181q();
    }

    /* renamed from: h */
    public void mo18173h() {
        mo18182r();
        mo18146a(m10501u());
    }

    public void cancel() {
        mo18145a();
        mo18182r();
    }

    /* renamed from: u */
    private boolean m10501u() {
        return mo18179o() < 0.0f;
    }

    /* renamed from: n */
    public float mo18178n() {
        C5830g gVar = this.f10101j;
        if (gVar == null) {
            return 0.0f;
        }
        float f = this.f10099h;
        if (f == -2.14748365E9f) {
            f = gVar.mo18201k();
        }
        return f;
    }

    /* renamed from: m */
    public float mo18177m() {
        C5830g gVar = this.f10101j;
        if (gVar == null) {
            return 0.0f;
        }
        float f = this.f10100i;
        if (f == 2.14748365E9f) {
            f = gVar.mo18195e();
        }
        return f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo18181q() {
        if (isRunning()) {
            mo18166c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo18182r() {
        mo18166c(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo18166c(boolean stopRunning) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (stopRunning) {
            this.f10102k = false;
        }
    }

    /* renamed from: w */
    private void m10502w() {
        if (this.f10101j != null) {
            float f = this.f10097f;
            if (f < this.f10099h || f > this.f10100i) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f10099h), Float.valueOf(this.f10100i), Float.valueOf(this.f10097f)}));
            }
        }
    }
}
