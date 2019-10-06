package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.p161c.C7678p;
import com.fyber.inneractive.sdk.p161c.C7679q;
import com.fyber.inneractive.sdk.p173h.C7897f;
import java.lang.ref.WeakReference;

public class InneractiveAdViewVideoContentController extends C7679q {

    /* renamed from: a */
    WeakReference<C7897f> f15401a;

    public void setControlledRenderer(C7897f fVar) {
        this.f15401a = new WeakReference<>(fVar);
    }

    public void playVideo() {
    }

    public void pauseVideo() {
    }

    public boolean canControl(InneractiveAdSpot inneractiveAdSpot) {
        if (inneractiveAdSpot.getAdContent() instanceof C7678p) {
            return true;
        }
        return false;
    }
}
