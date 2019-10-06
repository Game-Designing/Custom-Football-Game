package com.moat.analytics.mobile.sma;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.moat.analytics.mobile.sma.p230a.p231a.C11075a;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.sma.b */
abstract class C11079b {

    /* renamed from: a */
    C11095j f33856a;

    /* renamed from: b */
    final String f33857b;

    /* renamed from: c */
    final boolean f33858c;

    /* renamed from: d */
    boolean f33859d;

    /* renamed from: e */
    boolean f33860e;

    /* renamed from: f */
    private WeakReference<View> f33861f;

    /* renamed from: g */
    private WeakReference<WebView> f33862g;

    /* renamed from: h */
    private final C11139z f33863h;

    /* renamed from: i */
    private final boolean f33864i;

    C11079b(View view, boolean z, boolean z2) {
        String str;
        C11111p.m36577a(3, "BaseTracker", (Object) this, "Initializing.");
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(InneractiveMediationDefs.GENDER_MALE);
            sb.append(hashCode());
            str = sb.toString();
        } else {
            str = "";
        }
        this.f33857b = str;
        this.f33861f = new WeakReference<>(view);
        this.f33864i = z;
        this.f33858c = z2;
        this.f33859d = false;
        this.f33860e = false;
        this.f33863h = new C11139z();
    }

    /* renamed from: g */
    private void mo36197g() {
        String str;
        C11075a.m36440a(this.f33862g);
        String str2 = "BaseTracker";
        C11111p.m36577a(3, str2, (Object) this, "Attempting bridge installation.");
        if (this.f33862g.get() != null) {
            if (!this.f33864i && !this.f33858c) {
                this.f33856a = new C11095j((WebView) this.f33862g.get(), C11099a.WEBVIEW);
            }
            boolean z = this.f33856a.f33911a;
            StringBuilder sb = new StringBuilder();
            sb.append("Bridge ");
            sb.append(z ? "" : "not ");
            sb.append("installed.");
            str = sb.toString();
        } else {
            this.f33856a = null;
            str = "Bridge not installed, WebView is null.";
        }
        C11111p.m36577a(3, str2, (Object) this, str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract String mo36181a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36182a(WebView webView) {
        if (webView != null) {
            this.f33862g = new WeakReference<>(webView);
            if (this.f33856a == null) {
                mo36197g();
            }
            C11095j jVar = this.f33856a;
            if (jVar != null && jVar.f33911a) {
                jVar.mo36222a(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36183a(C11095j jVar) {
        this.f33856a = jVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36184b() {
        String str = "BaseTracker";
        C11111p.m36577a(3, str, (Object) this, "Attempting to start impression.");
        if (!this.f33860e) {
            boolean b = this.f33856a.mo36226b(this);
            StringBuilder sb = new StringBuilder();
            sb.append("Impression ");
            sb.append(b ? "" : "not ");
            sb.append("started.");
            C11111p.m36577a(3, str, (Object) this, sb.toString());
            if (!b) {
                return b;
            }
            this.f33859d = true;
            this.f33860e = true;
            return b;
        }
        C11111p.m36577a(3, str, (Object) this, "startTracking failed, tracker already started");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo36181a());
        sb2.append(" already started");
        C11111p.m36579a("[INFO] ", sb2.toString());
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo36185c() {
        String str = "BaseTracker";
        C11111p.m36577a(3, str, (Object) this, "Attempting to stop impression.");
        this.f33859d = false;
        boolean c = this.f33856a.mo36228c(this);
        StringBuilder sb = new StringBuilder();
        sb.append("Impression tracking ");
        sb.append(c ? "" : "not ");
        sb.append("stopped.");
        C11111p.m36577a(3, str, (Object) this, sb.toString());
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
        C11111p.m36577a(3, "BaseTracker", (Object) this, sb.toString());
        this.f33861f = new WeakReference<>(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public View mo36187d() {
        return (View) this.f33861f.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo36188e() {
        if (mo36187d() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo36187d().getClass().getSimpleName());
        sb.append("@");
        sb.append(mo36187d().hashCode());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo36189f() {
        this.f33863h.mo36261a(this.f33857b, mo36187d());
        return this.f33863h.f34010a;
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    public void startTracking() {
        boolean z;
        String str = "BaseTracker";
        try {
            C11111p.m36577a(3, str, (Object) this, "In startTracking method.");
            z = mo36184b();
        } catch (Exception e) {
            C11102m.m36543a(e);
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Attempt to start tracking ad impression was ");
        sb.append(z ? "" : "un");
        sb.append("successful.");
        C11111p.m36577a(3, str, (Object) this, sb.toString());
        String str2 = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo36181a());
        sb2.append(" startTracking ");
        sb2.append(z ? "succeeded" : "failed");
        sb2.append(" for ");
        sb2.append(mo36188e());
        C11111p.m36579a(str2, sb2.toString());
    }

    public void stopTracking() {
        boolean z;
        String str = "BaseTracker";
        try {
            C11111p.m36577a(3, str, (Object) this, "In stopTracking method.");
            z = mo36185c();
        } catch (Exception e) {
            C11102m.m36543a(e);
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Attempt to stop tracking ad impression was ");
        sb.append(z ? "" : "un");
        sb.append("successful.");
        C11111p.m36577a(3, str, (Object) this, sb.toString());
        String str2 = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo36181a());
        sb2.append(" stopTracking ");
        sb2.append(z ? "succeeded" : "failed");
        sb2.append(" for ");
        sb2.append(mo36188e());
        C11111p.m36579a(str2, sb2.toString());
    }
}
