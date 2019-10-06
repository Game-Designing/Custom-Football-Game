package com.mopub.common;

public final class MoPubReward {
    public static final int DEFAULT_REWARD_AMOUNT = 0;
    public static final int NO_REWARD_AMOUNT = -123;
    public static final String NO_REWARD_LABEL = "";

    /* renamed from: a */
    private final boolean f34350a;

    /* renamed from: b */
    private final String f34351b;

    /* renamed from: c */
    private final int f34352c;

    private MoPubReward(boolean success, String label, int amount) {
        this.f34350a = success;
        this.f34351b = label;
        this.f34352c = amount;
    }

    public static MoPubReward failure() {
        return new MoPubReward(false, "", 0);
    }

    public static MoPubReward success(String rewardLabel, int amount) {
        return new MoPubReward(true, rewardLabel, amount);
    }

    public final boolean isSuccessful() {
        return this.f34350a;
    }

    public final String getLabel() {
        return this.f34351b;
    }

    public final int getAmount() {
        return this.f34352c;
    }
}
