package com.fyber.inneractive.sdk.external;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.FullScreenRendererProvider;
import com.fyber.inneractive.sdk.config.C7704d;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.C7714l;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.p159a.C7639a;
import com.fyber.inneractive.sdk.p161c.C7670h;
import com.fyber.inneractive.sdk.p161c.C7670h.C7672a;
import com.fyber.inneractive.sdk.p161c.C7673i;
import com.fyber.inneractive.sdk.p161c.C7675m;
import com.fyber.inneractive.sdk.p161c.C7677o;
import com.fyber.inneractive.sdk.p163d.C7718b;
import com.fyber.inneractive.sdk.p163d.C7719c;
import com.fyber.inneractive.sdk.util.C8017o;
import com.fyber.inneractive.sdk.util.IAlog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InneractiveAdViewUnitController extends C7677o<InneractiveAdViewEventsListener> implements FullScreenRendererProvider, C7672a {

    /* renamed from: a */
    Set<InneractiveAdRenderer> f15397a;

    /* renamed from: b */
    boolean f15398b;

    /* renamed from: c */
    private View f15399c;

    /* renamed from: d */
    private int f15400d;
    protected int mAdContentHeight;
    protected int mAdContentWidth;

    public InneractiveAdViewUnitController() {
        this.f15398b = false;
        this.mAdContentWidth = -1;
        this.mAdContentHeight = -1;
        this.f15400d = 0;
        this.f15397a = new HashSet();
    }

    public InneractiveAdViewUnitController(int i) {
        this();
        if (i >= 30) {
            StringBuilder sb = new StringBuilder("InneractiveAdViewUnitController: Overriding remote config refresh interval to: ");
            sb.append(i);
            IAlog.m18021b(sb.toString());
            this.f15400d = i;
            return;
        }
        StringBuilder sb2 = new StringBuilder("InneractiveAdViewUnitController: Overriding remote config refresh interval - value too low. Setting to default: ");
        sb2.append(i);
        sb2.append(" -> 30");
        IAlog.m18021b(sb2.toString());
        this.f15400d = 30;
    }

    public boolean supports(InneractiveAdSpot inneractiveAdSpot) {
        C7712j unitConfig = inneractiveAdSpot.getAdContent().getUnitConfig();
        if (unitConfig.mo24208d() != null) {
            return false;
        }
        C7704d g = unitConfig.mo24211g();
        if (g != null) {
            if (UnitDisplayType.BANNER.equals(g.mo24185a()) || UnitDisplayType.MRECT.equals(g.mo24185a())) {
                return true;
            }
            if (UnitDisplayType.INTERSTITIAL.equals(g.mo24185a())) {
                if (!inneractiveAdSpot.getCurrentProcessedRequest().getAllowFullscreen()) {
                    return true;
                }
                return false;
            }
        }
        C7714l f = unitConfig.mo24210f();
        if (f == null || (!UnitDisplayType.LANDSCAPE.equals(f.mo24221h()) && !UnitDisplayType.SQUARE.equals(f.mo24221h()) && !UnitDisplayType.MRECT.equals(f.mo24221h()))) {
            return false;
        }
        return true;
    }

    public boolean supportsRefresh() {
        return true;
    }

    public C7719c getFullscreenRenderer() {
        C7719c a = C7657b.f15187a.mo24086a((InneractiveAdSpot) C8017o.m18094a((Reference<T>) this.mAdSpot));
        this.f15397a.add(a);
        return a;
    }

    public InneractiveContentController getSelectedContentController() {
        return this.mSelectedContentController;
    }

    public void destroy() {
        this.f15398b = true;
        for (InneractiveAdRenderer destroy : new HashSet(this.f15397a)) {
            destroy.destroy();
        }
        this.f15397a.clear();
        this.f15399c = null;
        super.destroy();
    }

    public void bindView(ViewGroup viewGroup) {
        StringBuilder sb = new StringBuilder();
        sb.append(logPrefix());
        sb.append("PPPP bindView called with parent: ");
        sb.append(viewGroup);
        IAlog.m18021b(sb.toString());
        InneractiveAdSpot adSpot = getAdSpot();
        if (adSpot == null) {
            IAlog.m18023d("InneractiveFullscreenUnitController was not attached to an ad spot");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(logPrefix());
        sb2.append("PPPP bindView spot is ");
        sb2.append(adSpot);
        IAlog.m18021b(sb2.toString());
        for (InneractiveAdRenderer inneractiveAdRenderer : new HashSet(this.f15397a)) {
            if (inneractiveAdRenderer instanceof C7718b) {
                C7718b bVar = (C7718b) inneractiveAdRenderer;
                if (bVar.mo24224a((View) viewGroup)) {
                    bVar.mo24231g_();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(logPrefix());
                    sb3.append("PPPP bindAdToRenderer returning an already attached renderer ");
                    sb3.append(bVar);
                    IAlog.m18021b(sb3.toString());
                    return;
                }
            }
        }
        this.f15399c = viewGroup;
        C7718b a = C7651b.f15183a.mo24078a(adSpot);
        int i = this.f15400d;
        if (i != 0) {
            a.mo24226a_(i);
        }
        if (a != null) {
            a.initialize(adSpot);
            selectContentController();
            a.mo24223a(viewGroup);
            this.f15397a.add(a);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(logPrefix());
            sb4.append("PPPP bindView created renderer ");
            sb4.append(a);
            IAlog.m18021b(sb4.toString());
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(logPrefix());
        sb5.append("Could not find a renderer for the given spot! Did you add the appropriate module to your project?");
        IAlog.m18023d(sb5.toString());
    }

    public void unbindView(View view) {
        if (this.f15399c != view) {
            StringBuilder sb = new StringBuilder();
            sb.append(logPrefix());
            sb.append(" unbindView invoked with incorrect view, was - ");
            sb.append(this.f15399c);
            sb.append(" received - ");
            sb.append(view);
            IAlog.m18023d(sb.toString());
        } else {
            this.f15399c = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(logPrefix());
        sb2.append("PPPP unbindView called with ");
        sb2.append(view);
        IAlog.m18021b(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(logPrefix());
        sb3.append("PPPP spot is ");
        sb3.append(this.mAdSpot);
        IAlog.m18021b(sb3.toString());
        for (InneractiveAdRenderer inneractiveAdRenderer : new HashSet(this.f15397a)) {
            if (inneractiveAdRenderer instanceof C7718b) {
                C7718b bVar = (C7718b) inneractiveAdRenderer;
                if (bVar.mo24224a(view)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(logPrefix());
                    sb4.append("PPPP unbindView unbinding renderer ");
                    sb4.append(inneractiveAdRenderer);
                    IAlog.m18021b(sb4.toString());
                    bVar.mo24232h_();
                    this.f15397a.remove(bVar);
                    return;
                }
            }
        }
    }

    public void refreshAd() {
        IAlog.m18021b("InneractiveFullscreenUnitController refreshAd called");
        InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) C8017o.m18094a((Reference<T>) this.mAdSpot);
        if (inneractiveAdSpot != null && (inneractiveAdSpot instanceof C7675m)) {
            ((C7675m) inneractiveAdSpot).mo24132a(this);
        }
    }

    public void onAdRefreshed(InneractiveAdSpot inneractiveAdSpot) {
        C7718b bVar;
        String str = "AD_REFRESH ";
        Iterator it = new HashSet(this.f15397a).iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            InneractiveAdRenderer inneractiveAdRenderer = (InneractiveAdRenderer) it.next();
            if (inneractiveAdRenderer instanceof C7718b) {
                bVar = (C7718b) inneractiveAdRenderer;
                if (bVar.mo24225a(inneractiveAdSpot.getAdContent())) {
                    break;
                }
            }
        }
        if (bVar != null) {
            bVar.mo24223a((ViewGroup) null);
        } else {
            onAdRefreshFailed(inneractiveAdSpot, InneractiveErrorCode.SDK_INTERNAL_ERROR);
        }
        try {
            if (inneractiveAdSpot instanceof C7670h) {
                String str2 = ((C7670h) inneractiveAdSpot).f15219g.f15197c.f15444c;
                if (C7640a.f15157a.f15150a) {
                    StringBuilder sb = new StringBuilder(str);
                    sb.append(str2);
                    Log.v("IA_CI_LOG", sb.toString());
                    C7639a a = C7640a.f15157a;
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.append(str2);
                    a.mo24033b(sb2.toString());
                }
            }
        } catch (Exception e) {
        }
        IAlog.m18021b("InneractiveFullscreenUnitController onAdRefreshed called");
    }

    public void onAdRefreshFailed(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
        for (InneractiveAdRenderer inneractiveAdRenderer : new HashSet(this.f15397a)) {
            if (inneractiveAdRenderer instanceof C7718b) {
                ((C7718b) inneractiveAdRenderer).mo24230f_();
                return;
            }
        }
    }

    public void unbindFullscreenRenderer(C7719c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(logPrefix());
        sb.append("removing full screen ad renderer ");
        sb.append(cVar);
        IAlog.m18021b(sb.toString());
        Set<InneractiveAdRenderer> set = this.f15397a;
        if (set != null) {
            set.remove(cVar);
        }
        if (!this.f15398b) {
            for (InneractiveAdRenderer inneractiveAdRenderer : new HashSet(this.f15397a)) {
                if (inneractiveAdRenderer instanceof C7718b) {
                    ((C7718b) inneractiveAdRenderer).mo24227d();
                    if (this.mEventsListener != null) {
                        WeakReference<C7673i> weakReference = this.mAdSpot;
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((InneractiveAdViewEventsListener) this.mEventsListener).onAdCollapsed((InneractiveAdSpot) this.mAdSpot.get());
                        }
                    }
                }
            }
        }
    }

    public boolean canRefreshAd() {
        if (!supportsRefresh()) {
            return false;
        }
        for (InneractiveAdRenderer canRefreshAd : this.f15397a) {
            if (!canRefreshAd.canRefreshAd()) {
                return false;
            }
        }
        return true;
    }

    public int getAdContentWidth() {
        for (InneractiveAdRenderer inneractiveAdRenderer : this.f15397a) {
            if (inneractiveAdRenderer instanceof C7718b) {
                int e = ((C7718b) inneractiveAdRenderer).mo24228e();
                if (e > 0) {
                    return e;
                }
            }
        }
        return this.mAdContentWidth;
    }

    public int getAdContentHeight() {
        for (InneractiveAdRenderer inneractiveAdRenderer : this.f15397a) {
            if (inneractiveAdRenderer instanceof C7718b) {
                int f = ((C7718b) inneractiveAdRenderer).mo24229f();
                if (f > 0) {
                    return f;
                }
            }
        }
        return this.mAdContentHeight;
    }
}
