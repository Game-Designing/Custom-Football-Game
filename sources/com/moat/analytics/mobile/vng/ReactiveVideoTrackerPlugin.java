package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.vng.p233a.p235b.C11147a;
import java.util.Map;

public class ReactiveVideoTrackerPlugin implements MoatPlugin<ReactiveVideoTracker> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f34031a;

    /* renamed from: com.moat.analytics.mobile.vng.ReactiveVideoTrackerPlugin$a */
    static class C11143a implements ReactiveVideoTracker {
        C11143a() {
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

        public boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
            return false;
        }
    }

    public ReactiveVideoTrackerPlugin(String str) {
        this.f34031a = str;
    }

    /* renamed from: c */
    public ReactiveVideoTracker mo36274a() {
        return (ReactiveVideoTracker) C11208x.m36866a((C11210a<T>) new C11210a<ReactiveVideoTracker>() {
            /* renamed from: a */
            public C11147a<ReactiveVideoTracker> mo36294a() {
                C11185p.m36819a("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return C11147a.m36683a(new C11212y(ReactiveVideoTrackerPlugin.this.f34031a));
            }
        }, ReactiveVideoTracker.class);
    }

    /* renamed from: d */
    public ReactiveVideoTracker mo36275b() {
        return new C11143a();
    }
}
