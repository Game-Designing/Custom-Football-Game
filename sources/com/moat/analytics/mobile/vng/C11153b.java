package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.moat.analytics.mobile.vng.p233a.p234a.C11146a;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.vng.b */
abstract class C11153b {

    /* renamed from: a */
    C11169j f34043a;

    /* renamed from: b */
    final String f34044b;

    /* renamed from: c */
    final boolean f34045c;

    /* renamed from: d */
    boolean f34046d;

    /* renamed from: e */
    boolean f34047e;

    /* renamed from: f */
    private WeakReference<View> f34048f;

    /* renamed from: g */
    private WeakReference<WebView> f34049g;

    /* renamed from: h */
    private final C11213z f34050h;

    /* renamed from: i */
    private final boolean f34051i;

    C11153b(View view, boolean z, boolean z2) {
        String str;
        C11185p.m36817a(3, "BaseTracker", (Object) this, "Initializing.");
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(InneractiveMediationDefs.GENDER_MALE);
            sb.append(hashCode());
            str = sb.toString();
        } else {
            str = "";
        }
        this.f34044b = str;
        this.f34048f = new WeakReference<>(view);
        this.f34051i = z;
        this.f34045c = z2;
        this.f34046d = false;
        this.f34047e = false;
        this.f34050h = new C11213z();
    }

    /* renamed from: g */
    private void mo36332g() {
        String str;
        C11146a.m36681a(this.f34049g);
        String str2 = "BaseTracker";
        C11185p.m36817a(3, str2, (Object) this, "Attempting bridge installation.");
        if (this.f34049g.get() != null) {
            if (!this.f34051i && !this.f34045c) {
                this.f34043a = new C11169j((WebView) this.f34049g.get(), C11173a.WEBVIEW);
            }
            boolean z = this.f34043a.f34098a;
            StringBuilder sb = new StringBuilder();
            sb.append("Bridge ");
            sb.append(z ? "" : "not ");
            sb.append("installed.");
            str = sb.toString();
        } else {
            this.f34043a = null;
            str = "Bridge not installed, WebView is null.";
        }
        C11185p.m36817a(3, str2, (Object) this, str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract String mo36311a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36317a(WebView webView) {
        if (webView != null) {
            this.f34049g = new WeakReference<>(webView);
            if (this.f34043a == null) {
                mo36332g();
            }
            C11169j jVar = this.f34043a;
            if (jVar != null && jVar.f34098a) {
                jVar.mo36354a(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36318a(C11169j jVar) {
        this.f34043a = jVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36319b() {
        String str = "BaseTracker";
        C11185p.m36817a(3, str, (Object) this, "Attempting to start impression.");
        if (!this.f34047e) {
            boolean b = this.f34043a.mo36358b(this);
            StringBuilder sb = new StringBuilder();
            sb.append("Impression ");
            sb.append(b ? "" : "not ");
            sb.append("started.");
            C11185p.m36817a(3, str, (Object) this, sb.toString());
            if (!b) {
                return b;
            }
            this.f34046d = true;
            this.f34047e = true;
            return b;
        }
        C11185p.m36817a(3, str, (Object) this, "startTracking failed, tracker already started");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo36311a());
        sb2.append(" already started");
        C11185p.m36819a("[INFO] ", sb2.toString());
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo36320c() {
        String str = "BaseTracker";
        C11185p.m36817a(3, str, (Object) this, "Attempting to stop impression.");
        this.f34046d = false;
        boolean c = this.f34043a.mo36360c(this);
        StringBuilder sb = new StringBuilder();
        sb.append("Impression tracking ");
        sb.append(c ? "" : "not ");
        sb.append("stopped.");
        C11185p.m36817a(3, str, (Object) this, sb.toString());
        return c;
    }

    public void changeTargetView(View view) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("changing view to ");
        if (view != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(view.getClass().getSimpleName());
            sb2.append("@");
            sb2.append(view.hashCode());
            str = sb2.toString();
        } else {
            str = "null";
        }
        sb.append(str);
        C11185p.m36817a(3, "BaseTracker", (Object) this, sb.toString());
        this.f34048f = new WeakReference<>(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public View mo36322d() {
        return (View) this.f34048f.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo36323e() {
        if (mo36322d() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo36322d().getClass().getSimpleName());
        sb.append("@");
        sb.append(mo36322d().hashCode());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo36324f() {
        this.f34050h.mo36393a(this.f34044b, mo36322d());
        return this.f34050h.f34197a;
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    public void startTracking() {
        boolean z;
        String str = "BaseTracker";
        try {
            C11185p.m36817a(3, str, (Object) this, "In startTracking method.");
            z = mo36319b();
        } catch (Exception e) {
            C11176m.m36783a(e);
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Attempt to start tracking ad impression was ");
        sb.append(z ? "" : "un");
        sb.append("successful.");
        C11185p.m36817a(3, str, (Object) this, sb.toString());
        String str2 = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo36311a());
        sb2.append(" startTracking ");
        sb2.append(z ? "succeeded" : "failed");
        sb2.append(" for ");
        sb2.append(mo36323e());
        C11185p.m36819a(str2, sb2.toString());
    }

    public void stopTracking() {
        boolean z;
        String str = "BaseTracker";
        try {
            C11185p.m36817a(3, str, (Object) this, "In stopTracking method.");
            z = mo36320c();
        } catch (Exception e) {
            C11176m.m36783a(e);
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Attempt to stop tracking ad impression was ");
        sb.append(z ? "" : "un");
        sb.append("successful.");
        C11185p.m36817a(3, str, (Object) this, sb.toString());
        String str2 = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo36311a());
        sb2.append(" stopTracking ");
        sb2.append(z ? "succeeded" : "failed");
        sb2.append(" for ");
        sb2.append(mo36323e());
        C11185p.m36819a(str2, sb2.toString());
    }
}
