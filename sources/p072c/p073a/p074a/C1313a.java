package p072c.p073a.p074a;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import p019d.p307j.p308a.p309a.C13084a;
import p019d.p307j.p308a.p313e.C13113c.C13114a;

/* renamed from: c.a.a.a */
/* compiled from: OkHttp3Connection */
public class C1313a implements C13084a {

    /* renamed from: a */
    final OkHttpClient f4196a;

    /* renamed from: b */
    private final Builder f4197b;

    /* renamed from: c */
    private Request f4198c;

    /* renamed from: d */
    private Response f4199d;

    /* renamed from: c.a.a.a$a */
    /* compiled from: OkHttp3Connection */
    public static class C1314a implements C13114a {

        /* renamed from: a */
        private OkHttpClient f4200a;

        /* renamed from: b */
        private OkHttpClient.Builder f4201b;

        public C1314a() {
        }

        public C1314a(OkHttpClient.Builder builder) {
            this.f4201b = builder;
        }

        public C13084a create(String url) throws IOException {
            if (this.f4200a == null) {
                synchronized (C1314a.class) {
                    if (this.f4200a == null) {
                        this.f4200a = this.f4201b != null ? this.f4201b.build() : new OkHttpClient();
                        this.f4201b = null;
                    }
                }
            }
            return new C1313a(url, this.f4200a);
        }
    }

    C1313a(Builder builder, OkHttpClient client) {
        this.f4197b = builder;
        this.f4196a = client;
    }

    public C1313a(String url, OkHttpClient client) {
        this(new Builder().url(url), client);
    }

    public void addHeader(String name, String value) {
        this.f4197b.addHeader(name, value);
    }

    /* renamed from: a */
    public boolean mo9293a(String etag, long offset) {
        return false;
    }

    /* renamed from: c */
    public InputStream mo9296c() throws IOException {
        Response response = this.f4199d;
        if (response != null) {
            return response.body().byteStream();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    /* renamed from: b */
    public Map<String, List<String>> mo9295b() {
        if (this.f4198c == null) {
            this.f4198c = this.f4197b.build();
        }
        return this.f4198c.headers().toMultimap();
    }

    /* renamed from: d */
    public Map<String, List<String>> mo9297d() {
        Response response = this.f4199d;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    /* renamed from: a */
    public String mo9291a(String name) {
        Response response = this.f4199d;
        if (response == null) {
            return null;
        }
        return response.header(name);
    }

    public void execute() throws IOException {
        if (this.f4198c == null) {
            this.f4198c = this.f4197b.build();
        }
        this.f4199d = this.f4196a.newCall(this.f4198c).execute();
    }

    /* renamed from: e */
    public int mo9298e() throws IOException {
        Response response = this.f4199d;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    /* renamed from: a */
    public void mo9292a() {
        this.f4198c = null;
        this.f4199d = null;
    }
}
