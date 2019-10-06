package com.moat.analytics.mobile.sma;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.sma.NativeDisplayTracker.MoatUserInteractionType;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.sma.v */
abstract class C11118v {

    /* renamed from: com.moat.analytics.mobile.sma.v$a */
    public static class C11119a extends MoatAnalytics {
        public void prepareNativeDisplayTracking(String str) {
        }

        public void start(Application application) {
        }

        public void start(MoatOptions moatOptions, Application application) {
        }
    }

    /* renamed from: com.moat.analytics.mobile.sma.v$b */
    public static class C11120b extends MoatFactory {
        public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
            return moatPlugin.mo36145b();
        }

        public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
            return new C11121c();
        }

        public NativeVideoTracker createNativeVideoTracker(String str) {
            return new C11122d();
        }

        public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
            return new C11123e();
        }

        public WebAdTracker createWebAdTracker(WebView webView) {
            return new C11123e();
        }
    }

    /* renamed from: com.moat.analytics.mobile.sma.v$c */
    static class C11121c implements NativeDisplayTracker {
        C11121c() {
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

    /* renamed from: com.moat.analytics.mobile.sma.v$d */
    static class C11122d implements NativeVideoTracker {
        C11122d() {
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

    /* renamed from: com.moat.analytics.mobile.sma.v$e */
    static class C11123e implements WebAdTracker {
        C11123e() {
        }

        public void setActivity(Activity activity) {
        }

        public void startTracking() {
        }

        public void stopTracking() {
        }
    }

    C11118v() {
    }
}
