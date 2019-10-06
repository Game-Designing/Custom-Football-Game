package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mopub.common.util.Visibility;

/* renamed from: com.mopub.mobileads.la */
/* compiled from: MoPubView */
class C11422la extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MoPubView f35312a;

    C11422la(MoPubView this$0) {
        this.f35312a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        if (Visibility.isScreenVisible(this.f35312a.f34876d) && intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                this.f35312a.setAdVisibility(0);
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.f35312a.setAdVisibility(8);
            }
        }
    }
}
