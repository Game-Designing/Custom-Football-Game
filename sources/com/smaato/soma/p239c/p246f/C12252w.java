package com.smaato.soma.p239c.p246f;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.smaato.soma.C12394h;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p239c.p246f.p247a.C12212a;
import com.smaato.soma.p239c.p246f.p249c.C12220d;
import com.smaato.soma.p239c.p246f.p249c.C12223f;
import com.smaato.soma.p239c.p246f.p249c.C12225h;
import com.smaato.soma.p239c.p246f.p249c.C12227j;
import com.smaato.soma.p239c.p246f.p249c.C12229k;
import com.smaato.soma.p239c.p252i.C12280f;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.smaato.soma.c.f.w */
/* compiled from: RequestsBuilder */
public class C12252w {

    /* renamed from: a */
    private static C12252w f38376a = null;

    /* renamed from: b */
    private static final String f38377b = System.getProperty("http.agent");

    /* renamed from: c */
    private final String f38378c = "HTTP_Connector";

    /* renamed from: d */
    private String f38379d;

    /* renamed from: e */
    private boolean f38380e = true;

    /* renamed from: f */
    private Proxy f38381f;

    /* renamed from: g */
    private String f38382g = "https://sdk-android.ad.smaato.net/oapi/v6/ad?";

    protected C12252w() {
    }

    /* renamed from: b */
    public static C12252w m40307b() {
        if (f38376a == null) {
            f38376a = new C12252w();
        }
        return f38376a;
    }

    /* renamed from: d */
    public String mo39628d() {
        return this.f38382g;
    }

    /* renamed from: a */
    public void mo39624a(String somaEndPoint) {
        this.f38382g = somaEndPoint;
    }

    /* renamed from: a */
    public final void mo39623a(Context context) {
        if (context != null) {
            C12220d.m40201i().mo39551a(context.getApplicationContext());
            C12220d.m40201i().mo39566o();
        }
    }

    /* renamed from: a */
    public URL mo39620a(C12394h adSettings, C12229k userSettings, C12227j locationCollector, View view, String subjectToGdpr, String consentString) {
        C12146d.m39966a((Object) new C12251v(this));
        StringBuffer adRequest = new StringBuffer();
        adRequest.append(mo39628d());
        C12220d deviceDataCollector = C12220d.m40201i();
        boolean isTablet = deviceDataCollector.mo39568q();
        Map<String, String> requestParams = mo39621a();
        requestParams.putAll(new C12223f(adSettings, view, isTablet).mo39570a());
        requestParams.putAll(new C12225h(userSettings).mo39571a());
        requestParams.putAll(deviceDataCollector.mo39562k());
        requestParams.putAll(locationCollector.mo39572a(userSettings.mo39582c(), userSettings.mo39583d()));
        Map<String, String> gdprParams = mo39622a(subjectToGdpr, consentString);
        if (!gdprParams.isEmpty()) {
            requestParams.putAll(gdprParams);
        }
        adRequest.append(m40306a(requestParams));
        try {
            return new URL(adRequest.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo39621a() {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("modifyRM", String.valueOf(true));
        requestParams.put("client", "sdkandroid_9-1-5");
        requestParams.put("apiver", String.valueOf(600));
        requestParams.put("extensions", "moat");
        return requestParams;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Map<String, String> mo39622a(String subjectToGdpr, String consentString) {
        Map<String, String> requestParams = new HashMap<>();
        String str = "gdpr";
        if (!C12280f.m40428a((CharSequence) consentString)) {
            requestParams.put(str, C12212a.CMPGDPREnabled.mo39543e());
            requestParams.put("gdpr_consent", consentString);
        } else if (!C12280f.m40428a((CharSequence) subjectToGdpr) && !C12212a.CMPGDPRUnknown.mo39543e().equalsIgnoreCase(subjectToGdpr)) {
            requestParams.put(str, subjectToGdpr);
        }
        return requestParams;
    }

    /* renamed from: a */
    private static String m40306a(Map<String, String> requestParams) {
        StringBuilder paramString = new StringBuilder(requestParams.size());
        for (Entry<String, String> entry : requestParams.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append(C12280f.m40429b((String) entry.getValue()));
            sb.append("&");
            paramString.append(sb.toString());
        }
        return paramString.substring(0, paramString.length() - 1);
    }

    /* renamed from: e */
    public String mo39629e() {
        return this.f38379d;
    }

    /* renamed from: b */
    public void mo39626b(Context context) {
        if (VERSION.SDK_INT >= 17) {
            this.f38379d = WebSettings.getDefaultUserAgent(context);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f38379d = new WebView(context).getSettings().getUserAgentString();
        } else {
            this.f38379d = f38377b;
        }
    }

    /* renamed from: c */
    public Proxy mo39627c() {
        return this.f38381f;
    }

    /* renamed from: a */
    public void mo39625a(boolean isPortrait) {
        this.f38380e = isPortrait;
    }
}
