package com.smaato.soma.p261j;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.smaato.soma.p239c.p252i.C12279e;
import com.smaato.soma.p239c.p253j.C12282a;
import java.util.Vector;

/* renamed from: com.smaato.soma.j.h */
/* compiled from: VASTAdActivity */
class C12473h implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C12282a f38918a;

    /* renamed from: b */
    final /* synthetic */ C12474i f38919b;

    C12473h(C12474i this$1, C12282a aVar) {
        this.f38919b = this$1;
        this.f38918a = aVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean touchHandled = false;
        if (motionEvent.getAction() == 0) {
            String urlToOpen = null;
            try {
                if (this.f38918a.mo39678a() != null) {
                    urlToOpen = this.f38918a.mo39678a();
                } else if (!(this.f38918a.mo39689f() == null || this.f38919b.f38920a.f38932d.getVastAd().mo39707g() == null)) {
                    urlToOpen = this.f38919b.f38920a.f38932d.getVastAd().mo39707g();
                }
                if (urlToOpen != null) {
                    this.f38919b.m41006a(urlToOpen);
                    this.f38919b.f38920a.m41023h();
                    touchHandled = true;
                }
                new C12279e().execute(new Vector[]{this.f38918a.mo39682b()});
            } catch (Exception e) {
            }
        }
        return touchHandled;
    }
}
