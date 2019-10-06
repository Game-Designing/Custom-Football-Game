package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.moat.analytics.mobile.iro.c */
abstract class C11015c {

    /* renamed from: ʻ */
    private WeakReference<View> f33647;

    /* renamed from: ʼ */
    private final boolean f33648;

    /* renamed from: ʽ */
    private boolean f33649;

    /* renamed from: ˊ */
    TrackerListener f33650;

    /* renamed from: ˊॱ */
    private final C11067y f33651;

    /* renamed from: ˋ */
    C11043o f33652 = null;

    /* renamed from: ˎ */
    final String f33653;

    /* renamed from: ˏ */
    C11019f f33654;

    /* renamed from: ˏॱ */
    private boolean f33655;

    /* renamed from: ॱ */
    WeakReference<WebView> f33656;

    /* renamed from: ᐝ */
    final boolean f33657;

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public abstract String mo36057();

    C11015c(View view, boolean z, boolean z2) {
        String str;
        C11011b.m36234(3, "BaseTracker", this, "Initializing.");
        if (z) {
            StringBuilder sb = new StringBuilder(InneractiveMediationDefs.GENDER_MALE);
            sb.append(hashCode());
            str = sb.toString();
        } else {
            str = "";
        }
        this.f33653 = str;
        this.f33647 = new WeakReference<>(view);
        this.f33648 = z;
        this.f33657 = z2;
        this.f33649 = false;
        this.f33655 = false;
        this.f33651 = new C11067y();
    }

    public void setListener(TrackerListener trackerListener) {
        this.f33650 = trackerListener;
    }

    public void removeListener() {
        this.f33650 = null;
    }

    public void startTracking() {
        String str = "BaseTracker";
        try {
            C11011b.m36234(3, str, this, "In startTracking method.");
            mo36060();
            if (this.f33650 != null) {
                TrackerListener trackerListener = this.f33650;
                StringBuilder sb = new StringBuilder("Tracking started on ");
                sb.append(C11011b.m36236((View) this.f33647.get()));
                trackerListener.onTrackingStarted(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder("startTracking succeeded for ");
            sb2.append(C11011b.m36236((View) this.f33647.get()));
            String sb3 = sb2.toString();
            C11011b.m36234(3, str, this, sb3);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(mo36057());
            sb4.append(" ");
            sb4.append(sb3);
            C11011b.m36232("[SUCCESS] ", sb4.toString());
        } catch (Exception e) {
            mo36063("startTracking", e);
        }
    }

    public void stopTracking() {
        String str = "BaseTracker";
        boolean z = false;
        try {
            C11011b.m36234(3, str, this, "In stopTracking method.");
            this.f33655 = true;
            if (this.f33654 != null) {
                this.f33654.mo36083(this);
                z = true;
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
        StringBuilder sb = new StringBuilder("Attempt to stop tracking ad impression was ");
        String str2 = "";
        sb.append(z ? str2 : "un");
        sb.append("successful.");
        C11011b.m36234(3, str, this, sb.toString());
        String str3 = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo36057());
        sb2.append(" stopTracking ");
        sb2.append(z ? "succeeded" : "failed");
        sb2.append(" for ");
        sb2.append(C11011b.m36236((View) this.f33647.get()));
        C11011b.m36232(str3, sb2.toString());
        TrackerListener trackerListener = this.f33650;
        if (trackerListener != null) {
            trackerListener.onTrackingStopped(str2);
            this.f33650 = null;
        }
    }

    public void changeTargetView(View view) {
        StringBuilder sb = new StringBuilder("changing view to ");
        sb.append(C11011b.m36236(view));
        C11011b.m36234(3, "BaseTracker", this, sb.toString());
        this.f33647 = new WeakReference<>(view);
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ */
    public void mo36060() throws C11043o {
        String str = "BaseTracker";
        C11011b.m36234(3, str, this, "Attempting to start impression.");
        mo36058();
        if (this.f33649) {
            throw new C11043o("Tracker already started");
        } else if (!this.f33655) {
            mo36062(new ArrayList());
            C11019f fVar = this.f33654;
            if (fVar != null) {
                fVar.mo36085(this);
                this.f33649 = true;
                C11011b.m36234(3, str, this, "Impression started.");
                return;
            }
            C11011b.m36234(3, str, this, "Bridge is null, won't start tracking");
            throw new C11043o("Bridge is null");
        } else {
            throw new C11043o("Tracker already stopped");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public final void mo36059(WebView webView) throws C11043o {
        if (webView != null) {
            this.f33656 = new WeakReference<>(webView);
            if (this.f33654 == null) {
                if (!(this.f33648 || this.f33657)) {
                    String str = "BaseTracker";
                    C11011b.m36234(3, str, this, "Attempting bridge installation.");
                    if (this.f33656.get() != null) {
                        this.f33654 = new C11019f((WebView) this.f33656.get(), C11023b.f33697);
                        C11011b.m36234(3, str, this, "Bridge installed.");
                    } else {
                        this.f33654 = null;
                        C11011b.m36234(3, str, this, "Bridge not installed, WebView is null.");
                    }
                }
            }
            C11019f fVar = this.f33654;
            if (fVar != null) {
                fVar.mo36082(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public final void mo36058() throws C11043o {
        if (this.f33652 != null) {
            StringBuilder sb = new StringBuilder("Tracker initialization failed: ");
            sb.append(this.f33652.getMessage());
            throw new C11043o(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public final void mo36061() throws C11043o {
        if (this.f33649) {
            throw new C11043o("Tracker already started");
        } else if (this.f33655) {
            throw new C11043o("Tracker already stopped");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public void mo36062(List<String> list) throws C11043o {
        if (((View) this.f33647.get()) == null && !this.f33657) {
            list.add("Tracker's target view is null");
        }
        if (!list.isEmpty()) {
            throw new C11043o(TextUtils.join(" and ", list));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ */
    public final boolean mo36064() {
        return this.f33649 && !this.f33655;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ʻ */
    public final View mo36054() {
        return (View) this.f33647.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ʽ */
    public final String mo36056() {
        return C11011b.m36236((View) this.f33647.get());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ʼ */
    public final String mo36055() {
        this.f33651.mo36132(this.f33653, (View) this.f33647.get());
        return this.f33651.f33827;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ */
    public final void mo36063(String str, Exception exc) {
        try {
            C11043o.m36351(exc);
            String r3 = C11043o.m36350(str, exc);
            if (this.f33650 != null) {
                this.f33650.onTrackingFailedToStart(r3);
            }
            C11011b.m36234(3, "BaseTracker", this, r3);
            StringBuilder sb = new StringBuilder();
            sb.append(mo36057());
            sb.append(" ");
            sb.append(r3);
            C11011b.m36232("[ERROR] ", sb.toString());
        } catch (Exception e) {
        }
    }
}
