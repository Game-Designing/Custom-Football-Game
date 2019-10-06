package p024io.fabric.sdk.android.p348a.p353e;

import android.content.res.Resources.NotFoundException;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13928n;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13836D;
import p024io.fabric.sdk.android.p348a.p350b.C13839a;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.services.network.C13968d;
import p024io.fabric.sdk.android.services.network.C13971g;
import p024io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: io.fabric.sdk.android.a.e.a */
/* compiled from: AbstractAppSpiCall */
abstract class C13887a extends C13839a implements C13892f {
    public C13887a(C0102l kit, String protocolAndHostOverride, String url, C13971g requestFactory, C13968d method) {
        super(kit, protocolAndHostOverride, url, requestFactory, method);
    }

    /* renamed from: a */
    public boolean mo43297a(C13890d requestData) {
        HttpRequest httpRequest = m44158b(m44157a(mo43219a(), requestData), requestData);
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Sending app info to ");
        sb.append(mo43221b());
        String str = "Fabric";
        e.mo43326c(str, sb.toString());
        if (requestData.f42139j != null) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("App icon hash is ");
            sb2.append(requestData.f42139j.f42164a);
            e2.mo43326c(str, sb2.toString());
            C13929o e3 = C13920f.m44245e();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("App icon size is ");
            sb3.append(requestData.f42139j.f42166c);
            sb3.append("x");
            sb3.append(requestData.f42139j.f42167d);
            e3.mo43326c(str, sb3.toString());
        }
        int statusCode = httpRequest.mo43452g();
        String kind = "POST".equals(httpRequest.mo43456k()) ? "Create" : "Update";
        C13929o e4 = C13920f.m44245e();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(kind);
        sb4.append(" app request ID: ");
        sb4.append(httpRequest.mo43444d("X-REQUEST-ID"));
        e4.mo43326c(str, sb4.toString());
        C13929o e5 = C13920f.m44245e();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Result was ");
        sb5.append(statusCode);
        e5.mo43326c(str, sb5.toString());
        return C13836D.m43981a(statusCode) == 0;
    }

    /* renamed from: a */
    private HttpRequest m44157a(HttpRequest request, C13890d requestData) {
        request.mo43441c("X-CRASHLYTICS-API-KEY", requestData.f42130a);
        request.mo43441c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        request.mo43441c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f42015f.mo2536w());
        return request;
    }

    /* renamed from: b */
    private HttpRequest m44158b(HttpRequest request, C13890d requestData) {
        String str = "Failed to close app icon InputStream.";
        request.mo43448e("app[identifier]", requestData.f42131b);
        request.mo43448e("app[name]", requestData.f42135f);
        request.mo43448e("app[display_version]", requestData.f42132c);
        request.mo43448e("app[build_version]", requestData.f42133d);
        request.mo43426a("app[source]", (Number) Integer.valueOf(requestData.f42136g));
        request.mo43448e("app[minimum_sdk_version]", requestData.f42137h);
        HttpRequest request2 = request.mo43448e("app[built_sdk_version]", requestData.f42138i);
        if (!C13852l.m44046b(requestData.f42134e)) {
            request2.mo43448e("app[instance_identifier]", requestData.f42134e);
        }
        if (requestData.f42139j != null) {
            InputStream is = null;
            try {
                is = this.f42015f.mo3307i().getResources().openRawResource(requestData.f42139j.f42165b);
                request2.mo43448e("app[icon][hash]", requestData.f42139j.f42164a);
                request2.mo43431a("app[icon][data]", "icon.png", "application/octet-stream", is);
                request2.mo43426a("app[icon][width]", (Number) Integer.valueOf(requestData.f42139j.f42166c));
                request2.mo43426a("app[icon][height]", (Number) Integer.valueOf(requestData.f42139j.f42167d));
            } catch (NotFoundException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to find app icon with resource ID: ");
                sb.append(requestData.f42139j.f42165b);
                C13920f.m44245e().mo43325b("Fabric", sb.toString(), e);
            } catch (Throwable th) {
                C13852l.m44036a((Closeable) is, str);
                throw th;
            }
            C13852l.m44036a((Closeable) is, str);
        }
        Collection<C13928n> collection = requestData.f42140k;
        if (collection != null) {
            for (C13928n kit : collection) {
                request2.mo43448e(mo43299b(kit), kit.mo43363c());
                request2.mo43448e(mo43298a(kit), kit.mo43361a());
            }
        }
        return request2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo43299b(C13928n kit) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{kit.mo43362b()});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo43298a(C13928n kit) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{kit.mo43362b()});
    }
}
