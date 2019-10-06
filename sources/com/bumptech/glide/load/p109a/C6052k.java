package com.bumptech.glide.load.p109a;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6114l;
import com.bumptech.glide.p107h.C6018c;
import com.bumptech.glide.p107h.C6020e;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.load.a.k */
/* compiled from: HttpUrlFetcher */
public class C6052k implements C6042d<InputStream> {

    /* renamed from: a */
    static final C6054b f10724a = new C6053a();

    /* renamed from: b */
    private final C6114l f10725b;

    /* renamed from: c */
    private final int f10726c;

    /* renamed from: d */
    private final C6054b f10727d;

    /* renamed from: e */
    private HttpURLConnection f10728e;

    /* renamed from: f */
    private InputStream f10729f;

    /* renamed from: g */
    private volatile boolean f10730g;

    /* renamed from: com.bumptech.glide.load.a.k$a */
    /* compiled from: HttpUrlFetcher */
    private static class C6053a implements C6054b {
        C6053a() {
        }

        /* renamed from: a */
        public HttpURLConnection mo18883a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* renamed from: com.bumptech.glide.load.a.k$b */
    /* compiled from: HttpUrlFetcher */
    interface C6054b {
        /* renamed from: a */
        HttpURLConnection mo18883a(URL url) throws IOException;
    }

    public C6052k(C6114l glideUrl, int timeout) {
        this(glideUrl, timeout, f10724a);
    }

    C6052k(C6114l glideUrl, int timeout, C6054b connectionFactory) {
        this.f10725b = glideUrl;
        this.f10726c = timeout;
        this.f10727d = connectionFactory;
    }

    /* renamed from: a */
    public void mo18853a(C6001h priority, C6043a<? super InputStream> callback) {
        StringBuilder sb;
        String str = "Finished http url fetcher fetch in ";
        String str2 = "HttpUrlFetcher";
        long startTime = C6020e.m11250a();
        try {
            callback.mo18868a(m11372a(this.f10725b.mo18932c(), 0, null, this.f10725b.mo18931b()));
            if (Log.isLoggable(str2, 2)) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(C6020e.m11249a(startTime));
                Log.v(str2, sb.toString());
            }
        } catch (IOException e) {
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Failed to load data for url", e);
            }
            callback.mo18867a((Exception) e);
            if (Log.isLoggable(str2, 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable(str2, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(C6020e.m11249a(startTime));
                Log.v(str2, sb2.toString());
            }
            throw th;
        }
    }

    /* renamed from: a */
    private InputStream m11372a(URL url, int redirects, URL lastUrl, Map<String, String> headers) throws IOException {
        if (redirects < 5) {
            if (lastUrl != null) {
                try {
                    if (url.toURI().equals(lastUrl.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException e) {
                }
            }
            this.f10728e = this.f10727d.mo18883a(url);
            for (Entry<String, String> headerEntry : headers.entrySet()) {
                this.f10728e.addRequestProperty((String) headerEntry.getKey(), (String) headerEntry.getValue());
            }
            this.f10728e.setConnectTimeout(this.f10726c);
            this.f10728e.setReadTimeout(this.f10726c);
            this.f10728e.setUseCaches(false);
            this.f10728e.setDoInput(true);
            this.f10728e.setInstanceFollowRedirects(false);
            this.f10728e.connect();
            this.f10729f = this.f10728e.getInputStream();
            if (this.f10730g) {
                return null;
            }
            int statusCode = this.f10728e.getResponseCode();
            if (m11373a(statusCode)) {
                return m11371a(this.f10728e);
            }
            if (m11374b(statusCode)) {
                String redirectUrlString = this.f10728e.getHeaderField("Location");
                if (!TextUtils.isEmpty(redirectUrlString)) {
                    URL redirectUrl = new URL(url, redirectUrlString);
                    mo18854b();
                    return m11372a(redirectUrl, redirects + 1, url, headers);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (statusCode == -1) {
                throw new HttpException(statusCode);
            } else {
                throw new HttpException(this.f10728e.getResponseMessage(), statusCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    /* renamed from: a */
    private static boolean m11373a(int statusCode) {
        return statusCode / 100 == 2;
    }

    /* renamed from: b */
    private static boolean m11374b(int statusCode) {
        return statusCode / 100 == 3;
    }

    /* renamed from: a */
    private InputStream m11371a(HttpURLConnection urlConnection) throws IOException {
        if (TextUtils.isEmpty(urlConnection.getContentEncoding())) {
            this.f10729f = C6018c.m11244a(urlConnection.getInputStream(), (long) urlConnection.getContentLength());
        } else {
            String str = "HttpUrlFetcher";
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got non empty content encoding: ");
                sb.append(urlConnection.getContentEncoding());
                Log.d(str, sb.toString());
            }
            this.f10729f = urlConnection.getInputStream();
        }
        return this.f10729f;
    }

    /* renamed from: b */
    public void mo18854b() {
        InputStream inputStream = this.f10729f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
        HttpURLConnection httpURLConnection = this.f10728e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f10728e = null;
    }

    public void cancel() {
        this.f10730g = true;
    }

    /* renamed from: a */
    public Class<InputStream> mo18847a() {
        return InputStream.class;
    }

    /* renamed from: c */
    public C6031a mo18855c() {
        return C6031a.REMOTE;
    }
}
