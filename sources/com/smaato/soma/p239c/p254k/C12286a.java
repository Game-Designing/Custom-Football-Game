package com.smaato.soma.p239c.p254k;

import android.view.MotionEvent;
import android.view.View;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p252i.C12277c;
import com.smaato.soma.p239c.p252i.C12279e;
import java.util.Vector;

/* renamed from: com.smaato.soma.c.k.a */
/* compiled from: CustomWebView */
class C12286a extends C12398ha<Boolean> {

    /* renamed from: a */
    final /* synthetic */ MotionEvent f38451a;

    /* renamed from: b */
    final /* synthetic */ View f38452b;

    /* renamed from: c */
    final /* synthetic */ C12288c f38453c;

    C12286a(C12288c this$1, MotionEvent motionEvent, View view) {
        this.f38453c = this$1;
        this.f38451a = motionEvent;
        this.f38452b = view;
    }

    public Boolean process() throws Exception {
        boolean z = false;
        if (this.f38451a.getAction() == 1 && !this.f38453c.m40468k()) {
            if (C12277c.m40409a().mo39665a(this.f38452b, this.f38451a.getX(), this.f38451a.getY())) {
                if (!this.f38453c.f38459f.mo39721a()) {
                    new C12279e().execute(new Vector[]{this.f38453c.f38458e.mo39287d()});
                }
                ((C12301p) this.f38452b).setUserClicked(true);
                this.f38452b.setVerticalScrollBarEnabled(true);
                this.f38452b.setHorizontalScrollBarEnabled(true);
                if (!this.f38453c.f38457d.getCurrentPackage().mo39365p()) {
                    this.f38453c.f38459f.m40478c();
                }
            } else {
                C12146d.m39965a(new C12147e("SOMA", "Click was outside the banner view, skipping expand ...", 1, C12143a.WARNING));
                return Boolean.valueOf(true);
            }
        }
        if (this.f38451a.getAction() == 2) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
