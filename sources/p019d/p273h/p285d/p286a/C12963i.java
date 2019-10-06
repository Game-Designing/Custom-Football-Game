package p019d.p273h.p285d.p286a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d.h.d.a.i */
/* compiled from: ISNAdViewLogic */
class C12963i {

    /* renamed from: a */
    private static Handler f39900a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public JSONObject f39901b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12959e f39902c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C12967m f39903d;

    /* renamed from: e */
    private WebView f39904e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f39905f = C12963i.class.getSimpleName();

    /* renamed from: g */
    private String[] f39906g;

    /* renamed from: h */
    private final String[] f39907h;

    C12963i() {
        String str = "handleGetViewVisibility";
        this.f39906g = new String[]{str};
        this.f39907h = new String[]{"loadWithUrl", "updateAd", "isExternalAdViewInitiated", str, "sendMessage"};
        this.f39903d = new C12967m();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41808a(C12959e delegate) {
        this.f39902c = delegate;
    }

    /* renamed from: d */
    private Handler m42243d() {
        try {
            if (f39900a == null) {
                f39900a = new Handler(Looper.getMainLooper());
            }
        } catch (Exception e) {
            Log.e(this.f39905f, "Error while trying execute method getUIThreadHandler");
            e.printStackTrace();
        }
        return f39900a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41807a(WebView webview) {
        this.f39904e = webview;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41806a() {
        this.f39901b = null;
        this.f39902c = null;
        this.f39903d = null;
        f39900a = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo41805a(JSONObject loadParams, String containerIdentifier) throws Exception {
        try {
            boolean isInReload = m42248e();
            if (this.f39901b == null) {
                this.f39901b = new JSONObject(loadParams.toString());
            }
            this.f39901b.put("externalAdViewId", containerIdentifier);
            this.f39901b.put("isInReload", isInReload);
            return this.f39901b;
        } catch (Exception e) {
            throw new Exception("ISNAdViewLogic | buildDataForLoadingAd | Could not build load parameters");
        }
    }

    /* renamed from: e */
    private boolean m42248e() {
        return this.f39901b != null;
    }

    /* renamed from: a */
    private void m42233a(String message, JSONObject params) {
        C12959e eVar = this.f39902c;
        if (eVar != null) {
            eVar.mo35413a(message, params);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41811a(String failureMethod, String errorMessage) {
        C12959e eVar = this.f39902c;
        if (eVar != null) {
            eVar.mo35412a(failureMethod, errorMessage);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41812a(String functionName, JSONObject functionParams, String successMethod, String failureMethod) {
        Handler d = m42243d();
        C12960f fVar = new C12960f(this, functionName, failureMethod, successMethod, functionParams);
        d.post(fVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m42242c(String command) {
        boolean isCommandFoundInCommandsArray = false;
        int i = 0;
        while (true) {
            String[] strArr = this.f39907h;
            if (i >= strArr.length || isCommandFoundInCommandsArray) {
                return isCommandFoundInCommandsArray;
            }
            if (strArr[i].equalsIgnoreCase(command)) {
                isCommandFoundInCommandsArray = true;
            }
            i++;
        }
        return isCommandFoundInCommandsArray;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41810a(String keyToUpdate, int newVisibilityState, boolean isShownValueToUpdate) {
        this.f39903d.mo41819a(keyToUpdate, newVisibilityState, isShownValueToUpdate);
        if (m42252h(keyToUpdate)) {
            m42249f();
        }
    }

    /* renamed from: h */
    private boolean m42252h(String keyToUpdate) {
        if (VERSION.SDK_INT <= 22) {
            return keyToUpdate.equalsIgnoreCase("isWindowVisible");
        }
        return keyToUpdate.equalsIgnoreCase("isVisible");
    }

    /* renamed from: f */
    private void m42249f() {
        if (this.f39902c != null && this.f39903d != null) {
            m42233a("containerIsVisible", m42239c());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo41813b() {
        if (this.f39902c != null && this.f39903d != null) {
            m42233a("containerWasRemoved", m42239c());
        }
    }

    /* renamed from: c */
    private JSONObject m42239c() {
        return new C12961g(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public JSONObject m42230a(JSONObject config, JSONObject visibilityParams) {
        try {
            JSONObject extendedConfigs = new JSONObject(config.toString());
            extendedConfigs.put("visibilityParams", visibilityParams);
            return extendedConfigs;
        } catch (JSONException e) {
            e.printStackTrace();
            return config;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m42250f(String successMethod) {
        try {
            boolean isExternalAdViewInitiated = (this.f39904e == null || this.f39904e.getUrl() == null) ? false : true;
            JSONObject containerAdViewStatusParams = new JSONObject();
            containerAdViewStatusParams.put("isExternalAdViewInitiated", isExternalAdViewInitiated);
            m42233a(successMethod, containerAdViewStatusParams);
        } catch (Exception e) {
            Log.e(this.f39905f, "Error while trying execute method sendIsExternalAdViewInitiated");
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m42247e(String successMethod) {
        m42233a(successMethod, this.f39903d.mo41818a());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m42232a(String params, String successMethod, String failureMethod) {
        if (this.f39904e == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No external adunit attached to ISNAdView while trying to send message: ");
            sb.append(params);
            String errorMessage = sb.toString();
            Log.e(this.f39905f, errorMessage);
            this.f39902c.mo35412a(failureMethod, errorMessage);
            return;
        }
        try {
            new JSONObject(params);
        } catch (JSONException e) {
            StringBuilder sb2 = new StringBuilder();
            String str = "\"";
            sb2.append(str);
            sb2.append(params);
            sb2.append(str);
            params = sb2.toString();
        }
        m42243d().post(new C12962h(this, m42236b(params)));
    }

    /* renamed from: b */
    private String m42236b(String params) {
        return String.format("window.ssa.onMessageReceived(%1$s)", new Object[]{params});
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m42246d(String command) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:try{");
            sb.append(command);
            sb.append("}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}");
            String url = sb.toString();
            if (VERSION.SDK_INT >= 19) {
                this.f39904e.evaluateJavascript(url, null);
            } else {
                this.f39904e.loadUrl(url);
            }
        } catch (Throwable t) {
            String str = this.f39905f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("injectJavaScriptIntoWebView | Error while trying inject JS into external adunit: ");
            sb2.append(command);
            sb2.append("Android API level: ");
            sb2.append(VERSION.SDK_INT);
            Log.e(str, sb2.toString());
            t.printStackTrace();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41809a(String data) {
        try {
            JSONObject params = new JSONObject(data);
            String method = params.optString("method");
            if (TextUtils.isEmpty(method) || !m42251g(method)) {
                m42233a("containerSendMessage", params);
            } else if (method.equalsIgnoreCase("handleGetViewVisibility")) {
                m42238b(params);
            }
        } catch (JSONException e) {
            String str = this.f39905f;
            StringBuilder sb = new StringBuilder();
            sb.append("ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: ");
            sb.append(data);
            Log.e(str, sb.toString());
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private boolean m42251g(String message) {
        int i = 0;
        while (true) {
            String[] strArr = this.f39906g;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equalsIgnoreCase(message)) {
                return true;
            }
            i++;
        }
    }

    /* renamed from: b */
    private void m42238b(JSONObject params) {
        m42232a(m42229a(params).toString(), (String) null, (String) null);
    }

    /* renamed from: a */
    private JSONObject m42229a(JSONObject params) {
        String str = "id";
        JSONObject visibilityMessage = new JSONObject();
        try {
            visibilityMessage.put(str, params.getString(str));
            visibilityMessage.put("data", this.f39903d.mo41818a());
        } catch (Exception e) {
            String str2 = this.f39905f;
            StringBuilder sb = new StringBuilder();
            sb.append("Error while trying execute method buildVisibilityMessageForAdunit | params: ");
            sb.append(params);
            Log.e(str2, sb.toString());
            e.printStackTrace();
        }
        return visibilityMessage;
    }
}
