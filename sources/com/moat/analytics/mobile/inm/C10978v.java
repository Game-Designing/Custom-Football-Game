package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.inm.NativeDisplayTracker.MoatUserInteractionType;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.inm.v */
abstract class C10978v {

    /* renamed from: com.moat.analytics.mobile.inm.v$a */
    public static class C10979a extends MoatAnalytics {
        public void prepareNativeDisplayTracking(String str) {
        }

        public void start(Application application) {
        }

        public void start(MoatOptions moatOptions, Application application) {
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.v$b */
    public static class C10980b extends MoatFactory {
        public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
            return moatPlugin.mo35834b();
        }

        public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
            return new C10981c();
        }

        public NativeVideoTracker createNativeVideoTracker(String str) {
            return new C10982d();
        }

        public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
            return new C10983e();
        }

        public WebAdTracker createWebAdTracker(WebView webView) {
            return new C10983e();
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.v$c */
    static class C10981c implements NativeDisplayTracker {
        C10981c() {
        }

        public void removeListener() {
        }

        public void reportUserInteractionEvent(MoatUserInteractionType moatUserInteractionType) {
        }

        public void setActivity(Activity activity) {
        }

        public void setListener(TrackerListener trackerListener) {
        }

        public void startTracking() {
        }

        public void stopTracking() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.v$d */
    static class C10982d implements NativeVideoTracker {
        C10982d() {
        }

        public void changeTargetView(View view) {
        }

        public void dispatchEvent(MoatAdEvent moatAdEvent) {
        }

        public void removeListener() {
        }

        public void removeVideoListener() {
        }

        public void setActivity(Activity activity) {
        }

        public void setListener(TrackerListener trackerListener) {
        }

        public void setPlayerVolume(Double d) {
        }

        public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        }

        public void stopTracking() {
        }

        public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
            return false;
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.v$e */
    static class C10983e implements WebAdTracker {
        C10983e() {
        }

        public void removeListener() {
        }

        public void setActivity(Activity activity) {
        }

        public void setListener(TrackerListener trackerListener) {
        }

        public void startTracking() {
        }

        public void stopTracking() {
        }
    }

    C10978v() {
    }
}
