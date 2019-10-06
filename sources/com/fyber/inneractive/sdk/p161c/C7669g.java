package com.fyber.inneractive.sdk.p161c;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.InternalBrowserListener;
import com.fyber.inneractive.sdk.external.InneractiveAdRenderer;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener;
import com.fyber.inneractive.sdk.p161c.C7668f;
import com.fyber.inneractive.sdk.util.C8031u;
import com.fyber.inneractive.sdk.util.C8031u.C8032a;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.c.g */
public abstract class C7669g<AdContent extends C7668f, EventsListener extends EventsListener> implements InternalBrowserListener, InneractiveAdRenderer {

    /* renamed from: a */
    protected InneractiveAdSpot f15208a;

    /* renamed from: b */
    protected AdContent f15209b;

    /* renamed from: c */
    protected EventsListener f15210c;

    /* renamed from: d */
    boolean f15211d = false;

    /* renamed from: e */
    protected boolean f15212e = false;

    public void initialize(InneractiveAdSpot inneractiveAdSpot) {
        this.f15208a = inneractiveAdSpot;
        this.f15209b = inneractiveAdSpot.getAdContent();
        this.f15210c = inneractiveAdSpot.getSelectedUnitController().getEventsListener();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo24124a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            IAlog.m18021b("InneractiveAdRendererImpl: openClickThroughUrl - is empty");
            return false;
        }
        int a = C8031u.m18114a(context, str);
        if (a == C8032a.f16372a) {
            StringBuilder sb = new StringBuilder("InneractiveAdRendererImpl: openClickThroughUrl - failed opening URL ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
            return false;
        }
        mo24123a(a);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24123a(int i) {
        if (i == C8032a.f16374c) {
            IAlog.m18021b("InneractiveAdRendererImpl: handleOpenResult - opened in external application");
            if (this.f15210c != null) {
                mo24129j_();
                mo24227d();
            }
        } else if (i == C8032a.f16373b) {
            IAlog.m18021b("InneractiveAdRendererImpl: handleOpenResult - opened in internal browser");
            this.f15211d = true;
            InneractiveInternalBrowserActivity.setInternalBrowserListener(this);
            if (this.f15210c != null) {
                mo24129j_();
            }
        }
    }

    public void onApplicationInBackground() {
        mo24227d();
    }

    public void onInternalBrowserDismissed() {
        if (this.f15211d) {
            this.f15211d = false;
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
        }
        if (this.f15210c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("Calling external interface onAdWillCloseInternalBrowser");
            IAlog.m18021b(sb.toString());
            this.f15210c.onAdWillCloseInternalBrowser(this.f15208a);
        }
    }

    public void destroy() {
        if (this.f15211d) {
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
            this.f15211d = false;
        }
        this.f15209b = null;
        this.f15210c = null;
        this.f15208a = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i_ */
    public final void mo24127i_() {
        if (!this.f15212e && this.f15210c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("Calling external interface onAdImpression");
            IAlog.m18021b(sb.toString());
            this.f15210c.onAdImpression(this.f15208a);
            this.f15212e = true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j_ */
    public final void mo24129j_() {
        if (this.f15210c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("Calling external interface onAdClicked");
            IAlog.m18021b(sb.toString());
            this.f15210c.onAdClicked(this.f15208a);
        }
    }

    /* renamed from: d */
    private void mo24227d() {
        if (this.f15210c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("Calling external interface onAdWillOpenExternalApp");
            IAlog.m18021b(sb.toString());
            this.f15210c.onAdWillOpenExternalApp(this.f15208a);
        }
    }

    /* renamed from: k_ */
    public boolean mo24130k_() {
        return false;
    }

    public boolean canRefreshAd() {
        return true;
    }
}
