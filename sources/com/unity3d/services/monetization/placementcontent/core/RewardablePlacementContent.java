package com.unity3d.services.monetization.placementcontent.core;

import java.util.Map;

public class RewardablePlacementContent extends PlacementContent {
    private boolean isRewarded;
    private String rewardId;

    public RewardablePlacementContent(String placementId, Map<String, Object> params) {
        super(placementId, params);
        String str = "rewarded";
        if (params.containsKey(str)) {
            this.isRewarded = ((Boolean) params.get(str)).booleanValue();
        }
        String str2 = "rewardId";
        if (params.containsKey(str2)) {
            this.rewardId = (String) params.get(str2);
        }
    }

    public boolean isRewarded() {
        return this.isRewarded;
    }

    public String getRewardId() {
        return this.rewardId;
    }
}
