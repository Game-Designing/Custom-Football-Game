package com.mopub.mobileads;

import com.mopub.common.AdType;

public class AdTypeTranslator {
    public static final String BANNER_SUFFIX = "_banner";
    public static final String INTERSTITIAL_SUFFIX = "_interstitial";

    public enum CustomEventType {
        GOOGLE_PLAY_SERVICES_BANNER("admob_native_banner", "com.mopub.mobileads.GooglePlayServicesBanner", false),
        GOOGLE_PLAY_SERVICES_INTERSTITIAL("admob_full_interstitial", "com.mopub.mobileads.GooglePlayServicesInterstitial", false),
        MILLENNIAL_BANNER("millennial_native_banner", "com.mopub.mobileads.MillennialBanner", false),
        MILLENNIAL_INTERSTITIAL("millennial_full_interstitial", "com.mopub.mobileads.MillennialInterstitial", false),
        MRAID_BANNER("mraid_banner", "com.mopub.mraid.MraidBanner", true),
        MRAID_INTERSTITIAL("mraid_interstitial", "com.mopub.mraid.MraidInterstitial", true),
        HTML_BANNER("html_banner", "com.mopub.mobileads.HtmlBanner", true),
        HTML_INTERSTITIAL("html_interstitial", "com.mopub.mobileads.HtmlInterstitial", true),
        VAST_VIDEO_INTERSTITIAL("vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial", true),
        MOPUB_NATIVE("mopub_native", "com.mopub.nativeads.MoPubCustomEventNative", true),
        MOPUB_VIDEO_NATIVE("mopub_video_native", "com.mopub.nativeads.MoPubCustomEventVideoNative", true),
        MOPUB_REWARDED_VIDEO(AdType.REWARDED_VIDEO, "com.mopub.mobileads.MoPubRewardedVideo", true),
        MOPUB_REWARDED_PLAYABLE(AdType.REWARDED_PLAYABLE, "com.mopub.mobileads.MoPubRewardedPlayable", true),
        UNSPECIFIED("", null, false);
        

        /* renamed from: b */
        private final String f34645b;

        /* renamed from: c */
        private final String f34646c;

        /* renamed from: d */
        private final boolean f34647d;

        private CustomEventType(String key, String className, boolean isMoPubSpecific) {
            this.f34645b = key;
            this.f34646c = className;
            this.f34647d = isMoPubSpecific;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public static CustomEventType m37235c(String key) {
            CustomEventType[] values;
            for (CustomEventType customEventType : values()) {
                if (customEventType.f34645b.equals(key)) {
                    return customEventType;
                }
            }
            return UNSPECIFIED;
        }

        /* renamed from: b */
        private static CustomEventType m37234b(String className) {
            CustomEventType[] values;
            for (CustomEventType customEventType : values()) {
                String str = customEventType.f34646c;
                if (str != null && str.equals(className)) {
                    return customEventType;
                }
            }
            return UNSPECIFIED;
        }

        public String toString() {
            return this.f34646c;
        }

        public static boolean isMoPubSpecific(String className) {
            return m37234b(className).f34647d;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCustomEventName(com.mopub.common.AdFormat r3, java.lang.String r4, java.lang.String r5, org.json.JSONObject r6) {
        /*
            com.mopub.common.Preconditions.checkNotNull(r3)
            com.mopub.common.Preconditions.checkNotNull(r4)
            java.lang.String r0 = r4.toLowerCase()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1364000502: goto L_0x0058;
                case -1349088399: goto L_0x004e;
                case 3213227: goto L_0x0044;
                case 3271912: goto L_0x003a;
                case 104156535: goto L_0x0030;
                case 474479519: goto L_0x0026;
                case 604727084: goto L_0x001c;
                case 797120100: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0062
        L_0x0012:
            java.lang.String r1 = "json_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0011
            r0 = 2
            goto L_0x0063
        L_0x001c:
            java.lang.String r1 = "interstitial"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0011
            r0 = 7
            goto L_0x0063
        L_0x0026:
            java.lang.String r1 = "rewarded_playable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0011
            r0 = 4
            goto L_0x0063
        L_0x0030:
            java.lang.String r1 = "mraid"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0011
            r0 = 6
            goto L_0x0063
        L_0x003a:
            java.lang.String r1 = "json"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0011
            r0 = 1
            goto L_0x0063
        L_0x0044:
            java.lang.String r1 = "html"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0011
            r0 = 5
            goto L_0x0063
        L_0x004e:
            java.lang.String r1 = "custom"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0011
            r0 = 0
            goto L_0x0063
        L_0x0058:
            java.lang.String r1 = "rewarded_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0011
            r0 = 3
            goto L_0x0063
        L_0x0062:
            r0 = -1
        L_0x0063:
            java.lang.String r1 = "_interstitial"
            java.lang.String r2 = "_banner"
            switch(r0) {
                case 0: goto L_0x00ea;
                case 1: goto L_0x00e3;
                case 2: goto L_0x00dc;
                case 3: goto L_0x00d5;
                case 4: goto L_0x00ce;
                case 5: goto L_0x009a;
                case 6: goto L_0x009a;
                case 7: goto L_0x0082;
                default: goto L_0x006a;
            }
        L_0x006a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.mopub.mobileads.AdTypeTranslator$CustomEventType r0 = com.mopub.mobileads.AdTypeTranslator.CustomEventType.m37235c(r0)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0082:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.mopub.mobileads.AdTypeTranslator$CustomEventType r0 = com.mopub.mobileads.AdTypeTranslator.CustomEventType.m37235c(r0)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x009a:
            com.mopub.common.AdFormat r0 = com.mopub.common.AdFormat.INTERSTITIAL
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00b6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.mopub.mobileads.AdTypeTranslator$CustomEventType r0 = com.mopub.mobileads.AdTypeTranslator.CustomEventType.m37235c(r0)
            goto L_0x00c9
        L_0x00b6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.mopub.mobileads.AdTypeTranslator$CustomEventType r0 = com.mopub.mobileads.AdTypeTranslator.CustomEventType.m37235c(r0)
        L_0x00c9:
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00ce:
            com.mopub.mobileads.AdTypeTranslator$CustomEventType r0 = com.mopub.mobileads.AdTypeTranslator.CustomEventType.MOPUB_REWARDED_PLAYABLE
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00d5:
            com.mopub.mobileads.AdTypeTranslator$CustomEventType r0 = com.mopub.mobileads.AdTypeTranslator.CustomEventType.MOPUB_REWARDED_VIDEO
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00dc:
            com.mopub.mobileads.AdTypeTranslator$CustomEventType r0 = com.mopub.mobileads.AdTypeTranslator.CustomEventType.MOPUB_VIDEO_NATIVE
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00e3:
            com.mopub.mobileads.AdTypeTranslator$CustomEventType r0 = com.mopub.mobileads.AdTypeTranslator.CustomEventType.MOPUB_NATIVE
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00ea:
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.CUSTOM_EVENT_NAME
            java.lang.String r0 = com.mopub.network.HeaderUtils.extractHeader(r6, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.AdTypeTranslator.getCustomEventName(com.mopub.common.AdFormat, java.lang.String, java.lang.String, org.json.JSONObject):java.lang.String");
    }
}
