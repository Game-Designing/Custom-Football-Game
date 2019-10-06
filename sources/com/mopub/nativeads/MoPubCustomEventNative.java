package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.DataKeys;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.util.Numbers;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class MoPubCustomEventNative extends CustomEventNative {
    public static final String ADAPTER_NAME = MoPubCustomEventNative.class.getSimpleName();

    /* renamed from: a */
    private C11545a f35819a;

    /* renamed from: com.mopub.nativeads.MoPubCustomEventNative$a */
    static class C11545a extends StaticNativeAd {

        /* renamed from: s */
        private final Context f35820s;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public final CustomEventNativeListener f35821t;

        /* renamed from: u */
        private final JSONObject f35822u;

        /* renamed from: v */
        private final ImpressionTracker f35823v;

        /* renamed from: w */
        private final NativeClickHandler f35824w;

        /* renamed from: com.mopub.nativeads.MoPubCustomEventNative$a$a */
        enum C11546a {
            IMPRESSION_TRACKER("imptracker", true),
            CLICK_TRACKER("clktracker", true),
            TITLE("title", false),
            TEXT(CommandHandler.TEXT, false),
            MAIN_IMAGE("mainimage", false),
            ICON_IMAGE("iconimage", false),
            CLICK_DESTINATION("clk", false),
            FALLBACK("fallback", false),
            CALL_TO_ACTION("ctatext", false),
            STAR_RATING("starrating", false),
            PRIVACY_INFORMATION_ICON_IMAGE_URL("privacyicon", false),
            PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL("privacyclkurl", false);
            
            @VisibleForTesting

            /* renamed from: a */
            static final Set<String> f35825a = null;

            /* renamed from: c */
            final String f35827c;

            /* renamed from: d */
            final boolean f35828d;

            static {
                int i;
                C11546a[] values;
                f35825a = new HashSet();
                for (C11546a parameter : values()) {
                    if (parameter.f35828d) {
                        f35825a.add(parameter.f35827c);
                    }
                }
            }

            private C11546a(String name, boolean required) {
                this.f35827c = name;
                this.f35828d = required;
            }

            /* renamed from: a */
            static C11546a m38225a(String name) {
                C11546a[] values;
                for (C11546a parameter : values()) {
                    if (parameter.f35827c.equals(name)) {
                        return parameter;
                    }
                }
                return null;
            }
        }

        C11545a(Context context, JSONObject jsonBody, ImpressionTracker impressionTracker, NativeClickHandler nativeClickHandler, CustomEventNativeListener customEventNativeListener) {
            this.f35822u = jsonBody;
            this.f35820s = context.getApplicationContext();
            this.f35823v = impressionTracker;
            this.f35824w = nativeClickHandler;
            this.f35821t = customEventNativeListener;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public void mo37914g() throws IllegalArgumentException {
            if (m38220a(this.f35822u)) {
                Iterator<String> keys = this.f35822u.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    C11546a parameter = C11546a.m38225a(key);
                    if (parameter != null) {
                        try {
                            m38218a(parameter, this.f35822u.opt(key));
                        } catch (ClassCastException e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("JSONObject key (");
                            sb.append(key);
                            sb.append(") contained unexpected value.");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    } else {
                        addExtra(key, this.f35822u.opt(key));
                    }
                }
                if (TextUtils.isEmpty(getPrivacyInformationIconClickThroughUrl())) {
                    setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout");
                }
                NativeImageHelper.preCacheImages(this.f35820s, mo37912e(), new C11552N(this));
                return;
            }
            throw new IllegalArgumentException("JSONObject did not contain required keys.");
        }

        /* renamed from: a */
        private boolean m38220a(JSONObject jsonObject) {
            Set<String> keys = new HashSet<>();
            Iterator<String> jsonKeys = jsonObject.keys();
            while (jsonKeys.hasNext()) {
                keys.add(jsonKeys.next());
            }
            return keys.containsAll(C11546a.f35825a);
        }

        /* renamed from: a */
        private void m38218a(C11546a key, Object value) throws ClassCastException {
            try {
                switch (C11543M.f35774a[key.ordinal()]) {
                    case 1:
                        setMainImageUrl((String) value);
                        return;
                    case 2:
                        setIconImageUrl((String) value);
                        return;
                    case 3:
                        mo37748b(value);
                        return;
                    case 4:
                        setClickDestinationUrl((String) value);
                        return;
                    case 5:
                        m38221c(value);
                        return;
                    case 6:
                        setCallToAction((String) value);
                        return;
                    case 7:
                        setTitle((String) value);
                        return;
                    case 8:
                        setText((String) value);
                        return;
                    case 9:
                        setStarRating(Numbers.parseDouble(value));
                        return;
                    case 10:
                        setPrivacyInformationIconImageUrl((String) value);
                        return;
                    case 11:
                        setPrivacyInformationIconClickThroughUrl((String) value);
                        return;
                    default:
                        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unable to add JSON key to internal mapping: ");
                        sb.append(key.f35827c);
                        MoPubLog.log(adapterLogEvent, MoPubCustomEventNative.ADAPTER_NAME, sb.toString());
                        return;
                }
            } catch (ClassCastException e) {
                if (!key.f35828d) {
                    AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring class cast exception for optional key: ");
                    sb2.append(key.f35827c);
                    MoPubLog.log(adapterLogEvent2, MoPubCustomEventNative.ADAPTER_NAME, sb2.toString());
                    return;
                }
                throw e;
            }
        }

        /* renamed from: c */
        private void m38221c(Object clickTrackers) {
            if (clickTrackers instanceof JSONArray) {
                mo37744a(clickTrackers);
            } else {
                addClickTracker((String) clickTrackers);
            }
        }

        /* renamed from: a */
        private boolean m38219a(String name) {
            return name != null && name.toLowerCase(Locale.US).endsWith("image");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public List<String> mo37913f() {
            List<String> extrasBitmapUrls = new ArrayList<>(getExtras().size());
            for (Entry<String, Object> entry : getExtras().entrySet()) {
                if (m38219a((String) entry.getKey()) && (entry.getValue() instanceof String)) {
                    extrasBitmapUrls.add((String) entry.getValue());
                }
            }
            return extrasBitmapUrls;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public List<String> mo37912e() {
            List<String> imageUrls = new ArrayList<>();
            if (!TextUtils.isEmpty(getMainImageUrl())) {
                imageUrls.add(getMainImageUrl());
            }
            if (!TextUtils.isEmpty(getIconImageUrl())) {
                imageUrls.add(getIconImageUrl());
            }
            if (!TextUtils.isEmpty(getPrivacyInformationIconImageUrl())) {
                imageUrls.add(getPrivacyInformationIconImageUrl());
            }
            imageUrls.addAll(mo37913f());
            return imageUrls;
        }

        public void prepare(View view) {
            this.f35823v.addView(view, this);
            this.f35824w.setOnClickListener(view, this);
        }

        public void clear(View view) {
            this.f35823v.removeView(view);
            this.f35824w.clearOnClickListener(view);
        }

        public void destroy() {
            this.f35823v.destroy();
            super.destroy();
        }

        public void recordImpression(View view) {
            mo37750d();
        }

        public void handleClick(View view) {
            MoPubLog.log(AdapterLogEvent.CLICKED, MoPubCustomEventNative.ADAPTER_NAME);
            mo37749c();
            this.f35824w.openClickDestinationUrl(getClickDestinationUrl(), view);
        }
    }

    /* access modifiers changed from: protected */
    public void loadNativeAd(Context context, CustomEventNativeListener customEventNativeListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        Context context2 = context;
        CustomEventNativeListener customEventNativeListener2 = customEventNativeListener;
        Map<String, String> map = serverExtras;
        MoPubLog.log(AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        C11545a aVar = this.f35819a;
        if (aVar == null || aVar.isInvalidated()) {
            Object json = localExtras.get(DataKeys.JSON_BODY_KEY);
            if (!(json instanceof JSONObject)) {
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(NativeErrorCode.INVALID_RESPONSE.getIntCode()), NativeErrorCode.INVALID_RESPONSE);
                customEventNativeListener2.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
                return;
            }
            C11545a aVar2 = new C11545a(context, (JSONObject) json, new ImpressionTracker(context2), new NativeClickHandler(context2), customEventNativeListener);
            this.f35819a = aVar2;
            String str = DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT;
            if (map.containsKey(str)) {
                try {
                    this.f35819a.setImpressionMinPercentageViewed(Integer.parseInt((String) map.get(str)));
                } catch (NumberFormatException e) {
                    AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to format min visible percent: ");
                    sb.append((String) map.get(str));
                    MoPubLog.log(adapterLogEvent, ADAPTER_NAME, sb.toString());
                }
            }
            String str2 = DataKeys.IMPRESSION_VISIBLE_MS;
            if (map.containsKey(str2)) {
                try {
                    this.f35819a.setImpressionMinTimeViewed(Integer.parseInt((String) map.get(str2)));
                } catch (NumberFormatException e2) {
                    AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to format min time: ");
                    sb2.append((String) map.get(str2));
                    MoPubLog.log(adapterLogEvent2, ADAPTER_NAME, sb2.toString());
                }
            }
            String str3 = DataKeys.IMPRESSION_MIN_VISIBLE_PX;
            if (map.containsKey(str3)) {
                try {
                    this.f35819a.setImpressionMinVisiblePx(Integer.valueOf(Integer.parseInt((String) map.get(str3))));
                } catch (NumberFormatException e3) {
                    AdapterLogEvent adapterLogEvent3 = AdapterLogEvent.CUSTOM;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unable to format min visible px: ");
                    sb3.append((String) map.get(str3));
                    MoPubLog.log(adapterLogEvent3, ADAPTER_NAME, sb3.toString());
                }
            }
            try {
                this.f35819a.mo37914g();
                MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, ADAPTER_NAME);
            } catch (IllegalArgumentException e4) {
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(NativeErrorCode.UNSPECIFIED.getIntCode()), NativeErrorCode.UNSPECIFIED);
                customEventNativeListener2.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37758a() {
        C11545a aVar = this.f35819a;
        if (aVar != null) {
            aVar.invalidate();
        }
    }
}
