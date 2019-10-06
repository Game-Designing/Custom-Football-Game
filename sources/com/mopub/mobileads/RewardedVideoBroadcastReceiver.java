package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;

public class RewardedVideoBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: c */
    private static IntentFilter f34926c;

    /* renamed from: d */
    private C11346a f34927d;

    public RewardedVideoBroadcastReceiver(C11346a rewardedVideoListener, long broadcastIdentifier) {
        super(broadcastIdentifier);
        this.f34927d = rewardedVideoListener;
        getIntentFilter();
    }

    public IntentFilter getIntentFilter() {
        if (f34926c == null) {
            f34926c = new IntentFilter();
            f34926c.addAction(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }
        return f34926c;
    }

    public void onReceive(Context context, Intent intent) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (this.f34927d != null && shouldConsumeBroadcast(intent)) {
            if (IntentActions.ACTION_REWARDED_VIDEO_COMPLETE.equals(intent.getAction())) {
                this.f34927d.onVideoComplete();
                unregister(this);
            }
        }
    }
}
