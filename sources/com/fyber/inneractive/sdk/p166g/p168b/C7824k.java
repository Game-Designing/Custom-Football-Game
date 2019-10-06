package com.fyber.inneractive.sdk.p166g.p168b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.p166g.p168b.C7822j.C7823a;
import com.fyber.inneractive.sdk.p166g.p171e.C7854a.C7855a;
import com.fyber.inneractive.sdk.p166g.p171e.C7856b;
import com.fyber.inneractive.sdk.p166g.p172f.C7869a;
import com.fyber.inneractive.sdk.p166g.p172f.C7870b;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.g.b.k */
public final class C7824k extends C7825l<C7823a> implements C7822j, C7855a {

    /* renamed from: a */
    boolean f15759a = false;

    /* renamed from: b */
    boolean f15760b = false;

    /* renamed from: l */
    private float f15761l;

    /* renamed from: m */
    private float f15762m;

    /* renamed from: n */
    private float f15763n = 0.0f;

    /* renamed from: o */
    private boolean f15764o = false;

    /* renamed from: p */
    private boolean f15765p = false;

    public C7824k(C7856b bVar, C7870b bVar2, C7712j jVar) {
        super(bVar, bVar2, jVar);
        this.f15767c.setOnWindowFocusChangedListener(this);
        this.f15761l = ((float) this.f15768d.mo24209e().f15380b.intValue()) / 100.0f;
        this.f15762m = ((float) this.f15768d.mo24209e().f15379a.intValue()) / 100.0f;
    }

    /* renamed from: a_ */
    public final void mo24435a_(boolean z) {
    }

    /* renamed from: a */
    public final void mo24432a() {
        C7856b bVar = this.f15767c;
        if (bVar != null) {
            bVar.setOnWindowFocusChangedListener(null);
        }
        super.mo24432a();
    }

    /* renamed from: b */
    public final Bitmap mo24436b(boolean z) {
        return null;
    }

    /* renamed from: b */
    public final void mo24437b(int i) {
        if (this.f15767c.hasWindowFocus()) {
            C7870b bVar = this.f15769e;
            C7869a aVar = bVar.f15923b;
            if (aVar != C7869a.Playing && aVar != C7869a.Seeking && aVar != C7869a.Error) {
                bVar.mo24657e_();
            }
        }
    }

    /* renamed from: b_ */
    public final void mo24438b_() {
        this.f15769e.mo24655d();
    }

    /* renamed from: a_ */
    public final void mo24527a_() {
        if (this.f15772h != null && !this.f15764o) {
            this.f15764o = true;
            mo24537p();
            ((C7823a) this.f15772h).mo24526a();
        }
    }

    /* renamed from: c */
    public final boolean mo24439c() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24468a(Activity activity) {
        super.mo24441c(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo24470b(Activity activity) {
        if (!this.f15765p) {
            this.f15765p = true;
            this.f15767c.mo24604c();
            super.mo24441c(this.f15767c.mo24603b());
        }
    }

    /* renamed from: z */
    public final void mo24494z() {
        if (this.f15764o) {
            this.f15764o = false;
            this.f15765p = true;
            this.f15769e.setListener(this);
        }
    }

    /* renamed from: d */
    public final void mo24485d(boolean z) {
        this.f15760b = z;
        if (this.f15760b && this.f15767c.mo24603b()) {
            mo24484a(this.f15763n);
        }
    }

    /* renamed from: a */
    public final void mo24469a(Object obj) {
    }

    /* renamed from: c */
    public final void mo24441c(boolean z) {
        super.mo24441c(z);
    }

    @TargetApi(16)
    /* renamed from: a */
    public final void mo24484a(float f) {
        this.f15763n = f;
        C7870b bVar = this.f15769e;
        if (bVar != null) {
            C7869a aVar = bVar.f15923b;
            if (aVar.equals(C7869a.Playing)) {
                if (!this.f15764o && f > 0.0f && (this.f15765p || !this.f15775k)) {
                    this.f15765p = false;
                    if (!mo24535n()) {
                        mo24536o();
                    }
                }
                if ((f <= 1.0f - this.f15762m || !this.f15767c.hasWindowFocus()) && mo24535n() && !this.f15764o) {
                    this.f15759a = false;
                    this.f15769e.mo24655d();
                }
            } else if (aVar.equals(C7869a.Seeking) && mo24535n() && !this.f15767c.hasWindowFocus()) {
                this.f15759a = false;
                this.f15769e.mo24655d();
            } else if (f >= this.f15761l && this.f15767c.hasWindowFocus()) {
                StringBuilder sb = new StringBuilder();
                sb.append(IAlog.m18018a((Object) this));
                sb.append("onVisibilityChanged vfp accepted! att=");
                sb.append(mo24535n());
                sb.append(" ps = ");
                sb.append(aVar.toString());
                IAlog.m18019a(sb.toString());
                if (mo24535n() && ((this.f15768d.mo24210f().mo24213a().booleanValue() || this.f15759a) && !aVar.equals(C7869a.Completed))) {
                    mo24437b(IAConfigManager.m17004r());
                } else if (!mo24535n()) {
                    mo24536o();
                }
            }
        }
    }

    /* renamed from: g */
    public final void mo24528g() {
        mo24484a(this.f15763n);
    }
}
