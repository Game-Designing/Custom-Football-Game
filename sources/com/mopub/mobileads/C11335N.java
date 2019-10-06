package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.BaseLifecycleListener;
import p019d.p273h.p276c.C12741D;

/* renamed from: com.mopub.mobileads.N */
/* compiled from: IronSourceRewardedVideo */
class C11335N extends BaseLifecycleListener {

    /* renamed from: a */
    final /* synthetic */ IronSourceRewardedVideo f34884a;

    C11335N(IronSourceRewardedVideo this$0) {
        this.f34884a = this$0;
    }

    public void onPause(Activity activity) {
        super.onPause(activity);
        C12741D.m41151a(activity);
    }

    public void onResume(Activity activity) {
        super.onResume(activity);
        C12741D.m41159b(activity);
    }
}
