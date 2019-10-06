package com.fyber.inneractive.sdk.p166g.p168b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.p166g.p171e.C7856b;
import com.fyber.inneractive.sdk.p166g.p172f.C7869a;
import com.fyber.inneractive.sdk.p166g.p172f.C7870b;
import com.fyber.inneractive.sdk.util.C7993ag;

@TargetApi(19)
/* renamed from: com.fyber.inneractive.sdk.g.b.f */
public final class C7806f extends C7825l<C7809a> implements OnLayoutChangeListener, C7993ag {

    /* renamed from: a */
    private boolean f15715a;

    /* renamed from: com.fyber.inneractive.sdk.g.b.f$a */
    public interface C7809a extends C7832m {
        /* renamed from: c */
        void mo24476c();
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f15769e.mo24650a(true);
    }

    public C7806f(C7856b bVar, C7870b bVar2, C7712j jVar) {
        super(bVar, bVar2, jVar);
    }

    /* renamed from: c */
    public final boolean mo24439c() {
        C7870b bVar = this.f15769e;
        Boolean bool = bVar.f15926e;
        if (bool == null) {
            return bVar.f15922a.mo24210f().mo24221h() != UnitDisplayType.REWARDED;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24468a(Activity activity) {
        if (activity != null && !activity.isFinishing() && VERSION.SDK_INT >= 11) {
            C7870b bVar = this.f15769e;
            if (bVar != null && bVar.mo24745i() != null) {
                this.f15769e.mo24745i().onPause();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo24470b(Activity activity) {
        if (activity != null && VERSION.SDK_INT >= 11) {
            C7870b bVar = this.f15769e;
            if (bVar != null && bVar.mo24745i() != null) {
                this.f15769e.mo24745i().onResume();
            }
        }
    }

    @TargetApi(16)
    /* renamed from: m */
    public final void mo24450m() {
        if (this.f15768d.mo24210f().mo24222i()) {
            this.f15769e.mo24657e_();
        }
        C7870b bVar = this.f15769e;
        if (bVar != null && bVar.mo24745i() != null) {
            this.f15769e.mo24745i().addOnLayoutChangeListener(this);
        }
    }

    /* renamed from: e */
    public final void mo24471e() {
        if (this.f15772h != null && !this.f15715a) {
            this.f15715a = true;
            this.f15767c.post(new Runnable() {
                public final void run() {
                    ((C7809a) C7806f.this.f15772h).mo24476c();
                }
            });
        }
        C7870b bVar = this.f15769e;
        if (bVar != null && bVar.mo24745i() != null) {
            this.f15769e.mo24745i().removeOnLayoutChangeListener(this);
        }
    }

    /* renamed from: a */
    public final void mo24469a(Object obj) {
    }

    /* renamed from: f */
    public final void mo24472f() {
        if (!this.f15715a) {
            C7870b bVar = this.f15769e;
            if (bVar != null) {
                bVar.mo24741e(String.format("IAVPAIDWrapperInstance.onAndroidBackPressed('%s', '%s');", new Object[]{bVar.mo24658f(), bVar.f15922a.mo24210f().mo24221h().toString()}));
            }
            this.f15715a = true;
        }
    }

    @TargetApi(14)
    /* renamed from: c */
    public final void mo24441c(boolean z) {
        super.mo24441c(z);
        if (this.f15770f) {
            mo24536o();
            if (!this.f15769e.f15923b.equals(C7869a.Completed)) {
                this.f15767c.postDelayed(new Runnable() {
                    public final void run() {
                        C7806f.this.f15769e.mo24657e_();
                    }
                }, 100);
            }
            return;
        }
        if (!this.f15715a && mo24535n()) {
            this.f15769e.mo24655d();
        }
    }

    /* renamed from: a */
    public final void mo24432a() {
        this.f15715a = true;
        C7870b bVar = this.f15769e;
        if (!(bVar == null || bVar.mo24745i() == null)) {
            this.f15769e.mo24745i().removeOnLayoutChangeListener(this);
        }
        super.mo24432a();
    }
}
