package com.smaato.soma.p239c.p252i;

import android.view.View;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.i.b */
/* compiled from: Controller */
class C12276b extends C12398ha<Boolean> {

    /* renamed from: a */
    final /* synthetic */ float f38425a;

    /* renamed from: b */
    final /* synthetic */ View f38426b;

    /* renamed from: c */
    final /* synthetic */ float f38427c;

    /* renamed from: d */
    final /* synthetic */ C12277c f38428d;

    C12276b(C12277c this$0, float f, View view, float f2) {
        this.f38428d = this$0;
        this.f38425a = f;
        this.f38426b = view;
        this.f38427c = f2;
    }

    public Boolean process() throws Exception {
        boolean z;
        float f = this.f38425a;
        if (f >= 0.0f && f <= ((float) this.f38426b.getWidth())) {
            float f2 = this.f38427c;
            if (f2 >= 0.0f && f2 <= ((float) this.f38426b.getHeight())) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
