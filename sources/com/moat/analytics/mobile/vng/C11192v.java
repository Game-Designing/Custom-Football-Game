package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.vng.NativeDisplayTracker.MoatUserInteractionType;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.vng.v */
abstract class C11192v {

    /* renamed from: com.moat.analytics.mobile.vng.v$a */
    public static class C11193a extends MoatAnalytics {
        public void prepareNativeDisplayTracking(String str) {
        }

        public void start(Application application) {
        }

        public void start(MoatOptions moatOptions, Application application) {
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.v$b */
    public static class C11194b extends MoatFactory {
        public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
            return null;
        }

        public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
            return new C11195c();
        }

        public NativeVideoTracker createNativeVideoTracker(String str) {
            return new C11196d();
        }

        public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
            return new C11197e();
        }

        public WebAdTracker createWebAdTracker(WebView webView) {
            return new C11197e();
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.v$c */
    static class C11195c implements NativeDisplayTracker {
        C11195c() {
        }

        public void reportUserInteractionEvent(MoatUserInteractionType moatUserInteractionType) {
        }

        public void setActivity(Activity activity) {
        }

        public void startTracking() {
        }

        public void stopTracking() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.v$d */
    static class C11196d implements NativeVideoTracker {
        C11196d() {
        }

        public void changeTargetView(View view) {
        }

        public void dispatchEvent(MoatAdEvent moatAdEvent) {
        }

        public void setActivity(Activity activity) {
        }

        public void setPlayerVolume(Double d) {
        }

        public void stopTracking() {
        }

        public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
            return false;
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.v$e */
    static class C11197e implements WebAdTracker {
        C11197e() {
        }

        public void setActivity(Activity activity) {
        }

        public void startTracking() {
        }

        public void stopTracking() {
        }
    }

    C11192v() {
    }
}
