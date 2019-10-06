package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.ExternalViewabilitySessionManager.ViewabilityVendor;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import com.mopub.network.Networking;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MoPub {
    public static final String SDK_VERSION = "5.7.1";

    /* renamed from: a */
    private static volatile LocationAwareness f97a = LocationAwareness.NORMAL;

    /* renamed from: b */
    private static volatile int f98b = 6;

    /* renamed from: c */
    private static volatile long f99c = 60000;

    /* renamed from: d */
    private static volatile BrowserAgent f100d = BrowserAgent.IN_APP;

    /* renamed from: e */
    private static volatile boolean f101e = false;

    /* renamed from: f */
    private static boolean f102f = false;

    /* renamed from: g */
    private static Method f103g;

    /* renamed from: h */
    private static boolean f104h = false;

    /* renamed from: i */
    private static boolean f105i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static AdapterConfigurationManager f106j;

    /* renamed from: k */
    private static PersonalInfoManager f107k;

    public enum BrowserAgent {
        IN_APP,
        NATIVE;

        public static BrowserAgent fromHeader(Integer browserAgent) {
            if (browserAgent == null) {
                return IN_APP;
            }
            return browserAgent.intValue() == 1 ? NATIVE : IN_APP;
        }
    }

    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED
    }

    /* renamed from: com.mopub.common.MoPub$a */
    private static class C0092a implements SdkInitializationListener {

        /* renamed from: a */
        private SdkInitializationListener f110a;

        C0092a(SdkInitializationListener sdkInitializationListener) {
            this.f110a = sdkInitializationListener;
        }

        public void onInitializationFinished() {
            AdapterConfigurationManager adapterConfigurationManager = MoPub.f106j;
            if (adapterConfigurationManager != null) {
                MoPubLog.log(SdkLogEvent.INIT_FINISHED, adapterConfigurationManager.getAdapterConfigurationInfo());
            }
            MoPub.m554b(this.f110a);
            this.f110a = null;
        }
    }

    public static LocationAwareness getLocationAwareness() {
        Preconditions.checkNotNull(f97a);
        return f97a;
    }

    public static void setLocationAwareness(LocationAwareness locationAwareness) {
        Preconditions.checkNotNull(locationAwareness);
        f97a = locationAwareness;
    }

    public static int getLocationPrecision() {
        return f98b;
    }

    public static void setLocationPrecision(int precision) {
        f98b = Math.min(Math.max(0, precision), 6);
    }

    public static void setMinimumLocationRefreshTimeMillis(long minimumLocationRefreshTimeMillis) {
        f99c = minimumLocationRefreshTimeMillis;
    }

    public static long getMinimumLocationRefreshTimeMillis() {
        return f99c;
    }

    public static void setBrowserAgent(BrowserAgent browserAgent) {
        Preconditions.checkNotNull(browserAgent);
        f100d = browserAgent;
        f101e = true;
    }

    public static void setBrowserAgentFromAdServer(BrowserAgent adServerBrowserAgent) {
        Preconditions.checkNotNull(adServerBrowserAgent);
        if (f101e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Browser agent already overridden by client with value ");
            sb.append(f100d);
            MoPubLog.log(sdkLogEvent, sb.toString());
            return;
        }
        f100d = adServerBrowserAgent;
    }

    public static BrowserAgent getBrowserAgent() {
        Preconditions.checkNotNull(f100d);
        return f100d;
    }

    public static void initializeSdk(Context context, SdkConfiguration sdkConfiguration, SdkInitializationListener sdkInitializationListener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(sdkConfiguration);
        MoPubLog.setLogLevel(sdkConfiguration.mo3275a());
        MoPubLog.log(SdkLogEvent.INIT_STARTED, new Object[0]);
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("SDK initialize has been called with ad unit: ");
        sb.append(sdkConfiguration.getAdUnitId());
        MoPubLog.log(sdkLogEvent, sb.toString());
        if (context instanceof Activity) {
            m552a((Activity) context, sdkConfiguration);
        }
        if (f104h) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "MoPub SDK is already initialized");
            m554b(sdkInitializationListener);
        } else if (f105i) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "MoPub SDK is currently initializing.");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "MoPub can only be initialized on the main thread.");
        } else {
            f105i = true;
            Networking.getRequestQueue(context);
            SdkInitializationListener compositeSdkInitializationListener = new C11247h(new C0092a(sdkInitializationListener), 2);
            f107k = new PersonalInfoManager(context, sdkConfiguration.getAdUnitId(), compositeSdkInitializationListener);
            f107k.setAllowLegitimateInterest(sdkConfiguration.getLegitimateInterestAllowed());
            ClientMetadata.getInstance(context);
            f106j = new AdapterConfigurationManager(compositeSdkInitializationListener);
            f106j.initialize(context, sdkConfiguration.getAdapterConfigurationClasses(), sdkConfiguration.getMediatedNetworkConfigurations(), sdkConfiguration.getMoPubRequestOptions());
        }
    }

    public static boolean isSdkInitialized() {
        return f104h;
    }

    public static boolean canCollectPersonalInformation() {
        PersonalInfoManager personalInfoManager = f107k;
        return personalInfoManager != null && personalInfoManager.canCollectPersonalInformation();
    }

    public static void setAllowLegitimateInterest(boolean allowed) {
        PersonalInfoManager personalInfoManager = f107k;
        if (personalInfoManager != null) {
            personalInfoManager.setAllowLegitimateInterest(allowed);
        }
    }

    public static boolean shouldAllowLegitimateInterest() {
        PersonalInfoManager personalInfoManager = f107k;
        return personalInfoManager != null && personalInfoManager.shouldAllowLegitimateInterest();
    }

    /* renamed from: a */
    static String m550a(Context context) {
        Preconditions.checkNotNull(context);
        AdapterConfigurationManager adapterConfigurationManager = f106j;
        if (adapterConfigurationManager == null) {
            return null;
        }
        return adapterConfigurationManager.mo36429a(context);
    }

    public static PersonalInfoManager getPersonalInformationManager() {
        return f107k;
    }

    @Deprecated
    @VisibleForTesting
    public static void resetBrowserAgent() {
        f100d = BrowserAgent.IN_APP;
        f101e = false;
    }

    public static void onCreate(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onCreate(activity);
        m551a(activity);
    }

    public static void onStart(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStart(activity);
        m551a(activity);
    }

    public static void onPause(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onPause(activity);
    }

    public static void onResume(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onResume(activity);
        m551a(activity);
    }

    public static void onRestart(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onRestart(activity);
        m551a(activity);
    }

    public static void onStop(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStop(activity);
    }

    public static void onDestroy(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onDestroy(activity);
    }

    public static void onBackPressed(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onBackPressed(activity);
    }

    public static void disableViewability(ViewabilityVendor vendor) {
        Preconditions.checkNotNull(vendor);
        vendor.disable();
    }

    public static List<String> getAdapterConfigurationInfo() {
        AdapterConfigurationManager configurationManager = f106j;
        if (configurationManager != null) {
            return configurationManager.getAdapterConfigurationInfo();
        }
        return null;
    }

    /* renamed from: a */
    private static void m552a(Activity activity, SdkConfiguration sdkConfiguration) {
        String str = "initializeRewardedVideo was called without the rewarded video module";
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(sdkConfiguration);
        try {
            new MethodBuilder(null, "initializeRewardedVideo").setStatic(Class.forName("com.mopub.mobileads.MoPubRewardedVideos")).setAccessible().addParam(Activity.class, activity).addParam(SdkConfiguration.class, sdkConfiguration).execute();
        } catch (ClassNotFoundException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, str);
        } catch (NoSuchMethodException e2) {
            MoPubLog.log(SdkLogEvent.CUSTOM, str);
        } catch (Exception e3) {
            MoPubLog.log(SdkLogEvent.ERROR, "Error while initializing rewarded video", e3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m554b(SdkInitializationListener sdkInitializationListener) {
        f105i = false;
        f104h = true;
        new Handler(Looper.getMainLooper()).post(new C11256p(sdkInitializationListener));
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m551a(Activity activity) {
        String str = "Error while attempting to access the update activity method - this should not have happened";
        if (!f102f) {
            f102f = true;
            try {
                f103g = Reflection.getDeclaredMethodWithTraversal(Class.forName("com.mopub.mobileads.MoPubRewardedVideoManager"), "updateActivity", Activity.class);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
            }
        }
        Method method = f103g;
        if (method != null) {
            try {
                method.invoke(null, new Object[]{activity});
            } catch (IllegalAccessException e2) {
                MoPubLog.log(SdkLogEvent.ERROR, str, e2);
            } catch (InvocationTargetException e3) {
                MoPubLog.log(SdkLogEvent.ERROR, str, e3);
            }
        }
    }
}
