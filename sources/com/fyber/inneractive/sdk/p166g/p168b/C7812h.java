package com.fyber.inneractive.sdk.p166g.p168b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.config.C7711i;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.p166g.C7746a;
import com.fyber.inneractive.sdk.p166g.p168b.C7822j.C7823a;
import com.fyber.inneractive.sdk.p166g.p169c.C7838b;
import com.fyber.inneractive.sdk.p166g.p171e.C7864i;
import com.fyber.inneractive.sdk.p174i.C7915o.C7916a;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.g.b.h */
public final class C7812h extends C7814i<C7823a> implements C7822j {

    /* renamed from: a */
    Runnable f15724a;

    /* renamed from: b */
    boolean f15725b = false;

    /* renamed from: c */
    boolean f15726c = false;

    /* renamed from: s */
    private float f15727s = (((float) this.f15735e.mo24209e().f15380b.intValue()) / 100.0f);

    /* renamed from: t */
    private float f15728t = 0.0f;

    /* renamed from: u */
    private boolean f15729u = false;

    public C7812h(C7746a aVar, C7864i iVar, C7711i iVar2, boolean z, boolean z2) {
        super(aVar, iVar, iVar2, z, z2);
        m17390I();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public final boolean mo24442e() {
        if (!super.mo24442e()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("connectToTextureView playing state = ");
        sb.append(this.f15736f.mo24460l());
        IAlog.m18021b(sb.toString());
        if (this.f15736f.mo24461m()) {
            this.f15737g.mo24628g(false);
            this.f15737g.mo24620a(false, false);
            this.f15737g.mo24619a(false);
            m17390I();
        }
        mo24484a(this.f15728t);
        return true;
    }

    /* renamed from: c */
    public final boolean mo24439c() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final boolean mo24443f() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final int mo24444g() {
        return 0;
    }

    /* renamed from: a_ */
    public final void mo24435a_(boolean z) {
        if (!this.f15736f.mo24460l().equals(C7838b.Completed)) {
            m17388G();
        }
        Bitmap bitmap = this.f15734d.f15514e;
        if (bitmap != null) {
            this.f15737g.mo24619a(true);
            this.f15737g.setLastFrameBitmap(bitmap);
        }
        super.mo24435a_(z);
    }

    @TargetApi(14)
    /* renamed from: c */
    public final void mo24441c(boolean z) {
        if (z) {
            mo24484a(this.f15728t);
        }
        super.mo24441c(z);
    }

    /* renamed from: r */
    public final void mo24486r() {
        super.mo24486r();
    }

    /* renamed from: b */
    public final void mo24437b(int i) {
        C7799e eVar = this.f15736f;
        if (!(eVar == null || eVar.mo24460l() == C7838b.Playing || this.f15724a != null)) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("playVideo ");
            sb.append(this.f15737g);
            IAlog.m18021b(sb.toString());
            if (i == 0) {
                mo24493y();
            } else {
                this.f15724a = new Runnable() {
                    public final void run() {
                        C7812h.this.mo24493y();
                        C7812h.this.f15724a = null;
                    }
                };
                this.f15737g.postDelayed(this.f15724a, (long) i);
            }
        }
    }

    /* renamed from: b_ */
    public final void mo24438b_() {
        m17387F();
        super.mo24438b_();
    }

    @TargetApi(14)
    /* renamed from: a */
    public final void mo24432a() {
        m17387F();
        this.f15741k = null;
        super.mo24432a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final int mo24446i() {
        return 5000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final void mo24447j() {
        if (this.f15737g.mo24603b()) {
            this.f15736f.mo24416a();
        }
        mo24449l();
    }

    /* renamed from: F */
    private void m17387F() {
        if (this.f15724a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("Cancelling play runnable");
            IAlog.m18021b(sb.toString());
            this.f15737g.removeCallbacks(this.f15724a);
            this.f15724a = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final void mo24448k() {
        super.mo24448k();
        m17388G();
        this.f15737g.mo24619a(false);
        this.f15725b = true;
    }

    /* renamed from: G */
    private void m17388G() {
        if (this.f15735e.mo24210f().mo24220g() != TapAction.FULLSCREEN) {
            C7864i iVar = this.f15737g;
            ImageView imageView = iVar.f15890r;
            if (imageView != null) {
                imageView.setVisibility(0);
                iVar.f15890r.setSelected(false);
            }
        }
        this.f15737g.mo24622c(mo24487s());
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public final boolean mo24487s() {
        return super.mo24487s() && this.f15735e.mo24210f().mo24220g() != TapAction.CTR;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public final void mo24488t() {
        super.mo24488t();
        m17387F();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final void mo24445h() {
        if (this.f15736f != null) {
            mo24442e();
            mo24493y();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public final void mo24489u() {
        m17387F();
        super.mo24489u();
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public final void mo24451n() {
        TapAction g = this.f15735e.mo24210f().mo24220g();
        if (this.f15736f == null || this.f15728t >= this.f15727s) {
            if (g == TapAction.CTR) {
                mo24490v();
            } else if (g == TapAction.FULLSCREEN) {
                m17389H();
            } else if (g != TapAction.DO_NOTHING) {
                StringBuilder sb = new StringBuilder();
                sb.append(IAlog.m18018a((Object) this));
                sb.append("onVideoClicked called, but we recieved an unknown tap action ");
                sb.append(g);
                IAlog.m18021b(sb.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final void mo24452o() {
        m17389H();
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public final boolean mo24490v() {
        Bitmap b = mo24436b(false);
        if (!super.mo24490v()) {
            return false;
        }
        if (b != null) {
            this.f15737g.setLastFrameBitmap(b);
            this.f15737g.mo24619a(true);
        }
        return true;
    }

    /* renamed from: H */
    private void m17389H() {
        if (this.f15741k != null && !this.f15729u) {
            mo24489u();
            ((C7823a) this.f15741k).mo24526a();
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("opening fullscreen");
            IAlog.m18021b(sb.toString());
            this.f15729u = true;
            this.f15734d.mo24332a(C7916a.EVENT_FULLSCREEN, C7916a.EVENT_EXPAND);
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    public final void mo24484a(float f) {
        this.f15728t = f;
        if (IAlog.f16291a >= 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("onVisibilityChanged called with: ");
            sb.append(f);
            sb.append(" vfpl = ");
            sb.append(this.f15727s);
            sb.append(" vfpa = ");
            sb.append(1.0f - this.f15727s);
            IAlog.m18022c(sb.toString());
        }
        C7799e eVar = this.f15736f;
        if (eVar != null) {
            if (eVar.mo24460l() != C7838b.Playing) {
                m17391J();
            } else if (f <= this.f15727s) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(IAlog.m18018a((Object) this));
                sb2.append("onVisibilityChanged pausing player");
                IAlog.m18019a(sb2.toString());
                if (this.f15738h != null) {
                    this.f15725b = false;
                    mo24436b(false);
                    mo24438b_();
                    mo24502f(false);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public final void mo24491w() {
        super.mo24491w();
        m17391J();
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public final boolean mo24492x() {
        return super.mo24492x() && this.f15726c && !this.f15729u;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public final void mo24493y() {
        if (this.f15736f != null) {
            m17390I();
            super.mo24493y();
        }
    }

    /* renamed from: I */
    private void m17390I() {
        if (!this.f15736f.mo24462n()) {
            if (this.f15735e.mo24210f().mo24216c().booleanValue()) {
                this.f15736f.mo24420a(false);
            } else if (!mo24497C()) {
                this.f15736f.mo24421b(false);
            }
        }
    }

    /* renamed from: d */
    public final void mo24485d(boolean z) {
        this.f15726c = z;
        if (this.f15726c && this.f15738h == null && this.f15737g.mo24603b() && !this.f15736f.mo24460l().equals(C7838b.Completed)) {
            mo24442e();
            mo24484a(this.f15728t);
        }
    }

    /* renamed from: z */
    public final void mo24494z() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("fullscreenExited called");
        IAlog.m18021b(sb.toString());
        this.f15729u = false;
        mo24485d(this.f15726c);
        mo24329a(this.f15736f.mo24460l());
        mo24323a(this.f15736f.mo24428h());
    }

    /* renamed from: A */
    public final void mo24483A() {
        this.f15734d.mo24322a();
    }

    /* renamed from: J */
    private void m17391J() {
        if (this.f15728t >= this.f15727s && !this.f15736f.mo24460l().equals(C7838b.Completed) && this.f15738h != null) {
            if (this.f15735e.mo24210f().mo24213a().booleanValue() || this.f15725b) {
                mo24437b(IAConfigManager.m17004r());
            }
        }
    }
}
