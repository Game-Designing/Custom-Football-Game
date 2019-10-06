package com.smaato.soma.p239c.p254k;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12369fa;
import com.smaato.soma.p239c.p251h.C12266b.C12267a;
import com.smaato.soma.p239c.p254k.C12301p.C12302a;

/* renamed from: com.smaato.soma.c.k.c */
/* compiled from: CustomWebView */
class C12288c extends C12302a {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f38455b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f38456c = 0;

    /* renamed from: d */
    final /* synthetic */ C12369fa f38457d;

    /* renamed from: e */
    final /* synthetic */ C12064Na f38458e;

    /* renamed from: f */
    final /* synthetic */ C12301p f38459f;

    C12288c(C12301p this$0, Context ctx, C12369fa faVar, C12064Na na) {
        this.f38459f = this$0;
        this.f38457d = faVar;
        this.f38458e = na;
        super(ctx);
    }

    /* renamed from: i */
    public void mo39711i() {
        if (this.f38459f.f38479a) {
            this.f38455b--;
        } else {
            this.f38455b++;
        }
        m40467j();
    }

    /* renamed from: h */
    public void mo39710h() {
        if (this.f38459f.f38479a) {
            this.f38455b--;
        } else {
            this.f38455b++;
        }
        m40467j();
    }

    public boolean onTouch(View v, MotionEvent event) {
        super.onTouch(v, event);
        if (this.f38457d.getBannerState().mo39638a() == C12267a.STATE_BANNEREXPANDED) {
            return false;
        }
        return ((Boolean) new C12286a(this, event, v).execute()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m40468k() {
        if (this.f38456c != 0 && System.currentTimeMillis() - this.f38456c <= 2000) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    private void m40467j() {
        new C12287b(this).execute();
    }
}
