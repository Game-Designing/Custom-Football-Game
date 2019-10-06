package com.mopub.mraid;

import android.content.Context;
import com.mopub.common.DataKeys;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.RewardedMraidActivity;
import java.util.Map;

public class RewardedMraidInterstitial extends MraidInterstitial {
    public static final String ADAPTER_NAME = RewardedMraidInterstitial.class.getSimpleName();

    /* renamed from: i */
    private RewardedPlayableBroadcastReceiver f35554i;

    /* renamed from: j */
    private int f35555j;

    /* renamed from: k */
    private boolean f35556k;

    public interface RewardedMraidInterstitialListener extends CustomEventInterstitialListener {
        void onMraidComplete();
    }

    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        super.loadInterstitial(context, customEventInterstitialListener, localExtras, serverExtras);
        MoPubLog.log(AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        if (customEventInterstitialListener instanceof RewardedMraidInterstitialListener) {
            this.f35554i = new RewardedPlayableBroadcastReceiver((RewardedMraidInterstitialListener) customEventInterstitialListener, this.f34916e);
            RewardedPlayableBroadcastReceiver rewardedPlayableBroadcastReceiver = this.f35554i;
            rewardedPlayableBroadcastReceiver.register(rewardedPlayableBroadcastReceiver, context);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37027a(CustomEventInterstitialListener customEventInterstitialListener) {
        Map<String, Object> localExtras = this.f34917f;
        if (localExtras != null) {
            Object rewardedDurationObject = localExtras.get(DataKeys.REWARDED_AD_DURATION_KEY);
            this.f35555j = rewardedDurationObject instanceof Integer ? ((Integer) rewardedDurationObject).intValue() : 30;
            Object shouldRewardOnClickObject = localExtras.get(DataKeys.SHOULD_REWARD_ON_CLICK_KEY);
            this.f35556k = shouldRewardOnClickObject instanceof Boolean ? ((Boolean) shouldRewardOnClickObject).booleanValue() : false;
        }
        RewardedMraidActivity.preRenderHtml(this, this.f34914c, customEventInterstitialListener, Long.valueOf(this.f34916e), this.f34915d, this.f35555j);
    }

    public void showInterstitial() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, ADAPTER_NAME);
        RewardedMraidActivity.start(this.f34914c, this.f34915d, this.f34916e, this.f35555j, this.f35556k);
    }

    public void onInvalidate() {
        super.onInvalidate();
        RewardedPlayableBroadcastReceiver rewardedPlayableBroadcastReceiver = this.f35554i;
        if (rewardedPlayableBroadcastReceiver != null) {
            rewardedPlayableBroadcastReceiver.unregister(rewardedPlayableBroadcastReceiver);
        }
    }
}
