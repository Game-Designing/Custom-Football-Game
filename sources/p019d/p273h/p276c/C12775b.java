package p019d.p273h.p276c;

import android.app.Activity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p280d.C12803e;
import p019d.p273h.p276c.p280d.C12804f;
import p019d.p273h.p276c.p282f.C12860a;
import p019d.p273h.p276c.p282f.C12866d;
import p019d.p273h.p276c.p282f.C12867da;
import p019d.p273h.p276c.p282f.C12868e;
import p019d.p273h.p276c.p282f.C12869ea;
import p019d.p273h.p276c.p282f.C12875ha;
import p019d.p273h.p276c.p282f.C12880k;
import p019d.p273h.p276c.p282f.C12885ma;
import p019d.p273h.p276c.p282f.C12889p;

/* renamed from: d.h.c.b */
/* compiled from: AbstractAdapter */
public abstract class C12775b implements C12868e, C12880k, C12875ha, C12860a, C12804f, C12867da {
    /* access modifiers changed from: protected */
    public C12866d mActiveBannerSmash;
    protected C12889p mActiveInterstitialSmash;
    protected C12885ma mActiveRewardedVideoSmash;
    protected CopyOnWriteArrayList<C12866d> mAllBannerSmashes = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<C12889p> mAllInterstitialSmashes = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<C12885ma> mAllRewardedVideoSmashes = new CopyOnWriteArrayList<>();
    protected ConcurrentHashMap<String, C12866d> mBannerPlacementToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, C12889p> mInterstitialPlacementToListenerMap = new ConcurrentHashMap<>();
    private C12802d mLoggerManager = C12802d.m41613c();
    private String mPluginFrameworkVersion;
    private String mPluginType;
    private String mProviderName;
    protected C12869ea mRewardedInterstitial;
    protected ConcurrentHashMap<String, C12885ma> mRewardedVideoPlacementToListenerMap = new ConcurrentHashMap<>();

    public abstract String getCoreSDKVersion();

    public abstract String getVersion();

    public void preInitInterstitial(Activity activity, String appKey, String userId, JSONObject config, C12889p listener) {
    }

    public void initInterstitialForBidding(Activity activity, String appKey, String userId, JSONObject config, C12889p listener) {
    }

    public void initRvForBidding(Activity activity, String appKey, String userId, JSONObject config, C12885ma listener) {
    }

    public void loadVideo(JSONObject config, C12885ma listener, String serverData) {
    }

    public void loadInterstitial(JSONObject config, C12889p listener, String serverData) {
    }

    public Map<String, Object> getIsBiddingData(JSONObject config) {
        return null;
    }

    public Map<String, Object> getRvBiddingData(JSONObject config) {
        return null;
    }

    public C12775b(String providerName) {
        this.mProviderName = providerName;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    /* access modifiers changed from: protected */
    public String getDynamicUserId() {
        return C12747I.m41186g().mo41227e();
    }

    /* access modifiers changed from: 0000 */
    public void setPluginData(String pluginType, String pluginFrameworkVersion) {
        this.mPluginType = pluginType;
        this.mPluginFrameworkVersion = pluginFrameworkVersion;
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getPluginFrameworkVersion() {
        return this.mPluginFrameworkVersion;
    }

    /* access modifiers changed from: protected */
    public void log(C12801a tag, String message, int logLevel) {
        this.mLoggerManager.mo41435a(tag, message, logLevel);
    }

    public void setLogListener(C12803e logListener) {
    }

    public void setRewardedInterstitialListener(C12869ea listener) {
        this.mRewardedInterstitial = listener;
    }

    /* access modifiers changed from: protected */
    public boolean isAdaptersDebugEnabled() {
        return this.mLoggerManager.mo41438d();
    }

    public void initBanners(Activity activity, String appKey, String userId, JSONObject config, C12866d listener) {
    }

    public void loadBanner(C12745G banner, JSONObject config, C12866d listener) {
    }

    public void destroyBanner(JSONObject config) {
    }

    public void reloadBanner(JSONObject config) {
    }

    /* access modifiers changed from: protected */
    public void addBannerListener(C12866d listener) {
    }

    /* access modifiers changed from: protected */
    public void removeBannerListener(C12866d listener) {
    }

    public void addRewardedVideoListener(C12885ma listener) {
        this.mAllRewardedVideoSmashes.add(listener);
    }

    public void removeRewardedVideoListener(C12885ma listener) {
        this.mAllRewardedVideoSmashes.remove(listener);
    }

    public void addInterstitialListener(C12889p listener) {
        this.mAllInterstitialSmashes.add(listener);
    }

    public void removeInterstitialListener(C12889p listener) {
        this.mAllInterstitialSmashes.remove(listener);
    }

    public void onResume(Activity activity) {
    }

    public void onPause(Activity activity) {
    }

    public void setAge(int age) {
    }

    public void setGender(String gender) {
    }

    public void setMediationSegment(String segment) {
    }

    /* access modifiers changed from: protected */
    public void setMediationState(C12792a state, String adUnit) {
    }

    /* access modifiers changed from: protected */
    public void setConsent(boolean consent) {
    }
}
