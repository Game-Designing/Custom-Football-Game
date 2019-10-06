package com.fyber.inneractive.sdk.external;

import android.content.Context;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.FullScreenRendererProvider;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.OnInneractiveFullscreenAdDismissedListener;
import com.fyber.inneractive.sdk.config.C7704d;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.C7714l;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.p161c.C7677o;
import com.fyber.inneractive.sdk.p163d.C7719c;
import com.fyber.inneractive.sdk.util.IAlog;

public class InneractiveFullscreenUnitController extends C7677o<InneractiveFullscreenAdEventsListener> implements FullScreenRendererProvider, OnInneractiveFullscreenAdDismissedListener {

    /* renamed from: a */
    private boolean f15404a = false;
    protected C7719c mRenderer;

    public boolean supports(InneractiveAdSpot inneractiveAdSpot) {
        C7712j unitConfig = inneractiveAdSpot.getAdContent().getUnitConfig();
        if (unitConfig.mo24208d() != null) {
            return false;
        }
        C7704d g = unitConfig.mo24211g();
        if (g != null && UnitDisplayType.INTERSTITIAL.equals(g.mo24185a())) {
            return true;
        }
        C7714l f = unitConfig.mo24210f();
        if (f == null || (!UnitDisplayType.REWARDED.equals(f.mo24221h()) && !UnitDisplayType.INTERSTITIAL.equals(f.mo24221h()) && !UnitDisplayType.VERTICAL.equals(f.mo24221h()))) {
            return false;
        }
        return true;
    }

    public boolean supportsRefresh() {
        return false;
    }

    public C7719c getFullscreenRenderer() {
        return this.mRenderer;
    }

    public void show(Context context) {
        if (!this.f15404a) {
            InneractiveAdSpot adSpot = getAdSpot();
            if (adSpot == null) {
                IAlog.m18023d("InneractiveFullscreenUnitController was not attached to an ad spot");
                return;
            }
            if (this.mRenderer == null) {
                this.mRenderer = C7657b.f15187a.mo24086a(getAdSpot());
            }
            selectContentController();
            InneractiveFullscreenAdActivity.show(context, adSpot);
            this.f15404a = true;
            return;
        }
        IAlog.m18023d("InneractiveFullscreenUnitController->show(android.content.Context) called while an ad is already showing");
    }

    public void destroy() {
        C7719c cVar = this.mRenderer;
        if (cVar != null) {
            cVar.destroy();
            this.mRenderer = null;
        }
        super.destroy();
    }

    public void onAdDismissed(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.f15404a = false;
    }
}
