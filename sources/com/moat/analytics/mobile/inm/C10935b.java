package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.moat.analytics.mobile.inm.b */
abstract class C10935b {

    /* renamed from: a */
    C10960m f33421a = null;

    /* renamed from: b */
    WeakReference<WebView> f33422b;

    /* renamed from: c */
    C10953j f33423c;

    /* renamed from: d */
    TrackerListener f33424d;

    /* renamed from: e */
    final String f33425e;

    /* renamed from: f */
    final boolean f33426f;

    /* renamed from: g */
    private WeakReference<View> f33427g;

    /* renamed from: h */
    private final C10999z f33428h;

    /* renamed from: i */
    private final boolean f33429i;

    /* renamed from: j */
    private boolean f33430j;

    /* renamed from: k */
    private boolean f33431k;

    C10935b(View view, boolean z, boolean z2) {
        String str;
        C10969p.m36113a(3, "BaseTracker", (Object) this, "Initializing.");
        if (z) {
            StringBuilder sb = new StringBuilder(InneractiveMediationDefs.GENDER_MALE);
            sb.append(hashCode());
            str = sb.toString();
        } else {
            str = "";
        }
        this.f33425e = str;
        this.f33427g = new WeakReference<>(view);
        this.f33429i = z;
        this.f33426f = z2;
        this.f33430j = false;
        this.f33431k = false;
        this.f33428h = new C10999z();
    }

    /* renamed from: i */
    private void mo35908i() {
        String str;
        String str2 = "BaseTracker";
        C10969p.m36113a(3, str2, (Object) this, "Attempting bridge installation.");
        if (this.f33422b.get() != null) {
            this.f33423c = new C10953j((WebView) this.f33422b.get(), C10957a.WEBVIEW);
            str = "Bridge installed.";
        } else {
            this.f33423c = null;
            str = "Bridge not installed, WebView is null.";
        }
        C10969p.m36113a(3, str2, (Object) this, str);
    }

    /* renamed from: j */
    private void mo35909j() {
        if (this.f33430j) {
            throw new C10960m("Tracker already started");
        }
    }

    /* renamed from: k */
    private void mo35910k() {
        if (this.f33431k) {
            throw new C10960m("Tracker already stopped");
        }
    }

    /* renamed from: l */
    private boolean mo35911l() {
        return this.f33429i || this.f33426f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract String mo35886a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35887a(WebView webView) {
        if (webView != null) {
            this.f33422b = new WeakReference<>(webView);
            if (this.f33423c == null && !mo35911l()) {
                mo35908i();
            }
            C10953j jVar = this.f33423c;
            if (jVar != null) {
                jVar.mo35939a(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35888a(C10953j jVar) {
        this.f33423c = jVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35889a(String str, Exception exc) {
        try {
            C10960m.m36077a(exc);
            String a = C10960m.m36075a(str, exc);
            if (this.f33424d != null) {
                this.f33424d.onTrackingFailedToStart(a);
            }
            C10969p.m36113a(3, "BaseTracker", (Object) this, a);
            StringBuilder sb = new StringBuilder();
            sb.append(mo35886a());
            sb.append(" ");
            sb.append(a);
            C10969p.m36116a("[ERROR] ", sb.toString());
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35890a(List<String> list) {
        if (mo35896f() == null && !this.f33426f) {
            list.add("Tracker's target view is null");
        }
        if (!list.isEmpty()) {
            throw new C10960m(TextUtils.join(" and ", list));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo35891b() {
        String str = "BaseTracker";
        C10969p.m36113a(3, str, (Object) this, "Attempting to start impression.");
        mo35892c();
        mo35894d();
        mo35890a((List<String>) new ArrayList<String>());
        C10953j jVar = this.f33423c;
        if (jVar != null) {
            jVar.mo35943b(this);
            this.f33430j = true;
            C10969p.m36113a(3, str, (Object) this, "Impression started.");
            return;
        }
        C10969p.m36113a(3, str, (Object) this, "Bridge is null, won't start tracking");
        throw new C10960m("Bridge is null");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo35892c() {
        if (this.f33421a != null) {
            StringBuilder sb = new StringBuilder("Tracker initialization failed: ");
            sb.append(this.f33421a.getMessage());
            throw new C10960m(sb.toString());
        }
    }

    public void changeTargetView(View view) {
        StringBuilder sb = new StringBuilder("changing view to ");
        sb.append(C10969p.m36111a(view));
        C10969p.m36113a(3, "BaseTracker", (Object) this, sb.toString());
        this.f33427g = new WeakReference<>(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo35894d() {
        mo35909j();
        mo35910k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo35895e() {
        return this.f33430j && !this.f33431k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public View mo35896f() {
        return (View) this.f33427g.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public String mo35897g() {
        return C10969p.m36111a(mo35896f());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public String mo35898h() {
        this.f33428h.mo35983a(this.f33425e, mo35896f());
        return this.f33428h.f33601a;
    }

    public void removeListener() {
        this.f33424d = null;
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    public void setListener(TrackerListener trackerListener) {
        this.f33424d = trackerListener;
    }

    public void startTracking() {
        String str = "BaseTracker";
        try {
            C10969p.m36113a(3, str, (Object) this, "In startTracking method.");
            mo35891b();
            if (this.f33424d != null) {
                TrackerListener trackerListener = this.f33424d;
                StringBuilder sb = new StringBuilder("Tracking started on ");
                sb.append(mo35897g());
                trackerListener.onTrackingStarted(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder("startTracking succeeded for ");
            sb2.append(mo35897g());
            String sb3 = sb2.toString();
            C10969p.m36113a(3, str, (Object) this, sb3);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(mo35886a());
            sb4.append(" ");
            sb4.append(sb3);
            C10969p.m36116a("[SUCCESS] ", sb4.toString());
        } catch (Exception e) {
            mo35889a("startTracking", e);
        }
    }

    public void stopTracking() {
        String str = "BaseTracker";
        boolean z = false;
        try {
            C10969p.m36113a(3, str, (Object) this, "In stopTracking method.");
            this.f33431k = true;
            if (this.f33423c != null) {
                this.f33423c.mo35945c(this);
                z = true;
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
        StringBuilder sb = new StringBuilder("Attempt to stop tracking ad impression was ");
        String str2 = "";
        sb.append(z ? str2 : "un");
        sb.append("successful.");
        C10969p.m36113a(3, str, (Object) this, sb.toString());
        String str3 = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo35886a());
        sb2.append(" stopTracking ");
        sb2.append(z ? "succeeded" : "failed");
        sb2.append(" for ");
        sb2.append(mo35897g());
        C10969p.m36116a(str3, sb2.toString());
        TrackerListener trackerListener = this.f33424d;
        if (trackerListener != null) {
            trackerListener.onTrackingStopped(str2);
            this.f33424d = null;
        }
    }
}
