package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.VastVideoConfig;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import p005cm.aptoide.p006pt.BuildConfig;

public class ExternalViewabilitySessionManager {

    /* renamed from: a */
    private final Set<ExternalViewabilitySession> f34322a = new HashSet();

    public enum ViewabilityVendor {
        AVID,
        MOAT,
        ALL;

        public void disable() {
            int i = C11254n.f34428a[ordinal()];
            if (i == 1) {
                C11242c.m37061a();
            } else if (i == 2) {
                C11292w.m37200a();
            } else if (i != 3) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Attempted to disable an invalid viewability vendor: ");
                sb.append(this);
                MoPubLog.log(sdkLogEvent, sb.toString());
                return;
            } else {
                C11242c.m37061a();
                C11292w.m37200a();
            }
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Disabled viewability for ");
            sb2.append(this);
            MoPubLog.log(sdkLogEvent2, sb2.toString());
        }

        public static String getEnabledVendorKey() {
            boolean avidEnabled = C11242c.m37064b();
            boolean moatEnabled = C11292w.m37203b();
            String vendorKey = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
            if (avidEnabled && moatEnabled) {
                return "3";
            }
            if (avidEnabled) {
                return "1";
            }
            if (moatEnabled) {
                return "2";
            }
            return vendorKey;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.mopub.common.ExternalViewabilitySessionManager.ViewabilityVendor fromKey(java.lang.String r3) {
            /*
                com.mopub.common.Preconditions.checkNotNull(r3)
                int r0 = r3.hashCode()
                r1 = 2
                r2 = 1
                switch(r0) {
                    case 49: goto L_0x0021;
                    case 50: goto L_0x0017;
                    case 51: goto L_0x000d;
                    default: goto L_0x000c;
                }
            L_0x000c:
                goto L_0x002b
            L_0x000d:
                java.lang.String r0 = "3"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L_0x000c
                r0 = 2
                goto L_0x002c
            L_0x0017:
                java.lang.String r0 = "2"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L_0x000c
                r0 = 1
                goto L_0x002c
            L_0x0021:
                java.lang.String r0 = "1"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L_0x000c
                r0 = 0
                goto L_0x002c
            L_0x002b:
                r0 = -1
            L_0x002c:
                if (r0 == 0) goto L_0x003a
                if (r0 == r2) goto L_0x0037
                if (r0 == r1) goto L_0x0034
                r0 = 0
                return r0
            L_0x0034:
                com.mopub.common.ExternalViewabilitySessionManager$ViewabilityVendor r0 = ALL
                return r0
            L_0x0037:
                com.mopub.common.ExternalViewabilitySessionManager$ViewabilityVendor r0 = MOAT
                return r0
            L_0x003a:
                com.mopub.common.ExternalViewabilitySessionManager$ViewabilityVendor r0 = AVID
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.ExternalViewabilitySessionManager.ViewabilityVendor.fromKey(java.lang.String):com.mopub.common.ExternalViewabilitySessionManager$ViewabilityVendor");
        }
    }

    public ExternalViewabilitySessionManager(Context context) {
        Preconditions.checkNotNull(context);
        this.f34322a.add(new C11242c());
        this.f34322a.add(new C11292w());
        m37006a(context);
    }

    /* renamed from: a */
    private void m37006a(Context context) {
        Preconditions.checkNotNull(context);
        for (ExternalViewabilitySession session : this.f34322a) {
            m37007a(session, "initialize", session.initialize(context), false);
        }
    }

    public void invalidate() {
        for (ExternalViewabilitySession session : this.f34322a) {
            m37007a(session, "invalidate", session.invalidate(), false);
        }
    }

    public void createDisplaySession(Context context, WebView webView, boolean isDeferred) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(webView);
        for (ExternalViewabilitySession session : this.f34322a) {
            m37007a(session, "start display session", session.createDisplaySession(context, webView, isDeferred), true);
        }
    }

    public void createDisplaySession(Context context, WebView webview) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(webview);
        createDisplaySession(context, webview, false);
    }

    public void startDeferredDisplaySession(Activity activity) {
        for (ExternalViewabilitySession session : this.f34322a) {
            m37007a(session, "record deferred session", session.startDeferredDisplaySession(activity), true);
        }
    }

    public void endDisplaySession() {
        for (ExternalViewabilitySession session : this.f34322a) {
            m37007a(session, "end display session", session.endDisplaySession(), true);
        }
    }

    public void createVideoSession(Activity activity, View view, VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(vastVideoConfig);
        for (ExternalViewabilitySession session : this.f34322a) {
            Set<String> buyerResources = new HashSet<>();
            if (session instanceof C11242c) {
                buyerResources.addAll(vastVideoConfig.getAvidJavascriptResources());
            } else if (session instanceof C11292w) {
                buyerResources.addAll(vastVideoConfig.getMoatImpressionPixels());
            }
            m37007a(session, "start video session", session.createVideoSession(activity, view, buyerResources, vastVideoConfig.getExternalViewabilityTrackers()), true);
        }
    }

    public void registerVideoObstruction(View view) {
        Preconditions.checkNotNull(view);
        for (ExternalViewabilitySession session : this.f34322a) {
            m37007a(session, "register friendly obstruction", session.registerVideoObstruction(view), true);
        }
    }

    public void onVideoPrepared(View playerView, int duration) {
        Preconditions.checkNotNull(playerView);
        for (ExternalViewabilitySession session : this.f34322a) {
            m37007a(session, "on video prepared", session.onVideoPrepared(playerView, duration), true);
        }
    }

    public void recordVideoEvent(VideoEvent event, int playheadMillis) {
        Preconditions.checkNotNull(event);
        for (ExternalViewabilitySession session : this.f34322a) {
            Boolean successful = session.recordVideoEvent(event, playheadMillis);
            StringBuilder sb = new StringBuilder();
            sb.append("record video event (");
            sb.append(event.name());
            sb.append(")");
            m37007a(session, sb.toString(), successful, true);
        }
    }

    public void endVideoSession() {
        for (ExternalViewabilitySession session : this.f34322a) {
            m37007a(session, "end video session", session.endVideoSession(), true);
        }
    }

    /* renamed from: a */
    private void m37007a(ExternalViewabilitySession session, String event, Boolean successful, boolean isVerbose) {
        Preconditions.checkNotNull(session);
        Preconditions.checkNotNull(event);
        if (successful != null) {
            String message = String.format(Locale.US, "%s viewability event: %s%s.", new Object[]{session.getName(), successful.booleanValue() ? "" : "failed to ", event});
            if (isVerbose) {
                MoPubLog.log(SdkLogEvent.CUSTOM, message);
            }
        }
    }
}
