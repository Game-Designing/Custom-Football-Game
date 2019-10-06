package com.fyber.inneractive.sdk.p166g.p168b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioManager;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.p166g.C7746a;
import com.fyber.inneractive.sdk.p166g.p169c.C7838b;
import com.fyber.inneractive.sdk.p166g.p171e.C7859d;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.g.b.d */
public final class C7798d extends C7814i<C7832m> {

    /* renamed from: a */
    private boolean f15695a = false;

    /* renamed from: b */
    private boolean f15696b = false;

    public C7798d(C7746a aVar, C7859d dVar, C7712j jVar, boolean z, boolean z2, boolean z3, Skip skip) {
        super(aVar, dVar, jVar, z, z3, skip);
        this.f15695a = z2;
    }

    /* renamed from: a_ */
    public final void mo24435a_(boolean z) {
        super.mo24435a_(z);
        if (this.f15695a) {
            this.f15737g.mo24624e();
            this.f15737g.mo24627f(false);
            this.f15740j = 0;
        }
        this.f15737g.mo24622c(mo24487s());
        this.f15737g.mo24619a(this.f15736f.mo24460l() == C7838b.Preparing || this.f15736f.mo24460l() == C7838b.Prepared);
        this.f15737g.mo24628g(false);
        this.f15737g.mo24620a(false, false);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public final boolean mo24442e() {
        if (!super.mo24442e()) {
            return false;
        }
        if (this.f15736f != null && !this.f15696b) {
            AudioManager audioManager = (AudioManager) this.f15737g.getContext().getSystemService("audio");
            int ringerMode = audioManager.getRingerMode();
            int streamVolume = audioManager.getStreamVolume(2);
            if (!this.f15695a && this.f15735e.mo24210f().mo24216c().booleanValue()) {
                mo24502f(false);
                mo24501e(false);
            } else if (streamVolume > 0 && ringerMode == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(IAlog.m18018a((Object) this));
                sb.append("setting default volume. unmuting player");
                IAlog.m18021b(sb.toString());
                mo24503g(false);
            }
            mo24498D();
            this.f15696b = true;
        }
        mo24493y();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final boolean mo24443f() {
        return !this.f15695a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final int mo24444g() {
        Skip skip = this.f15748r;
        if (skip == null) {
            skip = this.f15735e.mo24210f().mo24219f();
        }
        if (skip == Skip.DEFAULT) {
            return 99999;
        }
        return skip.value().intValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final void mo24445h() {
        super.mo24445h();
        if (mo24487s()) {
            this.f15737g.mo24622c(true);
        }
        mo24499E();
        mo24442e();
        mo24493y();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final int mo24446i() {
        return 12000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final void mo24447j() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append(" onBufferingTimeout reached. Dismissing ad");
        IAlog.m18021b(sb.toString());
        this.f15736f.mo24416a();
        ListenerT listenert = this.f15741k;
        if (listenert != null) {
            listenert.mo24558j();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final void mo24448k() {
        super.mo24448k();
        this.f15737g.mo24619a(false);
        if (this.f15695a) {
            this.f15737g.mo24624e();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public final void mo24449l() {
        super.mo24449l();
        ListenerT listenert = this.f15741k;
        if (listenert != null) {
            listenert.mo24558j();
        }
    }

    /* renamed from: m */
    public final void mo24450m() {
        super.mo24450m();
        if (this.f15742l) {
            mo24496B();
        } else {
            mo24442e();
        }
    }

    @TargetApi(14)
    /* renamed from: c */
    public final void mo24441c(boolean z) {
        if (z) {
            C7799e eVar = this.f15736f;
            if (eVar != null && !eVar.mo24460l().equals(C7838b.Completed)) {
                mo24493y();
            }
        }
        super.mo24441c(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public final void mo24451n() {
        TapAction g = this.f15735e.mo24210f().mo24220g();
        if (g == TapAction.CTR) {
            mo24490v();
            return;
        }
        if (!(g == TapAction.FULLSCREEN || g == TapAction.DO_NOTHING)) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("onVideoClicked called, but we recieved an unknown tap action ");
            sb.append(g);
            IAlog.m18021b(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final void mo24452o() {
        ListenerT listenert = this.f15741k;
        if (listenert != null) {
            listenert.mo24556h();
        }
    }

    /* renamed from: b */
    public final void mo24437b(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final void mo24453p() {
        super.mo24453p();
        if (this.f15736f.mo24460l().equals(C7838b.Completed) && this.f15695a) {
            this.f15737g.mo24624e();
        }
    }
}
