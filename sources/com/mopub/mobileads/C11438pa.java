package com.mopub.mobileads;

import com.mopub.mraid.MraidController.UseCustomCloseListener;

/* renamed from: com.mopub.mobileads.pa */
/* compiled from: MraidActivity */
class C11438pa implements UseCustomCloseListener {

    /* renamed from: a */
    final /* synthetic */ MraidActivity f35351a;

    C11438pa(MraidActivity this$0) {
        this.f35351a = this$0;
    }

    public void useCustomCloseChanged(boolean useCustomClose) {
        if (useCustomClose) {
            this.f35351a.mo37565d();
        } else {
            this.f35351a.mo37566e();
        }
    }
}
