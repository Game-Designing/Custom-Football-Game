package com.fyber.inneractive.sdk.p166g.p171e;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.C7994ah;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.g.e.a */
public abstract class C7854a extends RelativeLayout implements C7862g {

    /* renamed from: a */
    protected int f15862a;

    /* renamed from: b */
    protected C7712j f15863b;

    /* renamed from: c */
    protected UnitDisplayType f15864c;

    /* renamed from: d */
    protected boolean f15865d;

    /* renamed from: e */
    protected boolean f15866e;

    /* renamed from: f */
    protected C7863h f15867f;

    /* renamed from: com.fyber.inneractive.sdk.g.e.a$a */
    public interface C7855a {
        /* renamed from: g */
        void mo24528g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo24602a(C7994ah ahVar, int i, int i2);

    public C7854a(Context context) {
        this(context, 0);
    }

    private C7854a(Context context, byte b) {
        this(context, 0);
    }

    public C7854a(Context context, char c) {
        super(context, null, 0);
        this.f15862a = 0;
        this.f15865d = false;
        this.f15866e = false;
        this.f15862a = Math.min(C8006j.m18081t(), C8006j.m18080s());
    }

    public void setListener(C7863h hVar) {
        this.f15867f = hVar;
    }

    public void setUnitConfig(C7712j jVar) {
        this.f15863b = jVar;
        this.f15864c = jVar.mo24208d() == null ? jVar.mo24210f().mo24221h() : UnitDisplayType.DEFAULT;
    }

    /* renamed from: a */
    public void mo24601a() {
        if (this.f15867f != null) {
            this.f15867f = null;
        }
    }

    /* renamed from: b */
    public final boolean mo24603b() {
        return this.f15865d;
    }

    /* renamed from: c */
    public final void mo24604c() {
        boolean z = isShown() && hasWindowFocus() && this.f15866e;
        if (z) {
            z = getGlobalVisibleRect(new Rect());
        }
        if (z != this.f15865d && this.f15867f != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("updateVisibility changing to ");
            sb.append(z);
            IAlog.m18021b(sb.toString());
            this.f15865d = z;
            this.f15867f.mo24441c(this.f15865d);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (equals(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("got onVisibilityChanged with ");
            sb.append(i);
            IAlog.m18021b(sb.toString());
            mo24604c();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("got onWindowFocusChanged");
        IAlog.m18021b(sb.toString());
        mo24604c();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("Got onAttachedToWindow: mIsAttached = ");
        sb.append(this.f15866e);
        IAlog.m18021b(sb.toString());
        this.f15866e = true;
        C7863h hVar = this.f15867f;
        if (hVar != null) {
            hVar.mo24450m();
        }
        mo24604c();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("Got onDetachedFromWindow: mIsAttached = ");
        sb.append(this.f15866e);
        IAlog.m18021b(sb.toString());
        this.f15866e = false;
        C7863h hVar = this.f15867f;
        if (hVar != null) {
            hVar.mo24486r();
        }
        mo24604c();
    }
}
