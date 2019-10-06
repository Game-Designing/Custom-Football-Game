package p024io.fabric.sdk.android.services.network;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: io.fabric.sdk.android.services.network.h */
/* compiled from: NetworkUtils */
public final class C13972h {
    /* renamed from: a */
    public static final SSLSocketFactory m44439a(C13973i provider) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new C13974j(new C13975k(provider.mo19542b(), provider.mo19541a()), provider)}, null);
        return sslContext.getSocketFactory();
    }
}
