package com.fyber.inneractive.sdk.p166g.p168b;

import android.graphics.Rect;
import android.view.View;
import com.fyber.inneractive.sdk.util.C8034w.C8039b;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.g.b.g */
public abstract class C7810g implements C8039b {

    /* renamed from: a */
    protected float f15718a = 0.0f;

    /* renamed from: b */
    protected Rect f15719b = new Rect();

    /* renamed from: c */
    boolean f15720c = false;

    /* renamed from: d */
    boolean f15721d;

    /* renamed from: e */
    final Runnable f15722e = new Runnable() {
        public final void run() {
            if (C7810g.this.mo24477a() != null) {
                C7810g gVar = C7810g.this;
                if (gVar.f15721d) {
                    gVar.f15720c = true;
                    gVar.mo24479b();
                    StringBuilder sb = new StringBuilder();
                    sb.append(IAlog.m18018a((Object) C7810g.this));
                    sb.append("Idle state reached!");
                    IAlog.m18021b(sb.toString());
                }
            }
        }
    };

    /* renamed from: a */
    public abstract View mo24477a();

    /* renamed from: b */
    public abstract void mo24479b();

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public final boolean mo24478a_(float f, Rect rect) {
        if (this.f15718a == f && this.f15719b.equals(rect)) {
            return false;
        }
        this.f15718a = f;
        this.f15719b.set(rect);
        this.f15720c = false;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo24480c() {
        mo24481d();
        if (IAlog.f16291a >= 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("Checking for idle state in 100 msec");
            IAlog.m18022c(sb.toString());
        }
        this.f15721d = true;
        mo24477a().postDelayed(this.f15722e, 100);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo24481d() {
        this.f15721d = false;
        if (mo24477a() != null) {
            mo24477a().removeCallbacks(this.f15722e);
        }
    }
}
