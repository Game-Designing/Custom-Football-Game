package com.mopub.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mopub.common.w */
/* compiled from: MoatViewabilitySession */
class C11292w implements ExternalViewabilitySession {

    /* renamed from: a */
    private static Boolean f34616a;

    /* renamed from: b */
    private static boolean f34617b;

    /* renamed from: c */
    private static boolean f34618c = false;

    /* renamed from: d */
    private static final Map<String, String> f34619d = new HashMap();

    /* renamed from: e */
    private Object f34620e;

    /* renamed from: f */
    private Object f34621f;

    /* renamed from: g */
    private Map<String, String> f34622g = new HashMap();

    /* renamed from: h */
    private boolean f34623h;

    C11292w() {
    }

    static {
        f34619d.put("moatClientLevel1", "level1");
        f34619d.put("moatClientLevel2", "level2");
        f34619d.put("moatClientLevel3", "level3");
        f34619d.put("moatClientLevel4", "level4");
        f34619d.put("moatClientSlicer1", "slicer1");
        f34619d.put("moatClientSlicer2", "slicer2");
    }

    /* renamed from: b */
    static boolean m37203b() {
        return !f34617b && m37204c();
    }

    /* renamed from: a */
    static void m37200a() {
        f34617b = true;
    }

    /* renamed from: c */
    private static boolean m37204c() {
        if (f34616a == null) {
            f34616a = Boolean.valueOf(Reflection.classFound("com.moat.analytics.mobile.mpub.MoatFactory"));
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("Moat is ");
            sb.append(f34616a.booleanValue() ? "" : "un");
            sb.append("available via reflection.");
            objArr[0] = sb.toString();
            MoPubLog.log(sdkLogEvent, objArr);
        }
        return f34616a.booleanValue();
    }

    public String getName() {
        return VastExtensionXmlManager.MOAT;
    }

    public Boolean initialize(Context context) {
        Application application;
        String str = "com.moat.analytics.mobile.mpub.MoatOptions";
        Preconditions.checkNotNull(context);
        if (!m37203b()) {
            return null;
        }
        if (f34618c) {
            return Boolean.valueOf(true);
        }
        if (context instanceof Activity) {
            application = ((Activity) context).getApplication();
        } else {
            try {
                application = (Application) context.getApplicationContext();
            } catch (ClassCastException e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to initialize Moat, error obtaining application context.");
                return Boolean.valueOf(false);
            }
        }
        try {
            Object moatOptions = Reflection.instantiateClassWithEmptyConstructor(str, Object.class);
            moatOptions.getClass().getField("disableAdIdCollection").setBoolean(moatOptions, true);
            moatOptions.getClass().getField("disableLocationServices").setBoolean(moatOptions, true);
            new MethodBuilder(new MethodBuilder(null, "getInstance").setStatic("com.moat.analytics.mobile.mpub.MoatAnalytics").execute(), "start").addParam(str, moatOptions).addParam(Application.class, application).execute();
            f34618c = true;
            return Boolean.valueOf(true);
        } catch (Exception e2) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to initialize Moat: ");
            sb.append(e2.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean invalidate() {
        if (!m37203b()) {
            return null;
        }
        this.f34620e = null;
        this.f34621f = null;
        this.f34622g.clear();
        return Boolean.valueOf(true);
    }

    public Boolean createDisplaySession(Context context, WebView webView, boolean isDeferred) {
        Preconditions.checkNotNull(context);
        if (!m37203b()) {
            return null;
        }
        try {
            this.f34620e = new MethodBuilder(new MethodBuilder(null, "create").setStatic("com.moat.analytics.mobile.mpub.MoatFactory").execute(), "createWebAdTracker").addParam(WebView.class, webView).execute();
            if (!isDeferred) {
                new MethodBuilder(this.f34620e, "startTracking").execute();
            }
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to execute Moat start display session: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean startDeferredDisplaySession(Activity activity) {
        if (!m37203b()) {
            return null;
        }
        Object obj = this.f34620e;
        if (obj == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "MoatWebAdTracker unexpectedly null.");
            return Boolean.valueOf(false);
        }
        try {
            new MethodBuilder(obj, "startTracking").execute();
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to record deferred display session for Moat: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean endDisplaySession() {
        if (!m37203b()) {
            return null;
        }
        Object obj = this.f34620e;
        if (obj == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Moat WebAdTracker unexpectedly null.");
            return Boolean.valueOf(false);
        }
        try {
            new MethodBuilder(obj, "stopTracking").execute();
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to execute Moat end session: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean createVideoSession(Activity activity, View view, Set<String> buyerResources, Map<String, String> videoViewabilityTrackers) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(buyerResources);
        Preconditions.checkNotNull(videoViewabilityTrackers);
        if (!m37203b()) {
            return null;
        }
        m37201a((String) videoViewabilityTrackers.get("moat"), buyerResources);
        String partnerCode = (String) this.f34622g.get("partnerCode");
        if (TextUtils.isEmpty(partnerCode)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "partnerCode was empty when starting Moat video session");
            return Boolean.valueOf(false);
        }
        try {
            this.f34621f = new MethodBuilder(new MethodBuilder(null, "create").setStatic("com.moat.analytics.mobile.mpub.MoatFactory").execute(), "createCustomTracker").addParam("com.moat.analytics.mobile.mpub.MoatPlugin", Reflection.instantiateClassWithConstructor("com.moat.analytics.mobile.mpub.ReactiveVideoTrackerPlugin", Object.class, new Class[]{String.class}, new Object[]{partnerCode})).execute();
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to execute Moat start video session: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean registerVideoObstruction(View view) {
        Preconditions.checkNotNull(view);
        if (!m37203b()) {
            return null;
        }
        return Boolean.valueOf(true);
    }

    public Boolean onVideoPrepared(View playerView, int duration) {
        Preconditions.checkNotNull(playerView);
        if (!m37203b()) {
            return null;
        }
        Object obj = this.f34621f;
        if (obj == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Moat VideoAdTracker unexpectedly null.");
            return Boolean.valueOf(false);
        } else if (this.f34623h) {
            return Boolean.valueOf(false);
        } else {
            try {
                new MethodBuilder(obj, "trackVideoAd").addParam(Map.class, this.f34622g).addParam(Integer.class, Integer.valueOf(duration)).addParam(View.class, playerView).execute();
                this.f34623h = true;
                return Boolean.valueOf(true);
            } catch (Exception e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to execute Moat onVideoPrepared: ");
                sb.append(e.getMessage());
                MoPubLog.log(sdkLogEvent, sb.toString());
                return Boolean.valueOf(false);
            }
        }
    }

    public Boolean recordVideoEvent(VideoEvent event, int playheadMillis) {
        Preconditions.checkNotNull(event);
        if (!m37203b()) {
            return null;
        }
        if (this.f34621f == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Moat VideoAdTracker unexpectedly null.");
            return Boolean.valueOf(false);
        }
        try {
            switch (C11291v.f34615a[event.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    m37202a(event, playheadMillis);
                    return Boolean.valueOf(true);
                case 10:
                case 11:
                case 12:
                case 13:
                    return null;
                default:
                    SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected video event: ");
                    sb.append(event.getMoatEnumName());
                    MoPubLog.log(sdkLogEvent, sb.toString());
                    return Boolean.valueOf(false);
            }
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Video event ");
            sb2.append(event.getMoatEnumName());
            sb2.append(" failed. ");
            sb2.append(e.getMessage());
            MoPubLog.log(sdkLogEvent2, sb2.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean endVideoSession() {
        if (!m37203b()) {
            return null;
        }
        Object obj = this.f34621f;
        if (obj == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Moat VideoAdTracker unexpectedly null.");
            return Boolean.valueOf(false);
        }
        try {
            new MethodBuilder(obj, "stopTracking").execute();
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to execute Moat end video session: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    /* renamed from: a */
    private void m37201a(String urlString, Set<String> buyerResources) {
        this.f34622g.clear();
        String str = "partnerCode";
        this.f34622g.put(str, "mopubinapphtmvideo468906546585");
        this.f34622g.put("zMoatVASTIDs", TextUtils.join(";", buyerResources));
        if (!TextUtils.isEmpty(urlString)) {
            Uri uri = Uri.parse(urlString);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() > 0 && !TextUtils.isEmpty((CharSequence) pathSegments.get(0))) {
                this.f34622g.put(str, pathSegments.get(0));
            }
            String fragment = uri.getFragment();
            if (!TextUtils.isEmpty(fragment)) {
                for (String fragmentPairs : fragment.split("&")) {
                    String[] fragmentPair = fragmentPairs.split("=");
                    if (fragmentPair.length >= 2) {
                        String fragmentKey = fragmentPair[0];
                        String fragmentValue = fragmentPair[1];
                        if (!TextUtils.isEmpty(fragmentKey) && !TextUtils.isEmpty(fragmentValue) && f34619d.containsKey(fragmentKey)) {
                            this.f34622g.put(f34619d.get(fragmentKey), fragmentValue);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m37202a(VideoEvent videoEvent, int playheadMillis) throws Exception {
        if (videoEvent.getMoatEnumName() == null) {
            return false;
        }
        Class<?> clazz = Class.forName("com.moat.analytics.mobile.mpub.MoatAdEventType");
        String str = "com.moat.analytics.mobile.mpub.MoatAdEvent";
        new MethodBuilder(this.f34621f, "dispatchEvent").addParam(str, Reflection.instantiateClassWithConstructor(str, Object.class, new Class[]{clazz, Integer.class}, new Object[]{Enum.valueOf(clazz.asSubclass(Enum.class), videoEvent.getMoatEnumName()), Integer.valueOf(playheadMillis)})).execute();
        return true;
    }
}
