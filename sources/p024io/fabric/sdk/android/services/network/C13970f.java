package p024io.fabric.sdk.android.services.network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import p024io.fabric.sdk.android.services.network.HttpRequest.C13962b;

/* renamed from: io.fabric.sdk.android.services.network.f */
/* compiled from: HttpRequest */
class C13970f implements C13962b {
    C13970f() {
    }

    /* renamed from: a */
    public HttpURLConnection mo43464a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: a */
    public HttpURLConnection mo43465a(URL url, Proxy proxy) throws IOException {
        return (HttpURLConnection) url.openConnection(proxy);
    }
}
