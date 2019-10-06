package p024io.fabric.sdk.android.p348a.p350b;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.services.network.C13968d;
import p024io.fabric.sdk.android.services.network.C13971g;
import p024io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: io.fabric.sdk.android.a.b.a */
/* compiled from: AbstractSpiCall */
public abstract class C13839a {

    /* renamed from: a */
    private static final Pattern f42010a = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: b */
    private final String f42011b;

    /* renamed from: c */
    private final C13971g f42012c;

    /* renamed from: d */
    private final C13968d f42013d;

    /* renamed from: e */
    private final String f42014e;

    /* renamed from: f */
    protected final C0102l f42015f;

    public C13839a(C0102l kit, String protocolAndHostOverride, String url, C13971g requestFactory, C13968d method) {
        if (url == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (requestFactory != null) {
            this.f42015f = kit;
            this.f42014e = protocolAndHostOverride;
            this.f42011b = m43986a(url);
            this.f42012c = requestFactory;
            this.f42013d = method;
        } else {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo43221b() {
        return this.f42011b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpRequest mo43219a() {
        return mo43220a(Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpRequest mo43220a(Map<String, String> queryParams) {
        HttpRequest httpRequest = this.f42012c.mo43469a(this.f42013d, mo43221b(), queryParams);
        httpRequest.mo43434a(false);
        httpRequest.mo43424a(10000);
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics Android SDK/");
        sb.append(this.f42015f.mo2536w());
        httpRequest.mo43441c("User-Agent", sb.toString());
        httpRequest.mo43441c("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        return httpRequest;
    }

    /* renamed from: a */
    private String m43986a(String url) {
        String toReturn = url;
        if (!C13852l.m44046b(this.f42014e)) {
            return f42010a.matcher(url).replaceFirst(this.f42014e);
        }
        return toReturn;
    }
}
