package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.NativeDisplayTracker.MoatUserInteractionType;
import java.util.Map;

abstract class NoOp {

    public static class MoatAnalytics extends MoatAnalytics {
        public void start(MoatOptions moatOptions, Application application) {
        }

        public void start(Application application) {
        }

        public void prepareNativeDisplayTracking(String str) {
        }
    }

    public static class MoatFactory extends MoatFactory {
        public WebAdTracker createWebAdTracker(WebView webView) {
            return new C11005b();
        }

        public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
            return new C11005b();
        }

        public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
            return new C11004a();
        }

        public NativeVideoTracker createNativeVideoTracker(String str) {
            return new C11006c();
        }

        public <T> T createCustomTracker(C11037m<T> mVar) {
            return mVar.createNoOp();
        }
    }

    /* renamed from: com.moat.analytics.mobile.iro.NoOp$a */
    static class C11004a implements NativeDisplayTracker {
        C11004a() {
        }

        public final void startTracking() {
        }

        public final void setListener(TrackerListener trackerListener) {
        }

        public final void removeListener() {
        }

        public final void setActivity(Activity activity) {
        }

        public final void stopTracking() {
        }

        public final void reportUserInteractionEvent(MoatUserInteractionType moatUserInteractionType) {
        }
    }

    /* renamed from: com.moat.analytics.mobile.iro.NoOp$b */
    static class C11005b implements WebAdTracker {
        C11005b() {
        }

        public final void startTracking() {
        }

        public final void setListener(TrackerListener trackerListener) {
        }

        public final void removeListener() {
        }

        public final void setActivity(Activity activity) {
        }

        public final void stopTracking() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.iro.NoOp$c */
    static class C11006c implements NativeVideoTracker {
        C11006c() {
        }

        public final void setActivity(Activity activity) {
        }

        public final void setListener(TrackerListener trackerListener) {
        }

        public final void removeListener() {
        }

        public final void setVideoListener(VideoTrackerListener videoTrackerListener) {
        }

        public final void removeVideoListener() {
        }

        public final void dispatchEvent(MoatAdEvent moatAdEvent) {
        }

        public final boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
            return false;
        }

        public final void setPlayerVolume(Double d) {
        }

        public final void changeTargetView(View view) {
        }

        public final void stopTracking() {
        }
    }

    NoOp() {
    }
}
