package com.mopub.mraid;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.BaseBroadcastReceiver;
import com.mopub.mraid.RewardedMraidInterstitial.RewardedMraidInterstitialListener;

public class RewardedPlayableBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: c */
    private static IntentFilter f35557c;

    /* renamed from: d */
    private RewardedMraidInterstitialListener f35558d;

    public RewardedPlayableBroadcastReceiver(RewardedMraidInterstitialListener rewardedVideoListener, long broadcastIdentifier) {
        super(broadcastIdentifier);
        this.f35558d = rewardedVideoListener;
        getIntentFilter();
    }

    public IntentFilter getIntentFilter() {
        if (f35557c == null) {
            f35557c = new IntentFilter();
            f35557c.addAction(IntentActions.ACTION_REWARDED_PLAYABLE_COMPLETE);
        }
        return f35557c;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f35558d != null && shouldConsumeBroadcast(intent)) {
            if (IntentActions.ACTION_REWARDED_PLAYABLE_COMPLETE.equals(intent.getAction())) {
                this.f35558d.onMraidComplete();
                unregister(this);
            }
        }
    }
}
