package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.p161c.C7679q;
import com.fyber.inneractive.sdk.util.C8017o;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class InneractiveNativeVideoContentController extends C7679q {

    /* renamed from: a */
    WeakReference<Renderer> f15408a;

    /* renamed from: b */
    private boolean f15409b = true;

    public interface Renderer {
        void pauseVideo();

        void playVideo();
    }

    public void setControlledRenderer(Renderer renderer) {
        this.f15408a = new WeakReference<>(renderer);
    }

    public boolean canControl(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent().isVideoAd();
    }

    public void playVideo() {
        Renderer renderer = (Renderer) C8017o.m18094a((Reference<T>) this.f15408a);
        if (renderer != null) {
            renderer.playVideo();
        }
    }

    public void pauseVideo() {
        if (((Renderer) C8017o.m18094a((Reference<T>) this.f15408a)) != null) {
            ((Renderer) this.f15408a.get()).pauseVideo();
        }
    }
}
