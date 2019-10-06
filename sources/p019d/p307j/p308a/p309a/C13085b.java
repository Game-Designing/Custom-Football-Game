package p019d.p307j.p308a.p309a;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import p019d.p307j.p308a.p313e.C13113c.C13114a;

/* renamed from: d.j.a.a.b */
/* compiled from: FileDownloadUrlConnection */
public class C13085b implements C13084a {

    /* renamed from: a */
    protected URLConnection f40069a;

    /* renamed from: d.j.a.a.b$a */
    /* compiled from: FileDownloadUrlConnection */
    public static class C13086a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Proxy f40070a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Integer f40071b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Integer f40072c;
    }

    /* renamed from: d.j.a.a.b$b */
    /* compiled from: FileDownloadUrlConnection */
    public static class C13087b implements C13114a {

        /* renamed from: a */
        private final C13086a f40073a;

        public C13087b() {
            this(null);
        }

        public C13087b(C13086a configuration) {
            this.f40073a = configuration;
        }

        public C13084a create(String originUrl) throws IOException {
            return new C13085b(originUrl, this.f40073a);
        }
    }

    public C13085b(String originUrl, C13086a configuration) throws IOException {
        this(new URL(originUrl), configuration);
    }

    public C13085b(URL url, C13086a configuration) throws IOException {
        if (configuration == null || configuration.f40070a == null) {
            this.f40069a = url.openConnection();
        } else {
            this.f40069a = url.openConnection(configuration.f40070a);
        }
        if (configuration != null) {
            if (configuration.f40071b != null) {
                this.f40069a.setReadTimeout(configuration.f40071b.intValue());
            }
            if (configuration.f40072c != null) {
                this.f40069a.setConnectTimeout(configuration.f40072c.intValue());
            }
        }
    }

    public void addHeader(String name, String value) {
        this.f40069a.addRequestProperty(name, value);
    }

    /* renamed from: a */
    public boolean mo9293a(String etag, long offset) {
        return false;
    }

    /* renamed from: c */
    public InputStream mo9296c() throws IOException {
        return this.f40069a.getInputStream();
    }

    /* renamed from: b */
    public Map<String, List<String>> mo9295b() {
        return this.f40069a.getRequestProperties();
    }

    /* renamed from: d */
    public Map<String, List<String>> mo9297d() {
        return this.f40069a.getHeaderFields();
    }

    /* renamed from: a */
    public String mo9291a(String name) {
        return this.f40069a.getHeaderField(name);
    }

    public void execute() throws IOException {
        this.f40069a.connect();
    }

    /* renamed from: e */
    public int mo9298e() throws IOException {
        URLConnection uRLConnection = this.f40069a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo9292a() {
    }
}
