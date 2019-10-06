package com.smaato.soma.p239c.p241b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdType;
import com.smaato.soma.C12042D;
import com.smaato.soma.C12369fa;
import com.smaato.soma.interstitial.C12428r;
import com.smaato.soma.interstitial.InterstitialActivity;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p252i.C12278d;
import com.smaato.soma.p239c.p254k.C12301p;
import com.smaato.soma.p256e.C12330E;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.c.b.s */
/* compiled from: MraidConnector */
public class C12179s {

    /* renamed from: a */
    private C12369fa f38175a;

    /* renamed from: b */
    private C12160a f38176b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WebView f38177c;

    /* renamed from: d */
    private Context f38178d;

    /* renamed from: e */
    private DisplayMetrics f38179e;

    /* renamed from: f */
    private C12182v f38180f = C12182v.LOADING;

    /* renamed from: g */
    private ViewGroup f38181g;

    /* renamed from: h */
    private boolean f38182h;

    /* renamed from: i */
    private C12181u f38183i;

    /* renamed from: j */
    private Integer f38184j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f38185k;

    /* renamed from: l */
    private boolean f38186l;

    /* renamed from: m */
    private C12186z f38187m;

    public C12179s(Context context, C12369fa bannerView, WebView webView) {
        this.f38178d = context;
        this.f38175a = bannerView;
        this.f38177c = webView;
        this.f38179e = context.getResources().getDisplayMetrics();
        this.f38176b = new C12160a(context);
        mo39457l();
        this.f38187m = new C12186z();
        this.f38187m.mo39463a(context, this);
    }

    /* renamed from: a */
    public void mo39431a(Context context) {
        this.f38178d = context;
    }

    /* renamed from: k */
    public void mo39456k() {
        mo39448c(this.f38177c.getVisibility() == 0);
        mo39452g();
        mo39444b(this.f38186l);
    }

    /* renamed from: a */
    public void mo39427a(int width, int height, int offsetX, int offsetY, String closePosition, boolean allowOffscreen) {
        Rect rootViewRect;
        Rect resizeRect;
        if (mo39453h()) {
            int[] location = new int[2];
            this.f38175a.getLocationOnScreen(location);
            C12162b customClosePosition = C12162b.m39999a(closePosition);
            int width2 = C12278d.m40415a().mo39670a(width);
            int height2 = C12278d.m40415a().mo39670a(height);
            int offsetX2 = C12278d.m40415a().mo39670a(offsetX);
            int offsetY2 = C12278d.m40415a().mo39670a(offsetY);
            int left = location[0] + offsetX2;
            int top = location[1] + offsetY2;
            Rect resizeRect2 = new Rect(left, top, left + width2, top + height2);
            Rect rootViewRect2 = C12180t.m40072a((View) m40025p());
            if (!allowOffscreen) {
                rootViewRect = rootViewRect2;
                int[] iArr = location;
                resizeRect = resizeRect2;
                int i = top;
                if (mo39439a(resizeRect2, rootViewRect2, width2, height2, offsetX2, offsetY2)) {
                    mo39432a(rootViewRect, resizeRect);
                } else {
                    return;
                }
            } else {
                rootViewRect = rootViewRect2;
                int i2 = top;
                int[] iArr2 = location;
                resizeRect = resizeRect2;
            }
            int i3 = left;
            if (mo39440a(customClosePosition, resizeRect, rootViewRect, width2, height2, offsetX2, offsetY2)) {
                this.f38176b.setCloseButtonVisibility(false);
                this.f38176b.setCustomClosePosition(customClosePosition);
                mo39428a(width2, height2, resizeRect, rootViewRect);
                m40028s();
                mo39434a(C12182v.RESIZED);
            }
        }
    }

    /* renamed from: a */
    public void mo39436a(boolean useCustomClose) {
        if (this.f38177c != null) {
            C12182v vVar = this.f38180f;
            if (vVar == C12182v.DEFAULT || vVar == C12182v.RESIZED) {
                mo39452g();
                LayoutParams params = new LayoutParams(-1, -1);
                this.f38176b.setCloseButtonVisibility(!useCustomClose);
                if (this.f38180f == C12182v.RESIZED) {
                    mo39424a();
                }
                mo39433a(params);
                mo39434a(C12182v.EXPANDED);
                m40028s();
                if (VERSION.SDK_INT >= 19) {
                    this.f38177c.getSettings().setLoadWithOverviewMode(true);
                    this.f38177c.getSettings().setUseWideViewPort(true);
                    this.f38177c.setInitialScale(1);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo39437a(boolean allowOrientationChange, String forceOrientation) {
        this.f38182h = allowOrientationChange;
        this.f38183i = C12181u.m40081a(forceOrientation);
        if (this.f38180f == C12182v.EXPANDED || m40026q()) {
            mo39452g();
        }
    }

    /* renamed from: b */
    public void mo39444b(boolean useCustomClose) {
        this.f38186l = useCustomClose;
        if (m40026q()) {
            Context context = this.f38178d;
            if (context instanceof InterstitialActivity) {
                ((InterstitialActivity) context).mo39905a(!useCustomClose);
                return;
            }
        }
        if (this.f38180f == C12182v.EXPANDED) {
            this.f38176b.setCloseButtonVisibility(!useCustomClose);
        }
    }

    /* renamed from: j */
    public void mo39455j() {
        if (this.f38180f == C12182v.EXPANDED || m40026q()) {
            mo39429a(mo39450e());
        }
        C12182v vVar = this.f38180f;
        if (vVar == C12182v.RESIZED || vVar == C12182v.EXPANDED) {
            mo39424a();
            mo39434a(C12182v.DEFAULT);
            m40029t();
        } else if (vVar == C12182v.DEFAULT) {
            mo39434a(C12182v.HIDDEN);
            mo39448c(false);
        }
    }

    /* renamed from: a */
    public void mo39434a(C12182v state) {
        C12159F.m39994f();
        C12159F.m39987a(new C12174n(this, state), this.f38175a, this.f38177c);
    }

    /* renamed from: i */
    public void mo39454i() {
        C12159F.m39994f();
        if (m40026q()) {
            m40031v();
            return;
        }
        C12159F.m39987a(new C12175o(this), this.f38175a, this.f38177c);
    }

    /* renamed from: b */
    public void mo39443b(C12182v state) {
        this.f38180f = state;
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.setState(\"");
        sb.append(state.mo39461e());
        sb.append("\");");
        m40021b(sb.toString());
    }

    /* renamed from: a */
    public void mo39425a(float width, float height) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.notifySizeChangeEvent(");
        sb.append(C12180t.m40074a(width, height));
        sb.append(");");
        m40021b(sb.toString());
    }

    /* renamed from: a */
    public void mo39426a(float x, float y, float width, float height) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.setCurrentPosition(");
        sb.append(C12180t.m40074a(x, y, width, height));
        sb.append(");");
        m40021b(sb.toString());
    }

    /* renamed from: b */
    public void mo39442b(float x, float y, float width, float height) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.setDefaultPosition(");
        sb.append(C12180t.m40074a(x, y, width, height));
        sb.append(");");
        m40021b(sb.toString());
    }

    /* renamed from: b */
    public void mo39441b(float width, float height) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.setMaxSize(");
        sb.append(C12180t.m40074a(width, height));
        sb.append(");");
        m40021b(sb.toString());
    }

    /* renamed from: c */
    public void mo39447c(float width, float height) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.setScreenSize(");
        sb.append(C12180t.m40074a(width, height));
        sb.append(");");
        m40021b(sb.toString());
    }

    /* renamed from: c */
    public void mo39448c(boolean isViewable) {
        this.f38185k = isViewable;
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.setIsViewable(");
        sb.append(isViewable);
        sb.append(");");
        m40021b(sb.toString());
    }

    /* renamed from: a */
    public void mo39435a(String message, String action) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.fireErrorEvent(");
        sb.append(JSONObject.quote(message));
        sb.append(", ");
        sb.append(JSONObject.quote(action));
        sb.append(");");
        m40021b(sb.toString());
    }

    /* renamed from: b */
    public boolean mo39445b() {
        C12182v vVar = this.f38180f;
        return (vVar == C12182v.EXPANDED || vVar == C12182v.RESIZED) ? false : true;
    }

    /* renamed from: d */
    public void mo39449d() {
        C12330E.m40539a(this.f38176b);
        mo39429a(mo39450e());
        this.f38187m.mo39462a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo39451f() {
        HashMap<String, Object> initialState = new LinkedHashMap<>();
        initialState.put("state", C12182v.DEFAULT.mo39461e());
        initialState.put("hostSDKVersion", "9.1.5");
        initialState.put("placementType", m40024o());
        return mo39423a(initialState);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo39423a(HashMap<String, Object> hashMap) {
        return String.valueOf(new JSONObject(hashMap));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public void mo39458m() {
        WebView webView = this.f38177c;
        if (webView instanceof C12301p) {
            ((C12301p) webView).setOnVisibilityChangedListener(new C12176p(this));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo39446c() {
        return String.format("{\"tel\":%b, \"sms\":%b, \"inlineVideo\":%b}", new Object[]{Boolean.valueOf(C12180t.m40076a(this.f38178d)), Boolean.valueOf(C12180t.m40079b(this.f38178d)), Boolean.valueOf(true)});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39424a() {
        C12330E.m40539a(this.f38176b);
        C12330E.m40539a(this.f38177c);
        this.f38175a.addView(this.f38177c);
        this.f38175a.setVisibility(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39433a(LayoutParams params) {
        C12330E.m40539a(this.f38177c);
        this.f38175a.setVisibility(4);
        this.f38176b.addView(this.f38177c, new LayoutParams(-1, -1));
        m40025p().addView(this.f38176b, params);
        ViewGroup p = m40025p();
        C12369fa faVar = this.f38175a;
        if (p == faVar) {
            faVar.setVisibility(0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo39453h() {
        C12182v vVar = this.f38180f;
        if (vVar == C12182v.LOADING || vVar == C12182v.HIDDEN || m40026q()) {
            return false;
        }
        if (this.f38180f != C12182v.EXPANDED) {
            return true;
        }
        mo39435a("Resizing from Expanded state is not allowed", "resize");
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo39439a(Rect resizeRect, Rect rootViewRect, int width, int height, int offsetX, int offsetY) {
        if (resizeRect.width() <= rootViewRect.width() && resizeRect.height() <= rootViewRect.height()) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("resizeProperties specified a size (");
        sb.append(width);
        String str = ", ";
        sb.append(str);
        sb.append(height);
        sb.append(") and offset (");
        sb.append(offsetX);
        sb.append(str);
        sb.append(offsetY);
        sb.append(") that doesn't allow the ad to appear within the max allowed size (");
        sb.append(rootViewRect.width());
        sb.append(str);
        sb.append(rootViewRect.height());
        sb.append(")");
        mo39435a(sb.toString(), "resize");
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39432a(Rect rootViewRect, Rect resizeRect) {
        resizeRect.offsetTo(Math.max(rootViewRect.left, Math.min(resizeRect.left, rootViewRect.right - resizeRect.width())), Math.max(rootViewRect.top, Math.min(resizeRect.top, rootViewRect.bottom - resizeRect.height())));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo39440a(C12162b customClosePosition, Rect resizeRect, Rect rootViewRect, int width, int height, int offsetX, int offsetY) {
        Rect closeRect = new Rect();
        this.f38176b.mo39399a(customClosePosition, resizeRect, closeRect);
        String str = "resize";
        String str2 = ") and offset (";
        String str3 = "resizeProperties specified a size (";
        String str4 = ", ";
        if (!rootViewRect.contains(closeRect)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(width);
            sb.append(str4);
            sb.append(height);
            sb.append(str2);
            sb.append(offsetX);
            sb.append(str4);
            sb.append(offsetY);
            sb.append(") that doesn't allow the close region to appear within the max allowed size (");
            sb.append(rootViewRect.width());
            sb.append(str4);
            sb.append(rootViewRect.height());
            sb.append(")");
            mo39435a(sb.toString(), str);
            return false;
        } else if (resizeRect.contains(closeRect)) {
            return true;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(width);
            sb2.append(str4);
            sb2.append(height);
            sb2.append(str2);
            sb2.append(offsetX);
            sb2.append(str4);
            sb2.append(offsetY);
            sb2.append(") that doesn't allow the close region to appear within the resized ad.");
            mo39435a(sb2.toString(), str);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39428a(int width, int height, Rect resizeRect, Rect rootViewRect) {
        LayoutParams params = new LayoutParams(width, height);
        params.leftMargin = resizeRect.left - rootViewRect.left;
        params.topMargin = resizeRect.top - rootViewRect.top;
        C12182v vVar = this.f38180f;
        if (vVar == C12182v.DEFAULT) {
            mo39433a(params);
        } else if (vVar == C12182v.RESIZED) {
            this.f38176b.setLayoutParams(params);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo39452g() {
        if (this.f38183i != null && this.f38185k) {
            Activity activity = mo39450e();
            if (activity == null) {
                mo39435a("Cannot apply mraid orientation properties because the activity passed is null", "setOrientationProperties");
                return;
            }
            C12181u uVar = this.f38183i;
            if (uVar != C12181u.NONE) {
                mo39430a(activity, Integer.valueOf(uVar.mo39460e()));
            } else if (this.f38182h) {
                mo39429a(activity);
            } else {
                mo39430a(activity, Integer.valueOf(C12180t.m40071a(activity)));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39429a(Activity activity) {
        if (activity != null) {
            Integer num = this.f38184j;
            if (num != null) {
                activity.setRequestedOrientation(num.intValue());
                this.f38184j = null;
                this.f38183i = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39430a(Activity activity, Integer orientation) {
        if (mo39438a(orientation.intValue(), activity)) {
            if (this.f38184j == null) {
                this.f38184j = Integer.valueOf(activity.getRequestedOrientation());
            }
            activity.setRequestedOrientation(orientation.intValue());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo39438a(int orientation, Activity activity) {
        boolean z = true;
        if (orientation == -1) {
            return true;
        }
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
            int activityOrientation = activityInfo.screenOrientation;
            if (activityOrientation != -1) {
                if (activityOrientation != orientation) {
                    z = false;
                }
                return z;
            }
            if (!C12180t.m40075a(activityInfo.configChanges, 128) || !C12180t.m40075a(activityInfo.configChanges, (int) Opcodes.ACC_ABSTRACT)) {
                z = false;
            }
            return z;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Activity mo39450e() {
        Context context = this.f38178d;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public void mo39459n() {
        if (!C12159F.m39995g()) {
            C12159F.m39987a(new C12177q(this), this.f38175a, this.f38177c);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo39457l() {
        this.f38176b.setOnCloseCallback(new C12178r(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m40031v() {
        this.f38180f = C12182v.DEFAULT;
        m40019a(mo39451f());
        m40030u();
        if (m40026q()) {
            m40032w();
        } else {
            m40033x();
        }
        m40027r();
        mo39458m();
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m40033x() {
        int[] location = new int[2];
        this.f38177c.getLocationOnScreen(location);
        mo39426a((float) location[0], (float) location[1], (float) this.f38177c.getWidth(), (float) this.f38177c.getHeight());
        int[] location2 = new int[2];
        this.f38175a.getLocationOnScreen(location2);
        mo39442b((float) location2[0], (float) location2[1], (float) this.f38175a.getWidth(), (float) this.f38175a.getHeight());
        DisplayMetrics displayMetrics = this.f38179e;
        mo39447c((float) displayMetrics.widthPixels, (float) displayMetrics.heightPixels);
        mo39441b((float) m40025p().getWidth(), (float) m40025p().getHeight());
        mo39425a((float) this.f38177c.getWidth(), (float) this.f38177c.getHeight());
    }

    /* renamed from: w */
    private void m40032w() {
        DisplayMetrics displayMetrics = this.f38179e;
        mo39426a(0.0f, 0.0f, (float) displayMetrics.widthPixels, (float) displayMetrics.heightPixels);
        DisplayMetrics displayMetrics2 = this.f38179e;
        mo39442b(0.0f, 0.0f, (float) displayMetrics2.widthPixels, (float) displayMetrics2.heightPixels);
        DisplayMetrics displayMetrics3 = this.f38179e;
        mo39447c((float) displayMetrics3.widthPixels, (float) displayMetrics3.heightPixels);
        DisplayMetrics displayMetrics4 = this.f38179e;
        mo39441b((float) displayMetrics4.widthPixels, (float) displayMetrics4.heightPixels);
        DisplayMetrics displayMetrics5 = this.f38179e;
        mo39425a((float) displayMetrics5.widthPixels, (float) displayMetrics5.heightPixels);
    }

    /* renamed from: o */
    private String m40024o() {
        if (m40026q()) {
            return AdType.INTERSTITIAL;
        }
        return "inline";
    }

    /* renamed from: p */
    private ViewGroup m40025p() {
        ViewGroup viewGroup = this.f38181g;
        if (viewGroup != null) {
            return viewGroup;
        }
        View topMostView = C12180t.m40073a(this.f38178d, (View) this.f38175a);
        ViewGroup viewGroup2 = topMostView instanceof ViewGroup ? (ViewGroup) topMostView : this.f38175a;
        this.f38181g = viewGroup2;
        return viewGroup2;
    }

    /* renamed from: r */
    private void m40027r() {
        m40021b("window.mraidbridge.fireReadyEvent()");
    }

    /* renamed from: a */
    private void m40019a(String event) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.fireChangeEvent(");
        sb.append(event);
        sb.append(");");
        m40021b(sb.toString());
    }

    /* renamed from: u */
    private void m40030u() {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.setSupports(");
        sb.append(mo39446c());
        sb.append(");");
        m40021b(sb.toString());
    }

    /* renamed from: b */
    private void m40021b(String javaScript) {
        StringBuilder sb = new StringBuilder();
        sb.append("Injecting ");
        sb.append(javaScript);
        C12146d.m39965a(new C12147e("MraidConnector", sb.toString(), 1, C12143a.DEBUG));
        WebView webView = this.f38177c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("javascript:");
        sb2.append(javaScript);
        webView.loadUrl(sb2.toString());
    }

    /* renamed from: q */
    private boolean m40026q() {
        return this.f38175a instanceof C12428r;
    }

    /* renamed from: s */
    private void m40028s() {
        C12369fa faVar = this.f38175a;
        if (faVar instanceof C12042D) {
            ((C12042D) faVar).mo39228i();
        }
    }

    /* renamed from: t */
    private void m40029t() {
        C12369fa faVar = this.f38175a;
        if (faVar instanceof C12042D) {
            ((C12042D) faVar).mo39234p();
        }
    }
}
