package com.moat.analytics.mobile.sma;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.sma.p230a.p232b.C11076a;
import java.util.Map;

public class ReactiveVideoTrackerPlugin implements MoatPlugin<ReactiveVideoTracker> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f33847a;

    /* renamed from: com.moat.analytics.mobile.sma.ReactiveVideoTrackerPlugin$a */
    static class C11072a implements ReactiveVideoTracker {
        C11072a() {
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
        this.f33847a = str;
    }

    /* renamed from: c */
    public ReactiveVideoTracker mo36144a() {
        return (ReactiveVideoTracker) C11134x.m36626a((C11136a<T>) new C11136a<ReactiveVideoTracker>() {
            /* renamed from: a */
            public C11076a<ReactiveVideoTracker> mo36164a() {
                C11111p.m36579a("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return C11076a.m36442a(new C11138y(ReactiveVideoTrackerPlugin.this.f33847a));
            }
        }, ReactiveVideoTracker.class);
    }

    /* renamed from: d */
    public ReactiveVideoTracker mo36145b() {
        return new C11072a();
    }
}
