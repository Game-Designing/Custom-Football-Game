package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

public class EventForwardingBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: c */
    private static IntentFilter f34743c;

    /* renamed from: d */
    private final CustomEventInterstitialListener f34744d;

    public EventForwardingBroadcastReceiver(CustomEventInterstitialListener customEventInterstitialListener, long broadcastIdentifier) {
        super(broadcastIdentifier);
        this.f34744d = customEventInterstitialListener;
        getIntentFilter();
    }

    public IntentFilter getIntentFilter() {
        if (f34743c == null) {
            f34743c = new IntentFilter();
            f34743c.addAction(IntentActions.ACTION_INTERSTITIAL_FAIL);
            f34743c.addAction(IntentActions.ACTION_INTERSTITIAL_SHOW);
            f34743c.addAction(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            f34743c.addAction(IntentActions.ACTION_INTERSTITIAL_CLICK);
        }
        return f34743c;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f34744d != null && shouldConsumeBroadcast(intent)) {
            String action = intent.getAction();
            if (IntentActions.ACTION_INTERSTITIAL_FAIL.equals(action)) {
                this.f34744d.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            } else if (IntentActions.ACTION_INTERSTITIAL_SHOW.equals(action)) {
                this.f34744d.onInterstitialShown();
            } else if (IntentActions.ACTION_INTERSTITIAL_DISMISS.equals(action)) {
                this.f34744d.onInterstitialDismissed();
                unregister(this);
            } else if (IntentActions.ACTION_INTERSTITIAL_CLICK.equals(action)) {
                this.f34744d.onInterstitialClicked();
            }
        }
    }
}
