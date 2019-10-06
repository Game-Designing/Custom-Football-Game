package p024io.fabric.sdk.android.p348a.p353e;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13839a;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.services.network.C13968d;
import p024io.fabric.sdk.android.services.network.C13971g;
import p024io.fabric.sdk.android.services.network.HttpRequest;
import p024io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException;

/* renamed from: io.fabric.sdk.android.a.e.m */
/* compiled from: DefaultSettingsSpiCall */
class C13899m extends C13839a implements C13913z {
    public C13899m(C0102l kit, String protocolAndHostOverride, String url, C13971g requestFactory) {
        this(kit, protocolAndHostOverride, url, requestFactory, C13968d.GET);
    }

    C13899m(C0102l kit, String protocolAndHostOverride, String url, C13971g requestFactory, C13968d method) {
        super(kit, protocolAndHostOverride, url, requestFactory, method);
    }

    /* renamed from: a */
    public JSONObject mo43309a(C13912y requestData) {
        JSONObject toReturn;
        C13929o e;
        StringBuilder sb;
        String str = "X-REQUEST-ID";
        String str2 = "Settings request ID: ";
        String str3 = "Fabric";
        HttpRequest httpRequest = null;
        try {
            Map<String, String> queryParams = m44186b(requestData);
            httpRequest = mo43220a(queryParams);
            m44184a(httpRequest, requestData);
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Requesting settings from ");
            sb2.append(mo43221b());
            e2.mo43326c(str3, sb2.toString());
            C13929o e3 = C13920f.m44245e();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Settings query params were: ");
            sb3.append(queryParams);
            e3.mo43326c(str3, sb3.toString());
            toReturn = mo43310a(httpRequest);
            if (httpRequest != null) {
                e = C13920f.m44245e();
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(httpRequest.mo43444d(str));
                e.mo43326c(str3, sb.toString());
            }
        } catch (HttpRequestException e4) {
            C13920f.m44245e().mo43325b(str3, "Settings request failed.", e4);
            toReturn = null;
            if (httpRequest != null) {
                e = C13920f.m44245e();
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (httpRequest != null) {
                C13929o e5 = C13920f.m44245e();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str2);
                sb4.append(httpRequest.mo43444d(str));
                e5.mo43326c(str3, sb4.toString());
            }
            throw th;
        }
        return toReturn;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo43310a(HttpRequest httpRequest) {
        int statusCode = httpRequest.mo43452g();
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Settings result was: ");
        sb.append(statusCode);
        String str = "Fabric";
        e.mo43326c(str, sb.toString());
        if (mo43311a(statusCode)) {
            return m44187b(httpRequest.mo43435a());
        }
        C13929o e2 = C13920f.m44245e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to retrieve settings from ");
        sb2.append(mo43221b());
        e2.mo43324b(str, sb2.toString());
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo43311a(int httpStatusCode) {
        return httpStatusCode == 200 || httpStatusCode == 201 || httpStatusCode == 202 || httpStatusCode == 203;
    }

    /* renamed from: b */
    private JSONObject m44187b(String httpRequestBody) {
        try {
            return new JSONObject(httpRequestBody);
        } catch (Exception e) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse settings JSON from ");
            sb.append(mo43221b());
            String str = "Fabric";
            e2.mo43327c(str, sb.toString(), e);
            C13929o e3 = C13920f.m44245e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Settings response ");
            sb2.append(httpRequestBody);
            e3.mo43326c(str, sb2.toString());
            return null;
        }
    }

    /* renamed from: b */
    private Map<String, String> m44186b(C13912y requestData) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("build_version", requestData.f42208h);
        queryParams.put("display_version", requestData.f42207g);
        queryParams.put("source", Integer.toString(requestData.f42209i));
        String str = requestData.f42210j;
        if (str != null) {
            queryParams.put("icon_hash", str);
        }
        String instanceId = requestData.f42206f;
        if (!C13852l.m44046b(instanceId)) {
            queryParams.put("instance", instanceId);
        }
        return queryParams;
    }

    /* renamed from: a */
    private HttpRequest m44184a(HttpRequest request, C13912y requestData) {
        m44185a(request, "X-CRASHLYTICS-API-KEY", requestData.f42201a);
        m44185a(request, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m44185a(request, "X-CRASHLYTICS-API-CLIENT-VERSION", this.f42015f.mo2536w());
        m44185a(request, "Accept", "application/json");
        m44185a(request, "X-CRASHLYTICS-DEVICE-MODEL", requestData.f42202b);
        m44185a(request, "X-CRASHLYTICS-OS-BUILD-VERSION", requestData.f42203c);
        m44185a(request, "X-CRASHLYTICS-OS-DISPLAY-VERSION", requestData.f42204d);
        m44185a(request, "X-CRASHLYTICS-INSTALLATION-ID", requestData.f42205e);
        return request;
    }

    /* renamed from: a */
    private void m44185a(HttpRequest request, String key, String value) {
        if (value != null) {
            request.mo43441c(key, value);
        }
    }
}
