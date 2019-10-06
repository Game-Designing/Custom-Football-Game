package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubLifecycleManager;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import java.util.Map;

public abstract class CustomEventRewardedAd {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo36993a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo36904b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo36905b(Activity activity, Map<String, Object> map, Map<String, String> map2) throws Exception;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo36994c();

    /* access modifiers changed from: protected */
    public abstract boolean checkAndInitializeSdk(Activity activity, Map<String, Object> map, Map<String, String> map2) throws Exception;

    /* access modifiers changed from: protected */
    public abstract String getAdNetworkId();

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public abstract LifecycleListener getLifecycleListener();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo36992a(Activity launcherActivity, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        try {
            if (checkAndInitializeSdk(launcherActivity, localExtras, serverExtras)) {
                MoPubLifecycleManager.getInstance(launcherActivity).addLifecycleListener(getLifecycleListener());
            }
            mo36905b(launcherActivity, localExtras, serverExtras);
        } catch (Exception e) {
            MoPubLog.log(AdLogEvent.CUSTOM, e.getMessage());
        }
    }
}
