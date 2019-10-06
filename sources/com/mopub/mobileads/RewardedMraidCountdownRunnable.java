package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.mraid.RewardedMraidController;

public class RewardedMraidCountdownRunnable extends RepeatingHandlerRunnable {

    /* renamed from: d */
    private final RewardedMraidController f34923d;

    /* renamed from: e */
    private int f34924e;

    public RewardedMraidCountdownRunnable(RewardedMraidController rewardedMraidController, Handler handler) {
        super(handler);
        Preconditions.checkNotNull(handler);
        Preconditions.checkNotNull(rewardedMraidController);
        this.f34923d = rewardedMraidController;
    }

    public void doWork() {
        this.f34924e = (int) (((long) this.f34924e) + this.f34912c);
        this.f34923d.updateCountdown(this.f34924e);
        if (this.f34923d.isPlayableCloseable()) {
            this.f34923d.showPlayableCloseButton();
        }
    }
}
