package p019d.p273h.p285d.p286a;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import org.json.JSONObject;
import p019d.p273h.p285d.C12953a;
import p019d.p273h.p285d.C12976d;

/* renamed from: d.h.d.a.d */
/* compiled from: ISNAdView */
public class C12957d extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebView f39886a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f39887b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12953a f39888c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f39889d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12963i f39890e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f39891f = C12957d.class.getSimpleName();

    /* renamed from: d.h.d.a.d$a */
    /* compiled from: ISNAdView */
    interface C12958a {
        /* renamed from: a */
        void mo41793a(String str);
    }

    public C12957d(Activity activity, String containerIdentifier, C12953a adSize) {
        super(activity);
        this.f39887b = activity;
        this.f39888c = adSize;
        this.f39889d = containerIdentifier;
        this.f39890e = new C12963i();
    }

    public void setControllerDelegate(C12959e delegate) {
        this.f39890e.mo41808a(delegate);
    }

    /* renamed from: a */
    public void mo41798a(JSONObject loadParams) throws Exception {
        try {
            try {
                C12976d.m42322a(this.f39887b).mo41843b(this.f39890e.mo41805a(loadParams, this.f39889d));
            } catch (Exception e) {
                throw new Exception("ISNAdView | Failed to instantiate IronSourceAdsPublisherAgent");
            }
        } catch (Exception e2) {
            throw new Exception("ISNAdView | loadAd | Failed to build load parameters");
        }
    }

    /* renamed from: a */
    public void mo41794a() {
        this.f39887b.runOnUiThread(new C12954a(this));
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        C12963i iVar = this.f39890e;
        if (iVar != null) {
            iVar.mo41810a("isVisible", visibility, isShown());
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int visibility) {
        C12963i iVar = this.f39890e;
        if (iVar != null) {
            iVar.mo41810a("isWindowVisible", visibility, isShown());
        }
    }

    /* renamed from: a */
    public void mo41796a(String url, String failureMethod) {
        this.f39887b.runOnUiThread(new C12955b(this, failureMethod, url));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m42217b(String failureMethod) {
        this.f39886a = new WebView(this.f39887b);
        this.f39886a.getSettings().setJavaScriptEnabled(true);
        this.f39886a.addJavascriptInterface(new C12965k(this), "containerMsgHandler");
        this.f39886a.setWebViewClient(new C12964j(new C12956c(this, failureMethod)));
        this.f39886a.setLayoutParams(new LayoutParams(-1, -1));
        this.f39890e.mo41807a(this.f39886a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41795a(String data) {
        this.f39890e.mo41809a(data);
    }

    /* renamed from: a */
    public void mo41797a(String functionName, JSONObject functionParams, String successMethod, String failureMethod) {
        try {
            if (functionName.equalsIgnoreCase("loadWithUrl")) {
                mo41796a(functionParams.getString("urlForWebView"), failureMethod);
            } else {
                this.f39890e.mo41812a(functionName, functionParams, successMethod, failureMethod);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C12963i iVar = this.f39890e;
            StringBuilder sb = new StringBuilder();
            sb.append("Could not handle message from controller: ");
            sb.append(functionName);
            sb.append(" with params: ");
            sb.append(functionParams.toString());
            iVar.mo41811a(failureMethod, sb.toString());
        }
    }

    public C12953a getAdViewSize() {
        return this.f39888c;
    }
}
