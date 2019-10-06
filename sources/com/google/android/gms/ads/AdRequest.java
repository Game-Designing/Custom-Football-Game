package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzaba;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.Set;

@VisibleForTesting
public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;

    /* renamed from: a */
    private final zzaaz f19015a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    @VisibleForTesting
    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final zzaba f19016a = new zzaba();

        public Builder() {
            this.f19016a.mo29417b("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        public final Builder addKeyword(String str) {
            this.f19016a.mo29411a(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f19016a.mo29409a(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
            this.f19016a.mo29410a(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f19016a.mo29419c("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f19016a.mo29416b(cls, bundle);
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.f19016a.mo29417b(str);
            return this;
        }

        public final AdRequest build() {
            return new AdRequest(this);
        }

        @Deprecated
        public final Builder setBirthday(Date date) {
            this.f19016a.mo29413a(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            Preconditions.m21858a(str, (Object) "Content URL must be non-null.");
            Preconditions.m21859a(str, (Object) "Content URL must be non-empty.");
            Preconditions.m21865a(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(str.length()));
            this.f19016a.mo29421d(str);
            return this;
        }

        @Deprecated
        public final Builder setGender(int i) {
            this.f19016a.mo29407a(i);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.f19016a.mo29408a(location);
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.f19016a.mo29423f(str);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.f19016a.mo29418b(z);
            return this;
        }

        @Deprecated
        public final Builder setIsDesignedForFamilies(boolean z) {
            this.f19016a.mo29420c(z);
            return this;
        }

        public final Builder setTagForUnderAgeOfConsent(int i) {
            this.f19016a.mo29415b(i);
            return this;
        }

        public final Builder setMaxAdContentRating(String str) {
            this.f19016a.mo29425h(str);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.f19015a = new zzaaz(builder.f19016a);
    }

    @Deprecated
    public final Date getBirthday() {
        return this.f19015a.mo29384a();
    }

    public final String getContentUrl() {
        return this.f19015a.mo29387b();
    }

    @Deprecated
    public final int getGender() {
        return this.f19015a.mo29390d();
    }

    public final Set<String> getKeywords() {
        return this.f19015a.mo29391e();
    }

    public final Location getLocation() {
        return this.f19015a.mo29392f();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f19015a.mo29386b(cls);
    }

    public final <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f19015a.mo29389c(cls);
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f19015a.mo29383a(cls);
    }

    public final boolean isTestDevice(Context context) {
        return this.f19015a.mo29385a(context);
    }

    public final zzaaz zzde() {
        return this.f19015a;
    }
}
