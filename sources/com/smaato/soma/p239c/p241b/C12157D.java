package com.smaato.soma.p239c.p241b;

import android.view.View;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.b.D */
/* compiled from: ScreenMetricsWaiter */
class C12157D extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Runnable f38110a;

    /* renamed from: b */
    final /* synthetic */ View[] f38111b;

    C12157D(Runnable runnable, View[] viewArr) {
        this.f38110a = runnable;
        this.f38111b = viewArr;
    }

    public Void process() {
        if (C12159F.f38116e) {
            this.f38110a.run();
        } else {
            View[] viewArr = this.f38111b;
            if (viewArr != null) {
                C12159F.f38113b = viewArr;
                C12159F.f38114c = this.f38110a;
                C12159F.f38115d = C12159F.f38113b.length;
                C12159F.f38112a.post(C12159F.f38117f);
            }
        }
        return null;
    }
}
