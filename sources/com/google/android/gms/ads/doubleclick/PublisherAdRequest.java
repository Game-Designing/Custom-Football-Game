package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
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
import java.util.List;
import java.util.Set;

@VisibleForTesting
public final class PublisherAdRequest {
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
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;

    /* renamed from: a */
    private final zzaaz f19038a;

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
        public final zzaba f19039a = new zzaba();

        public final Builder addKeyword(String str) {
            this.f19039a.mo29411a(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f19039a.mo29409a(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
            this.f19039a.mo29410a(cls, bundle);
            return this;
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f19039a.mo29416b(cls, bundle);
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.f19039a.mo29417b(str);
            return this;
        }

        public final PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        @Deprecated
        public final Builder setBirthday(Date date) {
            this.f19039a.mo29413a(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            Preconditions.m21858a(str, (Object) "Content URL must be non-null.");
            Preconditions.m21859a(str, (Object) "Content URL must be non-empty.");
            Preconditions.m21865a(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(str.length()));
            this.f19039a.mo29421d(str);
            return this;
        }

        @Deprecated
        public final Builder setGender(int i) {
            this.f19039a.mo29407a(i);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.f19039a.mo29408a(location);
            return this;
        }

        @Deprecated
        public final Builder setManualImpressionsEnabled(boolean z) {
            this.f19039a.mo29414a(z);
            return this;
        }

        public final Builder setPublisherProvidedId(String str) {
            this.f19039a.mo29422e(str);
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.f19039a.mo29423f(str);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.f19039a.mo29418b(z);
            return this;
        }

        public final Builder addCustomTargeting(String str, String str2) {
            this.f19039a.mo29412a(str, str2);
            return this;
        }

        public final Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.f19039a.mo29412a(str, TextUtils.join(",", list));
            }
            return this;
        }

        public final Builder addCategoryExclusion(String str) {
            this.f19039a.mo29424g(str);
            return this;
        }

        @Deprecated
        public final Builder setIsDesignedForFamilies(boolean z) {
            this.f19039a.mo29420c(z);
            return this;
        }

        public final Builder setTagForUnderAgeOfConsent(int i) {
            this.f19039a.mo29415b(i);
            return this;
        }

        public final Builder setMaxAdContentRating(String str) {
            this.f19039a.mo29425h(str);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.f19038a = new zzaaz(builder.f19039a);
    }

    @Deprecated
    public final Date getBirthday() {
        return this.f19038a.mo29384a();
    }

    public final String getContentUrl() {
        return this.f19038a.mo29387b();
    }

    @Deprecated
    public final int getGender() {
        return this.f19038a.mo29390d();
    }

    public final Set<String> getKeywords() {
        return this.f19038a.mo29391e();
    }

    public final Location getLocation() {
        return this.f19038a.mo29392f();
    }

    public final boolean getManualImpressionsEnabled() {
        return this.f19038a.mo29393g();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f19038a.mo29386b(cls);
    }

    public final <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f19038a.mo29389c(cls);
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f19038a.mo29383a(cls);
    }

    public final String getPublisherProvidedId() {
        return this.f19038a.mo29395i();
    }

    public final boolean isTestDevice(Context context) {
        return this.f19038a.mo29385a(context);
    }

    public final Bundle getCustomTargeting() {
        return this.f19038a.mo29388c();
    }

    public static void updateCorrelator() {
    }

    public final zzaaz zzde() {
        return this.f19038a;
    }
}
