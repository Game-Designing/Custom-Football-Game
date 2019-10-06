package com.smaato.soma.p261j.p262a;

import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p246f.C12252w;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

/* renamed from: com.smaato.soma.j.a.j */
/* compiled from: SmaatoHttpUrlConnection */
public abstract class C12462j extends HttpURLConnection {
    /* renamed from: b */
    public static HttpURLConnection m40990b(String url) throws IOException {
        String getUrl;
        if (!m40991c(url)) {
            try {
                getUrl = m40993e(url);
            } catch (Exception e) {
                getUrl = url;
            }
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(getUrl).openConnection();
            urlConnection.setRequestProperty("User-Agent", C12252w.m40307b().mo39629e());
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            return urlConnection;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("URL is improperly encoded: ");
        sb.append(url);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: e */
    public static String m40993e(String url) throws Exception {
        URI uri;
        if (!m40991c(url)) {
            if (m40992d(url)) {
                uri = m40989a(url);
            } else {
                uri = new URI(url);
            }
            return uri.toURL().toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("URL is improperly encoded: ");
        sb.append(url);
        throw new UnsupportedEncodingException(sb.toString());
    }

    /* renamed from: c */
    static boolean m40991c(String url) {
        try {
            URLDecoder.decode(url, "UTF-8");
            return false;
        } catch (UnsupportedEncodingException e) {
            C12146d.m39965a(new C12147e("SmaatoHttpUrlConnection", "SmaatoHttpUrlConnectionUrl is improperly encoded:", 1, C12143a.DEBUG));
            return true;
        }
    }

    /* renamed from: d */
    static boolean m40992d(String url) {
        try {
            new URI(url);
            return false;
        } catch (URISyntaxException e) {
            return true;
        }
    }

    /* renamed from: a */
    static URI m40989a(String urlString) throws Exception {
        try {
            URL url = new URL(urlString);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            return uri;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("SmaatoHttpUrlConnectionFailed to encode url: ");
            sb.append(urlString);
            C12146d.m39965a(new C12147e("SmaatoHttpUrlConnection", sb.toString(), 1, C12143a.DEBUG));
            throw e;
        }
    }
}
