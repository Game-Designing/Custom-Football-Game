package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mopub.common.c */
/* compiled from: AvidViewabilitySession */
class C11242c implements ExternalViewabilitySession {

    /* renamed from: a */
    private static Object f34391a;

    /* renamed from: b */
    private static Object f34392b;

    /* renamed from: c */
    private static Boolean f34393c;

    /* renamed from: d */
    private static boolean f34394d;

    /* renamed from: e */
    private Object f34395e;

    /* renamed from: f */
    private Object f34396f;

    C11242c() {
    }

    /* renamed from: b */
    static boolean m37064b() {
        return !f34394d && m37067e();
    }

    /* renamed from: a */
    static void m37061a() {
        f34394d = true;
    }

    /* renamed from: e */
    private static boolean m37067e() {
        if (f34393c == null) {
            f34393c = Boolean.valueOf(Reflection.classFound("com.integralads.avid.library.mopub.session.AvidAdSessionManager"));
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("Avid is ");
            sb.append(f34393c.booleanValue() ? "" : "un");
            sb.append("available via reflection.");
            objArr[0] = sb.toString();
            MoPubLog.log(sdkLogEvent, objArr);
        }
        return f34393c.booleanValue();
    }

    /* renamed from: c */
    private static Object m37065c() {
        if (f34391a == null) {
            try {
                f34391a = Reflection.instantiateClassWithConstructor("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", Object.class, new Class[]{String.class, Boolean.TYPE}, new Object[]{"5.7.1", Boolean.valueOf(true)});
            } catch (Exception e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to generate Avid deferred ad session context: ");
                sb.append(e.getMessage());
                MoPubLog.log(sdkLogEvent, sb.toString());
            }
        }
        return f34391a;
    }

    /* renamed from: d */
    private static Object m37066d() {
        if (f34392b == null) {
            try {
                f34392b = Reflection.instantiateClassWithConstructor("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", Object.class, new Class[]{String.class}, new Object[]{"5.7.1"});
            } catch (Exception e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to generate Avid ad session context: ");
                sb.append(e.getMessage());
                MoPubLog.log(sdkLogEvent, sb.toString());
            }
        }
        return f34392b;
    }

    public String getName() {
        return VastExtensionXmlManager.AVID;
    }

    public Boolean initialize(Context context) {
        Preconditions.checkNotNull(context);
        if (!m37064b()) {
            return null;
        }
        return Boolean.valueOf(true);
    }

    public Boolean invalidate() {
        if (!m37064b()) {
            return null;
        }
        this.f34395e = null;
        this.f34396f = null;
        return Boolean.valueOf(true);
    }

    public Boolean createDisplaySession(Context context, WebView webView, boolean isDeferred) {
        Object avidAdSessionContext;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(webView);
        if (!m37064b()) {
            return null;
        }
        if (isDeferred) {
            avidAdSessionContext = m37065c();
        } else {
            avidAdSessionContext = m37066d();
        }
        Object obj = context instanceof Activity ? (Activity) context : null;
        try {
            this.f34395e = new MethodBuilder(null, "startAvidDisplayAdSession").setStatic("com.integralads.avid.library.mopub.session.AvidAdSessionManager").addParam(Context.class, context).addParam("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", avidAdSessionContext).execute();
            new MethodBuilder(this.f34395e, "registerAdView").addParam(View.class, webView).addParam(Activity.class, obj).execute();
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to execute Avid start display session: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean startDeferredDisplaySession(Activity activity) {
        if (!m37064b()) {
            return null;
        }
        if (this.f34395e == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Avid DisplayAdSession unexpectedly null.");
            return Boolean.valueOf(false);
        }
        try {
            new MethodBuilder(new MethodBuilder(null, "getInstance").setStatic("com.integralads.avid.library.mopub.AvidManager").execute(), "registerActivity").addParam(Activity.class, activity).execute();
            Object deferredAdSessionListener = new MethodBuilder(this.f34395e, "getAvidDeferredAdSessionListener").execute();
            if (deferredAdSessionListener == null) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Avid AdSessionListener unexpectedly null.");
                return Boolean.valueOf(false);
            }
            new MethodBuilder(deferredAdSessionListener, "recordReadyEvent").execute();
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to execute Avid record deferred session: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean endDisplaySession() {
        if (!m37064b()) {
            return null;
        }
        Object obj = this.f34395e;
        if (obj == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Avid DisplayAdSession unexpectedly null.");
            return Boolean.valueOf(false);
        }
        try {
            new MethodBuilder(obj, "endSession").execute();
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to execute Avid end session: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean createVideoSession(Activity activity, View view, Set<String> buyerResources, Map<String, String> videoViewabilityTrackers) {
        String str = "avid";
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(buyerResources);
        Preconditions.checkNotNull(videoViewabilityTrackers);
        if (!m37064b()) {
            return null;
        }
        try {
            this.f34396f = new MethodBuilder(null, "startAvidManagedVideoAdSession").setStatic("com.integralads.avid.library.mopub.session.AvidAdSessionManager").addParam(Context.class, activity).addParam("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", m37066d()).execute();
            new MethodBuilder(this.f34396f, "registerAdView").addParam(View.class, view).addParam(Activity.class, activity).execute();
            String str2 = "injectJavaScriptResource";
            if (!TextUtils.isEmpty((CharSequence) videoViewabilityTrackers.get(str))) {
                new MethodBuilder(this.f34396f, str2).addParam(String.class, videoViewabilityTrackers.get(str)).execute();
            }
            for (String buyerResource : buyerResources) {
                if (!TextUtils.isEmpty(buyerResource)) {
                    new MethodBuilder(this.f34396f, str2).addParam(String.class, buyerResource).execute();
                }
            }
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to execute Avid start video session: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean registerVideoObstruction(View view) {
        Preconditions.checkNotNull(view);
        if (!m37064b()) {
            return null;
        }
        Object obj = this.f34396f;
        if (obj == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Avid VideoAdSession unexpectedly null.");
            return Boolean.valueOf(false);
        }
        try {
            new MethodBuilder(obj, "registerFriendlyObstruction").addParam(View.class, view).execute();
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to register Avid video obstructions: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean onVideoPrepared(View playerView, int duration) {
        Preconditions.checkNotNull(playerView);
        if (!m37064b()) {
            return null;
        }
        return Boolean.valueOf(true);
    }

    public Boolean recordVideoEvent(VideoEvent event, int playheadMillis) {
        Preconditions.checkNotNull(event);
        if (!m37064b()) {
            return null;
        }
        if (this.f34396f == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Avid VideoAdSession unexpectedly null.");
            return Boolean.valueOf(false);
        }
        try {
            switch (C11241b.f34390a[event.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    m37062a(event);
                    return Boolean.valueOf(true);
                case 13:
                    m37063a(event, "error");
                    return Boolean.valueOf(true);
                default:
                    SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected video event type: ");
                    sb.append(event);
                    MoPubLog.log(sdkLogEvent, sb.toString());
                    return Boolean.valueOf(false);
            }
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to execute Avid video event for ");
            sb2.append(event.getAvidMethodName());
            sb2.append(": ");
            sb2.append(e.getMessage());
            MoPubLog.log(sdkLogEvent2, sb2.toString());
            return Boolean.valueOf(false);
        }
    }

    public Boolean endVideoSession() {
        if (!m37064b()) {
            return null;
        }
        Object obj = this.f34396f;
        if (obj == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Avid VideoAdSession unexpectedly null.");
            return Boolean.valueOf(false);
        }
        try {
            new MethodBuilder(obj, "endSession").execute();
            return Boolean.valueOf(true);
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to execute Avid end video session: ");
            sb.append(e.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return Boolean.valueOf(false);
        }
    }

    /* renamed from: a */
    private void m37062a(VideoEvent videoEvent) throws Exception {
        m37063a(videoEvent, null);
    }

    /* renamed from: a */
    private void m37063a(VideoEvent videoEvent, String message) throws Exception {
        MethodBuilder methodBuilder = new MethodBuilder(new MethodBuilder(this.f34396f, "getAvidVideoPlaybackListener").execute(), videoEvent.getAvidMethodName());
        if (!TextUtils.isEmpty(message)) {
            methodBuilder.addParam(String.class, message);
        }
        methodBuilder.execute();
    }
}
