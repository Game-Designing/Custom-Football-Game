package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzabe;
import com.google.android.gms.internal.ads.zzabi;

public class MobileAds {

    public static final class Settings {

        /* renamed from: a */
        private final zzabi f19022a = new zzabi();

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final zzabi mo26336a() {
            return this.f19022a;
        }
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzabe.m24652d().mo29477a(context, str, settings == null ? null : settings.mo26336a(), null);
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzabe.m24652d().mo29473a(context);
    }

    public static void setAppVolume(float f) {
        zzabe.m24652d().mo29475a(f);
    }

    public static void setAppMuted(boolean z) {
        zzabe.m24652d().mo29479a(z);
    }

    public static void openDebugMenu(Context context, String str) {
        zzabe.m24652d().mo29476a(context, str);
    }

    @KeepForSdk
    public static String getVersionString() {
        return zzabe.m24652d().mo29474a();
    }

    @KeepForSdk
    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzabe.m24652d().mo29478a(cls);
    }

    private MobileAds() {
    }
}
