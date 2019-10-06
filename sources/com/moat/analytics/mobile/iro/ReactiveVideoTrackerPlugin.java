package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import java.util.Map;

public class ReactiveVideoTrackerPlugin implements C11037m<ReactiveVideoTracker> {
    /* access modifiers changed from: private */

    /* renamed from: ˋ */
    public final String f33629;

    /* renamed from: com.moat.analytics.mobile.iro.ReactiveVideoTrackerPlugin$b */
    static class C11008b implements ReactiveVideoTracker {
        C11008b() {
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

        public final boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
            return false;
        }

        public final void setPlayerVolume(Double d) {
        }

        public final void changeTargetView(View view) {
        }

        public final void dispatchEvent(MoatAdEvent moatAdEvent) {
        }

        public final void stopTracking() {
        }
    }

    public ReactiveVideoTrackerPlugin(String str) {
        this.f33629 = str;
    }

    public ReactiveVideoTracker create() throws C11043o {
        return (ReactiveVideoTracker) C11050s.m36379(new C11052a<ReactiveVideoTracker>() {
            /* renamed from: ˏ */
            public final Optional<ReactiveVideoTracker> mo36029() {
                C11011b.m36232("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return Optional.m36239of(new C11065w(ReactiveVideoTrackerPlugin.this.f33629));
            }
        }, ReactiveVideoTracker.class);
    }

    public ReactiveVideoTracker createNoOp() {
        return new C11008b();
    }
}
