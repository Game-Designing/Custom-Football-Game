package p024io.fabric.sdk.android.services.network;

import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import p024io.fabric.sdk.android.C13917c;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: io.fabric.sdk.android.services.network.c */
/* compiled from: DefaultHttpRequestFactory */
public class C13967c implements C13971g {

    /* renamed from: a */
    private final C13929o f42333a;

    /* renamed from: b */
    private C13973i f42334b;

    /* renamed from: c */
    private SSLSocketFactory f42335c;

    /* renamed from: d */
    private boolean f42336d;

    public C13967c() {
        this(new C13917c());
    }

    public C13967c(C13929o logger) {
        this.f42333a = logger;
    }

    /* renamed from: a */
    public void mo43470a(C13973i pinningInfo) {
        if (this.f42334b != pinningInfo) {
            this.f42334b = pinningInfo;
            m44430c();
        }
    }

    /* renamed from: c */
    private synchronized void m44430c() {
        this.f42336d = false;
        this.f42335c = null;
    }

    /* renamed from: a */
    public HttpRequest mo43469a(C13968d method, String url, Map<String, String> queryParams) {
        HttpRequest httpRequest;
        int i = C13966b.f42332a[method.ordinal()];
        if (i == 1) {
            httpRequest = HttpRequest.m44368a((CharSequence) url, queryParams, true);
        } else if (i == 2) {
            httpRequest = HttpRequest.m44372b((CharSequence) url, queryParams, true);
        } else if (i == 3) {
            httpRequest = HttpRequest.m44377e((CharSequence) url);
        } else if (i == 4) {
            httpRequest = HttpRequest.m44367a((CharSequence) url);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m44428a(url) && this.f42334b != null) {
            SSLSocketFactory sslSocketFactory = m44427a();
            if (sslSocketFactory != null) {
                ((HttpsURLConnection) httpRequest.mo43455j()).setSSLSocketFactory(sslSocketFactory);
            }
        }
        return httpRequest;
    }

    /* renamed from: a */
    private boolean m44428a(String url) {
        return url != null && url.toLowerCase(Locale.US).startsWith("https");
    }

    /* renamed from: a */
    private synchronized SSLSocketFactory m44427a() {
        if (this.f42335c == null && !this.f42336d) {
            this.f42335c = m44429b();
        }
        return this.f42335c;
    }

    /* renamed from: b */
    private synchronized SSLSocketFactory m44429b() {
        SSLSocketFactory sslSocketFactory;
        this.f42336d = true;
        try {
            sslSocketFactory = C13972h.m44439a(this.f42334b);
            this.f42333a.mo43326c("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.f42333a.mo43325b("Fabric", "Exception while validating pinned certs", e);
            return null;
        }
        return sslSocketFactory;
    }
}
