package com.mopub.network;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager.ViewabilityVendor;
import com.mopub.common.FullAdType;
import com.mopub.common.MoPub;
import com.mopub.common.MoPub.BrowserAgent;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.util.Json;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.AdTypeTranslator;
import com.mopub.network.AdResponse.Builder;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiAdResponse implements Iterator<AdResponse> {

    /* renamed from: a */
    private static ServerOverrideListener f36367a;

    /* renamed from: b */
    private final Iterator<AdResponse> f36368b;

    /* renamed from: c */
    private String f36369c;

    public interface ServerOverrideListener {
        void onForceExplicitNo(String str);

        void onForceGdprApplies();

        void onInvalidateConsent(String str);

        void onReacquireConsent(String str);
    }

    public String getFailURL() {
        return this.f36369c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0153 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MultiAdResponse(android.content.Context r26, com.mopub.volley.NetworkResponse r27, com.mopub.common.AdFormat r28, java.lang.String r29) throws org.json.JSONException, com.mopub.network.MoPubNetworkError {
        /*
            r25 = this;
            r1 = r25
            r25.<init>()
            java.lang.String r2 = m38548a(r27)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r2)
            r3 = r0
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.FAIL_URL
            java.lang.String r0 = r0.getKey()
            java.lang.String r0 = r3.optString(r0)
            r1.f36369c = r0
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.REQUEST_ID
            java.lang.String r0 = r0.getKey()
            java.lang.String r10 = r3.optString(r0)
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.BACKOFF_MS
            java.lang.Integer r11 = com.mopub.network.HeaderUtils.extractIntegerHeader(r3, r0)
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.BACKOFF_REASON
            java.lang.String r12 = com.mopub.network.HeaderUtils.extractHeader(r3, r0)
            com.mopub.network.RequestRateTracker r0 = com.mopub.network.RequestRateTracker.getInstance()
            r13 = r29
            r0.mo38323a(r13, r11, r12)
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.INVALIDATE_CONSENT
            r14 = 0
            boolean r15 = com.mopub.network.HeaderUtils.extractBooleanHeader(r3, r0, r14)
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.FORCE_EXPLICIT_NO
            boolean r16 = com.mopub.network.HeaderUtils.extractBooleanHeader(r3, r0, r14)
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.REACQUIRE_CONSENT
            boolean r17 = com.mopub.network.HeaderUtils.extractBooleanHeader(r3, r0, r14)
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.CONSENT_CHANGE_REASON
            java.lang.String r9 = com.mopub.network.HeaderUtils.extractHeader(r3, r0)
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.FORCE_GDPR_APPLIES
            boolean r18 = com.mopub.network.HeaderUtils.extractBooleanHeader(r3, r0, r14)
            com.mopub.network.MultiAdResponse$ServerOverrideListener r0 = f36367a
            if (r0 == 0) goto L_0x0079
            if (r18 == 0) goto L_0x0062
            r0.onForceGdprApplies()
        L_0x0062:
            if (r16 == 0) goto L_0x006a
            com.mopub.network.MultiAdResponse$ServerOverrideListener r0 = f36367a
            r0.onForceExplicitNo(r9)
            goto L_0x0079
        L_0x006a:
            if (r15 == 0) goto L_0x0072
            com.mopub.network.MultiAdResponse$ServerOverrideListener r0 = f36367a
            r0.onInvalidateConsent(r9)
            goto L_0x0079
        L_0x0072:
            if (r17 == 0) goto L_0x0079
            com.mopub.network.MultiAdResponse$ServerOverrideListener r0 = f36367a
            r0.onReacquireConsent(r9)
        L_0x0079:
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.ENABLE_DEBUG_LOGGING
            boolean r19 = com.mopub.network.HeaderUtils.extractBooleanHeader(r3, r0, r14)
            if (r19 == 0) goto L_0x0086
            com.mopub.common.logging.MoPubLog$LogLevel r0 = com.mopub.common.logging.MoPubLog.LogLevel.DEBUG
            com.mopub.common.logging.MoPubLog.setLogLevel(r0)
        L_0x0086:
            com.mopub.common.util.ResponseHeader r0 = com.mopub.common.util.ResponseHeader.AD_RESPONSES
            java.lang.String r0 = r0.getKey()
            org.json.JSONArray r8 = r3.getJSONArray(r0)
            r7 = 3
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            r5 = r0
            r0 = 0
            r4 = 0
            r20 = r0
        L_0x009b:
            int r0 = r8.length()
            if (r4 >= r0) goto L_0x0187
            r6 = 1
            org.json.JSONObject r0 = r8.getJSONObject(r4)     // Catch:{ JSONException -> 0x0154, MoPubNetworkError -> 0x011f, Exception -> 0x00f3 }
            r14 = 1
            r6 = r0
            r21 = r4
            r4 = r26
            r14 = r5
            r5 = r27
            r22 = r7
            r7 = r29
            r23 = r8
            r8 = r28
            r24 = r9
            r9 = r10
            com.mopub.network.AdResponse r0 = m38546a(r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            java.lang.String r4 = "clear"
            java.lang.String r5 = r0.getAdType()     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            boolean r4 = r4.equals(r5)     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            if (r4 != 0) goto L_0x00d0
            r14.add(r0)     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            r7 = 0
            goto L_0x017b
        L_0x00d0:
            java.lang.String r4 = ""
            r1.f36369c = r4     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            r20 = r0
            boolean r4 = m38550b(r6)     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            if (r4 != 0) goto L_0x00de
            goto L_0x0190
        L_0x00de:
            com.mopub.network.MoPubNetworkError r4 = new com.mopub.network.MoPubNetworkError     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            java.lang.String r5 = "Server is preparing this Ad Unit."
            com.mopub.network.MoPubNetworkError$Reason r7 = com.mopub.network.MoPubNetworkError.Reason.WARMING_UP     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            java.lang.Integer r8 = r20.getRefreshTimeMillis()     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            r4.<init>(r5, r7, r8)     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
            throw r4     // Catch:{ JSONException -> 0x00f0, MoPubNetworkError -> 0x00ee, Exception -> 0x00ec }
        L_0x00ec:
            r0 = move-exception
            goto L_0x00fd
        L_0x00ee:
            r0 = move-exception
            goto L_0x0129
        L_0x00f0:
            r0 = move-exception
            goto L_0x015e
        L_0x00f3:
            r0 = move-exception
            r21 = r4
            r14 = r5
            r22 = r7
            r23 = r8
            r24 = r9
        L_0x00fd:
            com.mopub.common.logging.MoPubLog$AdLogEvent r4 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unexpected error parsing response item. "
            r6.append(r7)
            java.lang.String r7 = r0.getMessage()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 0
            r5[r7] = r6
            com.mopub.common.logging.MoPubLog.log(r4, r5)
            r7 = 0
            goto L_0x017b
        L_0x011f:
            r0 = move-exception
            r21 = r4
            r14 = r5
            r22 = r7
            r23 = r8
            r24 = r9
        L_0x0129:
            com.mopub.network.MoPubNetworkError$Reason r4 = r0.getReason()
            com.mopub.network.MoPubNetworkError$Reason r5 = com.mopub.network.MoPubNetworkError.Reason.WARMING_UP
            if (r4 == r5) goto L_0x0153
            com.mopub.common.logging.MoPubLog$AdLogEvent r4 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid response item. Error: "
            r6.append(r7)
            com.mopub.network.MoPubNetworkError$Reason r7 = r0.getReason()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 0
            r5[r7] = r6
            com.mopub.common.logging.MoPubLog.log(r4, r5)
            r7 = 0
            goto L_0x017b
        L_0x0153:
            throw r0
        L_0x0154:
            r0 = move-exception
            r21 = r4
            r14 = r5
            r22 = r7
            r23 = r8
            r24 = r9
        L_0x015e:
            com.mopub.common.logging.MoPubLog$AdLogEvent r4 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid response item. Body: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            r7 = 0
            r5[r7] = r6
            com.mopub.common.logging.MoPubLog.log(r4, r5)
        L_0x017b:
            int r4 = r21 + 1
            r5 = r14
            r7 = r22
            r8 = r23
            r9 = r24
            r14 = 0
            goto L_0x009b
        L_0x0187:
            r21 = r4
            r14 = r5
            r22 = r7
            r23 = r8
            r24 = r9
        L_0x0190:
            java.util.Iterator r0 = r14.iterator()
            r1.f36368b = r0
            java.util.Iterator<com.mopub.network.AdResponse> r0 = r1.f36368b
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x01b4
            r0 = 30000(0x7530, float:4.2039E-41)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            if (r20 == 0) goto L_0x01aa
            java.lang.Integer r0 = r20.getRefreshTimeMillis()
        L_0x01aa:
            com.mopub.network.MoPubNetworkError r4 = new com.mopub.network.MoPubNetworkError
            com.mopub.network.MoPubNetworkError$Reason r5 = com.mopub.network.MoPubNetworkError.Reason.NO_FILL
            java.lang.String r6 = "No ads found for ad unit."
            r4.<init>(r6, r5, r0)
            throw r4
        L_0x01b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.network.MultiAdResponse.<init>(android.content.Context, com.mopub.volley.NetworkResponse, com.mopub.common.AdFormat, java.lang.String):void");
    }

    public boolean hasNext() {
        return this.f36368b.hasNext();
    }

    public AdResponse next() {
        return (AdResponse) this.f36368b.next();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo38311a() {
        return TextUtils.isEmpty(this.f36369c);
    }

    public static void setServerOverrideListener(ServerOverrideListener serverOverrideListener) {
        f36367a = serverOverrideListener;
    }

    /* renamed from: a */
    protected static AdResponse m38546a(Context appContext, NetworkResponse networkResponse, JSONObject jsonObject, String adUnitId, AdFormat adFormat, String requestId) throws JSONException, MoPubNetworkError {
        Map map;
        JSONObject jSONObject = jsonObject;
        AdFormat adFormat2 = adFormat;
        String str = DataKeys.ADM_KEY;
        Preconditions.checkNotNull(appContext);
        Preconditions.checkNotNull(networkResponse);
        Preconditions.checkNotNull(jsonObject);
        Preconditions.checkNotNull(adFormat);
        MoPubLog.log(AdLogEvent.RESPONSE_RECEIVED, jsonObject.toString());
        Builder builder = new Builder();
        String content = jSONObject.optString(ResponseHeader.CONTENT.getKey());
        JSONObject jsonHeaders = jSONObject.getJSONObject(ResponseHeader.METADATA.getKey());
        builder.setAdUnitId(adUnitId);
        builder.setResponseBody(content);
        String adTypeString = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.AD_TYPE);
        String fullAdTypeString = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.FULL_AD_TYPE);
        builder.setAdType(adTypeString);
        builder.setFullAdType(fullAdTypeString);
        Integer refreshTimeMilliseconds = m38547a(jsonObject);
        builder.setRefreshTimeMilliseconds(refreshTimeMilliseconds);
        if (AdType.CLEAR.equals(adTypeString)) {
            return builder.build();
        }
        builder.setDspCreativeId(HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.DSP_CREATIVE_ID));
        builder.setNetworkType(HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.NETWORK_TYPE));
        builder.setImpressionData(ImpressionData.m38534a(HeaderUtils.extractJsonObjectHeader(jsonHeaders, ResponseHeader.IMPRESSION_DATA)));
        String clickTrackingUrl = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.CLICK_TRACKING_URL);
        builder.setClickTrackingUrl(clickTrackingUrl);
        List<String> impressionUrls = HeaderUtils.m38533b(jsonHeaders, ResponseHeader.IMPRESSION_URLS);
        if (impressionUrls.isEmpty()) {
            impressionUrls.add(HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.IMPRESSION_URL));
        }
        builder.setImpressionTrackingUrls(impressionUrls);
        builder.setBeforeLoadUrl(HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.BEFORE_LOAD_URL));
        List<String> afterLoadUrls = HeaderUtils.m38533b(jsonHeaders, ResponseHeader.AFTER_LOAD_URL);
        if (afterLoadUrls.isEmpty()) {
            afterLoadUrls.add(HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.AFTER_LOAD_URL));
        }
        builder.setAfterLoadUrls(afterLoadUrls);
        List<String> afterLoadSuccessUrls = HeaderUtils.m38533b(jsonHeaders, ResponseHeader.AFTER_LOAD_SUCCESS_URL);
        if (afterLoadSuccessUrls.isEmpty()) {
            List list = afterLoadUrls;
            afterLoadSuccessUrls.add(HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.AFTER_LOAD_SUCCESS_URL));
        }
        builder.setAfterLoadSuccessUrls(afterLoadSuccessUrls);
        List<String> afterLoadFailUrls = HeaderUtils.m38533b(jsonHeaders, ResponseHeader.AFTER_LOAD_FAIL_URL);
        if (afterLoadFailUrls.isEmpty()) {
            List list2 = afterLoadSuccessUrls;
            afterLoadFailUrls.add(HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.AFTER_LOAD_FAIL_URL));
        }
        builder.setAfterLoadFailUrls(afterLoadFailUrls);
        builder.setRequestId(requestId);
        Integer width = HeaderUtils.extractIntegerHeader(jsonHeaders, ResponseHeader.WIDTH);
        List list3 = afterLoadFailUrls;
        Integer height = HeaderUtils.extractIntegerHeader(jsonHeaders, ResponseHeader.HEIGHT);
        builder.setDimensions(width, height);
        Integer num = width;
        Integer adTimeoutDelayMilliseconds = HeaderUtils.extractIntegerHeader(jsonHeaders, ResponseHeader.AD_TIMEOUT);
        builder.setAdTimeoutDelayMilliseconds(adTimeoutDelayMilliseconds);
        Integer num2 = adTimeoutDelayMilliseconds;
        String str2 = "json";
        boolean equals = str2.equals(adTypeString);
        Integer num3 = height;
        String str3 = AdType.VIDEO_NATIVE;
        if (equals || str3.equals(adTypeString)) {
            try {
                builder.setJsonBody(new JSONObject(content));
            } catch (JSONException e) {
                String str4 = content;
                String str5 = adTypeString;
                Integer num4 = refreshTimeMilliseconds;
                throw new MoPubNetworkError("Failed to decode body JSON for native ad format", (Throwable) e, Reason.BAD_BODY);
            }
        }
        String customEventClassName = AdTypeTranslator.getCustomEventName(adFormat2, adTypeString, fullAdTypeString, jsonHeaders);
        builder.setCustomEventClassName(customEventClassName);
        String str6 = customEventClassName;
        BrowserAgent browserAgent = BrowserAgent.fromHeader(HeaderUtils.extractIntegerHeader(jsonHeaders, ResponseHeader.BROWSER_AGENT));
        MoPub.setBrowserAgentFromAdServer(browserAgent);
        builder.setBrowserAgent(browserAgent);
        BrowserAgent browserAgent2 = browserAgent;
        String customEventData = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.CUSTOM_EVENT_DATA);
        if (TextUtils.isEmpty(customEventData)) {
            String str7 = customEventData;
            customEventData = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.NATIVE_PARAMS);
        } else {
            String str8 = customEventData;
        }
        try {
            Map jsonStringToMap = Json.jsonStringToMap(customEventData);
            try {
                if (!jsonHeaders.optString(str).isEmpty()) {
                    String str9 = customEventData;
                    try {
                        Integer num5 = refreshTimeMilliseconds;
                        map = jsonStringToMap;
                        try {
                            map.put(str, jsonHeaders.getString(str));
                        } catch (JSONException e2) {
                            e = e2;
                            String str10 = content;
                            String str11 = adTypeString;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        Integer num6 = refreshTimeMilliseconds;
                        Map map2 = jsonStringToMap;
                        String str12 = content;
                        String str13 = adTypeString;
                        throw new MoPubNetworkError("Failed to parse ADM for advanced bidding", (Throwable) e, Reason.BAD_BODY);
                    }
                } else {
                    Integer num7 = refreshTimeMilliseconds;
                    map = jsonStringToMap;
                }
                if (!TextUtils.isEmpty(clickTrackingUrl)) {
                    map.put(DataKeys.CLICKTHROUGH_URL_KEY, clickTrackingUrl);
                }
                if (m38549a(adTypeString, fullAdTypeString)) {
                    map.put(DataKeys.HTML_RESPONSE_BODY_KEY, content);
                    map.put(DataKeys.CREATIVE_ORIENTATION_KEY, HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.ORIENTATION));
                }
                if (str2.equals(adTypeString) || str3.equals(adTypeString)) {
                    String impressionMinVisiblePercent = HeaderUtils.m38530a(jsonHeaders, ResponseHeader.IMPRESSION_MIN_VISIBLE_PERCENT);
                    String impressionVisibleMS = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.IMPRESSION_VISIBLE_MS);
                    String impressionMinVisiblePx = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.IMPRESSION_MIN_VISIBLE_PX);
                    if (!TextUtils.isEmpty(impressionMinVisiblePercent)) {
                        String str14 = content;
                        map.put(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT, impressionMinVisiblePercent);
                    }
                    if (!TextUtils.isEmpty(impressionVisibleMS)) {
                        map.put(DataKeys.IMPRESSION_VISIBLE_MS, impressionVisibleMS);
                    }
                    if (!TextUtils.isEmpty(impressionMinVisiblePx)) {
                        map.put(DataKeys.IMPRESSION_MIN_VISIBLE_PX, impressionMinVisiblePx);
                    }
                } else {
                    String str15 = content;
                }
                if (str3.equals(adTypeString)) {
                    map.put(DataKeys.PLAY_VISIBLE_PERCENT, HeaderUtils.m38530a(jsonHeaders, ResponseHeader.PLAY_VISIBLE_PERCENT));
                    map.put(DataKeys.PAUSE_VISIBLE_PERCENT, HeaderUtils.m38530a(jsonHeaders, ResponseHeader.PAUSE_VISIBLE_PERCENT));
                    map.put(DataKeys.MAX_BUFFER_MS, HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.MAX_BUFFER_MS));
                }
                String videoTrackers = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.VIDEO_TRACKERS);
                if (!TextUtils.isEmpty(videoTrackers)) {
                    map.put(DataKeys.VIDEO_TRACKERS_KEY, videoTrackers);
                }
                String str16 = AdType.REWARDED_VIDEO;
                if (str16.equals(adTypeString) || (AdType.INTERSTITIAL.equals(adTypeString) && FullAdType.VAST.equals(fullAdTypeString))) {
                    map.put(DataKeys.EXTERNAL_VIDEO_VIEWABILITY_TRACKERS_KEY, HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.VIDEO_VIEWABILITY_TRACKERS));
                }
                if (AdFormat.BANNER.equals(adFormat2)) {
                    map.put(DataKeys.BANNER_IMPRESSION_MIN_VISIBLE_MS, HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.BANNER_IMPRESSION_MIN_VISIBLE_MS));
                    map.put(DataKeys.BANNER_IMPRESSION_MIN_VISIBLE_DIPS, HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.BANNER_IMPRESSION_MIN_VISIBLE_DIPS));
                }
                String disabledViewabilityVendors = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.DISABLE_VIEWABILITY);
                if (!TextUtils.isEmpty(disabledViewabilityVendors)) {
                    ViewabilityVendor disabledVendors = ViewabilityVendor.fromKey(disabledViewabilityVendors);
                    if (disabledVendors != null) {
                        disabledVendors.disable();
                    }
                }
                builder.setServerExtras(map);
                if (str16.equals(adTypeString) || AdType.CUSTOM.equals(adTypeString) || AdType.REWARDED_PLAYABLE.equals(adTypeString)) {
                    String rewardedVideoCurrencyName = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.REWARDED_VIDEO_CURRENCY_NAME);
                    String rewardedVideoCurrencyAmount = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.REWARDED_VIDEO_CURRENCY_AMOUNT);
                    String rewardedCurrencies = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.REWARDED_CURRENCIES);
                    String str17 = videoTrackers;
                    String rewardedVideoCompletionUrl = HeaderUtils.extractHeader(jsonHeaders, ResponseHeader.REWARDED_VIDEO_COMPLETION_URL);
                    Integer rewardedDuration = HeaderUtils.extractIntegerHeader(jsonHeaders, ResponseHeader.REWARDED_DURATION);
                    String str18 = disabledViewabilityVendors;
                    String str19 = adTypeString;
                    boolean shouldRewardOnClick = HeaderUtils.extractBooleanHeader(jsonHeaders, ResponseHeader.SHOULD_REWARD_ON_CLICK, false);
                    builder.setRewardedVideoCurrencyName(rewardedVideoCurrencyName);
                    builder.setRewardedVideoCurrencyAmount(rewardedVideoCurrencyAmount);
                    builder.setRewardedCurrencies(rewardedCurrencies);
                    builder.setRewardedVideoCompletionUrl(rewardedVideoCompletionUrl);
                    builder.setRewardedDuration(rewardedDuration);
                    builder.setShouldRewardOnClick(shouldRewardOnClick);
                } else {
                    String str20 = videoTrackers;
                    String str21 = disabledViewabilityVendors;
                    String str22 = adTypeString;
                }
                return builder.build();
            } catch (JSONException e4) {
                e = e4;
                String str23 = customEventData;
                String str24 = adTypeString;
                Integer num8 = refreshTimeMilliseconds;
                Map map3 = jsonStringToMap;
                String str25 = content;
                throw new MoPubNetworkError("Failed to parse ADM for advanced bidding", (Throwable) e, Reason.BAD_BODY);
            }
        } catch (JSONException e5) {
            String str26 = content;
            String str27 = customEventData;
            String str28 = adTypeString;
            Integer num9 = refreshTimeMilliseconds;
            throw new MoPubNetworkError("Failed to decode server extras for custom event data.", (Throwable) e5, Reason.BAD_HEADER_DATA);
        }
    }

    /* renamed from: a */
    private static Integer m38547a(JSONObject item) throws JSONException {
        Preconditions.checkNotNull(item);
        Integer refreshTimeSeconds = HeaderUtils.extractIntegerHeader(item.getJSONObject(ResponseHeader.METADATA.getKey()), ResponseHeader.REFRESH_TIME);
        if (refreshTimeSeconds == null) {
            return null;
        }
        return Integer.valueOf(refreshTimeSeconds.intValue() * 1000);
    }

    /* renamed from: b */
    private static boolean m38550b(JSONObject item) {
        Preconditions.checkNotNull(item);
        return HeaderUtils.extractBooleanHeader(item.optJSONObject(ResponseHeader.METADATA.getKey()), ResponseHeader.WARMUP, false);
    }

    /* renamed from: a */
    private static String m38548a(NetworkResponse response) {
        Preconditions.checkNotNull(response);
        try {
            return new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            return new String(response.data);
        }
    }

    /* renamed from: a */
    private static boolean m38549a(String adType, String fullAdType) {
        if (!AdType.MRAID.equals(adType) && !AdType.HTML.equals(adType)) {
            boolean equals = AdType.INTERSTITIAL.equals(adType);
            String str = FullAdType.VAST;
            if ((!equals || !str.equals(fullAdType)) && ((!AdType.REWARDED_VIDEO.equals(adType) || !str.equals(fullAdType)) && !AdType.REWARDED_PLAYABLE.equals(adType))) {
                return false;
            }
        }
        return true;
    }
}
