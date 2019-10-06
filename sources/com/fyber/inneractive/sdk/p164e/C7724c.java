package com.fyber.inneractive.sdk.p164e;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.ina.MoatAdEvent;
import com.moat.analytics.mobile.ina.MoatFactory;
import com.moat.analytics.mobile.ina.NativeVideoTracker;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.e.c */
final class C7724c extends C7725d<MediaPlayer> {

    /* renamed from: a */
    private final NativeVideoTracker f15386a;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ boolean mo24242a(Map map, Object obj, View view) {
        return this.f15386a.trackVideoAd(map, (MediaPlayer) obj, view);
    }

    C7724c(MoatFactory moatFactory, String str) {
        this.f15386a = moatFactory.createNativeVideoTracker(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24241a(Double d) {
        this.f15386a.setPlayerVolume(d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24240a(View view) {
        this.f15386a.changeTargetView(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24239a() {
        this.f15386a.stopTracking();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24243a(MoatAdEvent moatAdEvent) {
        this.f15386a.dispatchEvent(moatAdEvent);
    }
}
