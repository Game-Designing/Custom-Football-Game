package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.MoPubReward;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.mopub.mobileads.aa */
/* compiled from: MoPubRewardedVideoManager */
class C11379aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Class f35192a;

    /* renamed from: b */
    final /* synthetic */ MoPubReward f35193b;

    /* renamed from: c */
    final /* synthetic */ String f35194c;

    /* renamed from: d */
    final /* synthetic */ String f35195d;

    C11379aa(Class cls, MoPubReward moPubReward, String str, String str2) {
        this.f35192a = cls;
        this.f35193b = moPubReward;
        this.f35194c = str;
        this.f35195d = str2;
    }

    public void run() {
        MoPubReward chosenReward = MoPubRewardedVideoManager.m37455a(MoPubRewardedVideoManager.f34859a.f34864f.mo37506a(this.f35192a), this.f35193b);
        Set<String> rewardedIds = new HashSet<>();
        if (TextUtils.isEmpty(this.f35194c)) {
            rewardedIds.addAll(MoPubRewardedVideoManager.f34859a.f34864f.mo37508a(this.f35192a, this.f35195d));
        } else {
            rewardedIds.add(this.f35194c);
        }
        if (MoPubRewardedVideoManager.f34859a.f34865g != null) {
            MoPubRewardedVideoManager.f34859a.f34865g.onRewardedVideoCompleted(rewardedIds, chosenReward);
        }
    }
}
