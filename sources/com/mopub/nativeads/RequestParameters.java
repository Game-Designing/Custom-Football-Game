package com.mopub.nativeads;

import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import java.util.EnumSet;

public class RequestParameters {

    /* renamed from: a */
    private final String f36018a;

    /* renamed from: b */
    private final String f36019b;

    /* renamed from: c */
    private final Location f36020c;

    /* renamed from: d */
    private final EnumSet<NativeAdAsset> f36021d;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f36022a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f36023b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Location f36024c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public EnumSet<NativeAdAsset> f36025d;

        public final Builder keywords(String keywords) {
            this.f36022a = keywords;
            return this;
        }

        public final Builder userDataKeywords(String userDataKeywords) {
            this.f36023b = MoPub.canCollectPersonalInformation() ? userDataKeywords : null;
            return this;
        }

        public final Builder location(Location location) {
            this.f36024c = MoPub.canCollectPersonalInformation() ? location : null;
            return this;
        }

        public final Builder desiredAssets(EnumSet<NativeAdAsset> desiredAssets) {
            this.f36025d = EnumSet.copyOf(desiredAssets);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters(this);
        }
    }

    public enum NativeAdAsset {
        TITLE("title"),
        TEXT(CommandHandler.TEXT),
        ICON_IMAGE("iconimage"),
        MAIN_IMAGE("mainimage"),
        CALL_TO_ACTION_TEXT("ctatext"),
        STAR_RATING("starrating");
        

        /* renamed from: b */
        private final String f36027b;

        private NativeAdAsset(String assetName) {
            this.f36027b = assetName;
        }

        public String toString() {
            return this.f36027b;
        }
    }

    private RequestParameters(Builder builder) {
        this.f36018a = builder.f36022a;
        this.f36021d = builder.f36025d;
        boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
        Location location = null;
        this.f36019b = canCollectPersonalInformation ? builder.f36023b : null;
        if (canCollectPersonalInformation) {
            location = builder.f36024c;
        }
        this.f36020c = location;
    }

    public final String getKeywords() {
        return this.f36018a;
    }

    public final String getUserDataKeywords() {
        if (!MoPub.canCollectPersonalInformation()) {
            return null;
        }
        return this.f36019b;
    }

    public final Location getLocation() {
        return this.f36020c;
    }

    public final String getDesiredAssets() {
        String result = "";
        EnumSet<NativeAdAsset> enumSet = this.f36021d;
        if (enumSet == null) {
            return result;
        }
        return TextUtils.join(",", enumSet.toArray());
    }
}
