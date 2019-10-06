package com.smaato.soma;

import android.animation.ObjectAnimator;

/* renamed from: com.smaato.soma.Va */
/* compiled from: ToasterBanner */
class C12079Va extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12081Wa f37945a;

    C12079Va(C12081Wa this$2) {
        this.f37945a = this$2;
    }

    public Void process() throws Exception {
        C12081Wa wa = this.f37945a;
        C12366eb ebVar = wa.f37948b.f37951a;
        int i = wa.f37947a;
        ObjectAnimator pullUp2 = ObjectAnimator.ofFloat(ebVar, "translationY", new float[]{(float) (i - 20), (float) i});
        pullUp2.setDuration(100);
        pullUp2.start();
        return null;
    }
}
