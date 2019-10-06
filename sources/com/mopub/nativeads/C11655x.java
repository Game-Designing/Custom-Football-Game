package com.mopub.nativeads;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mopub.mobileads.MoPubErrorCode;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.x */
/* compiled from: InneractiveBannerCustomEvent */
class C11655x implements RequestListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36259a;

    /* renamed from: b */
    final /* synthetic */ Context f36260b;

    /* renamed from: c */
    final /* synthetic */ InneractiveBannerCustomEvent f36261c;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38480a() {
        boolean[] zArr = f36259a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7459330481362211743L, "com/mopub/nativeads/InneractiveBannerCustomEvent$1", 17);
        f36259a = probes;
        return probes;
    }

    C11655x(InneractiveBannerCustomEvent this$0, Context context) {
        boolean[] a = m38480a();
        this.f36261c = this$0;
        this.f36260b = context;
        a[0] = true;
    }

    public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot adSpot) {
        boolean[] a = m38480a();
        InneractiveAdSpot inneractiveAdSpot = this.f36261c.f35748d;
        String str = InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG;
        if (adSpot != inneractiveAdSpot) {
            a[1] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Wrong Banner Spot: Received - ");
            sb.append(adSpot);
            sb.append(", Actual - ");
            sb.append(this.f36261c.f35748d);
            Log.d(str, sb.toString());
            a[2] = true;
            return;
        }
        ViewGroup layout = new RelativeLayout(this.f36260b);
        InneractiveAdSpot inneractiveAdSpot2 = this.f36261c.f35748d;
        a[3] = true;
        InneractiveAdViewUnitController controller = (InneractiveAdViewUnitController) inneractiveAdSpot2.getSelectedUnitController();
        a[4] = true;
        controller.setEventsListener(new C11652w(this));
        a[5] = true;
        Log.d(str, "IABannerForMopub - inneractiveBannerLoaded");
        a[6] = true;
        controller.bindView(layout);
        a[7] = true;
        this.f36261c.f35747c.onBannerLoaded(layout);
        a[8] = true;
    }

    public void onInneractiveFailedAdRequest(InneractiveAdSpot adSpot, InneractiveErrorCode errorCode) {
        boolean[] a = m38480a();
        StringBuilder sb = new StringBuilder();
        sb.append("IABannerForMopub - inneractiveBannerFailed with Error: ");
        sb.append(errorCode);
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, sb.toString());
        if (errorCode == InneractiveErrorCode.CONNECTION_ERROR) {
            a[9] = true;
            this.f36261c.f35747c.onBannerFailed(MoPubErrorCode.NO_CONNECTION);
            a[10] = true;
        } else if (errorCode == InneractiveErrorCode.CONNECTION_TIMEOUT) {
            a[11] = true;
            this.f36261c.f35747c.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
            a[12] = true;
        } else if (errorCode == InneractiveErrorCode.NO_FILL) {
            a[13] = true;
            this.f36261c.f35747c.onBannerFailed(MoPubErrorCode.NO_FILL);
            a[14] = true;
        } else {
            this.f36261c.f35747c.onBannerFailed(MoPubErrorCode.SERVER_ERROR);
            a[15] = true;
        }
        a[16] = true;
    }
}
