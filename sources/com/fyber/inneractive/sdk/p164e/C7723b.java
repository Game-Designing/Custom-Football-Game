package com.fyber.inneractive.sdk.p164e;

import android.view.View;
import com.google.android.exoplayer.ExoPlayer;
import com.moat.analytics.mobile.ina.ExoMoatPlugin;
import com.moat.analytics.mobile.ina.ExoVideoTracker;
import com.moat.analytics.mobile.ina.MoatFactory;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.e.b */
final class C7723b extends C7725d<ExoPlayer> {

    /* renamed from: a */
    private final ExoVideoTracker f15385a;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ boolean mo24242a(Map map, Object obj, View view) {
        return this.f15385a.trackVideoAd(map, (ExoPlayer) obj, view);
    }

    /* renamed from: a */
    static boolean m17112a(Object obj) {
        boolean z;
        try {
            Class.forName("com.google.android.exoplayer.ExoPlayer");
            z = true;
        } catch (Exception e) {
            z = false;
        }
        if (!z) {
            return false;
        }
        return obj instanceof ExoPlayer;
    }

    C7723b(MoatFactory moatFactory, String str) {
        this.f15385a = (ExoVideoTracker) moatFactory.createCustomTracker(new ExoMoatPlugin(str));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24241a(Double d) {
        this.f15385a.setPlayerVolume(d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24240a(View view) {
        this.f15385a.changeTargetView(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24239a() {
        this.f15385a.stopTracking();
    }
}
