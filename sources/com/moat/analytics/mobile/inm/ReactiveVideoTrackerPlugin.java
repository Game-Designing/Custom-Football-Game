package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.inm.p227a.p229b.C10932a;
import java.util.Map;

public class ReactiveVideoTrackerPlugin implements MoatPlugin<ReactiveVideoTracker> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f33411a;

    /* renamed from: com.moat.analytics.mobile.inm.ReactiveVideoTrackerPlugin$a */
    static class C10928a implements ReactiveVideoTracker {
        C10928a() {
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

        public boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
            return false;
        }
    }

    public ReactiveVideoTrackerPlugin(String str) {
        this.f33411a = str;
    }

    /* renamed from: c */
    public ReactiveVideoTracker mo35833a() {
        return (ReactiveVideoTracker) C10994x.m36172a((C10996a<T>) new C10996a<ReactiveVideoTracker>() {
            /* renamed from: a */
            public C10932a<ReactiveVideoTracker> mo35863a() {
                C10969p.m36116a("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return C10932a.m35954a(new C10998y(ReactiveVideoTrackerPlugin.this.f33411a));
            }
        }, ReactiveVideoTracker.class);
    }

    /* renamed from: d */
    public ReactiveVideoTracker mo35834b() {
        return new C10928a();
    }
}
