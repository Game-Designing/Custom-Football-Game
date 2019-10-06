package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mopub.common.AdReport;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.DataKeys;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Json;
import com.mopub.common.util.MoPubCollections;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.common.util.Utils;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NoConnectionError;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONException;
import org.json.JSONObject;

public class MoPubRewardedVideoManager {
    public static final int API_VERSION = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static MoPubRewardedVideoManager f34859a;

    /* renamed from: b */
    private static SharedPreferences f34860b;

    /* renamed from: c */
    private final Handler f34861c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private WeakReference<Activity> f34862d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Context f34863e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C11442ra f34864f = new C11442ra();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MoPubRewardedVideoListener f34865g;

    /* renamed from: h */
    private final Set<MediationSettings> f34866h = new HashSet();

    /* renamed from: i */
    private final Map<String, Set<MediationSettings>> f34867i;

    /* renamed from: j */
    private final Handler f34868j;

    /* renamed from: k */
    private final Map<String, Runnable> f34869k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final RewardedAdsLoaders f34870l;

    public static final class RequestParameters {
        public final String mCustomerId;
        public final String mKeywords;
        public final Location mLocation;
        public final String mUserDataKeywords;

        public RequestParameters(String keywords) {
            this(keywords, null);
        }

        public RequestParameters(String keywords, String userDataKeywords) {
            this(keywords, userDataKeywords, null);
        }

        public RequestParameters(String keywords, String userDataKeywords, Location location) {
            this(keywords, userDataKeywords, location, null);
        }

        public RequestParameters(String keywords, String userDataKeywords, Location location, String customerId) {
            this.mKeywords = keywords;
            this.mCustomerId = customerId;
            boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
            Location location2 = null;
            this.mUserDataKeywords = canCollectPersonalInformation ? userDataKeywords : null;
            if (canCollectPersonalInformation) {
                location2 = location;
            }
            this.mLocation = location2;
        }
    }

    /* renamed from: com.mopub.mobileads.MoPubRewardedVideoManager$a */
    private static abstract class C11334a implements Runnable {

        /* renamed from: a */
        private final Class<? extends CustomEventRewardedAd> f34871a;

        /* renamed from: b */
        private final String f34872b;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo37099a(String str);

        C11334a(Class<? extends CustomEventRewardedAd> customEventClass, String thirdPartyId) {
            Preconditions.checkNotNull(customEventClass);
            Preconditions.checkNotNull(thirdPartyId);
            this.f34871a = customEventClass;
            this.f34872b = thirdPartyId;
        }

        public void run() {
            for (String moPubId : MoPubRewardedVideoManager.f34859a.f34864f.mo37508a(this.f34871a, this.f34872b)) {
                mo37099a(moPubId);
            }
        }
    }

    private MoPubRewardedVideoManager(Activity mainActivity, MediationSettings... mediationSettings) {
        this.f34862d = new WeakReference<>(mainActivity);
        this.f34863e = mainActivity.getApplicationContext();
        MoPubCollections.addAllNonNull((Collection<? super T>) this.f34866h, (T[]) mediationSettings);
        this.f34867i = new HashMap();
        this.f34868j = new Handler();
        this.f34869k = new HashMap();
        this.f34870l = new RewardedAdsLoaders(this);
        f34860b = SharedPreferencesHelper.getSharedPreferences(this.f34863e, "mopubCustomEventSettings");
    }

    public static synchronized void init(Activity mainActivity, MediationSettings... mediationSettings) {
        synchronized (MoPubRewardedVideoManager.class) {
            if (f34859a == null) {
                f34859a = new MoPubRewardedVideoManager(mainActivity, mediationSettings);
            } else {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Tried to call initializeRewardedVideo more than once. Only the first initialization call has any effect.");
            }
        }
    }

    @ReflectionTarget
    public static void updateActivity(Activity activity) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager != null) {
            moPubRewardedVideoManager.f34862d = new WeakReference<>(activity);
        } else {
            m37468b();
        }
    }

    public static <T extends MediationSettings> T getGlobalMediationSettings(Class<T> clazz) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager == null) {
            m37468b();
            return null;
        }
        for (MediationSettings mediationSettings : moPubRewardedVideoManager.f34866h) {
            if (clazz.equals(mediationSettings.getClass())) {
                return (MediationSettings) clazz.cast(mediationSettings);
            }
        }
        return null;
    }

    public static <T extends MediationSettings> T getInstanceMediationSettings(Class<T> clazz, String adUnitId) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager == null) {
            m37468b();
            return null;
        }
        Set<MediationSettings> instanceMediationSettings = (Set) moPubRewardedVideoManager.f34867i.get(adUnitId);
        if (instanceMediationSettings == null) {
            return null;
        }
        for (MediationSettings mediationSettings : instanceMediationSettings) {
            if (clazz.equals(mediationSettings.getClass())) {
                return (MediationSettings) clazz.cast(mediationSettings);
            }
        }
        return null;
    }

    public static void setVideoListener(MoPubRewardedVideoListener listener) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager != null) {
            moPubRewardedVideoManager.f34865g = listener;
        } else {
            m37468b();
        }
    }

    public static void loadVideo(String adUnitId, RequestParameters requestParameters, MediationSettings... mediationSettings) {
        Preconditions.checkNotNull(adUnitId);
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager == null) {
            m37468b();
        } else if (adUnitId.equals(moPubRewardedVideoManager.f34864f.mo37507a())) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. The ad is already showing.", new Object[]{adUnitId}));
        } else if (f34859a.f34870l.mo37165a(adUnitId)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. This ad unit already finished loading and is ready to show.", new Object[]{adUnitId}));
            m37461a((Runnable) new C11391ca(adUnitId));
        } else {
            Set<MediationSettings> newInstanceMediationSettings = new HashSet<>();
            MoPubCollections.addAllNonNull((Collection<? super T>) newInstanceMediationSettings, (T[]) mediationSettings);
            f34859a.f34867i.put(adUnitId, newInstanceMediationSettings);
            String customerId = requestParameters == null ? null : requestParameters.mCustomerId;
            if (!TextUtils.isEmpty(customerId)) {
                f34859a.f34864f.mo37526i(customerId);
            }
            m37471b(adUnitId, new WebViewAdUrlGenerator(f34859a.f34863e, false).withAdUnitId(adUnitId).withKeywords(requestParameters == null ? null : requestParameters.mKeywords).withUserDataKeywords((requestParameters == null || !MoPub.canCollectPersonalInformation()) ? null : requestParameters.mUserDataKeywords).withLocation(requestParameters == null ? null : requestParameters.mLocation).generateUrlString(Constants.HOST), null);
        }
    }

    /* renamed from: b */
    private static void m37471b(String adUnitId, String adUrlString, MoPubErrorCode errorCode) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager == null) {
            m37468b();
        } else {
            moPubRewardedVideoManager.m37465a(adUnitId, adUrlString, errorCode);
        }
    }

    /* renamed from: a */
    private void m37465a(String adUnitId, String adUrlString, MoPubErrorCode errorCode) {
        if (this.f34870l.mo37169d(adUnitId)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. A request is already pending.", new Object[]{adUnitId}));
            return;
        }
        MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Loading rewarded ad request for ad unit %s with URL %s", new Object[]{adUnitId, adUrlString}));
        this.f34870l.mo37163a(this.f34863e, adUnitId, adUrlString, errorCode);
    }

    public static boolean hasVideo(String adUnitId) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager != null) {
            return m37466a(adUnitId, moPubRewardedVideoManager.f34864f.mo37520c(adUnitId));
        }
        m37468b();
        return false;
    }

    public static void showVideo(String adUnitId) {
        showVideo(adUnitId, null);
    }

    public static void showVideo(String adUnitId, String customData) {
        if (f34859a == null) {
            m37468b();
            return;
        }
        if (customData != null && customData.length() > 8192) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Provided rewarded ad custom data parameter longer than supported(%d bytes, %d maximum)", new Object[]{Integer.valueOf(customData.length()), Integer.valueOf(Opcodes.ACC_ANNOTATION)}));
        }
        CustomEventRewardedAd customEvent = f34859a.f34864f.mo37520c(adUnitId);
        if (!m37466a(adUnitId, customEvent)) {
            if (f34859a.f34870l.mo37169d(adUnitId)) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Rewarded ad is not ready to be shown yet.");
            } else {
                MoPubLog.log(SdkLogEvent.CUSTOM, "No rewarded ad loading or loaded.");
            }
            f34859a.m37470b(adUnitId, MoPubErrorCode.VIDEO_NOT_AVAILABLE);
        } else if (f34859a.f34864f.mo37509a(adUnitId).isEmpty() || f34859a.f34864f.mo37521d(adUnitId) != null) {
            f34859a.f34864f.mo37510a(customEvent.getClass(), f34859a.f34864f.mo37521d(adUnitId));
            f34859a.f34864f.mo37514a(adUnitId, customData);
            f34859a.f34864f.mo37525h(adUnitId);
            customEvent.mo36994c();
        } else {
            f34859a.m37470b(adUnitId, MoPubErrorCode.REWARD_NOT_SELECTED);
        }
    }

    /* renamed from: a */
    private static boolean m37466a(String adUnitId, CustomEventRewardedAd customEvent) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        return moPubRewardedVideoManager != null && moPubRewardedVideoManager.f34870l.mo37165a(adUnitId) && customEvent != null && customEvent.mo36993a();
    }

    public static Set<MoPubReward> getAvailableRewards(String adUnitId) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager != null) {
            return moPubRewardedVideoManager.f34864f.mo37509a(adUnitId);
        }
        m37468b();
        return Collections.emptySet();
    }

    public static void selectReward(String adUnitId, MoPubReward selectedReward) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager != null) {
            moPubRewardedVideoManager.f34864f.mo37512a(adUnitId, selectedReward);
        } else {
            m37468b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37097a(AdResponse adResponse) {
        AdResponse adResponse2 = adResponse;
        String adUnitId = adResponse.getAdUnitId();
        Integer timeoutMillis = adResponse2.getAdTimeoutMillis(30000);
        String customEventClassName = adResponse.getCustomEventClassName();
        if (customEventClassName == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Couldn't create custom event, class name was null.");
            m37470b(adUnitId, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        CustomEventRewardedAd oldRewardedVideo = this.f34864f.mo37520c(adUnitId);
        if (oldRewardedVideo != null) {
            oldRewardedVideo.mo36904b();
        }
        try {
            CustomEventRewardedAd customEvent = (CustomEventRewardedAd) Reflection.instantiateClassWithEmptyConstructor(customEventClassName, CustomEventRewardedAd.class);
            Map<String, Object> localExtras = new TreeMap<>();
            localExtras.put(DataKeys.AD_UNIT_ID_KEY, adUnitId);
            localExtras.put(DataKeys.REWARDED_AD_CURRENCY_NAME_KEY, adResponse.getRewardedVideoCurrencyName());
            localExtras.put(DataKeys.REWARDED_AD_CURRENCY_AMOUNT_STRING_KEY, adResponse.getRewardedVideoCurrencyAmount());
            localExtras.put(DataKeys.REWARDED_AD_DURATION_KEY, adResponse.getRewardedDuration());
            localExtras.put(DataKeys.SHOULD_REWARD_ON_CLICK_KEY, Boolean.valueOf(adResponse.shouldRewardOnClick()));
            localExtras.put(DataKeys.AD_REPORT_KEY, new AdReport(adUnitId, ClientMetadata.getInstance(this.f34863e), adResponse2));
            localExtras.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(Utils.generateUniqueId()));
            localExtras.put("rewarded-ad-customer-id", this.f34864f.mo37516b());
            String rewardedCurrencies = adResponse.getRewardedCurrencies();
            this.f34864f.mo37523f(adUnitId);
            this.f34864f.mo37524g(adUnitId);
            if (TextUtils.isEmpty(rewardedCurrencies)) {
                try {
                    this.f34864f.mo37519b(adUnitId, adResponse.getRewardedVideoCurrencyName(), adResponse.getRewardedVideoCurrencyAmount());
                } catch (Exception e) {
                    Integer num = timeoutMillis;
                }
            } else {
                try {
                    m37464a(adUnitId, rewardedCurrencies);
                } catch (Exception e2) {
                    Integer num2 = timeoutMillis;
                    Exception exc = e2;
                    SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error parsing rewarded currencies JSON header: ");
                    sb.append(rewardedCurrencies);
                    MoPubLog.log(sdkLogEvent, sb.toString());
                    m37470b(adUnitId, MoPubErrorCode.REWARDED_CURRENCIES_PARSING_ERROR);
                    return;
                }
            }
            this.f34864f.mo37518b(adUnitId, adResponse.getRewardedVideoCompletionUrl());
            Activity mainActivity = (Activity) this.f34862d.get();
            if (mainActivity == null) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Could not load custom event because Activity reference was null. Call MoPub#updateActivity before requesting more rewarded ads.");
                this.f34870l.mo37170e(adUnitId);
                return;
            }
            Runnable timeout = new C11394da(this, customEvent);
            this.f34868j.postDelayed(timeout, (long) timeoutMillis.intValue());
            this.f34869k.put(adUnitId, timeout);
            Map<String, String> serverExtras = adResponse.getServerExtras();
            if (customEvent instanceof CustomEventRewardedVideo) {
                String serverExtrasJsonString = new JSONObject(serverExtras).toString();
                SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
                Object[] objArr = new Object[1];
                Integer num3 = timeoutMillis;
                try {
                    objArr[0] = String.format(Locale.US, "Updating init settings for custom event %s with params %s", new Object[]{customEventClassName, serverExtrasJsonString});
                    MoPubLog.log(sdkLogEvent2, objArr);
                    f34860b.edit().putString(customEventClassName, serverExtrasJsonString).apply();
                } catch (Exception e3) {
                    MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Couldn't create custom event with class name %s", new Object[]{customEventClassName}));
                    m37470b(adUnitId, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                }
            }
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Loading custom event with class name %s", new Object[]{customEventClassName}));
            customEvent.mo36992a(mainActivity, localExtras, serverExtras);
            this.f34864f.mo37513a(adUnitId, customEvent, customEvent.getAdNetworkId());
        } catch (Exception e4) {
            Integer num4 = timeoutMillis;
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Couldn't create custom event with class name %s", new Object[]{customEventClassName}));
            m37470b(adUnitId, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37098a(VolleyError volleyError, String adUnitId) {
        MoPubErrorCode errorCode = MoPubErrorCode.INTERNAL_ERROR;
        if (volleyError instanceof MoPubNetworkError) {
            int i = C11384ba.f35219a[((MoPubNetworkError) volleyError).getReason().ordinal()];
            if (i == 1 || i == 2) {
                errorCode = MoPubErrorCode.NO_FILL;
            } else {
                errorCode = MoPubErrorCode.INTERNAL_ERROR;
            }
        }
        if (volleyError instanceof NoConnectionError) {
            errorCode = MoPubErrorCode.NO_CONNECTION;
        }
        m37470b(adUnitId, errorCode);
    }

    /* renamed from: a */
    private void m37464a(String adUnitId, String rewardedCurrencies) throws JSONException {
        String[] rewardsArray = Json.jsonArrayToStringArray((String) Json.jsonStringToMap(rewardedCurrencies).get("rewards"));
        String str = "amount";
        String str2 = "name";
        if (rewardsArray.length == 1) {
            Map<String, String> rewardData = Json.jsonStringToMap(rewardsArray[0]);
            this.f34864f.mo37519b(adUnitId, (String) rewardData.get(str2), (String) rewardData.get(str));
        }
        for (String rewardDataStr : rewardsArray) {
            Map<String, String> rewardData2 = Json.jsonStringToMap(rewardDataStr);
            this.f34864f.mo37515a(adUnitId, (String) rewardData2.get(str2), (String) rewardData2.get(str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m37470b(String adUnitId, MoPubErrorCode errorCode) {
        Preconditions.checkNotNull(adUnitId);
        Preconditions.checkNotNull(errorCode);
        if (!this.f34870l.mo37168c(adUnitId) || errorCode.equals(MoPubErrorCode.EXPIRED)) {
            MoPubRewardedVideoListener moPubRewardedVideoListener = f34859a.f34865g;
            if (moPubRewardedVideoListener != null) {
                moPubRewardedVideoListener.onRewardedVideoLoadFailure(adUnitId, errorCode);
                return;
            }
            return;
        }
        m37471b(adUnitId, "", errorCode);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m37476d(String moPubId) {
        Runnable runnable = (Runnable) this.f34869k.remove(moPubId);
        if (runnable != null) {
            this.f34868j.removeCallbacks(runnable);
        }
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoLoadSuccess(Class<T> customEventClass, String thirdPartyId) {
        m37461a((Runnable) new C11397ea(customEventClass, thirdPartyId));
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoLoadFailure(Class<T> customEventClass, String thirdPartyId, MoPubErrorCode errorCode) {
        m37461a((Runnable) new C11400fa(customEventClass, thirdPartyId, errorCode));
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoStarted(Class<T> customEventClass, String thirdPartyId) {
        String currentlyShowingAdUnitId = f34859a.f34864f.mo37507a();
        if (TextUtils.isEmpty(currentlyShowingAdUnitId)) {
            m37461a((Runnable) new C11403ga(customEventClass, thirdPartyId));
        } else {
            m37461a((Runnable) new C11406ha(currentlyShowingAdUnitId));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static void m37479g(String adUnitId) {
        Preconditions.checkNotNull(adUnitId);
        MoPubRewardedVideoListener moPubRewardedVideoListener = f34859a.f34865g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener.onRewardedVideoStarted(adUnitId);
        }
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        moPubRewardedVideoManager.f34870l.mo37167b(adUnitId, moPubRewardedVideoManager.f34863e);
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoPlaybackError(Class<T> customEventClass, String thirdPartyId, MoPubErrorCode errorCode) {
        String currentlyShowingAdUnitId = f34859a.f34864f.mo37507a();
        if (TextUtils.isEmpty(currentlyShowingAdUnitId)) {
            m37461a((Runnable) new C11409ia(customEventClass, thirdPartyId, errorCode));
        } else {
            m37461a((Runnable) new C11416ja(currentlyShowingAdUnitId, errorCode));
        }
        f34859a.f34864f.mo37525h(null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m37474c(String adUnitId, MoPubErrorCode errorCode) {
        Preconditions.checkNotNull(adUnitId);
        Preconditions.checkNotNull(errorCode);
        f34859a.f34870l.mo37170e(adUnitId);
        MoPubRewardedVideoListener moPubRewardedVideoListener = f34859a.f34865g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener.onRewardedVideoPlaybackError(adUnitId, errorCode);
        }
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoClicked(Class<T> customEventClass, String thirdPartyId) {
        String currentlyShowingAdUnitId = f34859a.f34864f.mo37507a();
        if (TextUtils.isEmpty(currentlyShowingAdUnitId)) {
            m37461a((Runnable) new C11419ka(customEventClass, thirdPartyId));
        } else {
            m37461a((Runnable) new C11366W(currentlyShowingAdUnitId));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m37477e(String adUnitId) {
        Preconditions.checkNotNull(adUnitId);
        MoPubRewardedVideoListener moPubRewardedVideoListener = f34859a.f34865g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener.onRewardedVideoClicked(adUnitId);
        }
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        moPubRewardedVideoManager.f34870l.mo37164a(adUnitId, moPubRewardedVideoManager.f34863e);
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoClosed(Class<T> customEventClass, String thirdPartyId) {
        String currentlyShowingAdUnitId = f34859a.f34864f.mo37507a();
        if (TextUtils.isEmpty(currentlyShowingAdUnitId)) {
            m37461a((Runnable) new C11369X(customEventClass, thirdPartyId));
        } else {
            m37461a((Runnable) new C11371Y(currentlyShowingAdUnitId));
        }
        f34859a.f34864f.mo37525h(null);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m37478f(String adUnitId) {
        Preconditions.checkNotNull(adUnitId);
        f34859a.f34870l.mo37171f(adUnitId);
        MoPubRewardedVideoListener moPubRewardedVideoListener = f34859a.f34865g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener.onRewardedVideoClosed(adUnitId);
        }
    }

    public static <T extends CustomEventRewardedAd> void onRewardedVideoCompleted(Class<T> customEventClass, String thirdPartyId, MoPubReward moPubReward) {
        String currentlyShowingAdUnitId = f34859a.f34864f.mo37507a();
        m37460a(customEventClass, thirdPartyId, moPubReward, currentlyShowingAdUnitId);
        m37480h(currentlyShowingAdUnitId);
    }

    /* renamed from: h */
    private static void m37480h(String currentlyShowingAdUnitId) {
        String serverCompletionUrl = f34859a.f34864f.mo37522e(currentlyShowingAdUnitId);
        if (!TextUtils.isEmpty(serverCompletionUrl)) {
            m37461a((Runnable) new C11375Z(currentlyShowingAdUnitId, serverCompletionUrl));
        }
    }

    /* renamed from: a */
    private static <T extends CustomEventRewardedAd> void m37460a(Class<T> customEventClass, String thirdPartyId, MoPubReward moPubReward, String currentlyShowingAdUnitId) {
        m37461a((Runnable) new C11379aa(customEventClass, moPubReward, currentlyShowingAdUnitId, thirdPartyId));
    }

    @VisibleForTesting
    /* renamed from: a */
    static MoPubReward m37455a(MoPubReward moPubReward, MoPubReward networkReward) {
        if (!networkReward.isSuccessful()) {
            return networkReward;
        }
        return moPubReward != null ? moPubReward : networkReward;
    }

    /* renamed from: a */
    private static void m37461a(Runnable runnable) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f34859a;
        if (moPubRewardedVideoManager != null) {
            moPubRewardedVideoManager.f34861c.post(runnable);
        }
    }

    /* renamed from: b */
    private static void m37468b() {
        MoPubLog.log(SdkLogEvent.CUSTOM, "MoPub rewarded ad was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play rewarded ads.");
    }
}
